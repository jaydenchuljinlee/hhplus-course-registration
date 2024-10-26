package com.hhplus.enrollment

import com.hhplus.enrollment.lecture.domain.LectureService
import com.hhplus.enrollment.lecture.domain.data.LectureCommandData
import com.hhplus.enrollment.lecture.domain.data.LectureQueryData
import com.hhplus.enrollment.lecture.exception.LectureCapacityExceededException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.web.servlet.function.ServerResponse.async
import java.util.*
import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors

@SpringBootTest
class EnrollmentIntegrationTest {
    @Autowired
    private lateinit var lectureService: LectureService

    @DisplayName("동시에 40명이 수강신청해도, 먼저 Lock을 획득한 30명의 사용자만 등록된다.")
    @Test
    fun test() = runBlocking {
        var errorCnt = 0

        val LECTURE_ID = 0L
        val beforeEntity = lectureService.getLecture(LectureQueryData(LECTURE_ID))

        val totalRequests = beforeEntity.capacity + 10 // 강의 수용량보다 10개가 많도록 설정

        // 수강신청한 사용자 ID 리스트 (동기화 리스트로 생성)
        val successfulStudents = Collections.synchronizedList(mutableListOf<Pair<Int, Long>>())
        val failedStudents = Collections.synchronizedList(mutableListOf<Pair<Int, Long>>())

        // 동시 요청을 실행하는 코루틴 생성
        val jobs = (1..totalRequests).map { i ->
            async(Dispatchers.IO) {
                try {
                    // 요청마다 다른 수강생 ID를 사용하여 LectureCommandData 생성
                    val command = LectureCommandData(LECTURE_ID, i.toLong())

                    // 수강 신청
                    lectureService.enroll(command)

                    val pair = Pair(i, System.currentTimeMillis())
                    successfulStudents.add(pair)
                } catch (e: LectureCapacityExceededException) {
                    val pair = Pair(i, System.currentTimeMillis())
                    failedStudents.add(pair)
                    errorCnt++
                }
            }
        }

        // 모든 요청이 완료될 때까지 대기
        jobs.awaitAll()

        val afterEntity = lectureService.getLecture(LectureQueryData(LECTURE_ID))

        assertTrue(afterEntity.capacity == 0) // 원래 수용 인원보다 많은 인원이 요청했기 때문에, 수용량은 0이 되어야 한다.
        assertTrue(errorCnt == totalRequests - beforeEntity.capacity) // 실패한 갯수 = 10 (총 요청 수를 수용량 + 10으로 설정했기 때문)
        assertTrue(successfulStudents.last().second < failedStudents.first().second) // 선착순이 보장되는지 확인
    }
}
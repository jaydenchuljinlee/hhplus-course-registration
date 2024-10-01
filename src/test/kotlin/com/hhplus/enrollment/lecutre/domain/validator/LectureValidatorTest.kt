package com.hhplus.enrollment.lecutre.domain.validator

import com.hhplus.enrollment.lecture.domain.data.LectureCommandData
import com.hhplus.enrollment.lecture.domain.validator.LectureValidator
import com.hhplus.enrollment.lecture.infrastructure.LectureHistoryRepository
import com.hhplus.enrollment.lecutre.domain.stub.StubLectureHistoryRepository
import com.hhplus.enrollment.lecutre.domain.stub.StubTraineeService
import com.hhplus.enrollment.user.domain.TraineeService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LectureValidatorTest {
    private lateinit var sut: LectureValidator

    private lateinit var traineeService: TraineeService
    private lateinit var lectureHistoryRepository: LectureHistoryRepository

    @BeforeEach
    fun before() {
        traineeService = StubTraineeService()
        lectureHistoryRepository = StubLectureHistoryRepository()

        sut = LectureValidator(traineeService, lectureHistoryRepository)
    }

    @DisplayName("수강자 정보가 존재하지 않으면 Exception을 발생시킨다.")
    @Test
    fun exceptionIfTraineeIsNull() {
        val exception = assertThrows(NullPointerException::class.java) {
            val param = LectureCommandData(1, 999)

            sut.validate(param)
        }

        assertEquals("수강자 정보가 존재하지 않습니다.", exception.message)
    }

    @DisplayName("이미 신청한 이력이 있는 수강생은 중복 신청을 할 수 없다.")
    @Test
    fun duplicateApplyingTest() {
        val exception = assertThrows(RuntimeException::class.java) {
            val param = LectureCommandData(1, 1)

            sut.validate(param)
        }

        assertEquals("현재 수강한 이력이 있습니다.", exception.message)
    }
}
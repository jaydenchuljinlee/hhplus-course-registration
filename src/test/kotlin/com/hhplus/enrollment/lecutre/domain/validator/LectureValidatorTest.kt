package com.hhplus.enrollment.lecutre.domain.validator

import com.hhplus.enrollment.lecture.domain.data.LectureCommandData
import com.hhplus.enrollment.lecture.domain.validator.LectureValidator
import com.hhplus.enrollment.lecture.exception.DuplicateEnrollmentException
import com.hhplus.enrollment.lecture.infrastructure.LectureHistoryRepository
import com.hhplus.enrollment.lecutre.domain.fake.FakeLectureHistoryRepository
import com.hhplus.enrollment.lecutre.domain.fake.FakeTraineeService
import com.hhplus.enrollment.user.domain.TraineeService
import com.hhplus.enrollment.user.exception.TraineeNotFoundException
import kotlinx.coroutines.runBlocking
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
        traineeService = FakeTraineeService()
        lectureHistoryRepository = FakeLectureHistoryRepository()

        sut = LectureValidator(traineeService, lectureHistoryRepository)
    }

    @DisplayName("수강자 정보가 존재하지 않으면 Exception을 발생시킨다.")
    @Test
    fun exceptionIfTraineeIsNull() = runBlocking {
        val param = LectureCommandData(1, 5)

        try {
            sut.validate(param)  // `validate`에서 예외 발생을 검증
            throw AssertionError("예외가 발생하지 않았습니다.")
        } catch (e: TraineeNotFoundException) {
            assertEquals("수강자 정보가 존재하지 않습니다.", e.message)
        }
    }

    @DisplayName("이미 신청한 이력이 있는 수강생은 중복 신청을 할 수 없다.")
    @Test
    fun duplicateEnrollmentTest() = runBlocking {
        try {
            val param = LectureCommandData(1, 2)

            sut.validate(param)
        } catch (e: DuplicateEnrollmentException) {
            assertEquals("현재 수강한 이력이 있습니다.", e.message)
        }
    }
}
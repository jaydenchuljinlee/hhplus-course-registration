package com.hhplus.enrollment.lecutre.domain.validator

import com.hhplus.enrollment.lecture.domain.LectureService
import com.hhplus.enrollment.lecture.domain.param.EnrollmentParam
import com.hhplus.enrollment.lecture.domain.validator.EnrollmentValidator
import com.hhplus.enrollment.lecutre.domain.stub.StubLectureService
import com.hhplus.enrollment.lecutre.domain.stub.StubTraineeService
import com.hhplus.enrollment.user.domain.TraineeService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class EnrollmentValidatorTest {
    private lateinit var sut: EnrollmentValidator

    private lateinit var lectureService: LectureService
    private lateinit var traineeService: TraineeService

    @BeforeEach
    fun before() {
        lectureService = StubLectureService()
        traineeService = StubTraineeService()

        sut = EnrollmentValidator(traineeService, lectureService)
    }

    @DisplayName("수강자 정보가 존재하지 않으면 Exception을 발생시킨다.")
    @Test
    fun exceptionIfTraineeIsNull() {
        val exception = assertThrows(NullPointerException::class.java) {
            val param = EnrollmentParam(1, 999)

            sut.validate(param)
        }

        assertEquals("수강자 정보가 존재하지 않습니다.", exception.message)
    }

    @DisplayName("강의 정보가 존재하지 않으면 Exception을 발생시킨다.")
    @Test
    fun exceptionIfLectureIsNull() {
        val exception = assertThrows(NullPointerException::class.java) {
            val param = EnrollmentParam(999, 1)

            sut.validate(param)
        }

        assertEquals("강의 정보가 존재하지 않습니다.", exception.message)
    }
}
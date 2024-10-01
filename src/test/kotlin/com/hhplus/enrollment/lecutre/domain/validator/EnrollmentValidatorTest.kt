package com.hhplus.enrollment.lecutre.domain.validator

import com.hhplus.enrollment.lecture.domain.LectureService
import com.hhplus.enrollment.lecture.domain.data.EnrollmentCommandData
import com.hhplus.enrollment.lecture.domain.validator.EnrollmentValidator
import com.hhplus.enrollment.lecture.infrastructure.EnrollmentHistoryRepository
import com.hhplus.enrollment.lecture.infrastructure.EnrollmentRepository
import com.hhplus.enrollment.lecutre.domain.stub.StubEnrollmentHistoryRepository
import com.hhplus.enrollment.lecutre.domain.stub.StubEnrollmentRepository
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
    private lateinit var  enrollmentRepository: EnrollmentRepository
    private lateinit var  enrollmentHistoryRepository: EnrollmentHistoryRepository

    @BeforeEach
    fun before() {
        lectureService = StubLectureService()
        traineeService = StubTraineeService()
        enrollmentRepository = StubEnrollmentRepository()
        enrollmentHistoryRepository = StubEnrollmentHistoryRepository()

        sut = EnrollmentValidator(traineeService, lectureService, enrollmentRepository, enrollmentHistoryRepository)
    }

    @DisplayName("수강자 정보가 존재하지 않으면 Exception을 발생시킨다.")
    @Test
    fun exceptionIfTraineeIsNull() {
        val exception = assertThrows(NullPointerException::class.java) {
            val param = EnrollmentCommandData(1, 999)

            sut.validate(param)
        }

        assertEquals("수강자 정보가 존재하지 않습니다.", exception.message)
    }

    @DisplayName("강의 정보가 존재하지 않으면 Exception을 발생시킨다.")
    @Test
    fun exceptionIfLectureIsNull() {
        val exception = assertThrows(NullPointerException::class.java) {
            val param = EnrollmentCommandData(999, 1)

            sut.validate(param)
        }

        assertEquals("강의 정보가 존재하지 않습니다.", exception.message)
    }

    @DisplayName("기간이 지난 강의는 신청할 수 없다.")
    @Test
    fun expiredLecturePeriodTest() {
        val exception = assertThrows(RuntimeException::class.java) {
            val param = EnrollmentCommandData(2, 31)

            sut.validate(param)
        }

        // 시간이 같을 때도 테스트할 것
        assertEquals("강의 수강 기간이 아닙니다.", exception.message)
    }

    @DisplayName("강의 수강 인원을 초과하여 신청할 수 없다.")
    @Test
    fun overCapacityTest() {
        val exception = assertThrows(RuntimeException::class.java) {
            val param = EnrollmentCommandData(1, 31)

            sut.validate(param)
        }

        // 수강인원이 내부 변수로 되어잇는 부분을 어떻게 처리할지 고민할 것. 더미 객체가 항상 Validator에 의존하게 된다.
        assertEquals("강의 인원이 초과되었습니다.", exception.message)
    }

    @DisplayName("이미 신청한 이력이 있는 수강생은 중복 신청을 할 수 없다.")
    @Test
    fun duplicateApplyingTest() {
        val exception = assertThrows(RuntimeException::class.java) {
            val param = EnrollmentCommandData(1, 1)

            sut.validate(param)
        }

        assertEquals("현재 수강한 이력이 있습니다.", exception.message)
    }
}
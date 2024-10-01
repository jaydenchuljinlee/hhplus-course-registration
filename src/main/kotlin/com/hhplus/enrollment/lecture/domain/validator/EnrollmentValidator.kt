package com.hhplus.enrollment.lecture.domain.validator

import com.hhplus.enrollment.lecture.domain.LectureService
import com.hhplus.enrollment.lecture.domain.data.EnrollmentCommandData
import com.hhplus.enrollment.lecture.domain.data.LectureData
import com.hhplus.enrollment.lecture.domain.data.LectureQueryData
import com.hhplus.enrollment.lecture.infrastructure.EnrollmentHistoryRepository
import com.hhplus.enrollment.lecture.infrastructure.EnrollmentRepository
import com.hhplus.enrollment.lecture.infrastructure.dto.AppliedEnrollmentHistoryQueryDto
import com.hhplus.enrollment.user.domain.TraineeService
import com.hhplus.enrollment.user.domain.param.TraineeParam
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class EnrollmentValidator(
    private val traineeService: TraineeService,
    private val lectureService: LectureService,
    private val enrollmentRepository: EnrollmentRepository,
    private val enrollmentHistoryRepository: EnrollmentHistoryRepository,
) {
    private val APPLY_CAPACITY = 30

    fun validate(param: EnrollmentCommandData) {
        val trainee = traineeService.getTrainee(TraineeParam.of(param.traineeId))
        val lecture = lectureService.getLecture(LectureQueryData.of(param.lectureId))

        validateAlreadyApplied(param)
        validateLecturePeriod(lecture)
        validateOverCapacity(param)
    }

    fun validateLecturePeriod(lecture: LectureData) {
        val now = LocalDateTime.now()

        require(now.isAfter(lecture.applyStartDt) && now.isBefore(lecture.applyEndDt)) {
            throw RuntimeException("강의 수강 기간이 아닙니다.")
        }
    }

    fun validateOverCapacity(param: EnrollmentCommandData) {
        val currentAppliedCnt = enrollmentRepository.countEnrollmentByLectureId(param.lectureId)
        require(currentAppliedCnt.plus(1) <= APPLY_CAPACITY) {
            throw RuntimeException("강의 인원이 초과되었습니다.")
        }
    }

    fun validateAlreadyApplied(param: EnrollmentCommandData) {
        val historyQuery = AppliedEnrollmentHistoryQueryDto.of(param.traineeId, param.lectureId)
        val appliedHistory = enrollmentHistoryRepository.getAppliedHistory(historyQuery)

        // 신청했다가 다시 해제할 수도 있으니, 최신 신청 이력에서 검사한다.
        require(appliedHistory == null || (appliedHistory != null && !appliedHistory.cancelYn)) {
            throw RuntimeException("현재 수강한 이력이 있습니다.")
        }
    }
}
package com.hhplus.enrollment.lecture.domain.validator

import com.hhplus.enrollment.lecture.domain.data.LectureCommandData
import com.hhplus.enrollment.lecture.infrastructure.LectureHistoryRepository
import com.hhplus.enrollment.lecture.infrastructure.dto.EnrolledLectureHistoryQueryDto
import com.hhplus.enrollment.user.domain.TraineeService
import com.hhplus.enrollment.user.domain.param.TraineeParam
import org.springframework.stereotype.Component

@Component
class LectureValidator(
    private val traineeService: TraineeService,
    private val lectureHistoryRepository: LectureHistoryRepository,
) {

    fun validate(param: LectureCommandData) {
        traineeService.getTrainee(TraineeParam.of(param.traineeId))

        val historyQuery = EnrolledLectureHistoryQueryDto.of(param.traineeId, param.lectureId)
        val appliedHistory = lectureHistoryRepository.getEnrolledHistory(historyQuery)

        // 신청했다가 다시 해제할 수도 있으니, 최신 신청 이력에서 검사한다.
        require(appliedHistory == null || (appliedHistory != null && !appliedHistory.cancelYn)) {
            throw RuntimeException("현재 수강한 이력이 있습니다.")
        }
    }

}
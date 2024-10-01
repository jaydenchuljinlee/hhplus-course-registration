package com.hhplus.enrollment.lecture.domain.validator

import com.hhplus.enrollment.lecture.domain.LectureService
import com.hhplus.enrollment.lecture.domain.data.EnrollmentCommandData
import com.hhplus.enrollment.lecture.domain.data.LectureQueryData
import com.hhplus.enrollment.user.domain.TraineeService
import com.hhplus.enrollment.user.domain.param.TraineeParam
import org.springframework.stereotype.Component

@Component
class EnrollmentValidator(
    private val traineeService: TraineeService,
    private val lectureService: LectureService,
) {
    fun validate(param: EnrollmentCommandData) {
        traineeService.getTrainee(TraineeParam.of(param.traineeId))
        lectureService.getLecture(LectureQueryData.of(param.lectureId))
    }
}
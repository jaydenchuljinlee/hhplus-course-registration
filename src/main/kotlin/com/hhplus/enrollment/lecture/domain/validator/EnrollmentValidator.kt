package com.hhplus.enrollment.lecture.domain.validator

import com.hhplus.enrollment.lecture.domain.LectureService
import com.hhplus.enrollment.lecture.domain.param.EnrollmentParam
import com.hhplus.enrollment.lecture.domain.param.LectureParam
import com.hhplus.enrollment.user.domain.TraineeService
import com.hhplus.enrollment.user.domain.param.TraineeParam
import org.springframework.stereotype.Component

@Component
class EnrollmentValidator(
    private val traineeService: TraineeService,
    private val lectureService: LectureService,
) {
    fun validate(param: EnrollmentParam) {
        traineeService.getTrainee(TraineeParam.of(param.traineeId))
        lectureService.getLecture(LectureParam.of(param.lectureId))
    }
}
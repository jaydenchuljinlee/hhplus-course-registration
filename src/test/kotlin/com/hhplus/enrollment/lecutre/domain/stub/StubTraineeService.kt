package com.hhplus.enrollment.lecutre.domain.stub

import com.hhplus.enrollment.user.domain.TraineeService
import com.hhplus.enrollment.user.domain.param.TraineeParam
import com.hhplus.enrollment.user.domain.result.TraineeResult

class StubTraineeService: TraineeService {
    private var trainees = mapOf(1L to TraineeResult(1,"201311122","이철진", "01089669169", "ironjin92@gmail.com"))

    override fun getTrainee(param: TraineeParam): TraineeResult {
        return trainees[param.traineeId] ?: throw NullPointerException("수강자 정보가 존재하지 않습니다.")
    }
}
package com.hhplus.enrollment.user.domain

import com.hhplus.enrollment.user.domain.param.TraineeParam
import com.hhplus.enrollment.user.domain.result.TraineeResult

interface TraineeService {
    fun getTrainee(param: TraineeParam): TraineeResult
}
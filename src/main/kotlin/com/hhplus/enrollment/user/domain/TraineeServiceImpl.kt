package com.hhplus.enrollment.user.domain

import com.hhplus.enrollment.user.domain.param.TraineeParam
import com.hhplus.enrollment.user.domain.result.TraineeResult
import com.hhplus.enrollment.user.infrastructure.TraineeRepository
import org.springframework.stereotype.Service

@Service
class TraineeServiceImpl(
    private val traineeRepository: TraineeRepository
): TraineeService {
    override fun getTrainee(param: TraineeParam): TraineeResult {
        val result = traineeRepository.getTrainees(param.toQuery())
        return TraineeResult.from(result)
    }
}
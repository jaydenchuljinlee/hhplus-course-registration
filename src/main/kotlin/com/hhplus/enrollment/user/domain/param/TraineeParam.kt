package com.hhplus.enrollment.user.domain.param

import com.hhplus.enrollment.user.infrastructure.query.TraineeQuery

data class TraineeParam(
    var traineeId: Long
) {
    companion object {
        fun of(traineeId: Long): TraineeParam {
            return TraineeParam(traineeId)
        }
    }

    fun toQuery(): TraineeQuery {
        return TraineeQuery(traineeId)
    }
}
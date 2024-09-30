package com.hhplus.enrollment.user.domain.result

import com.hhplus.enrollment.user.infrastructure.projection.TraineeProjection

data class TraineeResult(
    var traineeId: Long,
    var studentNumber: String,
    var name: String,
    var phoneNumber: String,
    var email: String
) {
    companion object {
        fun from(projection: TraineeProjection) = TraineeResult(
            traineeId = projection.traineeId,
            studentNumber = projection.studentNumber,
            name = projection.name,
            phoneNumber = projection.phoneNumber,
            email = projection.email
        )
    }
}
package com.hhplus.enrollment.user.infrastructure.projection

import com.hhplus.enrollment.user.infrastructure.jpa.entity.TraineeTable

data class TraineeProjection(
    var traineeId: Long,
    var studentNumber: String,
    var name: String,
    var phoneNumber: String,
    var email: String
) {
    companion object {
        fun from(table: TraineeTable): TraineeProjection {
            return TraineeProjection(
                traineeId = table.id,
                studentNumber = table.studentNumber,
                name = table.name,
                phoneNumber = table.phoneNumber,
                email = table.email
            )
        }
    }
}
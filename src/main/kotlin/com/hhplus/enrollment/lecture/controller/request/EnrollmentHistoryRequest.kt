package com.hhplus.enrollment.lecture.controller.request

import com.hhplus.enrollment.lecture.application.command.EnrollmentHistoryCommand

data class EnrollmentHistoryRequest(
    var userId: Long
) {
    init {
        require(userId >= 0) { "User ID를 0 이상이어야 합니다." }
    }

    companion object {

    }

    fun toCommand(): EnrollmentHistoryCommand {
        return EnrollmentHistoryCommand(userId)
    }
}
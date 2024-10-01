package com.hhplus.enrollment.lecture.application.info

import com.hhplus.enrollment.lecture.domain.data.LectureHistoryQueryData

data class LectureHistoryCommandInfo(
    var userId: Long,
) {
    fun toData() = LectureHistoryQueryData(userId = userId)
}
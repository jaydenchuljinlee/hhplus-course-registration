package com.hhplus.enrollment.lecture.infrastructure.query

import com.hhplus.enrollment.lecture.infrastructure.jpa.entity.EnrollmentHistoryTable

data class EnrollmentHistoryInsertionQuery(
    var enrollmentId: Long,
    var lectureId: Long,
    var traineeId: Long,
    var acceptYn: Boolean,
    var cancelYn: Boolean
) {
    fun toTable(): EnrollmentHistoryTable {
        return EnrollmentHistoryTable(
            enrollmentId = enrollmentId,
            lectureId = lectureId,
            traineeId = traineeId,
            acceptYn = if (acceptYn) 'Y' else 'N',
            cancelYn = if (cancelYn) 'Y' else 'N'
        )
    }
}
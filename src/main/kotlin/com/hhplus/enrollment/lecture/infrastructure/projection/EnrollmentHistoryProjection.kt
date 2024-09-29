package com.hhplus.enrollment.lecture.infrastructure.projection

import com.hhplus.enrollment.lecture.infrastructure.jpa.entity.EnrollmentHistoryTable

data class EnrollmentHistoryProjection(
    var enrollmentHistoryId: Long,
    var enrollmentId: Long,
    var lectureId: Long,
    var lectureName: String,
    var traineeId: Long,
    var traineeNo: String,
    var acceptYn: Boolean,
    var cancelYn: Boolean
) {
    companion object {
        fun from(enrollmentHistoryTable: EnrollmentHistoryTable): EnrollmentHistoryProjection {
            return EnrollmentHistoryProjection(
                enrollmentHistoryId = enrollmentHistoryTable.id,
                enrollmentId = enrollmentHistoryTable.enrollmentId,
                lectureId = enrollmentHistoryTable.lectureId,
                lectureName = "",
                traineeId = enrollmentHistoryTable.traineeId,
                traineeNo = "",
                acceptYn = enrollmentHistoryTable.acceptYn == 'Y',
                cancelYn = enrollmentHistoryTable.cancelYn == 'Y'
            )
        }
    }
}
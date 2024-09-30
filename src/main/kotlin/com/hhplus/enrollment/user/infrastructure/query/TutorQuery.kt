package com.hhplus.enrollment.user.infrastructure.query

data class TutorQuery(
    var tutorId: Long
) {
    companion object {
        fun of(tutorId: Long): TutorQuery {
            return TutorQuery(tutorId)
        }
    }
}
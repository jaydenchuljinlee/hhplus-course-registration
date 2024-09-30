package com.hhplus.enrollment.user.domain.param

import com.hhplus.enrollment.user.infrastructure.query.TutorQuery

data class TutorParam(
    var tutorId: Long,
) {
    init {
        require(tutorId >= 0) { "Tutor ID는 0 이상이어야 합니다."}
    }

    fun toQuery(): TutorQuery {
        return TutorQuery(tutorId)
    }
}
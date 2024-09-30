package com.hhplus.enrollment.user.infrastructure

import com.hhplus.enrollment.user.infrastructure.jpa.TutorJapRepository
import com.hhplus.enrollment.user.infrastructure.projection.TutorProjection
import com.hhplus.enrollment.user.infrastructure.query.TutorQuery
import org.springframework.stereotype.Component

@Component
class TutorRepositoryImpl(
    private val jpaRepository: TutorJapRepository
): TutorRepository {
    override fun getTutor(query: TutorQuery): TutorProjection {
        val result = jpaRepository.findById(query.tutorId).orElseThrow { NullPointerException("강의자 정보를 찾을 수 없습니다.") }
        return TutorProjection.from(result)
    }
}
package com.hhplus.enrollment.user.infrastructure.projection

import com.hhplus.enrollment.user.infrastructure.TutorRepository
import com.hhplus.enrollment.user.infrastructure.jpa.TutorJapRepository
import org.springframework.stereotype.Repository

@Repository
class TutorRepositoryImpl(
    private val tutorJpaRepository: TutorJapRepository
): TutorRepository {
    override fun getTutor(tutorId: Long): TutorProjection {
        val result = tutorJpaRepository.findById(tutorId).orElseThrow { NullPointerException("강의자 정보를 찾을 수 없습니다.") }
        return TutorProjection.from(result)
    }
}
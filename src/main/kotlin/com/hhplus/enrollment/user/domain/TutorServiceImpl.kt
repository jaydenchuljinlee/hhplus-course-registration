package com.hhplus.enrollment.user.domain

import com.hhplus.enrollment.user.domain.param.TutorParam
import com.hhplus.enrollment.user.domain.result.TutorResult
import com.hhplus.enrollment.user.infrastructure.TutorRepository
import org.springframework.stereotype.Service

@Service
class TutorServiceImpl(
    private val tutorRepository: TutorRepository
): TutorService {
    override fun getLecture(tutorParam: TutorParam): TutorResult {
        val result = tutorRepository.getTutor(tutorParam.toQuery())
    }

}
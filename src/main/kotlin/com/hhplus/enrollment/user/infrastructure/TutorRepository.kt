package com.hhplus.enrollment.user.infrastructure

import com.hhplus.enrollment.user.infrastructure.dto.TutorDto
import com.hhplus.enrollment.user.infrastructure.dto.TutorQueryDto

interface TutorRepository {
    suspend fun getTutor(query: TutorQueryDto): TutorDto
    suspend fun getTutors(queryList: List<TutorQueryDto>): List<TutorDto>
}
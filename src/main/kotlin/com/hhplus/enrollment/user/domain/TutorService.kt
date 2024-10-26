package com.hhplus.enrollment.user.domain

import com.hhplus.enrollment.user.domain.data.TutorQueryData
import com.hhplus.enrollment.user.domain.data.TutorData

interface TutorService {
    suspend fun getTutor(tutorQueryData: TutorQueryData): TutorData
    suspend fun getTutors(paramList: List<TutorQueryData>): List<TutorData>
}
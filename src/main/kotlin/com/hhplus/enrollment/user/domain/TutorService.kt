package com.hhplus.enrollment.user.domain

import com.hhplus.enrollment.user.domain.param.TutorParam
import com.hhplus.enrollment.user.domain.result.TutorResult

interface TutorService {
    fun getTutor(tutorParam: TutorParam): TutorResult
}
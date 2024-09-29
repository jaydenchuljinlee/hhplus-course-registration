package com.hhplus.enrollment.lecture.domain

import com.hhplus.enrollment.lecture.domain.result.LectureResult
import com.hhplus.enrollment.lecture.infrastructure.LectureRepository
import org.springframework.stereotype.Service

@Service
class LectureServiceImpl(
    private val lectureRepository: LectureRepository
): LectureService {
    override fun getLectures(): List<LectureResult> {
        val result = lectureRepository.getLectures()
        return result.map { LectureResult.from(it) }
    }
}
package com.hhplus.enrollment.lecture.domain

import com.hhplus.enrollment.lecture.domain.data.LectureQueryData
import com.hhplus.enrollment.lecture.domain.data.LectureData
import com.hhplus.enrollment.lecture.infrastructure.LectureRepository
import org.springframework.stereotype.Service

@Service
class LectureServiceImpl(
    private val lectureRepository: LectureRepository
): LectureService {
    override fun getLecture(query: LectureQueryData): LectureData {
        val result = lectureRepository.getLecture(query.toDto())
        return LectureData.from(result)
    }

    override fun getLectures(): List<LectureData> {
        val result = lectureRepository.getLectures()
        return result.map { LectureData.from(it) }
    }
}
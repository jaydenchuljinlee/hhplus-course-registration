package com.hhplus.enrollment.lecture.domain

import com.hhplus.enrollment.lecture.domain.param.LectureParam
import com.hhplus.enrollment.lecture.domain.result.LectureResult
import com.hhplus.enrollment.lecture.infrastructure.LectureRepository
import com.hhplus.enrollment.lecture.infrastructure.query.LectureQuery
import org.springframework.stereotype.Service

@Service
class LectureServiceImpl(
    private val lectureRepository: LectureRepository
): LectureService {
    override fun getLecture(param: LectureParam): LectureResult {
        val result = lectureRepository.getLecture(LectureQuery.of(param.lectureId))
        return LectureResult.from(result)
    }

    override fun getLectures(): List<LectureResult> {
        val result = lectureRepository.getLectures()
        return result.map { LectureResult.from(it) }
    }
}
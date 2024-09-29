package com.hhplus.enrollment.lecture.application

import com.hhplus.enrollment.lecture.application.info.LectureInfo
import com.hhplus.enrollment.lecture.domain.LectureService
import org.springframework.stereotype.Service

@Service
class LectureFacadeImpl(
    private val lectureService: LectureService
): LectureFacade {
    override fun getLectures(): List<LectureInfo> {
        val results = lectureService.getLectures()
        return results.map { LectureInfo.from(it) }
    }
}
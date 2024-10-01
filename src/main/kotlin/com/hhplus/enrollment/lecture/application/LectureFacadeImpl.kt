package com.hhplus.enrollment.lecture.application

import com.hhplus.enrollment.lecture.application.info.*
import com.hhplus.enrollment.lecture.domain.LectureService
import org.springframework.stereotype.Service

@Service
class LectureFacadeImpl(
    private val lectureService: LectureService
): LectureFacade {
    override fun enroll(command: LectureCommandInfo): LectureInfo {
        val result = lectureService.enroll(command.toData())
        return LectureInfo.from(result)
    }

    override fun getLectureHistories(command: LectureHistoryCommandInfo): List<LectureHistoryInfo> {
        val results = lectureService.getLectureHistories(command.toData())
        return results.map { LectureHistoryInfo.from(it) }
    }

    override fun getLectures(): List<LectureInfo> {
        val results = lectureService.getLectures()
        return results.map { LectureInfo.from(it) }
    }
}
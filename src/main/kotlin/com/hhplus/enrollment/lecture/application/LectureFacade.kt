package com.hhplus.enrollment.lecture.application

import com.hhplus.enrollment.lecture.application.info.*

interface LectureFacade {
    fun enroll(command: LectureCommandInfo): LectureInfo
    fun getLectureHistories(command: LectureHistoryCommandInfo): List<LectureHistoryInfo>

    fun getLectures(): List<LectureInfo>
}
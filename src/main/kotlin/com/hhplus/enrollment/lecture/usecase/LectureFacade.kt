package com.hhplus.enrollment.lecture.usecase

import com.hhplus.enrollment.lecture.usecase.info.*

interface LectureFacade {
    suspend fun enroll(command: LectureCommandInfo): LectureInfo
    suspend fun getLectureHistories(command: LectureHistoryCommandInfo): List<LectureHistoryInfo>

    suspend fun getGroupedAvailableLectures(): List<LectureDetailInfo>
}
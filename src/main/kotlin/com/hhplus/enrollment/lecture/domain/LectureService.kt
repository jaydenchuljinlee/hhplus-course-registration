package com.hhplus.enrollment.lecture.domain

import com.hhplus.enrollment.lecture.domain.data.*

interface LectureService {
    suspend fun getLecture(query: LectureQueryData): LectureData  // Optional<LectureResult> 로 변경? Optional<Lecture> 로 변경?
    suspend fun getAvailableLectures(): List<LectureData>

    suspend fun enroll(query: LectureCommandData): LectureData
    suspend fun getLectureHistories(query: LectureHistoryQueryData): List<LectureHistoryData>
}
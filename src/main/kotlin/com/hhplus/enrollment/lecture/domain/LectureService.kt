package com.hhplus.enrollment.lecture.domain

import com.hhplus.enrollment.lecture.domain.data.LectureQueryData
import com.hhplus.enrollment.lecture.domain.data.LectureData

interface LectureService {
    fun getLecture(query: LectureQueryData): LectureData  // Optional<LectureResult> 로 변경? Optional<Lecture> 로 변경?
    fun getLectures(): List<LectureData>
}
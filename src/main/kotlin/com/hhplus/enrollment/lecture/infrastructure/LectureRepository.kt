package com.hhplus.enrollment.lecture.infrastructure

import com.hhplus.enrollment.lecture.infrastructure.projection.LectureProjection
import com.hhplus.enrollment.lecture.infrastructure.query.LectureQuery

interface LectureRepository {
    fun getLecture(query: LectureQuery): LectureProjection
    fun getLectures(): List<LectureProjection>
}
package com.hhplus.enrollment.lecture.infrastructure

import com.hhplus.enrollment.lecture.infrastructure.projection.LectureProjection

interface LectureRepository {
    fun getLectures(): List<LectureProjection>
}
package com.hhplus.enrollment.lecture.infrastructure

import com.hhplus.enrollment.lecture.infrastructure.projection.LectureProjection

interface LectureRepository {
    fun getLecture(lectureId: Long): LectureProjection
    fun getLectures(): List<LectureProjection>
}
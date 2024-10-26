package com.hhplus.enrollment.lecture.infrastructure

import com.hhplus.enrollment.lecture.infrastructure.dto.LectureQueryDto
import com.hhplus.enrollment.lecture.infrastructure.jpa.entity.LectureEntity

interface LectureRepository {
    suspend fun getLecture(query: LectureQueryDto): LectureEntity
    suspend fun getAvailableLectures(): List<LectureEntity>

    suspend fun enroll(command: LectureEntity): LectureEntity

}
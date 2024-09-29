package com.hhplus.enrollment.lecture.domain

import com.hhplus.enrollment.lecture.domain.result.LectureResult

interface LectureService {
    fun getLectures(): List<LectureResult>
}
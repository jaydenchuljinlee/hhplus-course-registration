package com.hhplus.enrollment.lecture.domain

import com.hhplus.enrollment.lecture.domain.param.LectureParam
import com.hhplus.enrollment.lecture.domain.result.LectureResult

interface LectureService {
    fun getLecture(param: LectureParam): LectureResult  // Optional<LectureResult> 로 변경? Optional<Lecture> 로 변경?
    fun getLectures(): List<LectureResult>
}
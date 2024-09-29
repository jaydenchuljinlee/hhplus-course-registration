package com.hhplus.enrollment.lecture.application

import com.hhplus.enrollment.lecture.application.info.LectureInfo

interface LectureFacade {
    fun getLectures(): List<LectureInfo>
}
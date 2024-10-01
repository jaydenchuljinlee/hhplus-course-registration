package com.hhplus.enrollment.lecutre.domain.stub

import com.hhplus.enrollment.lecture.domain.LectureService
import com.hhplus.enrollment.lecture.domain.param.LectureParam
import com.hhplus.enrollment.lecture.domain.result.LectureResult
import com.hhplus.enrollment.user.domain.result.TraineeResult

class StubLectureService: LectureService {
    private var lectures = mapOf(1L to LectureResult(1, "토비의 스프링"))

    override fun getLecture(param: LectureParam): LectureResult {
        return lectures[param.lectureId] ?: throw NullPointerException("강의 정보가 존재하지 않습니다.")
    }

    override fun getLectures(): List<LectureResult> {
        return lectures.values.toList()
    }
}
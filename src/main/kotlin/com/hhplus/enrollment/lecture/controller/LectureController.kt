package com.hhplus.enrollment.lecture.controller

import com.hhplus.enrollment.lecture.application.LectureFacade
import com.hhplus.enrollment.lecture.controller.request.LectureHistoryRequest
import com.hhplus.enrollment.lecture.controller.request.LectureRequest
import com.hhplus.enrollment.lecture.controller.response.LectureHistoryResponse
import com.hhplus.enrollment.lecture.controller.response.LectureResponse
import org.springframework.web.bind.annotation.*

@RequestMapping("/lecture")
@RestController
class LectureController(
    private val lectureFacade: LectureFacade,
) {
    @PostMapping("enrollment")
    fun enrollment(
        @RequestBody request: LectureRequest.Command): LectureResponse {
        val result = lectureFacade.enroll(request.toInfo())
        return LectureResponse.from(result)
    }

    @GetMapping("enrollment/histories/{userId}")
    fun getEnrollmentHistories(request: LectureHistoryRequest.Query): List<LectureHistoryResponse> {
        val results = lectureFacade.getLectureHistories(request.toInfo())
        return results.map { LectureHistoryResponse.from(it) }
    }

    @GetMapping("list")
    fun getLectureList(): List<LectureResponse> {
        val results = lectureFacade.getLectures()
        return results.map { LectureResponse.from(it) }
    }
}
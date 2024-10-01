package com.hhplus.enrollment.lecture.controller

import com.hhplus.enrollment.lecture.application.EnrollmentFacade
import com.hhplus.enrollment.lecture.application.LectureFacade
import com.hhplus.enrollment.lecture.controller.request.EnrollmentHistoryRequest
import com.hhplus.enrollment.lecture.controller.request.EnrollmentRequest
import com.hhplus.enrollment.lecture.controller.response.EnrollmentHistoryResponse
import com.hhplus.enrollment.lecture.controller.response.EnrollmentResponse
import com.hhplus.enrollment.lecture.controller.response.LectureResponse
import org.springframework.web.bind.annotation.*

@RequestMapping("/lecture")
@RestController
class LectureController(
    private val enrollmentFacade: EnrollmentFacade,
    private val lectureFacade: LectureFacade,
) {
    @PostMapping("enrollment")
    fun enrollment(
        @RequestBody request: EnrollmentRequest.Command): EnrollmentResponse {
        val result = enrollmentFacade.enroll(request.toInfo())
        return EnrollmentResponse.from(result)
    }

    @GetMapping("enrollment/histories/{userId}")
    fun getEnrollmentHistories(request: EnrollmentHistoryRequest.Query): List<EnrollmentHistoryResponse> {
        val results = enrollmentFacade.getEnrollmentHistories(request.toInfo())
        return results.map { EnrollmentHistoryResponse.from(it) }
    }

    @GetMapping("list")
    fun getLectureList(): List<LectureResponse> {
        val results = lectureFacade.getLectures()
        return results.map { LectureResponse.from(it) }
    }
}
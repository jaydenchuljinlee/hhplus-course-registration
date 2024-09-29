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
    @PostMapping()
    fun enrollment(
        @RequestBody enrollmentRequest: EnrollmentRequest): EnrollmentResponse {
        val result = enrollmentFacade.enroll(enrollmentRequest.toCommand())
        return EnrollmentResponse.from(result)
    }

    @GetMapping("enrollment/histories/{userId}")
    fun getEnrollmentHistories(enrollmentHistoryRequest: EnrollmentHistoryRequest): List<EnrollmentHistoryResponse> {
        val results = enrollmentFacade.getEnrollmentHistories(enrollmentHistoryRequest.toCommand())
        return results.map { EnrollmentHistoryResponse.from(it) }
    }

    @GetMapping("list")
    fun getLectureList(): List<LectureResponse> {
        val result = lectureFacade.getLectures()
        return result.map { LectureResponse.from(it) }
    }
}
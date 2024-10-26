package com.hhplus.enrollment.lecture.controller

import com.hhplus.enrollment.lecture.usecase.LectureFacade
import com.hhplus.enrollment.lecture.controller.request.LectureHistoryRequest
import com.hhplus.enrollment.lecture.controller.request.LectureRequest
import com.hhplus.enrollment.lecture.controller.response.LectureDetailResponse
import com.hhplus.enrollment.lecture.controller.response.LectureDetailResponseMap
import com.hhplus.enrollment.lecture.controller.response.LectureHistoryResponse
import com.hhplus.enrollment.lecture.controller.response.LectureResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.future.future
import org.springframework.web.bind.annotation.*
import java.util.concurrent.CompletableFuture

@RequestMapping("/lecture")
@RestController
class LectureController(
    private val lectureFacade: LectureFacade,
) {
    @PostMapping("enrollment")
    fun enroll(
        @RequestBody command: LectureRequest.Command): CompletableFuture<LectureResponse> {
        return CoroutineScope(Dispatchers.IO).future {
            val result = lectureFacade.enroll(command.toInfo())

            LectureResponse.from(result)
        }
    }

    @GetMapping("enrollment/histories/{traineeId}")
    fun getEnrollmentHistories(@PathVariable traineeId: Long): CompletableFuture<List<LectureHistoryResponse>> {
        return CoroutineScope(Dispatchers.IO).future {
            val query = LectureHistoryRequest.Query(traineeId)
            val results = lectureFacade.getLectureHistories(query.toInfo())
            results.map { LectureHistoryResponse.from(it) }
        }
    }

    @GetMapping("list")
    fun getLectureList(): CompletableFuture<LectureDetailResponseMap> {
        return CoroutineScope(Dispatchers.IO).future {
            val results = lectureFacade.getGroupedAvailableLectures()
            val toDetail = results.map { LectureDetailResponse.from(it) }

            LectureDetailResponseMap.from(toDetail)
        }
    }
}
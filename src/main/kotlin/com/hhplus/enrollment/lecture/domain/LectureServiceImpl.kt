package com.hhplus.enrollment.lecture.domain

import com.hhplus.enrollment.lecture.domain.data.*
import com.hhplus.enrollment.lecture.domain.validator.LectureValidator
import com.hhplus.enrollment.lecture.infrastructure.LectureHistoryRepository
import com.hhplus.enrollment.lecture.infrastructure.LectureRepository
import com.hhplus.enrollment.lecture.infrastructure.dto.LectureHistoryCommandDto
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class LectureServiceImpl(
    private val lectureRepository: LectureRepository,
    private val lectureHistoryRepository: LectureHistoryRepository,
    private val validator: LectureValidator
): LectureService {
    override fun getLecture(query: LectureQueryData): LectureData {
        val result = lectureRepository.getLecture(query.toDto())
        return LectureData.from(result)
    }

    override fun getLectures(): List<LectureData> {
        val result = lectureRepository.getLectures()
        return result.map { LectureData.from(it) }
    }

    @Transactional
    override fun enroll(query: LectureCommandData): LectureData {
        validator.validate(query)

        val lecture = getLecture(LectureQueryData.of(query.lectureId))
        lecture.decrease()

        lectureRepository.enroll(lecture.toDto())

        val historyCommand = LectureHistoryCommandDto.of(query.lectureId, query.traineeId)
        lectureHistoryRepository.insert(historyCommand)
        return lecture
    }

    override fun getLectureHistories(query: LectureHistoryQueryData): List<LectureHistoryData> {
        val result = lectureHistoryRepository.getEnrollmentHistories(query.toDto())
        return result.map { LectureHistoryData.from(it) }
    }
}
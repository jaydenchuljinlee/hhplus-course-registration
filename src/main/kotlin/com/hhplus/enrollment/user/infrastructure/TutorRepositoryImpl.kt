package com.hhplus.enrollment.user.infrastructure

import com.hhplus.enrollment.user.exception.TutorNotFoundException
import com.hhplus.enrollment.user.infrastructure.jpa.TutorJapRepository
import com.hhplus.enrollment.user.infrastructure.dto.TutorDto
import com.hhplus.enrollment.user.infrastructure.dto.TutorQueryDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.stereotype.Component

@Component
class TutorRepositoryImpl(
    private val jpaRepository: TutorJapRepository
): TutorRepository {
    override suspend fun getTutor(query: TutorQueryDto): TutorDto {
        val result = withContext(Dispatchers.IO) {
            jpaRepository.findById(query.tutorId).orElseThrow { TutorNotFoundException() }
        }
        return TutorDto.from(result)
    }

    override suspend fun getTutors(queryList: List<TutorQueryDto>): List<TutorDto> {
        val queryParam = queryList.map { it.tutorId } // 사용자를 조회하는 쿼리의 명세가 바뀔 수도 있기 때문에 객체 형식으로 받아줬습니다.
        val results = withContext(Dispatchers.IO) {
            jpaRepository.findAllById(queryParam)
        }

        return results.map { TutorDto.from(it) }
    }
}
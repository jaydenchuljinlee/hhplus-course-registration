package com.hhplus.enrollment.lecutre.domain.stub

import com.hhplus.enrollment.lecture.infrastructure.EnrollmentRepository
import com.hhplus.enrollment.lecture.infrastructure.dto.EnrollmentCommandDto
import com.hhplus.enrollment.lecture.infrastructure.dto.EnrollmentDto
import com.hhplus.enrollment.lecture.infrastructure.jpa.entity.EnrollmentEntity

class StubEnrollmentRepository: EnrollmentRepository {
    private val table = mutableMapOf<Long, EnrollmentEntity>()

    init {
        table[1] = EnrollmentEntity(1, 1, 1)
        table[2] = EnrollmentEntity(2, 2, 1)
        table[3] = EnrollmentEntity(3, 3, 1)
        table[4] = EnrollmentEntity(4, 4, 1)
        table[5] = EnrollmentEntity(5, 5, 1)
        table[6] = EnrollmentEntity(6, 6, 1)
        table[7] = EnrollmentEntity(7, 7, 1)
        table[8] = EnrollmentEntity(8, 8, 1)
        table[9] = EnrollmentEntity(9, 9, 1)
        table[10] = EnrollmentEntity(10, 10, 1)
        table[11] = EnrollmentEntity(11, 11, 1)
        table[12] = EnrollmentEntity(12, 12, 1)
        table[13] = EnrollmentEntity(13, 13, 1)
        table[14] = EnrollmentEntity(14, 14, 1)
        table[15] = EnrollmentEntity(15, 15, 1)
        table[16] = EnrollmentEntity(16, 16, 1)
        table[17] = EnrollmentEntity(17, 17, 1)
        table[18] = EnrollmentEntity(18, 18, 1)
        table[19] = EnrollmentEntity(19, 19, 1)
        table[20] = EnrollmentEntity(20, 20, 1)
        table[21] = EnrollmentEntity(21, 21, 1)
        table[22] = EnrollmentEntity(22, 22, 1)
        table[23] = EnrollmentEntity(23, 23, 1)
        table[24] = EnrollmentEntity(24, 24, 1)
        table[25] = EnrollmentEntity(25, 25, 1)
        table[26] = EnrollmentEntity(26, 26, 1)
        table[27] = EnrollmentEntity(27, 27, 1)
        table[28] = EnrollmentEntity(28, 28, 1)
        table[29] = EnrollmentEntity(29, 29, 1)
        table[30] = EnrollmentEntity(30, 30, 1)

    }

    override fun enroll(command: EnrollmentCommandDto): EnrollmentDto {
        table[1] = command.toEntity()
        return EnrollmentDto.from(command.toEntity())
    }

    override fun countEnrollmentByLectureId(lectureId: Long): Long {
        val result = table.values.filter { it.lectureId == lectureId }
        return result.count().toLong()
    }
}
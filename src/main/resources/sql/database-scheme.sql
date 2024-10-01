----------------------------------------------------------------
-- 사용자 관련 테이블
----------------------------------------------------------------

-- 강의자 관련 테이블
CREATE TABLE tutor (
    id BIGINT AUTO_INCREMENT PRIMARY KEY, -- 기본 키
    tutor_number VARCHAR(50) UNIQUE NOT NULL, -- 유니크한 튜터번호
    name VARCHAR(100) NOT NULL, -- 이름
    phone_number VARCHAR(20) NOT NULL, -- 연락처
    email VARCHAR(100) NOT NULL, -- 이메일

    -- 베이스 필드
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 생성일
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- 수정일
    active_yn CHAR(1) DEFAULT 'Y' NOT NULL -- 사용 여부 (Y/N)
);

-- 수강자 관련 테이블
CREATE TABLE trainee (
     id BIGINT AUTO_INCREMENT PRIMARY KEY, -- 기본 키
     student_number VARCHAR(50) UNIQUE NOT NULL, -- 유니크한 학생번호
     name VARCHAR(100) NOT NULL, -- 이름
     phone_number VARCHAR(20) NOT NULL, -- 연락처
     email VARCHAR(100) NOT NULL, -- 이메일

    -- 베이스 필드
     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 생성일
     updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- 수정일
     active_yn CHAR(1) DEFAULT 'Y' NOT NULL -- 사용 여부 (Y/N)
);

----------------------------------------------------------------
-- 강의 관련 테이블
----------------------------------------------------------------

-- 강의 관련 테이블
CREATE TABLE lecture (
    id BIGINT AUTO_INCREMENT PRIMARY KEY, -- 기본 키
    lecture_name VARCHAR(200) NOT NULL, -- 강의 이름
    description TEXT, -- 강의 설명
    tutor_id BIGINT, -- 강의자 (외래 키: Tutor 테이블의 id)
    capacity INT DEFAULT 0, -- 수강 인원
    open_yn CHAR(1) DEFAULT 'Y' NOT NULL, -- 개설 여부 (Y/N)
    apply_start_dt TIMESTAMP NOT NULL, -- 신청 시작일,
    apply_end_dt TIMESTAMP NOT NULL, -- 신청 종료일,

    -- 베이스 필드
     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 생성일
     updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- 수정일
     active_yn CHAR(1) DEFAULT 'Y' NOT NULL -- 사용 여부 (Y/N)
);

-- 강의 신청 관련 테이블
CREATE TABLE enrollment (
    id BIGINT AUTO_INCREMENT PRIMARY KEY, -- 기본 키
    trainee_id BIGINT NOT NULL, -- 수강자 (외래 키: Trainee 테이블의 id)
    lecture_id BIGINT NOT NULL, -- 강의 (외래 키: Lecture 테이블의 id)
    accept_yn CHAR(1) DEFAULT 'N' NOT NULL, -- 수락 여부 (Y/N)

    -- 베이스 필드
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 생성일
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- 수정일
    active_yn CHAR(1) DEFAULT 'N' NOT NULL -- 사용 여부 (Y/N)
);

-- 강의 신청 이력 관련 테이블
CREATE TABLE enrollment_history (
    id BIGINT AUTO_INCREMENT PRIMARY KEY, -- 기본 키
    enrollment_id BIGINT NOT NULL, -- 강의 신청 (외래 키: Enrollment 테이블의 id)
    lecture_id BIGINT NOT NULL, -- 강의 (외래 키: Lecture 테이블의 id)
    trainee_id BIGINT NOT NULL, -- 수강자 (외래 키: Trainee 테이블의 trainere_no)
    accept_yn CHAR(1) DEFAULT 'N' NOT NULL, -- 수락 여부 (Y/N)
    cancel_yn CHAR(1) DEFAULT 'N' NOT NULL, -- 취소 여부 (Y/N)

    -- 베이스 필드
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 생성일
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- 수정일
    active_yn CHAR(1) DEFAULT 'Y' NOT NULL -- 사용 여부 (Y/N)
);

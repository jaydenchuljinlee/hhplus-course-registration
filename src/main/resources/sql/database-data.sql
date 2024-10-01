INSERT INTO tutor (tutor_number, name, phone_number, email, created_at, updated_at, active_yn) VALUES
    ('TUTOR001', '토비', '010-1234-5678', 'toby@example.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),
    ('TUTOR002', '엉클밥', '010-9876-5432', 'unclebob@example.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),
    ('TUTOR003', '마크 주커버그', '010-1111-2222', 'zuckerberg@example.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y');

INSERT INTO trainee (student_number, name, phone_number, email, created_at, updated_at, active_yn)
VALUES
    ('STU001', '이철진', '010-3333-4444', 'abc123@example.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),
    ('STU002', '이정기', '010-5555-6666', 'bcd234@example.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),
    ('STU003', '이규명', '010-7777-8888', 'cde345@example.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),
    ('STU004', '윤성민', '010-8888-9999', 'def456@example.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),
    ('STU005', '김현진', '010-9999-0000', 'efg567@example.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y');


INSERT INTO lecture (lecture_name, description, tutor_id, capacity, open_yn, apply_start_dt, apply_end_dt, created_at, updated_at, active_yn)
VALUES
    ('토비의 스프링 마스터 클래스', '스프링 프레임워크의 내부 구조와 원리를 상세히 설명하며, 실전 예제와 함께 스프링의 모든 것을 다룹니다.', 1, 50, 'Y', '2024-10-01T00:00:00', '2024-10-20T00:00:00', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),
    ('클린 코드 작성법', '소프트웨어 공학의 대가, 로버트 C. 마틴(밥 아저씨)이 말하는 클린 코드 작성법과 설계 원칙을 학습하는 강의입니다.', 2, 30, 'Y', '2024-10-01T00:00:00', '2024-10-20T00:00:00', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),
    ('소셜 미디어와 창업', '마크 주커버그의 페이스북 창업 스토리와 함께, 성공적인 스타트업을 만들기 위한 전략과 소셜 미디어의 활용 방안을 다루는 강의입니다.', 3, 100, 'Y', '2024-10-01T00:00:00', '2024-10-20T00:00:00', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y');


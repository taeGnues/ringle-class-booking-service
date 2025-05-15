-- 1. 튜터 테이블
CREATE TABLE tutor (
                       tutor_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(255) NOT NULL,
                       email VARCHAR(255) NOT NULL UNIQUE,
                       subject VARCHAR(255) NOT NULL,
                       university VARCHAR(255) NOT NULL
);

-- 2. 학생 테이블
CREATE TABLE student (
                         student_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         email VARCHAR(255) NOT NULL UNIQUE
);

-- 3. 튜터 수업 가능 시간 테이블
CREATE TABLE tutor_availability (
                                    tutor_availability_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                    tutor_id BIGINT NOT NULL,
                                    start_time DATETIME(6) NOT NULL,
                                    is_booked BIT(1) NOT NULL DEFAULT 0,

                                    UNIQUE KEY uniq_tutor_time (tutor_id, start_time),

                                    CONSTRAINT fk_availability_tutor FOREIGN KEY (tutor_id)
                                        REFERENCES tutor (tutor_id)
);

-- 4. 수업 예약 테이블
CREATE TABLE class_reservation (
                                   class_reservation_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                   student_id BIGINT NOT NULL,
                                   tutor_id BIGINT NOT NULL,
                                   tutor_availability_id BIGINT NOT NULL,
                                   start_time DATETIME(6) NOT NULL,
                                   end_time DATETIME(6) NOT NULL,
                                   duration_minutes INT NOT NULL,
                                   status ENUM('RESERVED', 'CANCELLED') NOT NULL,

                                   CONSTRAINT fk_reservation_student FOREIGN KEY (student_id)
                                       REFERENCES student (student_id),

                                   CONSTRAINT fk_reservation_tutor FOREIGN KEY (tutor_id)
                                       REFERENCES tutor (tutor_id),

                                   CONSTRAINT fk_reservation_availability FOREIGN KEY (tutor_availability_id)
                                       REFERENCES tutor_availability (tutor_availability_id)
);

INSERT INTO tutor (name, email, subject, university) VALUES
                                                         ('John Smith', 'john.smith@harvard.edu', 'English', 'Harvard University'),
                                                         ('Emily Johnson', 'emily.johnson@stanford.edu', 'Business', 'Stanford University');

INSERT INTO student (name, email) VALUES
                                      ('Alice Kim', 'alice.kim@example.com'),
                                      ('Bob Lee', 'bob.lee@example.com');

-- John Smith (튜터 1)
INSERT INTO tutor_availability (tutor_id, start_time, is_booked) VALUES
                                                                     (1, '2025-06-01 13:00:00.000000', 0),
                                                                     (1, '2025-06-01 13:30:00.000000', 0),
                                                                     (1, '2025-06-01 15:00:00.000000', 0);

-- Emily Johnson (튜터 2)
INSERT INTO tutor_availability (tutor_id, start_time, is_booked) VALUES
                                                                     (2, '2025-06-01 00:00:00.000000', 0),
                                                                     (2, '2025-06-01 12:00:00.000000', 0),
                                                                     (2, '2025-06-01 12:30:00.000000', 0),
                                                                     (2, '2025-06-01 13:30:00.000000', 0);


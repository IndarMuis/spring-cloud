CREATE DATABASE studydb;
USE studydb;


CREATE TABLE students
(
    student_id    VARCHAR(10)  NOT NULL PRIMARY KEY,
    name          VARCHAR(100) NOT NULL,
    email         VARCHAR(100) NOT NULL,
    phone_number  VARCHAR(15),
    date_of_birth DATE,
    major         VARCHAR(50)  NOT NULL,
    year_of_entry YEAR         NOT NULL,
    address       VARCHAR(200),
    created_at    TIMESTAMP   DEFAULT CURRENT_TIMESTAMP,
    updated_at    TIMESTAMP   DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by    VARCHAR(50),
    updated_by    VARCHAR(50) DEFAULT 'ADMIN'
);

CREATE TABLE lecturers
(
    lecturer_id    VARCHAR(10)  NOT NULL PRIMARY KEY,
    name           VARCHAR(100) NOT NULL,
    email          VARCHAR(100) NOT NULL,
    phone_number   VARCHAR(15),
    department     VARCHAR(50)  NOT NULL,
    office_address VARCHAR(200),
    date_of_birth  DATE,
    created_at     TIMESTAMP   DEFAULT CURRENT_TIMESTAMP,
    updated_at     TIMESTAMP   DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by     VARCHAR(50),
    updated_by     VARCHAR(50) DEFAULT 'ADMIN'
);


CREATE TABLE courses
(
    course_id   VARCHAR(10)  NOT NULL PRIMARY KEY,
    course_name VARCHAR(100) NOT NULL,
    credits     INT(2)       NOT NULL,
    semester    TINYINT(1)   NOT NULL,
    department  VARCHAR(50)  NOT NULL,
    description TEXT,
    created_at  TIMESTAMP   DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP   DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by  VARCHAR(50),
    updated_by  VARCHAR(50) DEFAULT 'ADMIN'
);

CREATE TABLE schedule
(
    schedule_id    INT(11)                                                               NOT NULL AUTO_INCREMENT PRIMARY KEY,
    course_id      VARCHAR(10)                                                           NOT NULL,
    lecturer_id    VARCHAR(10)                                                           NOT NULL,
    day            ENUM ('Senin', 'Selasa', 'Rabu', 'Kamis', 'Jumat', 'Sabtu', 'Minggu') NOT NULL,
    time_start     TIME                                                                  NOT NULL,
    time_end       TIME                                                                  NOT NULL,
    room           VARCHAR(50)                                                           NOT NULL,
    semester       TINYINT(1)                                                            NOT NULL,
    class_capacity INT(3),
    created_at     TIMESTAMP   DEFAULT CURRENT_TIMESTAMP,
    updated_at     TIMESTAMP   DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by     VARCHAR(50),
    updated_by     VARCHAR(50) DEFAULT 'ADMIN',
    FOREIGN KEY (course_id) REFERENCES courses (course_id),
    FOREIGN KEY (lecturer_id) REFERENCES lecturers (lecturer_id)
);

CREATE TABLE student_enrollments
(
    enrollment_id   INT(11)                            NOT NULL AUTO_INCREMENT PRIMARY KEY,
    student_id      VARCHAR(10)                        NOT NULL,
    schedule_id     INT(11)                            NOT NULL,
    enrollment_date DATE                               NOT NULL,
    status          ENUM ('Aktif', 'Ditunda', 'Batal') NOT NULL,
    created_at      TIMESTAMP   DEFAULT CURRENT_TIMESTAMP,
    updated_at      TIMESTAMP   DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by      VARCHAR(50),
    updated_by      VARCHAR(50) DEFAULT 'ADMIN',
    FOREIGN KEY (student_id) REFERENCES students (student_id),
    FOREIGN KEY (schedule_id) REFERENCES schedule (schedule_id)
);

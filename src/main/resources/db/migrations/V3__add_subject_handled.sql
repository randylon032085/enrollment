CREATE TABLE teacher_subject(
    teacher_id BIGINT NOT NULL,
    subject_id BIGINT NOT NULL,
    PRIMARY KEY (teacher_id,subject_id),
    CONSTRAINT fk_teacher_subject FOREIGN KEY (teacher_id)
        REFERENCES teacher_model (id) ON DELETE CASCADE,
    CONSTRAINT fk_teacher_subject_subject FOREIGN KEY (subject_id)
        REFERENCES subject_model (id) ON DELETE CASCADE
    )ENGINE=InnoDB;
    
    
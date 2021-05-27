CREATE TABLE IF NOT EXISTS tbl_person_language(
    person_id bigint not null,
    language_id bigint not null,
    CONSTRAINT person_lang_pk PRIMARY KEY (person_id, language_id),
    CONSTRAINT person_fk FOREIGN KEY (person_id) REFERENCES tbl_person (id) ON DELETE cascade,
    CONSTRAINT language_fk FOREIGN KEY (language_id) REFERENCES tbl_language (id) ON DELETE cascade
);

INSERT INTO tbl_person_language (person_id, language_id) VALUES (
                                                                 1,
                                                                 1
                                                                );

INSERT INTO tbl_person_language (person_id, language_id) VALUES (
                                                                    1,
                                                                    4
                                                                );

INSERT INTO tbl_person_language (person_id, language_id) VALUES (
                                                                    2,
                                                                    1
                                                                );

INSERT INTO tbl_person_language (person_id, language_id) VALUES (
                                                                    3,
                                                                    1
                                                                );

INSERT INTO tbl_person_language (person_id, language_id) VALUES (
                                                                    3,
                                                                    4
                                                                );

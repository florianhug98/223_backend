CREATE TABLE IF NOT EXISTS tbl_person(
    id bigint not null auto_increment,
    surname varchar(20) not null,
    name varchar(30) not null,
    notice text,
    PRIMARY KEY (id)
);

INSERT INTO tbl_person (surname, name, notice) VALUES (
                                                       'Florian',
                                                       'Hug',
                                                       ''
                                                      );

INSERT INTO tbl_person (surname, name, notice) VALUES (
                                                          'Fabio',
                                                          'Kaufmann',
                                                          ''
                                                      );

INSERT INTO tbl_person (surname, name, notice) VALUES (
                                                          'Jan',
                                                          'van Antwerpen',
                                                          ''
                                                      );

INSERT INTO tbl_person (surname, name, notice) VALUES (
                                                          'Matus',
                                                          'Blasko',
                                                          ''
                                                      );

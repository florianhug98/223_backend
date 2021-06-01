CREATE TABLE IF NOT EXISTS tbl_person(
    id bigint not null auto_increment,
    surname varchar(20) not null,
    name varchar(30) not null,
    notice text,
    version bigint not null,
    PRIMARY KEY (id)
);

INSERT INTO tbl_person (surname, name, notice, version) VALUES (
                                                                'Florian',
                                                                'Hug',
                                                                '',
                                                                0
                                                      );

INSERT INTO tbl_person (surname, name, notice, version) VALUES (
                                                       'Fabio',
                                                       'Kaufmann',
                                                       '',
                                                       0
                                                      );

INSERT INTO tbl_person (surname, name, notice, version) VALUES (
                                                       'Jan',
                                                       'van Antwerpen',
                                                       '',
                                                       0
                                                      );

INSERT INTO tbl_person (surname, name, notice, version) VALUES (
                                                       'Matus',
                                                       'Blasko',
                                                       '',
                                                       0
                                                      );

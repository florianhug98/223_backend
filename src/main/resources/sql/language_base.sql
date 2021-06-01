CREATE TABLE IF NOT EXISTS tbl_language(
    id bigint not null auto_increment,
    name varchar(20) not null,
    iso_code varchar(3) not null,
    version bigint not null,
    PRIMARY KEY (id)
);

INSERT INTO tbl_language (name, iso_code, version) VALUES (
                                                           'Deutsch',
                                                           'de',
                                                           0
                                                 );

INSERT INTO tbl_language (name, iso_code, version) VALUES (
                                                           'Französisch',
                                                           'fr',
                                                           0
                                                 );

INSERT INTO tbl_language (name, iso_code, version) VALUES (
                                                           'Italienisch',
                                                           'it',
                                                           0
                                                 );

INSERT INTO tbl_language (name, iso_code, version) VALUES (
                                                  'Englisch',
                                                  'en',
                                                  0
                                                 );

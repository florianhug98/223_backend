CREATE TABLE IF NOT EXISTS tbl_language(
    id bigint not null auto_increment,
    name varchar(20) not null,
    iso_code varchar(3) not null,
    PRIMARY KEY (id)
);

INSERT INTO tbl_language (name, iso_code) VALUES (
                                                  'Deutsch',
                                                  'de'
                                                 );

INSERT INTO tbl_language (name, iso_code) VALUES (
                                                     'Französisch',
                                                     'fr'
                                                 );

INSERT INTO tbl_language (name, iso_code) VALUES (
                                                     'Italienisch',
                                                     'it'
                                                 );

INSERT INTO tbl_language (name, iso_code) VALUES (
                                                     'Englisch',
                                                     'en'
                                                 );

INSERT INTO playpal.role (name) VALUES ('Admin');
INSERT INTO playpal.role (name) VALUES ('Kasutaja');

INSERT INTO playpal."user" (username, password, role_id) VALUES ('rain', '123', 2);

INSERT INTO playpal.gender (name) VALUES ('Naine');
INSERT INTO playpal.gender (name) VALUES ('Mees');

INSERT INTO playpal.country (name) VALUES ('Eesti');

INSERT INTO playpal.county (name, country_id) VALUES ('Harjumaa', 1);
INSERT INTO playpal.county (name, country_id) VALUES ('Raplamaa', 1);
INSERT INTO playpal.county (name, country_id) VALUES ('Pärnumaa', 1);
INSERT INTO playpal.county (name, country_id) VALUES ('Järvamaa', 1);
INSERT INTO playpal.county (name, country_id) VALUES ('Lääne-Virumaa', 1);
INSERT INTO playpal.county (name, country_id) VALUES ('Ida-Virumaa', 1);
INSERT INTO playpal.county (name, country_id) VALUES ('Tartumaa', 1);
INSERT INTO playpal.county (name, country_id) VALUES ('Saaremaa', 1);
INSERT INTO playpal.county (name, country_id) VALUES ('Hiiumaa', 1);
INSERT INTO playpal.county (name, country_id) VALUES ('Jõgevamaa', 1);
INSERT INTO playpal.county (name, country_id) VALUES ('Viljandimaa', 1);
INSERT INTO playpal.county (name, country_id) VALUES ('Valgamaa', 1);
INSERT INTO playpal.county (name, country_id) VALUES ('Võrumaa', 1);
INSERT INTO playpal.county (name, country_id) VALUES ('Põlvamaa', 1);
INSERT INTO playpal.county (name, country_id) VALUES ('Läänemaa', 1);

INSERT INTO playpal.city (county_id, name) VALUES (1, 'Tallinn');
INSERT INTO playpal.city (county_id, name) VALUES (2, 'Rapla');
INSERT INTO playpal.city (county_id, name) VALUES (3, 'Pärnu');
INSERT INTO playpal.city (county_id, name) VALUES (4, 'Paide');
INSERT INTO playpal.city (county_id, name) VALUES (5, 'Rakvere');
INSERT INTO playpal.city (county_id, name) VALUES (6, 'Narva');
INSERT INTO playpal.city (county_id, name) VALUES (7, 'Tartu');
INSERT INTO playpal.city (county_id, name) VALUES (8, 'Kuressaare');
INSERT INTO playpal.city (county_id, name) VALUES (9, 'Kärdla');
INSERT INTO playpal.city (county_id, name) VALUES (10, 'Jõgeva');
INSERT INTO playpal.city (county_id, name) VALUES (11, 'Viljandi');
INSERT INTO playpal.city (county_id, name) VALUES (12, 'Valga');
INSERT INTO playpal.city (county_id, name) VALUES (13, 'Võru');
INSERT INTO playpal.city (county_id, name) VALUES (14, 'Põlva');
INSERT INTO playpal.city (county_id, name) VALUES (15, 'Haapsalu');

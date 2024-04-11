INSERT INTO playpal.role (name) VALUES ('Admin');
INSERT INTO playpal.role (name) VALUES ('Kasutaja');

INSERT INTO playpal."user" (username, password, role_id) VALUES ('rain', '123', 2);
INSERT INTO playpal."user" (username, password, role_id) VALUES ('juku', '123', 2);

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

INSERT INTO playpal.profile (user_id, gender_id, city_id, first_name, last_name, birth_date, interested_in, introduction) VALUES (1, 2, 1, 'Rain', 'Tüür', '1900-01-01', 'EVERY! THING!??!!', 'Jah');
INSERT INTO playpal.profile (user_id, gender_id, city_id, first_name, last_name, birth_date, interested_in, introduction) VALUES (1, 2, 1, 'Juku', 'Pauk', '2014-01-01', 'mängimine, MINECRAFT!!!', 'lit');

INSERT INTO playpal.skill (name) VALUES ('Kõik on teretulnud');
INSERT INTO playpal.skill (name) VALUES ('Algaja');
INSERT INTO playpal.skill (name) VALUES ('Edasijõudnu');
INSERT INTO playpal.skill (name) VALUES ('Ekspert');

INSERT INTO playpal.location (city_id, post_code, street, longitude, latitude) VALUES (1, '10000     ', 'Vinge tee 3', 59.385130, 25.302980);

INSERT INTO playpal.event (user_id, name, venue, start_date, end_date, start_time, end_time, min_players, max_players, min_age, max_age, fee, skill_id, location_id) VALUES (1, 'Monopolyõhtu Raini juures', 'Raini pleiss', '2024-05-04', '2024-05-04', '16:00:00', '22:00:00', 2, 22, 18, 125, null, 1, 1);

INSERT INTO playpal.game (name) VALUES ('Monopoly');

INSERT INTO playpal.tag (name) VALUES ('Majandus');
INSERT INTO playpal.tag (name) VALUES ('Strateegia');

INSERT INTO playpal.game_tag (game_id, tag_id) VALUES (1, 1);
INSERT INTO playpal.game_tag (game_id, tag_id) VALUES (1, 2);

INSERT INTO playpal.event_game (event_id, game_id) VALUES (1, 1);

INSERT INTO playpal.participant (event_id, user_id, status) VALUES (1, 1, 'A');
INSERT INTO playpal.participant (event_id, user_id, status) VALUES (1, 2, 'P');

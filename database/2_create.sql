-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2024-04-10 06:19:10.03

-- tables

-- Table: type
CREATE TABLE type
(
    id     serial       NOT NULL,
    name   varchar(255) NOT NULL,
    status char(1)      NOT NULL DEFAULT 'A',
    CONSTRAINT type_pk PRIMARY KEY (id)
);

-- Table: gender
CREATE TABLE gender
(
    id     serial       NOT NULL,
    name   varchar(255) NOT NULL,
    status char(1)      NOT NULL DEFAULT 'A',
    CONSTRAINT gender_pk PRIMARY KEY (id)
);

-- Table: country
CREATE TABLE country
(
    id     serial       NOT NULL,
    name   varchar(255) NOT NULL,
    status char(1)      NOT NULL DEFAULT 'A',
    CONSTRAINT country_pk PRIMARY KEY (id)
);

-- Table: city
CREATE TABLE city
(
    id        serial       NOT NULL,
    county_id int          NOT NULL,
    name      varchar(255) NOT NULL,
    status    char(1)      NOT NULL DEFAULT 'A',
    CONSTRAINT city_pk PRIMARY KEY (id)
);


-- Table: county
CREATE TABLE county
(
    id         serial       NOT NULL,
    name       varchar(255) NOT NULL,
    status     char(1)      NOT NULL DEFAULT 'A',
    country_id int          NOT NULL,
    CONSTRAINT county_pk PRIMARY KEY (id)
);

-- Table: location
CREATE TABLE location
(
    id         serial        NOT NULL,
    city_id    int           NOT NULL,
    post_code  char(10)      NOT NULL,
    street     text          NOT NULL,
    longitude decimal(8, 6) NULL,
    latitude   decimal(8, 6) NULL,
    status     char(1)       NOT NULL DEFAULT 'A',
    CONSTRAINT location_pk PRIMARY KEY (id)
);

-- Table: role
CREATE TABLE role
(
    id     serial       NOT NULL,
    name   varchar(255) NOT NULL,
    status char(1)      NOT NULL DEFAULT 'A',
    CONSTRAINT role_pk PRIMARY KEY (id)
);

-- Table: tag
CREATE TABLE tag
(
    id     serial       NOT NULL,
    name   varchar(255) NOT NULL,
    status char(1)      NOT NULL DEFAULT 'A',
    CONSTRAINT tag_pk PRIMARY KEY (id)
);

-- Table: skill
CREATE TABLE skill
(
    id     serial       NOT NULL,
    name   varchar(255) NOT NULL,
    status char(1)      NOT NULL DEFAULT 'A',
    CONSTRAINT skill_pk PRIMARY KEY (id)
);

-- Table: user
CREATE TABLE "user"
(
    id       serial       NOT NULL,
    username varchar(30)  NOT NULL UNIQUE,
    password varchar(255) NOT NULL,
    role_id  int          NOT NULL DEFAULT 2,
    status   char(1)      NOT NULL DEFAULT 'A',
    CONSTRAINT user_pk PRIMARY KEY (id)
);

-- Table: profile
CREATE TABLE profile
(
    id            serial       NOT NULL,
    user_id       int          NOT NULL,
    gender_id     int          NOT NULL,
    city_id       int          NOT NULL,
    first_name    varchar(255) NOT NULL,
    last_name     varchar(255) NOT NULL,
    birth_date    date         NOT NULL,
    interested_in text         NULL,
    introduction  text         NULL,
    CONSTRAINT profile_pk PRIMARY KEY (id)
);

-- Table: event
CREATE TABLE event
(
    id          serial        NOT NULL,
    user_id     int           NOT NULL,
    name        varchar(255)  NOT NULL,
    venue       varchar(255)  NOT NULL,
    start_date  date          NOT NULL,
    end_date    date          NOT NULL,
    start_time  time          NOT NULL,
    end_time    time          NOT NULL,
    min_players int           NULL,
    max_players int           NULL,
    min_age     int           NULL,
    max_age     int           NULL,
    fee         decimal(6, 2) NULL,
    skill_id    int           NOT NULL,
    location_id int           NOT NULL,
    status      char(1)       NOT NULL DEFAULT 'A',
    CONSTRAINT event_pk PRIMARY KEY (id)
);

-- Table: feedback
CREATE TABLE feedback
(
    id      serial  NOT NULL,
    type_id int     NOT NULL,
    status  char(1) NOT NULL DEFAULT 'A',
    CONSTRAINT feedback_pk PRIMARY KEY (id)
);

-- Table: game
CREATE TABLE game
(
    id     serial       NOT NULL,
    name   varchar(255) NOT NULL,
    status char(1)      NOT NULL DEFAULT 'A',
    CONSTRAINT game_pk PRIMARY KEY (id)
);

-- Table: event_game
CREATE TABLE event_game
(
    id       serial NOT NULL,
    event_id int    NOT NULL,
    game_id  int    NOT NULL,
    CONSTRAINT event_game_pk PRIMARY KEY (id)
);

-- Table: game_tag
CREATE TABLE game_tag
(
    id      serial  NOT NULL,
    game_id int     NOT NULL,
    tag_id  int     NOT NULL,
    status  char(1) NOT NULL DEFAULT 'A',
    CONSTRAINT game_tag_pk PRIMARY KEY (id)
);

-- Table: event_image
CREATE TABLE event_image
(
    id         serial NOT NULL,
    image_data bytea  NULL,
    event_id   int    NOT NULL,
    CONSTRAINT event_image_pk PRIMARY KEY (id)
);

-- Table: participant
CREATE TABLE participant
(
    id       serial  NOT NULL,
    event_id int     NOT NULL,
    user_id  int     NOT NULL,
    status   char(1) NOT NULL DEFAULT 'A',
    CONSTRAINT participant_pk PRIMARY KEY (id)
);

-- Table: user_image
CREATE TABLE user_image
(
    id         serial NOT NULL,
    image_data bytea  NULL,
    profile_id int    NOT NULL,
    CONSTRAINT user_image_pk PRIMARY KEY (id)
);

-- Table: notification
CREATE TABLE notification
(
    id           serial       NOT NULL,
    message      varchar(255) NOT NULL,
    time_created timestamp    NOT NULL,
    status       char(1)      NOT NULL DEFAULT 'A',
    CONSTRAINT notification_pk PRIMARY KEY (id)
);



-- foreign keys
-- Reference: city_county (table: city)
ALTER TABLE city
    ADD CONSTRAINT city_county
        FOREIGN KEY (county_id)
            REFERENCES county (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: county_country (table: county)
ALTER TABLE county
    ADD CONSTRAINT county_country
        FOREIGN KEY (country_id)
            REFERENCES country (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: event_game_event (table: event_game)
ALTER TABLE event_game
    ADD CONSTRAINT event_game_event
        FOREIGN KEY (event_id)
            REFERENCES event (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: event_game_game (table: event_game)
ALTER TABLE event_game
    ADD CONSTRAINT event_game_game
        FOREIGN KEY (game_id)
            REFERENCES game (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: event_image_event (table: event_image)
ALTER TABLE event_image
    ADD CONSTRAINT event_image_event
        FOREIGN KEY (event_id)
            REFERENCES event (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: event_location (table: event)
ALTER TABLE event
    ADD CONSTRAINT event_location
        FOREIGN KEY (location_id)
            REFERENCES location (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: event_skill (table: event)
ALTER TABLE event
    ADD CONSTRAINT event_skill
        FOREIGN KEY (skill_id)
            REFERENCES skill (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: event_user (table: event)
ALTER TABLE event
    ADD CONSTRAINT event_user
        FOREIGN KEY (user_id)
            REFERENCES "user" (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: feedback_type (table: feedback)
ALTER TABLE feedback
    ADD CONSTRAINT feedback_type
        FOREIGN KEY (type_id)
            REFERENCES type (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: game_tag_game (table: game_tag)
ALTER TABLE game_tag
    ADD CONSTRAINT game_tag_game
        FOREIGN KEY (game_id)
            REFERENCES game (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: game_tag_tag (table: game_tag)
ALTER TABLE game_tag
    ADD CONSTRAINT game_tag_tag
        FOREIGN KEY (tag_id)
            REFERENCES tag (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: location_city (table: location)
ALTER TABLE location
    ADD CONSTRAINT location_city
        FOREIGN KEY (city_id)
            REFERENCES city (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: participant_event (table: participant)
ALTER TABLE participant
    ADD CONSTRAINT participant_event
        FOREIGN KEY (event_id)
            REFERENCES event (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: participant_user (table: participant)
ALTER TABLE participant
    ADD CONSTRAINT participant_user
        FOREIGN KEY (user_id)
            REFERENCES "user" (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: profile_city (table: profile)
ALTER TABLE profile
    ADD CONSTRAINT profile_city
        FOREIGN KEY (city_id)
            REFERENCES city (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: profile_gender (table: profile)
ALTER TABLE profile
    ADD CONSTRAINT profile_gender
        FOREIGN KEY (gender_id)
            REFERENCES gender (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: profile_user (table: profile)
ALTER TABLE profile
    ADD CONSTRAINT profile_user
        FOREIGN KEY (user_id)
            REFERENCES "user" (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: user_image_profile (table: user_image)
ALTER TABLE user_image
    ADD CONSTRAINT user_image_profile
        FOREIGN KEY (profile_id)
            REFERENCES profile (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: user_role (table: user)
ALTER TABLE "user"
    ADD CONSTRAINT user_role
        FOREIGN KEY (role_id)
            REFERENCES role (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- End of file.


INSERT INTO playpal.role (name) VALUES ('Admin');
INSERT INTO playpal.role (name) VALUES ('Kasutaja');

INSERT INTO playpal."user" (username, password, role_id) VALUES ('rain', '123', 2);
INSERT INTO playpal."user" (username, password, role_id) VALUES ('juku', '123', 2);
INSERT INTO playpal."user" (username, password, role_id) VALUES ('admin', '123', 1);
INSERT INTO playpal."user" (username, password, role_id) VALUES ('Pets', '123', 2);
INSERT INTO playpal."user" (username, password, role_id) VALUES ('Jaan', '123', 2);
INSERT INTO playpal."user" (username, password, role_id) VALUES ('pets', '123', 2);

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
INSERT INTO playpal.city (county_id, name) VALUES (1, 'Kiili');
INSERT INTO playpal.city (county_id, name) VALUES (1, 'Kiisa');
INSERT INTO playpal.city (county_id, name) VALUES (1, 'Saku');
INSERT INTO playpal.city (county_id, name) VALUES (1, 'Laagri');
INSERT INTO playpal.city (county_id, name) VALUES (1, 'Viimsi');
INSERT INTO playpal.city (county_id, name) VALUES (1, 'Maardu');
INSERT INTO playpal.city (county_id, name) VALUES (1, 'Peetri');
INSERT INTO playpal.city (county_id, name) VALUES (1, 'Lagedi');
INSERT INTO playpal.city (county_id, name) VALUES (1, 'Assaku');
INSERT INTO playpal.city (county_id, name) VALUES (1, 'Kangru');
INSERT INTO playpal.city (county_id, name) VALUES (1, 'Luige');
INSERT INTO playpal.city (county_id, name) VALUES (1, 'Vaida');
INSERT INTO playpal.city (county_id, name) VALUES (1, 'Kostivere');
INSERT INTO playpal.city (county_id, name) VALUES (1, 'Aruküla');
INSERT INTO playpal.city (county_id, name) VALUES (1, 'Raasiku');
INSERT INTO playpal.city (county_id, name) VALUES (1, 'Kiiu');
INSERT INTO playpal.city (county_id, name) VALUES (1, 'Kuusalu');
INSERT INTO playpal.city (county_id, name) VALUES (1, 'Kolga');
INSERT INTO playpal.city (county_id, name) VALUES (1, 'Loksa');
INSERT INTO playpal.city (county_id, name) VALUES (1, 'Aegviidu');
INSERT INTO playpal.city (county_id, name) VALUES (1, 'Kehra');
INSERT INTO playpal.city (county_id, name) VALUES (1, 'Kose-Uuemõisa');
INSERT INTO playpal.city (county_id, name) VALUES (1, 'Ravila');
INSERT INTO playpal.city (county_id, name) VALUES (1, 'Habaja');
INSERT INTO playpal.city (county_id, name) VALUES (1, 'Ardu');
INSERT INTO playpal.city (county_id, name) VALUES (1, 'Saue');
INSERT INTO playpal.city (county_id, name) VALUES (1, 'Karjaküla');
INSERT INTO playpal.city (county_id, name) VALUES (1, 'Keila-Joa');
INSERT INTO playpal.city (county_id, name) VALUES (1, 'Paldiski');
INSERT INTO playpal.city (county_id, name) VALUES (1, 'Klooga');
INSERT INTO playpal.city (county_id, name) VALUES (1, 'Keila');
INSERT INTO playpal.city (county_id, name) VALUES (1, 'Ämari');
INSERT INTO playpal.city (county_id, name) VALUES (1, 'Rummu');
INSERT INTO playpal.city (county_id, name) VALUES (1, 'Riisipere');
INSERT INTO playpal.city (county_id, name) VALUES (1, 'Turba');
INSERT INTO playpal.city (county_id, name) VALUES (1, 'Vasalemma');
INSERT INTO playpal.city (county_id, name) VALUES (1, 'Harku');
INSERT INTO playpal.city (county_id, name) VALUES (1, 'Loo');
INSERT INTO playpal.city (county_id, name) VALUES (1, 'Haabneeme');
INSERT INTO playpal.city (county_id, name) VALUES (1, 'Tabasalu');
INSERT INTO playpal.city (county_id, name) VALUES (2, 'Rapla');
INSERT INTO playpal.city (county_id, name) VALUES (2, 'Kehtna');
INSERT INTO playpal.city (county_id, name) VALUES (2, 'Kohila');
INSERT INTO playpal.city (county_id, name) VALUES (2, 'Järvakandi');
INSERT INTO playpal.city (county_id, name) VALUES (2, 'Hageri');
INSERT INTO playpal.city (county_id, name) VALUES (2, 'Hagudi');
INSERT INTO playpal.city (county_id, name) VALUES (2, 'Alu');
INSERT INTO playpal.city (county_id, name) VALUES (2, 'Kaiu');
INSERT INTO playpal.city (county_id, name) VALUES (2, 'Keava');
INSERT INTO playpal.city (county_id, name) VALUES (2, 'Kaerepere');
INSERT INTO playpal.city (county_id, name) VALUES (2, 'Kuusiku');
INSERT INTO playpal.city (county_id, name) VALUES (2, 'Märjamaa');
INSERT INTO playpal.city (county_id, name) VALUES (2, 'Eidapere');
INSERT INTO playpal.city (county_id, name) VALUES (2, 'Lelle');
INSERT INTO playpal.city (county_id, name) VALUES (3, 'Pärnu');
INSERT INTO playpal.city (county_id, name) VALUES (3, 'Lihula');
INSERT INTO playpal.city (county_id, name) VALUES (3, 'Virtsu');
INSERT INTO playpal.city (county_id, name) VALUES (3, 'Pärnu-Jaagupi');
INSERT INTO playpal.city (county_id, name) VALUES (3, 'Tootsi');
INSERT INTO playpal.city (county_id, name) VALUES (3, 'Vändra');
INSERT INTO playpal.city (county_id, name) VALUES (3, 'Tori');
INSERT INTO playpal.city (county_id, name) VALUES (3, 'Sindi');
INSERT INTO playpal.city (county_id, name) VALUES (3, 'Sauga');
INSERT INTO playpal.city (county_id, name) VALUES (3, 'Lavassaare');
INSERT INTO playpal.city (county_id, name) VALUES (3, 'Tõstamaa');
INSERT INTO playpal.city (county_id, name) VALUES (3, 'Audru');
INSERT INTO playpal.city (county_id, name) VALUES (3, 'Võiste');
INSERT INTO playpal.city (county_id, name) VALUES (3, 'Kilingi-Nõmme');
INSERT INTO playpal.city (county_id, name) VALUES (3, 'Häädemeeste');
INSERT INTO playpal.city (county_id, name) VALUES (3, 'Are');
INSERT INTO playpal.city (county_id, name) VALUES (4, 'Paide');
INSERT INTO playpal.city (county_id, name) VALUES (4, 'Käravete');
INSERT INTO playpal.city (county_id, name) VALUES (4, 'Ambla');
INSERT INTO playpal.city (county_id, name) VALUES (4, 'Aravete');
INSERT INTO playpal.city (county_id, name) VALUES (4, 'Järva-Jaani');
INSERT INTO playpal.city (county_id, name) VALUES (4, 'Roosna-Alliku');
INSERT INTO playpal.city (county_id, name) VALUES (4, 'Peetri');
INSERT INTO playpal.city (county_id, name) VALUES (4, 'Koeru');
INSERT INTO playpal.city (county_id, name) VALUES (4, 'Türi');
INSERT INTO playpal.city (county_id, name) VALUES (4, 'Väätsa');
INSERT INTO playpal.city (county_id, name) VALUES (4, 'Käru');
INSERT INTO playpal.city (county_id, name) VALUES (4, 'Oisu');
INSERT INTO playpal.city (county_id, name) VALUES (5, 'Rakvere');
INSERT INTO playpal.city (county_id, name) VALUES (5, 'Võsu');
INSERT INTO playpal.city (county_id, name) VALUES (5, 'Kunda');
INSERT INTO playpal.city (county_id, name) VALUES (5, 'Aseri');
INSERT INTO playpal.city (county_id, name) VALUES (5, 'Viru-Nigula');
INSERT INTO playpal.city (county_id, name) VALUES (5, 'Haljala');
INSERT INTO playpal.city (county_id, name) VALUES (5, 'Uhtna');
INSERT INTO playpal.city (county_id, name) VALUES (5, 'Näpi');
INSERT INTO playpal.city (county_id, name) VALUES (5, 'Sõmeru');
INSERT INTO playpal.city (county_id, name) VALUES (5, 'Hulja');
INSERT INTO playpal.city (county_id, name) VALUES (5, 'Kadrina');
INSERT INTO playpal.city (county_id, name) VALUES (5, 'Lepna');
INSERT INTO playpal.city (county_id, name) VALUES (5, 'Vinni');
INSERT INTO playpal.city (county_id, name) VALUES (5, 'Pajusti');
INSERT INTO playpal.city (county_id, name) VALUES (5, 'Viru-Jaagupi');
INSERT INTO playpal.city (county_id, name) VALUES (5, 'Tapa');
INSERT INTO playpal.city (county_id, name) VALUES (5, 'Tamsalu');
INSERT INTO playpal.city (county_id, name) VALUES (5, 'Kiltsi');
INSERT INTO playpal.city (county_id, name) VALUES (5, 'Väike-Maarja');
INSERT INTO playpal.city (county_id, name) VALUES (5, 'Laekvere');
INSERT INTO playpal.city (county_id, name) VALUES (5, 'Simuna');
INSERT INTO playpal.city (county_id, name) VALUES (5, 'Roela');
INSERT INTO playpal.city (county_id, name) VALUES (5, 'Tudu');
INSERT INTO playpal.city (county_id, name) VALUES (5, 'Rakke');
INSERT INTO playpal.city (county_id, name) VALUES (6, 'Narva');
INSERT INTO playpal.city (county_id, name) VALUES (6, 'Sonda');
INSERT INTO playpal.city (county_id, name) VALUES (6, 'Erra');
INSERT INTO playpal.city (county_id, name) VALUES (6, 'Lüganuse');
INSERT INTO playpal.city (county_id, name) VALUES (6, 'Püssi');
INSERT INTO playpal.city (county_id, name) VALUES (6, 'Kohtla-Järve');
INSERT INTO playpal.city (county_id, name) VALUES (6, 'Toila');
INSERT INTO playpal.city (county_id, name) VALUES (6, 'Voka');
INSERT INTO playpal.city (county_id, name) VALUES (6, 'Sillamäe');
INSERT INTO playpal.city (county_id, name) VALUES (6, 'Sinimäe');
INSERT INTO playpal.city (county_id, name) VALUES (6, 'Narva-Jõesuu');
INSERT INTO playpal.city (county_id, name) VALUES (6, 'Olgina');
INSERT INTO playpal.city (county_id, name) VALUES (6, 'Kohtla-Nõmme');
INSERT INTO playpal.city (county_id, name) VALUES (6, 'Jõhvi');
INSERT INTO playpal.city (county_id, name) VALUES (6, 'Mäetaguse');
INSERT INTO playpal.city (county_id, name) VALUES (6, 'Iisaku');
INSERT INTO playpal.city (county_id, name) VALUES (7, 'Tartu');
INSERT INTO playpal.city (county_id, name) VALUES (7, 'Kallaste');
INSERT INTO playpal.city (county_id, name) VALUES (7, 'Alatskivi');
INSERT INTO playpal.city (county_id, name) VALUES (7, 'Kolkja');
INSERT INTO playpal.city (county_id, name) VALUES (7, 'Kasepää');
INSERT INTO playpal.city (county_id, name) VALUES (7, 'Varnja');
INSERT INTO playpal.city (county_id, name) VALUES (7, 'Tabivere');
INSERT INTO playpal.city (county_id, name) VALUES (7, 'Äksi');
INSERT INTO playpal.city (county_id, name) VALUES (7, 'Lähte');
INSERT INTO playpal.city (county_id, name) VALUES (7, 'Vasula');
INSERT INTO playpal.city (county_id, name) VALUES (7, 'Raadi');
INSERT INTO playpal.city (county_id, name) VALUES (7, 'Luunja');
INSERT INTO playpal.city (county_id, name) VALUES (7, 'Märja');
INSERT INTO playpal.city (county_id, name) VALUES (7, 'Räni');
INSERT INTO playpal.city (county_id, name) VALUES (7, 'Külitse');
INSERT INTO playpal.city (county_id, name) VALUES (7, 'Roiu');
INSERT INTO playpal.city (county_id, name) VALUES (7, 'Võnnu');
INSERT INTO playpal.city (county_id, name) VALUES (7, 'Kambja');
INSERT INTO playpal.city (county_id, name) VALUES (7, 'Nõo');
INSERT INTO playpal.city (county_id, name) VALUES (7, 'Tõravere');
INSERT INTO playpal.city (county_id, name) VALUES (7, 'Elva');
INSERT INTO playpal.city (county_id, name) VALUES (7, 'Käärdi');
INSERT INTO playpal.city (county_id, name) VALUES (7, 'Rõngu');
INSERT INTO playpal.city (county_id, name) VALUES (7, 'Rannu');
INSERT INTO playpal.city (county_id, name) VALUES (7, 'Kureküla');
INSERT INTO playpal.city (county_id, name) VALUES (7, 'Puhja');
INSERT INTO playpal.city (county_id, name) VALUES (7, 'Ulila');
INSERT INTO playpal.city (county_id, name) VALUES (8, 'Kuressaare');
INSERT INTO playpal.city (county_id, name) VALUES (8, 'Kihelkonna');
INSERT INTO playpal.city (county_id, name) VALUES (8, 'Kärla');
INSERT INTO playpal.city (county_id, name) VALUES (8, 'Nasva');
INSERT INTO playpal.city (county_id, name) VALUES (8, 'Salme');
INSERT INTO playpal.city (county_id, name) VALUES (8, 'Aste');
INSERT INTO playpal.city (county_id, name) VALUES (8, 'Kudjape');
INSERT INTO playpal.city (county_id, name) VALUES (8, 'Valjala');
INSERT INTO playpal.city (county_id, name) VALUES (8, 'Orissaare');
INSERT INTO playpal.city (county_id, name) VALUES (9, 'Kärdla');
INSERT INTO playpal.city (county_id, name) VALUES (9, 'Kõrgessaare');
INSERT INTO playpal.city (county_id, name) VALUES (9, 'Käina');
INSERT INTO playpal.city (county_id, name) VALUES (10, 'Jõgeva');
INSERT INTO playpal.city (county_id, name) VALUES (10, 'Lohusuu');
INSERT INTO playpal.city (county_id, name) VALUES (10, 'Mustvee');
INSERT INTO playpal.city (county_id, name) VALUES (10, 'Sadala');
INSERT INTO playpal.city (county_id, name) VALUES (10, 'Torma');
INSERT INTO playpal.city (county_id, name) VALUES (10, 'Palamuse');
INSERT INTO playpal.city (county_id, name) VALUES (10, 'Puurmani');
INSERT INTO playpal.city (county_id, name) VALUES (10, 'Kamari');
INSERT INTO playpal.city (county_id, name) VALUES (10, 'Adavere');
INSERT INTO playpal.city (county_id, name) VALUES (10, 'Põltsamaa');
INSERT INTO playpal.city (county_id, name) VALUES (10, 'Siimusti');
INSERT INTO playpal.city (county_id, name) VALUES (11, 'Viljandi');
INSERT INTO playpal.city (county_id, name) VALUES (11, 'Võhma');
INSERT INTO playpal.city (county_id, name) VALUES (11, 'Kolga-Jaani');
INSERT INTO playpal.city (county_id, name) VALUES (11, 'Olustvere');
INSERT INTO playpal.city (county_id, name) VALUES (11, 'Suure-Jaani');
INSERT INTO playpal.city (county_id, name) VALUES (11, 'Kõpu');
INSERT INTO playpal.city (county_id, name) VALUES (11, 'Ramsi');
INSERT INTO playpal.city (county_id, name) VALUES (11, 'Õisu');
INSERT INTO playpal.city (county_id, name) VALUES (11, 'Halliste');
INSERT INTO playpal.city (county_id, name) VALUES (11, 'Abja-Paluoja');
INSERT INTO playpal.city (county_id, name) VALUES (11, 'Mõisaküla');
INSERT INTO playpal.city (county_id, name) VALUES (11, 'Karksi-Nuia');
INSERT INTO playpal.city (county_id, name) VALUES (11, 'Mustla');
INSERT INTO playpal.city (county_id, name) VALUES (12, 'Valga');
INSERT INTO playpal.city (county_id, name) VALUES (12, 'Helme');
INSERT INTO playpal.city (county_id, name) VALUES (12, 'Tõrva');
INSERT INTO playpal.city (county_id, name) VALUES (12, 'Puka');
INSERT INTO playpal.city (county_id, name) VALUES (12, 'Otepää');
INSERT INTO playpal.city (county_id, name) VALUES (12, 'Sangaste');
INSERT INTO playpal.city (county_id, name) VALUES (12, 'Õru');
INSERT INTO playpal.city (county_id, name) VALUES (12, 'Laatre');
INSERT INTO playpal.city (county_id, name) VALUES (12, 'Tsirguliina');
INSERT INTO playpal.city (county_id, name) VALUES (12, 'Hummuli');
INSERT INTO playpal.city (county_id, name) VALUES (13, 'Võru');
INSERT INTO playpal.city (county_id, name) VALUES (13, 'Vana-Antsla');
INSERT INTO playpal.city (county_id, name) VALUES (13, 'Antsla');
INSERT INTO playpal.city (county_id, name) VALUES (13, 'Varstu');
INSERT INTO playpal.city (county_id, name) VALUES (13, 'Rõuge');
INSERT INTO playpal.city (county_id, name) VALUES (13, 'Misso');
INSERT INTO playpal.city (county_id, name) VALUES (13, 'Vastseliina');
INSERT INTO playpal.city (county_id, name) VALUES (13, 'Kose');
INSERT INTO playpal.city (county_id, name) VALUES (13, 'Väimela');
INSERT INTO playpal.city (county_id, name) VALUES (13, 'Parksepa');
INSERT INTO playpal.city (county_id, name) VALUES (13, 'Värska');
INSERT INTO playpal.city (county_id, name) VALUES (14, 'Põlva');
INSERT INTO playpal.city (county_id, name) VALUES (14, 'Mehikoorma');
INSERT INTO playpal.city (county_id, name) VALUES (14, 'Ahja');
INSERT INTO playpal.city (county_id, name) VALUES (14, 'Vastse-Kuuste');
INSERT INTO playpal.city (county_id, name) VALUES (14, 'Mooste');
INSERT INTO playpal.city (county_id, name) VALUES (14, 'Räpina');
INSERT INTO playpal.city (county_id, name) VALUES (14, 'Veriora');
INSERT INTO playpal.city (county_id, name) VALUES (14, 'Kanepi');
INSERT INTO playpal.city (county_id, name) VALUES (15, 'Haapsalu');
INSERT INTO playpal.city (county_id, name) VALUES (15, 'Risti');
INSERT INTO playpal.city (county_id, name) VALUES (15, 'Palivere');
INSERT INTO playpal.city (county_id, name) VALUES (15, 'Paralepa');
INSERT INTO playpal.city (county_id, name) VALUES (15, 'Taebla');

INSERT INTO playpal.profile (user_id, gender_id, city_id, first_name, last_name, birth_date, interested_in, introduction) VALUES (1, 2, 1, 'Rain', 'Tüür', '1900-01-01', 'EVERY! THING!??!!', 'Kui võtad minu eventile kaasa meetodi, siis pane ta muutujasse.');
INSERT INTO playpal.profile (user_id, gender_id, city_id, first_name, last_name, birth_date, interested_in, introduction) VALUES (2, 2, 5, 'Juku', 'Pauk', '2014-01-01', 'mängimine, MINECRAFT!!!', 'lit');
INSERT INTO playpal.profile (user_id, gender_id, city_id, first_name, last_name, birth_date, interested_in, introduction) VALUES (3, 2, 25, 'Suur', 'Kärss', '2064-01-01', 'Administreerimine', 'Ma näen kõike');
INSERT INTO playpal.profile (user_id, gender_id, city_id, first_name, last_name, birth_date, interested_in, introduction) VALUES (4, 2, 45, 'Cash', 'Money', '2064-01-01', 'raha', 'rahaboss');
INSERT INTO playpal.profile (user_id, gender_id, city_id, first_name, last_name, birth_date, interested_in, introduction) VALUES (5, 1, 66, 'Heli', 'Looja', '2064-01-01', 'Muusika', 'Mu vanemad on heliloojad');
INSERT INTO playpal.profile (user_id, gender_id, city_id, first_name, last_name, birth_date, interested_in, introduction) VALUES (6, 1, 68, 'Pets', 'Võsa', '2064-01-01', 'metsad', 'Ma olen staar');

INSERT INTO playpal.skill (name) VALUES ('Kõik on teretulnud');
INSERT INTO playpal.skill (name) VALUES ('Algajad');
INSERT INTO playpal.skill (name) VALUES ('Edasijõudnud');
INSERT INTO playpal.skill (name) VALUES ('Eksperdid');
UPDATE playpal.skill SET sort_order = 1000 WHERE id = 1;
UPDATE playpal.skill SET sort_order = 2000 WHERE id = 2;
UPDATE playpal.skill SET sort_order = 3000 WHERE id = 3;
UPDATE playpal.skill SET sort_order = 4000 WHERE id = 4;



INSERT INTO playpal.location (city_id, post_code, street, longitude, latitude) VALUES (1, '10000', 'Vinge tee 3', 59.385130, 25.302980);
INSERT INTO playpal.location (city_id, post_code, street, longitude, latitude) VALUES (124, '51004', 'Vabaduse pst 5', 58.382643, 26.724832);
INSERT INTO playpal.location (city_id, post_code, street, longitude, latitude) VALUES (121, '51004', 'Tamme tee 6', 58.382643, 26.724832);
INSERT INTO playpal.location (city_id, post_code, street, longitude, latitude) VALUES (122, '51004', 'Kase tn 8', 58.382643, 26.724832);
INSERT INTO playpal.location (city_id, post_code, street, longitude, latitude) VALUES (123, '51004', 'Paju pst 5', 58.382643, 26.724832);
INSERT INTO playpal.location (city_id, post_code, street, longitude, latitude) VALUES (100, '51004', 'Lõkke 666', 58.382643, 26.724832);

INSERT INTO playpal.event (user_id, name, venue, start_date, end_date, start_time, end_time, min_players, max_players, min_age, max_age, fee, skill_id, location_id, event_description) VALUES (1, 'Monopolyõhtu Raini juures', 'Raini pleiss', '2024-05-04', '2024-05-04', '16:00:00', '22:00:00', 4, 8, 18, 125, null, 1, 1, 'Kui võtad minu üritusele kaasa meetodi, siis pane ta muutujasse. #coolcoolcool');
INSERT INTO playpal.event (user_id, name, venue, start_date, end_date, start_time, end_time, min_players, max_players, min_age, max_age, fee, skill_id, location_id, event_description) VALUES (2, 'Wingspan @ Naiiv', ' Kohvik Naiiv', '2024-05-05', '2024-05-05', '18:00:00', '21:30:00', 3, 5, 6, 66, 5.00, 2, 2,'"Wingspan" on mäng, kus saad olla linnuvaatleja ja luua enda unistuste linnuparadiisi! Kogu erinevaid linnuliike, ehitades üles oma parki ja võid mängu võites näidata, kes on tõeline sulg! Linnulised seiklused ootavad sind!');
INSERT INTO playpal.event (user_id, name, venue, start_date, end_date, start_time, end_time, min_players, max_players,min_age, max_age, fee, skill_id, location_id, event_description) VALUES (3, 'Alias koopas', 'koobas', '2024-03-03', '2024-03-03', '18:00:00', '21:30:00', 1, 5, 12, 67, 7.00, 1, 4,'
Tere sõber!Kas oled valmis seiklema mõistatuste maailmas, avastama saladusi ja naerma südamest? Siis oled oodatud meie lauamänguõhtule koopasse, kus võtame ette põneva seikluse mängides mängu "Alias"!
Mida oodata?
Põnevust pakkuvad mänguvoorud
Hingematvalt naljakad hetked
Võimalus üllatada ja olla üllatatud
Üritus toimub [kuupäeval] kell [ajal] [asukohas]. Ära unusta kaasa võtta head tuju ja sõpru, kellega koos seiklust jagada!
Ole valmis avastama uusi sõnu ja naerma südamest koos meiega!
Kohtumiseni koopas!');
INSERT INTO playpal.event (user_id, name, venue, start_date, end_date, start_time, end_time, min_players, max_players,min_age, max_age, fee, skill_id, location_id, event_description) VALUES (3, 'Catan Petsi pool', 'Pets House', '2024-02-03', '2024-03-03', '18:00:00', '21:30:00', 2, 12, 18, 27, 2.00, 2, 3,'Tere kõigile seiklushimulistele!
Olete kutsutud erilisele seiklusele, kus rändame kaugel asuva Catan''i saare maagilisse maailma! Liituge meiega Petsi juures, et sukelduda põnevasse maailma täis kaubandust, strateegiat ja seiklusi.
Koos veedame õhtu lauamängu "Catan" mängides, kus igaüks saab kujundada oma impeeriumi, kaubelda ressurssidega ning ehitada teid ja asulaid, et saada saare suurimaks valitsejaks!
Ärge unustage kaasa võtta head tuju ja oma parimaid strateegilisi oskusi, sest ees ootavad põnevad väljakutsed ja võidusõidud!
Ootame teid suure põnevusega!');
INSERT INTO playpal.event (user_id, name, venue, start_date, end_date, start_time, end_time, min_players, max_players,min_age, max_age, fee, skill_id, location_id, event_description) VALUES (2, 'Turakas Türgis', 'Türkland', '2024-06-06', '2024-06-07', '12:00:00', '21:00:00', 0, 8, 32, 37, 1.00, 2, 4,'Olete oodatud meie erilisele "Turakas Mängimise Õhtule", kus saate sukelduda põnevasse ja lõbusasse mängumaailma koos sõprade ja pereliikmetega. Oodatud on nii kogenud mängurid kui ka algajad! Tutvustame teile "Turakat" - mängu, mis pakub nii naeru kui ka strateegilist mõtlemist. Olge valmis võtma vastu väljakutseid ja kogema mängurõõmu!');
INSERT INTO playpal.event (user_id, name, venue, start_date, end_date, start_time, end_time, min_players, max_players,min_age, max_age, fee, skill_id, location_id, event_description) VALUES (6, 'Linnade põletamine jaanipäeval', 'Fire', '2024-06-24', '2024-06-24', '12:00:00', '23:00:00', 1, 99, 22, 57, 0.50, 1, 6,'Tere kõigile linnade põletamise fännidele!
Kas oled valmis kogema kaardimängu adrenaliinirohket põnevust? Kutsume sind osalema meie lõbusal ja mõnusal "Linnade Põletamine" kaardimängu õhtul!');
INSERT INTO playpal.event (user_id, name, venue, start_date, end_date, start_time, end_time, min_players, max_players,min_age, max_age, fee, skill_id, location_id, event_description) VALUES (5, 'Reis ümber maailma', 'Underworld', '2024-01-02', '2024-02-03', '12:00:00', '23:00:00', 1, 7, 1, 11, 0.01, 4, 5,'Kas oled valmis seikluseks, mis viib sind lauamängu reisile ümber maailma? Kui jah, siis on see kutse just sulle! Pakime kotid täis rõõmu, naeru ja mängukomplekte ning asume teele erinevatesse paikadesse üle maailma. Ole valmis avastama uusi kultuure, lahendama mõistatusi ja võtma vastu väljakutseid, mis pakuvad meile kõigile põnevaid elamusi.
Ära maga maha seda unustamatut reisi! Ootame sind põnevale lauamängu seiklusele');


INSERT INTO playpal.game (name) VALUES ('Monopoly');
INSERT INTO playpal.game (name) VALUES ('Wingspan');

INSERT INTO playpal.tag (name) VALUES ('Majandus');
INSERT INTO playpal.tag (name) VALUES ('Strateegia');
INSERT INTO playpal.tag (name) VALUES ('Pere');

INSERT INTO playpal.game_tag (game_id, tag_id) VALUES (1, 1);
INSERT INTO playpal.game_tag (game_id, tag_id) VALUES (1, 2);
INSERT INTO playpal.game_tag (game_id, tag_id) VALUES (2, 2);
INSERT INTO playpal.game_tag (game_id, tag_id) VALUES (2, 3);

INSERT INTO playpal.event_game (event_id, game_id) VALUES (1, 1);
INSERT INTO playpal.event_game (event_id, game_id) VALUES (2, 2);

INSERT INTO playpal.participant (event_id, user_id, status) VALUES (1, 1, 'A');
INSERT INTO playpal.participant (event_id, user_id, status) VALUES (1, 2, 'P');
INSERT INTO playpal.participant (event_id, user_id, status) VALUES (3, 2, 'A');
INSERT INTO playpal.participant (event_id, user_id, status) VALUES (4, 2, 'A');
INSERT INTO playpal.participant (event_id, user_id, status) VALUES (3, 1, 'R');
INSERT INTO playpal.participant (event_id, user_id, status) VALUES (4, 1, 'A');
INSERT INTO playpal.participant (event_id, user_id, status) VALUES (3, 3, 'A');
INSERT INTO playpal.participant (event_id, user_id, status) VALUES (4, 3, 'R');
INSERT INTO playpal.participant (event_id, user_id, status) VALUES (5, 3, 'A');
INSERT INTO playpal.participant (event_id, user_id, status) VALUES (5, 4, 'A');


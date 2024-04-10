-- Kustutab public schema (mis põhimõtteliselt kustutab kõik tabelid)
DROP SCHEMA playpal CASCADE;
-- Loob uue public schema vajalikud õigused
CREATE SCHEMA playpal
-- taastab vajalikud andmebaasi õigused
    GRANT ALL ON SCHEMA playpal TO postgres;
GRANT ALL ON SCHEMA playpal TO PUBLIC;
-- SET MODE Oracle; -- H2
SET DATABASE SQL SYNTAX ORA TRUE; -- Use ORACLE syntax in HSQLDB database

CREATE TABLE "MOBILE_USER" (
    "PERSON_ID_CODE" VARCHAR2(50 CHAR),
    "FULL_NAME" VARCHAR2(50 CHAR),
    "IS_ACTIVE" BOOLEAN,
    CONSTRAINT "PK_MOBILE_USER" PRIMARY KEY ("PERSON_ID_CODE")
);
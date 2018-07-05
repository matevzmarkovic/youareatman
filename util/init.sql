-- CREATE AtmanUser atman WITH PASSWORD 'youareatman';  managed by Docker
-- SET ROLE atman; managed by Docker

CREATE DATABASE youareatman;
-- ALTER DATABASE youareatman OWNER TO atman;  managed by Docker
-- GRANT ALL PRIVILEGES ON DATABASE youareatman TO atman;  managed by Docker

\c youareatman;

-- Following tutorial at https://www.meetspaceapp.com/2016/04/12/passwords-postgresql-pgcrypto.html
CREATE EXTENSION pgcrypto;

-- CREATE TABLE "atman_user" -----------------------------------------
CREATE TABLE "atman_user" (
	"user_email" Character Varying( 100 ) NOT NULL,
	"join_date" Date DEFAULT CURRENT_DATE NOT NULL,
	"pass_hash" Character Varying( 100 ) NOT NULL,
	PRIMARY KEY ( "user_email" ) );
 ;
-- -------------------------------------------------------------

-- CREATE INDEX "index_user_email" ----------------------------------
CREATE INDEX "index_user_email" ON "atman_user" USING btree( "user_email" );
-- -------------------------------------------------------------

-- CREATE TABLE "yamas" ----------------------------------------
CREATE TABLE "yamas" (
	"date" Date NOT NULL,
	"atman_user" Character Varying( 100 ) NOT NULL,
	"ahimsa" Boolean NOT NULL,
	"satya" Boolean NOT NULL,
	"asteya" Boolean NOT NULL,
	"brahmacharya" Boolean NOT NULL,
	"aparigraha" Boolean NOT NULL,
	PRIMARY KEY ( "date", "atman_user" ) );
 ;
-- -------------------------------------------------------------

-- CREATE INDEX "index_atman_user" -----------------------------------
CREATE INDEX "index_atman_user" ON "yamas" USING btree( "atman_user" );
-- -------------------------------------------------------------

-- CREATE INDEX "index_date" -----------------------------------
CREATE INDEX "index_date" ON "yamas" USING btree( "date" );
-- -------------------------------------------------------------

-- CREATE TABLE "niyamas" --------------------------------------
CREATE TABLE "niyamas" (
	"date" Date NOT NULL,
	"atman_user" Character Varying( 100 ) NOT NULL,
	"shaucha" Boolean NOT NULL,
	"santosha" Boolean NOT NULL,
	"tapas" Boolean NOT NULL,
	"svadhyaya" Boolean NOT NULL,
	"ishvara_pranidhana" Boolean NOT NULL,
	PRIMARY KEY ( "date", "atman_user" ) );
 ;
-- -------------------------------------------------------------

-- CREATE INDEX "index_atman_user1" -----------------------------------
CREATE INDEX "index_atman_user1" ON "niyamas" USING btree( "atman_user" );
-- -------------------------------------------------------------

-- CREATE INDEX "index_date1" ----------------------------------
CREATE INDEX "index_date1" ON "niyamas" USING btree( "date" );
-- -------------------------------------------------------------

-- CREATE LINK "lnk_atman_user_yamas" --------------------------------
ALTER TABLE "yamas"
	ADD CONSTRAINT "lnk_atman_user_yamas" FOREIGN KEY ( "atman_user" )
	REFERENCES "atman_user" ( "user_email" ) MATCH FULL
	ON DELETE Cascade
	ON UPDATE Cascade;
-- -------------------------------------------------------------

-- CREATE LINK "lnk_atman_user_niyamas" ------------------------------
ALTER TABLE "niyamas"
	ADD CONSTRAINT "lnk_atman_user_niyamas" FOREIGN KEY ( "atman_user" )
	REFERENCES "atman_user" ( "user_email" ) MATCH FULL
	ON DELETE Cascade
	ON UPDATE Cascade;
-- -------------------------------------------------------------

-- CREATE TABLE "incident" -------------------------------------
CREATE TABLE "incident" (
	"incident_id" Serial NOT NULL,
	"user_email" Character Varying( 100 ) NOT NULL,
	"date" Date NOT NULL,
	"antarayah_type" Character Varying( 50 ) NOT NULL,
	"sahabhuva_type" Character Varying( 50 ),
	"description" Character Varying( 2044 ) NOT NULL,
	PRIMARY KEY ( "incident_id" ) );
 ;
-- -------------------------------------------------------------

-- CREATE INDEX "index_user_email2" ----------------------------------
CREATE INDEX "index_user_email2" ON "incident" USING btree( "user_email" );
-- -------------------------------------------------------------

-- CREATE INDEX "index_date2" ----------------------------------
CREATE INDEX "index_date2" ON "incident" USING btree( "date" );
-- -------------------------------------------------------------

-- CREATE LINK "lnk_Incident_user_email2" -----------------------------
ALTER TABLE "incident"
	ADD CONSTRAINT "lnk_incident_user_email" FOREIGN KEY ( "user_email" )
	REFERENCES "atman_user" ( "user_email" ) MATCH FULL
	ON DELETE Cascade
	ON UPDATE Cascade;
-- -------------------------------------------------------------

-- REASSIGN OWNED BY postgres TO atman; not needed, since atman is used by Docker to create the database

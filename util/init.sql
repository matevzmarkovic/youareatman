-- CREATE AtmanUser atman WITH PASSWORD 'youareatman';  managed by Docker
-- SET ROLE atman; managed by Docker

CREATE DATABASE youareatman;
-- ALTER DATABASE youareatman OWNER TO atman;  managed by Docker
-- GRANT ALL PRIVILEGES ON DATABASE youareatman TO atman;  managed by Docker

\c youareatman;

-- Following tutorial at https://www.meetspaceapp.com/2016/04/12/passwords-postgresql-pgcrypto.html
CREATE EXTENSION pgcrypto;

-- CREATE TABLE "AtmanUser" -----------------------------------------
CREATE TABLE "AtmanUser" ( 
	"UserEmail" Character Varying( 100 ) NOT NULL,
	"JoinDate" Date DEFAULT CURRENT_DATE NOT NULL,
	"PassHash" Character Varying( 100 ) NOT NULL,
	PRIMARY KEY ( "UserEmail" ) );
 ;
-- -------------------------------------------------------------

-- CREATE INDEX "index_UserEmail" ----------------------------------
CREATE INDEX "index_UserEmail" ON "AtmanUser" USING btree( "UserEmail" );
-- -------------------------------------------------------------

-- CREATE TABLE "Yamas" ----------------------------------------
CREATE TABLE "Yamas" ( 
	"Date" Date NOT NULL,
	"AtmanUser" Character Varying( 100 ) NOT NULL,
	"Ahimsa" Boolean NOT NULL,
	"Satya" Boolean NOT NULL,
	"Asteya" Boolean NOT NULL,
	"Brahmacharya" Boolean NOT NULL,
	"Aparigraha" Boolean NOT NULL,
	PRIMARY KEY ( "Date", "AtmanUser" ) );
 ;
-- -------------------------------------------------------------

-- CREATE INDEX "index_AtmanUser" -----------------------------------
CREATE INDEX "index_AtmanUser" ON "Yamas" USING btree( "AtmanUser" );
-- -------------------------------------------------------------

-- CREATE INDEX "index_Date" -----------------------------------
CREATE INDEX "index_Date" ON "Yamas" USING btree( "Date" );
-- -------------------------------------------------------------

-- CREATE TABLE "Niyamas" --------------------------------------
CREATE TABLE "Niyamas" ( 
	"Date" Date NOT NULL,
	"AtmanUser" Character Varying( 100 ) NOT NULL,
	"Shaucha" Boolean NOT NULL,
	"Santosha" Boolean NOT NULL,
	"Tapas" Boolean NOT NULL,
	"Svadhyaya" Boolean NOT NULL,
	"Ishvara Pranidhana" Boolean NOT NULL,
	PRIMARY KEY ( "Date", "AtmanUser" ) );
 ;
-- -------------------------------------------------------------

-- CREATE INDEX "index_AtmanUser1" -----------------------------------
CREATE INDEX "index_AtmanUser1" ON "Niyamas" USING btree( "AtmanUser" );
-- -------------------------------------------------------------

-- CREATE INDEX "index_Date1" ----------------------------------
CREATE INDEX "index_Date1" ON "Niyamas" USING btree( "Date" );
-- -------------------------------------------------------------

-- CREATE LINK "lnk_AtmanUser_Yamas" --------------------------------
ALTER TABLE "Yamas"
	ADD CONSTRAINT "lnk_AtmanUser_Yamas" FOREIGN KEY ( "AtmanUser" )
	REFERENCES "AtmanUser" ( "UserEmail" ) MATCH FULL
	ON DELETE Cascade
	ON UPDATE Cascade;
-- -------------------------------------------------------------

-- CREATE LINK "lnk_AtmanUser_Niyamas" ------------------------------
ALTER TABLE "Niyamas"
	ADD CONSTRAINT "lnk_AtmanUser_Niyamas" FOREIGN KEY ( "AtmanUser" )
	REFERENCES "AtmanUser" ( "UserEmail" ) MATCH FULL
	ON DELETE Cascade
	ON UPDATE Cascade;
-- -------------------------------------------------------------

-- CREATE TABLE "Incident" -------------------------------------
CREATE TABLE "Incident" ( 
	"IncidentId" Serial NOT NULL,
	"UserEmail" Character Varying( 100 ) NOT NULL,
	"Date" Date NOT NULL,
	"AntarayahType" Character Varying( 50 ) NOT NULL,
	"SahabhuvaType" Character Varying( 50 ),
	"Description" Character Varying( 2044 ) NOT NULL,
	PRIMARY KEY ( "IncidentId" ) );
 ;
-- -------------------------------------------------------------

-- CREATE INDEX "index_UserEmail2" ----------------------------------
CREATE INDEX "index_UserEmail2" ON "Incident" USING btree( "UserEmail" );
-- -------------------------------------------------------------

-- CREATE INDEX "index_Date2" ----------------------------------
CREATE INDEX "index_Date2" ON "Incident" USING btree( "Date" );
-- -------------------------------------------------------------

-- CREATE LINK "lnk_Incident_UserEmail2" -----------------------------
ALTER TABLE "Incident"
	ADD CONSTRAINT "lnk_Incident_UserEmail" FOREIGN KEY ( "UserEmail" )
	REFERENCES "AtmanUser" ( "UserEmail" ) MATCH FULL
	ON DELETE Cascade
	ON UPDATE Cascade;
-- -------------------------------------------------------------

-- REASSIGN OWNED BY postgres TO atman; not needed, since atman is used by Docker to create the database

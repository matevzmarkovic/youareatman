-- CREATE USER atman WITH PASSWORD 'youareatman';  managed by Docker
-- SET ROLE atman; managed by Docker

CREATE DATABASE youareatman;
-- ALTER DATABASE youareatman OWNER TO atman;  managed by Docker
-- GRANT ALL PRIVILEGES ON DATABASE youareatman TO atman;  managed by Docker

\c youareatman;

-- CREATE TABLE "User" -----------------------------------------
CREATE TABLE "User" ( 
	"Email" Character Varying( 100 ) NOT NULL,
	"JoinDate" Date DEFAULT CURRENT_DATE NOT NULL,
	PRIMARY KEY ( "Email" ) );
 ;
-- -------------------------------------------------------------

-- CREATE INDEX "index_Email" ----------------------------------
CREATE INDEX "index_Email" ON "User" USING btree( "Email" );
-- -------------------------------------------------------------

-- CREATE TABLE "Yamas" ----------------------------------------
CREATE TABLE "Yamas" ( 
	"Date" Date NOT NULL,
	"User" Character Varying( 100 ) NOT NULL,
	"Ahimsa" Boolean NOT NULL,
	"Satya" Boolean NOT NULL,
	"Asteya" Boolean NOT NULL,
	"Brahmacharya" Boolean NOT NULL,
	"Aparigraha" Boolean NOT NULL,
	PRIMARY KEY ( "Date", "User" ) );
 ;
-- -------------------------------------------------------------

-- CREATE INDEX "index_User" -----------------------------------
CREATE INDEX "index_User" ON "Yamas" USING btree( "User" );
-- -------------------------------------------------------------

-- CREATE INDEX "index_Date" -----------------------------------
CREATE INDEX "index_Date" ON "Yamas" USING btree( "Date" );
-- -------------------------------------------------------------

-- CREATE TABLE "Niyamas" --------------------------------------
CREATE TABLE "Niyamas" ( 
	"Date" Date NOT NULL,
	"User" Character Varying( 100 ) NOT NULL,
	"Shaucha" Boolean NOT NULL,
	"Santosha" Boolean NOT NULL,
	"Tapas" Boolean NOT NULL,
	"Svadhyaya" Boolean NOT NULL,
	"Ishvara Pranidhana" Boolean NOT NULL,
	PRIMARY KEY ( "Date", "User" ) );
 ;
-- -------------------------------------------------------------

-- CREATE INDEX "index_User1" -----------------------------------
CREATE INDEX "index_User1" ON "Niyamas" USING btree( "User" );
-- -------------------------------------------------------------

-- CREATE INDEX "index_Date1" ----------------------------------
CREATE INDEX "index_Date1" ON "Niyamas" USING btree( "Date" );
-- -------------------------------------------------------------

-- CREATE LINK "lnk_User_Yamas" --------------------------------
ALTER TABLE "Yamas"
	ADD CONSTRAINT "lnk_User_Yamas" FOREIGN KEY ( "User" )
	REFERENCES "User" ( "Email" ) MATCH FULL
	ON DELETE Cascade
	ON UPDATE Cascade;
-- -------------------------------------------------------------

-- CREATE LINK "lnk_User_Niyamas" ------------------------------
ALTER TABLE "Niyamas"
	ADD CONSTRAINT "lnk_User_Niyamas" FOREIGN KEY ( "User" )
	REFERENCES "User" ( "Email" ) MATCH FULL
	ON DELETE Cascade
	ON UPDATE Cascade;
-- -------------------------------------------------------------

-- CREATE TABLE "Incident" -------------------------------------
CREATE TABLE "Incident" ( 
	"IncidentId" Serial NOT NULL,
	"User" Character Varying( 100 ) NOT NULL,
	"Date" Date NOT NULL,
	"AntarayahType" Character Varying( 50 ) NOT NULL,
	"SahabhuvaType" Character Varying( 50 ),
	"Description" Character Varying( 2044 ) NOT NULL,
	PRIMARY KEY ( "IncidentId" ) );
 ;
-- -------------------------------------------------------------

-- CREATE INDEX "index_User2" ----------------------------------
CREATE INDEX "index_User2" ON "Incident" USING btree( "User" );
-- -------------------------------------------------------------

-- CREATE INDEX "index_Date2" ----------------------------------
CREATE INDEX "index_Date2" ON "Incident" USING btree( "Date" );
-- -------------------------------------------------------------

-- CREATE LINK "lnk_Incident_User" -----------------------------
ALTER TABLE "Incident"
	ADD CONSTRAINT "lnk_Incident_User" FOREIGN KEY ( "User" )
	REFERENCES "User" ( "Email" ) MATCH FULL
	ON DELETE Cascade
	ON UPDATE Cascade;
-- -------------------------------------------------------------

-- REASSIGN OWNED BY postgres TO atman; not needed, since atman is used by Docker to create the database

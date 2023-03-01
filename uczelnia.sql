--------------------------------------------------------
--  File created - niedziela-czerwca-05-2022   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence KIERUNKI_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "SYSTEM"."KIERUNKI_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 41 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence KOLEGIA_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "SYSTEM"."KOLEGIA_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence PRZEDMIOTY_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "SYSTEM"."PRZEDMIOTY_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 41 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence STATYSTYKI_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "SYSTEM"."STATYSTYKI_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence STUDENCI_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "SYSTEM"."STUDENCI_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 41 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence USERS_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "SYSTEM"."USERS_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence WYKLADANEPRZEDMIOTY_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "SYSTEM"."WYKLADANEPRZEDMIOTY_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence WYKLADOWCY_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "SYSTEM"."WYKLADOWCY_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 41 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Table KIERUNKI
--------------------------------------------------------

  CREATE TABLE "SYSTEM"."KIERUNKI" 
   (	"IDKIERUNKU" NUMBER(10,0), 
	"NAZWA" VARCHAR2(255 CHAR), 
	"IDKOLEGIUM" NUMBER(10,0)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table KOLEGIA
--------------------------------------------------------

  CREATE TABLE "SYSTEM"."KOLEGIA" 
   (	"IDKOLEGIUM" NUMBER(10,0), 
	"KODPOCZTOWY" VARCHAR2(255 CHAR), 
	"MIASTO" VARCHAR2(255 CHAR), 
	"NAZWA" VARCHAR2(255 CHAR), 
	"NRBUDYNKU" VARCHAR2(255 CHAR), 
	"ULICA" VARCHAR2(255 CHAR)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table PRZEDMIOTY
--------------------------------------------------------

  CREATE TABLE "SYSTEM"."PRZEDMIOTY" 
   (	"IDPRZEDMIOTU" NUMBER(10,0), 
	"NAZWA" VARCHAR2(255 CHAR), 
	"IDKIERUNKU" NUMBER(10,0)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table STATYSTYKI
--------------------------------------------------------

  CREATE TABLE "SYSTEM"."STATYSTYKI" 
   (	"NUMER" NUMBER, 
	"NAZWA" VARCHAR2(20 BYTE), 
	"WARTOSC" NUMBER, 
	"DATA" DATE DEFAULT CURRENT_TIMESTAMP
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table STUDENCI
--------------------------------------------------------

  CREATE TABLE "SYSTEM"."STUDENCI" 
   (	"IDSTUDENTA" NUMBER(10,0), 
	"EMAIL" VARCHAR2(255 CHAR), 
	"IMIE" VARCHAR2(255 CHAR), 
	"MIASTO" VARCHAR2(255 CHAR), 
	"NAZWISKO" VARCHAR2(255 CHAR), 
	"NRALBUMU" VARCHAR2(255 CHAR), 
	"NUMERMIESZKANIA" VARCHAR2(255 CHAR), 
	"NRSEMESTRU" VARCHAR2(255 CHAR), 
	"NUMERTELEFONU" VARCHAR2(255 CHAR), 
	"PESEL" VARCHAR2(255 CHAR), 
	"ULICA" VARCHAR2(255 CHAR), 
	"IDKIERUNKU" NUMBER(10,0), 
	"IDKOLEGIUM" NUMBER(10,0)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table USERS
--------------------------------------------------------

  CREATE TABLE "SYSTEM"."USERS" 
   (	"IDUSER" NUMBER(10,0), 
	"HASLO" VARCHAR2(255 CHAR), 
	"LOGIN" VARCHAR2(255 CHAR), 
	"ROLA" VARCHAR2(255 CHAR)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table WYKLADANEPRZEDMIOTY
--------------------------------------------------------

  CREATE TABLE "SYSTEM"."WYKLADANEPRZEDMIOTY" 
   (	"IDWYKLADANEPRZEDMIOTY" NUMBER(10,0), 
	"IDKIERUNKU" NUMBER(10,0), 
	"IDPRZEDMIOTU" NUMBER(10,0), 
	"IDWYKLADOWCY" NUMBER(10,0)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table WYKLADOWCY
--------------------------------------------------------

  CREATE TABLE "SYSTEM"."WYKLADOWCY" 
   (	"IDWYKLADOWCY" NUMBER(10,0), 
	"EMAIL" VARCHAR2(255 CHAR), 
	"IMIE" VARCHAR2(255 CHAR), 
	"MIASTO" VARCHAR2(255 CHAR), 
	"NAZWISKO" VARCHAR2(255 CHAR), 
	"NUMERMIESZKANIA" VARCHAR2(255 CHAR), 
	"NUMERTELEFONU" VARCHAR2(255 CHAR), 
	"PENSJA" NUMBER(10,0), 
	"PESEL" VARCHAR2(255 CHAR), 
	"STOPIEN" VARCHAR2(255 CHAR), 
	"ULICA" VARCHAR2(255 CHAR)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into SYSTEM.KIERUNKI
SET DEFINE OFF;
Insert into SYSTEM.KIERUNKI (IDKIERUNKU,NAZWA,IDKOLEGIUM) values ('1','informatyka','1');
Insert into SYSTEM.KIERUNKI (IDKIERUNKU,NAZWA,IDKOLEGIUM) values ('2','matematyka','1');
Insert into SYSTEM.KIERUNKI (IDKIERUNKU,NAZWA,IDKOLEGIUM) values ('3','medycyna','2');
REM INSERTING into SYSTEM.KOLEGIA
SET DEFINE OFF;
Insert into SYSTEM.KOLEGIA (IDKOLEGIUM,KODPOCZTOWY,MIASTO,NAZWA,NRBUDYNKU,ULICA) values ('1','35-430','Rzesz�w','Kolegium nauk przyrodniczych','10','ulica');
Insert into SYSTEM.KOLEGIA (IDKOLEGIUM,KODPOCZTOWY,MIASTO,NAZWA,NRBUDYNKU,ULICA) values ('2','35-430','Rzesz�w','Kolegium nauk medycznych','20','ulica2');
REM INSERTING into SYSTEM.PRZEDMIOTY
SET DEFINE OFF;
Insert into SYSTEM.PRZEDMIOTY (IDPRZEDMIOTU,NAZWA,IDKIERUNKU) values ('1','Bazy danych','1');
Insert into SYSTEM.PRZEDMIOTY (IDPRZEDMIOTU,NAZWA,IDKIERUNKU) values ('2','Kardiologia','2');
Insert into SYSTEM.PRZEDMIOTY (IDPRZEDMIOTU,NAZWA,IDKIERUNKU) values ('21','matematyka','1');
REM INSERTING into SYSTEM.STATYSTYKI
SET DEFINE OFF;
REM INSERTING into SYSTEM.STUDENCI
SET DEFINE OFF;
Insert into SYSTEM.STUDENCI (IDSTUDENTA,EMAIL,IMIE,MIASTO,NAZWISKO,NRALBUMU,NUMERMIESZKANIA,NRSEMESTRU,NUMERTELEFONU,PESEL,ULICA,IDKIERUNKU,IDKOLEGIUM) values ('1','email1@email.com','Adam','Rzesz�w','Nowak','123456','5','2','123456789','12345678999','Modrzewiowa','1','1');
Insert into SYSTEM.STUDENCI (IDSTUDENTA,EMAIL,IMIE,MIASTO,NAZWISKO,NRALBUMU,NUMERMIESZKANIA,NRSEMESTRU,NUMERTELEFONU,PESEL,ULICA,IDKIERUNKU,IDKOLEGIUM) values ('2','email2@email.com','Jan','Rzesz�w','Kowalski','123457','12','5','987654321','12345147852','Akacjowa','1','2');
Insert into SYSTEM.STUDENCI (IDSTUDENTA,EMAIL,IMIE,MIASTO,NAZWISKO,NRALBUMU,NUMERMIESZKANIA,NRSEMESTRU,NUMERTELEFONU,PESEL,ULICA,IDKIERUNKU,IDKOLEGIUM) values ('22','email3@wp.pl','Jan','Rzesz�w','Kowalski','444555','35','2','123321111','12332122233','Akacjowa','3','2');
Insert into SYSTEM.STUDENCI (IDSTUDENTA,EMAIL,IMIE,MIASTO,NAZWISKO,NRALBUMU,NUMERMIESZKANIA,NRSEMESTRU,NUMERTELEFONU,PESEL,ULICA,IDKIERUNKU,IDKOLEGIUM) values ('23','email4@wp.pl','Stefan','Rzesz�w','Wilk','444556','36','2','147852369','12332122244','Akacjowa','3','2');
REM INSERTING into SYSTEM.USERS
SET DEFINE OFF;
Insert into SYSTEM.USERS (IDUSER,HASLO,LOGIN,ROLA) values ('1','admin','admin','admin');
Insert into SYSTEM.USERS (IDUSER,HASLO,LOGIN,ROLA) values ('2','nowak','jan','guest');
REM INSERTING into SYSTEM.WYKLADANEPRZEDMIOTY
SET DEFINE OFF;
REM INSERTING into SYSTEM.WYKLADOWCY
SET DEFINE OFF;
Insert into SYSTEM.WYKLADOWCY (IDWYKLADOWCY,EMAIL,IMIE,MIASTO,NAZWISKO,NUMERMIESZKANIA,NUMERTELEFONU,PENSJA,PESEL,STOPIEN,ULICA) values ('1','email3@email.com','Stefan','Rzesz�w','Zawadzki','6','145869237','5600','14788522699','doktor','Le�na');
--------------------------------------------------------
--  DDL for Index SYS_C007647
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYSTEM"."SYS_C007647" ON "SYSTEM"."KIERUNKI" ("IDKIERUNKU") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index SYS_C007654
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYSTEM"."SYS_C007654" ON "SYSTEM"."KOLEGIA" ("IDKOLEGIUM") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index SYS_C007658
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYSTEM"."SYS_C007658" ON "SYSTEM"."PRZEDMIOTY" ("IDPRZEDMIOTU") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index SYS_C007486
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYSTEM"."SYS_C007486" ON "SYSTEM"."STATYSTYKI" ("NUMER") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index SYS_C007677
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYSTEM"."SYS_C007677" ON "SYSTEM"."STUDENCI" ("IDSTUDENTA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index SYS_C007457
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYSTEM"."SYS_C007457" ON "SYSTEM"."USERS" ("IDUSER") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index SYS_C007682
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYSTEM"."SYS_C007682" ON "SYSTEM"."WYKLADANEPRZEDMIOTY" ("IDWYKLADANEPRZEDMIOTY") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index SYS_C007694
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYSTEM"."SYS_C007694" ON "SYSTEM"."WYKLADOWCY" ("IDWYKLADOWCY") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Trigger KIERUNKI_TRG
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE TRIGGER "SYSTEM"."KIERUNKI_TRG" 
BEFORE INSERT ON KIERUNKI 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.IDKIERUNKU IS NULL THEN
      SELECT KIERUNKI_SEQ.NEXTVAL INTO :NEW.IDKIERUNKU FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;

/
ALTER TRIGGER "SYSTEM"."KIERUNKI_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger KOLEGIA_TRG
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE TRIGGER "SYSTEM"."KOLEGIA_TRG" 
BEFORE INSERT ON KOLEGIA 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.IDKOLEGIUM IS NULL THEN
      SELECT KOLEGIA_SEQ.NEXTVAL INTO :NEW.IDKOLEGIUM FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;

/
ALTER TRIGGER "SYSTEM"."KOLEGIA_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger PRZEDMIOTY_TRG
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE TRIGGER "SYSTEM"."PRZEDMIOTY_TRG" 
BEFORE INSERT ON PRZEDMIOTY 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.IDPRZEDMIOTU IS NULL THEN
      SELECT PRZEDMIOTY_SEQ.NEXTVAL INTO :NEW.IDPRZEDMIOTU FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;

/
ALTER TRIGGER "SYSTEM"."PRZEDMIOTY_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger STUDENCI_TRG
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE TRIGGER "SYSTEM"."STUDENCI_TRG" 
BEFORE INSERT ON STUDENCI 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.IDSTUDENTA IS NULL THEN
      SELECT STUDENCI_SEQ.NEXTVAL INTO :NEW.IDSTUDENTA FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;

/
ALTER TRIGGER "SYSTEM"."STUDENCI_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger USERS_TRG
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE TRIGGER "SYSTEM"."USERS_TRG" 
BEFORE INSERT ON USERS 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.IDUSER IS NULL THEN
      SELECT USERS_SEQ.NEXTVAL INTO :NEW.IDUSER FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;

/
ALTER TRIGGER "SYSTEM"."USERS_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger WYKLADANEPRZEDMIOTY_TRG
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE TRIGGER "SYSTEM"."WYKLADANEPRZEDMIOTY_TRG" 
BEFORE INSERT ON WYKLADANEPRZEDMIOTY 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.IDWYKLADANEPRZEDMIOTY IS NULL THEN
      SELECT WYKLADANEPRZEDMIOTY_SEQ.NEXTVAL INTO :NEW.IDWYKLADANEPRZEDMIOTY FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;

/
ALTER TRIGGER "SYSTEM"."WYKLADANEPRZEDMIOTY_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger WYKLADOWCY_TRG
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE TRIGGER "SYSTEM"."WYKLADOWCY_TRG" 
BEFORE INSERT ON WYKLADOWCY 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.IDWYKLADOWCY IS NULL THEN
      SELECT WYKLADOWCY_SEQ.NEXTVAL INTO :NEW.IDWYKLADOWCY FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;

/
ALTER TRIGGER "SYSTEM"."WYKLADOWCY_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger KIERUNKI_TRG
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE TRIGGER "SYSTEM"."KIERUNKI_TRG" 
BEFORE INSERT ON KIERUNKI 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.IDKIERUNKU IS NULL THEN
      SELECT KIERUNKI_SEQ.NEXTVAL INTO :NEW.IDKIERUNKU FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;

/
ALTER TRIGGER "SYSTEM"."KIERUNKI_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger KOLEGIA_TRG
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE TRIGGER "SYSTEM"."KOLEGIA_TRG" 
BEFORE INSERT ON KOLEGIA 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.IDKOLEGIUM IS NULL THEN
      SELECT KOLEGIA_SEQ.NEXTVAL INTO :NEW.IDKOLEGIUM FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;

/
ALTER TRIGGER "SYSTEM"."KOLEGIA_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger PRZEDMIOTY_TRG
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE TRIGGER "SYSTEM"."PRZEDMIOTY_TRG" 
BEFORE INSERT ON PRZEDMIOTY 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.IDPRZEDMIOTU IS NULL THEN
      SELECT PRZEDMIOTY_SEQ.NEXTVAL INTO :NEW.IDPRZEDMIOTU FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;

/
ALTER TRIGGER "SYSTEM"."PRZEDMIOTY_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger STUDENCI_TRG
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE TRIGGER "SYSTEM"."STUDENCI_TRG" 
BEFORE INSERT ON STUDENCI 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.IDSTUDENTA IS NULL THEN
      SELECT STUDENCI_SEQ.NEXTVAL INTO :NEW.IDSTUDENTA FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;

/
ALTER TRIGGER "SYSTEM"."STUDENCI_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger USERS_TRG
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE TRIGGER "SYSTEM"."USERS_TRG" 
BEFORE INSERT ON USERS 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.IDUSER IS NULL THEN
      SELECT USERS_SEQ.NEXTVAL INTO :NEW.IDUSER FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;

/
ALTER TRIGGER "SYSTEM"."USERS_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger WYKLADANEPRZEDMIOTY_TRG
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE TRIGGER "SYSTEM"."WYKLADANEPRZEDMIOTY_TRG" 
BEFORE INSERT ON WYKLADANEPRZEDMIOTY 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.IDWYKLADANEPRZEDMIOTY IS NULL THEN
      SELECT WYKLADANEPRZEDMIOTY_SEQ.NEXTVAL INTO :NEW.IDWYKLADANEPRZEDMIOTY FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;

/
ALTER TRIGGER "SYSTEM"."WYKLADANEPRZEDMIOTY_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger WYKLADOWCY_TRG
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE TRIGGER "SYSTEM"."WYKLADOWCY_TRG" 
BEFORE INSERT ON WYKLADOWCY 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.IDWYKLADOWCY IS NULL THEN
      SELECT WYKLADOWCY_SEQ.NEXTVAL INTO :NEW.IDWYKLADOWCY FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;

/
ALTER TRIGGER "SYSTEM"."WYKLADOWCY_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Function AKTUALIZUJSTATYSTYKI
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE FUNCTION "SYSTEM"."AKTUALIZUJSTATYSTYKI" return number IS
        st statystyki%rowtype;
        
        procedure st_add(z_numer number, z_nazwa varchar2, z_wartosc number) AS
        begin 
        	update statystyki set nazwa = z_nazwa, wartosc = z_wartosc, data = sysdate where numer = z_numer;
            if SQL%NOTFOUND then 
                insert into statystyki (numer, nazwa, wartosc) values (z_numer, z_nazwa, z_wartosc);
            end IF;
            commit;
       end st_add;
       
BEGIN
    st.numer := 1;
    st.nazwa := 'Liczba student�w';
    st.wartosc := 0;
    select count(*) into st.wartosc from studenci;
    st_add(st.numer, st.nazwa, st.wartosc);
    
    st.numer := 2;
    st.nazwa := 'Liczba wykladowc�w';
    st.wartosc := 0;
    select count(*) into st.wartosc from wykladowcy;
    st_add(st.numer, st.nazwa, st.wartosc);
    
    st.numer := 3;
    st.nazwa := 'Liczba kierunk�w';
    st.wartosc := 0;
    select count(*) into st.wartosc from kierunki;
    st_add(st.numer, st.nazwa, st.wartosc);
    
    return 1;
    
exception
    when others then return 0;
    
END aktualizujStatystyki;

/
--------------------------------------------------------
--  DDL for Function LOGIN
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE FUNCTION "SYSTEM"."LOGIN" (z_login varchar2, z_haslo varchar2) return varchar2 is
  l_exst number(1);
begin
 select case 
           when exists(SELECT login FROM USERS WHERE login = z_login AND haslo = z_haslo)
           then 1
           else 0
         end  into l_exst
  from dual;

if l_exst = 1 
  then
    return 'true';
  else
    return 'false'; 
  end if;
end Login;

/
--------------------------------------------------------
--  Constraints for Table KIERUNKI
--------------------------------------------------------

  ALTER TABLE "SYSTEM"."KIERUNKI" MODIFY ("IDKIERUNKU" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."KIERUNKI" MODIFY ("NAZWA" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."KIERUNKI" MODIFY ("IDKOLEGIUM" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."KIERUNKI" ADD PRIMARY KEY ("IDKIERUNKU")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Constraints for Table KOLEGIA
--------------------------------------------------------

  ALTER TABLE "SYSTEM"."KOLEGIA" MODIFY ("IDKOLEGIUM" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."KOLEGIA" MODIFY ("KODPOCZTOWY" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."KOLEGIA" MODIFY ("MIASTO" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."KOLEGIA" MODIFY ("NAZWA" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."KOLEGIA" MODIFY ("NRBUDYNKU" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."KOLEGIA" MODIFY ("ULICA" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."KOLEGIA" ADD PRIMARY KEY ("IDKOLEGIUM")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Constraints for Table PRZEDMIOTY
--------------------------------------------------------

  ALTER TABLE "SYSTEM"."PRZEDMIOTY" MODIFY ("IDPRZEDMIOTU" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."PRZEDMIOTY" MODIFY ("NAZWA" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."PRZEDMIOTY" MODIFY ("IDKIERUNKU" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."PRZEDMIOTY" ADD PRIMARY KEY ("IDPRZEDMIOTU")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Constraints for Table STATYSTYKI
--------------------------------------------------------

  ALTER TABLE "SYSTEM"."STATYSTYKI" MODIFY ("NUMER" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."STATYSTYKI" MODIFY ("NAZWA" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."STATYSTYKI" MODIFY ("WARTOSC" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."STATYSTYKI" MODIFY ("DATA" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."STATYSTYKI" ADD PRIMARY KEY ("NUMER")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Constraints for Table STUDENCI
--------------------------------------------------------

  ALTER TABLE "SYSTEM"."STUDENCI" MODIFY ("IDSTUDENTA" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."STUDENCI" MODIFY ("EMAIL" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."STUDENCI" MODIFY ("IMIE" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."STUDENCI" MODIFY ("MIASTO" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."STUDENCI" MODIFY ("NAZWISKO" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."STUDENCI" MODIFY ("NRALBUMU" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."STUDENCI" MODIFY ("NUMERMIESZKANIA" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."STUDENCI" MODIFY ("NRSEMESTRU" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."STUDENCI" MODIFY ("NUMERTELEFONU" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."STUDENCI" MODIFY ("PESEL" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."STUDENCI" MODIFY ("ULICA" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."STUDENCI" MODIFY ("IDKIERUNKU" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."STUDENCI" MODIFY ("IDKOLEGIUM" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."STUDENCI" ADD PRIMARY KEY ("IDSTUDENTA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Constraints for Table USERS
--------------------------------------------------------

  ALTER TABLE "SYSTEM"."USERS" MODIFY ("IDUSER" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."USERS" MODIFY ("HASLO" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."USERS" MODIFY ("LOGIN" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."USERS" MODIFY ("ROLA" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."USERS" ADD PRIMARY KEY ("IDUSER")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Constraints for Table WYKLADANEPRZEDMIOTY
--------------------------------------------------------

  ALTER TABLE "SYSTEM"."WYKLADANEPRZEDMIOTY" MODIFY ("IDWYKLADANEPRZEDMIOTY" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."WYKLADANEPRZEDMIOTY" MODIFY ("IDKIERUNKU" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."WYKLADANEPRZEDMIOTY" MODIFY ("IDPRZEDMIOTU" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."WYKLADANEPRZEDMIOTY" MODIFY ("IDWYKLADOWCY" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."WYKLADANEPRZEDMIOTY" ADD PRIMARY KEY ("IDWYKLADANEPRZEDMIOTY")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Constraints for Table WYKLADOWCY
--------------------------------------------------------

  ALTER TABLE "SYSTEM"."WYKLADOWCY" MODIFY ("IDWYKLADOWCY" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."WYKLADOWCY" MODIFY ("EMAIL" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."WYKLADOWCY" MODIFY ("IMIE" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."WYKLADOWCY" MODIFY ("MIASTO" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."WYKLADOWCY" MODIFY ("NAZWISKO" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."WYKLADOWCY" MODIFY ("NUMERMIESZKANIA" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."WYKLADOWCY" MODIFY ("NUMERTELEFONU" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."WYKLADOWCY" MODIFY ("PENSJA" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."WYKLADOWCY" MODIFY ("PESEL" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."WYKLADOWCY" MODIFY ("STOPIEN" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."WYKLADOWCY" MODIFY ("ULICA" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."WYKLADOWCY" ADD PRIMARY KEY ("IDWYKLADOWCY")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table KIERUNKI
--------------------------------------------------------

  ALTER TABLE "SYSTEM"."KIERUNKI" ADD CONSTRAINT "FKPQ3YC6A5FDT5B9ACXD5RX415C" FOREIGN KEY ("IDKOLEGIUM")
	  REFERENCES "SYSTEM"."KOLEGIA" ("IDKOLEGIUM") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table PRZEDMIOTY
--------------------------------------------------------

  ALTER TABLE "SYSTEM"."PRZEDMIOTY" ADD CONSTRAINT "FKTFFXXK4VOBHT3QOF6QUOGVNMN" FOREIGN KEY ("IDKIERUNKU")
	  REFERENCES "SYSTEM"."KIERUNKI" ("IDKIERUNKU") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table STUDENCI
--------------------------------------------------------

  ALTER TABLE "SYSTEM"."STUDENCI" ADD CONSTRAINT "FKE158AY1876QOCSUQBYRBX6SH9" FOREIGN KEY ("IDKIERUNKU")
	  REFERENCES "SYSTEM"."KIERUNKI" ("IDKIERUNKU") ENABLE;
  ALTER TABLE "SYSTEM"."STUDENCI" ADD CONSTRAINT "FKIR60UUBR33RW4MDQ92X9MRUSP" FOREIGN KEY ("IDKOLEGIUM")
	  REFERENCES "SYSTEM"."KOLEGIA" ("IDKOLEGIUM") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table WYKLADANEPRZEDMIOTY
--------------------------------------------------------

  ALTER TABLE "SYSTEM"."WYKLADANEPRZEDMIOTY" ADD CONSTRAINT "FK1J73JFD8ACFHQ6F06S0FB49GE" FOREIGN KEY ("IDKIERUNKU")
	  REFERENCES "SYSTEM"."KIERUNKI" ("IDKIERUNKU") ENABLE;
  ALTER TABLE "SYSTEM"."WYKLADANEPRZEDMIOTY" ADD CONSTRAINT "FK2OG5BULTRQBB56CHEV4ESNSIY" FOREIGN KEY ("IDPRZEDMIOTU")
	  REFERENCES "SYSTEM"."PRZEDMIOTY" ("IDPRZEDMIOTU") ENABLE;
  ALTER TABLE "SYSTEM"."WYKLADANEPRZEDMIOTY" ADD CONSTRAINT "FKEW97EB8PI2XR9UN7EFI4ED4XX" FOREIGN KEY ("IDWYKLADOWCY")
	  REFERENCES "SYSTEM"."WYKLADOWCY" ("IDWYKLADOWCY") ENABLE;

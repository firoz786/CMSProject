/*
Dropping previous registration table and creating new registration table
*/
DROP TABLE Registration CASCADE CONSTRAINTS;
CREATE TABLE Registration
  (
    memberid      VARCHAR2(10) NOT NULL,
    firstname     VARCHAR2(20) NOT NULL,
    lastname      VARCHAR2(20) NOT NULL,
    dateofbirth   DATE NOT NULL,
    contactnumber NUMBER(10) NOT NULL,
    emailaddress  VARCHAR2(50) NOT NULL,
    gender        VARCHAR2(10) NOT NULL,
    password      VARCHAR2(100) NOT NULL,
    CONSTRAINT pk1 PRIMARY KEY (memberid),
    CONSTRAINT uk1 UNIQUE (emailaddress)
  );
/*
dropping previous sequence and creating new sequence
*/
DROP SEQUENCE memberid_seq;
CREATE SEQUENCE memberid_seq MINVALUE 1 MAXVALUE 99999 START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;
  /*
  dropping previous procedure and creating new procedure
  */
CREATE OR REPLACE
  FUNCTION registration_prc2(
      firstnamevariable     VARCHAR2,
      lastnamevariable      VARCHAR2,
      gendervariable        VARCHAR2,
      dateofbirthvariable   DATE,
      emailaddressvariable  VARCHAR2,
      contactnumbervariable NUMBER,
      passwordvariable      VARCHAR2)
    RETURN VARCHAR2
  AS
    memberid_init VARCHAR2(4)  := 'MBC-';
    sequenceno    VARCHAR2(10) := TO_CHAR(memberid_seq.nextval);
  BEGIN
    CASE
    WHEN sequenceno  < 10 THEN
      sequenceno    := concat(memberid_init,concat('0000',sequenceno));
    WHEN sequenceno >= 10 AND sequenceno < 100 THEN
      sequenceno    :=concat(memberid_init, concat('000',sequenceno));
    WHEN sequenceno >= 100 AND sequenceno < 1000 THEN
      sequenceno    := concat(memberid_init,concat('00',sequenceno));
    WHEN sequenceno >= 1000 AND sequenceno < 10000 THEN
      sequenceno    := concat(memberid_init,concat('0',sequenceno));
    END CASE;
    INSERT
    INTO registration
      (
        memberid,
        firstname,
        lastname,
        gender,
        dateofbirth,
        emailaddress,
        contactnumber,
        password
      )
      VALUES
      (
        sequenceno,
        firstnamevariable,
        lastnamevariable,
        gendervariable,
        dateofbirthvariable,
        emailaddressvariable,
        contactnumbervariable,
        passwordvariable
      );
    COMMIT;
    RETURN sequenceno;
  END;
  /
CREATE OR REPLACE
PROCEDURE registration_prc1
  (
    memberidvariable      VARCHAR2,
    firstnamevariable     VARCHAR2,
    lastnamevariable      VARCHAR2,
    gendervariable        VARCHAR2,
    dateofbirthvariable   DATE,
    emailaddressvariable  VARCHAR2,
    contactnumbervariable NUMBER
  )
AS
BEGIN
  UPDATE registration
  SET FIRSTNAME  =firstnamevariable,
    LASTNAME     =lastnamevariable,
    GENDER       =gendervariable,
    DATEOFBIRTH  =dateofbirthvariable,
    EMAILADDRESS =emailaddressvariable,
    CONTACTNUMBER=contactnumbervariable
  WHERE MEMBERID =memberidvariable;
  COMMIT;
END;
/
COMMIT;
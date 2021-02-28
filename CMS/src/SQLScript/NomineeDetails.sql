DROP TABLE NomineeDetails CASCADE CONSTRAINTS;
CREATE TABLE NomineeDetails
  (
    insurancetypeid NUMBER(1) NOT NULL,
    memberid        VARCHAR2(10) NOT NULL,
    nomineename     VARCHAR2(20) NOT NULL,
    CONSTRAINT fk2 FOREIGN KEY (insurancetypeid) REFERENCES InsuranceType (insurancetypeid),
    CONSTRAINT fk3 FOREIGN KEY (memberid) REFERENCES Registration (memberid)
  );
/*
dropping previous procedure and creating new procedure
*/
CREATE OR REPLACE
PROCEDURE NomineeDetails_prc1
  (
    memberidvariable        VARCHAR2,
    insurancetypeidvariable NUMBER,
    nomineenamevariable     VARCHAR2,
    oldnomineenamevariable  VARCHAR2
  )
AS
BEGIN
  UPDATE nomineedetails
  SET nomineename    =nomineenamevariable
  WHERE memberid     =memberidvariable
  AND insurancetypeid=insurancetypeidvariable
  AND nomineename    =oldnomineenamevariable;
  COMMIT;
END;
/
CREATE OR REPLACE
PROCEDURE nomineedetails_prc2(
    memberidvariable        VARCHAR2,
    insurancetypeidvariable NUMBER,
    nomineenamevariable     VARCHAR2 )
AS
BEGIN
  INSERT
  INTO nomineedetails
    (
      memberid,
      insurancetypeid,
      nomineename
    )
    VALUES
    (
      memberidvariable,
      insurancetypeidvariable,
      nomineenamevariable
    );
  COMMIT;
END;
/
COMMIT;

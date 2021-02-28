DROP TABLE Claim CASCADE CONSTRAINTS;
CREATE TABLE Claim
  (
    claimid          VARCHAR2(10) NOT NULL,
    memberid         VARCHAR2(10) NOT NULL,
    insurancetypeid  NUMBER(1) NOT NULL,
    claimreason      VARCHAR2(10) NOT NULL,
    dateofapproval   DATE NOT NULL,
    requestdate      DATE NOT NULL,
    finalclaimamount NUMBER(10,2) NOT NULL,
    status           VARCHAR2(10),
    CONSTRAINT pk4 PRIMARY KEY (claimid)
  );
DROP SEQUENCE claim_seq1;
CREATE SEQUENCE claim_seq1 MINVALUE 1 MAXVALUE 99999 START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE OR REPLACE
  FUNCTION claim_fun1(
      memberidvariable         VARCHAR2,
      insurancetypevariable    VARCHAR2,
      reasonvariable           VARCHAR2,
      requestdatevariable      VARCHAR2,
      approvaldatevariable     VARCHAR2,
      finalclaimamountvariable NUMBER,
      statusvariable           VARCHAR2)
    RETURN VARCHAR2
  AS
    insurancetypeidlocal VARCHAR2(1);
    memberid_init        VARCHAR2(4)  := 'CLM-';
    sequenceno           VARCHAR2(10) := TO_CHAR(claim_seq1.nextval);
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
    SELECT insurancetype.insurancetypeid
    INTO insurancetypeidlocal
    FROM insurancetype
    WHERE insurancetype.insurancetype=insurancetypevariable;
    INSERT
    INTO Claim
      (
        claimid,
        memberid,
        insurancetypeid,
        claimreason,
        dateofapproval,
        requestdate,
        finalclaimamount,
        status
      )
      VALUES
      (
        sequenceno,
        memberidvariable,
        insurancetypeidlocal,
        reasonvariable,
        to_date(approvaldatevariable,'dd/mm/yyyy'),
        to_date(requestdatevariable,'dd/mm/yyyy'),
        finalclaimamountvariable,
        statusvariable
      );
    COMMIT;
    RETURN sequenceno;
  END;
  /
  COMMIT;
package com.cms.constants;

/**
 * @author Rishabh Gupta
 *
 */
public class DatabaseConstants {

    public static final String DBPROPERTIES = "properties.DatabaseProperties";
    public static final String DBURL = "database.url";
    public static final String DBUSERNAME = "database.username";
    public static final String DBPASSWORD = "database.password";
    public static final String CMSMESSAGES = "properties.CMSMessages";
    public static final String GETUSERMEMBERID = "select count(*) from registration where memberid=?";
    public static final String GETUSERDETAILS = "select count(*) from registration where memberid=? and password=?";
    public static final String GETPROFILEUPDATES = "select count(*) from address where memberid=?";
    public static final String GETEMAILADDRESS = "select count(*) from registration where emailaddress=?";
    public static final String MEMBERREGISTRATION = "{?= call registration_prc2(?,?,?, TO_DATE(?,'dd/mm/yyyy'),?,?,?)}";
    public static final String UPDATEPROFILE = "{ call profileupdate_prc1(?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?)}";
    public static final String UPDATEFIRSTTIMEPROFILE = "{call profileupdate_prc2(?,?,?,?,TO_DATE(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?)}";
    public static final String GETMEMBERID = "select memberid from registration";
    public static final String GETJSPQUERYWITHMEMBERID = "select firstname,lastname,to_char(dateofbirth,'dd/mm/yyyy') as DOB,contactnumber,emailaddress,gender,nvl(address,null),nvl(city,null),nvl(state,null),nvl(zipcode,null) from registration reg left outer join "
            + "address addr on reg.memberid=addr.memberid  where reg.memberid=?";
    public static final String GETNOMINEEDETAILS = "select nomineename from nomineedetails where memberid=? and insurancetypeid=(select insurancetypeid from insurancetype where insurancetype=?)";
    public static final String GETNOMINEENAMECOUNT = "select count(*) from nomineedetails where memberid=? and insurancetypeid=(select insurancetypeid from insurancetype where insurancetype=?)";
    public static final String GETINSURANCETYPES = "select insurancetype,insuredamount from insurancetype";
    public static final String GETINSURANCETYPEID = "select insurancetypeid from insurancetype where insurancetype=?";
    public static final String INSERTNOMINEENAME = "insert into nomineedetails(insurancetypeid,memberid,nomineename) values(?,?,?)";
    public static final String GETMEMBERNOMINEECOUNT = "select count(*) from nomineedetails where memberid=? and insurancetypeid=?";
    public static final String ISNOMINEEPRESENT = "select count(*) from nomineedetails where memberid=? and insurancetypeid=? and nomineename=?";
    public static final String REMOVENOMINEE = "delete from nomineedetails where memberid=? and insurancetypeid=? and nomineename=?";
    public static final String SELECTCLAIMDATA = "select * from claim where memberId=? and requestDate=to_date(?,'dd/mm/yyyy')";
    public static final String CLAIMREQUEST = "{call Claim_prc(?,?,?,?,?,?)}";
    public static final String GETMEMBERFROMMEMBERINSURANCETYPE="select count(*) from memberinsurancetype where memberid=? and insurancetypeid=?";
    public static final String GETMAXIMUMCLAIMABLEAMOUNT = "select maximumclaimableamount from memberinsurancetype where memberid=? and insurancetypeid=(select insurancetypeid from insurancetype where insurancetype=?)";
    public static final String REQUESTCLAIM="{?=call claim_fun1(?,?,?,?,?,?,?)}";
    public static final String GETPROCESSCLAIMDATA="select * from claim where memberid=?";
    public static final String UPDATESTATUS="update claim set status=? where claimid=?";

}

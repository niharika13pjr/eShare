package eshare.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import com.mysql.jdbc.*;
import eshare.model.Registration;
import eshare.util.DBHandle;

public class registrationDAO
{

	public void InsertNewUser(Registration RegObj)
	{
	    try 
	    {
	        PreparedStatement
	        dbStatement = 
	        DBHanlde.prepareStatement(
	        		"insert into registration"
	        		+ "(fname,lname,password,address,contact,regdate,verifyUser,email,verificationCode,gender,dppath,dob)"
	        		+ " values (?, ?,?,?,?,?,?,?,?,?,?,?)");
	        
	        //dbStatement.setInt(1, hashTagfeed.getParentFeedID());
	        //dbStatement.setString(2, hashTagfeed.getHashtag());
	        //dbStatement.setString(3, hashTagfeed.getContent());
	        
	        dbStatement.setString(1,RegObj.getFname()); 
	        dbStatement.setString(2,RegObj.getLname()); 
	        dbStatement.setString(3,RegObj.getPassword()); 
	        dbStatement.setString(4,RegObj.getAddress()); 
	        dbStatement.setString(5,RegObj.getContact()); 
	        dbStatement.setDate(6,  new java.sql.Date(RegObj.getDate().getTime()));
	        dbStatement.setInt(7,0); 
	        dbStatement.setString(8,RegObj.getEmail()); 
	        dbStatement.setString(9,RegObj.getVerificationCode());
	        dbStatement.setString(10,RegObj.getGender());
	        dbStatement.setString(11,RegObj.getDppath());        
	        dbStatement.setDate(12,  new java.sql.Date(RegObj.getDob().getTime()));
	        
	        dbStatement.executeUpdate(); 

	    } catch (Exception AllExceptoin) {
	    	AllExceptoin.printStackTrace();
	    }
	}
	
	public registrationDAO() 
	{
		DBHanlde = DBHandle.getDBHandle();
		if (DBHanlde == null){
			System.out.println("Here..in DB handle null");
		}
		else{
			System.out.println("DB Handle not null");
		}
	}
	
	
	public boolean IsAuthenticatedUser(String EmailID, String Password)
	{
	    try 
	    {
	        PreparedStatement dbStatement = DBHanlde.prepareStatement("select * from registration where Email=? and password=?");
	        
	        dbStatement.setString(1, EmailID);
	        dbStatement.setString(2, Password);
	        
	        ResultSet Resultset = dbStatement.executeQuery();
	
	        //If set is not null then the entry is already present.
	        if (Resultset.next())
	        {
	            return true;
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	
	    return false;
	}

	public void SetVerificatoinStatus(String EmailID, int iVerificationStatus)
	{
	    try 
	    {
	        PreparedStatement dbStatement = DBHanlde.prepareStatement("update registration set verifyUser = ? where Email=?");

	        dbStatement.setInt(1, iVerificationStatus);
	        dbStatement.setString(2, EmailID);
	        
	        int iUpdateCount  = dbStatement.executeUpdate();
	
//	        //If set is not null then the entry is already present.
//	        if (Resultset.next())
//	        {
//	            return true;
//	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	
	    return;
		
	}
	
	public boolean IsPresent(String EmailID)
	{
	    try 
	    {
	        PreparedStatement dbStatement = DBHanlde.prepareStatement("select * from registration where email=?");
	        
	        dbStatement.setString(1, EmailID);
	        
	        ResultSet Resultset = dbStatement.executeQuery();
	
	        //If set is not null then the entry is already present.
	        if (Resultset.next())
	        {
	            return true;
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	
	    return false;
	}
	
	public Registration GetUserInfo(String EmailID)
	{
		Registration RegObj = new Registration();
		 
	    try 
	    {
	        PreparedStatement dbStatement = DBHanlde.prepareStatement("select * from registration where email=?");
	        
	        dbStatement.setString(1, EmailID);
	        
	        ResultSet Resultset = dbStatement.executeQuery();
	
	       	//If set is not null then the entry is already present.
	        if (Resultset.next())
	        {
//(fname,lname,password,Address,Contact,Date,verifyUser,Email,verificationCode,gender,dppath,dob)
	        	
	        	RegObj.setUserID(Resultset.getInt("userID"));
	        	RegObj.setFname(Resultset.getString("fname"));
	        	RegObj.setLname(Resultset.getString("lname"));
	        	RegObj.setEmail(Resultset.getString("Email"));	
	        	
	            return RegObj;
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	
	    return RegObj;
	}
	
	//public Registration getUser(String Email){
//		ArrayList list=new ArrayList(); 
//		try{
//			PreparedStatement dbStatement = DBHanlde.
//	                prepareStatement("select * from Registration_Table where Email=?");
//			 ResultSet rs=ps.executeQuery();  
//			    while(rs.next()){  
//			    	 Registration rr=new Registration();  
//			    
//			         rr.setFName(rs.getSting(1));  
//			         rr.setLName(rs.getString(2));
//			         rr.setUserID(rs.getInt(3));
//					 rr.setPassword(rs.getString(4));
//					rr.setAddress(rs.getString(5));
//						rr.setContact(rs.getString(6));
//					rr.setDate(rs.getDate(7));
//						rr.setVerifyUser(rs.getBoolean(8));
//			
//						rr.setSharedCount(rs.getInt(9));
//						rr.setReceivedCount(rs.getInt(10));
//						rr.setVerificationCode(rs.getString(11));
//						rr.setUserScore(rs.getInt(12));
//						rr.setGender(rs.getShort(13));
//						rr.setDob(rs.getDate(14));
//						rr.setDppath(rs.getString(15));
//						list.add(rr); 
//			    }
//			
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//	}
	

private Connection DBHanlde;
}
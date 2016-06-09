package eshare.model;

import java.util.Date;

public class Registration {
	Date dob;
	Date regdate;
	int userID;
	String fname;
	String lname;
	String email;
	String gender;
	String dppath;
	int userScore;
	String address;
	String contact;
	String password;
	int sharedCount;
	int receivedCount;
	boolean verifyUser;
	String verificationCode;
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public Date getDate() {
		return regdate;
	}
	public void setDate(Date date) {
		regdate = date;
	}
	public boolean isVerifyUser() {
		return verifyUser;
	}
	public void setVerifyUser(boolean verifyUser) {
		this.verifyUser = verifyUser;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getSharedCount() {
		return sharedCount;
	}
	public void setSharedCount(int sharedCount) {
		this.sharedCount = sharedCount;
	}
	public int getReceivedCount() {
		return receivedCount;
	}
	public void setReceivedCount(int receivedCount) {
		this.receivedCount = receivedCount;
	}
	public String getVerificationCode() {
		return verificationCode;
	}
	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}
	public int getUserScore() {
		return userScore;
	}
	public void setUserScore(int userScore) {
		this.userScore = userScore;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getDppath() {
		return dppath;
	}
	public void setDppath(String dppath) {
		this.dppath = dppath;
	}
	
	

}

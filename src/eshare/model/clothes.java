package eshare.model;

import java.util.Date;

public class clothes {
	int clothID;
	String clothtype;
	String brandname;
	String shoplocation;
	String comments;
	int count;
	Date startdate;
	Date expirydate;
	int quantity;
	String link;
	int userid;
	int clothstatus;
	public int getClothstatus() {
		return clothstatus;
	}
	public void setClothstatus(int clothstatus) {
		this.clothstatus = clothstatus;
	}
	public int getClothID() {
		return clothID;
	}
	public void setClothID(int clothID) {
		this.clothID = clothID;
	}
	public String getClothtype() {
		return clothtype;
	}
	public void setClothtype(String clothtype) {
		this.clothtype = clothtype;
	}
	public String getBrandname() {
		return brandname;
	}
	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}
	public String getShoplocation() {
		return shoplocation;
	}
	public void setShoplocation(String shoplocation) {
		this.shoplocation = shoplocation;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getExpirydate() {
		return expirydate;
	}
	public void setExpirydate(Date expirydate) {
		this.expirydate = expirydate;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}

}

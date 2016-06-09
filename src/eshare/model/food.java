package eshare.model;

import java.util.Date;

public class food {
	int foodID;
	int userID;
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	String venue;
	Date timeposted;
	Date expirydate;
	String foodType;
	String comments;
	int foodStatus;
	double foodPrice;
	int peopleNeeded;
	int currentfoodCount;
	String paymentType;
	String foodQuantity;
	double priceperPerson;
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public int getFoodID() {
		return foodID;
	}
	public void setFoodID(int foodID) {
		this.foodID = foodID;
	}
	public Date getTimeposted() {
		return timeposted;
	}
	public void setTimeposted(Date timeposted) {
		this.timeposted = timeposted;
	}
	public Date getExpirydate() {
		return expirydate;
	}
	public void setExpirydate(Date expirydate) {
		this.expirydate = expirydate;
	}
	public int getCurrentfoodCount() {
		return currentfoodCount;
	}
	public void setCurrentfoodCount(int currentfoodCount) {
		this.currentfoodCount = currentfoodCount;
	}
	public String getFoodType() {
		return foodType;
	}
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public int getFoodStatus() {
		return foodStatus;
	}
	public void setFoodStatus(int foodStatus) {
		this.foodStatus = foodStatus;
	}
	public double getFoodPrice() {
		return foodPrice;
	}
	public void setFoodPrice(double foodPrice) {
		this.foodPrice = foodPrice;
	}
	public int getPeopleNeeded() {
		return peopleNeeded;
	}
	public void setPeopleNeeded(int peopleNeeded) {
		this.peopleNeeded = peopleNeeded;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getFoodQuantity() {
		return foodQuantity;
	}
	public void setFoodQuantity(String foodQuantity) {
		this.foodQuantity = foodQuantity;
	}
	public double getPriceperPerson() {
		return priceperPerson;
	}
	public void setPriceperPerson(double priceperPerson) {
		this.priceperPerson = priceperPerson;
	}
}

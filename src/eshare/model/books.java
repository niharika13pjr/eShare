package eshare.model;



public class books {
	public String getBooktitle() {
		return booktitle;
	}
	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public int getBookID() {
		return bookID;
	}
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	public double getRentedPrice() {
		return rentedPrice;
	}
	public void setRentedPrice(double rentedPrice) {
		this.rentedPrice = rentedPrice;
	}
	public double getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getAdditionVolume() {
		return additionVolume;
	}
	public void setAdditionVolume(String additionVolume) {
		this.additionVolume = additionVolume;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getISBNnumber() {
		return ISBNnumber;
	}
	public void setISBNnumber(String iSBNnumber) {
		ISBNnumber = iSBNnumber;
	}
	String booktitle;
	String publisher;
	String author;
	String comments;
	int bookID;
	double rentedPrice;
	double purchasePrice;
	int userID;
	String additionVolume;
	String paymentType;
	String ISBNnumber;
	int booked;
	public int isBooked() {
		return booked;
	}
	public void setBooked(int booked) {
		this.booked = booked;
	}
}

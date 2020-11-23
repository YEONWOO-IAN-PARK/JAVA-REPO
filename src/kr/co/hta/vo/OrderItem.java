package kr.co.hta.vo;

public class OrderItem {
	long no;
	int bookNo;
	int price;
	int amount;
	
	public OrderItem () {}

	public long getNo() {
		return no;
	}

	public void setNo(long no) {
		this.no = no;
	}

	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "OrderItem [No=" + no + ", BookNo=" + bookNo + ", Price=" + price + ", Amount=" + amount + "]";
	}

	
}
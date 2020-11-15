package kr.co.hta.vo;

public class OrderItem {
	long No;
	long BookNo;
	long Price;
	long Amount;
	
	public OrderItem () {}

	public long getNo() {
		return No;
	}

	public void setNo(long no) {
		No = no;
	}

	public long getBookNo() {
		return BookNo;
	}

	public void setBookNo(long bookNo) {
		BookNo = bookNo;
	}

	public long getPrice() {
		return Price;
	}

	public void setPrice(long price) {
		Price = price;
	}

	public long getAmount() {
		return Amount;
	}

	public void setAmount(long amount) {
		Amount = amount;
	}

	@Override
	public String toString() {
		return "OrderItem [No=" + No + ", BookNo=" + BookNo + ", Price=" + Price + ", Amount=" + Amount + "]";
	}

	
}
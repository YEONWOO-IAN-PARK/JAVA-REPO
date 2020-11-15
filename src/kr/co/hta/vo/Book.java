package kr.co.hta.vo;

import java.util.Date;

public class Book {

	private long no;
	private String title;
	private String writer;
	private String genre;
	private long price;
	private long stock;
	private String status;
	private Date createDate;
	
	public Book() {}
	
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public long getStock() {
		return stock;
	}
	public void setStock(long stock) {
		this.stock = stock;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	@Override
	public String toString() {
		return "Book [no=" + no + ", title=" + title + ", writer=" + writer + ", genre=" + genre + ", price=" + price
				+ ", stock=" + stock + ", status=" + status + ", createDate=" + createDate + "]";
	}
	
	
}

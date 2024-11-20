package com.seiryo.entity;

/**
 * @ClassName: BookInfo
 * @Description: 书籍实体类
 * @author JY
 */
public class BookInfo {
	
	//书籍ID
	private Integer bookId;
	
	//书籍名称
	private String bookName;
	
	//书籍介绍
	private String bookIntroduce;
	
	//书籍封面
	private String bookCover;
	
	//书籍状态0/1
	private String bookStatus;
	
	//书籍种类
	private String bookType;
	
	//书籍还书按钮显示
	private Integer bookReturnButton;

	//get和set方法
	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookIntroduce() {
		return bookIntroduce;
	}

	public void setBookIntroduce(String bookIntroduce) {
		this.bookIntroduce = bookIntroduce;
	}

	public String getBookCover() {
		return bookCover;
	}

	public void setBookCover(String bookCover) {
		this.bookCover = bookCover;
	}

	public String getBookStatus() {
		return bookStatus;
	}

	public void setBookStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}

	public String getBookType() {
		return bookType;
	}

	public void setBookType(String bookType) {
		this.bookType = bookType;
	}

	public Integer getBookReturnButton() {
		return bookReturnButton;
	}

	public void setBookReturnButton(Integer bookReturnButton) {
		this.bookReturnButton = bookReturnButton;
	}

	/**
	 * BookInfoの初期設定をおこなう（コンストラクタ）
	 *
	 * @param bookId
	 * @param bookName
	 * @param bookIntroduce
	 * @param bookCover
	 * @param bookStatus
	 * @param bookType
	 */
	public BookInfo(Integer bookId, String bookName, String bookIntroduce, String bookCover, String bookStatus,
			String bookType) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookIntroduce = bookIntroduce;
		this.bookCover = bookCover;
		this.bookStatus = bookStatus;
		this.bookType = bookType;
	}

	/**
	 * BookInfoの初期設定をおこなう（コンストラクタ）
	 *
	 * @param bookId
	 * @param bookName
	 * @param bookIntroduce
	 * @param bookCover
	 * @param bookStatus
	 * @param bookType
	 * @param bookReturnButton
	 */
	public BookInfo(Integer bookId, String bookName, String bookIntroduce, String bookCover, String bookStatus,
			String bookType, Integer bookReturnButton) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookIntroduce = bookIntroduce;
		this.bookCover = bookCover;
		this.bookStatus = bookStatus;
		this.bookType = bookType;
		this.bookReturnButton = bookReturnButton;
	}

	/**
	 * BookInfoの初期設定をおこなう（コンストラクタ）
	 */
	public BookInfo() {
		super();
	}

	/**
	 * toString方法
	 */
	public String toString() {
		return "BookInfo [bookId=" + bookId + ", bookName=" + bookName + ", bookIntroduce=" + bookIntroduce
				+ ", bookCover=" + bookCover + ", bookStatus=" + bookStatus + ", bookType=" + bookType + "]";
	}
	
}

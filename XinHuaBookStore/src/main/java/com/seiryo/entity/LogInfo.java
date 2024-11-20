package com.seiryo.entity;

/**
 * @ClassName: LogInfo
 * @Description: 日志实体类
 * @author JY
 */
public class LogInfo {
	
	//日志ID
	private Integer logId;
	
	//用户ID
	private Integer logUserId;
	
	//书籍ID
	private Integer logBookId;
	
	//借书时间
	private String logBorrowingTime;
	
	//还书时间
	private String logBookReturnTime;

	//get和set方法
	public Integer getLogId() {
		return logId;
	}

	public void setLogId(Integer logId) {
		this.logId = logId;
	}

	public Integer getLogUserId() {
		return logUserId;
	}

	public void setLogUserId(Integer logUserId) {
		this.logUserId = logUserId;
	}

	public Integer getLogBookId() {
		return logBookId;
	}

	public void setLogBookId(Integer logBookId) {
		this.logBookId = logBookId;
	}

	public String getLogBorrowingTime() {
		return logBorrowingTime;
	}

	public void setLogBorrowingTime(String logBorrowingTime) {
		this.logBorrowingTime = logBorrowingTime;
	}

	public String getLogBookReturnTime() {
		return logBookReturnTime;
	}

	public void setLogBookReturnTime(String logBookReturnTime) {
		this.logBookReturnTime = logBookReturnTime;
	}

	/**
	 * LogInfoの初期設定をおこなう（コンストラクタ）
	 *
	 * @param logId
	 * @param logUserId
	 * @param logBookId
	 * @param logBorrowingTime
	 * @param logBookReturnTime
	 */
	public LogInfo(Integer logId, Integer logUserId, Integer logBookId, String logBorrowingTime,
			String logBookReturnTime) {
		super();
		this.logId = logId;
		this.logUserId = logUserId;
		this.logBookId = logBookId;
		this.logBorrowingTime = logBorrowingTime;
		this.logBookReturnTime = logBookReturnTime;
	}

	/**
	 * LogInfoの初期設定をおこなう（コンストラクタ）
	 */
	public LogInfo() {
		super();
	}

	/**
	 * toString方法
	 */
	public String toString() {
		return "LogInfo [logId=" + logId + ", logUserId=" + logUserId + ", logBookId=" + logBookId
				+ ", logBorrowingTime=" + logBorrowingTime + ", logBookReturnTime=" + logBookReturnTime + "]";
	}

}

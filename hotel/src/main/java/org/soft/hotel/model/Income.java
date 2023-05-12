package org.soft.hotel.model;

public class Income {

	private int incomeId;  //收入记录id             
	private int roomTypeId; //房间类型id       
	private int staffId;    //员工id 
	private double incomeMoney; //收入金额
	private int incomeType;    //收入类型 0代表房费收入，1代表预订押金收入,
	private String incomeTime;//收入时间
	public int paymentMethod; //支付方式0代表现金支付，1代表扫码支付，2代表刷卡支付
	private String staffName; //员工姓名
	private String roomtypeName; //房间类型名
	
	
	public Income () {
		
	}

	public Income(int incomeId, int roomTypeId, int staffId, double incomeMoney, int incomeType, String incomeTime,
			int paymentMethod, String staffName, String roomtypeName) {
		this.incomeId = incomeId;
		this.roomTypeId = roomTypeId;
		this.staffId = staffId;
		this.incomeMoney = incomeMoney;
		this.incomeType = incomeType;
		this.incomeTime = incomeTime;
		this.paymentMethod = paymentMethod;
		this.staffName = staffName;
		this.roomtypeName = roomtypeName;
	}

	public int getIncomeId() {
		return incomeId;
	}

	public void setIncomeId(int incomeId) {
		this.incomeId = incomeId;
	}

	public int getRoomTypeId() {
		return roomTypeId;
	}

	public void setRoomTypeId(int roomTypeId) {
		this.roomTypeId = roomTypeId;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public double getIncomeMoney() {
		return incomeMoney;
	}

	public void setIncomeMoney(double incomeMoney) {
		this.incomeMoney = incomeMoney;
	}

	public int getIncomeType() {
		return incomeType;
	}

	public void setIncomeType(int incomeType) {
		this.incomeType = incomeType;
	}

	public String getIncomeTime() {
		return incomeTime;
	}

	public void setIncomeTime(String incomeTime) {
		this.incomeTime = incomeTime;
	}

	public int getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(int paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getRoomtypeName() {
		return roomtypeName;
	}

	public void setRoomtypeName(String roomtypeName) {
		this.roomtypeName = roomtypeName;
	}
	
}

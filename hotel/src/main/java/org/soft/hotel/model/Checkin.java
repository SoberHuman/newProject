package org.soft.hotel.model;

/**
 * 入住记录
 * @author Administrator
 *
 */
public class Checkin {

	private int checkinId;//入住记录id
	private int roomTypeId;  //房间类型id
	private int roomId; //房间id
	private int staffId;//员工id
	private int usersId;//会员id
	private int clientId;//普通客户id
	private String checkinTime;//入住时间
	private String departureTime;//预离时间
	private int checkinDay;//入住天数
	private double checkinForegift;//所交押金
	private int roomNumber; //房间号
	private String staffName; //员工姓名
	private String checkInName; //入住人姓名
	private String checkInIdCard; //入住人身份证号
	private String checkInPhone; //入住人手机号
	private String clientName;  //客户姓名
	private String clientIdCard;//客户身份证号
	private String clientPhone;//客户手机号
	private String userRealName; //会员真实姓名
	private String userIdCard; //会员身份证号
	private String userPhone; //会员手机号
	
	public Checkin() {
		
	}

	public Checkin(int checkinId, int roomTypeId, int roomId, int staffId, int usersId, int clientId,
			String checkinTime, String departureTime, int checkinDay, double checkinForegift, int roomNumber,
			String staffName, String checkInName, String checkInIdCard, String checkInPhone, String clientName,
			String clientIdCard, String clientPhone, String userRealName, String userIdCard, String userPhone) {
		this.checkinId = checkinId;
		this.roomTypeId = roomTypeId;
		this.roomId = roomId;
		this.staffId = staffId;
		this.usersId = usersId;
		this.clientId = clientId;
		this.checkinTime = checkinTime;
		this.departureTime = departureTime;
		this.checkinDay = checkinDay;
		this.checkinForegift = checkinForegift;
		this.roomNumber = roomNumber;
		this.staffName = staffName;
		this.checkInName = checkInName;
		this.checkInIdCard = checkInIdCard;
		this.checkInPhone = checkInPhone;
		this.clientName = clientName;
		this.clientIdCard = clientIdCard;
		this.clientPhone = clientPhone;
		this.userRealName = userRealName;
		this.userIdCard = userIdCard;
		this.userPhone = userPhone;
	}

	public int getCheckinId() {
		return checkinId;
	}

	public void setCheckinId(int checkinId) {
		this.checkinId = checkinId;
	}

	public int getRoomTypeId() {
		return roomTypeId;
	}

	public void setRoomTypeId(int roomTypeId) {
		this.roomTypeId = roomTypeId;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public int getUsersId() {
		return usersId;
	}

	public void setUsersId(int usersId) {
		this.usersId = usersId;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getCheckinTime() {
		return checkinTime;
	}

	public void setCheckinTime(String checkinTime) {
		this.checkinTime = checkinTime;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public int getCheckinDay() {
		return checkinDay;
	}

	public void setCheckinDay(int checkinDay) {
		this.checkinDay = checkinDay;
	}

	public double getCheckinForegift() {
		return checkinForegift;
	}

	public void setCheckinForegift(double checkinForegift) {
		this.checkinForegift = checkinForegift;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getCheckInName() {
		return checkInName;
	}

	public void setCheckInName(String checkInName) {
		this.checkInName = checkInName;
	}

	public String getCheckInIdCard() {
		return checkInIdCard;
	}

	public void setCheckInIdCard(String checkInIdCard) {
		this.checkInIdCard = checkInIdCard;
	}

	public String getCheckInPhone() {
		return checkInPhone;
	}

	public void setCheckInPhone(String checkInPhone) {
		this.checkInPhone = checkInPhone;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientIdCard() {
		return clientIdCard;
	}

	public void setClientIdCard(String clientIdCard) {
		this.clientIdCard = clientIdCard;
	}

	public String getClientPhone() {
		return clientPhone;
	}

	public void setClientPhone(String clientPhone) {
		this.clientPhone = clientPhone;
	}

	public String getUserRealName() {
		return userRealName;
	}

	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}

	public String getUserIdCard() {
		return userIdCard;
	}

	public void setUserIdCard(String userIdCard) {
		this.userIdCard = userIdCard;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}	
}

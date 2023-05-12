package org.soft.hotel.model;

/**
 * 预订记录
 * @author Administrator
 *
 */
public class Reservation{
	private int reservationId; //预订id
	private int roomId; //房间id
	private int roomTypeId; //房间类型Id
	private int staffId; //员工id
	private String reservationName; //预订人姓名
	private String reservationIdCard; //预订人身份证号
	private String reservationPhoneNumber; //预订人电话号码
	private String reservationTime; //预订时间
	private String expectedTimeOfArrival; //预计到店时间
	private String estimatedTimeOfDeparture; //预计离开时间
	private String unsubscribeTime; //退订时间
	private int reservationOccupancyDays;//入住天数
	private int reservationStatus;//预订状态  0代表未入住，1代表已入住，2代表已退订,3代表未处理客户预订订单
	private double reservationForegift;//押金
	private double unsubscribeForegift;//已退押金
	private String roomNumber; //房间号
	private String roomTypeName; //房间类型名
	private String staffName; //员工姓名


	private RoomType roomType;




	public Reservation() {
		
	}

	public Reservation(int reservationId, int roomId, int roomTypeId, int staffId, String reservationName,
			String reservationIdCard, String reservationPhoneNumber, String reservationTime,
			String expectedTimeOfArrival,String estimatedTimeOfDeparture, String unsubscribeTime, int reservationOccupancyDays, int reservationStatus,
			double reservationForegift, double unsubscribeForegift, String roomNumber, String roomTypeName,
			String staffName) {
		this.reservationId = reservationId;
		this.roomId = roomId;
		this.roomTypeId = roomTypeId;
		this.staffId = staffId;
		this.reservationName = reservationName;
		this.reservationIdCard = reservationIdCard;
		this.reservationPhoneNumber = reservationPhoneNumber;
		this.reservationTime = reservationTime;
		this.expectedTimeOfArrival = expectedTimeOfArrival;
		this.estimatedTimeOfDeparture = estimatedTimeOfDeparture;
		this.unsubscribeTime = unsubscribeTime;
		this.reservationOccupancyDays = reservationOccupancyDays;
		this.reservationStatus = reservationStatus;
		this.reservationForegift = reservationForegift;
		this.unsubscribeForegift = unsubscribeForegift;
		this.roomNumber = roomNumber;
		this.roomTypeName = roomTypeName;
		this.staffName = staffName;
	}

	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
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

	public String getReservationName() {
		return reservationName;
	}

	public void setReservationName(String reservationName) {
		this.reservationName = reservationName;
	}

	public String getReservationIdCard() {
		return reservationIdCard;
	}

	public void setReservationIdCard(String reservationIdCard) {
		this.reservationIdCard = reservationIdCard;
	}

	public String getReservationPhoneNumber() {
		return reservationPhoneNumber;
	}

	public void setReservationPhoneNumber(String reservationPhoneNumber) {
		this.reservationPhoneNumber = reservationPhoneNumber;
	}

	public String getReservationTime() {
		return reservationTime;
	}

	public void setReservationTime(String reservationTime) {
		this.reservationTime = reservationTime;
	}

	public String getExpectedTimeOfArrival() {
		return expectedTimeOfArrival;
	}

	public void setExpectedTimeOfArrival(String expectedTimeOfArrival) {
		this.expectedTimeOfArrival = expectedTimeOfArrival;
	}

	public String getEstimatedTimeOfDeparture() {
		return estimatedTimeOfDeparture;
	}

	public void setEstimatedTimeOfDeparture(String estimatedTimeOfDeparture) {
		this.estimatedTimeOfDeparture = estimatedTimeOfDeparture;
	}


	public String getUnsubscribeTime() {
		return unsubscribeTime;
	}

	public void setUnsubscribeTime(String unsubscribeTime) {
		this.unsubscribeTime = unsubscribeTime;
	}

	public int getReservationOccupancyDays() {
		return reservationOccupancyDays;
	}

	public void setReservationOccupancyDays(int reservationOccupancyDays) {
		this.reservationOccupancyDays = reservationOccupancyDays;
	}

	public int getReservationStatus() {
		return reservationStatus;
	}

	public void setReservationStatus(int reservationStatus) {
		this.reservationStatus = reservationStatus;
	}

	public double getReservationForegift() {
		return reservationForegift;
	}

	public void setReservationForegift(double reservationForegift) {
		this.reservationForegift = reservationForegift;
	}

	public double getUnsubscribeForegift() {
		return unsubscribeForegift;
	}

	public void setUnsubscribeForegift(double unsubscribeForegift) {
		this.unsubscribeForegift = unsubscribeForegift;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getRoomTypeName() {
		return roomTypeName;
	}

	public void setRoomTypeName(String roomTypeName) {
		this.roomTypeName = roomTypeName;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}



	public RoomType getRoomType(){
		return roomType;
	}
	public void setRoomType(RoomType roomType){
		this.roomType = roomType;
	}

}

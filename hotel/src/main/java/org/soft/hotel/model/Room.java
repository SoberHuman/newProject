package org.soft.hotel.model;

/**
 * 房间信息
 * @author Administrator
 *
 */
public class Room {

	private int roomId;
	private int roomTypeId;  //房间类型id
	private String roomNumber; //房间号
	private int roomSanitation; //客房情况 0代表已打扫，1代表脏房，2代表维修中
	private int roomStatus;  //状态 0代表空闲，1代表已预订，2代表已入住
	private String roomStorey;  //楼层
	private String roomWindow; //窗户
	private String roomBed;  //床型
	private int roomGuestNumber; //可入住人数
	private String roomFacility;  //房间设施
	private String roomTypeName; //房间类型名

	
	public Room() {
		
	}
	
	public Room(int roomId, int roomTypeId, String roomNumber, int roomSanitation, int roomStatus, String roomStorey,
			String roomWindow, String roomBed, int roomGuestNumber, String roomFacility,
			String roomTypeName) {
		this.roomId = roomId;
		this.roomTypeId = roomTypeId;
		this.roomNumber = roomNumber;
		this.roomSanitation = roomSanitation;
		this.roomStatus = roomStatus;
		this.roomStorey = roomStorey;
		this.roomWindow = roomWindow;
		this.roomBed = roomBed;
		this.roomGuestNumber = roomGuestNumber;
		this.roomFacility = roomFacility;
		this.roomTypeName = roomTypeName;
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
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public int getRoomSanitation() {
		return roomSanitation;
	}
	public void setRoomSanitation(int roomSanitation) {
		this.roomSanitation = roomSanitation;
	}
	public int getRoomStatus() {
		return roomStatus;
	}
	public void setRoomStatus(int roomStatus) {
		this.roomStatus = roomStatus;
	}
	public String getRoomStorey() {
		return roomStorey;
	}
	public void setRoomStorey(String roomStorey) {
		this.roomStorey = roomStorey;
	}
	public String getRoomWindow() {
		return roomWindow;
	}
	public void setRoomWindow(String roomWindow) {
		this.roomWindow = roomWindow;
	}
	public String getRoomBed() {
		return roomBed;
	}
	public void setRoomBed(String roomBed) {
		this.roomBed = roomBed;
	}
	public int getRoomGuestNumber() {
		return roomGuestNumber;
	}
	public void setRoomGuestNumber(int roomGuestNumber) {
		this.roomGuestNumber = roomGuestNumber;
	}
	public String getRoomFacility() {
		return roomFacility;
	}
	public void setRoomFacility(String roomFacility) {
		this.roomFacility = roomFacility;
	}
	public String getRoomTypeName() {
		return roomTypeName;
	}
	public void setRoomTypeName(String roomTypeName) {
		this.roomTypeName = roomTypeName;
	}


}

package org.soft.hotel.model;

/**
 * 房价表
 * 
 * @author Administrator
 *
 */
public class Roomrate {

	private int roomrateId;
	private int roomTypeId; // 房间类型id
	private double listPrice; // 挂牌价
	private double individualPrice; // 散客价
	private double vipPrice; // 会员价
	private double roomTypeArea; // 面积
	private int roomTypeStatus; // 状态
	private String roomTypeName; // 类型名

	public Roomrate() {

	}

	public Roomrate(int roomrateId, int roomTypeId, double listPrice, double individualPrice, double vipPrice,
			double roomTypeArea, int roomTypeStatus, String roomTypeName) {
		this.roomrateId = roomrateId;
		this.roomTypeId = roomTypeId;
		this.listPrice = listPrice;
		this.individualPrice = individualPrice;
		this.vipPrice = vipPrice;
		this.roomTypeArea = roomTypeArea;
		this.roomTypeStatus = roomTypeStatus;
		this.roomTypeName = roomTypeName;
	}

	public int getRoomrateId() {
		return roomrateId;
	}

	public void setRoomrateId(int roomrateId) {
		this.roomrateId = roomrateId;
	}

	public int getRoomTypeId() {
		return roomTypeId;
	}

	public void setRoomTypeId(int roomTypeId) {
		this.roomTypeId = roomTypeId;
	}

	public double getListPrice() {
		return listPrice;
	}

	public void setListPrice(double listPrice) {
		this.listPrice = listPrice;
	}

	public double getIndividualPrice() {
		return individualPrice;
	}

	public void setIndividualPrice(double individualPrice) {
		this.individualPrice = individualPrice;
	}

	public double getVipPrice() {
		return vipPrice;
	}

	public void setVipPrice(double vipPrice) {
		this.vipPrice = vipPrice;
	}

	public double getRoomTypeArea() {
		return roomTypeArea;
	}

	public void setRoomTypeArea(double roomTypeArea) {
		this.roomTypeArea = roomTypeArea;
	}

	public int getRoomTypeStatus() {
		return roomTypeStatus;
	}

	public void setRoomTypeStatus(int roomTypeStatus) {
		this.roomTypeStatus = roomTypeStatus;
	}

	public String getRoomTypeName() {
		return roomTypeName;
	}

	public void setRoomTypeName(String roomTypeName) {
		this.roomTypeName = roomTypeName;
	}

}

package org.soft.hotel.model;

/**
 * 维修记录
 * @author Administrator
 *
 */
public class Maintain {

	private int maintainId; //维修记录id
	private int roomId; //房间内id
	private int staffId; // 员工id
	private String maintainCause; //维修原因
	private String maintainStartTime; //维修时间
	private String maintainFinishTime; //完成时间
	private int maintainStatus; //维修状态
	private String maintainResult; //维修结果
	private String staffName;  //员工姓名
	private int roomNumber; // 房间号
	
	public Maintain() {
		
	}
	
	public Maintain(int maintainId, int roomId, int staffId, String maintainCause, String maintainStartTime,
			String maintainFinishTime, int maintainStatus, String maintainResult, String staffName, int roomNumber) {
		this.maintainId = maintainId;
		this.roomId = roomId;
		this.staffId = staffId;
		this.maintainCause = maintainCause;
		this.maintainStartTime = maintainStartTime;
		this.maintainFinishTime = maintainFinishTime;
		this.maintainStatus = maintainStatus;
		this.maintainResult = maintainResult;
		this.staffName = staffName;
		this.roomNumber = roomNumber;
	}

	public int getMaintainId() {
		return maintainId;
	}

	public void setMaintainId(int maintainId) {
		this.maintainId = maintainId;
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

	public String getMaintainCause() {
		return maintainCause;
	}

	public void setMaintainCause(String maintainCause) {
		this.maintainCause = maintainCause;
	}

	public String getMaintainStartTime() {
		return maintainStartTime;
	}

	public void setMaintainStartTime(String maintainStartTime) {
		this.maintainStartTime = maintainStartTime;
	}

	public String getMaintainFinishTime() {
		return maintainFinishTime;
	}

	public void setMaintainFinishTime(String maintainFinishTime) {
		this.maintainFinishTime = maintainFinishTime;
	}

	public int getMaintainStatus() {
		return maintainStatus;
	}

	public void setMaintainStatus(int maintainStatus) {
		this.maintainStatus = maintainStatus;
	}

	public String getMaintainResult() {
		return maintainResult;
	}

	public void setMaintainResult(String maintainResult) {
		this.maintainResult = maintainResult;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	
}

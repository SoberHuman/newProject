package org.soft.hotel.server;

import java.util.List;

import org.soft.hotel.dao.RoomDAO;
import org.soft.hotel.model.Room;
import org.soft.hotel.model.RoomType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 客房模块
 * @author Administrator
 *
 */
@Controller("RoomServer")
public class RoomServer {

	@Autowired
	private RoomDAO roomDAO;
	
	/**
	 * 新增房间
	 * @param room
	 * @return
	 */
	public boolean newRoom(Room room) {
		boolean b = roomDAO.newRoom(room);
		return b;
	}
	
	/**
	 * 修改房间信息
	 * @param room
	 * @return
	 */
	public boolean updateRoom(Room room) {
		boolean b = roomDAO.updateRoom(room);
		return b;
	}
	
	/**
	 * 删除房间
	 * @param roomId
	 * @return
	 */
	public boolean deleteRoom(int roomId) {
		boolean b = roomDAO.deleteRoom(roomId);
		return b;
	}
	
	/**
	 * 查询指定房间类型的房间id和类型名
	 * @param roomTypeId
	 * @return
	 */
	public RoomType showRoomType(int roomTypeId){
		RoomType roomType = roomDAO.showRoomType(roomTypeId);
		return roomType;
	}
	
	/**
	 * 查询指定房间类型的所有房间
	 * @param roomTypeId
	 * @return
	 */
	public List<Room> showAllRoom(int roomTypeId){
		List<Room> rooms = roomDAO.showAllRoom(roomTypeId);
		return rooms;
	}
	/**
	 * 输入框搜索房间
	 * @param roomNumber
	 * @return
	 */
	public List<Room> inputShowRoom(String roomNumber){
		List<Room> rooms = roomDAO.inputShowRoom(roomNumber);
		return rooms;
	}
	/**
	 * 查看房间信息明细
	 */
	public Room showRoom(int roomId) {
		Room room = roomDAO.showRoom(roomId);
		return room;
	}
	
	/**
	 * 修改房间情况
	 * @param roomSanitation
	 * @param roomId
	 * @return
	 */
	public boolean updateRoomSanitation(int roomSanitation,int roomId) {
		boolean b = roomDAO.updateRoomSanitation(roomSanitation, roomId);
		return b;
	}
	
	/**
	 * 修改房间状态
	 * @param roomStatus
	 * @param roomId
	 * @return
	 */
	public boolean updateRoomStatus(int roomStatus,int roomId) {
		boolean b = roomDAO.updateRoomStatus(roomStatus, roomId);
		return b;
	}
	
	/**
	 * 通过房间id查询房间类型id
	 * @param roomTypeId
	 * @return
	 */
	public int showRoomTypeId(int roomId) {
		int roomTypeId = roomDAO.showRoomTypeId(roomId);
		return roomTypeId;
	}
	
	/**
	 * 通过房间号查询房间类型Id和房间Id
	 * @param roomTypeId
	 * @return
	 */
	public Room showRoomTypeIdAndRoomId(String roomNumbers) {
		Room room =  roomDAO.showRoomTypeIdAndRoomId(roomNumbers);
		return room;
	}
	
	/**
	 * 统计全部房间
	 * @return
	 */
	public int countRoom() {
		int countRoomRoom = roomDAO.countRoom();
		return countRoomRoom;
	}
	
	/**
	 * 统计预订房间
	 * @return
	 */
	public int countReservation() {
		int countReservation = roomDAO.countReservation();
		return countReservation;
	}
	
	/**
	 * 统计已入住房间
	 * @return
	 */
	public int countCheckin() {
		int countCheckin = roomDAO.countCheckin();
		return countCheckin;
	}
	
	/**
	 * 统计空闲房间
	 * @return
	 */
	public int countFree() {
		int countFree = roomDAO.countFree();
		return countFree;
	}
	
	/**
	 * 统计未打扫房间
	 * @return
	 */
	public int countNotCleaned() {
		int countNotCleaned = roomDAO.countNotCleaned();
		return countNotCleaned;
	}
	
	/**
	 * 统计维修中房间
	 * @return
	 */
	public int countRepair() {
		int countRepair = roomDAO.countRepair();
		return countRepair;
	}
	
	/**
	 * 统计指定房间类型的全部房间
	 * @param roomTypeId
	 * @return
	 */
	public int countRoomType(int roomTypeId) {
		int countRoomType = roomDAO.countRoomType(roomTypeId);
		return countRoomType;
	}
	
	/**
	 * 统计指定房间类型的已预订房间
	 * @param roomTypeId
	 * @return
	 */
	public int countReservationRoomType(int roomTypeId) {
		int countReservationRoomType = roomDAO.countReservationRoomType(roomTypeId);
		return countReservationRoomType;
	}
	
	/**
	 * 统计指定房间类型的已入住房间
	 * @param roomTypeId
	 * @return
	 */
	public int countCheckinRoomType(int roomTypeId) {
		int countCheckinRoomType = roomDAO.countCheckinRoomType(roomTypeId);
		return countCheckinRoomType;
	}
	
	/**
	 * 统计指定房间类型的空闲房间
	 * @param roomTypeId
	 * @return
	 */
	public int countFreeRoomType(int roomTypeId) {
		int countFreeRoomType = roomDAO.countFreeRoomType(roomTypeId);
		return countFreeRoomType;
	}
	
	/**
	 * 统计指定房间类型的未打扫房间
	 * @param roomTypeId
	 * @return
	 */
	public int countNotCleanedRoomType(int roomTypeId) {
		int countNotCleanedRoomType = roomDAO.countNotCleanedRoomType(roomTypeId);
		return countNotCleanedRoomType;
	}
	
	/**
	 * 统计指定房间类型的维修中房间
	 * @param roomTypeId
	 * @return
	 */
	public int countRepairRoomType(int roomTypeId) {
		int countRepairRoomType = roomDAO.countRepairRoomType(roomTypeId);
		return countRepairRoomType;
	}
	
	/**
	 * 查询各状态房间
	 * @return
	 */
	public List<Room> showRoomStruts(int roomStatus,int roomSanitation){
		List<Room> rooms = roomDAO.showRoomStruts(roomStatus,roomSanitation);
		return rooms;
	}
	
	/**
	 * 查询各房间情况
	 * @return
	 */
	public List<Room> showRoomSanitation(int roomSanitation){
		List<Room> rooms = roomDAO.showRoomSanitation(roomSanitation);
		return rooms;
	}
	
	/**
	 * 查询指定房间类型的各状态房间
	 * @return
	 */
	public List<Room> showRoomTypeStruts(int roomStatus,int roomSanitation,int roomTypeId){
		List<Room> rooms = roomDAO.showRoomTypeStruts(roomStatus, roomSanitation, roomTypeId);
		return rooms;
	}
	
	/**
	 * 查询指定房间类型的各房间情况
	 * @return
	 */
	public List<Room> showRoomTypeSanitation(int roomSanitation,int roomTypeId){
		List<Room> rooms = roomDAO.showRoomTypeSanitation(roomSanitation, roomTypeId);
		return rooms;
	}
	
	/**
	 * 查询今日退房房间
	 * @return
	 */
	public List<Room> showRoomNowCheckOut(){
		List<Room> rooms = roomDAO.showRoomNowCheckOut();
		return rooms;
	}
}

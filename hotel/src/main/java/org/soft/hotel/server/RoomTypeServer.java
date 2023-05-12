package org.soft.hotel.server;

import java.util.List;
import org.soft.hotel.dao.RoomTypeDAO;
import org.soft.hotel.model.Room;
import org.soft.hotel.model.RoomType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller("RoomTypeServer")
public class RoomTypeServer {

	@Autowired
	private RoomTypeDAO roomTypeDAO;
	
	/**
	 * 新增房间类型
	 * @param roomType
	 * @return
	 */
	public boolean NewRoomType(RoomType roomType) { 
		boolean b = roomTypeDAO.NewRoomType(roomType);
		return b;
	}
	
	/**
	 * 修改房间类型
	 * @param roomType
	 * @return
	 */
	public boolean UpdateRoomType(RoomType roomType) {
		boolean b = roomTypeDAO.UpdateRoomType(roomType);
		return b;
	}
	
	/**
	 * 新增或者修改房间类型后查询房间类型ID来添加房间类型图片url
	 * @return
	 */
	public int showRoomTypeId() {
		int roomTypeId = roomTypeDAO.showRoomTypeId();
		return roomTypeId;
	}
	
	/**
	 * 新增或者修改房间类型后通过房间类型Id修改房间类型图片url
	 * @return
	 */
	public boolean updateRoomTypeImageUrl(String roomTypeImageUrl, int roomTypeId) {
		boolean b = roomTypeDAO.updateRoomTypeImageUrl(roomTypeImageUrl, roomTypeId);
		return b;
	}

	/**
	 * 所有干净且空闲的房间
	 */
	public List<Room> queryNullRoom(int roomTypeId){
		List<Room> rooms = roomTypeDAO.selectNullroom(roomTypeId);
		return rooms;
	}


	/**
	 * 删除房间类型
	 * @param roomTypeId
	 * @return
	 */
	public boolean DeleteRoomType(int roomTypeId) {
		boolean b = roomTypeDAO.DeleteRoomType(roomTypeId);
		return b;
	}
	/**
	 * 查看房间类型信息
	 * @return
	 */
	public RoomType ShowRoomType(int roomTypeId){
		RoomType roomType = roomTypeDAO.ShowRoomType(roomTypeId);
		return roomType;
	}
	
	/**
	 * 查看所有房间类型
	 * @return
	 */
	public List<RoomType> ShowAllRoomType(){
		List<RoomType> roomTypes = roomTypeDAO.ShowAllRoomType();
		return roomTypes;
	}
	
	/**
	 * 查看房价
	 * @return
	 */
	public RoomType ShowRoomTypePrice(int roomTypeId) {
		RoomType roomType = roomTypeDAO.ShowRoomTypePrice(roomTypeId);
		return roomType;
	}
	
	/**
	 * 查看所有房间类型Id和名字
	 * @return
	 */
	public List<RoomType> ShowAllRoomTypeIdAndName(){
		List<RoomType> roomTypes = roomTypeDAO.ShowAllRoomTypeIdAndName();
		return roomTypes;
	}
}

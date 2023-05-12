package org.soft.hotel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.soft.hotel.model.Room;
import org.soft.hotel.model.RoomType;
import org.soft.hotel.querySql.roomQuery;

/**
 * 房间模块
 * @author Administrator
 *
 */
@Mapper
public interface RoomDAO {

	/**
	 * 新增房间
	 * @param room
	 * @return
	 */
	@Insert("insert into room(roomTypeId,roomNumber,roomSanitation,roomStatus,roomStorey,"
			+ "roomWindow,roomBed,roomGuestNumber,roomFacility) "
			+ "value(#{roomTypeId},#{roomNumber},#{roomSanitation},#{roomStatus},#{roomStorey},"
			+ "#{roomWindow},#{roomBed},#{roomGuestNumber},#{roomFacility})")
	public boolean newRoom(Room room);
	
	/**
	 * 修改房间信息
	 * @param room
	 * @return
	 */
	@Update("update room set roomTypeId=#{roomTypeId},roomNumber=#{roomNumber},roomSanitation=#{roomSanitation},"
			+ "roomStatus=#{roomStatus},roomStorey=#{roomStorey},roomWindow=#{roomWindow},"
			+ "roomBed=#{roomBed},roomGuestNumber=#{roomGuestNumber},roomFacility=#{roomFacility}"
			+ "where roomId = #{roomId}")
	public boolean updateRoom(Room room);
	
	/**
	 * 删除房间
	 * @param roomId
	 * @return
	 */
	@Delete("delete from room where roomId = #{roomId}")
	public boolean deleteRoom(int roomId);
	
	/**
	 * 查询指定房间类型的房间id和类型名
	 * @param roomTypeId
	 * @return
	 */
	@Select("select * from roomType where roomTypeId = #{roomTypeId}")
	public RoomType showRoomType(int roomTypeId);
	
	/**
	 * 查询指定房间类型的所有房间
	 * @param roomTypeId
	 * @return
	 */
	@Select("select r.roomId,r.roomNumber,r.roomSanitation,r.roomStatus,rt.roomTypeName,r.roomTypeId "
			+ "from room r inner join roomType rt on r.roomTypeId = rt.roomTypeId where rt.roomTypeId = #{roomTypeId}")
	public List<Room> showAllRoom(int roomTypeId);
	
	/**
	 * 输入框搜索房间
	 * @param roomNumber
	 * @return
	 */
	@SelectProvider(value = roomQuery.class,method = "inputShowRoom")
	public List<Room> inputShowRoom(String roomNumber);
	
	/**
	 * 查看房间信息明细
	 */
	@Select("select r.*,rt.roomTypeName from room r inner join roomType rt on r.roomTypeId = rt.roomTypeId "
			+ "where roomId = #{roomId}")
	public Room showRoom(int roomId);
	
	/**
	 * 修改房间情况
	 * @param roomSanitation
	 * @param roomId
	 * @return
	 */
	@Update("update room set roomSanitation = #{roomSanitation} where roomId = #{roomId}")
	public boolean updateRoomSanitation(int roomSanitation,int roomId);		
	
	/**
	 * 修改房间状态
	 * @param roomStatus
	 * @param roomId
	 * @return
	 */
	@Update("update room set roomStatus = #{roomStatus} where roomId = #{roomId}")
	public boolean updateRoomStatus(int roomStatus,int roomId);	
	
	/**
	 * 通过房间Id查询房间类型Id
	 * @param roomTypeId
	 * @return
	 */
	@Select("select roomTypeId from room where roomId = #{roomId}")
	public int showRoomTypeId(int roomId);
	
	/**
	 * 通过房间号查询房间类型Id和房间Id
	 * @param roomTypeId
	 * @return
	 */
	@Select("select roomId,roomTypeId from room where roomNumber = #{roomNumber}")
	public Room showRoomTypeIdAndRoomId(String roomNumbers);
	
	/**
	 * 统计全部房间
	 * @return
	 */
	@Select("select count(*) from room")
	public int countRoom();
	
	/**
	 * 统计预订房间
	 * @return
	 */
	@Select("select count(*) from room where roomStatus = 1 and roomSanitation = 0")
	public int countReservation();
	
	/**
	 * 统计已入住房间
	 * @return
	 */
	@Select("select count(*) from room where roomStatus = 2 and roomSanitation = 0")
	public int countCheckin();
	
	/**
	 * 统计空闲房间
	 * @return
	 */
	@Select("select count(*) from room where roomStatus = 0 and roomSanitation = 0")
	public int countFree();
	
	/**
	 * 统计未打扫房间
	 * @return
	 */
	@Select("select count(*) from room where  roomSanitation = 1")
	public int countNotCleaned();
	
	/**
	 * 统计维修中房间
	 * @return
	 */
	@Select("select count(*) from room where  roomSanitation = 2")
	public int countRepair();
	
	/**
	 * 统计指定房间类型的全部房间
	 * @param roomTypeId
	 * @return
	 */
	@Select("select count(*) from room where roomTypeId = #{roomTypeId}")
	public int countRoomType(int roomTypeId);
	
	/**
	 * 统计指定房间类型的已预订房间
	 * @param roomTypeId
	 * @return
	 */
	@Select("select count(*) from room where roomTypeId = #{roomTypeId} and roomStatus = 1 and roomSanitation = 0")
	public int countReservationRoomType(int roomTypeId);
	
	/**
	 * 统计指定房间类型的已入住房间
	 * @param roomTypeId
	 * @return
	 */
	@Select("select count(*) from room where roomTypeId = #{roomTypeId} and  roomStatus = 2 and roomSanitation = 0")
	public int countCheckinRoomType(int roomTypeId);
	
	/**
	 * 统计指定房间类型的空闲房间
	 * @param roomTypeId
	 * @return
	 */
	@Select("select count(*) from room where roomTypeId = #{roomTypeId} and  roomStatus = 0 and roomSanitation = 0")
	public int countFreeRoomType(int roomTypeId);
	
	/**
	 * 统计指定房间类型的未打扫房间
	 * @param roomTypeId
	 * @return
	 */
	@Select("select count(*) from room where roomTypeId = #{roomTypeId} and   roomSanitation = 1")
	public int countNotCleanedRoomType(int roomTypeId);
	
	/**
	 * 统计指定房间类型的维修房间
	 * @param roomTypeId
	 * @return
	 */
	@Select("select count(*) from room where roomTypeId = #{roomTypeId} and   roomSanitation = 2")
	public int countRepairRoomType(int roomTypeId);
	
	/**
	 * 查询各状态房间
	 * @return
	 */
	@Select("select * from room where roomStatus = #{roomStatus} and roomSanitation = #{roomSanitation}")
	public List<Room> showRoomStruts(int roomStatus,int roomSanitation);
	
	/**
	 * 查询各房间情况
	 * @return
	 */
	@Select("select * from room where  roomSanitation = #{roomSanitation}")
	public List<Room> showRoomSanitation(int roomSanitation);
	
	/**
	 * 查询指定房间类型的各状态房间
	 * @return
	 */
	@Select("select * from room where roomStatus = #{roomStatus} and roomSanitation = #{roomSanitation}"
			+ " and roomTypeId = #{roomTypeId}")
	public List<Room> showRoomTypeStruts(int roomStatus,int roomSanitation,int roomTypeId);
	
	/**
	 * 查询指定房间类型的各房间情况
	 * @return
	 */
	@Select("select * from room where  roomSanitation = #{roomSanitation} and roomTypeId = #{roomTypeId}")
	public List<Room> showRoomTypeSanitation(int roomSanitation,int roomTypeId);
	
	/**
	 * 查询今日退房房间
	 * @return
	 */
	@Select("select r.* from room r,checkIn c where r.roomId = c.roomId and r.roomStatus = 2 and r.roomSanitation = 0"
			+ " and SUBSTR(c.DepartureTime,1,10)=SUBSTR(now(),1,10)")
	public List<Room> showRoomNowCheckOut();
}

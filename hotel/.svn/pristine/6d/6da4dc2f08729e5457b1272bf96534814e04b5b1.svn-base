package org.soft.hotel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.soft.hotel.model.RoomType;

@Mapper
public interface RoomTypeDAO {

	/**
	 * 新增房间类型
	 * @param roomType
	 * @return
	 */
	@Insert("insert into roomType(roomTypeName,roomTypeStatus,roomTypeTimingMode,roomTypeArea,"
			+ "listPrice,individualPrice,vipPrice)" 
			+ " value(#{roomTypeName},#{roomTypeStatus},#{roomTypeTimingMode},#{roomTypeArea},"
			+ "#{listPrice},#{individualPrice},#{individualPrice})")
	public boolean NewRoomType(RoomType roomType);
	
	/**
	 * 修改房间类型
	 * @param roomType
	 * @return
	 */
	@Update("update roomType set roomTypeName=#{roomTypeName},"
			+ "roomTypeTimingMode=#{roomTypeTimingMode},roomTypeStatus=#{roomTypeStatus},"
			+ "roomTypeArea=#{roomTypeArea},listPrice=#{listPrice},vipPrice=#{vipPrice},"
			+ "individualPrice=#{individualPrice} where roomTypeId = #{roomTypeId}")
	public boolean UpdateRoomType(RoomType roomType);
	
	/**
	 * 新增或者修改房间类型后查询房间类型ID来添加房间类型图片url
	 * @return
	 */
	@Select("select roomTypeId from roomType order by roomTypeId desc limit 1")
	public int showRoomTypeId();
	
	/**
	 * 新增或者修改房间类型后通过房间类型Id修改房间类型图片url
	 * @return
	 */
	@Update("update roomType set roomTypeImage = #{roomTypeImageUrl} where roomTypeId = #{roomTypeId}")
	public boolean updateRoomTypeImageUrl(String roomTypeImageUrl, int roomTypeId);
	
	
	/**
	 * 删除房间类型
	 * @param roomTypeId
	 * @return
	 */
	@Delete("delete from roomType where roomTypeId = #{roomTypeId}")
	public boolean DeleteRoomType(int roomTypeId);
	
	/**
	 * 查看房间类型信息
	 * @return
	 */
	@Select("select * from roomType where roomTypeId = #{roomTypeId}")
	public RoomType ShowRoomType(int roomTypeId);
	
	/**
	 * 查看所有房间类型
	 * @return
	 */
	@Select("select * from roomType")
	public List<RoomType> ShowAllRoomType();
	
	/**
	 * 查看房价
	 * @return
	 */
	@Select("select listPrice,individualPrice,vipPrice from roomType where roomTypeId = #{roomTypeId}")
	public RoomType ShowRoomTypePrice(int roomTypeId);
	
	/**
	 * 查看所有房间类型Id和名字
	 * @return
	 */
	@Select("select roomTypeId,roomTypeName from roomType")
	public List<RoomType> ShowAllRoomTypeIdAndName();
}

package org.soft.hotel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.soft.hotel.model.Announcement;



/**
 * 公告管理模块
 * @author Administrator
 *
 */
@Mapper
public interface AnnouncementDAO {

	/**
	 * 新增公告
	 * @param announcement
	 * @return
	 */
	@Insert("insert into announcement(staffId,announcementTitle,announcementContent,"
			+ "announcementType,announcementState,activityTime,announcementTime) value(#{staffId},#{announcementTitle},"
			+ "#{announcementContent},#{announcementType},#{announcementState},#{activityTime},current_date)")
	public boolean newAnnouncement(Announcement announcement);
	
	/**
	 * 查看公告详情
	 * @param announcementId
	 * @return
	 */
	@Select("select a.*,s.staffName from  announcement a inner join staff s on a.staffId = s.staffId "
			+ "and announcementId = #{announcementId}")
	public Announcement showAnnouncement(int announcementId);
	
	/**
	 * 删除公告
	 * @param announcementId
	 * @return
	 */
	@Delete("delete from announcement where announcementId = #{announcementId}")
	public boolean deleteAnnouncement(int announcementId);
	
	/**
	 * 修改公告
	 * @param announcement
	 * @return
	 */
	@Update("update announcement set staffId = #{staffId},announcementTitle=#{announcementTitle},"
			+ "announcementContent=#{announcementContent},announcementType=#{announcementType},"
			+ "announcementState=#{announcementState},activityTime=#{activityTime},"
			+ "announcementTime = current_date where announcementId = #{announcementId}")
	public boolean updateAnnouncement(Announcement announcement);
	
	/**
	 * 发布或停用公告
	 * @param announcement
	 * @return
	 */
	@Update("update announcement set announcementState=#{announcementState} where announcementId = #{announcementId}")
	public boolean updateAnnouncementState(int announcementState,int announcementId);
	
	/**
	 * 公告列表
	 * @return
	 */
	@Select("select  a.*,s.staffName from"
			+ " announcement a inner join staff s on a.staffId = s.staffId order by announcementTime desc")
	public List<Announcement> showAllAnnouncement();
	
	/**
	 * 公告列表
	 * @return
	 */
	@Select("select  a.*,s.staffName from"
			+ " announcement a inner join staff s on a.staffId = s.staffId order by activityTime")
	public List<Announcement> gatewayShowAllAnnouncement();
}

package org.soft.hotel.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.soft.hotel.model.Maintain;
import org.soft.hotel.querySql.MaintainQuery;

/**
 * 维修记录模块
 * @author Administrator
 *
 */
@Mapper
public interface MaintainDAO {

	/**
	 * 维修登记
	 * @param maintain
	 * @return
	 */
	@Insert("insert into maintain(roomId,staffId,maintainCause,maintainStartTime,maintainStatus)"
			+ "value(#{roomId},#{staffId},#{maintainCause},#{maintainStartTime},#{maintainStatus})")
	public boolean addMaintain(Maintain maintain);
	
	/**
	 * 后倾管理界面进行维修登记
	 * @param maintain
	 * @return
	 */
	@Insert("insert into maintain(roomId,staffId,maintainCause,maintainStartTime,maintainStatus)"
			+ "value(#{roomId},#{staffId},#{maintainCause},#{maintainStartTime},#{maintainStatus})")
	public boolean logisticsAddMaintain(Map<String, Object> map);
	
	/**
	 * 查询指定房间的最新一条维修记录
	 * @param size
	 * @return
	 */
	@Select("select maintainId from maintain  where roomId = #{roomId} order by maintainId desc limit 1")
	public int showMaintainId(int roomId);
	
	/**
	 * 修改维修记录
	 * @param maintainId
	 * @return
	 */
	@Update("update maintain set staffId=#{staffId},maintainFinishTime =#{maintainFinishTime},"
			+ "maintainStatus = #{maintainStatus},maintainResult = #{maintainResult} where maintainId = #{maintainId}")
	public boolean updateMaintain(Map<String, Object> map);
	
	/**
	 * 删除维修记录
	 * @param maintainId
	 * @return
	 */
	@Delete("delete from maintain where maintainId = #{maintainId}")
	public boolean deleteMaintain(int maintainId);
	
	/**
	 * 查看所有维修记录
	 * @return
	 */
	@SelectProvider(value = MaintainQuery.class,method = "showAllMaintain")
	public List<Maintain> showAllMaintain(Map<String, Object> map);
	
	/**
	 * 查询总条数
	 * @param size
	 * @return
	 */
	@Select("select count(*) from maintain")
	public int showAllPage();
	
	/**
	 * 查看输入框指定房间的所有维修记录
	 * @return
	 */
	@SelectProvider(value = MaintainQuery.class,method = "showInputAllMaintain")
	public List<Maintain> showInputAllMaintain(Map<String, Object> map);
	
	/**
	 * 查询输入框指定房间的总条数
	 * @param size
	 * @return
	 */
	@Select("select count(*) from maintain where roomId = #{roomId}")
	public int showInputAllPage(int roomId);
	
	
	
}

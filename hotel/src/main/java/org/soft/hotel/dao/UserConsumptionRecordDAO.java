package org.soft.hotel.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.soft.hotel.model.UserConsumptionRecord;
import org.soft.hotel.querySql.UserConsumptionRecordQuery;


/**
 * 会员客户消费记录模块
 * @author Administrator
 *
 */
@Mapper
public interface UserConsumptionRecordDAO {

	/**
	 * 新增会员消费记录
	 * @param map
	 * @return
	 */
	@Insert("insert into userConsumptionRecord(usersId,staffId,userConsumptionTime,userConsumptionMoney,userConsumptionManner) "
			+ "value(#{usersId},#{staffId},#{userConsumptionTime},#{userConsumptionMoney},#{userConsumptionManner})")
	public boolean NewUserConsumptionRecord(Map<String, Object> map);
	
	/**
	 * 删除会员消费记录
	 * @param userConsumptionRecordId
	 * @return
	 */
	@Delete("delete from userConsumptionRecord where userConsumptionRecordId = #{userConsumptionRecordId}")
	public boolean DeleteUserConsumptionRecord(int userConsumptionRecordId);
	
	/**
	 * 查看所有会员的消费记录
	 * @param map
	 * @return
	 */
	@SelectProvider(value = UserConsumptionRecordQuery.class,method = "showAllUserConsumptionRecord")
	public List<UserConsumptionRecord> showAllUserConsumptionRecord(Map<String, Object> map);
	
	/**
	 * 所有会员的消费记录总条数
	 * @return
	 */
	@Select("select count(*) from userConsumptionRecord")
	public int allUserConsumptionRecordPage();
	
	/**
	 * 查看指定会员的消费记录
	 * @param map
	 * @return
	 */
	@SelectProvider(value = UserConsumptionRecordQuery.class,method = "showAllUsersIdConsumptionRecord")
	public List<UserConsumptionRecord> showAllUsersIdConsumptionRecord(Map<String, Object> map);
	
	/**
	 * 指定会员的消费记录总条数
	 * @param usersId
	 * @return
	 */
	@Select("select count(*) from userConsumptionRecord where usersId = #{usersId}")
	public int allUserIdConsumptionRecordPage(int usersId);

	
}

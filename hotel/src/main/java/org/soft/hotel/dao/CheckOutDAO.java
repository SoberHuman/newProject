package org.soft.hotel.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.soft.hotel.model.CheckOut;
import org.soft.hotel.querySql.CheckOutQuery;

/**
 * 退房模块
 * @author Administrator
 *
 */
@Mapper
public interface CheckOutDAO {
	
	/**
	 * 退房登记
	 * @param checkOut
	 * @return
	 */
	@Insert("insert into checkOut(roomId,staffId,usersId,clientId,checkOutTime,amountReceived) "
			+ "value(#{roomId},#{staffId},#{usersId},#{clientId},#{checkOutTime},#{amountReceived})")
	public boolean newCheckOut(CheckOut checkOut);
	
	/**
	 * 删除退房记录
	 * @param checkOutId
	 * @return
	 */
	@Delete("delete from checkOut where checkOutId = #{checkOutId}")
	public boolean deleteCheckOut(int checkOutId);

	/**
	 * 查询所有会员客户退房记录
	 * @param nowPageRowNum
	 * @param size
	 * @return
	 */
	@SelectProvider(value = CheckOutQuery.class,method = "showAllUserCheckOut")
	public List<CheckOut> showAllUserCheckOut(Map<String, Object> map);
	
	/**
	 * 查询会员客户退房记录总条数
	 * @param size
	 * @return
	 */
	@Select("select count(*) from checkOut where usersId >0")
	public int allUserCheckOutPage();
	
	/**
	 * 查询输入框条件下所有会员客户退房记录
	 * @param nowPageRowNum
	 * @param size
	 * @return
	 */
	@SelectProvider(value = CheckOutQuery.class,method = "showInputUserCheckOut")
	public List<CheckOut> showInputUserCheckOut(Map<String, Object> map);
	
	/**
	 * 查询输入框条件下会员客户退房记录总条数
	 * @param size
	 * @return
	 */
	@Select("select count(*) from checkOut where usersId >0 and roomId = #{roomId}")
	public int inputUserCheckOutPage(int roomId);
	
	/**
	 * 查询所有普通客户退房记录
	 * @param nowPageRowNum
	 * @param size
	 * @return
	 */
	@SelectProvider(value = CheckOutQuery.class,method = "showAllClientCheckOut")
	public List<CheckOut> showAllClientCheckOut(Map<String, Object> map);
	
	/**
	 * 查询普通客户退房记录总条数
	 * @param size
	 * @return
	 */
	@Select("select count(*) from checkOut where usersId >0")
	public int allClientCheckOutPage();
	
	
	/**
	 * 查询输入框条件下所有普通客户退房记录
	 * @param nowPageRowNum
	 * @param size
	 * @return
	 */
	@SelectProvider(value = CheckOutQuery.class,method = "showInputClientCheckOut")
	public List<CheckOut> showInputClientCheckOut(Map<String, Object> map);
	
	/**
	 * 查询输入框条件下普通客户退房记录总条数
	 * @param size
	 * @return
	 */
	@Select("select count(*) from checkOut where usersId >0 and roomId = #{roomId}")
	public int inputClientCheckOutPage(int roomId);
}

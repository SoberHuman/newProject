package org.soft.hotel.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.soft.hotel.model.Income;
import org.soft.hotel.querySql.IncomeQuery;

/**
 * 收入模块
 * @author Administrator
 *
 */
@Mapper
public interface IncomeDAO {

	/**
	 * 新增收入记录
	 * @param income
	 * @return
	 */
	@Insert("insert into income(roomTypeId,staffId,paymentMethod,incomeTime,incomeMoney,incomeType)"
			+ " value(#{roomTypeId},#{staffId},#{paymentMethod},now(),#{incomeMoney},#{incomeType})")
	public boolean addIncome(Map<String, Object> map);
	
	/**
	 * 查询总收入记录
	 * @param nowPage
	 * @param size
	 * @return
	 */
	@SelectProvider(value = IncomeQuery.class,method = "showIncomeList")
	public List<Income> showIncomeList(Map<String, Object> map);
			
	/**
	 * 查询总收入记录页数
	 * @return
	 */
	@Select("select count(*) from income")
	public int showIncomeAllPage();
	
	/**
	 * 查询当日收入记录
	 * @param nowPage
	 * @param size
	 * @return
	 */
	@SelectProvider(value = IncomeQuery.class,method = "showIncomeListDate")
	public List<Income> showIncomeListDate(Map<String, Object> map);
	
	/**
	 * 查询当日收入记录页数
	 * @return
	 */
	@Select("select count(*) from income where SUBSTR(incomeTime,1,10)=DATE(CURDATE())")
	public int showIncomeDateAllPage();
	
	/**
	 * 查询指定起止日期的收入记录
	 * @param nowPage
	 * @param size
	 * @return
	 */
	@SelectProvider(value = IncomeQuery.class,method = "showIncomeListStartAndStopDates")
	public List<Income> showIncomeListStartAndStopDates(Map<String, Object> map);
	
	/**
	 *查询指定起止日期的收入记录页数
	 * @return
	 */
	@SelectProvider(value = IncomeQuery.class,method = "showIncomeListStartAndStopDatesAllPage")
	public int showIncomeListStartAndStopDatesAllPage(String startDates,String stopDates);
	
	/**
	 * 查询指定月份的收入记录
	 * @param nowPage
	 * @param size
	 * @return
	 */
	@SelectProvider(value = IncomeQuery.class,method = "showIncomeListMonth")
	public List<Income> showIncomeListMonth(Map<String, Object> map);
	
	/**
	 * 查询指定月份的收入记录页数
	 * @return
	 */
	@Select("select count(*) from income where SUBSTR(incomeTime,1,7)=#{months}")
	public int showIncomeListMonthAllPage(String months);
	
	/**
	 * 查询指定年份的收入记录
	 * @param nowPage
	 * @param size
	 * @return
	 */
	@SelectProvider(value = IncomeQuery.class,method = "showIncomeListYear")
	public List<Income> showIncomeListYear(Map<String, Object> map);
	
	/**
	 * 查询指定年份的收入记录页数
	 * @return
	 */
	@Select("select count(*) from income where SUBSTR(incomeTime,1,4)=#{years}")
	public int showIncomeListYearAllPage(String years);
	
	/**
	 *查询指定房间类型的总收入
	 * @return
	 */
	@Select("select sum(incomeMoney) from income where roomTypeId = #{roomTypeId}")
	public String countRoomTypeAllIncome(int roomTypeId);
	
	/**
	 * 统计指定房间类型的日收入
	 * @param roomTypeId
	 * @return
	 */
	@Select("select sum(incomeMoney) from income where roomTypeId = #{roomTypeId} and SUBSTR(incomeTime,1,10)=SUBSTR(now(),1,10)")
	public String countRoomTypeIncomeData(int roomTypeId);
	
	/**
	 * 统计指定房间类型的周收入
	 * @param roomTypeId
	 * @return
	 */
	@Select("select sum(incomeMoney) from income where roomTypeId=#{roomTypeId} and week(incomeTime) = week(curdate());")
	public String countRoomTypeIncomeWeek(int roomTypeId);
	
	/**
	 * 统计指定房间类型的月收入
	 * @param roomTypeId
	 * @return
	 */
	@Select("select sum(incomeMoney) from income where roomTypeId = #{roomTypeId} and SUBSTR(incomeTime,1,7)=SUBSTR(now(),1,7)")
	public String countRoomTypeIncomeNowMonths(int roomTypeId);
	
	/**
	 * 统计指定房间类型的年收入
	 * @param roomTypeId
	 * @return
	 */
	@Select("select sum(incomeMoney) from income where roomTypeId=#{roomTypeId} and SUBSTR(incomeTime,1,4)=SUBSTR(now(),1,4)")
	public String countRoomTypeIncomeNowYear(int roomTypeId);	
	
	/**
	 * 查询指定起止日期的收入
	 * @param map
	 * @return
	 */
	@SelectProvider(value = IncomeQuery.class,method = "countRoomTypeIncomeStartAndStopDates")
	public String countRoomTypeIncomeStartAndStopDates(Map<String, Object> map);

	
	/**
	 * 查询指定月份的收入
	 * @param map
	 * @return
	 */
	@SelectProvider(value = IncomeQuery.class,method = "countRoomTypeIncomeMonth")
	public String countRoomTypeIncomeMonth(Map<String, Object> map);
	
	/**
	 *查询指定年份的收入
	 * @param map
	 * @return
	 */
	@SelectProvider(value = IncomeQuery.class,method = "countRoomTypeIncomeYear")
	public String countRoomTypeIncomeYear(Map<String, Object> map);
}

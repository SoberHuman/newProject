package org.soft.hotel.querySql;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

/**
 * 收入模块
 * @author Administrator
 *
 */
public class IncomeQuery {

	/**
	 * 查询总收入记录
	 * @param nowPage
	 * @param size
	 * @return
	 */
	public String showIncomeList(Map<String, Object> map) {
		String sql = null;
		sql = new SQL() {{
			SELECT("i.incomeId,i.incomeMoney,i.incomeType,i.incomeTime,i.paymentMethod,st.staffName,ro.roomtypeName");
			FROM("income i,staff st,roomtype ro");
			WHERE("i.staffId=st.staffId and i.roomtypeId=ro.roomtypeId");
			ORDER_BY("i.incomeId desc");
			LIMIT(map.get("nowPageNum")+","+map.get("size"));
		}}.toString();
		return sql;
	}
	
	/**
	 * 查询日收入记录
	 * @param nowPage
	 * @param size
	 * @return
	 */
	public String showIncomeListDate(Map<String, Object> map) {
		String sql = null;
		sql = new SQL() {{
			SELECT("i.incomeId,i.incomeMoney,i.incomeType,i.incomeTime,i.paymentMethod,st.staffName,ro.roomtypeName");
			FROM("income i,staff st,roomtype ro");
			WHERE("i.staffId=st.staffId and i.roomtypeId=ro.roomtypeId");
			AND();
			WHERE("SUBSTR(incomeTime,1,10)=DATE(CURDATE())");
			ORDER_BY("i.incomeId desc");
			LIMIT(map.get("nowPageNum")+","+map.get("size"));
		}}.toString();
		return sql;
	}
	
	/**
	 *查询指定起止日期的收入记录
	 * @param nowPage
	 * @param size
	 * @return
	 */
	public String showIncomeListStartAndStopDates(Map<String, Object> map) {
		String sql = null;
		sql = new SQL() {{
			SELECT("i.incomeId,i.incomeMoney,i.incomeType,i.incomeTime,i.paymentMethod,st.staffName,ro.roomtypeName");
			FROM("income i,staff st,roomtype ro");
			WHERE("i.staffId=st.staffId and i.roomtypeId=ro.roomtypeId");
			AND();
			WHERE("'"+map.get("startDates")+"'<=incomeTime and incomeTime<='"+map.get("stopDates")+"'");
			ORDER_BY("i.incomeId desc");
			LIMIT(map.get("nowPageNum")+","+map.get("size"));
		}}.toString();
		return sql;
	}
	
	/**
	 *查询指定起止日期的收入记录页数
	 * @param nowPage
	 * @param size
	 * @return
	 */
	public String showIncomeListStartAndStopDatesAllPage(String startDates,String stopDates) {
		String sql = null;
		sql = new SQL() {{
			SELECT("count(*)");
			FROM("income");
			WHERE("'"+startDates+"'<=incomeTime and incomeTime<='"+stopDates+"'");
		}}.toString();
		return sql;
	}
	
	/**
	 * 查询指定月份的收入记录
	 * @param nowPage
	 * @param size
	 * @return
	 */
	public String showIncomeListMonth(Map<String, Object> map) {
		String sql = null;
		sql = new SQL() {{
			SELECT("i.incomeId,i.incomeMoney,i.incomeType,i.incomeTime,i.paymentMethod,st.staffName,ro.roomtypeName");
			FROM("income i,staff st,roomtype ro");
			WHERE("i.staffId=st.staffId and i.roomtypeId=ro.roomtypeId");
			AND();
			WHERE("SUBSTR(incomeTime,1,7)='"+map.get("months")+"'");
			ORDER_BY("i.incomeId desc");
			LIMIT(map.get("nowPageNum")+","+map.get("size"));
		}}.toString();
		return sql;
	}
	/**
	 * 查询指定年份的收入记录
	 * @param nowPage
	 * @param size
	 * @return
	 */
	public String showIncomeListYear(Map<String, Object> map) {
		String sql = null;
		sql = new SQL() {{
			SELECT("i.incomeId,i.incomeMoney,i.incomeType,i.incomeTime,i.paymentMethod,st.staffName,ro.roomtypeName");
			FROM("income i,staff st,roomtype ro");
			WHERE("i.staffId=st.staffId and i.roomtypeId=ro.roomtypeId");
			AND();
			WHERE("SUBSTR(incomeTime,1,4)='"+map.get("years")+"'");
			ORDER_BY("i.incomeId desc");
			LIMIT(map.get("nowPageNum")+","+map.get("size"));
		}}.toString();
		return sql;
	}
	
	/**
	 * 查询指定起止日期的收入
	 * @param map
	 * @return
	 */
	public String countRoomTypeIncomeStartAndStopDates(Map<String, Object> map) {
		String sql = null;
		sql = new SQL() {{
			SELECT("sum(incomeMoney)");
			FROM("income");
			WHERE("roomTypeId="+map.get("roomTypeId"));
			WHERE("'"+map.get("startDates")+"'<=incomeTime and incomeTime<='"+map.get("stopDates")+"'");
		}}.toString();
		return sql;
	}
	
	/**
	 * 查询指定月份的收入
	 * @param nowPage
	 * @param size
	 * @return
	 */
	public String countRoomTypeIncomeMonth(Map<String, Object> map) {
		String sql = null;
		sql = new SQL() {{
			SELECT("sum(incomeMoney)");
			FROM("income");
			WHERE("roomTypeId="+map.get("roomTypeId"));
			WHERE("SUBSTR(incomeTime,1,7)='"+map.get("months")+"'");
		}}.toString();
		return sql;
	}
	/**
	 * 查询指定年份的收入
	 * @param nowPage
	 * @param size
	 * @return
	 */
	public String countRoomTypeIncomeYear(Map<String, Object> map) {
		String sql = null;
		sql = new SQL() {{
			SELECT("sum(incomeMoney)");
			FROM("income");
			WHERE("roomTypeId="+map.get("roomTypeId"));
			WHERE("SUBSTR(incomeTime,1,4)='"+map.get("years")+"'");
		}}.toString();
		return sql;
	}
}

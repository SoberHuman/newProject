package org.soft.hotel.querySql;

import java.util.Map;


import org.apache.ibatis.jdbc.SQL;

/**
 * 预订记录查询语句
 * @author Administrator
 *
 */
public class ReservationQuery {

	/**
	   * 查看所有的预订记录
	 * @param map
	 * @return
	 */
	public String showAllReservation(Map<String, Object> map) {
		String sql = null;
		sql = new SQL() {{
			SELECT("re.reservationId,re.reservationName,re.reservationIdCard,re.reservationTime,"
					+ "re.expectedTimeOfArrival,re.reservationForegift,re.reservationStatus,s.staffName,ro.roomNumber");
			FROM("reservation re,staff s,room ro");
			WHERE("re.roomId = ro.roomId");
			ORDER_BY("re.reservationId desc");
			LIMIT(map.get("nowPageNum")+","+map.get("size"));
		}}.toString();
		return sql;
	}
	
	/**
	 * 查看预订记录详情
	 * @param reservationId
	 * @return
	 */
	public String showReservationDetail(int reservationId) {
		String sql = null;
		sql = new SQL() {{
			SELECT("re.*,s.staffName,ro.roomNumber");
			FROM("reservation re,staff s,room ro");
			WHERE("re.roomId = ro.roomId");
			AND();
			WHERE("reservationId ="+reservationId);
		}}.toString();
		return sql;
	}
	
	/**
	  * 查看输入框条件下的预订记录
	 * @param reservationId
	 * @return
	 */
	public String showInputReservation(Map<String, Object> map) {
		String sql = null;
		sql = new SQL() {{
			SELECT("re.reservationId,re.reservationName,re.reservationIdCard,re.reservationTime,"
					+ "re.expectedTimeOfArrival,re.reservationForegift,re.reservationStatus,s.staffName,ro.roomNumber");
			FROM("reservation re,staff s,room ro");
			WHERE("re.staffId = s.staffId");
			AND();
			WHERE("re.roomId = ro.roomId");
			AND();
			WHERE("re.roomId =" +map.get("roomId"));
			ORDER_BY("re.reservationId desc");
			LIMIT(map.get("nowPageNum")+","+map.get("size"));
		}}.toString();
		return sql;
	}
	/**
	  * 查看退订记录
	 * @param reservationId
	 * @return
	 */
	public String showAllUnsubscribeReservation(Map<String, Object> map) {
		String sql = null;
		sql = new SQL() {{
			SELECT("re.reservationId,re.reservationName,re.reservationIdCard,re.reservationTime,re.unsubscribeForegift,"
					+ "re.expectedTimeOfArrival,re.reservationForegift,re.reservationStatus,s.staffName,ro.roomNumber");
			FROM("reservation re,staff s,room ro");
			WHERE("re.roomId = ro.roomId");
			AND();
			WHERE("re.reservationStatus = 2");
			ORDER_BY("re.reservationId desc");
			LIMIT(map.get("nowPageNum")+","+map.get("size"));
		}}.toString();
		return sql;
	}
	
	/**
	  * 查看已入住记录
	 * @param reservationId
	 * @return
	 */
	public String showAllCheckInReservation(Map<String, Object> map) {
		String sql = null;
		sql = new SQL() {{
			SELECT("re.reservationId,re.reservationName,re.reservationIdCard,re.reservationTime,re.unsubscribeForegift,"
					+ "re.expectedTimeOfArrival,re.reservationForegift,re.reservationStatus,s.staffName,ro.roomNumber");
			FROM("reservation re,staff s,room ro");
			WHERE("re.roomId = ro.roomId");
			AND();
			WHERE("re.reservationStatus = 1");
			ORDER_BY("re.reservationId desc");
			LIMIT(map.get("nowPageNum")+","+map.get("size"));
		}}.toString();
		return sql;
	}
	/**
	  * 查看未入住记录
	 * @param reservationId
	 * @return
	 */
	public String showAllNoCheckInReservation(Map<String, Object> map) {
		String sql = null;
		sql = new SQL() {{
			SELECT("re.reservationId,re.reservationName,re.reservationIdCard,re.reservationTime,re.unsubscribeForegift,"
					+ "re.expectedTimeOfArrival,re.reservationForegift,re.reservationStatus,s.staffName,ro.roomNumber");
			FROM("reservation re,staff s,room ro");
			WHERE("re.roomId = ro.roomId");
			AND();
			WHERE("re.reservationStatus = 0");
			ORDER_BY("re.reservationId desc");
			LIMIT(map.get("nowPageNum")+","+map.get("size"));
		}}.toString();
		return sql;
	}
	
	/**
	  * 查看未处理预订订单
	 * @param reservationId
	 * @return
	 */
	public String showUserReservation(Map<String, Object> map) {
		String sql = null;
		sql = new SQL() {{
			SELECT("re.reservationId,re.reservationName,re.reservationIdCard,re.reservationPhoneNumber,re.reservationTime,re.unsubscribeForegift,"
					+ "re.expectedTimeOfArrival,re.reservationOccupancyDays,re.reservationForegift,re.reservationStatus,rt.roomTypeName,rt.roomTypeId ");
			FROM("reservation re,roomType rt");
			WHERE("re.roomTypeId = rt.roomTypeId");
			AND();
			WHERE("re.reservationStatus = 3");
			ORDER_BY("re.reservationId desc");
			LIMIT(map.get("nowPageNum")+","+map.get("size"));
		}}.toString();
		return sql;
	}
}


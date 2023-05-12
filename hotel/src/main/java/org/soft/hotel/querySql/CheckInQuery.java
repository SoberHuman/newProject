package org.soft.hotel.querySql;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

/**
 * 入住模块查询语句
 * @author Administrator
 *
 */
public class CheckInQuery {

	/**
	 * 查询房间的入住信息
	 * @param roomId
	 * @return
	 */
	public String showCheckIn(int roomId) {
		String sql = null;
		sql = new SQL() {{
			SELECT("c.*,r.roomNumber");
			FROM("checkin c,room  r");
			WHERE(" c.roomId=r.roomId");
			AND();
			WHERE("c.roomId="+roomId);
			ORDER_BY("c.checkinId desc");
			LIMIT("1");
		}}.toString();
		return sql;		
	}
	
	/**
	 * 查询所有会员入住记录
	 * @param nowPageRowNum
	 * @param size
	 * @return
	 */
	public String showAllUsersCheckIn(Map<String, Object> map) {
		String sql = null;
		sql = new SQL() {{
			SELECT("ch.*,u.userRealName,u.userIdCard,u.userPhone,s.staffName,r.roomNumber");
			FROM("checkin ch,users u,staff s,room r");
			WHERE("ch.usersId=u.usersId and ch.staffId=s.staffId and ch.roomId=r.roomId");
			ORDER_BY("ch.checkinId desc");
			LIMIT(map.get("nowPageNum")+","+map.get("size"));
		}}.toString();
		return sql;
	}
	
	/**
	 * 查询输入框条件下所有会员入住记录
	 * @param nowPageRowNum
	 * @param size
	 * @return
	 */
	public String showInputUsersCheckIn(Map<String, Object> map) {
		String sql = null;
		sql = new SQL() {{
			SELECT("ch.*,u.userRealName,u.userIdCard,u.userPhone,s.staffName,r.roomNumber");
			FROM("checkin ch,users u,staff s,room r");
			WHERE("ch.usersId=u.usersId and ch.staffId=s.staffId and ch.roomId=r.roomId");
			AND();
			WHERE(" ch.roomId = "+map.get("roomId"));
			ORDER_BY("ch.checkinId desc");
			LIMIT(map.get("nowPageNum")+","+map.get("size"));
		}}.toString();
		return sql;
	}
	
	/**
	 * 查询所有普通客户入住记录
	 * @param nowPageRowNum
	 * @param size
	 * @return
	 */
	public String showAllClientCheckIn(Map<String, Object> map) {
		String sql = null;
		sql = new SQL() {{
			SELECT("ch.*,cl.clientName,cl.clientIdCard,cl.clientPhone,s.staffName,r.roomNumber");
			FROM("checkin ch,client cl,staff s,room r");
			WHERE("ch.clientId=cl.clientId and ch.staffId=s.staffId and ch.roomId=r.roomId");
			ORDER_BY("ch.checkinId desc");
			LIMIT(map.get("nowPageNum")+","+map.get("size"));
		}}.toString();
		return sql;
	}
	
	/**
	 * 查询输入框条件下所有普通客户入住记录
	 * @param nowPageRowNum
	 * @param size
	 * @return
	 */
	public String showInputClientCheckIn(Map<String, Object> map) {
		String sql = null;
		sql = new SQL() {{
			SELECT("ch.*,cl.clientName,cl.clientIdCard,cl.clientPhone,s.staffName,r.roomNumber");
			FROM("checkin ch,client cl,staff s,room r");
			WHERE("ch.clientId=cl.clientId and ch.staffId=s.staffId and ch.roomId=r.roomId");
			AND();
			WHERE(" ch.roomId = "+map.get("roomId"));
			ORDER_BY("ch.checkinId desc");
			LIMIT(map.get("nowPageNum")+","+map.get("size"));
		}}.toString();
		return sql;
	}
	
	/**
	 * 统计指定房间类型的指定起止日期下的入住房间
	 * @param map
	 * @return
	 */
	public String countCheckInRoomTtypeStartAndStopDates(Map<String, Object> map) {
		String sql = null;
		sql = new SQL() {{
			SELECT("count(*)");
			FROM("checkIn");
			WHERE("roomTypeId="+map.get("roomTypeId"));
			WHERE("'"+map.get("startDates")+"'<=checkInTime and checkInTime<='"+map.get("stopDates")+"'");
		}}.toString();
		return sql;
	}
}

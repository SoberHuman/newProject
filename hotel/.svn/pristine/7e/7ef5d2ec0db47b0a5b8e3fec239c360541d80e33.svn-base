package org.soft.hotel.querySql;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

/**
 * 退房登记查询语句
 * @author Administrator
 *
 */
public class CheckOutQuery {

	/**
	 * 查询所有会员客户退房记录
	 * @param nowPageRowNum
	 * @param size
	 * @return
	 */
	public String showAllUserCheckOut(Map<String, Object> map) {
		String sql = null;
		sql = new SQL() {{
			SELECT("ch.*,us.userRealName,us.userIdCard,us.userPhone,st.staffName,ro.roomNumber");
			FROM("checkOut ch,users us,staff st,room ro");
			WHERE("ch.usersId = us.usersId");
			AND();
			WHERE("ch.staffId = st.staffId");
			AND();
			WHERE("ch.roomId = ro.roomId");
			ORDER_BY("ch.checkOutId desc");
			LIMIT(map.get("nowPageNum")+","+map.get("size"));
		}}.toString();
		return sql;
	}
	
	/**
	 * 查询输入框条件下所有会员客户退房记录
	 * @param nowPageRowNum
	 * @param size
	 * @return
	 */
	public String showInputUserCheckOut(Map<String, Object> map) {
		String sql = null;
		sql = new SQL() {{
			SELECT("ch.*,us.userRealName,us.userIdCard,us.userPhone,st.staffName,ro.roomNumber");
			FROM("checkOut ch,users us,staff st,room ro");
			WHERE("ch.usersId = us.usersId");
			AND();
			WHERE("ch.staffId = st.staffId");
			AND();
			WHERE("ch.roomId = ro.roomId");
			AND();
			WHERE(" ch.roomId = "+map.get("roomId"));
			ORDER_BY("ch.checkOutId desc");
			LIMIT(map.get("nowPageNum")+","+map.get("size"));
		}}.toString();
		return sql;
	}
	
	/**
	 * 查询所有普通客户退房记录
	 * @param nowPageRowNum
	 * @param size
	 * @return
	 */
	public String showAllClientCheckOut(Map<String, Object> map) {
		String sql = null;
		sql = new SQL() {{
			SELECT("ch.*,cl.clientName,cl.clientIdCard,cl.clientPhone,st.staffName,ro.roomNumber");
			FROM("checkOut ch,client cl,staff st,room ro");
			WHERE("ch.clientId = cl.clientId");
			AND();
			WHERE("ch.staffId = st.staffId");
			AND();
			WHERE("ch.roomId = ro.roomId");
			ORDER_BY("ch.checkOutId desc");
			LIMIT(map.get("nowPageNum")+","+map.get("size"));
		}}.toString();
		return sql;
	}
	
	/**
	 * 查询输入框条件下所有普通客户退房记录
	 * @param nowPageRowNum
	 * @param size
	 * @return
	 */
	public String showInputClientCheckOut(Map<String, Object> map) {
		String sql = null;
		sql = new SQL() {{
			SELECT("ch.*,cl.clientName,cl.clientIdCard,cl.clientPhone,st.staffName,ro.roomNumber");
			FROM("checkOut ch,client cl,staff st,room ro");
			WHERE("ch.clientId = cl.clientId");
			AND();
			WHERE("ch.staffId = st.staffId");
			AND();
			WHERE("ch.roomId = ro.roomId");
			AND();
			WHERE(" ch.roomId = "+map.get("roomId"));
			ORDER_BY("ch.checkOutId desc");
			LIMIT(map.get("nowPageNum")+","+map.get("size"));
		}}.toString();
		return sql;
	}
}

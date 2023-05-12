package org.soft.hotel.querySql;



import org.apache.ibatis.jdbc.SQL;

/**
 * 客房查询语句
 * @author Administrator
 *
 */
public class roomQuery {

	/**
	 * 输入框搜索房间
	 * @param roomNumber
	 * @return
	 */
	public String inputShowRoom(String roomNumber) {
		String sql = null;
		sql = new SQL() {{
			SELECT("r.roomId,r.roomNumber,r.roomSanitation,r.roomStatus,rt.roomTypeName,r.roomTypeId");
			FROM("room r");
			INNER_JOIN("roomType rt on r.roomTypeId = rt.roomTypeId");
			AND();
			WHERE("r.roomNumber like '%"+roomNumber+"%'");
		}}.toString();
		return sql;
	}
}

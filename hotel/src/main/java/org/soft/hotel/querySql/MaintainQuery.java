package org.soft.hotel.querySql;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
/**
 * 维修记录查询sql
 * @author Administrator
 *
 */
public class MaintainQuery {

	/**
	 * 查询所有的维修记录
	 * @param map
	 * @return
	 */
	public String showAllMaintain(Map<String, Object> map) {
		String sql = null;
		sql = new SQL() {{
			SELECT("m.*,s.staffName,r.roomNumber");
			FROM("maintain m,staff s,room r");
			WHERE("m.staffId = s.staffId");
			AND();
			WHERE("m.roomId = r.roomId");
			ORDER_BY("m.maintainId desc");
			LIMIT(map.get("nowPageNum")+","+map.get("size"));
		}}.toString();
		return sql;
	}
	
	/**
	 * 查询输入框指定房间地方所有维修记录
	 * @param map
	 * @return
	 */
	public String showInputAllMaintain(Map<String, Object> map) {
		String sql = null;
		sql = new SQL() {{
			SELECT("m.*,s.staffName,r.roomNumber");
			FROM("maintain m,staff s,room r");
			WHERE("m.staffId = s.staffId");
			AND();
			WHERE("m.roomId = r.roomId");
			AND();
			WHERE("m.roomId  ="+map.get("roomId"));
			ORDER_BY("m.maintainId desc");
			LIMIT(map.get("nowPageNum")+","+map.get("size"));
		}}.toString();
		return sql;
	}
}

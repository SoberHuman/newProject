package org.soft.hotel.querySql;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

/**
 * 会员客户消费记录搜索语句
 * @author Administrator
 *
 */
public class UserConsumptionRecordQuery {

	/**
	 * 查看所有会员的消费记录
	 * @param map
	 * @return
	 */
	public String showAllUserConsumptionRecord(Map<String, Object> map) {
		String sql = null;
		sql = new SQL() {{
			SELECT("ur.*,s.staffName,us.*");
			FROM("userConsumptionRecord ur,staff s,users us");
			WHERE("ur.staffId= s.staffId");
			AND();
			WHERE("ur.usersId=us.usersId");
			LIMIT(map.get("nowPageNum")+","+map.get("size"));
		}}.toString();
		return sql;
	}
	
	/**
	 * 查看指定会员的消费记录
	 * @param map
	 * @return
	 */
	public String showAllUsersIdConsumptionRecord(Map<String, Object> map) {
		String sql = null;
		sql = new SQL() {{
			SELECT("ur.*,s.staffName,us.*");
			FROM("userConsumptionRecord ur,staff s,users us");
			WHERE("ur.staffId= s.staffId");
			AND();
			WHERE("ur.usersId=us.usersId");
			WHERE("ur.usersId ="+map.get("usersId"));
			LIMIT(map.get("nowPageNum")+","+map.get("size"));
		}}.toString();
		return sql;
	}
}

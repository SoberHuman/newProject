package org.soft.hotel.querySql;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
/**
 * 会员用户查询语句
 * @author Administrator
 *
 */
public class userQuery {
	
	/**
	 * 会员列表
	 * @param map
	 * @return
	 */
	public String queryUsers(Map<String, Object> map) {
		String sql = null;
		sql = new SQL() {{
			SELECT("*");
			FROM("users");
			LIMIT("#{nowPageNum},#{size}");
		}}.toString();
		return sql;
	}
	/**
	 * 会员信息总条数
	 * @param map
	 * @return
	 */
	public String queryUsersAllPage() {
		String sql = null;
		sql = new SQL() {{
			SELECT("count(*)");
			FROM("users");
		}}.toString();
		return sql;
	}
	/**
	 * 搜索框输入条件下的会员列表
	 * @param map
	 * @return
	 */
	public String queryInputUsers(Map<String, Object> map) {
		String sql = null;
		sql = new SQL() {{
			SELECT("*");
			FROM("users");
			WHERE("userRealName like '%"+map.get("userRealNames")+"%'");
			OR();
			WHERE("userPhone like '%"+map.get("userRealNames")+"%'");
			OR();
			WHERE("userIdCard like '%"+map.get("userRealNames")+"%'");
			OR();
			WHERE("userVipId like '%"+map.get("userRealNames")+"%'");
			LIMIT("#{nowPageNum},#{size}");
		}}.toString();
		return sql;
	}
	/**
	 * 搜索框输入条件下的会员信息总条数
	 * @param map
	 * @return
	 */
	public String queryInputUsersAllPage(String userRealNames) {
		String sql = null;
		sql = new SQL() {{
			SELECT("count(*)");
			FROM("users");
			WHERE("userRealName like '%"+userRealNames+"%'");
			OR();
			WHERE("userPhone like '%"+userRealNames+"%'");
			OR();
			WHERE("userIdCard like '%"+userRealNames+"%'");
		}}.toString();
		return sql;
	}
	
	/**
	 * 搜索框输入条件下的会员ID
	 * @param map
	 * @return
	 */
	public String showInputUsersId(String userRealNames) {
		String sql = null;
		sql = new SQL() {{
			SELECT("usersId");
			FROM("users");
			WHERE("userRealName = "+userRealNames);
			OR();
			WHERE("userPhone ="+userRealNames);
			OR();
			WHERE("userIdCard ="+userRealNames);
		}}.toString();
		return sql;
	}
}

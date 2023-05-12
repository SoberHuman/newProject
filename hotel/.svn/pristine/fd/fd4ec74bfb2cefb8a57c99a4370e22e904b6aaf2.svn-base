package org.soft.hotel.querySql;


import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

/**
   *  普通客户查询语句
 * @author Administrator
 *
 */
public class ClientQuery {

	/**
	 * 查看所有客户信息
	 * @return
	 */
	public String showAllClient(Map<String, Object> map){
			String sql = null;
			sql = new SQL() {{
				SELECT("*");
				FROM("client");
				LIMIT(map.get("nowPageNum")+","+map.get("size"));
			}}.toString();
			return sql;
	}
	
	/**
	 * 查看输入框条件下的客户信息
	 * @return
	 */
	public String showInputAllClient(Map<String, Object> map){
			String sql = null;
			sql = new SQL() {{
				SELECT("*");
				FROM("client");
				WHERE("clientName like '%"+map.get("clientNames")+"%'");
				OR();
				WHERE("clientIdCard like '%"+map.get("clientNames")+"%'");
				OR();
				WHERE("clientPhone like '%"+map.get("clientNames")+"%'");
				LIMIT(map.get("nowPageNum")+","+map.get("size"));
			}}.toString();
			return sql;
	}
	
	/**
	 * 搜索框输入条件下的会员信息总条数
	 * @param map
	 * @return
	 */
	public String allInputClientPage(String clientNames) {
		String sql = null;
		sql = new SQL() {{
			SELECT("count(*)");
			FROM("client");
			WHERE("clientName like '%"+clientNames+"%'");
			OR();
			WHERE("clientIdCard like '%"+clientNames+"%'");
			OR();
			WHERE("clientPhone like '%"+clientNames+"%'");
		}}.toString();
		return sql;
	}
		
	/**
	 * 搜索框输入条件下的普通客户ID
	 * @param map
	 * @return
	 */
	public String showInputClientId(String clientName) {
		String sql = null;
		sql = new SQL() {{
			SELECT("clientId");
			FROM("client");
			WHERE("clientName = "+clientName);
			OR();
			WHERE("clientIdCard ="+clientName);
			OR();
			WHERE("clientPhone ="+clientName);
		}}.toString();
		return sql;
	}
}

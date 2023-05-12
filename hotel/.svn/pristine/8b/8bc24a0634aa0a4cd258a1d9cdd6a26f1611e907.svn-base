package org.soft.hotel.querySql;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

/**
 * 普通客户消费记录搜索语句
 * @author Administrator
 *
 */
public class ClientConsumptionRecordQuery {

	/**
	 * 查看所有普通客户的消费记录
	 * @param map
	 * @return
	 */
	public String showAllClientConsumptionRecord(Map<String, Object> map) {
		String sql = null;
		sql = new SQL() {{
			SELECT("cr.*,s.staffName,cl.*");
			FROM("clientConsumptionRecord cr,staff s,client cl");
			WHERE("cr.staffId= s.staffId");
			AND();
			WHERE("cr.clientId=cl.clientId");
			LIMIT(map.get("nowPageNum")+","+map.get("size"));
		}}.toString();
		return sql;
	}
	
	/**
	 * 查看指定普通客户的消费记录
	 * @param map
	 * @return
	 */
	public String showAllClientIdConsumptionRecord(Map<String, Object> map) {
		String sql = null;
		sql = new SQL() {{
			SELECT("cr.*,s.staffName,cl.*");
			FROM("clientConsumptionRecord cr,staff s,client cl");
			WHERE("cr.staffId= s.staffId");
			AND();
			WHERE("cr.clientId=cl.clientId");
			AND();
			WHERE("cr.clientId ="+map.get("clientId"));
			LIMIT(map.get("nowPageNum")+","+map.get("size"));
		}}.toString();
		return sql;
	}
}

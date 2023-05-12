package org.soft.hotel.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.soft.hotel.model.ClientConsumptionRecord;
import org.soft.hotel.querySql.ClientConsumptionRecordQuery;


/**
 * 普通客户消费记录模块
 * @author Administrator
 *
 */
@Mapper
public interface ClientConsumptionRecordDAO {

	/**
	 * 新增客户消费记录
	 * @param clientrConsumptionRecord
	 * @return
	 */
	@Insert("insert into clientConsumptionRecord(clientId,staffId,clientConsumptionTime,clientConsumptionMoney,clientConsumptionManner) "
			+ "value(#{clientId},#{staffId},#{clientConsumptionTime},#{clientConsumptionMoney},#{clientConsumptionManner})")
	public boolean NewClientrConsumptionRecord(Map<String, Object> map);
	
	/**
	 * 删除客户消费记录
	 * @param clientConsumptionRecordId
	 * @return
	 */
	@Delete("delete from clientConsumptionRecord where clientConsumptionRecordId = #{clientConsumptionRecordId}")
	public boolean DeleteClientrConsumptionRecord(int clientConsumptionRecordId);
	
	/**
	 * 查看所有普通客户的消费记录
	 * @param map
	 * @return
	 */
	@SelectProvider(value = ClientConsumptionRecordQuery.class,method = "showAllClientConsumptionRecord")
	public List<ClientConsumptionRecord> showAllClientConsumptionRecord(Map<String, Object> map);
	
	/**
	 * 所有普通客户的消费记录总条数
	 * @return
	 */
	@Select("select count(*) from clientConsumptionRecord")
	public int allClientsConsumptionRecordPage();
	
	/**
	 * 查看指定普通客户的消费记录
	 * @param map
	 * @return
	 */
	@SelectProvider(value = ClientConsumptionRecordQuery.class,method = "showAllClientIdConsumptionRecord")
	public List<ClientConsumptionRecord> showAllClientIdConsumptionRecord(Map<String, Object> map);
	
	/**
	 * 指定普通客户的消费记录总条数
	 * @param clientId
	 * @return
	 */
	@Select("select count(*) from clientConsumptionRecord where clientId = #{clientId}")
	public int allClientIdConsumptionRecordPage(int clientId);

	
}

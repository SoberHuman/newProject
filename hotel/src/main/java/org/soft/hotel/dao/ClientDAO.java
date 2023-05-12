package org.soft.hotel.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.soft.hotel.model.Client;
import org.soft.hotel.model.Users;
import org.soft.hotel.querySql.ClientQuery;


@Mapper
public interface ClientDAO {

	/**
	 * 新增客户
	 * @return
	 */
	@Insert("insert into client(clientName,clientPass,clientIdCard,clientPhone) value(#{clientName},#{clientPass},#{clientIdCard},#{clientPhone})")
	public boolean NewClient(Map<String, Object> map);


	/**
	 * 登录
	 */
	@Select("select * from client where clientPhone = #{clientPhone} and clientPass=#{clientPass}")
	public Client clentlogin(Client client);


	/**
	 * 修改客户信息
	 * @param client
	 * @return
	 */
	@Update("update client set clientName=#{clientName},clientPhone=#{clientPhone} where clientId=#{clientId}")
	public boolean updateClient(Client client);


	/**
	 * 用户修改密码
	 */
	@Update("update client set clientPass = #{clientPass} where clientId = #{clientId}")
	public boolean clientPersonalModify(Client client);




	/**
	 * 删除客户信息
	 * @param clientId
	 * @return
	 */
	@Delete("delete from client where clientId = #{clientId}")
	public boolean deleteClient(int clientId);
	
	/**
	 * 通过入住身份证号查询客户信息
	 * @param checkInIdCard
	 * @return
	 */
	@Select("select count(*) from client where clientIdCard = #{checkinIdCard}")
	public int showClientIds(String checkinIdCard);
	
	/**
	 * 通过入住身份证号查询客户信息
	 * @param checkInIdCard
	 * @return
	 */
	@Select("select clientId from client where clientIdCard = #{checkinIdCard}")
	public int showClientId(String checkinIdCard);
	
	/**
	 * 通过客户Id查询客户信息
	 * @param clientId
	 * @return
	 */
	@Select("select * from client where clientId = #{clientId}")
	public Client showClient(int clientId);
	
	/**
	 * 查看所有客户信息
	 * @return
	 */
	@SelectProvider(value = ClientQuery.class,method = "showAllClient")
	public List<Client> showAllClient(Map<String, Object> map);
	
	/**
	 * 查询客户信息的总页数
	 * @param size
	 * @return
	 */
	@Select("select count(*) from client")
	public int allClientPage();
	
	/**
	 * 查看输入框条件下所有客户信息
	 * @return
	 */
	@SelectProvider(value = ClientQuery.class,method = "showInputAllClient")
	public List<Client> showInputAllClient(Map<String, Object> map);
	
	/**
	 * 查询客户信息的总页数
	 * @param size
	 * @return
	 */
	@SelectProvider(value = ClientQuery.class,method = "allInputClientPage")
	public int allInputClientPage(String clientNames);
	
	/**
	 * 搜索框输入条件下的普通客户ID
	 * @param map
	 * @return
	 */
	@SelectProvider(value = ClientQuery.class,method = "showInputClientId")
	public int showInputClientId(String clientName);
}

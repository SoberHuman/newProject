package org.soft.hotel.server;

import java.util.List;
import java.util.Map;


import org.soft.hotel.dao.ClientDAO;
import org.soft.hotel.model.Client;
import org.soft.hotel.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


//普通用户模块
@Controller("ClientServer")
public class ClientServer {

	@Autowired
	private ClientDAO clientDAO;
	
	/**
	 * 新增客户
	 * @return
	 */
	public boolean NewClient(Map<String, Object> map) {
		boolean b = clientDAO.NewClient(map);
		return b;
	}

	/**
	 * 登录
	 */
	public Client clientlogin(Client client2){
		Client client = clientDAO.clentlogin(client2);
		return client;
	}



	/**
	 * 修改客户信息
	 * @param client
	 * @return
	 */
	public boolean updateClient(Client client) {
		boolean b = clientDAO.updateClient(client);
		return b;
	}
	
	/**
	 * 删除客户信息
	 * @param clientId
	 * @return
	 */
	public boolean deleteClient(int clientId) {
		boolean b = clientDAO.deleteClient(clientId);
		return b;
	}
	
	/**
	 * 通过入住身份证号查询客户信息
	 * @param checkInIdCard
	 * @return
	 */
	public int showClientIds(String checkinIdCard) {
		int clientIds = clientDAO.showClientIds(checkinIdCard);
		return clientIds;
	}
	
	/**
	 * 通过入住身份证号查询客户信息
	 * @param checkInIdCard
	 * @return
	 */
	public int showClientId(String checkinIdCard) {
		int clientId = clientDAO.showClientId(checkinIdCard);
		return clientId;
	}
	
	/**
	 *  通过客户Id查询客户信息
	 * @param clientId
	 * @return
	 */
	public Client showClient(int clientId) {
		Client client = clientDAO.showClient(clientId);
		return client;
	}
	
	/**
	 * 查看所有客户信息
	 * @return
	 */
	public List<Client> showAllClient(Map<String, Object> map){
		List<Client> clients = clientDAO.showAllClient(map);
		return clients;
	}
	
	/**
	 * 查询客户信息的总页数
	 * @param size
	 * @return
	 */
	public int allClientPage() {
		int allClientPageNum = clientDAO.allClientPage();
		return allClientPageNum;
	}
	
	/**
	 * 查看所有客户信息
	 * @return
	 */
	public List<Client> showInputAllClient(Map<String, Object> map){
		List<Client> clients = clientDAO.showInputAllClient(map);
		return clients;
	}
	
	/**
	 * 查询客户信息的总页数
	 * @param size
	 * @return
	 */
	public int allInputClientPage(String clientNames) {
		int allClientPageNum = clientDAO.allInputClientPage(clientNames);
		return allClientPageNum;
	}
	
	/**
	 * 搜索框输入条件下的普通客户ID
	 * @param map
	 * @return
	 */
	public int showInputClientId(String clientName) {
		int clientId =clientDAO.showInputClientId(clientName);
		return clientId;
	}




	/**
	 * 用户修改密码
	 */
	public boolean clientPersonalModify(Client client){
		boolean b = clientDAO.clientPersonalModify(client);
		return b;
	}
}

package org.soft.hotel.server;

import java.util.List;
import java.util.Map;

import org.soft.hotel.dao.ClientConsumptionRecordDAO;
import org.soft.hotel.model.ClientConsumptionRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 普通客户消费记录模块
 * @author Administrator
 *
 */
@Controller("ClientConsumptionRecordServer")
public class ClientConsumptionRecordServer {

	@Autowired
	private ClientConsumptionRecordDAO clientConsumptionRecordDAO;
	
	/**
	 * 新增客户消费记录
	 * @param clientrConsumptionRecord
	 * @return
	 */
	public boolean NewClientrConsumptionRecord(Map<String, Object> map) {
		boolean b = clientConsumptionRecordDAO.NewClientrConsumptionRecord(map);
		return b;
	}
	
	/**
	 * 删除客户消费记录
	 * @param clientConsumptionRecordId
	 * @return
	 */
	public boolean deleteClientrConsumptionRecord(int clientConsumptionRecordId) {
		boolean b = clientConsumptionRecordDAO.DeleteClientrConsumptionRecord(clientConsumptionRecordId);
		return b;
	}
	
	/**
	 * 查看所有普通客户的消费记录
	 * @param map
	 * @return
	 */
	public List<ClientConsumptionRecord> showAllClientConsumptionRecord(Map<String, Object> map){
		List<ClientConsumptionRecord> clientConsumptionRecords = clientConsumptionRecordDAO.showAllClientConsumptionRecord(map);
		return clientConsumptionRecords;
	}
	
	/**
	 * 所有普通客户的消费记录总条数
	 * @return
	 */
	public int allClientsConsumptionRecordPage() {
		int allClientsConsumptionRecordPageNum = clientConsumptionRecordDAO.allClientsConsumptionRecordPage();
		return allClientsConsumptionRecordPageNum;
	}
	
	/**
	 * 查看指定普通客户的消费记录
	 * @param map
	 * @return
	 */
	public List<ClientConsumptionRecord> showAllClientIdConsumptionRecord(Map<String, Object> map){
		List<ClientConsumptionRecord> clientConsumptionRecords = clientConsumptionRecordDAO.showAllClientIdConsumptionRecord(map);
		return clientConsumptionRecords;
	}
	
	/**
	 * 指定普通客户的消费记录总条数
	 * @param clientId
	 * @return
	 */
	public int allClientIdConsumptionRecordPage(int clientId) {
		int allClientIdConsumptionRecordPage = clientConsumptionRecordDAO.allClientIdConsumptionRecordPage(clientId);
		return allClientIdConsumptionRecordPage;
	}
}

package org.soft.hotel.server;

import java.util.List;
import java.util.Map;

import org.soft.hotel.dao.UserConsumptionRecordDAO;
import org.soft.hotel.model.UserConsumptionRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 会员消费记录模块
 * @author Administrator
 *
 */
@Controller("UserConsumptionRecordServer")
public class UserConsumptionRecordServer {

	@Autowired
	private UserConsumptionRecordDAO userConsumptionRecordDAO;
	
	/**
	 * 新增会员消费记录
	 * @param clientrConsumptionRecord
	 * @return
	 */
	public boolean NewUserConsumptionRecord(Map<String, Object> map) {
		boolean b = userConsumptionRecordDAO.NewUserConsumptionRecord(map);
		return b;
	}
	
	/**
	 * 删除会员消费记录
	 * @param clientConsumptionRecordId
	 * @return
	 */
	public boolean deleteUserConsumptionRecord(int userConsumptionRecordId) {
		boolean b = userConsumptionRecordDAO.DeleteUserConsumptionRecord(userConsumptionRecordId);
		return b;
	}
	
	/**
	 * 查看所有会员的消费记录
	 * @param map
	 * @return
	 */
	public List<UserConsumptionRecord> showAllUserConsumptionRecord(Map<String, Object> map){
		List<UserConsumptionRecord> userConsumptionRecords = userConsumptionRecordDAO.showAllUserConsumptionRecord(map);
		return userConsumptionRecords;
	}
	
	/**
	 * 所有会员的消费记录总条数
	 * @return
	 */
	public int allUserConsumptionRecordPage() {
		int allUserConsumptionRecordPageNum = userConsumptionRecordDAO.allUserConsumptionRecordPage();
		return allUserConsumptionRecordPageNum;
	}
	
	/**
	 * 查看指定会员的消费记录
	 * @param map
	 * @return
	 */
	public List<UserConsumptionRecord> showAllUsersIdConsumptionRecord(Map<String, Object> map){
		List<UserConsumptionRecord> userConsumptionRecords = userConsumptionRecordDAO.showAllUsersIdConsumptionRecord(map);
		return userConsumptionRecords;
	}
	
	/**
	 * 指定会员的消费记录总条数
	 * @param clientId
	 * @return
	 */
	public int allUserIdConsumptionRecordPage(int usersId) {
		int allUserIdConsumptionRecordPageNum = userConsumptionRecordDAO.allUserIdConsumptionRecordPage(usersId);
		return allUserIdConsumptionRecordPageNum;
	}
}

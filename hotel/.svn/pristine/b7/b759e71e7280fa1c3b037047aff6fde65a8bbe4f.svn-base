package org.soft.hotel.server;

import java.util.List;
import java.util.Map;
import org.soft.hotel.dao.MaintainDAO;
import org.soft.hotel.model.Maintain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 维修记录模块
 * @author Administrator
 *
 */
@Controller("MaintainServer")
public class MaintainServer {

	@Autowired
	private MaintainDAO maintainDAO;
	
	/**
	 * 维修登记
	 * @param maintain
	 * @return
	 */
	public boolean addMaintain(Maintain maintain) {
		boolean b = maintainDAO.addMaintain(maintain);
		return b;
	}
	
	/**
	 * 后勤管理界面进行维修登记
	 * @param maintain
	 * @return
	 */
	public boolean logisticsAddMaintain(Map<String, Object> map) {
		boolean b = maintainDAO.logisticsAddMaintain(map);
		return b;
	}
	/**
	 * 查询指定房间的最新一条维修记录
	 * @param size
	 * @return
	 */
	public int showMaintain(int roomId) {
		int maintainId = maintainDAO.showMaintainId(roomId);
		return 	maintainId;
	}
	/**
	 * 修改维修记录
	 * @param maintainId
	 * @return
	 */
	public boolean updateMaintain(Map<String, Object> map) {
		boolean b = maintainDAO.updateMaintain(map);
		return b;
	}
	
	/**
	 * 删除维修记录
	 * @param maintainId
	 * @return
	 */
	public boolean deleteMaintain(int maintainId) {
		boolean b = maintainDAO.deleteMaintain(maintainId);				
		return b;
	}
	
	/**
	 * 查看所有维修记录
	 * @return
	 */
	public List<Maintain> showAllMaintain(Map<String, Object> map){
		 List<Maintain> maintains = maintainDAO.showAllMaintain(map);
		 return maintains;
	}
	
	/**
	 * 查询总条数
	 * @param size
	 * @return
	 */
	public int showAllPage() {
		int allPageNum = maintainDAO.showAllPage();
		return allPageNum;
	}
	
	/**
	 * 查看输入框指定房间的所有维修记录
	 * @return
	 */
	public List<Maintain> showInputAllMaintain(Map<String, Object> map){
		 List<Maintain> maintains = maintainDAO.showInputAllMaintain(map);
		 return maintains;
	}
	
	/**
	 * 查询总条数
	 * @param size
	 * @return
	 */
	public int showInputAllPage(int roomId) {
		int allPageNum = maintainDAO.showInputAllPage(roomId);
		return allPageNum;
	}
}

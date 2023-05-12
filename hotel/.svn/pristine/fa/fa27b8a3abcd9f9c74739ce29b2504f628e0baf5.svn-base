package org.soft.hotel.server;

import java.util.List;
import java.util.Map;

import org.soft.hotel.dao.CheckOutDAO;
import org.soft.hotel.model.CheckOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 退房模块
 * @author Administrator
 *
 */
@Controller("CheckOutServer")
public class CheckOutServer {

	@Autowired
	private CheckOutDAO checkOutDAO;
	
	/**
	 * 退房登记
	 * @param checkOut
	 * @return
	 */
	public boolean newCheckOut(CheckOut checkOut) {
		boolean b = checkOutDAO.newCheckOut(checkOut);
		return b;
	}
	
	/**
	 * 删除退房记录
	 * @param checkOutId
	 * @return
	 */
	public boolean deleteCheckOut(int checkOutId) {
		boolean b = checkOutDAO.deleteCheckOut(checkOutId);
		return b;
	}

	/**
	 * 查询所有会员客户退房记录
	 * @param nowPageRowNum
	 * @param size
	 * @return
	 */
	public List<CheckOut> showAllUserCheckOut(Map<String, Object> map){
		List<CheckOut> checkOuts = checkOutDAO.showAllUserCheckOut(map);
		return checkOuts;
	}
	
	/**
	 * 查询会员客户退房记录总条数
	 * @param size
	 * @return
	 */
	public int allUserCheckOutPage() {
		int allCheckOutPageNum = checkOutDAO.allUserCheckOutPage();
		return allCheckOutPageNum;
	}
	
	/**
	 * 查询输入框条件下所有会员客户退房记录
	 * @param nowPageRowNum
	 * @param size
	 * @return
	 */
	public List<CheckOut> showInputUserCheckOut(Map<String, Object> map){
		List<CheckOut> checkOuts = checkOutDAO.showInputUserCheckOut(map);
		return checkOuts;
	}
	
	/**
	 * 查询输入框条件下会员客户退房记录总条数
	 * @param size
	 * @return
	 */
	public int inputUserCheckOutPage(int roomId) {
		int inputUserCheckOutPage = checkOutDAO.inputUserCheckOutPage(roomId);
		return inputUserCheckOutPage;
	}
	
	/**
	 * 查询所有普通客户退房记录
	 * @param nowPageRowNum
	 * @param size
	 * @return
	 */
	public List<CheckOut> showAllClientCheckOut(Map<String, Object> map){
		List<CheckOut> checkOuts = checkOutDAO.showAllClientCheckOut(map);
		return checkOuts;
	}
	
	/**
	 * 查询普通客户退房记录总条数
	 * @param size
	 * @return
	 */
	public int allClientCheckOutPage() {
		int allCheckOutPageNum = checkOutDAO.allUserCheckOutPage();
		return allCheckOutPageNum;
	}
	
	/**
	 * 查询输入框条件下所有普通客户退房记录
	 * @param nowPageRowNum
	 * @param size
	 * @return
	 */
	public List<CheckOut> showInputClientCheckOut(Map<String, Object> map){
		List<CheckOut> checkOuts = checkOutDAO.showInputClientCheckOut(map);
		return checkOuts;
	}
	
	/**
	 * 查询输入框条件下普通客户退房记录总条数
	 * @param size
	 * @return
	 */
	public int inputClientCheckOutPage(int roomId) {
		int inputClientCheckOutPage = checkOutDAO.inputClientCheckOutPage(roomId);
		return inputClientCheckOutPage;
	}
}

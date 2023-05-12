package org.soft.hotel.server;

import org.soft.hotel.dao.StaffDAO;
import org.soft.hotel.model.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 员工模块
 * @author Administrator
 *
 */
@Controller("StaffServer")
public class StaffServer{

	@Autowired
	private StaffDAO staffDAO;
	
	/**
	 * 员工登录
	 * @param staff
	 * @return
	 */
	public Staff staffLogin(Staff staff) {
		staff = staffDAO.staffLogin(staff);
		return staff;
	}
}

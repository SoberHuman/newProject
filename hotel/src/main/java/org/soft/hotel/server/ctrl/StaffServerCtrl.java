package org.soft.hotel.server.ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.soft.hotel.model.Staff;
import org.soft.hotel.server.StaffServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"staff"})
public class StaffServerCtrl {

	@Autowired
	@Qualifier("StaffServer")
	private StaffServer staffServer;
	
	/**
	 * 员工登录
	 * @param staff
	 * @return
	 */
	@RequestMapping("staffLogin")
	public String staffLogin(Staff staff, Model model) {
		String path = null;
		staff = staffServer.staffLogin(staff);
		if(staff != null) {
			model.addAttribute("staff", staff);
			path = "index/index";
		}else {
			path = "staff/staffLogin";
		}
		return path;
	}
	
	@RequestMapping("/staffCancellation")
	public String staffCancellation(HttpServletRequest request, HttpSession session) {
		String path = "/staff/staffLogin";
		request.getSession().invalidate();
		return path;
	}
}

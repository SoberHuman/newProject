package org.soft.hotel.server.ctrl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.net.httpserver.HttpsServer;
import org.soft.hotel.model.Client;
import org.soft.hotel.model.Users;
import org.soft.hotel.server.UsersServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 会员用户模块
 * @author Administrator
 *
 */
@Controller
public class UsersServerCtrl {

	@Autowired
	@Qualifier("UsersServer")
	private UsersServer usersServer; 
	//存储搜索框输入的信息
	private String userRealNames;
	
	/**
	 * 新增会员
	 * @return
	 */
	@RequestMapping("newUsers")
	public String newUsers(Users users) {
		String path = "error";
		boolean b = usersServer.NewUsers(users);
		if(b) {
			path = "redirect:/showAllUsers/1";
		}
		return path;
	}

	/**
	 * 会员注册
	 * @return
	 */
	@RequestMapping("userRegist")
	public String userRegist(Users users) {
		String path = "error";
		String userVipId = "vip";
		for(int i = 0; i < 6;i ++){
            int randomNum = (int)(Math.random() * 10);
            userVipId += randomNum;           
        }
		for(int a =0;a<=100;a++) {					
		int showUserVipId = usersServer.showUserVipId(userVipId);
		if(showUserVipId == 0) {
			break;
		}else {
			for(int i = 0; i < 6;i ++){
	            int randomNum = (int)(Math.random() * 10);
	            userVipId = "vip"+randomNum;           
	        }
		}	
		}
		users.setUserVipId(userVipId);
		System.out.println("userVipId="+userVipId);
		boolean b = usersServer.NewUsers(users);
		if(b) {
			path = "/toPage/gateway/userLogin";
		}
		return path;
	}
	
	/**
	 * 修改会员信息
	 * @param users
	 * @return
	 */
	@RequestMapping("updateUsers")
	public String updateUsers(Users users){
		String path = "error";
		boolean b = usersServer.UpdateUsers(users);
		if(b) {
			path = "redirect:/showAllUsers/1";
		}
		return path;
	}





	/**
	 * 删除会员
	 * @param usersId
	 * @return
	 */
	@RequestMapping("deleteUsers")
	public String deleteUsers(int usersId) {
		String path = "error";
		boolean b = usersServer.DeleteUsers(usersId);
		if(b) {
			path = "redirect:/showAllUsers/1";
		}
		return path;
	}
	/**
	 * 查看所有会员信息
	 * @return
	 */
	@RequestMapping(value = "showAllUsers/{nowPage}")
	public String showAllUsers(@PathVariable("nowPage") int nowPage,Model model) {
		String path = "error";	
		//显示条数
		int size = 3;
		//数据总条数
		int allPage = usersServer.showAllPage();
		//总页数
		int allPageNum = 1;
		if(allPage % size >0) {
			allPageNum = allPage / size +1;
		}else if(allPage % size == 0) {
			allPageNum = allPage / size;
		}
		//显示页数最大个数
		int PageSize = 4;
		
		if(nowPage > allPageNum) {
			nowPage =allPageNum;
		}
		//当前页数
		if(nowPage <=0) {
			nowPage = 1;
		}
		//分页遍历起始页码
		int beginPage = nowPage;
		//分页遍历结束页码
		int endPage = beginPage +PageSize;	
		if(endPage > allPageNum) {
			endPage = allPageNum;
		}
		if(beginPage >allPageNum-PageSize) {
			beginPage = allPageNum-PageSize;
			if(beginPage<=0) {
				beginPage = 1;
			}
		}
		//当前数据库查询的起始位置
		int nowPageNum = (nowPage - 1) * size;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("nowPageNum", nowPageNum);
		map.put("size", size);
		List<Users> users = usersServer.ShowAllUsers(map);
		if(users != null) {
			model.addAttribute("users", users);
			model.addAttribute("nowPage", nowPage);
			model.addAttribute("allPageNum", allPageNum);
			model.addAttribute("beginPage", beginPage);
			model.addAttribute("endPage", endPage);
			path = "users/usersOperation";
		}
		return path;
	}
	
	/**
	 * 查看搜索框输入条件的会员信息
	 * @param userPhone
	 * @return
	 */
	@RequestMapping(value = "showInputUsers/{nowPage}")
	public String showInputUsers(String userRealName,@PathVariable("nowPage") int nowPage,Model model){
		String path = "error";
		if(userRealName != null) {
			userRealNames = userRealName;
		}		
		//显示条数
		int size = 2;
		
		//数据总条数
		int allPage = usersServer.showAllPage(userRealNames);
		//总页数
		int allPageNum = 1;
		if(allPage % size >0) {
			allPageNum = allPage / size +1;
		}else if(allPage % size == 0) {
			allPageNum = allPage / size;
		}
		//显示页数最大个数
		int PageSize = 3;
		
		if(nowPage > allPageNum) {
			nowPage =allPageNum;
		}
		//当前页数
		if(nowPage <=0) {
			nowPage = 1;
		}
		//分页遍历起始页码
		int beginPage = nowPage;
		//分页遍历结束页码
		int endPage = beginPage +PageSize;	
		if(endPage > allPageNum) {
			endPage = allPageNum;
		}
		if(beginPage >allPageNum-PageSize) {
			beginPage = allPageNum-PageSize;
			if(beginPage<=0) {
				beginPage = 1;
			}
		}
		//当前数据库查询的起始位置
		int nowPageNum = (nowPage - 1) * size;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userRealNames", userRealNames);
		map.put("nowPageNum", nowPageNum);
		map.put("size", size);
		List<Users> users = usersServer.ShowInputUsers(map);
		if(users != null) {
			model.addAttribute("userRealNames", userRealNames);
			model.addAttribute("users", users);
			model.addAttribute("nowPage", nowPage);
			model.addAttribute("allPageNum", allPageNum);
			model.addAttribute("beginPage", beginPage);
			model.addAttribute("endPage", endPage);
			path = "users/usersInputOperation";
		}
		return path;
	}
	
	/**
	 * 会员登录
	 * @param users
	 * @param model
	 * @return
	 */
	@RequestMapping("/userLogin")
	public String userLogin(Users users, HttpServletRequest request, Model model) {
		String path = "error";
		Users userss = usersServer.userLogin(users);
		if(userss != null) {
			request.getSession().setAttribute("userss", userss);
			request.getSession().setAttribute("customer",userss);
			request.getSession().setAttribute("loginKey" ,0);
			path = "redirect:/gatewayShowAllRoomType/0";
		}
		return path;
	}
	
	/**
	 * 会员注销
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/userCancellation",method = RequestMethod.GET)
	public String userCancellation(HttpSession session) {
		session.invalidate();
		return "redirect:/gatewayShowAllRoomType/0";
	}









}

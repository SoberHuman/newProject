package org.soft.hotel.server;

import java.util.List;
import java.util.Map;

import org.soft.hotel.dao.UsersDAO;
import org.soft.hotel.model.Reservation;
import org.soft.hotel.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

/**
 * 会员用户模块
 * @author Administrator
 *
 */
@Controller("UsersServer")
public class UsersServer {

	@Autowired
	private UsersDAO usersDAO;
	/**
	 * 新增会员
	 * @return
	 */
	public boolean NewUsers(Users users) {
		boolean b = usersDAO.NewUsers(users);
		return b;
	}
	
	/**
	 * 修改会员信息
	 * @param users
	 * @return
	 */
	public boolean UpdateUsers(Users users){
		boolean b = usersDAO.UpdateUsers(users);
		return b;
	}
	/**
	 * 用户修改密码
	 */
	public boolean personalModify(Users users){
		boolean b = usersDAO.personalModify(users);
		return b;
	}

	/**
	 * 个人订单
	 */
	public List<Reservation> queryOrder(Users users){
		List<Reservation> reservations= usersDAO.queryOrder(users);
		return reservations;
	}



	/**
	 * 删除会员
	 * @param usersId
	 * @return
	 */
	public boolean DeleteUsers(int usersId){
		boolean b = usersDAO.DeleteUsers(usersId);
		return b;
	}
	
	/**
	 * 查看所有会员信息
	 * @return
	 */
	public List<Users> ShowAllUsers(Map<String, Object> map){
		List<Users> users = usersDAO.showAllUsers(map);
		return users;
	}
	
	/**
	 * 统计信息总条数
	 * @param userRealNames
	 * @return
	 */
	public int showAllPage() {
		int allPage = usersDAO.showAllPage();
		return allPage;
	}
	
	/**
	 * 查看搜索框输入条件的会员信息
	 * @param userPhone
	 * @return
	 */
	public List<Users> ShowInputUsers(Map<String, Object> map){
		List<Users> users = usersDAO.ShowInputUsers(map);
		return users;
	}
	/**
	 * 统计搜索框输入条件下的信息总条数
	 * @param userRealNames
	 * @return
	 */
	public int showAllPage(String userRealNames) {
		int allPage = usersDAO.showInptAllPage(userRealNames);
		return allPage;
	}
	
	/**
	 * 通过入住登记输入的身份证号查询会员id
	 * @param userIdCard
	 * @return
	 */
	public int showUsersId(String checkinIdCard) {
		int usersId = usersDAO.showUsersId(checkinIdCard);
		return usersId;
	}


	public boolean userIntegral(String checkinIdCard){
		boolean b = usersDAO.userIntegral(checkinIdCard);
		return b;
	}
	/**
	 * 通过入住登记输入的身份证号查询是否为会员
	 * @param userIdCard
	 * @return
	 */
	public int showJudgeUsers(String checkinIdCard) {
		int showJudgeUsersNum = usersDAO.showJudgeUsers(checkinIdCard);
		return showJudgeUsersNum;
	}
	
	/**
	 * 通过userId查询会员信息
	 * @param usersId
	 * @return
	 */
	public Users showUsers(int usersId) {
		Users users = usersDAO.showUsers(usersId);
		return users;
	}
	/**
	 * 输入框条件下的会员ID
	 * @param userRealNames
	 * @return
	 */
	public int showInputUsersId(String userRealNames) {
		int usersId = usersDAO.showInputUsersId(userRealNames);
		return usersId;
	}
	
	/**
	 * 会员登录
	 * @param users
	 * @return
	 */
	public Users userLogin(Users users) {
		Users users2 = usersDAO.userLogin(users);
		return users2;
	}
	
	/**
	 * 会员注册是判断账号是否重复
	 * @param userVipId
	 * @return
	 */
	public int showUserVipId(String userVipId) {
		int showUserVipId = usersDAO.showUserVipId(userVipId);
		return showUserVipId;
	}
}

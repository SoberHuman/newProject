package org.soft.hotel.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;
import org.soft.hotel.model.Reservation;
import org.soft.hotel.model.Users;
import org.soft.hotel.querySql.userQuery;

/**
 * 会员用户模块
 * @author Administrator
 *
 */
@Mapper
public interface UsersDAO {

	/**
	 * 新增会员
	 * @return
	 */
	@Insert("insert into users(userVipId,userRealName,userPass,userIdCard,userPhone) value(#{userVipId},#{userRealName},#{userPass},#{userIdCard},#{userPhone})")
	public boolean NewUsers(Users users);
	
	/**
	 * 修改会员信息
	 * @param users
	 * @return
	 */
	@Update("update users set userRealName = #{userRealName},userPass=#{userPass},userPhone = #{userPhone},userIntegral=#{userIntegral} where usersId = #{usersId}")
	public boolean UpdateUsers(Users users);





	/**
	 * 用户修改密码
	 */
	@Update("update users set userPass = #{userPass} where usersId = #{usersId}")
	public boolean personalModify(Users users);


	/**
	 * 个人订单
	 */
	@Results({
			@Result(id = true,property = "roomTypeId",column = "roomTypeId"),
			@Result(property = "roomType",column = "roomTypeId",one=@One(select = "org.soft.hotel.dao.RoomTypeDAO.ShowRoomType"))
	})
	@Select("SELECT  re.* FROM users us INNER JOIN reservation re ON us.userIdCard = re.reservationIdCard AND us.userIdCard =#{userIdCard} ")
	public List<Reservation> queryOrder(Users users);

	/**
	 * 删除会员
	 * @param usersId
	 * @return
	 */
	@Delete("delete from users where usersId = #{usersId}")
	public boolean DeleteUsers(int usersId);
	
	/**
	 * 查看所有会员信息
	 * @return
	 */
	@SelectProvider(type = userQuery.class,method = "queryUsers")
	public List<Users> showAllUsers(Map<String, Object> map);
	
	/**
	 * 统计信息总条数
	 * @param userRealNames
	 * @return
	 */
	@SelectProvider(type = userQuery.class,method = "queryUsersAllPage")
	public int showAllPage();
	
	/**
	 * 查看搜索框输入条件的会员信息
	 * @param userPhone
	 * @return
	 */
	@SelectProvider(type = userQuery.class,method = "queryInputUsers")
	public List<Users> ShowInputUsers(Map<String, Object> map);
	
	/**
	 * 统计搜索框输入条件下的信息总条数
	 * @param userRealNames
	 * @return
	 */
	@SelectProvider(type = userQuery.class,method = "queryInputUsersAllPage")
	public int showInptAllPage(String userRealNames);
	
	/**
	 * 通过入住登记输入的身份证号查询会员id
	 * @param userIdCard
	 * @return
	 */
	@Select("select usersId from users where userIdCard = #{checkinIdCard}")
	public int showUsersId(String checkinIdCard);


	/**
	 *积分
	 */
	@Update("update users set userIntegral=userIntegral+10 where userIdCard = #{checkinIdCard}")
	public boolean userIntegral(String checkinIdCard);



	/**
	 * 通过入住登记输入的身份证号查询是否为会员
	 * @param userIdCard
	 * @return
	 */
	@Select("select count(*) from users where userIdCard = #{userIdCard}")
	public int showJudgeUsers(String userIdCard);
	
	
	/**
	 * 通过userId查询会员信息
	 * @param usersId
	 * @return
	 */
	@Select("select userRealName,userIdCard,userPhone from users where usersId = #{usersId}")
	public Users showUsers(int usersId);
	
	/**
	 * 输入框条件下的会员ID
	 * @param userRealNames
	 * @return
	 */
	@SelectProvider(value = userQuery.class,method =  "showInputUsersId")
	public int showInputUsersId(String userRealNames);
	
	/**
	 * 会员登录
	 * @param users
	 * @return
	 */
	@Select("select * from users where userPhone = #{userPhone} and userPass=#{userPass}")
	public Users userLogin(Users users);
	
	/**
	 * 会员注册是判断账号是否重复
	 * @param userVipId
	 * @return
	 */
	@Select("select count(*) from users where userVipId = #{userVipId}")
	public int showUserVipId(String userVipId);
}

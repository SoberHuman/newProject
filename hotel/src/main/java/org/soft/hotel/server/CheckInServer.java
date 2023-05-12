package org.soft.hotel.server;

import java.util.List;
import java.util.Map;

import org.soft.hotel.dao.CheckInDAO;
import org.soft.hotel.model.Checkin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 入住模块
 * @author Administrator
 *
 */
@Controller("CheckInServer")
public class CheckInServer{

	@Autowired
	private CheckInDAO checkInDAO;
	
	/**
	 * 入住登记
	 * @param checkin
	 * @return
	 */
	public boolean checkIn(Checkin checkin) {
		boolean b = checkInDAO.checkIn(checkin);
		return b;
	}
	
	/**
	 * 查询房间的入住信息
	 * @param roomId
	 * @return
	 */
	public Checkin showCheckIn(int roomId) {
		Checkin checkin = checkInDAO.showCheckIn(roomId);
		return checkin;
	}
	
	/**
	 * 删除入住记录
	 * @param checkinId
	 * @return
	 */
	public boolean checkInDelete(int checkinId) {
		boolean b = checkInDAO.checkInDelete(checkinId);
		return b;
	}
	
	/**
	 * 查询所有会员入住记录
	 * @param nowPageRowNum
	 * @param size
	 * @return
	 */
	public List<Checkin> showAllUsersCheckIn(Map<String, Object> map){
		List<Checkin> checkins = checkInDAO.showAllUsersCheckIn(map);
		return checkins;
	}
	
	/**
	 * 查询会员入住记录 总页数
	 * @param size
	 * @return
	 */
	public int allUsersPage() {
		int allUsersPageNum = checkInDAO.allUsersPage();
		return allUsersPageNum;
	}
	
	/**
	 * 查询输入框条件下所有会员入住记录
	 * @param nowPageRowNum
	 * @param size
	 * @return
	 */
	public List<Checkin> showInputUsersCheckIn(Map<String, Object> map){
		List<Checkin> checkins = checkInDAO.showInputUsersCheckIn(map);
		return checkins;
	}
	
	/**
	 * 查询输入框条件下会员入住记录 总页数
	 * @param size
	 * @return
	 */
	public int inputUsersPage(int roomId) {
		int inputUsersPage = checkInDAO.inputUsersPage(roomId);
		return inputUsersPage;
	}
	
	
	/**
	 * 查询所有普通客户入住记录
	 * @param nowPageRowNum
	 * @param size
	 * @return
	 */
	public List<Checkin> showAllClientCheckIn(Map<String, Object> map){
		List<Checkin> checkins = checkInDAO.showAllClientCheckIn(map);
		return checkins;
	}

	/**
	 * 查询普通客户入住记录 总页数
	 * @param size
	 * @return
	 */
	public int allClientPage() {
		int allClientPageNum = checkInDAO.allClientPage();
		return allClientPageNum;
	}
	
	/**
	 * 查询输入框条件下所有普通客户入住记录
	 * @param nowPageRowNum
	 * @param size
	 * @return
	 */
	public List<Checkin> showInputClientCheckIn(Map<String, Object> map){
		List<Checkin> checkins = checkInDAO.showInputClientCheckIn(map);
		return checkins;
	}

	/**
	 * 查询输入框条件下普通客户入住记录 总页数
	 * @param size
	 * @return
	 */
	public int inputClientPage(int roomId) {
		int inputClientPage = checkInDAO.inputClientPage(roomId);
		return inputClientPage;
	}
	
	/**
	 * 通过房间id查询入住记录id
	 * @param roomId
	 * @return
	 */
	public int showCheckinId(int roomId) {
		int checkinId = checkInDAO.showCheckinId(roomId);
		return checkinId;
	}
	/**
	 * 续住登记
	 * @param checkin
	 * @return
	 */
	public boolean Continued(Checkin checkin) {
		boolean b = checkInDAO.Continued(checkin);
		return b;		
	}
	
	/**
	 * 统计指定房间类型的日入住房间
	 * @param roomTypeId
	 * @return
	 */
	public int countCheckinRoomTypeData(int roomTypeId,String dataNum) {
		int countCheckinRoomTypeData = checkInDAO.countCheckinRoomTypeData(roomTypeId,dataNum);
		return countCheckinRoomTypeData;
	}
	
	/**
	 * 统计指定房间类型的周入住房间
	 * @param roomTypeId
	 * @return
	 */
	public int countCheckinRoomTypeWeek(int roomTypeId) {
		int countCheckinRoomTypeWeek = checkInDAO.countCheckinRoomTypeWeek(roomTypeId);
		return countCheckinRoomTypeWeek;
	}
	
	/**
	 * 统计指定房间类型的年入住房间
	 * @param roomTypeId
	 * @return
	 */
	public int countCheckinRoomTypeNowYear(int roomTypeId,int nowYearNum) {
		int countCheckinRoomTypeNowYear = checkInDAO.countCheckinRoomTypeNowYear(roomTypeId,nowYearNum);
		return countCheckinRoomTypeNowYear;
	}
	
	/**
	 * 统计指定房间类型的指定起止日期下的入住房间
	 * @param map
	 * @return
	 */
	public int countCheckInRoomTtypeStartAndStopDates(Map<String, Object> map) {
		int countCheckInRoomTtypeStartAndStopDates = checkInDAO.countCheckInRoomTtypeStartAndStopDates(map);
		return countCheckInRoomTtypeStartAndStopDates;
	}
	
	/**
	 * 统计指定房间类型的指定年月下的入住房间
	 * @param roomTypeId
	 * @return
	 */
	public int countCheckinRoomTypeYearAndDates(int roomTypeId,String yearAndDates) {
		int countCheckinRoomTypeYearAndDates = checkInDAO.countCheckinRoomTypeYearAndDates(roomTypeId, yearAndDates);
		return countCheckinRoomTypeYearAndDates;
	}
	
	/**
	 * 统计指定房间类型的指定年份下的入住房间
	 * @param roomTypeId
	 * @return
	 */
	public int countCheckinRoomTypeYear(int roomTypeId,String yearNum) {
		int countCheckinRoomTypeYear = checkInDAO.countCheckinRoomTypeYear(roomTypeId, yearNum);
		return countCheckinRoomTypeYear;
	}
	
	/**
	 * 统计今日退房房间数
	 * @return
	 */
	public int countNowCheckOut() {
		int countNowCheckOut = checkInDAO.countNowCheckOut();
		return countNowCheckOut;
	}
}

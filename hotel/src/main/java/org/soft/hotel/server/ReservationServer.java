package org.soft.hotel.server;

import java.util.List;
import java.util.Map;

import org.apache.catalina.User;
import org.soft.hotel.dao.ReservationDAO;
import org.soft.hotel.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 预订模块
 * @author Administrator
 *
 */
@Controller("ReservationServer")
public class ReservationServer {

	@Autowired
	private ReservationDAO reservationDAO;

	/**
	 * 用于判断是普通用户还是VIP用户
	 */
	public Users vipUsers(String userPhone){
		Users users = reservationDAO.selectVipUser(userPhone);
		return users;
	}
	public Client NoVipUsrs(String clientPhone){
		Client client = reservationDAO.selectNoVipUser(clientPhone);
		return client;
	}



	/**
	 * 预订登记
	 * @param reservation
	 * @return
	 */
	public boolean reservation(Reservation reservation) {
		boolean b = reservationDAO.reservation(reservation);
		return b;
	}



	/**
	 * 更改房间状态
	 */
	public boolean UpRoomState(int roomId){
		boolean b = reservationDAO.updateRoomState(roomId);
		return b;
	}


	/**
	 * 房间其他信息
	 */
	public RoomType roomTypes(int roomTypeId){
		RoomType roomTypeInfo = reservationDAO.selectRoomtypeInfo(roomTypeId);
		return roomTypeInfo;
	}

	/**
	 * 当前预定信息
	 */
	public Reservation queryReservation(String reservationPhoneNumber){
		Reservation reservationInfo = reservationDAO.selectReservationInfo(reservationPhoneNumber);
		return reservationInfo;
	}

	/**
	 * 查看干净且空闲的房间
	 */
	public List<Room> queryRoom(int roomTypeId){
		List<Room> room = reservationDAO.selectRoomInfo(roomTypeId);
		return room;
	}


	/**
	 * 删除预订记录
	 * @param reservationId
	 * @return
	 */
	public boolean deleteReservation(int reservationId) {
		boolean b = reservationDAO.deleteReservation(reservationId);
		return b;
	}
	
	/**
	 * 入住之后修改预订状态
	 * @param reservationId
	 * @return
	 */
	public boolean UpdateReservationStatus(int reservationId) {
		boolean b = reservationDAO.UpdateReservationStatus(reservationId);
		return b;
	}
	
	
	/**
	 * 查看所有预订记录
	 * @return
	 */
	public List<Reservation> showAllReservation(Map<String, Object> map){
		List<Reservation> reservations = reservationDAO.showAllReservation(map);
		return reservations;
	}
	
	/**
	 * 查询预订记录总页数
	 * @param size
	 * @return
	 */
	public int allPage() {
		int allPageNum = reservationDAO.allPage();
		return allPageNum;
	}
	
	/**
	 * 查看输入框条件下的所有预订记录
	 * @return
	 */
	public List<Reservation> showInputReservation(Map<String, Object> map){
		List<Reservation> reservations = reservationDAO.showInputReservation(map);
		return reservations;
	}
	
	/**
	 * 查询输入框条件下的预订记录总页数
	 * @param size
	 * @return
	 */
	public int showInputAllPage(int roomId) {
		int allPageNum = reservationDAO.showInputAllPage(roomId);
		return allPageNum;
	}
	
	/**
	 * 查看已入住预订记录
	 * @return
	 */
	public List<Reservation> showAllCheckInReservation(Map<String, Object> map){
		List<Reservation> reservations = reservationDAO.showAllCheckInReservation(map);
		return reservations;
	}
		
	/**
	 * 查询未已住预订记录总页数
	 * @param size
	 * @return
	 */
	public int allCheckInPage() {
		int allCheckInPageNum = reservationDAO.allCheckInPage();
		return allCheckInPageNum;
	}
	
	/**
	 * 查看预订中的预订记录
	 * @return
	 */
	public List<Reservation> showAllNoCheckInReservation(Map<String, Object> map){
		List<Reservation> reservations = reservationDAO.showAllNoCheckInReservation(map);
		return reservations;
	}
		
	/**
	 * 查询预订中的预订记录总页数
	 * @param size
	 * @return
	 */
	public int allNoCheckInPage() {
		int allNoCheckInPageNum = reservationDAO.allNoCheckInPage();
		return allNoCheckInPageNum;
	}
	
	/**
	 * 查看退订记录
	 * @return
	 */
	public List<Reservation> showAllUnsubscribeReservation(Map<String, Object> map){
		List<Reservation> reservations = reservationDAO.showAllUnsubscribeReservation(map);
		return reservations;
	}
	
	/**
	 * 查询退订记录总页数
	 * @param size
	 * @return
	 */
	public int allUnsubscribePage() {
		int allUnsubscribePageNum = reservationDAO.allUnsubscribePage();
		return allUnsubscribePageNum;
	}
	
	/**
	 * 查看未处理预订订单
	 * @return
	 */
	public List<Reservation> showUserReservation(Map<String, Object> map){
		List<Reservation> reservations = reservationDAO.showUserReservation(map);
		return reservations;
	}
	
	/**
	 * 查询未处理预订订单总页数
	 * @param size
	 * @return
	 */
	public int allUserReservation() {
		int allUserReservation = reservationDAO.allUserReservation();
		return allUserReservation;
	}
	
	/**
	 * 通过房间id查询预订记录进行退订
	 * @param roomId
	 * @return
	 */
	public Reservation showReservation(int roomId) {
		Reservation reservation = reservationDAO.showReservation(roomId);
		return reservation;
	}
	
	/**
	 * 修改预订记录进行退订
	 * @param reservationId
	 * @return
	 */
	public boolean UpdateReservation(Reservation reservation) {
		boolean b = reservationDAO.UpdateReservation(reservation);
		return b;
	}
	
	/**
	 * 通过房间 id查询入住人信息
	 * @param roomId
	 * @return
	 */ 
	public Reservation showReservationUser(int roomId) {
		Reservation reservation = reservationDAO.showReservationUser(roomId);
		return reservation;
	}
	
	/**
	 * 通过预订记录id查询预订信息
	 * @param roomId
	 * @return
	 */
	public Reservation showReservationDetail(int reservationId) {
		Reservation reservation = reservationDAO.showReservationDetail(reservationId);
		return reservation;
	}
	
	/**
	 * 修改预订记录的预订人信息
	 * @param reservationId
	 * @return
	 */
	public boolean updateReservationUsers(Reservation reservation) {
		boolean b = reservationDAO.updateReservationUsers(reservation);
		return b;
	}
	
	/**
	 * 统计未处理的客户预订订单数
	 * @return
	 */
	public int countUserReservation() {
		int countUserReservation = reservationDAO.countUserReservation();
		return countUserReservation;
	}
}

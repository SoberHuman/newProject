package org.soft.hotel.server.ctrl;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.coyote.Request;
import org.soft.hotel.model.*;
import org.soft.hotel.server.IncomeServer;
import org.soft.hotel.server.ReservationServer;
import org.soft.hotel.server.RoomServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 预订模块
 * @author Administrator
 *
 */
@Controller
public class ReservationServerCtrl {

	@Autowired
	@Qualifier("ReservationServer")
	private ReservationServer reservationServer;
	
	@Autowired
	@Qualifier("RoomServer")
	private RoomServer roomServer;
	
	@Autowired
	@Qualifier("IncomeServer")
	private IncomeServer incomeServer;
	
	//用于存储输入框输入的房间号
	private String roomNumbers;
	
	/**
	 * 预订登记
	 * @param reservation
	 * @return
	 */
	@RequestMapping("/reservation")
	public String reservation(Reservation reservation , int paymentMethod) {
		System.out.println(reservation.getReservationForegift());
		String path = "error";
		//修改房间状态为预订状态
		int roomStatus = 1;
		int roomId = reservation.getRoomId();
		boolean b = roomServer.updateRoomStatus(roomStatus, roomId);	 	
		if(b) {
			//通过房间id查询房间类型id
			int roomTypeId = roomServer.showRoomTypeId(roomId);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("roomTypeId",roomTypeId);
			map.put("staffId", reservation.getStaffId());
			map.put("paymentMethod", paymentMethod);
//			map.put("incomeTime", reservation.getReservationTime());
			map.put("incomeMoney",reservation.getReservationForegift());
			map.put("incomeType",1);
			//新增收入
			incomeServer.addIncome(map);
			//添加预订记录
			boolean reservations = reservationServer.reservation(reservation);
			if(reservations) {
				path = "redirect:/showAllRoom/"+roomTypeId;
			}			
		}
		return path;
	}
	
	/**
	 * 客户在官网预订登记
	 * @param reservation
	 * @return
	 */
	@RequestMapping("/userReservation")
	public String userReservation(Reservation reservation, HttpSession httpSession, HttpServletRequest request,int roomTypeId , Model model) {
		String path = "/gateway/userReservationPreview";
		reservation.setRoomTypeId(roomTypeId);
		RoomType roomTypeInfo = reservationServer.roomTypes(roomTypeId);
		reservation.setRoomTypeName(roomTypeInfo.getRoomTypeName());
		reservation.setReservationForegift(roomTypeInfo.getReservationForegift());

		int selectMenu = Integer.parseInt(request.getParameter("selectMenu"));
		request.getSession().setAttribute("selectMenu",selectMenu);
		//判断是VIP还是普通用户，进行标价
		int loginKey = Integer.parseInt(request.getSession().getAttribute("loginKey").toString());
		Users users = null;
		Client client = null;
		double Price = 0;
		if(loginKey==0){
			users = (Users) request.getSession().getAttribute("customer");

			if(selectMenu==1){
				Price= roomTypeInfo.getVipPrice()+reservation.getReservationForegift();
			}
			if(selectMenu==0){
				Price = reservation.getReservationForegift();
			}
		}else if(loginKey==1){
			client = (Client)request.getSession().getAttribute("customer");

			if(selectMenu==1){
				Price = roomTypeInfo.getListPrice()+reservation.getReservationForegift();
			}
			if(selectMenu==0){
				Price = reservation.getReservationForegift();
			}
		}





//		model.addAttribute("reservation",reservation);
		httpSession.setAttribute("reservation",reservation);
		model.addAttribute("selectMenu",selectMenu);
		model.addAttribute("users",users);
		model.addAttribute("client",client);
		model.addAttribute("roomTypeInfo",roomTypeInfo);
		model.addAttribute("Price",Price);
		request.getSession().setAttribute("Price",Price);
//		System.out.println(reservation.getReservationName());
		return path;
	}
//	@RequestMapping("/userReservation")
//	public String userReservation(Reservation reservation,HttpSession httpSession,int roomTypeId,Model model) {
//
//		String path = "error";
//		Users users = (Users) httpSession.getAttribute("userss");
//		reservation.setReservationName(users.getUserRealName());
//		reservation.setReservationIdCard(users.getUserIdCard());
//		reservation.setReservationPhoneNumber(users.getUserPhone());
//		reservation.setRoomTypeId(roomTypeId);
//		int reservationStatus = 0;
//		reservation.setReservationStatus(reservationStatus);
////		System.out.println(reservation.getExpectedTimeOfArrival());
//		RoomType roomTypeInfo = reservationServer.roomTypes(roomTypeId);
//		reservation.setReservationForegift(roomTypeInfo.getReservationForegift());
//
//
//		boolean reservations = false;
//		//查询干净且空闲的房间
//		List<Room> roomInfo = reservationServer.queryRoom(reservation.getRoomTypeId()) ;
//		if(roomInfo.size()!=0){
//			int roomId = 0;
//			Random random = new Random();
//			List<Integer> roomNumber = new ArrayList<>();
//			for(Room room :roomInfo){
//				roomNumber.add(room.getRoomId());
//			}
//			int roomIdCount = roomNumber.size();
//			int index = random.nextInt(roomIdCount);
//			roomId = roomNumber.get(index);
//			reservation.setRoomId(roomId);
//
//			//添加预订记录
//			reservations = reservationServer.reservation(reservation);
//			//更改房间状态
//			boolean roomState = reservationServer.UpRoomState(roomId);
//
//		}else {
//			System.out.println("房间已售罄");
//		}
//
//
//
//
//		if(reservations) {
////			path = "redirect:/gatewayShowAllRoomType/0";
//			Reservation reservationInfo = reservationServer.queryReservation(reservation.getReservationPhoneNumber());
//			model.addAttribute("reservationInfo",reservationInfo);
//			path = "/gateway/userReservationPreview";
//		}
//		return path;
//	}
	
	/**
	 * 删除预订记录
	 * @param reservationId
	 * @return
	 */
	@RequestMapping("/deleteReservation")
	public String deleteReservation(int reservationId) {
		String path = "error";
		boolean b = reservationServer.deleteReservation(reservationId);
		if(b) {
			path = "redirect:/showAllReservation/1";
		}
		return path;
	}
	
	/**
	 * 修改预订记录的预订人信息
	 * @param reservationId
	 * @return
	 */
	@RequestMapping("/updateReservationUsers")
	public String updateReservationUsers(Reservation reservation) {
			String path = "error";
			boolean b = reservationServer.updateReservationUsers(reservation);
			if(b) {
				path = "redirect:/showAllReservation/1";
			}
			return path;
	}
	
	/**
	 * 查看所有预订记录
	 * @return
	 */
	@RequestMapping(value = "/showAllReservation/{nowPage}")
	public String showAllReservation(@PathVariable("nowPage") int nowPage,Model model){
		String path = "error";	
		//显示条数
		int size = 5;
		//数据总条数
		int allPage = reservationServer.allPage();
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

		List<Reservation> reservations = reservationServer.showAllReservation(map);
		for(Reservation reservation :reservations){
			System.out.println(reservation.getReservationStatus());
		}
		if(reservations != null) {
			model.addAttribute("reservations", reservations);
			model.addAttribute("nowPage", nowPage);
			model.addAttribute("allPageNum", allPageNum);
			model.addAttribute("beginPage", beginPage);
			model.addAttribute("endPage", endPage);

			path = "reservation/reservationOp";
		}
		return path;
	}
	
	/**
	 * 查看输入框指定房间下的所有预订记录
	 * @return
	 */
	@RequestMapping(value = "/showInputReservation/{nowPage}")
	public String showInputReservation(@PathVariable("nowPage") int nowPage,String roomNumber,Model model){
		String path = "error";	
		if(roomNumber != null) {
			roomNumbers = roomNumber;
		}
		//通过房间号查询房间类型Id和房间Id
		Room room = roomServer.showRoomTypeIdAndRoomId(roomNumbers);
		int roomId = room.getRoomId();
		//显示条数
		int size = 2;
		//数据总条数
		int allPage = reservationServer.showInputAllPage(roomId);
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
		map.put("roomId", roomId);
		map.put("nowPageNum", nowPageNum);
		map.put("size", size);
		List<Reservation> reservations = reservationServer.showInputReservation(map);
		if(reservations != null) {
			model.addAttribute("roomNumbers", roomNumbers);
			model.addAttribute("reservations", reservations);
			model.addAttribute("nowPage", nowPage);
			model.addAttribute("allPageNum", allPageNum);
			model.addAttribute("beginPage", beginPage);
			model.addAttribute("endPage", endPage);
			path = "reservation/reservationInp";
		}
		return path;
	}
	
	/**
	 * 修改预订记录进行退订
	 * @param reservationId
	 * @return
	 */
	@RequestMapping("/updateReservation")
	public String updateReservation(Reservation reservation) {

			String path = "error";
			int roomStatus = 0;
			int roomId = reservation.getRoomId();
			//修改房间状态为空闲
			boolean updateRoomStatus = roomServer.updateRoomStatus(roomStatus, roomId);
			if(updateRoomStatus) {
				int reservationStatus = 2;
				reservation.setReservationStatus(reservationStatus);
				//如果修改房间状态成功，则修改预订记录
				boolean b = reservationServer.UpdateReservation(reservation);
				if(b) {
					path = "redirect:/showAllReservation/1";
				}else {
					//如果修改不成功，则修改房间记录为预订
					roomStatus = 1;
					roomServer.updateRoomStatus(roomStatus, roomId);
				}
			}			 
			return path;
	}




	/**
	 * 用户修改预订记录进行退订
	 * @param reservationId
	 * @return
	 */
	@RequestMapping("/updateReservation2")
	public String updateReservation2(Reservation reservation) {
		System.out.println(reservation.getUnsubscribeForegift());
		System.out.println(reservation.getReservationId());
		String path = "error";
		int roomStatus = 0;
		int roomId = reservation.getRoomId();
		//修改房间状态为空闲
		boolean updateRoomStatus = roomServer.updateRoomStatus(roomStatus, roomId);
		if(updateRoomStatus) {
			int reservationStatus = 2;
			reservation.setReservationStatus(reservationStatus);
			//如果修改房间状态成功，则修改预订记录

			boolean b = reservationServer.UpdateReservation(reservation);
			if(b) {
				path = "/gateway/personalOrder";
			}else {
				//如果修改不成功，则修改房间记录为预订
				roomStatus = 1;
				roomServer.updateRoomStatus(roomStatus, roomId);
			}
		}
		return path;
	}





	
	/**
	 * 查看退订记录
	 * @return
	 */
	@RequestMapping(value = "/showAllUnsubscribeReservation/{nowPage}")
	public String showAllUnsubscribeReservation(@PathVariable("nowPage") int nowPage,Model model){
		String path = "error";	
		//显示条数
		int size = 10;		
		//数据总条数
		int allPage = reservationServer.allUnsubscribePage();
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
		List<Reservation> reservations = reservationServer.showAllUnsubscribeReservation(map);
		if(reservations != null) {
			model.addAttribute("reservations", reservations);
			model.addAttribute("nowPage", nowPage);
			model.addAttribute("allPageNum", allPageNum);
			model.addAttribute("beginPage", beginPage);
			model.addAttribute("endPage", endPage);
			path = "reservation/reservationUnsubscribe";
		}
		return path;
	}
	
	/**
	 * 查看已入住记录
	 * @return
	 */
	@RequestMapping(value = "/showAllCheckInReservation/{nowPage}")
	public String showAllCheckInReservation(@PathVariable("nowPage") int nowPage,Model model){
		String path = "error";	
		//显示条数
		int size = 10;		
		//数据总条数
		int allPage = reservationServer.allCheckInPage();
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
		List<Reservation> reservations = reservationServer.showAllCheckInReservation(map);
		if(reservations != null) {
			model.addAttribute("reservations", reservations);
			model.addAttribute("nowPage", nowPage);
			model.addAttribute("allPageNum", allPageNum);
			model.addAttribute("beginPage", beginPage);
			model.addAttribute("endPage", endPage);
			path = "reservation/reservationCheckIn";
		}
		return path;
	}
	/**
	 * 查看预订中记录
	 * @return
	 */
	@RequestMapping(value = "/showAllNoCheckInReservation/{nowPage}")
	public String showAllNoCheckInReservation(@PathVariable("nowPage") int nowPage,Model model){
		String path = "error";	
		//显示条数
		int size = 10;		
		//数据总条数
		int allPage = reservationServer.allNoCheckInPage();
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
		List<Reservation> reservations = reservationServer.showAllNoCheckInReservation(map);
		if(reservations != null) {
			model.addAttribute("reservations", reservations);
			model.addAttribute("nowPage", nowPage);
			model.addAttribute("allPageNum", allPageNum);
			model.addAttribute("beginPage", beginPage);
			model.addAttribute("endPage", endPage);
			path = "reservation/reservationNoCheckIn";
		}
		return path;
	}
	
	/**
	 * 查看未处理预订订单
	 * @return
	 */
	@RequestMapping(value = "/showUserReservation/{nowPage}")
	public String showUserReservation(@PathVariable("nowPage") int nowPage,Model model){
		String path = "error";	
		//显示条数
		int size = 10;		
		//数据总条数
		int allPage = reservationServer.allUserReservation();
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
		List<Reservation> reservations = reservationServer.showUserReservation(map);
		if(reservations != null) {
			model.addAttribute("reservations", reservations);
			model.addAttribute("nowPage", nowPage);
			model.addAttribute("allPageNum", allPageNum);
			model.addAttribute("beginPage", beginPage);
			model.addAttribute("endPage", endPage);
			path = "reservation/userReservation";
		}
		return path;
	}
}

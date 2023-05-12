package org.soft.hotel.server.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.soft.hotel.model.Checkin;
import org.soft.hotel.model.Room;
import org.soft.hotel.server.CheckInServer;
import org.soft.hotel.server.ClientConsumptionRecordServer;
import org.soft.hotel.server.ClientServer;
import org.soft.hotel.server.IncomeServer;
import org.soft.hotel.server.ReservationServer;
import org.soft.hotel.server.RoomServer;
import org.soft.hotel.server.UserConsumptionRecordServer;
import org.soft.hotel.server.UsersServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 入住模块
 * @author Administrator
 *
 */
@Controller
public class CheckInServerCtrl {

	@Autowired
	@Qualifier("CheckInServer")
	private CheckInServer checkInServer;
	
	@Autowired
	@Qualifier("UsersServer")
	private UsersServer usersServer;
	
	@Autowired
	@Qualifier("ClientServer")
	private ClientServer clientServer;
	
	@Autowired
	@Qualifier("RoomServer")
	private RoomServer roomServer;
	
	@Autowired
	@Qualifier("ReservationServer")
	private ReservationServer reservationServer;
	
	@Autowired
	@Qualifier("ClientConsumptionRecordServer")
	private ClientConsumptionRecordServer clientConsumptionRecordServer;
	
	@Autowired
	@Qualifier("UserConsumptionRecordServer")
	private UserConsumptionRecordServer userConsumptionRecordServer;
	
	@Autowired
	@Qualifier("IncomeServer")
	private IncomeServer incomeServer;
	
	//用于存储输入框输入的房间号
	private String roomNumbers;
	
		
	/**
	 * 入住登记
	 * @param checkin
	 * @return
	 */
	@RequestMapping("/checkIn")
	public String checkIn(Checkin checkin,int customerType,String checkinName,String checkinIdCard,String checkinPhone,
			int reservationId,int paymentMethod) {
		String path = "error";	
		int usersId = 0;
		int clientId = 0; 		
		if(customerType == 0) {
			boolean b = usersServer.userIntegral(checkinIdCard);
			//如果customerType == 0，说明该客户为会员客户，向checkin表新增会员id
			if(usersServer.showUsersId(checkinIdCard) >0) {
				 usersId = usersServer.showUsersId(checkinIdCard);

			}

			 checkin.setUsersId(usersId); 
			 Map<String, Object> mapUsers = new HashMap<String, Object>();
			 mapUsers.put("usersId", usersId);
			 mapUsers.put("staffId", checkin.getStaffId());
			 mapUsers.put("userConsumptionTime",checkin.getCheckinTime());
			 mapUsers.put("userConsumptionMoney", checkin.getCheckinForegift());
			 mapUsers.put("userConsumptionManner", paymentMethod);
			 userConsumptionRecordServer.NewUserConsumptionRecord(mapUsers);
		}
		if(customerType == 1) {
			//如果customerType == 1，说明该客户为普通客户，向checkin表新增普通客户id			
				if(clientServer.showClientIds(checkinIdCard) > 0) {
					clientId =clientServer.showClientId(checkinIdCard);
				}
			 //如果普通客户不存在，则新增普通客户
			 if(clientServer.showClientIds(checkinIdCard) ==0) {
				 Map<String, Object> map = new HashMap<String, Object>();
				 map.put("clientName", checkinName);
				 map.put("clientIdCard", checkinIdCard);
				 map.put("clientPhone", checkinPhone);
				 clientServer.NewClient(map);
				 clientId = clientServer.showClientId(checkinIdCard);
			 }
			 checkin.setClientId(clientId);
			 Map<String, Object> maps = new HashMap<String, Object>();
			 maps.put("clientId", clientId);
			 maps.put("staffId", checkin.getStaffId());
			 maps.put("clientConsumptionTime",checkin.getCheckinTime());
			 maps.put("clientConsumptionMoney", checkin.getCheckinForegift());
			 maps.put("clientConsumptionManner", paymentMethod);
			 clientConsumptionRecordServer.NewClientrConsumptionRecord(maps);
		}
		int roomTypeId = roomServer.showRoomTypeId(checkin.getRoomId());
		checkin.setRoomTypeId(roomTypeId);
		//入住登记
		boolean checkins = checkInServer.checkIn(checkin);
		if(checkins) {			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("roomTypeId",roomTypeId);
			map.put("staffId", checkin.getStaffId());
			map.put("paymentMethod", paymentMethod);
			map.put("incomeTime",checkin.getCheckinTime());
			map.put("incomeMoney",checkin.getCheckinForegift());
			map.put("incomeType",0);
			//新增收入
			incomeServer.addIncome(map);
			//修改房间状态，跳转到房间列表界面
			int roomStatus = 2;
			int roomId = checkin.getRoomId();
			if(reservationId != 0) {
				reservationServer.UpdateReservationStatus(reservationId);
			}
			roomServer.updateRoomStatus(roomStatus, roomId);
			path = "redirect:/showAllRoom/"+roomTypeId;
		}
	
		return path;
	}
	
	/**
	 * 续住登记
	 * @param checkin
	 * @return
	 */
	@RequestMapping("/continued")
	public String continued(Checkin checkin) {
		System.out.println(checkin.getCheckinTime());
		String path = "error";
		int roomId = checkin.getRoomId();
		//续住
		boolean b = checkInServer.Continued(checkin);
		if(b) {
			int roomTypeId = roomServer.showRoomTypeId(roomId);
			path = "redirect:/showAllRoom/"+roomTypeId;
		}
		return path;
	}
	
	/**
	 * 查询所有会员入住记录
	 * @param nowPage
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "showAllUsersCheckIn/{nowPage}")
	public String showAllUsersCheckIn(@PathVariable("nowPage") int nowPage,Model model){
		String path = "error";	
		//显示条数
		int size = 10;		
		//数据总条数
		int allPage = checkInServer.allUsersPage();
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
		List<Checkin> checkins = checkInServer.showAllUsersCheckIn(map);
		if(checkins != null) {
			model.addAttribute("checkins", checkins);
			model.addAttribute("nowPage", nowPage);
			model.addAttribute("allPageNum", allPageNum);
			model.addAttribute("beginPage", beginPage);
			model.addAttribute("endPage", endPage);
			path = "checkIn/userCheckInRecord";
		}
		return path;
	}
	
	/**
	 * 查询输入框条件下所有会员入住记录
	 * @param nowPage
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "showInputUsersCheckIn/{nowPage}")
	public String showInputUsersCheckIn(@PathVariable("nowPage") int nowPage,String roomNumber,Model model){
		String path = "error";	
		if(roomNumber != null) {
			roomNumbers = roomNumber;
		}
		//通过房间号查询房间类型Id和房间Id
		Room room = roomServer.showRoomTypeIdAndRoomId(roomNumbers);
		int roomId = room.getRoomId();
		//显示条数
		int size = 10;		
		//数据总条数
		int allPage = checkInServer.inputUsersPage(roomId);
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
		map.put("roomId", roomId);
		List<Checkin> checkins = checkInServer.showInputUsersCheckIn(map);
		if(checkins != null) {			
			model.addAttribute("roomNumber", roomNumbers);
			model.addAttribute("checkins", checkins);
			model.addAttribute("nowPage", nowPage);
			model.addAttribute("allPageNum", allPageNum);
			model.addAttribute("beginPage", beginPage);
			model.addAttribute("endPage", endPage);
			path = "checkIn/userCheckInRecordInp";
		}
		return path;
	}
	
	/**
	 * 查询所有普通客户入住记录
	 * @param nowPage
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "showAllClientCheckIn/{nowPage}")
	public String showAllClientCheckIn(@PathVariable("nowPage") int nowPage,Model model){
		String path = "error";	
		//显示条数
		int size = 10;		
		//数据总条数
		int allPage = checkInServer.allClientPage();
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
		List<Checkin> checkins = checkInServer.showAllClientCheckIn(map);
		if(checkins != null) {
			model.addAttribute("checkins", checkins);
			model.addAttribute("nowPage", nowPage);
			model.addAttribute("allPageNum", allPageNum);
			model.addAttribute("beginPage", beginPage);
			model.addAttribute("endPage", endPage);
			path = "checkIn/clientCheckInRecord";
		}
		return path;
	}
	
	/**
	 * 查询输入框条件下所有普通客户入住记录
	 * @param nowPage
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "showInputClientCheckIn/{nowPage}")
	public String showInputClientCheckIn(@PathVariable("nowPage") int nowPage,String roomNumber,Model model){
		String path = "error";	
		if(roomNumber != null) {
			roomNumbers = roomNumber;
		}
		//通过房间号查询房间类型Id和房间Id
		Room room = roomServer.showRoomTypeIdAndRoomId(roomNumbers);
		int roomId = room.getRoomId();
		//显示条数
		int size = 10;		
		//数据总条数
		int allPage = checkInServer.inputClientPage(roomId);
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
		map.put("roomId", roomId);
		List<Checkin> checkins = checkInServer.showInputClientCheckIn(map);
		if(checkins != null) {
			model.addAttribute("roomNumber", roomNumbers);
			model.addAttribute("checkins", checkins);
			model.addAttribute("nowPage", nowPage);
			model.addAttribute("allPageNum", allPageNum);
			model.addAttribute("beginPage", beginPage);
			model.addAttribute("endPage", endPage);
			path = "checkIn/clientCheckInRecordInp";
		}
		return path;
	}
}

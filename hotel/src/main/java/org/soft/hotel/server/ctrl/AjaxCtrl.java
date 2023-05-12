package org.soft.hotel.server.ctrl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.soft.hotel.model.Announcement;
import org.soft.hotel.model.Checkin;
import org.soft.hotel.model.Client;
import org.soft.hotel.model.Reservation;
import org.soft.hotel.model.Room;
import org.soft.hotel.model.RoomType;
import org.soft.hotel.model.Users;
import org.soft.hotel.server.AnnouncementServer;
import org.soft.hotel.server.CheckInServer;
import org.soft.hotel.server.ClientServer;
import org.soft.hotel.server.IncomeServer;
import org.soft.hotel.server.ReservationServer;
import org.soft.hotel.server.RoomServer;
import org.soft.hotel.server.RoomTypeServer;
import org.soft.hotel.server.UsersServer;
import org.soft.hotel.server.aliyunMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
//import com.sun.org.glassfish.gmbal.ParameterNames;
/**
 * 异步交互部分
 * @author Administrator
 *
 */
@RestController
public class AjaxCtrl {

	@Autowired
	@Qualifier("AnnouncementServer")
	private AnnouncementServer announcementServer;
	@Autowired
	@Qualifier("RoomTypeServer")
	private RoomTypeServer roomTypeServer;
	@Autowired
	@Qualifier("RoomServer")
	private RoomServer roomserver;
	@Autowired
	@Qualifier("ReservationServer")
	private ReservationServer reservationServer;
	@Autowired
	@Qualifier("UsersServer")
	private UsersServer usersServer;	
	@Autowired
	@Qualifier("CheckInServer")
	private CheckInServer checkInServer;
	@Autowired
	@Qualifier("ClientServer")
	private ClientServer clientServer;
	@Autowired
	@Qualifier("IncomeServer")
	private IncomeServer incomeServer;
	@Autowired
	@Qualifier("aliyunMessage")
	private aliyunMessage aliyunMessage;
	
	//公告部分----------------------------------------------------------------------
	/**
	 * 查看公告详情
	 * @param announcementId
	 * @return
	 */
	@RequestMapping(value = "showAnnouncement/{announcementId}")
	public Announcement showAnnouncement(@PathVariable("announcementId") int announcementId) {
		Announcement announcement = announcementServer.showAnnouncement(announcementId);
		return announcement;
	}
		
	//房间类型部分-------------------------------------------------------------------
	/**
	 * 点击修改房间类型查询房间类型信息
	 */
	@RequestMapping(value = "showRoomType/{roomTypeId}")
	public RoomType showRoomType(@PathVariable("roomTypeId") int roomTypeId) {
		RoomType roomType = roomTypeServer.ShowRoomType(roomTypeId);
		return roomType;
	}
	
	//客房部分-------------------------------------------------------------------
		/**
		 * 点击查看房间明细查询房间信息
		 */
		@RequestMapping(value = "showRoom/{roomId}")
		public Room showRoom(@PathVariable("roomId") int roomId) {
			Room room = roomserver.showRoom(roomId);
			return room;
		}
		/**
		 * 查看指定房间类型下空闲的房间
		 * @param roomTypeId
		 * @return
		 */
		@RequestMapping(value = "showRoomTypeStruts/{roomTypeId}")
		public List<String> showRoomTypeStruts(@PathVariable("roomTypeId") int roomTypeId){
			int roomStatus = 0;
			int roomSanitation = 0;
			List<Room> rooms = roomserver.showRoomTypeStruts(roomStatus, roomSanitation, roomTypeId);
			List<String> list = new ArrayList<String>(); 
			for(Room r : rooms) {
				list.add(r.getRoomNumber());
			}
			return list;
		}
	//预订记录部分----------------------------------------------------------
		/**
		 * 点击查看预订记录详情查询预订记录信息
		 */
		@RequestMapping(value = "/showReservationDetail/{reservationId}")
		public Reservation showReservationDetail(@PathVariable("reservationId") int reservationId) {
			Reservation reservation  = reservationServer.showReservationDetail(reservationId);
			return reservation;
		}
		/**
		 * 点击查看预订记录详情查询预订记录信息
		 */
		@RequestMapping(value = "/showReservation/{roomId}")
		public Reservation showReservation(@PathVariable("roomId") int roomId) {
			Reservation reservation  = reservationServer.showReservation(roomId);
			return reservation;
		}
		
		//会员部分------------------------------------------------------------
		
		/**
		 * 通过入住登记输入的身份证号查询是否为会员
		 * @param userIdCard
		 * @return
		 */
		@RequestMapping(value = "/showJudgeUsers/{userIdCard}")
		public int showJudgeUsers(@PathVariable("userIdCard") String userIdCard) {
			int showJudgeUsersNum = usersServer.showJudgeUsers(userIdCard);
			return showJudgeUsersNum;
		}
		/**
		 * 会员注册时获取验证码
		 * @param userPhone
		 * @return
		 */
		@RequestMapping(value = "/getMessage/{userPhone}")
		public String getMessage(@PathVariable("userPhone") String userPhone) {
			String message = "error";
			String randomNumStr = "";
			try {
				randomNumStr =aliyunMessage.sendSms(userPhone);
			} catch (ClientException e) {
				e.printStackTrace();
			}
			if(randomNumStr != null) {
				message = randomNumStr;
			}
			return message;
		}
		
		//入住部分------------------------------------------------------------
		/**
		 * 通过房价id查询房客信息
		 * @param roomId
		 * @return
		 */
		@RequestMapping("/showCheckIn/{roomId}")
		public Checkin showCheckIn(@PathVariable("roomId") int roomId) {
			Checkin checkin = checkInServer.showCheckIn(roomId);
			if(checkin.getUsersId() != 0) {
				int usersId = checkin.getUsersId();
				Users users = usersServer.showUsers(usersId);
				checkin.setCheckInName(users.getUserRealName());
				checkin.setCheckInIdCard(users.getUserIdCard());
				checkin.setCheckInPhone(users.getUserPhone());
			}else {
				int clientId = checkin.getClientId();
				Client client = clientServer.showClient(clientId);
				checkin.setCheckInName(client.getClientName());
				checkin.setCheckInIdCard(client.getClientIdCard());
				checkin.setCheckInPhone(client.getClientPhone());
			}
			return checkin;
		}
		
		//图表入住率部分--------------------------------------------------------------------
		/**
		 * 统计指定房间类型的日入住率
		 * @return
		 */
		@RequestMapping("/countCheckinRoomTypeData/{dataNum}")
		public List<String> countCheckinRoomTypeData(@PathVariable("dataNum") String dataNum){
			//查看所有房间类型Id和名字
			List<RoomType> roomTypes = roomTypeServer.ShowAllRoomTypeIdAndName();
			List<String> lists = new ArrayList<String>();
			for(RoomType r : roomTypes) {
				//统计指定房间类型的全部房间
				int  countRoomType = roomserver.countRoomType(r.getRoomTypeId());
				int countCheckinRoomTypeData = checkInServer.countCheckinRoomTypeData(r.getRoomTypeId(),dataNum);
				double dou =((double)countCheckinRoomTypeData/countRoomType);
				String occupancyRate = String.format("%.2f", dou);				
				lists.add(r.getRoomTypeName());
				lists.add(occupancyRate);
			}
			return lists;
		}
		
		/**
		 * 统计指定房间类型的周入住率
		 * @return
		 */
		@RequestMapping("/countCheckinRoomTypeWeek")
		public List<String> countCheckinRoomTypeWeek(){
			List<RoomType> roomTypes = roomTypeServer.ShowAllRoomTypeIdAndName();
			List<String> lists = new ArrayList<String>();
			for(RoomType r : roomTypes) {
				int  countRoomType = roomserver.countRoomType(r.getRoomTypeId());
				int countCheckinRoomTypeWeek = checkInServer.countCheckinRoomTypeWeek(r.getRoomTypeId());
				double dou =((double)countCheckinRoomTypeWeek/countRoomType);
				String occupancyRate = String.format("%.2f", dou);				
				lists.add(r.getRoomTypeName());
				lists.add(occupancyRate);
			}
			return lists;
		}
		
		/**
		 * 统计指定房间类型的月入住率
		 * @param
		 * @param
		 * @return
		 */
		@RequestMapping(value = "/countCheckInRoomTtypeStartAndStopDates/{startDates}&{stopDates}")
		public  List<String> countCheckInRoomTtypeStartAndStopDates(@PathVariable("startDates") String startDates,@PathVariable("stopDates") String stopDates){
			List<String> lists = new ArrayList<String>();
			List<RoomType> roomTypes = roomTypeServer.ShowAllRoomTypeIdAndName();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("startDates", startDates);
			map.put("stopDates", stopDates);
			for(RoomType r : roomTypes) {
				map.put("roomTypeId", r.getRoomTypeId());
				int  countRoomType = roomserver.countRoomType(r.getRoomTypeId());
				int countCheckInRoomTtypeStartAndStopDates = checkInServer.countCheckInRoomTtypeStartAndStopDates(map);
				double dou =((double)countCheckInRoomTtypeStartAndStopDates/countRoomType);
				String occupancyRate = String.format("%.2f", dou);				
				lists.add(r.getRoomTypeName());
				lists.add(occupancyRate);
			}
			return lists;
		}
		
		/**
		 * 统计指定房间类型的年入住率
		 * @param
		 * @param
		 * @return
		 */
		@RequestMapping(value = "/countCheckinRoomTypeNowYear/{yearNum}")
		public  List<String> countCheckinRoomTypeNowYear(@PathVariable("yearNum") int nowYearNum){
			List<String> lists = new ArrayList<String>();
			List<RoomType> roomTypes = roomTypeServer.ShowAllRoomTypeIdAndName();
			for(RoomType r : roomTypes) {
				int  countRoomType = roomserver.countRoomType(r.getRoomTypeId());
				int countCheckinRoomTypeNowYear = checkInServer.countCheckinRoomTypeNowYear(r.getRoomTypeId(), nowYearNum);
				double dou =((double)countCheckinRoomTypeNowYear/countRoomType);
				String occupancyRate = String.format("%.2f", dou);				
				lists.add(r.getRoomTypeName());
				lists.add(occupancyRate);
			}
			return lists;
		}
		
		/**
		 * 统计指定房间类型的指定年月下的入住率
		 * @param
		 * @return
		 */
		@RequestMapping("/countCheckinRoomTypeYearAndDates/{yearAndDates}")
		public List<String> countCheckinRoomTypeYearAndDates(@PathVariable("yearAndDates") String yearAndDates){
			List<RoomType> roomTypes = roomTypeServer.ShowAllRoomTypeIdAndName();
			List<String> lists = new ArrayList<String>();
			for(RoomType r : roomTypes) {
				int  countRoomType = roomserver.countRoomType(r.getRoomTypeId());
				int countCheckinRoomTypeYearAndDates = checkInServer.countCheckinRoomTypeYearAndDates(r.getRoomTypeId(),yearAndDates);
				double dou =((double)countCheckinRoomTypeYearAndDates/countRoomType);
				String occupancyRate = String.format("%.2f", dou);				
				lists.add(r.getRoomTypeName());
				lists.add(occupancyRate);
			}
			return lists;
		}
		
		/**
		 *  统计指定房间类型的指定年份下的入住率
		 * @param
		 * @return
		 */
		@RequestMapping("/countCheckinRoomTypeYear/{yearNum}")
		public List<String> countCheckinRoomTypeYear(@PathVariable("yearNum") String yearNum){
			List<RoomType> roomTypes = roomTypeServer.ShowAllRoomTypeIdAndName();
			List<String> lists = new ArrayList<String>();
			for(RoomType r : roomTypes) {
				int  countRoomType = roomserver.countRoomType(r.getRoomTypeId());
				int countCheckinRoomTypeYear = checkInServer.countCheckinRoomTypeYear(r.getRoomTypeId(),yearNum);
				double dou =((double)countCheckinRoomTypeYear/countRoomType);
				String occupancyRate = String.format("%.2f", dou);				
				lists.add(r.getRoomTypeName());
				lists.add(occupancyRate);
			}
			return lists;
		}
		
		//收入部分----------------------------------------------------------------------------------
		/**
		 * 查询指定房间类型的总收入
		 * @return
		 */
		@RequestMapping("/countRoomTypeAllIncome")
		public List<String> countRoomTypeAllIncome(){
			List<RoomType> roomTypes = roomTypeServer.ShowAllRoomTypeIdAndName();
			List<String> lists = new ArrayList<String>();
			for(RoomType r : roomTypes) {
				String countRoomTypeAllIncome = incomeServer.countRoomTypeAllIncome(r.getRoomTypeId());			
				lists.add(r.getRoomTypeName());
				lists.add(countRoomTypeAllIncome);
			}
			return lists;
		}
		
		/**
		 * 查询指定房间类型的日收入
		 * @return
		 */
		@RequestMapping("/countRoomTypeIncomeData")
		public List<String> countRoomTypeIncomeData(){
			List<RoomType> roomTypes = roomTypeServer.ShowAllRoomTypeIdAndName();
			List<String> lists = new ArrayList<String>();
			for(RoomType r : roomTypes) {
				String countRoomTypeAllIncome = incomeServer.countRoomTypeIncomeData(r.getRoomTypeId());			
				lists.add(r.getRoomTypeName());
				lists.add(countRoomTypeAllIncome);
			}
			return lists;
		}
		/**
		 * 查询指定房间类型的周收入
		 * @return
		 */
		@RequestMapping("/countRoomTypeIncomeWeek")
		public List<String> countRoomTypeIncomeWeek(){
			List<RoomType> roomTypes = roomTypeServer.ShowAllRoomTypeIdAndName();
			List<String> lists = new ArrayList<String>();
			for(RoomType r : roomTypes) {
				String countRoomTypeAllIncome = incomeServer.countRoomTypeIncomeWeek(r.getRoomTypeId());			
				lists.add(r.getRoomTypeName());
				lists.add(countRoomTypeAllIncome);
			}
			return lists;
		}
		/**
		 * 统计指定房间类型的月收入
		 * @return
		 */
		@RequestMapping("/countRoomTypeIncomeNowMonths")
		public List<String> countRoomTypeIncomeNowMonths(){
			List<RoomType> roomTypes = roomTypeServer.ShowAllRoomTypeIdAndName();
			List<String> lists = new ArrayList<String>();
			for(RoomType r : roomTypes) {
				String countRoomTypeIncomeNowMonths = incomeServer.countRoomTypeIncomeNowMonths(r.getRoomTypeId());			
				lists.add(r.getRoomTypeName());
				lists.add(countRoomTypeIncomeNowMonths);
			}
			return lists;
		}
		
		/**
		 * 统计指定房间类型的年收入
		 * @return
		 */
		@RequestMapping("/countRoomTypeIncomeNowYear")
		public List<String> countRoomTypeIncomeNowYear(){
			List<RoomType> roomTypes = roomTypeServer.ShowAllRoomTypeIdAndName();
			List<String> lists = new ArrayList<String>();
			for(RoomType r : roomTypes) {
				String countRoomTypeIncomeNowYear = incomeServer.countRoomTypeIncomeNowYear(r.getRoomTypeId());			
				lists.add(r.getRoomTypeName());
				lists.add(countRoomTypeIncomeNowYear);
			}
			return lists;
		}
		
		/**
		 *查询指定起止日期的收入
		 * @return
		 */
		@RequestMapping("/countRoomTypeIncomeStartAndStopDates/{startDates}&{stopDates}")
		public List<String> countRoomTypeIncomeStartAndStopDates(@PathVariable("startDates") String startDates,@PathVariable("stopDates") String stopDates){
			List<RoomType> roomTypes = roomTypeServer.ShowAllRoomTypeIdAndName();
			List<String> lists = new ArrayList<String>();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("startDates",startDates );
			map.put("stopDates", stopDates);
			for(RoomType r : roomTypes) {
				map.put("roomTypeId", r.getRoomTypeId());
				String countRoomTypeIncomeStartAndStopDates = incomeServer.countRoomTypeIncomeStartAndStopDates(map);			
				lists.add(r.getRoomTypeName());
				lists.add(countRoomTypeIncomeStartAndStopDates);
			}
			return lists;
		}
		
		/**
		 *查询指定月份的收入
		 * @return
		 */
		@RequestMapping("/countRoomTypeIncomeMonth/{months}")
		public List<String> countRoomTypeIncomeMonth(@PathVariable("months") String months){
			List<RoomType> roomTypes = roomTypeServer.ShowAllRoomTypeIdAndName();
			List<String> lists = new ArrayList<String>();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("months",months );
			for(RoomType r : roomTypes) {
				map.put("roomTypeId", r.getRoomTypeId());
				String countRoomTypeIncomeMonth = incomeServer.countRoomTypeIncomeMonth(map);			
				lists.add(r.getRoomTypeName());
				lists.add(countRoomTypeIncomeMonth);
			}
			return lists;
		}
		
		/**
		 *查询指定年份的收入
		 * @return
		 */
		@RequestMapping("/countRoomTypeIncomeYear/{years}")
		public List<String> countRoomTypeIncomeYear(@PathVariable("years") String years){
			List<RoomType> roomTypes = roomTypeServer.ShowAllRoomTypeIdAndName();
			List<String> lists = new ArrayList<String>();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("years",years );
			for(RoomType r : roomTypes) {
				map.put("roomTypeId", r.getRoomTypeId());
				String countRoomTypeIncomeYear = incomeServer.countRoomTypeIncomeYear(map);			
				lists.add(r.getRoomTypeName());
				lists.add(countRoomTypeIncomeYear);
			}
			return lists;
		}
		
}

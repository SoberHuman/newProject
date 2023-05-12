package org.soft.hotel.server.ctrl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.catalina.User;
import org.soft.hotel.model.*;
import org.soft.hotel.server.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RoomTypeServerCtrl {

	@Autowired
	@Qualifier("RoomTypeServer")
	private RoomTypeServer roomTypeServer;
	@Autowired
	@Qualifier("RoomServer")
	private RoomServer roomServer;
	@Autowired
	@Qualifier("CheckInServer")
	private CheckInServer checkInServer;
	@Autowired
	@Qualifier("AnnouncementServer")
	private AnnouncementServer announcementServer;
	@Autowired
	@Qualifier("ReservationServer")
	private ReservationServer reservationServer;




	
	/**
	 * 新增房间类型
	 * @param roomType
	 * @return
	 */
	@RequestMapping("/newRoomType")
	public String newRoomType(@RequestParam(value = "file",required = false) MultipartFile file,RoomType roomType) {

		if (file.isEmpty()) {
            System.out.println("文件为空");
        } 
		String path = "error";
		String suffixName = null;
        String fileName = file.getOriginalFilename();  // 文件名

        if(fileName.lastIndexOf("Form")!=-1){
        suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        }
        String filePath = "D:/IDEA/JavaExerciseCode/hotel/src/main/webapp/img/RType/"; // 上传后的路径
       
        fileName = UUID.randomUUID() + suffixName; // 新文件名

        
        File dest = new File(filePath + fileName);

		System.out.println(dest);  //
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String roomTypeImageUrl =  fileName;
		boolean b = roomTypeServer.NewRoomType(roomType);
		if(b) {
			if(fileName != null) {
				int roomTypeId = roomTypeServer.showRoomTypeId();
				boolean updateRoomTypeImageUrl = roomTypeServer.updateRoomTypeImageUrl(roomTypeImageUrl, roomTypeId);
				if(updateRoomTypeImageUrl) {
					path = "redirect:/showAllRoomType/0/";
				}
			}
		}
		return path;
	}
	/**
	 * 修改房间类型
	 * @param roomType
	 * @return 
	 */
	@RequestMapping("/updateRoomType")
	public String updateRoomType(@RequestParam(value = "file") MultipartFile file,RoomType roomType) {
		if (file.isEmpty()) {
            System.out.println("文件为空");
        } 
		String path = "error";
		String suffixName = null;
		 String fileName= file.getOriginalFilename();  // 文件名
			 if(fileName.lastIndexOf("Form")!=-1){
	         suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
			 }
	        String filePath = "D:/IDEA/JavaExerciseCode/hotel/src/main/webapp/img/RType/"; // 上传后的路径
	        fileName = UUID.randomUUID() + suffixName; // 新文件名
			 
	        File dest = new File(filePath + fileName);
	        if (!dest.getParentFile().exists()) {
	            dest.getParentFile().mkdirs();
	        }
	        try {
	            file.transferTo(dest);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			 
		     
        String roomTypeImageUrl =  fileName;
		boolean b = roomTypeServer.UpdateRoomType(roomType);
		if(b) {
			if(fileName != null) {
				int roomTypeId = roomType.getRoomTypeId();
				boolean updateRoomTypeImageUrl = roomTypeServer.updateRoomTypeImageUrl(roomTypeImageUrl, roomTypeId);
				if(updateRoomTypeImageUrl) {
					path = "redirect:/showAllRoomType/0/";
				}
			}		 
		}
		return path;
	}
	/**
	 * 删除房间类型
	 * @param roomTypeId
	 * @return
	 */
	@RequestMapping("/deleteRoomType")
	public String deleteRoomType(int roomTypeId) {
		String path = "error";
		boolean b = roomTypeServer.DeleteRoomType(roomTypeId);
		if(b) {
			path = "redirect:/showAllRoomType/0";
		}
		return path;
	}
	
	/**
	 * 查看所有房间类型
	 * @return
	 */
	@RequestMapping("/showAllRoomType/{op}")
	public String showAllRoomType(@PathVariable("op") int op, Model model){
		String path = "error";
		List<RoomType> roomTypes = roomTypeServer.ShowAllRoomType();
		if(roomTypes != null) {
			model.addAttribute("roomTypes", roomTypes);
			if(op == 0) {
				int countNowCheckOut = checkInServer.countNowCheckOut();
				int countUserReservation = reservationServer.countUserReservation();
				int countRoom = roomServer.countRoom();
				int countReservation = roomServer.countReservation();
				int countCheckin = roomServer.countCheckin();
				int countFree =roomServer.countFree();
				int countNotCleaned = roomServer.countNotCleaned();
				int countRepair = roomServer.countRepair();
				model.addAttribute("countNowCheckOut", countNowCheckOut);
				model.addAttribute("countUserReservation", countUserReservation);
				model.addAttribute("countRoom", countRoom);
				model.addAttribute("countReservation", countReservation);
				model.addAttribute("countCheckin", countCheckin);
				model.addAttribute("countFree", countFree);
				model.addAttribute("countNotCleaned", countNotCleaned);
				model.addAttribute("countRepair", countRepair);
				path = "roomtype/roomTypeOp";
			}else{
				path = "roomtype/roomTypeEdit";
			}
		}
		return path;
	}
	
	/**
	 * 主页和预订页显示所有房间类型
	 * @return
	 */
	@RequestMapping("/gatewayShowAllRoomType/{roomTypeId}")
	public String gatewayShowAllRoomType(@PathVariable("roomTypeId") int roomTypeId,Model model){
		String path = "error";
		List<RoomType> roomTypes = roomTypeServer.ShowAllRoomType();

		if(roomTypes != null) {
			List<Announcement> announcements = announcementServer.gatewayShowAllAnnouncement();
			if(announcements != null) {
				model.addAttribute("announcements", announcements);
				model.addAttribute("roomTypes", roomTypes);
			}
			if(roomTypeId == 0) {
				Map<String,Object> map = new HashMap<String, Object>();
				//所有干净且空闲的房间
				for(RoomType roomType:roomTypes){
					List<Room> rooms = roomTypeServer.queryNullRoom(roomType.getRoomTypeId());

					map.put(roomType.getRoomTypeName(),rooms);
				}
				model.addAttribute("map",map);
				path = "gateway/gateway";
			}else if(roomTypeId != 0) {
				RoomType roomType = roomTypeServer.ShowRoomType(roomTypeId);
				model.addAttribute("roomType", roomType);
				path = "gateway/userReservation";
			}			
		}
		return path;
	}



}

package org.soft.hotel.server.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.soft.hotel.model.CheckOut;
import org.soft.hotel.model.Room;
import org.soft.hotel.server.CheckOutServer;
import org.soft.hotel.server.RoomServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 退房模块
 * @author Administrator
 *
 */
@Controller
public class CheckOutServerCtrl{

	@Autowired
	@Qualifier("CheckOutServer")
	private CheckOutServer checkOutServer;
	
	@Autowired
	@Qualifier("RoomServer")
	private RoomServer roomServer;
	
	//用于存储输入框输入的房间号
	private String roomNumbers;
	
	/**
	 * 退房登记
	 * @param checkOut
	 * @return
	 */
	@RequestMapping("/newCheckOut")
	public String newCheckOut(CheckOut checkOut) {
		String path = "error";
		boolean b = checkOutServer.newCheckOut(checkOut);
		if(b) {
			int roomId = checkOut.getRoomId();
			int roomSanitation = 1;
			int roomStatus = 0;
			roomServer.updateRoomSanitation(roomSanitation, roomId);
			roomServer.updateRoomStatus(roomStatus, roomId);
			int roomTypeId = roomServer.showRoomTypeId(roomId);
			path = "redirect:/showAllRoom/"+roomTypeId;
		}
		return path;
	}
	
	/**
	 * 删除退房记录
	 * @param checkOutId
	 * @return
	 */
	@RequestMapping("deleteCheckOut")
	public String deleteCheckOut(int checkOutId) {
		String path = "error";
		boolean b = checkOutServer.deleteCheckOut(checkOutId);
		if(b) {
			path = "";
		}
		return path;
	}
	
	/**
	 * 查询所有会员客户退房记录
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "showAllUserCheckOut/{nowPage}")
	public String showAllUserCheckOut(@PathVariable("nowPage") int nowPage,Model model){
		System.out.println("11111111111");
		String path = "error";	
		//显示条数
		int size = 10;
		//数据总条数
		int allPage = checkOutServer.allUserCheckOutPage();
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
		List<CheckOut> checkOuts = checkOutServer.showAllUserCheckOut(map);
		if(checkOuts != null) {
			model.addAttribute("checkOuts", checkOuts);
			model.addAttribute("nowPage", nowPage);
			model.addAttribute("allPageNum", allPageNum);
			model.addAttribute("beginPage", beginPage);
			model.addAttribute("endPage", endPage);

			path = "checkOut/userCheckOutRecord";
		}
		return path;
	}
	
	/**
	 * 查询输入框条件下所有会员客户退房记录
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "showInputUserCheckOut/{nowPage}")
	public String showInputUserCheckOut(@PathVariable("nowPage") int nowPage,String roomNumber,Model model){
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
		int allPage = checkOutServer.inputUserCheckOutPage(roomId);
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
		List<CheckOut> checkOuts = checkOutServer.showInputUserCheckOut(map);
		if(checkOuts != null) {
			model.addAttribute("roomNumber", roomNumbers);
			model.addAttribute("checkOuts", checkOuts);
			model.addAttribute("nowPage", nowPage);
			model.addAttribute("allPageNum", allPageNum);
			model.addAttribute("beginPage", beginPage);
			model.addAttribute("endPage", endPage);
			path = "checkOut/userCheckOutRecordInp";
		}
		return path;
	}
	
	/**
	 * 查询所有普通客户退房记录
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "showAllClientCheckOut/{nowPage}")
	public String showAllClientCheckOut(@PathVariable("nowPage") int nowPage,Model model){
		String path = "error";	
		//显示条数
		int size = 10;		
		//数据总条数
		int allPage = checkOutServer.allClientCheckOutPage();
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
		List<CheckOut> checkOuts = checkOutServer.showAllClientCheckOut(map);
		if(checkOuts != null) {
			model.addAttribute("checkOuts", checkOuts);
			model.addAttribute("nowPage", nowPage);
			model.addAttribute("allPageNum", allPageNum);
			model.addAttribute("beginPage", beginPage);
			model.addAttribute("endPage", endPage);
			path = "checkOut/clientCheckOutRecord";
		}
		return path;
	}
	
	/**
	 * 查询输入框条件下所有普通客户退房记录
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "showInputClientCheckOut/{nowPage}")
	public String showInputClientCheckOut(@PathVariable("nowPage") int nowPage,String roomNumber,Model model){
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
		int allPage = checkOutServer.inputClientCheckOutPage(roomId);
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
		List<CheckOut> checkOuts = checkOutServer.showInputClientCheckOut(map);
		if(checkOuts != null) {
			model.addAttribute("roomNumber", roomNumbers);
			model.addAttribute("checkOuts", checkOuts);
			model.addAttribute("nowPage", nowPage);
			model.addAttribute("allPageNum", allPageNum);
			model.addAttribute("beginPage", beginPage);
			model.addAttribute("endPage", endPage);
			path = "checkOut/clientCheckOutRecordInp";
		}
		return path;
	}
}

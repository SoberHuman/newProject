package org.soft.hotel.server.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.soft.hotel.model.Maintain;
import org.soft.hotel.model.Room;
import org.soft.hotel.server.MaintainServer;
import org.soft.hotel.server.RoomServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 维修记录模块
 * @author Administrator
 *
 */
@Controller
public class MaintainServerCtrl {

	@Autowired
	@Qualifier("MaintainServer")
	private MaintainServer maintainServer;
	@Autowired
	@Qualifier("RoomServer")
	private RoomServer roomServer;
	//存储用于分页的房间号
	private String roomNumbers;
	
	/**
	 * 查询所有的维修记录
	 * @param nowPage
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/showAllMaintain/{nowPage}")
	public String showAllMaintain(@PathVariable("nowPage") int nowPage,Model model) {
		String path = "error";	
		//显示条数
		int size = 2;		
		//数据总条数
		int allPage = maintainServer.showAllPage();
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
		List<Maintain> maintains = maintainServer.showAllMaintain(map);
		if(maintains != null) {
			model.addAttribute("maintains", maintains);
			model.addAttribute("nowPage", nowPage);
			model.addAttribute("allPageNum", allPageNum);
			model.addAttribute("beginPage", beginPage);
			model.addAttribute("endPage", endPage);
			path = "logistics/maintain";
		}
		return path;
	}
	
	/**
	 * 查询指定房间的维修记录
	 * @param nowPage
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/showInputAllMaintain/{nowPage}")
	public String showInputAllMaintain(@PathVariable("nowPage") int nowPage,String roomNumber, Model model) {
		String path = "error";	
		if(roomNumber != null) {
			roomNumbers  = roomNumber;
		}
		//通过房间号查询房间类型Id和房间Id
		Room room = roomServer.showRoomTypeIdAndRoomId(roomNumbers);
		int roomId = room.getRoomId();
		System.out.println("-----------------roomId="+roomId);
		
		
		//显示条数
		int size = 2;		
		//数据总条数
		int allPage = maintainServer.showInputAllPage(roomId);
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
		List<Maintain> maintains = maintainServer.showInputAllMaintain(map);
		if(maintains != null) {
			model.addAttribute("maintains", maintains);
			model.addAttribute("nowPage", nowPage);
			model.addAttribute("allPageNum", allPageNum);
			model.addAttribute("beginPage", beginPage);
			model.addAttribute("endPage", endPage);
			model.addAttribute("roomNumbers", roomNumbers);
			path = "logistics/maintainInp";
		}
		return path;
	}
	
	/**
	 * 删除维修记录
	 * @param maintainId
	 * @return
	 */
	@RequestMapping(value = "/deleteMaintain/{maintainId}")
	public String deleteMaintain(@PathVariable("maintainId") int maintainId) {
		String path = "error";
		boolean b = maintainServer.deleteMaintain(maintainId);
		if(b) {
			path = "redirect:/showAllMaintain/1";
		}
		return path;
	}
}

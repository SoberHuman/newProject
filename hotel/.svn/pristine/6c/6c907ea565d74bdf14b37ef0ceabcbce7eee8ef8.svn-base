package org.soft.hotel.server.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.soft.hotel.model.UserConsumptionRecord;
import org.soft.hotel.server.UserConsumptionRecordServer;
import org.soft.hotel.server.UsersServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 会员消费记录模块
 * @author Administrator
 *
 */
@Controller
public class UserConsumptionRecordCtrl {

	@Autowired
	@Qualifier("UserConsumptionRecordServer")
	private UserConsumptionRecordServer userConsumptionRecordServer;
	
	@Autowired
	@Qualifier("UsersServer")
	private UsersServer usersServer; 
	//存储搜索框输入的信息
	private String userRealNames;
	
	/**
	 * 删除会员消费记录
	 * @param clientConsumptionRecordId
	 * @return
	 */
	@RequestMapping("deleteUserConsumptionRecord")
	public String deleteUserConsumptionRecord(int userConsumptionRecordId)  {
		String path = "error";
		boolean b = userConsumptionRecordServer.deleteUserConsumptionRecord(userConsumptionRecordId);
		if(b) {
			path = "redirect:/showAllUserConsumptionRecord/1";
		}
		return path;
	}
	
	/**
	 * 查看所有会员的消费记录
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/showAllUserConsumptionRecord/{nowPage}")
	public String showAllUserConsumptionRecord(@PathVariable("nowPage") int nowPage,Model model) {
		String path = "error";	
		//显示条数
		int size = 10;		
		//数据总条数
		int allPage = userConsumptionRecordServer.allUserConsumptionRecordPage();
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
		List<UserConsumptionRecord> userConsumptionRecords = userConsumptionRecordServer.showAllUserConsumptionRecord(map);
		if(userConsumptionRecords != null) {
			model.addAttribute("userConsumptionRecords", userConsumptionRecords);
			model.addAttribute("nowPage", nowPage);
			model.addAttribute("allPageNum", allPageNum);
			model.addAttribute("beginPage", beginPage);
			model.addAttribute("endPage", endPage);
			path = "userConsumptionRecord/userConsumptionRecordAll";
		}
		return path;
	}
	
	/**
	 * 查看输入框指定会员的消费记录
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/showAllUsersIdConsumptionRecord/{nowPage}")
	public String showAllUsersIdConsumptionRecord(@PathVariable("nowPage") int nowPage,String userRealName,Model model) {
		String path = "error";	
		if(userRealName != null) {
			userRealNames = userRealName;
		}
		int usersId = usersServer.showInputUsersId(userRealNames);
		//显示条数
		int size = 10;		
		//数据总条数
		int allPage = userConsumptionRecordServer.allUserIdConsumptionRecordPage(usersId);
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
		map.put("usersId", usersId);
		List<UserConsumptionRecord> userConsumptionRecords = userConsumptionRecordServer.showAllUsersIdConsumptionRecord(map);
		if(userConsumptionRecords != null) {
			model.addAttribute("userRealNames", userRealNames);
			model.addAttribute("userConsumptionRecords", userConsumptionRecords);
			model.addAttribute("nowPage", nowPage);
			model.addAttribute("allPageNum", allPageNum);
			model.addAttribute("beginPage", beginPage);
			model.addAttribute("endPage", endPage);
			path = "userConsumptionRecord/userConsumptionRecordInp";
		}
		return path;
	}
	
	/**
	 * 查看指定会员的消费记录
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/showUsersIdConsumptionRecord/{nowPage}&{usersId}")
	public String showUsersIdConsumptionRecord(@PathVariable("nowPage") int nowPage,@PathVariable("usersId") int usersId,Model model) {
		String path = "error";	
		//显示条数
		int size = 10;		
		//数据总条数
		int allPage = userConsumptionRecordServer.allUserIdConsumptionRecordPage(usersId);
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
		map.put("usersId", usersId);
		List<UserConsumptionRecord> userConsumptionRecords = userConsumptionRecordServer.showAllUsersIdConsumptionRecord(map);
		if(userConsumptionRecords != null) {
			model.addAttribute("usersId", usersId);
			model.addAttribute("userConsumptionRecords", userConsumptionRecords);
			model.addAttribute("nowPage", nowPage);
			model.addAttribute("allPageNum", allPageNum);
			model.addAttribute("beginPage", beginPage);
			model.addAttribute("endPage", endPage);
			path = "userConsumptionRecord/userConsumptionRecordId";
		}
		return path;
	}
}

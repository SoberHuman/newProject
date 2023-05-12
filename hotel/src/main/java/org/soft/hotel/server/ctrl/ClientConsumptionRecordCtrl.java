package org.soft.hotel.server.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.soft.hotel.model.ClientConsumptionRecord;
import org.soft.hotel.server.ClientConsumptionRecordServer;
import org.soft.hotel.server.ClientServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 普通客户消费记录模块
 * @author Administrator
 *
 */
@Controller
public class ClientConsumptionRecordCtrl {

	@Autowired
	@Qualifier("ClientConsumptionRecordServer")
	private ClientConsumptionRecordServer clientConsumptionRecordServer;
	@Autowired
	@Qualifier("ClientServer")
	private ClientServer clientServer;
	//存储输入框输入的信息
	private String clientNames;
	/**
	 * 删除客户消费记录
	 * @param clientConsumptionRecordId
	 * @return
	 */
	@RequestMapping("deleteClientrConsumptionRecord")
	public String deleteClientrConsumptionRecord(int clientConsumptionRecordId) {
		String path = "error";
		boolean b = clientConsumptionRecordServer.deleteClientrConsumptionRecord(clientConsumptionRecordId);
		if(b) {
			path = "redirect:/showAllClientConsumptionRecord/1";
		}
		return path;
	}
	
	/**
	 * 查看所有普通客户的消费记录
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/showAllClientConsumptionRecord/{nowPage}")
	public String showAllClientConsumptionRecord(@PathVariable("nowPage") int nowPage,Model model) {
		String path = "error";	
		//显示条数
		int size = 10;		
		//数据总条数
		int allPage = clientConsumptionRecordServer.allClientsConsumptionRecordPage();
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
		List<ClientConsumptionRecord> clientConsumptionRecords = clientConsumptionRecordServer.showAllClientConsumptionRecord(map);
		if(clientConsumptionRecords != null) {
			model.addAttribute("clientConsumptionRecords", clientConsumptionRecords);
			model.addAttribute("nowPage", nowPage);
			model.addAttribute("allPageNum", allPageNum);
			model.addAttribute("beginPage", beginPage);
			model.addAttribute("endPage", endPage);
			path = "clientConsumptionRecord/clientConsumptionRecordAll";
		}
		return path;
	}
	
	/**
	 * 查看输入框指定普通客户的消费记录
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/showInputlientConsumptionRecord/{nowPage}")
	public String showInputlientConsumptionRecord(@PathVariable("nowPage") int nowPage,String clientName,Model model) {
		String path = "error";	
		if(clientName != null) {
			clientNames = clientName;
		}
		int clientId = clientServer.showInputClientId(clientNames);
		//显示条数
		int size = 10;		
		//数据总条数
		int allPage = clientConsumptionRecordServer.allClientIdConsumptionRecordPage(clientId);
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
		map.put("clientId", clientId);
		List<ClientConsumptionRecord> clientConsumptionRecords = clientConsumptionRecordServer.showAllClientIdConsumptionRecord(map);
		if(clientConsumptionRecords != null) {
			model.addAttribute("clientConsumptionRecords", clientConsumptionRecords);
			model.addAttribute("nowPage", nowPage);
			model.addAttribute("allPageNum", allPageNum);
			model.addAttribute("beginPage", beginPage);
			model.addAttribute("endPage", endPage);
			path = "clientConsumptionRecord/clientConsumptionRecordInp";
		}
		return path;
	}
	
	/**
	 * 查看指定普通客户的消费记录
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/showClientConsumptionRecord/{nowPage}&{clientId}")
	public String showClientConsumptionRecord(@PathVariable("nowPage") int nowPage,@PathVariable("clientId") int clientId,Model model) {
		String path = "error";	
		//显示条数
		int size = 10;		
		//数据总条数
		int allPage = clientConsumptionRecordServer.allClientIdConsumptionRecordPage(clientId);
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
		map.put("clientId", clientId);
		List<ClientConsumptionRecord> clientConsumptionRecords = clientConsumptionRecordServer.showAllClientIdConsumptionRecord(map);		
		if(clientConsumptionRecords != null) {
			model.addAttribute("clientId", clientId);
			model.addAttribute("clientConsumptionRecords", clientConsumptionRecords);
			model.addAttribute("nowPage", nowPage);
			model.addAttribute("allPageNum", allPageNum);
			model.addAttribute("beginPage", beginPage);
			model.addAttribute("endPage", endPage);
			path = "clientConsumptionRecord/clientConsumptionRecordId";
		}
		return path;
	}
}

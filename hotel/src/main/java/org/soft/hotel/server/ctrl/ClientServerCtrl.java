package org.soft.hotel.server.ctrl;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.soft.hotel.model.Client;
import org.soft.hotel.model.Users;
import org.soft.hotel.server.ClientServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 普通客户模块
 * @author Administrator
 *
 */
@Controller
public class ClientServerCtrl {

	@Autowired
	@Qualifier("ClientServer")
	private ClientServer clientServer;
	
	//存储搜索客户输入框输入的信息
	private String clientNames;


	/**
	 * 普通用户注册
	 */
	@RequestMapping("clientRegist")
	public String clientRegist(Client client){

		String path = "error";
		Map<String , Object> map = new HashMap<>();
		map.put("clientName",client.getClientName());
		map.put("clientPass",client.getClientPass());
		map.put("clientIdCard",client.getClientIdCard());
		map.put("clientPhone",client.getClientPhone());
		boolean b = clientServer.NewClient(map);
		if(b){
			path="/toPage/gateway/userLogin";
		}
		return path;
	}


	/**
	 * 普通用户登录
	 */
	@RequestMapping("/clientLogin")
	public String clientLogin(Client client2 , HttpServletRequest request,Model model){
		String path = "error";
		Client client = clientServer.clientlogin(client2);
		if(client!=null){
			request.getSession().setAttribute("clients", client);
			request.getSession().setAttribute("customer",client);
			request.getSession().setAttribute("loginKey" ,1);
			path = "redirect:/gatewayShowAllRoomType/0";
		}
		return path;
	}



	/**
	 * 修改客户信息
	 * @param client
	 * @return
	 */
	@RequestMapping("/updateClient")
	public String updateClient(Client client) {
		String path = "error";
		boolean b = clientServer.updateClient(client);
		if(b) {
			path = "redirect:/showAllClient/1";
		}
		return path;
	}
	
	/**
	 * 删除客户信息
	 * @param client
	 * @return
	 */
	@RequestMapping("/deleteClient")
	public String deleteClient(int clientId) {
		String path = "error";
		boolean b = clientServer.deleteClient(clientId);
		if(b) {
			path = "redirect:/showAllClient/1";
		}
		return path;
	}
	
	/**
	 * 查看所有客户信息
	 * @return
	 */
	@RequestMapping(value = "showAllClient/{nowPage}")
	public String showAllClient(@PathVariable("nowPage") int nowPage,Model model){
		String path = "error";	
		//显示条数
		int size = 2;		
		//数据总条数
		int allPage = clientServer.allClientPage();
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
		
		List<Client> clients =  clientServer.showAllClient(map);
		if(clients != null) {
			model.addAttribute("clients", clients);
			model.addAttribute("nowPage", nowPage);
			model.addAttribute("allPageNum", allPageNum);
			model.addAttribute("beginPage", beginPage);
			model.addAttribute("endPage", endPage);
			path = "client/clientOperation";
		}
		return path;
	}
	/**
	 * 查看所有客户信息
	 * @return
	 */
	@RequestMapping(value = "showInputAllClient/{nowPage}")
	public String showInputAllClient(@PathVariable("nowPage") int nowPage,String clientName,Model model){
		String path = "error";	
		//显示条数
		int size = 2;		
		if(clientName != null) {
			clientNames = clientName;
		}
		//数据总条数
		int allPage = clientServer.allInputClientPage(clientNames);
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
		map.put("clientNames", clientNames);
		List<Client> clients =  clientServer.showInputAllClient(map);
		if(clients != null) {
			model.addAttribute("clientNames", clientNames);
			model.addAttribute("clients", clients);
			model.addAttribute("nowPage", nowPage);
			model.addAttribute("allPageNum", allPageNum);
			model.addAttribute("beginPage", beginPage);
			model.addAttribute("endPage", endPage);
			path = "client/clientInp";
		}
		return path;
	}








	/**
	 * 用户修改密码
	 */
	@RequestMapping("/ClientPersonalModify")
	public String updateUsersPass(Client client, HttpServletRequest request, Model model){
		String path = "error";
		String newCPass = client.getClientPass();
		String cPass = request.getParameter("oldClientPass");
		String tcPass = request.getParameter("twoClientPass");


		Client clients = (Client) request.getSession().getAttribute("clients");
		String clientPass = clients.getClientPass();
		int clientId = clients.getClientId();

		client.setClientId(clientId);


		if(clientPass.equals(cPass)){
			if(tcPass.equals(newCPass)){
				boolean b= clientServer.clientPersonalModify(client);
				if(b){
					path = "redirect:/toPage/gateway/userLogin";
				}
			}else {
				model.addAttribute("fail","两次密码不一致");
			}
		}else{
			model.addAttribute("fail","原密码不正确");
		}


		return path;
	}
}

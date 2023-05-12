package org.soft.hotel.server.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.soft.hotel.model.Income;
import org.soft.hotel.server.IncomeServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 收入模块
 * @author Administrator
 *
 */
@Controller
public class IncomeServerCtrl {

	@Autowired
	@Qualifier("IncomeServer")
	private IncomeServer incomeServer;
	
	//保存输入的查询条件
	//指定起止日期
	private String startDatess;
	private String stopDatess;
	//指定月份
	private String monthss;
	//指定年份
	private String yearss;
	
	/**
	 * 查询总收入记录
	 * @param nowPage
	 * @param size
	 * @return
	 */
	@RequestMapping(value = "/showIncomeList/{nowPage}")
	public String showIncomeList(@PathVariable("nowPage") int nowPage,Model model) {
		String path = "error";	
		//显示条数
		int size = 10;		
		//数据总条数
		int allPage = incomeServer.showIncomeAllPage();
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
		List<Income> incomes = incomeServer.showIncomeList(map);
		if(incomes != null) {
			model.addAttribute("incomes", incomes);
			model.addAttribute("nowPage", nowPage);
			model.addAttribute("allPageNum", allPageNum);
			model.addAttribute("beginPage", beginPage);
			model.addAttribute("endPage", endPage);
			path = "income/incomeOp";
		}
		return path;
	}
	
	/**
	 * 查询日收入记录
	 * @param nowPage
	 * @param size
	 * @return
	 */
	@RequestMapping(value = "/showIncomeListDate/{nowPage}")
	public String showIncomeListDate(@PathVariable("nowPage") int nowPage,Model model) {
		String path = "error";	
		//显示条数
		int size = 10;		
		//数据总条数
		int allPage = incomeServer.showIncomeDateAllPage();
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
		List<Income> incomes = incomeServer.showIncomeListDate(map);
		if(incomes != null) {
			model.addAttribute("incomes", incomes);
			model.addAttribute("nowPage", nowPage);
			model.addAttribute("allPageNum", allPageNum);
			model.addAttribute("beginPage", beginPage);
			model.addAttribute("endPage", endPage);
			path = "income/incomeDate";
		}
		return path;
	}
	
	/**
	 * 查询指定起止日期的收入记录
	 * @param nowPage
	 * @param size
	 * @return
	 */
	@RequestMapping(value = "/showIncomeListStartAndStopDates/{nowPage}")
	public String showIncomeListStartAndStopDates(@PathVariable("nowPage") int nowPage,String startDates,String stopDates,Model model) {
		String path = "error";	
		if(startDates != null) {
			startDatess = startDates;
		}
		if(stopDates != null) {
			stopDatess = stopDates;
		}
		//显示条数
		int size = 10;		
		//数据总条数
		int allPage = incomeServer.showIncomeListStartAndStopDatesAllPage(startDatess, stopDatess);
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
		map.put("startDates", startDatess);
		map.put("stopDates", stopDatess);
		List<Income> incomes = incomeServer.showIncomeListStartAndStopDates(map);
		if(incomes != null) {
			model.addAttribute("startDates", startDatess);
			model.addAttribute("stopDates", stopDatess);
			model.addAttribute("incomes", incomes);
			model.addAttribute("nowPage", nowPage);
			model.addAttribute("allPageNum", allPageNum);
			model.addAttribute("beginPage", beginPage);
			model.addAttribute("endPage", endPage);
			path = "income/incomeStartAndStopDates";
		}
		return path;
	}
	
	/**
	 * 查询指定月份的收入记录
	 * @param nowPage
	 * @param size
	 * @return
	 */
	@RequestMapping(value = "/showIncomeListMonth/{nowPage}")
	public String showIncomeListMonth(@PathVariable("nowPage") int nowPage,String months,Model model) {
		String path = "error";	
		if(months != null) {
			monthss = months;
		}
		//显示条数
		int size = 10;		
		//数据总条数
		int allPage = incomeServer.showIncomeListMonthAllPage(monthss);
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
		map.put("months", monthss);
		List<Income> incomes = incomeServer.showIncomeListMonth(map);
		if(incomes != null) {
			model.addAttribute("months", monthss);
			model.addAttribute("incomes", incomes);
			model.addAttribute("nowPage", nowPage);
			model.addAttribute("allPageNum", allPageNum);
			model.addAttribute("beginPage", beginPage);
			model.addAttribute("endPage", endPage);
			path = "income/incomeMonth";
		}
		return path;
	}
	
	/**
	 * 查询指定年份的收入记录
	 * @param nowPage
	 * @param size
	 * @return
	 */
	@RequestMapping(value = "/showIncomeListYear/{nowPage}")
	public String showIncomeListYear(@PathVariable("nowPage") int nowPage,String years,Model model) {
		String path = "error";
		if(years != null) {
			yearss = years;
		}
		//显示条数
		int size = 10;		
		//数据总条数
		int allPage = incomeServer.showIncomeListYearAllPage(yearss);
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
		map.put("years", yearss);
		List<Income> incomes = incomeServer.showIncomeListYear(map);
		if(incomes != null) {
			model.addAttribute("years", yearss);
			model.addAttribute("incomes", incomes);
			model.addAttribute("nowPage", nowPage);
			model.addAttribute("allPageNum", allPageNum);
			model.addAttribute("beginPage", beginPage);
			model.addAttribute("endPage", endPage);
			path = "income/incomeYear";
		}
		return path;
	}
}

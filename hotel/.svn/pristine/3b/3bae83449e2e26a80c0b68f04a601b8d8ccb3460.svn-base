package org.soft.hotel.server;

import java.util.List;
import java.util.Map;
import org.soft.hotel.dao.IncomeDAO;
import org.soft.hotel.model.Income;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 收入模块
 * @author Administrator
 *
 */
@Controller("IncomeServer")
public class IncomeServer {

	@Autowired
	private IncomeDAO incomeDAO;
	
	/**
	 * 新增收入记录
	 * @param income
	 * @return
	 */
	public boolean addIncome(Map<String, Object> map) {
		boolean b = incomeDAO.addIncome(map);
		return b;
	}
	
	/**
	 * 查询总收入记录
	 * @param nowPage
	 * @param size
	 * @return
	 */
	public List<Income> showIncomeList(Map<String, Object> map){
		List<Income> incomes = incomeDAO.showIncomeList(map);
		return incomes;
	}
			
	/**
	 * 查询总收入记录页数
	 * @return
	 */
	public int showIncomeAllPage() {
		int showIncomeAllPage = incomeDAO.showIncomeAllPage();
		return showIncomeAllPage;
	}
	
	/**
	 * 查询当日收入记录
	 * @param nowPage
	 * @param size
	 * @return
	 */
	public List<Income> showIncomeListDate(Map<String, Object> map){
		List<Income> incomes = incomeDAO.showIncomeListDate(map);
		return incomes;
	}
	
	/**
	 * 查询当日收入记录页数
	 * @return
	 */
	public int showIncomeDateAllPage() {
		int showIncomeDateAllPage = incomeDAO.showIncomeDateAllPage();
		return showIncomeDateAllPage;
	}
	
	/**
	 * 查询指定起止日期的收入记录页数
	 * @param nowPage
	 * @param size
	 * @return
	 */
	public List<Income> showIncomeListStartAndStopDates(Map<String, Object> map){
		List<Income> incomes = incomeDAO.showIncomeListStartAndStopDates(map);
		return incomes;
	}
	
	/**
	 *查询指定起止日期的收入记录页数
	 * @return
	 */
	public int showIncomeListStartAndStopDatesAllPage(String startDates,String stopDates) {
		int showIncomeDateAllPage = incomeDAO.showIncomeListStartAndStopDatesAllPage(startDates,stopDates);
		return showIncomeDateAllPage;
	}
	
	/**
	 * 查询指定月份的收入记录
	 * @param nowPage
	 * @param size
	 * @return
	 */
	public List<Income> showIncomeListMonth(Map<String, Object> map){
		List<Income> incomes = incomeDAO.showIncomeListMonth(map);
		return incomes;
	}
	
	/**
	 * 查询指定月份的收入记录页数
	 * @return
	 */
	public int showIncomeListMonthAllPage(String months) {
		int showIncomeListMonthAllPage = incomeDAO.showIncomeListMonthAllPage(months);
		return showIncomeListMonthAllPage;
	}
	
	/**
	 * 查询指定年份的收入记录
	 * @param nowPage
	 * @param size
	 * @return
	 */
	public List<Income> showIncomeListYear(Map<String, Object> map){
		List<Income> incomes = incomeDAO.showIncomeListYear(map);
		return incomes;
	}
	
	/**
	 * 查询指定年份的收入记录页数
	 * @return
	 */
	public int showIncomeListYearAllPage(String years) {
		int showIncomeListYearAllPage = incomeDAO.showIncomeListYearAllPage(years);
		return showIncomeListYearAllPage;
	}
	
	/**
	 *查询指定房间类型的总收入
	 * @return
	 */
	public String countRoomTypeAllIncome(int roomTypeId) {
		String countRoomTypeAllIncome = incomeDAO.countRoomTypeAllIncome(roomTypeId);
		return countRoomTypeAllIncome;
	}
	
	/**
	 *查询指定房间类型的日收入
	 * @return
	 */
	public String countRoomTypeIncomeData(int roomTypeId) {
		String countRoomTypeIncomeData = incomeDAO.countRoomTypeIncomeData(roomTypeId);
		return countRoomTypeIncomeData;
	}
	
	/**
	 *查询指定房间类型的周收入
	 * @return
	 */
	public String countRoomTypeIncomeWeek(int roomTypeId) {
		String countRoomTypeIncomeWeek = incomeDAO.countRoomTypeIncomeWeek(roomTypeId);
		return countRoomTypeIncomeWeek;
	}
	
	/**
	 *统计指定房间类型的月收入
	 * @return
	 */
	public String countRoomTypeIncomeNowMonths(int roomTypeId) {
		String countRoomTypeIncomeNowMonths = incomeDAO.countRoomTypeIncomeNowMonths(roomTypeId);
		return countRoomTypeIncomeNowMonths;
	}
	
	/**
	 *统计指定房间类型的年收入
	 * @return
	 */
	public String countRoomTypeIncomeNowYear(int roomTypeId) {
		String countRoomTypeIncomeNowYear = incomeDAO.countRoomTypeIncomeNowYear(roomTypeId);
		return countRoomTypeIncomeNowYear;
	}
	
	/**
	 *查询指定起止日期的收入
	 * @return
	 */
	public String countRoomTypeIncomeStartAndStopDates(Map<String, Object> map) {
		String countRoomTypeIncomeStartAndStopDates = incomeDAO.countRoomTypeIncomeStartAndStopDates(map);
		return countRoomTypeIncomeStartAndStopDates;
	}
	
	/**
	 *查询指定月份的收入
	 * @return
	 */
	public String countRoomTypeIncomeMonth(Map<String, Object> map) {
		String countRoomTypeIncomeMonth = incomeDAO.countRoomTypeIncomeMonth(map);
		return countRoomTypeIncomeMonth;
	}
	
	/**
	 *查询指定年份的收入
	 * @return
	 */
	public String countRoomTypeIncomeYear(Map<String, Object> map) {
		String countRoomTypeIncomeYear = incomeDAO.countRoomTypeIncomeYear(map);
		return countRoomTypeIncomeYear;
	}
}

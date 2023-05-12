package org.soft.hotel.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.soft.hotel.model.Staff;

/**
 * 员工模块
 * @author Administrator
 *
 */
@Mapper
public interface StaffDAO {

	/**
	 * 员工登录
	 * @param staff
	 * @return
	 */
	@Select("select * from staff where staffAccount = #{staffAccount} and staffPassword = #{staffPassword}")
	public Staff staffLogin(Staff staff);
}

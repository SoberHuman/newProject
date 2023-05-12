package org.soft.hotel.server;

import java.util.List;

import org.soft.hotel.dao.AnnouncementDAO;
import org.soft.hotel.model.Announcement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


/**
 * 公告管理模块
 * @author Administrator
 *
 */
@Controller("AnnouncementServer")
public class AnnouncementServer {

	@Autowired
	private AnnouncementDAO announcementDAO;
	
	/**
	 * 新增公告
	 * @param announcement
	 * @return
	 */
	public boolean newAnnouncement(Announcement announcement) {
		boolean b = announcementDAO.newAnnouncement(announcement);
		return b;
	}
	
	/**
	 * 查看公告详情
	 * @param announcementId
	 * @return
	 */
	public Announcement showAnnouncement(int announcementId) {
		Announcement announcement = announcementDAO.showAnnouncement(announcementId);
		return announcement;
	}
	
	/**
	 * 删除公告
	 * @param announcementId
	 * @return
	 */
	public boolean deleteAnnouncement(int announcementId) {
		boolean b = announcementDAO.deleteAnnouncement(announcementId);
		return b;
	}
	/**
	 * 修改公告
	 * @param announcement
	 * @return
	 */
	public boolean updateAnnouncement(Announcement announcement) {
		boolean b = announcementDAO.updateAnnouncement(announcement);
		return b;
	}
	
	/**
	 * 发布或停用公告
	 * @param announcement
	 * @return
	 */
	public boolean updateAnnouncementState(int announcementState,int announcementId) {
		boolean b = announcementDAO.updateAnnouncementState(announcementState,announcementId);
		return b;
	}
	/**
	 * 公告列表
	 * @return
	 */
	public List<Announcement> showAllAnnouncement(){
		List<Announcement> announcements = announcementDAO.showAllAnnouncement();
		return announcements;
	}
	
	/**
	 * 网站主页查询网站公告列表
	 * @return
	 */
	public List<Announcement> gatewayShowAllAnnouncement(){
		List<Announcement> announcements = announcementDAO.gatewayShowAllAnnouncement();
		return announcements;
	}
	
}

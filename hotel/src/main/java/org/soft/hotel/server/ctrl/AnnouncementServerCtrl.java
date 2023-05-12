package org.soft.hotel.server.ctrl;

import java.util.List;

import org.soft.hotel.model.Announcement;
import org.soft.hotel.server.AnnouncementServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



/**
 * 公告管理模块
 * @author Administrator
 *
 */
@Controller
public class AnnouncementServerCtrl {

	@Autowired
	@Qualifier("AnnouncementServer")
	private AnnouncementServer announcementServer;
	/**
	 * 新增公告
	 * @param announcement
	 * @return
	 */
	@RequestMapping("newAnnouncement")
	public String newAnnouncement(Announcement announcement) {
		String path = null;
		boolean b = announcementServer.newAnnouncement(announcement);
		if(b) {
			path = "redirect:/showAllAnnouncement";
		}else {
			path = "error";
		}
		return path;
	}
	/**
	 * 删除公告
	 * @param announcementId
	 * @return
	 */
	@RequestMapping("deleteAnnouncement")
	public String deleteAnnouncement(int announcementId) {
		String path = null;
		boolean b = announcementServer.deleteAnnouncement(announcementId);
		if(b) {
			path = "redirect:/showAllAnnouncement";
		}else {
			path = "error";
		}
		return path;
	}
	/**
	 * 修改公告
	 * @param announcement
	 * @return
	 */
	@RequestMapping("updateAnnouncement")
	public String updateAnnouncement(Announcement announcement) {
		String path = null;
		boolean b = announcementServer.updateAnnouncement(announcement);
		if(b) {
			path = "redirect:/showAllAnnouncement";
		}else {
			path = "error";
		}
		return path;
	}
	
	/**
	 * 发布或停用公告
	 * @param announcement
	 * @return
	 */
	@RequestMapping("updateAnnouncementState/{announcementId}&{num}")
	public String updateAnnouncementState(@PathVariable("announcementId") int announcementId,@PathVariable("num") int num) {
		String path = null;
		int announcementState = 0;
		if(num == 0) {
			announcementState = 0;
		}else {
			announcementState = 1;
		}
		boolean b = announcementServer.updateAnnouncementState(announcementState,announcementId);
		if(b) {
			path = "redirect:/showAllAnnouncement";
		}else {
			path = "error";
		}
		return path;
	}
	/**
	 * 公告列表
	 * @return
	 */
	@RequestMapping("showAllAnnouncement")
	public String showAllAnnouncement(Model model){
		String path = null;
		List<Announcement> announcements = announcementServer.showAllAnnouncement();
		if(announcements != null) {
			model.addAttribute("announcements", announcements);
			path = "announcement/announcements";
		}else {
			path = "error";
		}
		return path;
	}
}

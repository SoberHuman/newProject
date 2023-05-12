package org.soft.hotel.view.ctrl;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class toPageCtrl {

	@RequestMapping(value = "toPage/{folderName}/{pageAdd}")
	public String toPage(@PathVariable("folderName") String folderName,@PathVariable("pageAdd") String pageAdd) {
		return folderName+"/"+pageAdd; 
	}
	
	@RequestMapping(value = "/")
	public String toIndex() { 
		return "/staff/staffLogin";
	}
}

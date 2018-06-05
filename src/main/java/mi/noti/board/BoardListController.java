package mi.noti.board;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mi.noti.board.model.User;

@Controller
public class BoardListController {
	
	@RequestMapping(value = "/blist", method = RequestMethod.GET)
	public String blist(Model model) {
		return "home";
	}
	
	@RequestMapping(value = "/blist", method = RequestMethod.POST)
	public String blist(@ModelAttribute("user")User user, 
		      BindingResult result, ModelMap model) {
		
		if(result.hasErrors()) {
			System.out.println(result.getObjectName());
		}
				
		model.addAttribute("user_name", user.getUser_name());
		return "blist";
	}

}

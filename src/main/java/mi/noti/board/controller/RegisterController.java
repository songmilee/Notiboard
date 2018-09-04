package mi.noti.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {

	public ModelAndView showRegister(ModelAndView mv) {
		mv.setViewName("register");
		return mv;
	}
}

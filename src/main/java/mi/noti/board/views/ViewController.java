package mi.noti.board.views;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public ModelAndView view(@RequestParam("no") int no) {
		ModelAndView mv = new ModelAndView("view");
		return mv;
	}

}

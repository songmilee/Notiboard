package mi.noti.board.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mi.noti.board.dao.NotiDAO;
import mi.noti.board.model.NotiTxt;
import mi.noti.board.service.BoardService;

@Controller
public class ViewController {
	@Resource(name="boardService")
	private BoardService bs;
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public ModelAndView view(@RequestParam("no") int no) throws Exception {
		ModelAndView mv = new ModelAndView("view");
		NotiTxt result = bs.selectNotiTxt(no); 
		
		mv.addObject("result", result);
		return mv;
	}

}

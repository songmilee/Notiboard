package mi.noti.board.controller;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mi.noti.board.model.NotiTxt;
import mi.noti.board.model.User;
import mi.noti.board.service.BoardService;

@Controller
public class BoardListController {
	
	@Resource(name="boardService")
	private BoardService bs;
	
	@RequestMapping(value = "/blist", method = RequestMethod.GET)
	public ModelAndView blist() throws Exception {
		ModelAndView mv = new ModelAndView("blist");
		
		List<Map<String, Object>> list = bs.selectBoardList() ;
		
		mv.addObject("list", list);

		return mv;
	}

}

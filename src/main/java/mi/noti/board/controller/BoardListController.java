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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mi.noti.board.model.NotiTxt;
import mi.noti.board.model.Page;
import mi.noti.board.model.User;
import mi.noti.board.service.BoardService;

@Controller
public class BoardListController {
	
	@Resource(name="boardService")
	private BoardService bs;
	
	@RequestMapping(value = "/blist", method = RequestMethod.GET)
	public ModelAndView blist(@RequestParam(defaultValue="1") int curpage) throws Exception {
		ModelAndView mv = new ModelAndView("blist");
		Page page = new Page(curpage);
		
		List<Map<String, Object>> list = bs.selectBoardList() ;
		mv.addObject("list", list);
		
		Page.totalText = list.size();
		
		if(Page.totalText > 0) {
			mv.addObject("total", list.size());
		}else {
			mv.addObject("total", 0);
		}
		
		mv.addObject("page", page);

		return mv;
	}

}

package mi.noti.board.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import mi.noti.board.model.Comment;
import mi.noti.board.model.NotiTxt;
import mi.noti.board.model.Page;
import mi.noti.board.service.BoardService;

@Controller
public class ViewController {
	@Resource(name="boardService")
	private BoardService bs;
	
	private ModelAndView mv;
	private List<Map<String, Object>> comment;
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public ModelAndView view(@RequestParam("no") Integer no) throws Exception {
		mv = new ModelAndView("view");
		NotiTxt result = bs.initViewText(no);
		
		comment = bs.getCommentList(no);
		
		mv.addObject("result", result);
		mv.addObject("comment", comment);
		mv.addObject("total", Page.totalText);
		return mv;
	}

	@RequestMapping(value="/view", method = RequestMethod.POST)
	public ModelAndView writeComment(@RequestParam("no") String no, 
			@RequestParam("detail") String detail) throws Exception {		
		Comment c = new Comment();
		c.setNo(Integer.parseInt(no));
		c.setDetail(detail);
		
		comment = bs.addCommentList(c);
		
		mv.addObject("comment", comment);
		
		return mv;
	}
	

}

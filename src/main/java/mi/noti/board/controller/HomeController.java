package mi.noti.board.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import mi.noti.board.common.Variable;
import mi.noti.board.model.Member;
import mi.noti.board.model.User;
import mi.noti.board.service.impl.MemberServiceImp;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	MemberServiceImp ms;
		
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {	
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
				
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	} 
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	@ResponseBody
	public String login(@RequestParam("id")String id, @RequestParam("pwd")String pwd, HttpServletResponse rep) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		
		Member m = new Member();
		m.setId(id);
		m.setPwd(pwd);
		
		int unique = ms.isMember(m);
		
		if(unique == -1) {
			result.put("result", Variable.LOGIN_FAIL);
		} else {
			Cookie c = new Cookie("uid", String.valueOf(unique));
			c.setMaxAge(60 * 60 * 60);
			rep.addCookie(c);
			result.put("result", Variable.LOGIN_OK);
		}
		
		return new ObjectMapper().writeValueAsString(result);
	}
	
}

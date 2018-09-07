package mi.noti.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import mi.noti.board.common.Variable;
import mi.noti.board.model.Member;
import mi.noti.board.service.impl.MemberServiceImp;

@Controller
public class RegisterController {
	@Autowired
	MemberServiceImp ms;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView showRegister(ModelAndView mv) {
		mv.setViewName("register");
		return mv;
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	@ResponseBody
	public String registerMember(@RequestParam("id")String id, @RequestParam("pwd")String pwd, @RequestParam("name") String name) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		
		Member m = new Member();
		m.setId(id);
		m.setPwd(pwd);
		m.setName(name);
		
		//member 있는지 검사
		int unique = ms.isMember(m);
		if(unique == -1) {
			ms.addMember(m);
			result.put("result", Variable.REGISTER_OK);
		} else {
			result.put("result", Variable.REGISTER_FAIL);
		}		
		
		return new ObjectMapper().writeValueAsString(result);
	}
}

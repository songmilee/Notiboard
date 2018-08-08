package mi.noti.board.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import mi.noti.board.dao.NotiDAO;
import mi.noti.board.model.NotiTxt;
import mi.noti.board.model.User;


@Controller
public class WriteController {
	@Resource(name="notiDAO")
	private NotiDAO notiDAO;
	
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write() {		
		return "write";
	}

	/**
	 * write 페이지로 부터 작성한 값 변경
	 * responseBody가 없으면 jsp 리턴하는 스트링을 기준으로 jsp 파일을 찾으려 함
	 * */
	@RequestMapping(value= "/write", method = RequestMethod.POST)
	@ResponseBody
	public String writeText(@RequestParam("name") String name, 
			@RequestParam("title") String title, @RequestParam("detail") String detail) throws Exception {
		
		//set value to notiTxt
		Map<String, Object> message = new HashMap<String, Object>();
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = "";
		
		NotiTxt notiTxt = new NotiTxt();
		notiTxt.setname(name);
		notiTxt.setTitle(title);
		notiTxt.setDetail(detail);
		
		boolean result = notiDAO.insertWrite(notiTxt);
		
		if(result) {
			message.put("result", 1);
		} else {
			message.put("result", 0);
		}
		
		jsonString = mapper.writeValueAsString(message);
		
		return jsonString;
	}

}

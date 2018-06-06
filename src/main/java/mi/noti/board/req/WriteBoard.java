package mi.noti.board.req;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import mi.noti.board.dao.WriteDAO;
import mi.noti.board.model.NotiTxt;
/*
 * 웹 페이지로부터 글 정보를 받아
 * 데이터베이스에 작성
 * */
@Controller
public class WriteBoard {
	@Inject
	private WriteDAO dao;

	@RequestMapping(value= "/request/write", method = RequestMethod.POST)
	@ResponseBody
	public String WriteReq(@RequestParam("name") String name, 
			@RequestParam("title") String title, @RequestParam("detail") String detail) {
		
		Map<String, String> message = new HashMap<String, String>();
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = "";
		
		NotiTxt notiTxt = new NotiTxt();
		notiTxt.setUserName(name);
		notiTxt.setTitle(title);
		notiTxt.setDetail(detail);
		
		boolean result = dao.insertWrite(notiTxt);
		
		if(result) {
			message.put("result", "true");
		} else {
			message.put("result", "false");
		}
		
		try {
			jsonString = mapper.writeValueAsString(message);
		}catch(Exception e) {
			e.printStackTrace();			
		}
		
		return jsonString;
	}
}

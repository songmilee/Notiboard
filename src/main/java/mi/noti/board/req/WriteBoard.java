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

import mi.noti.board.dao.NotiDAO;
import mi.noti.board.model.NotiTxt;
/*
 * �쎒 �럹�씠吏�濡쒕��꽣 湲� �젙蹂대�� 諛쏆븘
 * �뜲�씠�꽣踰좎씠�뒪�뿉 �옉�꽦
 * */
@Controller
public class WriteBoard {
	@Inject
	private NotiDAO dao;

	@RequestMapping(value= "/request/write", method = RequestMethod.POST)
	@ResponseBody
	public String WriteReq(@RequestParam("name") String name, 
			@RequestParam("title") String title, @RequestParam("detail") String detail) {
		
		Map<String, String> message = new HashMap<String, String>();
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = "";
		
		NotiTxt notiTxt = new NotiTxt();
		notiTxt.setname(name);
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

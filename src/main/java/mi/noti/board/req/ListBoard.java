package mi.noti.board.req;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import mi.noti.board.dao.NotiDAO;
import mi.noti.board.model.NotiTxt;

@Controller
public class ListBoard {
	@Inject
	private NotiDAO dao;
	
	@RequestMapping(value= "/request/listboard", method = RequestMethod.POST)
	@ResponseBody
	public String ListReq(@RequestParam("curpage") int curpage) {
		Map<String, String> message = new HashMap<String, String>();
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = "";
		
		try {
			List<NotiTxt> result = dao.selectNotiTxtList();
			
			jsonString = mapper.writeValueAsString(result);
		}catch(Exception e) {
			//error message 생성			
			message.put("result", "error occur");
			
			try {
				jsonString = mapper.writeValueAsString(message);
			} catch (JsonGenerationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (JsonMappingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			return jsonString;
		}
		 
		
		return jsonString;
	}
}

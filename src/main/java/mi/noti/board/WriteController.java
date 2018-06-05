package mi.noti.board;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import mi.noti.board.model.User;


@Controller
public class WriteController {
	private User user;
	
	public WriteController() {
		user = new User();
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String blist(Model model) {
		model.addAttribute("user_name", user.getUser_name());
		return "write";
	}

	@RequestMapping(value= "/write", method = RequestMethod.POST)
	@ResponseBody
	public String blist(@RequestParam("name") String name) {		
		Map<String, String> message = new HashMap<String, String>();
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = "";
		
		if(name.equals(null) || name.equals("")) {
			message.put("result", "false");						
		}else {
			user.setUser_name(name);
			message.put("result", "true");
		}
		
		try {
			jsonString = mapper.writeValueAsString(message);
		}catch(Exception e) {
			e.printStackTrace();			
		}
		
		return jsonString;
	}

}

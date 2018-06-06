package mi.noti.board.views;

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
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write() {		
		return "write";
	}

	@RequestMapping(value= "/write", method = RequestMethod.POST)
	@ResponseBody
	public String write(@RequestParam("name") String name) {						
		return "write";
	}

}

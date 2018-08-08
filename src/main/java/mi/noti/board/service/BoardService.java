package mi.noti.board.service;

import java.util.List;
import java.util.Map;

import mi.noti.board.model.NotiTxt;

public interface BoardService {
	List<Map<String, Object>> selectBoardList() throws Exception;

}

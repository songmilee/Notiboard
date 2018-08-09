package mi.noti.board.service;

import java.util.List;
import java.util.Map;

import mi.noti.board.model.NotiTxt;
import mi.noti.board.model.Page;

public interface BoardService {
	List<Map<String, Object>> selectBoardList() throws Exception;
	NotiTxt selectNotiTxt(int no) throws Exception;
	boolean insertWrite(NotiTxt notiTxt) throws Exception;
	int updateHit(int no) throws Exception;

}

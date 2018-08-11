package mi.noti.board.service;

import java.util.List;
import java.util.Map;

import mi.noti.board.model.Comment;
import mi.noti.board.model.NotiTxt;
import mi.noti.board.model.Page;

public interface BoardService {
	List<Map<String, Object>> selectBoardList() throws Exception;
	NotiTxt initViewText(int no) throws Exception;
	boolean insertWrite(NotiTxt notiTxt) throws Exception;
	
	List<Map<String, Object>> getCommentList(int no) throws Exception;
	List<Map<String, Object>> addCommentList(Comment co) throws Exception;
}

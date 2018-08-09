package mi.noti.board.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import mi.noti.board.model.NotiTxt;
import mi.noti.board.model.Page;

public interface NotiDAO {
	public boolean insertText(NotiTxt no);
	public List<Map<String, Object>> selectNotiTxtList() throws Exception;
	public NotiTxt selectNotiTxt(Integer no) throws Exception;
	public int updateHit(int no);
}

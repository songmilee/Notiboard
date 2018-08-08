package mi.noti.board.dao;

import java.util.List;
import java.util.Map;

import mi.noti.board.model.NotiTxt;

public interface NotiDAO {
	public boolean insertWrite(NotiTxt no);
	public List<Map<String, Object>> selectNotiTxtList() throws Exception;
	public List<NotiTxt> selectNotiTxt(Integer no) throws Exception;
}

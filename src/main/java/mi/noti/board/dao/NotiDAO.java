package mi.noti.board.dao;

import java.util.List;

import mi.noti.board.model.NotiTxt;

public interface NotiDAO {
	public boolean insertWrite(NotiTxt no);
	public List<NotiTxt> selectNotiTxtList() throws Exception;
	public List<NotiTxt> selectNotiTxt(Integer no) throws Exception;
}

package mi.noti.board.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.stereotype.Service;

import mi.noti.board.dao.NotiDAO;
import mi.noti.board.model.NotiTxt;
import mi.noti.board.model.Page;
import mi.noti.board.service.BoardService;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Resource(name="notiDAO")
	private NotiDAO notiDAO;
	
	@Override
	public List<Map<String, Object>> selectBoardList() throws Exception {
		// TODO Auto-generated method stub
		return notiDAO.selectNotiTxtList();
	}

	@Override
	public NotiTxt selectNotiTxt(int no) throws Exception {
		// TODO Auto-generated method stub
		return notiDAO.selectNotiTxt(no);
	}

	@Override
	public boolean insertWrite(NotiTxt notiTxt) throws Exception {
		// TODO Auto-generated method stub
		return notiDAO.insertText(notiTxt);
	}

	@Override
	public int updateHit(int no) throws Exception {
		// TODO Auto-generated method stub
		return notiDAO.updateHit(no);
	}

}

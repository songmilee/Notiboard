package mi.noti.board.dao.imp;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import mi.noti.board.dao.NotiDAO;
import mi.noti.board.model.Comment;
import mi.noti.board.model.NotiTxt;
import mi.noti.board.model.Page;

@Repository("notiDAO") // DAO 
public class NotiDAOImp implements NotiDAO {

	@Inject // sql 주입
	private SqlSession sqlSession;
	
	private static final String namespace = "mi.noti.board.mapper.NotiMapper";
	
	@Override
	public boolean insertText(NotiTxt no) {
		// TODO Auto-generated method stub
		int val = sqlSession.insert(namespace+".insertWrite", no);
		
		if(val > 0)
			return true;
		return false;
	}

	@Override
	public List<Map<String, Object>> selectNotiTxtList() {
		// TODO Auto-generated method stub		

		return sqlSession.selectList(namespace+".selectNotiTxtList");
	}

	@Override
	public NotiTxt selectNotiTxt(Integer no) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".selectNotiTxt", no);
	}

	@Override
	public int updateHit(int no) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace + ".updateHit", no);
	}

	@Override
	public List<Map<String, Object>> selectNotiComment(int no) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace +".selectNotiComment", no);
	}

	@Override
	public int insertComment(Comment c) {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace+".insertComment", c);
	}

}

package mi.noti.board.dao.imp;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import mi.noti.board.dao.NotiDAO;
import mi.noti.board.model.NotiTxt;

@Repository // DAO 명시
public class NotiDAOImp implements NotiDAO {

	@Inject // 의존관계 연결
	private SqlSession sqlSession;
	
	private static final String namespace = "mi.noti.board.mapper.NotiMapper";
	
	@Override
	public boolean insertWrite(NotiTxt no) {
		// TODO Auto-generated method stub
		int val = sqlSession.insert(namespace+".insertWrite", no);
		
		if(val > 0)
			return true;
		return false;
	}

	@Override
	public List<NotiTxt> selectNotiTxtList() {
		// TODO Auto-generated method stub		
		
		return sqlSession.selectList(namespace+".selectNotiTxtList");
	}

}

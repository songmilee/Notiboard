package mi.noti.board.dao.imp;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import mi.noti.board.dao.NotiDAO;
import mi.noti.board.model.NotiTxt;

@Repository // DAO 紐낆떆
public class NotiDAOImp implements NotiDAO {

	@Inject // �쓽議닿�怨� �뿰寃�
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
	public List<Map<String, Object>> selectNotiTxtList() {
		// TODO Auto-generated method stub		
		
		return sqlSession.selectList(namespace+".selectNotiTxtList");
	}

	@Override
	public List<NotiTxt> selectNotiTxt(Integer no) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".selecctNotiTxt", no);
	}

}

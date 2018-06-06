package mi.noti.board.dao.imp;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import mi.noti.board.dao.WriteDAO;
import mi.noti.board.model.NotiTxt;

@Repository // DAO 명시
public class WriteDAOImp implements WriteDAO {

	@Inject // 의존관계 연결
	private SqlSession sqlSession;
	
	private static final String namespace = "mi.noti.board.mapper.WriteMapper";
	
	@Override
	public boolean insertWrite(NotiTxt no) {
		// TODO Auto-generated method stub
		int val = sqlSession.insert(namespace+".insertWrite", no);
		
		if(val > 0)
			return true;
		return false;
	}

}

package mi.noti.board.dao.imp;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mi.noti.board.common.Variable;
import mi.noti.board.dao.MemberDAO;
import mi.noti.board.model.Member;

@Repository
public class MemberDAOImp implements MemberDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insertMember(Member m) {
		// TODO Auto-generated method stub
		sqlSession.insert(Variable.MEMBER + ".addMember", m);
	}

	@Override
	public Member selectMember(Member m) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(Variable.MEMBER + ".selectMember", m);
	}

}

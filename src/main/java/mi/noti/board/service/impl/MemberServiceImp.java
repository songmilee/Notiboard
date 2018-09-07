package mi.noti.board.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mi.noti.board.dao.imp.MemberDAOImp;
import mi.noti.board.model.Member;
import mi.noti.board.service.MemberService;

@Service
public class MemberServiceImp implements MemberService {
	@Autowired
	private MemberDAOImp mem;
	
	@Override
	public void addMember(Member m) {
		// TODO Auto-generated method stub
		mem.insertMember(m);
	}

	@Override
	public int isMember(Member m) {
		// TODO Auto-generated method stub
		Member result = mem.selectMember(m);
		
		return (result == null? -1 : result.getUid());
	}
	
}

package mi.noti.board.dao;

import mi.noti.board.model.Member;

public interface MemberDAO {
	public void insertMember(Member m);
	public Member selectMember(Member m);
}

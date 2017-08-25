package com.anticovi.mango.member.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.anticovi.mango.member.dao.MemberMapper;
import com.anticovi.mango.member.domain.MemberCommand;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
	@Resource
	private MemberMapper memberMapper;
	@Override
	public void insertMember(MemberCommand member) {
		memberMapper.insertMember(member);
	}
	@Override
	public MemberCommand selectMemberForId(String m_id) {
		return memberMapper.selectMemberForId(m_id);
	}

}

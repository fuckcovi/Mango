package com.anticovi.mango.member.service;

import org.springframework.transaction.annotation.Transactional;

import com.anticovi.mango.member.domain.MemberCommand;

@Transactional
public interface MemberService{
	public void insertMember(MemberCommand member);
	@Transactional(readOnly=true)
	public MemberCommand selectMemberForId(String m_id);
}

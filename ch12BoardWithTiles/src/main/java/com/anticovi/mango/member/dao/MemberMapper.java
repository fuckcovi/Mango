package com.anticovi.mango.member.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.anticovi.mango.member.domain.MemberCommand;

public interface MemberMapper {
	@Insert("INSERT INTO member(m_seq,m_id,m_pw,m_name,m_phone1,m_phone2,m_phone3,m_birth,m_address1,m_address2,m_mydevice1,m_mydevice2,m_mydevice3,m_regdate) VALUES(member_seq.nextval,#{m_id},#{m_pw},#{m_name},#{m_phone1},#{m_phone2},#{m_phone3},#{m_birth},#{m_address1},#{m_address2},#{m_mydevice1},#{m_mydevice2},#{m_mydevice3},sysdate)")
	public void insertMember(MemberCommand member);
	@Select("SELECT * FROM member WHERE m_id=#{m_id}")
	public MemberCommand selectMemberForId(String m_id);
}

package kr.spring.member.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.spring.member.domain.MemberCommand;

public interface MemberMapper {
	@Insert("INSERT INTO spmember(id) values (#{id})")
	public void insert(MemberCommand member);
	@Insert("INSERT INTO spmember_detail (id,name,passwd,phone,email,zipcode,address1,address2,reg_date) values (#{id},#{name},#{passwd},#{phone},#{email},#{zipcode},#{address1},#{address2,jdbcType=VARCHAR},sysdate)")
	public void insertDetail(MemberCommand member);
	@Select("SELECT * FROM spmember m left outer join spmember_detail d on m.id=d.id where m.id=#{id}")
	public MemberCommand selectMember(String id);
	@Update("UPDATE spmember_detail SET name=#{name},passwd=#{passwd},phone=#{phone},email=#{email},zipcode=#{zipcode},address1=#{address1},address2=#{address2,jdbcType=VARCHAR} WHERE id=#{id}")
	public void update(MemberCommand member);
	@Update("UPDATE spmember set auth=0 WHERE id=#{id}")
	public void delete(String id);
	@Delete("DELETE FROM spmember_detail WHERE id=#{id}")
	public void deleteDetail(String id);
}








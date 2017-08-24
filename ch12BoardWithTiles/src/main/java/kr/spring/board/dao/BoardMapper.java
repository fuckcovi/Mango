package kr.spring.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.spring.board.domain.BoardCommand;
import kr.spring.board.domain.BoardReplyCommand;

public interface BoardMapper {
	//부모글
	public List<BoardCommand> list(Map<String,Object> map);
	public int getRowCount(Map<String,Object> map);
	@Insert("INSERT INTO spboard(seq,title,content,regdate,uploadfile,filename,ip,id) VALUES (board_seq.nextval,#{title},#{content},sysdate,#{uploadfile,jdbcType=BLOB},#{filename,jdbcType=VARCHAR},#{ip},#{id})")
	public void insert(BoardCommand board);
	@Select("SELECT * FROM spboard WHERE seq=#{seq}")
	public BoardCommand selectBoard(Integer seq);
	@Update("UPDATE spboard SET hit=hit+1 WHERE seq=#{seq}")
	public void updateHit(Integer seq);
	@Update("UPDATE spboard SET title=#{title},content=#{content},uploadfile=#{uploadfile,jdbcType=BLOB},filename=#{filename,jdbcType=VARCHAR},ip=#{ip} WHERE seq=#{seq}")
	public void update(BoardCommand board);
	@Delete("DELETE FROM spboard WHERE seq=#{seq}")
	public void delete(Integer seq);
	//댓글
	public List<BoardReplyCommand> listReply(Map<String,Object> Map);
	@Select("SELECT count(*) FROM spboard_reply WHERE seq=#{seq}")
	public int getRowCountReply(Map<String,Object> map);
	@Insert("INSERT INTO spboard_reply (re_no,re_content,re_date,re_ip,seq,id) VALUES (reply_seq.nextval,#{re_content},sysdate,#{re_ip},#{seq},#{id})")
	public void insertReply(BoardReplyCommand boardReply);
	@Update("UPDATE spboard_reply SET re_content=#{re_content},re_ip=#{re_ip} WHERE re_no=#{re_no}")
	public void updateReply(BoardReplyCommand boardReply);
	@Delete("DELETE FROM spboard_reply WHERE re_no=#{re_no}")
	public void deleteReply(Integer re_no);
	
	//부모글 삭제시 댓글이 존재하면 부모글 삭제전 댓글 삭제
	@Delete("DELETE FROM spboard_reply WHERE seq=#{seq}")
	public void deleteReplyBySeq(Integer seq);
	
}












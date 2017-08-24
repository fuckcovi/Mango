package kr.spring.board.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.board.dao.BoardMapper;
import kr.spring.board.domain.BoardCommand;
import kr.spring.board.domain.BoardReplyCommand;

@Service("boardService")
public class BoardServiceImpl implements BoardService{

	@Resource
	private BoardMapper boardMapper;
	
	@Override
	public List<BoardCommand> list(Map<String, Object> map) {
		return boardMapper.list(map);
	}

	@Override
	public int getRowCount(Map<String, Object> map) {
		return boardMapper.getRowCount(map);
	}

	@Override
	public void insert(BoardCommand board) {
		boardMapper.insert(board);
	}

	@Override
	public BoardCommand selectBoard(Integer seq) {
		return boardMapper.selectBoard(seq);
	}

	@Override
	public void updateHit(Integer seq) {
		boardMapper.updateHit(seq);
	}

	@Override
	public void update(BoardCommand board) {
		boardMapper.update(board);
	}

	@Override
	public void delete(Integer seq) {
		//����� �����ϸ� ����� �켱 �����ϰ� �θ���� ����
		boardMapper.deleteReplyBySeq(seq);
		//�θ�� ����
		boardMapper.delete(seq);
	}

	@Override
	public List<BoardReplyCommand> listReply(Map<String, Object> Map) {
		return boardMapper.listReply(Map);
	}

	@Override
	public int getRowCountReply(Map<String, Object> map) {
		return boardMapper.getRowCountReply(map);
	}

	@Override
	public void insertReply(BoardReplyCommand boardReply) {
		boardMapper.insertReply(boardReply);
	}

	@Override
	public void updateReply(BoardReplyCommand boardReply) {
		boardMapper.updateReply(boardReply);
	}

	@Override
	public void deleteReply(Integer re_no) {
		boardMapper.deleteReply(re_no);
	}

}







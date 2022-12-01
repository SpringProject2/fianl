package dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;


import vo.DiaryVO;
import vo.GuestBookVO;

public class DiaryDAO{
	
	SqlSession sqlSession; // Mapper접근
	// SI
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//다이어리 전체목록 조회
	public List<DiaryVO> selectList(int idx){
		List<DiaryVO> list = sqlSession.selectList("d.diary_list", idx);
		return list;
	}
	
	// 작성된 글 갯수 구하기
	public int selectCountNum(int idx) {
		int res = sqlSession.selectOne("d.countNum", idx);
		return res;
	}
	
	//새 글 추가
	public int insert(DiaryVO vo) {
		//맵퍼로 딱 한개의 객체만 넘겨줄 수 있다.
		int res = sqlSession.insert("d.diary_insert", vo);
		return res;
	}
	
	//글 삭제
	public int delete(DiaryVO vo ) {
		int res = sqlSession.delete("d.diary_delete", vo);
		return res;
	}
	
	// 방명록 삭제 후 삭제한 방명록 번호보다 큰 번호들을 조회
	public List<DiaryVO> selectListDelete(HashMap<String, Integer> map) {
		List<DiaryVO> list = sqlSession.selectList("d.diary_list_delete", map);
		return list;
	}
	
	// 방명록 삭제 후 삭제한 방명록 번호보다 큰 번호들을 1씩 감소시켜서 갱신
	public int updateRefMinus(DiaryVO vo) {
		int res = sqlSession.update("d.diary_update_ref_minus", vo);
		return res;
	}
	
	//수정을 위한 게시글 한 건 조회
	public DiaryVO selectOne( DiaryVO vo ) {
		DiaryVO updateVo = sqlSession.selectOne("d.diary_one", vo);
		return updateVo;
	}
	
	//게시글 수정
	public int update( DiaryVO vo ) {
		int res = sqlSession.update("d.diary_update", vo);
		return res;
	}	
}
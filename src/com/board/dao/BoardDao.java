package com.board.dao;

import java.sql.SQLException;
import java.util.List;

import com.board.model.BoardVo;
import com.util.SqlMapLocator;

public class BoardDao {
  private static BoardDao singleton;

  private BoardDao() {
  }

  public static BoardDao getInstance() {
    if (singleton == null)
      singleton = new BoardDao();
    return singleton;
  }
  
  public List<BoardVo> list(Object obj) throws SQLException {      
	List<BoardVo> list = SqlMapLocator.getMapper().queryForList("BoardList", obj);
	return list;
  }
  
  public void insert(Object obj) throws SQLException {
    SqlMapLocator.getMapper().insert("BoardInsert", (BoardVo)obj);
  }
   
  public BoardVo selectBoard(Object obj) throws SQLException { 
	BoardVo vo=(BoardVo)SqlMapLocator.getMapper().queryForObject("BoardOne", obj);	  
	return vo;
  }
  
  public int getMaxSeq() throws SQLException {    
    return ((Integer)SqlMapLocator.getMapper()
      .queryForObject("BoardMaxSeq")).intValue();
  }
  
  public void updateStep(Object obj) throws SQLException {
    SqlMapLocator.getMapper().update("BoardStepUpdate",obj);
  }
  public void updateHit(Object obj)throws SQLException{
    SqlMapLocator.getMapper().update("BoardHitUpdate",obj);
  }
  public void update(Object obj)throws SQLException{
    SqlMapLocator.getMapper().update("BoardUpdate",obj);
  }
  public void delete(Object obj)throws SQLException{
    SqlMapLocator.getMapper().delete("BoardDelete",obj);
  }
  public int getRowCount(Object obj) throws SQLException {    
     return ((Integer)SqlMapLocator.getMapper().queryForObject("BoardCnt", obj)).intValue();
  }
}

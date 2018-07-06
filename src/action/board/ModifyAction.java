package action.board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.board.dao.BoardDao;
import com.board.model.BoardVo;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class ModifyAction extends ActionSupport 	
   implements Preparable, ModelDriven {
	
  private BoardDao dao;

  private BoardVo boardVo;
  
  private int seqarg; 
  private int currentPage;  //현재 페이지
  
  // 생성자
  public ModifyAction() {
	dao = BoardDao.getInstance();
  }

  // 게시글 수정
  @Override
  public String execute() throws Exception {
	  boardVo.setSeq(seqarg);
	  
	dao.update(boardVo);
	
    return SUCCESS;
  }
  
public int getSeqarg() {
	return seqarg;
}

public void setSeqarg(int seqarg) {
	this.seqarg = seqarg;
}

public int getCurrentPage() {
	return currentPage;
}

public void setCurrentPage(int currentPage) {
	this.currentPage = currentPage;
} 
	@Override
	public void prepare() throws Exception {
		boardVo = new BoardVo();
	}

	@Override
	public Object getModel() {
		return boardVo;
	}

	public BoardVo getBoardVo() {
		return boardVo;
	}

	public void setBoardVo(BoardVo boardVo) {
		this.boardVo = boardVo;
	}


	
}

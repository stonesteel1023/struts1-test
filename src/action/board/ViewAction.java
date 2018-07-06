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

public class ViewAction extends ActionSupport 
  implements Preparable, ModelDriven {
	
  private BoardDao dao;  
  private String bname="bbs"; 	   //게시판 이름
	
  private BoardVo boardVo;
  
  private int currentPage;

  private int seqarg;
  private String pwdarg;

  public ViewAction() {
	dao = BoardDao.getInstance();
  }

  // 상세보기
  public String execute() throws Exception {	    
    Map map = new HashMap();
    map.put("bname", bname);
    map.put("seq", seqarg);    

    // 해당 글의 조회수 +1.
    dao.updateHit(map);
    
    // 해당 번호의 글을 가져온다.  
    boardVo = dao.selectBoard(map);

    return SUCCESS;
  } 

  // 비밀번호 체크 폼
  public String checkForm() throws Exception {

    return SUCCESS;
  }

  // 비밀번호 체크 액션
  public String checkAction() throws Exception {
	    Map map = new HashMap();
	    map.put("bname", bname);
	    map.put("seq", seqarg);   
		
	// 해당 번호의 글을 가져온다. 
	boardVo = dao.selectBoard(map);
	
    // 입력한 비밀번호가 틀리면 ERROR 리턴.
    if (boardVo.getPwd().equals(pwdarg) == false)
      return ERROR;
    
    return SUCCESS;
  } 

  public int getCurrentPage() {
    return currentPage;
  }

  public void setCurrentPage(int currentPage) {
    this.currentPage = currentPage;
  }
  
  public int getSeqarg() {
	return seqarg;
}

public void setSeqarg(int seqarg) {
	this.seqarg = seqarg;
}

public String getPwdarg() {
	return pwdarg;
}

public void setPwdarg(String pwdarg) {
	this.pwdarg = pwdarg;
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


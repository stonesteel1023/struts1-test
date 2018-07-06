package action.board;
import java.io.IOException;

import com.board.dao.BoardDao;
import com.board.model.BoardVo;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteAction extends ActionSupport {
	private BoardDao dao;
	private String bname="bbs"; 	   //게시판 이름
	private BoardVo vo;

    private int currentPage;  //현재 페이지
    private int seq;
    
  // 생성자
  public DeleteAction() throws IOException {
	dao = BoardDao.getInstance();
  }

  // 게시글 글 삭제
  public String execute() throws Exception {  
	dao.delete(seq);

    return SUCCESS;
  }

  public int getSeq() {
	return seq;
  }

  public void setSeq(int seq) {
	this.seq = seq;
  }

  public int getCurrentPage() {
    return currentPage;
  }

  public void setCurrentPage(int currentPage) {
    this.currentPage = currentPage;
  }
}
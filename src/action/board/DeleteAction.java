package action.board;
import java.io.IOException;

import com.board.dao.BoardDao;
import com.board.model.BoardVo;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteAction extends ActionSupport {
	private BoardDao dao;
	private String bname="bbs"; 	   //�Խ��� �̸�
	private BoardVo vo;

    private int currentPage;  //���� ������
    private int seq;
    
  // ������
  public DeleteAction() throws IOException {
	dao = BoardDao.getInstance();
  }

  // �Խñ� �� ����
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
package action.board;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import com.board.dao.BoardDao;
import com.board.model.BoardVo;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.ModelDriven;


public class WriteAction extends ActionSupport 
	implements Preparable, ModelDriven {
	
	private BoardDao dao;
	private String bname="bbs"; 	   //게시판 이름
	private BoardVo boardVo;
	
	private int currentPage; //현재 페이지
	
	private int seq;
	
	private int group = 0;
	private int step = 0;
	private int level = 0;

	private Calendar today; 
	
	public WriteAction() {
		dao = BoardDao.getInstance();
		today = Calendar.getInstance(); //오늘 날짜 구하기.
	}

	public String form() throws Exception {
		//등록 폼.
		return SUCCESS;
	}

	// 게시판 WRITE 액션
	@Override
	public String execute() throws Exception {
		int seq = dao.getMaxSeq()+1;
		if(boardVo.getSeq() == 0 ){
		      group = seq;
		      step = 0;
		      level = 0;
		}else{
		      group = boardVo.getGroups();
		      step = boardVo.getSeq()+1;
		      Map map = new HashMap();
		      map.put("groups",group);
		      map.put("step",step);
		      dao.updateStep(map);
		      level = boardVo.getLevel() + 1;	
		}
		boardVo.setBname(bname);
		boardVo.setSeq(seq);
		boardVo.setGroups(group);
		boardVo.setStep(step);
		boardVo.setLevel(level);

		dao.insert(boardVo);	
		
		return SUCCESS;
	}

	  public int getCurrentPage() {
	    return currentPage;
	  }

	  public void setCurrentPage(int currentPage) {
	    this.currentPage = currentPage;
	  }
	    
	  public int getSeq() {
		return seq;
	  }

	  public void setSeq(int seq) {
		this.seq = seq;
	  }
	  
	@Override
	public void prepare() throws Exception {
		boardVo = new BoardVo();
	}

	@Override
	public Object getModel() {
		return boardVo;
	}	
}

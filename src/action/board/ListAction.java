package action.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.board.dao.BoardDao;
import com.board.model.BoardVo;
import com.opensymphony.xwork2.ActionSupport;

public class ListAction extends ActionSupport {
	
	private BoardDao dao; 
	private String bname="bbs"; 	   //게시판 이름
	private List<BoardVo> list = new ArrayList<BoardVo>();	

	private int currentPage = 1;	// 현재 페이지
	private int totalCount; 		// 총 게시물의 수
	private int blockCount = 10;	// 한 페이지의  게시물의 수
	private int blockPage = 5; 		// 한 화면에 보여줄 페이지 수
	private String pagingHtml; 		// 페이징을 구현한 HTML
	private PagingAction page; 		// 페이징 클래스
	
	// 생성자
	public ListAction() throws IOException {
		dao = BoardDao.getInstance();
	}
	// 게시판 LIST 액션
	public String execute() throws Exception {		
		HashMap map = new HashMap();		
		map.put("bname",bname);
		
		totalCount = dao.getRowCount(map);  // 전체 글 갯수를 구한다.
		
		page = new PagingAction(currentPage, totalCount, blockCount, blockPage); // PagingAction 객체 생성.
		pagingHtml = page.getPagingHtml().toString(); // 페이지 HTML 생성.
		// 현재 페이지에서 보여줄 마지막 글의 번호 설정.
		int lastCount = totalCount;
		// 현재 페이지의 마지막 글의 번호가 전체의 마지막 글 번호보다 작으면 lastCount를 +1 번호로 설정.
		if (page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;
		// 현재 페이지만큼의 게시물  리스트를 가져온다.
		map.put("start", page.getStartCount());
		map.put("end", lastCount);
		list = dao.list(map);

		return SUCCESS;
	}	
	public List<BoardVo> getList() {
		return list;
	}
	public void setList(List<BoardVo> list) {
		this.list = list;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getBlockCount() {
		return blockCount;
	}
	public void setBlockCount(int blockCount) {
		this.blockCount = blockCount;
	}
	public int getBlockPage() {
		return blockPage;
	}
	public void setBlockPage(int blockPage) {
		this.blockPage = blockPage;
	}
	public String getPagingHtml() {
		return pagingHtml;
	}
	public void setPagingHtml(String pagingHtml) {
		this.pagingHtml = pagingHtml;
	}
	public PagingAction getPage() {
		return page;
	}
	public void setPage(PagingAction page) {
		this.page = page;
	}
}

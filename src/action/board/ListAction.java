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
	private String bname="bbs"; 	   //�Խ��� �̸�
	private List<BoardVo> list = new ArrayList<BoardVo>();	

	private int currentPage = 1;	// ���� ������
	private int totalCount; 		// �� �Խù��� ��
	private int blockCount = 10;	// �� ��������  �Խù��� ��
	private int blockPage = 5; 		// �� ȭ�鿡 ������ ������ ��
	private String pagingHtml; 		// ����¡�� ������ HTML
	private PagingAction page; 		// ����¡ Ŭ����
	
	// ������
	public ListAction() throws IOException {
		dao = BoardDao.getInstance();
	}
	// �Խ��� LIST �׼�
	public String execute() throws Exception {		
		HashMap map = new HashMap();		
		map.put("bname",bname);
		
		totalCount = dao.getRowCount(map);  // ��ü �� ������ ���Ѵ�.
		
		page = new PagingAction(currentPage, totalCount, blockCount, blockPage); // PagingAction ��ü ����.
		pagingHtml = page.getPagingHtml().toString(); // ������ HTML ����.
		// ���� ���������� ������ ������ ���� ��ȣ ����.
		int lastCount = totalCount;
		// ���� �������� ������ ���� ��ȣ�� ��ü�� ������ �� ��ȣ���� ������ lastCount�� +1 ��ȣ�� ����.
		if (page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;
		// ���� ��������ŭ�� �Խù�  ����Ʈ�� �����´�.
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

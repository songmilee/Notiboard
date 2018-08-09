package mi.noti.board.model;

public class Page { 
	public static int totalText = 0;
	
	private int pageSize = 10;
	private int blockSize = 10;
	
	private int curPage = 1;
	private int curBlock = 1;
	
	private int totalPage;
	private int totalBlock;
	
	private int startPage = 1;
	private int endPage = 1;
	
	private int startIndex = 0;
	
	private int prevPage;
	private int nextPage;
	
	public Page(int curPage) {
		this.curPage = curPage;
		
		setTotalPage();
		setTotalBlock();
		setting();
		
	}
	
	public void setTotalPage() {
		this.totalPage = this.totalText / this.pageSize;
		
		if(totalText % pageSize > 0)
			totalPage++;
	}
	
	public void setTotalBlock() {
		this.totalBlock = totalPage / blockSize; 
		
		if(totalPage % blockSize > 0)
			totalBlock++;
	}
	
	public void setting() {
		setCurBlock();
		setStartIndex();
		
		this.startPage = (this.curBlock - 1) * this.blockSize + 1;
		this.endPage = startPage + this.blockSize - 1;
		
		if(this.endPage > this.totalPage)
			this.endPage = this.totalPage;
		
		this.prevPage = this.curPage - 1;
		this.nextPage = this.curPage + 1;
	}
	
	public void setCurBlock() {
		this.curBlock = (int) ((this.curPage - 1)/this.blockSize) + 1;
	}
	
	public void setStartIndex() {
		this.startIndex = (this.curPage - 1) * this.pageSize;
	}

	public static int getTotalText() {
		return totalText;
	}

	public static void setTotalText(int totalText) {
		Page.totalText = totalText;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(int blockSize) {
		this.blockSize = blockSize;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getCurBlock() {
		return curBlock;
	}

	public void setCurBlock(int curBlock) {
		this.curBlock = curBlock;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalBlock() {
		return totalBlock;
	}

	public void setTotalBlock(int totalBlock) {
		this.totalBlock = totalBlock;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getPrevPage() {
		return prevPage;
	}

	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	
}

package Diary;

public class PostDTO {
	private Long postId; //게시판 글 번호
	private String memberId;// 회원 id
	private String postTitle; // 게시판 글 제목
	private String postContents; // 내용
	private String postCreatedDate; // 게시글 작성일
	private int postHits; // 게시글 조회수
	private String postCreatedTime; // 게시글 작성 시간

	PostDTO(){
		
	}
	
	public PostDTO(Long postId, String memberId, String postTitle, String postContents, String postCreatedDate,
			int postHits, String postCreatedTime) {
		this.postId = postId;
		this.memberId = memberId;
		this.postTitle = postTitle;
		this.postContents = postContents;
		this.postCreatedDate = postCreatedDate;
		this.postHits = postHits;
		this.postCreatedTime = postCreatedTime;
	}

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostContents() {
		return postContents;
	}

	public void setPostContents(String postContents) {
		this.postContents = postContents;
	}

	public String getPostCreatedDate() {
		return postCreatedDate;
	}

	public void setPostCreatedDate(String postCreatedDate) {
		this.postCreatedDate = postCreatedDate;
	}

	public int getPostHits() {
		return postHits;
	}

	public void setPostHits(int postHits) {
		this.postHits = postHits;
	}

	public String getPostCreatedTime() {
		return postCreatedTime;
	}

	public void setPostCreatedTime(String postCreatedTime) {
		this.postCreatedTime = postCreatedTime;
	}

	@Override
	public String toString() {
		return "PostDTO [postId=" + postId + ", memberId=" + memberId + ", postTitle=" + postTitle + ", postContents="
				+ postContents + ", postCreatedDate=" + postCreatedDate + ", postHits=" + postHits
				+ ", postCreatedTime=" + postCreatedTime + "]";
	}
	
	
}
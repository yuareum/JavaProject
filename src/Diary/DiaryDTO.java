package Diary;

public class DiaryDTO {
	private Long id; // 다이어리 번호
	private String memberId; // 회원 id
	private String diaryDate; // 다이어리 작성 연,월,일 기입
	private String diaryTitle; // 다이어리 제목
	private String diary; // 다이어리 작성
	private String diaryCreatedTime; // 작성 시간
	private int diaryHits; // 다이어리 조회 수
	
	DiaryDTO(){
		
	}

	public DiaryDTO(Long id, String memberId, String diaryDate, String diaryTitle, String diary,
			String diaryCreatedTime, int diaryHits) {
		this.id = id;
		this.memberId = memberId;
		this.diaryDate = diaryDate;
		this.diaryTitle = diaryTitle;
		this.diary = diary;
		this.diaryCreatedTime = diaryCreatedTime;
		this.diaryHits = diaryHits;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getDiaryDate() {
		return diaryDate;
	}

	public void setDiaryDate(String diaryDate) {
		this.diaryDate = diaryDate;
	}

	public String getDiaryTitle() {
		return diaryTitle;
	}

	public void setDiaryTitle(String diaryTitle) {
		this.diaryTitle = diaryTitle;
	}

	public String getDiary() {
		return diary;
	}

	public void setDiary(String diary) {
		this.diary = diary;
	}

	public String getDiaryCreatedTime() {
		return diaryCreatedTime;
	}

	public void setDiaryCreatedTime(String diaryCreatedTime) {
		this.diaryCreatedTime = diaryCreatedTime;
	}

	public int getDiaryHits() {
		return diaryHits;
	}

	public void setDiaryHits(int diaryHits) {
		this.diaryHits = diaryHits;
	}

	@Override
	public String toString() {
		return "DiaryDTO [id=" + id + ", memberId=" + memberId + ", diaryDate=" + diaryDate + ", diaryTitle="
				+ diaryTitle + ", diary=" + diary + ", diaryCreatedTime=" + diaryCreatedTime + ", diaryHits="
				+ diaryHits + "]";
	}
	
	
}

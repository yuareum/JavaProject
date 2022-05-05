package Diary;

public class MemberDTO {
	private Long id; // 회원 번호
	private String memberId; // 회원 id
	private String memberPass; // 회원 비밀번호
	private String memberName; // 회원 이름
	private int memberAge; // 회원 나이
	private String memberMobile; // 회원 전화번호
	private String memberEmail; // 회원 이메일
	private String memberCreatedDate;// 회원 생성 시간
	
	public MemberDTO() {
		
	}

	public MemberDTO(Long id, String memberId, String memberPass, String memberName, int memberAge, String memberMobile, String memberEmail, String memberCreatedDate) {
		this.id = id;
		this.memberId = memberId;
		this.memberPass = memberPass;
		this.memberName = memberName;
		this.memberAge = memberAge;
		this.memberMobile = memberMobile;
		this.memberEmail = memberEmail;
		this.memberCreatedDate = memberCreatedDate;
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

	public String getMemberPass() {
		return memberPass;
	}

	public void setMemberPass(String memberPass) {
		this.memberPass = memberPass;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getMemberAge() {
		return memberAge;
	}

	public void setMemberAge(int memberAge) {
		this.memberAge = memberAge;
	}

	public String getMemberMobile() {
		return memberMobile;
	}

	public void setMemberMobile(String memberMobile) {
		this.memberMobile = memberMobile;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberCreatedDate() {
		return memberCreatedDate;
	}

	public void setMemberCreatedDate(String memberCreatedDate) {
		this.memberCreatedDate = memberCreatedDate;
	}

	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", memberId=" + memberId + ", memberPass=" + memberPass + ", memberName="
				+ memberName + ", memberAge=" + memberAge + ", memberMobile=" + memberMobile + ", memberEmail="
				+ memberEmail + ", memberCreatedDate=" + memberCreatedDate + "]";
	}
	

}

package Diary;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DiaryRepository {
	static List<MemberDTO> memberList = new ArrayList<>();
	static List<DiaryDTO> diaryList = new ArrayList<>();
	static List<PostDTO> postList = new ArrayList<>();
	
	static Long diaryId = 0L;
	static int diaryHits = 0;
	static Long postId = 0L;
	static int postHits = 0;
	Scanner scan = new Scanner(System.in);

	public boolean checkMemberId(String memberId) {
		boolean checkResult = false;
		for (int i = 0; i < memberList.size(); i++) {
			if (memberId.equals(memberList.get(i).getMemberId())) {
				checkResult = true;
			}
		}
		return checkResult;
	}

	public boolean save(MemberDTO newMember) {
		return memberList.add(newMember);
	}

	public boolean memberLogin(String memberId, String memberPass) {
		boolean memberLogin = false;
		for (int i = 0; i < memberList.size(); i++) {
			if (memberId.equals(memberList.get(i).getMemberId())
					&& memberPass.equals(memberList.get(i).getMemberPass())) {
				memberLogin = true;
			}
		}
		return memberLogin;
	}

	public List<MemberDTO> memberFindAll() {
		return memberList;
	}

	public MemberDTO findByMemberId(String memberId) {
		MemberDTO findMember = null;
		for (int i = 0; i < memberList.size(); i++) {
			if (memberId.equals(memberList.get(i).getMemberId())) {
				findMember = memberList.get(i);
			}
		}
		return findMember;
	}    

	public MemberDTO memberPassUpdate(String memberId, String memberPass) {
		MemberDTO memberPassUpdate = null;
		for (int i = 0; i < memberList.size(); i++) {
			if (memberId.equals(memberList.get(i).getMemberId())) {
				memberList.get(i).setMemberPass(memberPass);
				memberPassUpdate = memberList.get(i);
			}
		}
		return memberPassUpdate;

	}

	public MemberDTO memberMobileUpdate(String memberId, String memberMobile) {
		MemberDTO memberMobileUpdate = null;
		for (int i = 0; i < memberList.size(); i++) {
			if (memberId.equals(memberList.get(i).getMemberId())) {
				memberList.get(i).setMemberMobile(memberMobile);
				memberMobileUpdate = memberList.get(i);
			}
		}
		return memberMobileUpdate;

	}

	public MemberDTO memberEmailUpdate(String memberId, String memberEmail) {
		MemberDTO memberEmailUpdate = null;
		for (int i = 0; i < memberList.size(); i++) {
			if (memberId.equals(memberList.get(i).getMemberId())) {
				memberList.get(i).setMemberEmail(memberEmail);
				memberEmailUpdate = memberList.get(i);
			}
		}
		return memberEmailUpdate;
	}

	public void memberDelete(String memberId, String memberPass) {
		for (int i = 0; i < memberList.size(); i++) {
			if (memberId.equals(memberList.get(i).getMemberId())
					&& memberPass.equals(memberList.get(i).getMemberPass())) {
				memberList.remove(i);
			}
		}
	}
	
	public boolean diarySave(String memberId,String diaryTitle, int open, String diary) {
		boolean diaryResult = false;
		for (int i = 0; i < memberList.size(); i++) {
			if (memberId.equals(memberList.get(i).getMemberId())) {
				DiaryDTO newDiary = new DiaryDTO(++diaryId, memberId, createdDate(),diaryTitle, diary, createdTime(),open,diaryHits);
				diaryList.add(newDiary);
				diaryResult = true;
			}
		}
		return diaryResult;

	}

	private String createdTime() {
		LocalDateTime dateTime = LocalDateTime.now();
		String createdTime = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		return createdTime;
	}

	private String createdDate() {
		LocalDate dateTime = LocalDate.now();
		String createdDate = dateTime.format(DateTimeFormatter.ofPattern("yyyy년MM월dd일"));
		return createdDate;
	}
	
	//공개된 다이어리 전체 목록 
	public List<DiaryDTO> openDiaryFindByAll() {
		List<DiaryDTO> list = new ArrayList<>();
		for (int i = 0; i < diaryList.size(); i++) {
			if (diaryList.get(i).getOpen() == 1) {
				list.add(diaryList.get(i));
			}
		}
		return list;
	}
	//공개된 다이어리 상세 조회 
	public List<DiaryDTO> OpenDiaryFindByMemberId(String memberId) {
		List<DiaryDTO> list = new ArrayList<>();
		for (int i = 0; i < diaryList.size(); i++) {
			if (memberId.equals(diaryList.get(i).getMemberId()) && diaryList.get(i).getOpen() == 1) {
				list.add(diaryList.get(i));
			}
		}
		return list;
	}
	public List<DiaryDTO> OpenDiaryFindByDate(String diaryDate) {
		List<DiaryDTO> list = new ArrayList<>();
		for (int i = 0; i < diaryList.size(); i++) {
			if (diaryDate.equals(diaryList.get(i).getDiaryDate()) && diaryList.get(i).getOpen() == 1) {
				list.add(diaryList.get(i));
			}
		}
		return list;
	}
	public List<DiaryDTO> OpenDiaryFindByTitle(String diaryTitle) {
		List<DiaryDTO> list = new ArrayList<>();
		for (int i = 0; i < diaryList.size(); i++) {
			if (diaryTitle.equals(diaryList.get(i).getDiaryTitle()) && diaryList.get(i).getOpen() == 1) {
				list.add(diaryList.get(i));
			}
		}
		return list;
	}
	//글 번호는 중복 없음
	public List<DiaryDTO> OpenDiaryFindByDiaryId(Long diaryId2) {
		List<DiaryDTO> list = new ArrayList<>();
		for (int i = 0; i < diaryList.size(); i++) {
			if (diaryId2.equals(diaryList.get(i).getId()) && diaryList.get(i).getOpen() == 1) {
				diaryList.get(i).setDiaryHits(diaryList.get(i).getDiaryHits() + 1);
				list.add(diaryList.get(i));
			}
		}
		return list;
	}
	
	
	// 작성한 다이어리 목록
	public List<DiaryDTO> diaryFindByMemberId(String memberId) {
		List<DiaryDTO> list = new ArrayList<>();
		for (int i = 0; i < diaryList.size(); i++) {
			if (memberId.equals(diaryList.get(i).getMemberId())) {
				list.add(diaryList.get(i));
			}
		}
		return list;
	}
	
	
	public DiaryDTO diaryUpdate(Long diaryId2, String memberId, String diaryTitle, String diary) {
		DiaryDTO diaryUpdate = null;
		for (int i = 0; i < diaryList.size(); i++) {
			if (diaryId2.equals(diaryList.get(i).getId()) && memberId.equals(diaryList.get(i).getMemberId())) {
				diaryList.get(i).setDiaryTitle(diaryTitle);
				diaryList.get(i).setDiary(diary);
				diaryUpdate = diaryList.get(i);
			}
		}
		return diaryUpdate;
	}

	public boolean diaryDelete(Long diaryId2,String memberId) {
		boolean deleteResult = false;
		for (int i = 0; i < diaryList.size(); i++) {
			if (diaryId2.equals(diaryList.get(i).getId()) && memberId.equals(diaryList.get(i).getMemberId())) {
				diaryList.remove(i);
				deleteResult = true;
			}
		}
		return deleteResult;
	}

	public boolean postSave(String memberId, String postTitle, String postContents) {
		boolean postResult = false;
		for(int i = 0; i < memberList.size();i++) {
			if(memberId.equals(memberList.get(i).getMemberId())) {
				PostDTO newPost = new PostDTO(++postId,memberId,postTitle,postContents,createdDate(),postHits,createdTime());
				postList.add(newPost);
				postResult = true;
			}
		}
		return postResult;
	}

	public List<PostDTO> postFindAll() {
		return postList;
	}

	public List<PostDTO> postFindByMemberId(String memberId) {
		List<PostDTO> list = new ArrayList<>();
		for (int i = 0; i < postList.size(); i++) {
			if (memberId.equals(postList.get(i).getMemberId())) {
				list.add(postList.get(i));
			}
		}
		return list;
	}
	public List<PostDTO> postFindByPostTitle(String postTitle) {
		List<PostDTO> list = new ArrayList<>();
		for (int i = 0; i < postList.size(); i++) {
			if (postTitle.equals(postList.get(i).getPostTitle())) {
				list.add(postList.get(i));
			}
		}
		return list;
	}

	public List<PostDTO> postFindByPostDate(String postDate) {
		List<PostDTO> list = new ArrayList<>();
		for (int i = 0; i < postList.size(); i++) {
			if (postDate.equals(postList.get(i).getPostCreatedDate())) {
				list.add(postList.get(i));
			}
		}
		return list;
	}
	
	public List<PostDTO> postFindByPostId(Long postId2) {
		List<PostDTO> list = new ArrayList<>();
		for (int i = 0; i < postList.size(); i++) {
			if (postId2.equals(postList.get(i).getPostId())) {
				postList.get(i).setPostHits(postList.get(i).getPostHits()+1);
				list.add(postList.get(i));
			}
		}
		return list;
	}
	
	public boolean checkPostId(Long postId2) {
		boolean checkPostId = false;
		for(int i = 0 ; i < postList.size(); i++) {
			if(postId2.equals(postList.get(i).getPostId())) {
				checkPostId = true;
			}
		}
		return checkPostId;
	}

	public PostDTO postUpdate(Long postId2,String memberId, String postTitle, String postContents) {
		PostDTO postUpdate = null;
		for (int i = 0; i < postList.size(); i++) {
			if (postId2.equals(postList.get(i).getPostId()) && memberId.equals(postList.get(i).getMemberId())) {
				postList.get(i).setPostTitle(postTitle);
				postList.get(i).setPostContents(postContents);
				postUpdate = postList.get(i);
			}
		}
		return postUpdate;
		
	}

	public boolean postDelete(Long postId2,String memberId) {
		boolean postDelete = false;
		for(int i = 0; i < postList.size(); i++) {
			if(postId2.equals(postList.get(i).getPostId()) && memberId.equals(postList.get(i).getMemberId())) {
				postList.remove(i);
				postDelete = true;
			}
		}
		return postDelete;
	}
	
}

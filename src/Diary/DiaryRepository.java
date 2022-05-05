package Diary;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DiaryRepository {
	static List<MemberDTO> memberList = new ArrayList<>();
	static List<DiaryDTO> diaryList = new ArrayList<>();
	static Long diaryId = 0L;
	static int diaryHits = 0;
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

	public boolean diarySave(DiaryDTO newDiary) {
		return diaryList.add(newDiary);
	}

	public boolean diaryWrite(String memberId, String diary) {
		boolean diaryResult = false;
		for (int i = 0; i < memberList.size(); i++) {
			if (memberId.equals(memberList.get(i).getMemberId())) {
				DiaryDTO newDiary = new DiaryDTO(++diaryId, memberId, diaryDate(), diary, "", diaryCreatedTime(),
						diaryHits);
				diaryList.add(newDiary);
				diaryResult = true;
			}
		}
		return diaryResult;

	}

	private String diaryCreatedTime() {
		LocalDateTime dateTime = LocalDateTime.now();
		String diaryCreatedTime = dateTime.format(DateTimeFormatter.ofPattern("yyyy년MM월dd일 HH:mm:ss"));
		return diaryCreatedTime;
	}

	private String diaryDate() {
		LocalDate dateTime = LocalDate.now();
		String diaryDate = dateTime.format(DateTimeFormatter.ofPattern("yyyy년MM월dd일"));
		return diaryDate;
	}

	public List<DiaryDTO> diaryFindAll() {
		return diaryList;
	}

	public List<DiaryDTO> diaryFindByMemberId(String memberId) {
		List<DiaryDTO> list = new ArrayList<>();
		for (int i = 0; i < diaryList.size(); i++) {
			if (memberId.equals(diaryList.get(i).getMemberId())) {
				diaryList.get(i).setDiaryHits(diaryList.get(i).getDiaryHits() + 1);
				list.add(diaryList.get(i));
			}
		}
		return list;
	}

	public List<DiaryDTO> diaryFindByDate(String diaryDate) {
		List<DiaryDTO> list = new ArrayList<>();
		for (int i = 0; i < diaryList.size(); i++) {
			if (diaryDate.equals(diaryList.get(i).getDiaryDate())) {
				diaryList.get(i).setDiaryHits(diaryList.get(i).getDiaryHits() + 1);
				list.add(diaryList.get(i));
			}
		}
		return list;
	}

	public DiaryDTO diaryFindById(Long id) {
		DiaryDTO diary = null;
		for (int i = 0; i < diaryList.size(); i++) {
			if (id.equals(diaryList.get(i).getId())) {
				diary = diaryList.get(i);
			}
		}
		return diary;
	}

	public DiaryDTO diaryComment(Long id, String comment) {
		DiaryDTO diary = null;
		for (int i = 0; i < diaryList.size(); i++) {
			if (id.equals(diaryList.get(i).getId())) {
				diaryList.get(i).setComment(comment);
				diary = diaryList.get(i);
			}
		}
		return diary;
	}

	public DiaryDTO diaryUpdate(Long id, String memberId, String diary) {
		DiaryDTO diaryUpdate = null;
		for (int i = 0; i < diaryList.size(); i++) {
			if (id.equals(diaryList.get(i).getId()) && memberId.equals(diaryList.get(i).getMemberId())) {
				diaryList.get(i).setDiary(diary);
				diaryUpdate = diaryList.get(i);
			}
		}
		return diaryUpdate;

	}

	public boolean diaryDelete(Long id, String memberId) {
		boolean diaryDelete = false;
		for (int i = 0; i < diaryList.size(); i++) {
			if (id.equals(diaryList.get(i).getId()) && memberId.equals(diaryList.get(i).getMemberId())) {
				diaryList.remove(i);
				diaryDelete = true;
			}
		}
		return diaryDelete;
	}
}

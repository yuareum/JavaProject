package Diary;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DiaryService {
	Scanner scan = new Scanner(System.in);
	static Long id = 0L;
	static Long noticeId = 0L;
	DiaryRepository dr = new DiaryRepository();

	public void memberSave() {
		System.out.print("아이디: ");
		String memberId = scan.next();
		System.out.print("비밀번호: ");
		String memberPass = scan.next();
		System.out.print("이름: ");
		String memberName = scan.next();
		System.out.print("나이: ");
		int memberAge = scan.nextInt();
		System.out.print("전화번호: ");
		String memberMobile = scan.next();
		System.out.print("이메일: ");
		String memberEmail = scan.next();
		LocalDateTime dateTime = LocalDateTime.now();
		String memberCreatedDate = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

		if (!checkMemberId(memberId)) {
			MemberDTO newMember = new MemberDTO(++id, memberId, memberPass, memberName, memberAge, memberMobile,
					memberEmail, memberCreatedDate);
			boolean saveResult = dr.save(newMember);
			if (saveResult) {
				System.out.println("회원가입 성공");
			} else {
				System.out.println("회원가입 실패");
			}
		} else {
			System.out.println("아이디가 중복됩니다. 다시 입력하세요.");
		}
	}

	public void memberLogin() {
		memberFindAll();
		System.out.print("아이디: ");
		String memberId = scan.next();
		System.out.print("비밀번호: ");
		String memberPass = scan.next();
		if (checkMemberId(memberId)) {
			boolean login = dr.memberLogin(memberId, memberPass);
			if (login) {
				System.out.println("로그인 성공");
			} else {
				System.out.println("로그인 실패. 다시 입력 하세요!!");
			}
		} else {
			System.out.println("로그인 실패. 다시 입력 하세요!!");
		}
	}

	public void memberFindAll() {
		List<MemberDTO> memberList = dr.memberFindAll();
		for (MemberDTO m : memberList) {
			System.out.println(m);
		}
	}

	public void findByMemberId() {
		memberFindAll();
		System.out.print("아이디: ");
		String memberId = scan.next();
		if (checkMemberId(memberId)) {
			MemberDTO findMember = dr.findByMemberId(memberId);
			System.out.println("해당 회원 정보: " + findMember);
		} else {
			System.out.println("해당 아이디가 없습니다.");
		}
	}

	private boolean checkMemberId(String memberId) {
		return dr.checkMemberId(memberId);
	}

	public void memberUpdate() {
		memberFindAll();
		System.out.print("아이디: ");
		String memberId = scan.next();
		System.out.print("비밀번호 : ");
		String memberPass = scan.next();
		if (dr.memberLogin(memberId, memberPass)) {
			System.out.println("-----------------------------------------------------");
			System.out.println("1. 비밀번호 변경 | 2. 전화번호 변경 | 3. 이메일 변경");
			System.out.println("------------------------------------------------------");
			System.out.print("선택>");
			int select = scan.nextInt();
			if (select == 1) {
				System.out.print("변경할 비밀번호: ");
				memberPass = scan.next();
				MemberDTO memberUpdate = dr.memberPassUpdate(memberId, memberPass);
				System.out.println(memberUpdate);
			} else if (select == 2) {
				dr.memberFindAll();
				System.out.print("변경할 전화번호: ");
				String memberMobile = scan.next();
				MemberDTO memberUpdate = dr.memberMobileUpdate(memberId, memberMobile);
				System.out.println(memberUpdate);
			} else if (select == 3) {
				dr.memberFindAll();
				System.out.print("변경할 이메일: ");
				String memberEmail = scan.next();
				MemberDTO memberUpdate = dr.memberEmailUpdate(memberId, memberEmail);
				System.out.println(memberUpdate);
			}
		} else {
			System.out.println("아이디 또는 비밀번호가 틀립니다. 다시 입력하세요!!");
		}

	}

	public void memberDelete() {
		memberFindAll();
		System.out.print("아이디: ");
		String memberId = scan.next();
		System.out.print("비밀번호: ");
		String memberPass = scan.next();
		boolean login = dr.memberLogin(memberId, memberPass);
		if (login) {
			dr.memberDelete(memberId, memberPass);
			System.out.println("해당 회원이 삭제되었습니다.");
		} else {
			System.out.println("아이디 또는 비밀번호가 틀립니다. 다시 입력하세요!!");
		}
		memberFindAll();
	}

	public void diarySave() {
		memberFindAll();
		System.out.print("아이디: ");
		String memberId = scan.next();
		scan.nextLine();
		System.out.print("비밀번호:");
		String memberPass = scan.next();
		boolean login = dr.memberLogin(memberId, memberPass);
		if (login) {
			scan.nextLine();
			System.out.print("다이어리 제목: ");
			String diaryTitle = scan.next();
			scan.nextLine();
			System.out.print("다이어리: ");
			String diary = scan.nextLine();
			boolean diaryResult = dr.diarySave(memberId, diaryTitle, diary);
			if (diaryResult) {
				System.out.println("다이어리 작성 완료");
			} else {
				System.out.println("다이어리 작성 실패");
			}
		} else {
			System.out.println("아이디 또는 비밀번호가 틀립니다. 다시 입력 하세요!!");
		}
	}

	public void diaryFindAll() {
		List<DiaryDTO> diaryList = dr.diaryFindAll();
		for (DiaryDTO d : diaryList) {
			System.out.println(d);
		}
	}

	public void diaryFindByCondition() {
		diaryFindAll();
		boolean run = true;
		while (run) {
			System.out.println("--------------------------------------------------------------------");
			System.out.println("1. 아이디로 조회 | 2. 작성 일로 조회 | 3.제목 조회 | 4. 글 번호 조회 | 5. 종료 ");
			System.out.println("--------------------------------------------------------------------");
			System.out.print("선택>");
			int select = scan.nextInt();
			if (select == 1) {
				System.out.print("조회할 아이디: ");
				String memberId = scan.next();
				List<DiaryDTO> diaryMemberIdList = dr.diaryFindByMemberId(memberId);
				for (DiaryDTO d : diaryMemberIdList) {
					System.out.println(d);
				}
			} else if (select == 2) {
				System.out.print("조회할 날짜: ");
				String diaryDate = scan.next();
				List<DiaryDTO> diaryDateList = dr.diaryFindByDate(diaryDate);
				for (DiaryDTO d : diaryDateList) {
					System.out.println(d);
				}
			} else if (select == 3) {
				System.out.print("조회할 제목: ");
				String diaryTitle = scan.next();
				List<DiaryDTO> diaryTitleList = dr.diaryFindByTitle(diaryTitle);
				for (DiaryDTO d : diaryTitleList) {
					System.out.println(d);
				}
			} else if (select == 4) {
				System.out.print("조회할 다이어리 번호: ");
				Long diaryId = scan.nextLong();
				List<DiaryDTO> diaryTitleList = dr.diaryFindByDiaryId(diaryId);
				for (DiaryDTO d : diaryTitleList) {
					System.out.println(d);
				}
			}
		}

	}

	public void diaryUpdate() {
		memberFindAll();
		System.out.print("아이디: ");
		String memberId = scan.next();
		System.out.print("비밀번호: ");
		String memberPass = scan.next();
		boolean login = dr.memberLogin(memberId, memberPass);
		if (login) {
			System.out.println("<작성한 다이어리 목록>");
			List<DiaryDTO> diaryFindByMemberId = dr.diaryFindByMemberId(memberId);
			for (DiaryDTO d : diaryFindByMemberId) {
				System.out.println(d);
			}
			System.out.println("-------------------------");
			System.out.println("1. 제목 수정 | 2. 내용 수정");
			System.out.println("-------------------------");
			System.out.print("선택>");
			int select = scan.nextInt();
			if (select == 1) {
				System.out.print("변경할 다이어리 번호: ");
				Long diaryId = scan.nextLong();
				DiaryDTO FindBydiaryId = dr.findByDiaryId(diaryId);
				if (FindBydiaryId != null) {
					System.out.print("변경할 다이어리 제목: ");
					String diaryTitle = scan.next();
					DiaryDTO diaryTitleUpdate = dr.diaryTitleUpdate(diaryId, diaryTitle);
					if (diaryTitleUpdate != null) {
						System.out.println(diaryTitleUpdate);
					} else {
						System.out.println("변경될 내용이 없습니다.");
					}
				} else {
					System.out.println("해당 다이어리 번호가 없습니다.");
				}

			} else if (select == 2) {
				System.out.print("변경할 다이어리 번호: ");
				Long diaryId = scan.nextLong();
				DiaryDTO FindBydiaryId = dr.findByDiaryId(diaryId);
				if (FindBydiaryId != null) {
					System.out.print("변경할 다이어리 내용: ");
					String diary = scan.next();
					DiaryDTO diaryUpdate = dr.diaryUpdate(diaryId, diary);
					if (diaryUpdate != null) {
						System.out.println(diaryUpdate);
					} else {
						System.out.println("변경될 내용이 없습니다.");
					}
				} else {
					System.out.println("해당 다이어리 번호가 없습니다.");
				}
			} else {
				System.out.println("아이디 또는 비밀번호가 틀립니다. 다시 입력 하세요!!");
			}
		}
		else {
			System.out.println("아이디 또는 비밀번호가 틀립니다. 다시 입력하세요!!");
		}
	}

	public void diaryDelete() {
		memberFindAll();
		System.out.print("아이디: ");
		String memberId = scan.next();
		System.out.print("비밀번호: ");
		String memberPass = scan.next();
		boolean login = dr.memberLogin(memberId, memberPass);
		if (login) {
			System.out.println("<작성한 다이어리 목록>");
			List<DiaryDTO> diaryFindByMemberId = dr.diaryFindByMemberId(memberId);
			for (DiaryDTO d : diaryFindByMemberId) {
				System.out.println(d);
			}
			System.out.print("삭제할 다이어리 번호: ");
			Long diaryId = scan.nextLong();
			boolean diaryDel = dr.diaryDelete(diaryId);
			if (diaryDel) {
				System.out.println("다이어리를 삭제하였습니다.");
			} else {
				System.out.println("회원은 해당 글번호의 다이어리가 없습니다.");
			}
		} else {
			System.out.println("아이디 또는 비밀번호가 틀립니다. 다시 입력 하세요!!");
		}
	}

}

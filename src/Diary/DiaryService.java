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
				System.out.println("로그인 실패. 비밀번호가 틀립니다!!");
			}
		} else {
			System.out.println("로그인 실패. 가입하지 않은 아이디 입니다!!");
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
			System.out.println(findMember);
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
			System.out.println("---------------------------------------------------");
			System.out.println("1. 비밀번호 변경 | 2. 전화번호 변경 | 3. 이메일 변경");
			System.out.println("---------------------------------------------------");
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
		System.out.print("비밀번호: ");
		String memberPass = scan.next();
		boolean login = dr.memberLogin(memberId, memberPass);
		if (login) {
			System.out.print("다이어리 제목: ");
			String diaryTitle = scan.next();
			scan.nextLine();
			System.out.print("다이어리: ");
			String diary = scan.nextLine();
			System.out.println("---------------------");
			System.out.println("1. 공개 | 2. 비공개");
			System.out.println("---------------------");
			System.out.print("선택> ");
			int select = scan.nextInt();
			boolean run = true;
			if (select == 1) {
				int open = 1; // 공개 선택시 open = 1로 저장
				boolean diaryResult = dr.diarySave(memberId, diaryTitle, open, diary);
				if (diaryResult) {
					System.out.println("다이어리 작성 완료");
				} else {
					System.out.println("다이어리 작성 실패");
				}
				System.out.println("전체 열람 가능 합니다.");
			} else if (select == 2) {
				int open = 0; // 비공개 선택 시 open = 0 으로 저장
				boolean diaryResult = dr.diarySave(memberId, diaryTitle, open, diary);
				if (diaryResult) {
					System.out.println("다이어리 작성 완료");
				} else {
					System.out.println("다이어리 작성 실패");
				}
				System.out.println("해당 아이디로 로그인한 회원만 열람할 수 있습니다.");

			} else {
				System.out.println("공개/비공개 여부가 선택 되지 않아 다이어리가 작성되지 않습니다.");
			}
		} else {
			System.out.println("아이디 또는 비밀번호가 틀립니다. 다시 입력 하세요!!");
		}
	}

	public void diaryFindByOpen() {
		List<DiaryDTO> diaryList = dr.openDiaryFindByAll();
		for (DiaryDTO d : diaryList) {
			System.out.println(d);
		}
	}

	// 공개된 다이어리 목록 중 에서 해당 조건으로 조회
	public void OpenDiaryFindByCondition() {
		diaryFindByOpen();
		boolean run = true;
		while (run) {
			System.out.println("----------------------------------------------------------------------");
			System.out.println("1. 아이디로 조회 | 2. 제목으로 조회 | 3. 글 번호로 조회 | 4. 종료 ");
			System.out.println("----------------------------------------------------------------------");
			System.out.print("선택>");
			int select = scan.nextInt();
			if (select == 1) {
				System.out.print("조회할 아이디: ");
				String memberId = scan.next();
				List<DiaryDTO> diaryMemberIdList = dr.OpenDiaryFindByMemberId(memberId);
				if(diaryMemberIdList.size() == 1) {
					diaryMemberIdList.get(0).setDiaryHits(diaryMemberIdList.get(0).getDiaryHits()+1);
				}
				else if (diaryMemberIdList.size() == 0) {
					System.out.println("조회 결과가 없습니다.");
				}
				for(DiaryDTO d : diaryMemberIdList) {
					System.out.println(d);
				}
			} else if (select == 2) {
				System.out.print("조회할 제목: ");
				String diaryTitle = scan.next();
				List<DiaryDTO> diaryTitleList = dr.OpenDiaryFindByTitle(diaryTitle);
				if(diaryTitleList.size() == 1) {
					diaryTitleList.get(0).setDiaryHits(diaryTitleList.get(0).getDiaryHits()+1);
				}
				else if (diaryTitleList.size() == 0) {
					System.out.println("조회 결과가 없습니다.");
				}
				for (DiaryDTO d : diaryTitleList) { 
					System.out.println(d);
				}
			} else if (select == 3) {
				System.out.print("조회할 다이어리 번호: ");
				Long diaryId = scan.nextLong();
				List<DiaryDTO> diaryIdList = dr.OpenDiaryFindByDiaryId(diaryId);
				for (DiaryDTO d : diaryIdList) {
					System.out.println(d);
				}
				if (diaryIdList.size() == 0) {
					System.out.println("조회 결과가 없습니다.");
				}
			} else if (select == 4) {
				run = false;
			}
		}
	}

	public void diaryFindBymemberId() {
		memberFindAll();
		System.out.print("아이디: ");
		String memberId = scan.next();
		System.out.print("비밀번호: ");
		String memberPass = scan.next();
		boolean login = dr.memberLogin(memberId, memberPass);
		if (login) {
			List<DiaryDTO> diaryList = dr.diaryFindByMemberId(memberId);
			for (DiaryDTO d : diaryList) {
				System.out.println(d);
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
			System.out.print("변경할 다이어리 번호: ");
			Long diaryId = scan.nextLong();
			System.out.print("변경할 다이어리 제목: ");
			String diaryTitle = scan.next();
			System.out.print("변경할 다이어리 내용: ");
			String diary = scan.next();
			DiaryDTO diaryUpdate = dr.diaryUpdate(diaryId, memberId, diaryTitle, diary);
			if (diaryUpdate != null) {
				System.out.println(diaryUpdate);
			} else {
				System.out.println("회원은 해당 번호의 다이어리가 없습니다.");
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
			boolean diaryDel = dr.diaryDelete(diaryId, memberId);
			if (diaryDel) {
				System.out.println("다이어리를 삭제하였습니다.");
			} else {
				System.out.println("회원은 해당 글번호의 다이어리가 없습니다.");
			}
		} else {
			System.out.println("아이디 또는 비밀번호가 틀립니다. 다시 입력 하세요!!");
		}
	}

	public void postSave() {
		memberFindAll();
		System.out.print("아이디: ");
		String memberId = scan.next();
		System.out.print("비밀번호: ");
		String memberPass = scan.next();
		boolean login = dr.memberLogin(memberId, memberPass);
		if (login) {
			System.out.print("게시글 제목: ");
			String postTitle = scan.next();
			scan.nextLine();
			System.out.print("게시글 내용: ");
			String postContents = scan.nextLine();
			boolean postList = dr.postSave(memberId, postTitle, postContents);
			if (postList) {
				System.out.println("게시판 글 등록 완료.");
			} else {
				System.out.println("게시판 글 등록 실패");
			}
		} else {
			System.out.println("아이디 또는 비밀번호가 틀립니다!!");
		}
	}

	public void postFindByAll() {
		List<PostDTO> postList = dr.postFindAll();
		for (PostDTO p : postList) {
			System.out.println(p);
		}
	}

	public void postFindByCondition() {
		postFindByAll();
		boolean run = true;
		while (run) {
			System.out.println("-----------------------------------------------------------------------");
			System.out.println("1. 아이디로 조회 | 2. 제목으로 조회 | 3. 글 번호로 조회 | 4. 종료 ");
			System.out.println("-----------------------------------------------------------------------");
			System.out.print("선택>");
			int select = scan.nextInt();
			if (select == 1) {
				System.out.print("아이디: ");
				String memberId = scan.next();
				boolean postCheckMemberId = dr.checkMemberId(memberId);
				if (postCheckMemberId) {
					List<PostDTO> postList = dr.postFindByMemberId(memberId);
					if(postList.size() == 1) {
						postList.get(0).setPostHits(postList.get(0).getPostHits()+1);
					}
					else if(postList.size() == 0) {
						System.out.println("해당 아이디가 작성한 게시글이 없습니다.");
					}
					for (PostDTO p : postList) {
						System.out.println(p);
					}
				}
				else {
					System.out.println("해당 아이디가 없습니다.");
				}
			} else if (select == 2) {
				System.out.print("글 제목: ");
				String postTitle = scan.next();
				List<PostDTO> postList = dr.postFindByPostTitle(postTitle);
				if(postList.size() == 1) {
					postList.get(0).setPostHits(postList.get(0).getPostHits()+1);
				}
				else if(postList.size() == 0) {
					System.out.println("해당 제목인 게시글이 없습니다.");
				}
				for (PostDTO p : postList) {
					System.out.println(p);
				}
				
			} else if (select == 3) {
				System.out.print("글 번호: ");
				Long postId = scan.nextLong();
				if(dr.checkPostId(postId)) {
					List<PostDTO> postList = dr.postFindByPostId(postId);
					for (PostDTO p : postList) {
						System.out.println(p);
					}
				}
				else {
					System.out.println("해당 글번호의 게시글이 없습니다.");
				}
			} else if (select == 4) {
				run = false;
			}
		}
	}

	public void postUpdate() {
		memberFindAll();
		System.out.print("아이디: ");
		String memberId = scan.next();
		System.out.print("비밀번호: ");
		String memberPass = scan.next();
		boolean login = dr.memberLogin(memberId, memberPass);
		if (login) {
			System.out.println("<작성한 게시글 목록>");
			List<PostDTO> postList = dr.postFindByMemberId(memberId);
			for (PostDTO p : postList) {
				System.out.println(p);
			}
			System.out.print("변경할 글 번호: ");
			Long postId = scan.nextLong();
			System.out.print("변경할 글 제목: ");
			String postTitle = scan.next();
			scan.nextLine();
			System.out.print("변경할 글 내용: ");
			String postContents = scan.nextLine();
			PostDTO postUpdate = dr.postUpdate(postId, memberId, postTitle, postContents);
			if(postUpdate != null) {
				System.out.println(postUpdate);
			}
			else {
				System.out.println("회원은 해당 글번호의 게시글이 없습니다. ");
			} 		
		}
		else {
			System.out.println("아이디 또는 비밀번호가 틀립니다!!");
		}
	}

	public void postDelete() {
		memberFindAll();
		System.out.print("아이디: ");
		String memberId = scan.next();
		System.out.print("비밀번호: ");
		String memberPass = scan.next();
		boolean login = dr.memberLogin(memberId, memberPass);
		if (login) {
			System.out.println("<작성한 게시글 목록>");
			List<PostDTO> postFindByMemberId = dr.postFindByMemberId(memberId);
			for (PostDTO d : postFindByMemberId) {
				System.out.println(d);
			}
			System.out.print("삭제할 글 번호: ");
			Long postId = scan.nextLong();
			boolean postDelete = dr.postDelete(postId, memberId);
			if(postDelete) {
				System.out.println("게시글이 삭제되었습니다.");
			}
			else {
				System.out.println("회원은 해당 글 번호의 게시글이 없습니다.");
			}
		}
		else {
			System.out.println("아이디 또는 비밀번호가 틀립니다!!");
		}
	}
}

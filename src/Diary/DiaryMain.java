package Diary;

import java.util.Scanner;

public class DiaryMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int select = 0;
		int selectNumber = 0;
		DiaryService ds = new DiaryService();
		boolean run = true;
		while (run) {
			System.out.println("-------------<다이어리 프로그램>------------");
			System.out.println("1. 회원 | 2. 다이어리 | 3.종료");
			System.out.println("---------------------------------------");
			System.out.print("선택>");
			select = scan.nextInt();
			if (select == 1) {
				System.out.println("---------------------------------------------------------------------------------------------");
				System.out.println("1.회원가입 | 2. 로그인 | 3. 회원 목록 | 4. 회원 상세 조회 | 5.회원 정보 수정 | 6. 회원 탈퇴 ");
				System.out.println("---------------------------------------------------------------------------------------------");
				System.out.print("선택>");
				selectNumber = scan.nextInt();
				if (selectNumber == 1) {
					ds.memberSave();
				} else if (selectNumber == 2) {
					ds.memberLogin();
				} else if (selectNumber == 3) {
					ds.memberFindAll();
				} else if (selectNumber == 4) {
					ds.findByMemberId();
				} else if (selectNumber == 5) {
					ds.memberUpdate();
				} else if (selectNumber == 6) {
					ds.memberDelete();
				} 
			} else if (select == 2) {
				System.out.println("-------------------------------------------------------------------------------------------------");
				System.out.println("1. 다이어리 작성 | 2. 다이어리 전체 목록 | 3. 다이어리 상세 조회 | 4. 다이어리 제목 / 내용 수정 | 5. 다이어리 삭제 ");
				System.out.println("-------------------------------------------------------------------------------------------------");
				System.out.print("선택> ");
				selectNumber = scan.nextInt();
				if (selectNumber == 1) {
					ds.diarySave();
				} else if (selectNumber == 2) {
					ds.diaryFindAll();
				} else if (selectNumber == 3) {
					ds.diaryFindByCondition();
				} else if (selectNumber == 4) {
					ds.diaryUpdate();
				} else if (selectNumber == 5) {
					ds.diaryDelete();
				} 
			} else if(select == 3) {
				run = false;
			}
		}

	}
}

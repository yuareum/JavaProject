# 프로젝트 기획안
            - 작성일 : 2022.05. 08
            - 작성자 : 유아름
            
1. 프로젝트 명 : 다이어리 작성 프로그램

2. 기획 의도 
- 다이어리 프로그램으로 가입한 회원들이 자유롭게 하루 일과, 감정 등을 기록할 수 있다. 이 프로그램을 생각하게 된 이유는 평소 다이어리를 꾸준히 사용해왔는데 이번 프로젝트를 통해 한 번 프로그램으로 만들어 보고 싶어서 이 프로그램을 만들기로 결정하였다. 
- 이 프로그램은 가입한 회원들이 다이어리를 작성할 수 있고, 회원들이 공개한 다이어리를 볼 수 있으며 게시판에 회원들만이 질문 및 건의사항 등 의견을 작성할 수 있다. 

3. 벤치마킹 
-‘통플 다이어리’와 '울트라 다이어리' 라는 다이어리를 작성하는 사이트에서 회원 가입과 회원이 작성한 다이어리 구조, 게시판을 참고로하여 다이어리 프로그램을 만들었다.

4. 주요 기능 
- 다이어리 프로그램은 회원, 다이어리, 게시판 3가지 서비스가 있고 선택 시 해당 서비스가 실행되도록 하였다. 
- 먼저, 회원 서비스에는 회원 가입, 로그인, 회원 전체 목록, 회원 상세 목록, 회원 정보 수정, 회원 탈퇴 서비스로 구성하였다.
- 회원 가입 기능은 아이디, 비밀번호, 이름, 전화번호, 이메일 정보를 입력받는다. 이 때 각 회원 번호는 자동으로 1씩 증가하도록 하였으며 아이디는 중복되는 아이디가 없으면 회원 정보를 저장하고 회원 가입이 되도록 하였다.
- 로그인은 아이디, 비밀번호를 입력받도록 하였고 입력한 정보가 회원가입 시 입력한 정보와 일치해야 로그인을 실행하였다. 
- 회원 전체 목록은 바로 회원 전체 목록이 조회가 되고, 회원 상세 목록은 회원 아이디를 입력받았고 입력받은 아이디의 회원 정보가 조회 되도록 하였다. 
- 회원 정보 수정은 아이디와 비밀번호를 입력해 로그인을 실행한 다음 수정 서비스가 실행되는데 수정 서비스는 비밀번호, 전화번호, 이메일 수정으로 나누었으며 회원이 3개 중 하나를 선택하고 변경할 내용을 입력하면 해당 내용으로 정보가 수정되도록 한다. 
- 회원 탈퇴는 아이디와 비밀번호를 입력해 로그인을 실행하면 바로 탈퇴 기능을 수행하여 해당 아이디의 회원 정보를 삭제하도록 하였다. 

- 다음으로, 다이어리 서비스에는 다이어리 작성, 공개 다이어리 전체 목록, 공개 다이어리 조회, 작성한 다이어리 조회, 다이어리 변경, 다이어리 삭제 서비스로 구성하였다.
- 다이어리 작성은 먼저 로그인을 한 후 다이어리가 실행되고 회원이 다이어리 제목 및 내용을 작성한 후 공개 비공개 여부를 선택하고 작성한 내용을 해당 회원의 다이어리에 저장되도록 하였다. 이 때 다이어리 번호는 작성 시 1씩 증가하여 저장되었고, 자동으로 작성 날짜 및 작성 시간이 설정되고 조회수는 0으로 저장된다.  
- 공개 다이어리 전체 목록은 공개로 설정한 전체 다이어리 목록이 조회가 되도록 하였다. 공개 다이어리 조회 역시 공개한 다이어리 목록만 조회 가능한데 이 때 조회는 아이디, 제목, 글 번호로 나누었다. 이 중 하나를 선택하고 입력 란에 관련 내용을 입력받으면 해당 다이어리가 조회되도록 하였다. 이 때 조회 결과가 하나인 경우 조회 수가 하나 증가하도록 하였고, 여러 개인 경우 조회 수는 그대로 유지되도록 하였다. 
- 다이어리 변경은 로그인을 한 후 로그인 한 회원의 다이어리만 변경 가능하도록 하였는데 이 때 회원이 작성한 전체 목록에서 변경할 다이어리 번호를 입력받고 다이어리에 변경할 제목 및 내용을 작성하도록 하고 작성한 내용을 변경하여 저장하였다. 
- 다이어리 삭제는 로그인을 한 후 로그인한 회원이 작성한 다이어리 목록에서 삭제할 다이어리 번호를 입력받아 해당 다이어리를 삭제하도록 하였다.

- 마지막으로, 게시판 서비스는 게시판 작성, 게시판 전체 목록, 게시판 조회, 게시판 수정, 게시판 삭제로 구성하였다.
- 게시판 작성은 로그인을 수행한 후 게시글을 작성란이 실행되고 해당 란에 제목 및 내용을 입력한 후 게시판에 저장되도록 하였다. 이 때 게시판 글 번호가 1씩 증가되고, 작성일 및 작성 시간은 자동으로 설정되어 게시글에 저장된다.
- 게시판 전체 목록은 회원이 작성한 게시판 글 전체 목록이 조회되도록 하였다. 게시판 조회는 아이디, 제목, 글 번호로 나누었으며 이 중 하나를 선택하고 관련 내용을 입력받으면 해당 다이어리가 조회되도록 하였다. 이 때 조회 결과가 하나인 경우 조회 수가 하나 증가하도록 하였고, 결과가 여러 개인 경우는 조회수가 그대로 유지되도록 하였다. 
- 게시판 변경은 로그인을 한 후에 로그인 한 회원의 작성한 게시글 목록에서 변경할 게시글 번호를 입력받은 후 입력 란에 변경할 게시글 제목 및 내용을 작성한 후 내용을 변경하여 저장하였다.     
- 게시판 삭제는 로그인을 한 후 로그인 한 회원이 작성한 게시글 목록에서 삭제할 게시글 번호를 입력 받으면 해당 게시글이 삭제되도록 하였다.

5. 기타

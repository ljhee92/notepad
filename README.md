# 메모장 프로그램
sist 과제 중 메모장 프로그램을 재구현한 코드입니다.

java swing을 활용하여 프로그램을 구현했습니다.

## 💻 프로그램 소개
윈도우 메모장 프로그램을 클론코딩한 프로그램입니다.

## ⏰ 개발 기간
- 2024.02.20(화) ~ 진행 중

## 💾 프로그램 구성 및 흐름
1. 실행

2. 메모장 design
	- 메뉴바: 파일, 편집, 서식, 도움말
	- 메뉴아이템: 새글, 열기, 저장, 종료 / 줄바꿈 / 글꼴 / 메모장 정보
	- TextArea
	- Listener

3. 메모장 event
	- 새글 클릭 시
	- 열기 클릭 시
	- 저장 클릭 시
	- 종료 클릭 시 : 메모장 종료
	- 줄바꿈 클릭 시 : 줄바꿈 설정 및 해제 적용
	- 글꼴 클릭 시 : 글꼴 Dialog 오픈
	- 메모장 정보 클릭 시 : 메모장 정보 Dialog 오픈
	
4. 글꼴
	- 글꼴명, 글꼴 스타일 enum
	- 글꼴 스타일 String -> Integer 전환 Class
	- 글꼴 스타일 Integer -> String 전환 Class
	
5. 글꼴 design
	- TextField
	- 글꼴명, 글꼴스타일, 글꼴사이즈 리스트
	- 글꼴 적용 보기
	- Listener
	
6. 글꼴 event
	- 리스트 클릭 시 TextField와 보기에 함께 적용
	- 확인 버튼 클릭 시 메모장에 적용

7. 메모장 정보 design (+event 포함)
	- TextArea(수정 불가)
	- 닫기 버튼(클릭 시 dialog 종료 event)

## 💻 개발 환경
- **Version** : Java 17
- **IDE** : eclipse

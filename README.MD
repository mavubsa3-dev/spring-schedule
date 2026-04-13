# 일정 관리 API

## - 기능
### 1. 일정 생성
   #### @Requestbody를 통해 AddScheduleRequest 객체 파라미터로 전송
   #### Service에서 일정 정보를 담은 AddScheduleResponse 객체 반환
### 2. 일정 조회(API 응답에 비밀번호 제외)
#### - 전체 일정 조회
##### @RequestParam 통해 작성자명 조건부로 받음
##### List<CheckAllScheduleResponse> 리스트 선언 후 정보 대입해서 반환

#### - 선택 일정 조회
##### @PathVariable 통해 url의 scheduleId로 오름차순 정렬
      
### 3. 일정 수정
#### 선택한 일정 내용 중 일정 제목, 작성자명 수정 가능
#### 서버에 요청 시 비밀번호 함께 전송
4. 일정 삭제
5. 댓글 생성
6. 일정 단건 조회 기능 업그레이드
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
#### @PathVariable을 통해 scheduleId, @RequestBody를 통해 UpdateScheduleRequest dto 객체 전송 
#### 작성자명, 일정 변경 후 UpdateScheduleResponse 객체 반환

### 4. 일정 삭제
#### @RequestBody 통해 password를 받아서 인증 후 @PathVariable을 통해 scheduleId로 일정 삭제

### 5.댓글 생성
#### AddScheduleCommentRequest dto 클래스를 통해 댓글 데이터 전송 후 댓글 내용, 작성자명, 작성/수정일 정보 담아 AddScheduleCommentResponse객체 반환

### 6. 일정 단건 조회 기능 업그레이드
#### AddScheduleCommentResponse 타입으로 리스트 선언 후, 댓글 정보를 담아 CheckOneScheduleResponse에 같이 반환.
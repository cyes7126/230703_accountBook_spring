# 230703_accountBook_spring
java, spring-boot, mysql 사용한 월별 예산입니다. 
<hr><br>

## version
java : 11<br>
spring-boot : 2.7.13<br>
mysql : 8.0.33
<br><br>

## 호출 api
### (컨트롤러 위치 : controller/TransactionController.java)
|HTTP Method|매핑url|함수명|내용|
|---|---|---|---|
|GET|month-plan|get_month_plan|전체 리스트 조회|
|GET|month-plan-item/{sno}|get_month_plan_item|한건 데이터 조회|
|POST|month-plan-item|add_month_plan_item|데이터 추가|
|PUT|month-plan-item/{sno}|update_month_plan_item|데이터 수정|
|DELETE|month-plan-item/{sno}|delete_month_plan_item|데이터 삭제|
<br>

## 실행화면
1. 리스트화면
<img width="1385" alt="스크린샷 2023-07-06 오후 5 20 19" src="https://github.com/cyes7126/190128_OpenProject_Spring/assets/46583544/50faec99-c2fe-4650-a083-19e406ad5a15">

2. 예산 추가/수정 모달 화면
<img width="1028" alt="스크린샷 2023-07-06 오후 5 20 50" src="https://github.com/cyes7126/190128_OpenProject_Spring/assets/46583544/13cad033-10a7-4453-b311-9d269d63aa5d">




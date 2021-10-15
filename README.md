#크롤링 샘플 예제
### 개발환경
    스프링부트 V2.5.5
    JAVA 11
    ChromeDriver 94.0.4606.61
    selenium-chrome-driver 3.141.59

### 메인페이지 
    localhost:8099
---
### 참고
1 다운받은 크롬드라이버 버전과 pc에 설치된 크롬 버전과 맞지 않는경우 실행에 문제가 발생할 수 있다.   
2 테스트 크롤링 대상 URL : https://mbdrive.gettyimageskorea.com/ 
3 WebDriverUtil 에서 WebDriver 생성을 서비스와 분리하여 Bean 으로 등록하였다.   
4 크롬드라이버 위치를 lib 폴더 하위로 지정되어있다.
5 logback.xml, mapper , mybatis, DBMS 관련 dependency 등이 있으나 연결은 안되어있다.

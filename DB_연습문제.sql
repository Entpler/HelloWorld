[문제 1] --OK
--EMPLOYEE 테이블에서 12월 생일자에게 축하 메세지 보내기
--결과: OOO님 12월 OO일 생일을 축하합니다! 
================================================================
SELECT EMP_NAME ||'님 12월'||SUBSTR(EMP_NO,5,2)||'일 생일을 축하합니다!' "생일축하메시지"
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO,3,2) ='12';

[문제 2] --OK
--EMP 테이블의 부서코드와 DEPT 테이블을 조인하여 각 부서별 근무지 위치를 조회
--사원명, 부서코드, 부서명, 근무지 위치 출력
--1.오라클 구문
SELECT EMP_NAME"부서명", DEPT_CODE "부서코드",DEPT_TITLE"부서명",LOCATION_ID"근무지위치"
FROM EMPLOYEE, DEPARTMENT
WHERE (DEPT_CODE = DEPT_ID)
ORDER BY DEPT_TITLE;

================================================================
[문제 3]--OK
--EMPLOYEE 테이블에서 월급 200만원 이상 300만원 이하인 사원의 
--사번, 사원명, 입사일, 부서코드, 연봉 조회 (단, 연봉은 BONUS 적용 및 \999,999,999로 조회)
SELECT EMP_ID"사번", EMP_NAME"사원명", HIRE_DATE"입사일", DEPT_CODE"부서코드",TO_CHAR(TO_NUMBER((SALARY+(SALARY*BONUS))*12),'999,999,999')"연봉"
FROM EMPLOYEE
WHERE (SALARY>=2000000) AND (SALARY <=3000000);
====================================================
[문제 4]
--EMPLOYEE 테이블을 통해 PHONE 번호가 011으로 시작하는 사원의
--이름, 사번, PHONE, 부서코드를 조회--OK
SELECT EMP_NAME, EMP_ID, PHONE, DEPT_CODE
FROM EMPLOYEE
WHERE SUBSTR(PHONE, 1, 3) = '011' ;
================================================================
[문제 5]
--80년대생인 남자 직원들 중 성이 '김'씨인 사람의 주민번호, 직원명 조회
--단, 주민번호는 [888888-2******] 형태로 조회 및 직원명으로 오름차순 정렬--OK
SELECT EMP_NAME"직원명",RPAD(SUBSTR(EMP_NO,1,8),14,'*')"주민번호"
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO,8,1) IN ('1','3') 
ORDER BY EMP_NAME ASC;

================================================================
[문제 6]
--EMPLOYEE 테이블에서 직급코드를 중복 없이, "직급 종류" 라는 별칭을 부여하고
--"직급 종류" 오름차순으로 정렬해서 조회--OK
SELECT DISTINCT JOB_CODE"직급종류"
FROM EMPLOYEE 
ORDER BY JOB_CODE ASC;
========================================================================
[문제 7]--
--EMPLOYEE 테이블에서 부서 인원이 3명 이상인 부서의 
--부서 코드, 평균, 최고 급여, 최저 급여, 인원 수 조회 
--(단, 부서코드로 오름차순 조회 및 \999,999,999로 조회)
SELECT DEPT_CODE"부서코드",TO_CHAR(TO_NUMBER(AVG(SALARY)),'999,999,999')"평균", TO_CHAR(TO_NUMBER(MAX(SALARY)),'999,999,999')"최고급여",TO_CHAR(TO_NUMBER(MIN(SALARY)),'999,999,999')"최소급여",COUNT(EMP_NAME)"인원수"
FROM EMPLOYEE
--WHERE COUNT(EMP_NAME)>='3'
GROUP BY DEPT_CODE
HAVING COUNT(EMP_NAME)>=3
ORDER BY DEPT_CODE ASC;
================================================================
[문제 8]
--EMPLOYEE 테이블에서 
--직원 중 '이'씨 성을 가지면서, 
--급여가 200만원 이상 250만원 이하인 
--직원의 이름과 급여를 조회하시오
SELECT EMP_NAME"이름", SALARY"급여"
FROM EMPLOYEE
WHERE EMP_NAME LIKE '이%' AND SALARY >=2000000 AND SALARY <=3000000;

================================================================
[문제 9]--EMPLOYEE 테이블에서 부서별 그룹을 편성하여
--부서별 급여 합계, 제일 낮게 받는 부서와, 제일 높게 받는부서, 인원수를 조회
--단, 조회결과는 인원수 오름차순하여 출력하여라.
SELECT DEPT_CODE"부서코드",COUNT(*)"사원수",SUM(SALARY)"급여합계"
from employee
GRouP BY DEPT_CODE 
HAVING SUM(SALARY) = (SELECT MAX(SUM(SALARY)) from employee group by dept_code)
union
SELECT DEPT_CODE"부서코드",COUNT(*)"사원수",SUM(SALARY)"급여합계"
from employee
GRouP BY DEPT_CODE 
HAVING SUM(SALARY) = (SELECT min(SUM(SALARY)) from employee group by dept_code)
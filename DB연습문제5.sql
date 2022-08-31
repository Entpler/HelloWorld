================================================================
[문제 34]
--급여 평균이 3위안에 드는 직급을 찾아 직급코드, 직급명, 급여평군을 조회한 후
--ROWNUM과 인라인뷰를 반영하여 조회하시오
SELECT JOB_CODE"직급코드", JOB_NAME"직급명"
FROM EMPLOYEE E, DEPARTMET D
WHERE (E.DEPT_CODE=D.DEPT_ID) AND SALARY = (SELECT AVG(SALARY) FROM 
(DEPT_ID=DEPT_CODE) AND (E.JOB_CODE=J.JOB_CODE)

================================================================
[문제 35]
--EMPLOYEE 테이블에서
    --급여가 1,380,000원인 직원과 같은 직급코드, 같은 급여등급(SAL_LEVEL)에 해당하는 
    --사원의 사원명, 직급코드, 급여등급을 조회하시오
--단, 급여가 1,380,000원인 해당직원은 제외하여 조회하시오
--(다중열 서브쿼리 사용)
SELECT EMP_NAME"사원명", JOB_CODE"직급코드",SAL_LEVEL"급여등급"
FROM EMPLOYEE
WHERE (JOB_CODE,SAL_LEVEL) IN (SELECT JOB_CODE,SAL_LEVEL FROM EMPLOYEE WHERE SALARY = '1380000')
AND SALARY<>'1380000';


================================================================
[문제 36]
--4/4분기 실적에 따른 상여금을 지급하게 되어 기존 월급에 따라 상여금을 지급하려 한다.
--급여(SALARY)가 400만원 초과 시 급여의 30%, 200만원 이상 400만원 미만이면 급여의 50%, 
--100만원이상 200만원 미만이면 급여의 70%를 지급한다.
--단, CASE문 사용하고 급여 순으로 내림차순 정렬
SELECT EMP_ID"사번", SALARY"급여", CASE WHEN  SALARY>'4000000' THEN SALARY*0.3 
            WHEN  SALARY >='2000000' AND SALARY <4000000 THEN SALARY*0.5
            WHEN  SALARY>='1000000' AND SALARY< 2000000 THEN SALARY*0.7
            END "상여금"
FROM EMPLOYEE
ORDER BY SALARY DESC;
 
================================================================
[문제 37]
--EMPLOYEE 테이블에서 사번이 200, 201, 202인 사원들을 찾아
--200번인 사원의 주민번호 앞자리를 '621212'로
--201번인 사원의 주민번호 앞자리를 '631111'로
--202번인 사원의 주민번호 앞자리를 '861010'으로 변경하는 UPDATE 구문을 구현하시오.
SELECT EMP_ID"사번",EMP_NO"주민번호",
CASE WHEN EMP_ID ='200' THEN REPLACE(SUBSTR(EMP_NO,1,6),'621212')
     WHEN EMP_ID ='201' THEN REPLACE(SUBSTR(EMP_NO,1,6),'631111')
     WHEN EMP_ID ='202' THEN REPLACE(SUBSTR(EMp_NO,1,6),'861010')
     END "변경된주민번호"
FROM EMPLOYEE;

================================================================
[문제 38]
--EMPLOYE 테이블에서 ENT_YN이 Y면 '퇴사자', N이면 '근무자'로 표시하고
--관리자 사번이 있으면 '일반사원', 관리자 사번이 없으면 '관리자'로 표시하고
--직원의 사번, 사원명, 부서코드, 직급코드, 근무 현황, 관리자 여부를 조회하시오.
SELECT EMP_ID"사번",EMP_NAME"사원명",DEPT_CODE"부서코드",JOB_CODE"직급코드",
DECODE(ENT_YN,'Y','퇴사자','N','근무자')"근무현황", NVL2(MANAGER_ID,'일반사원','관리자')"관리자여부"
FROM EMPLOYEE;

================================================================
[문제39]
--EMPLOYEE 테이블에서 부서코드 D5의 직급코드가 J5도 아니고 J7도 아닌 사원의 
--사원명, 부서코드, 직급코드, SAL_LEVEL, 근무여부 조회
SELECT EMP_NAME"사원명", DEPT_CODE"부서코드", JOB_CODE"직급코드", SAL_LEVEL"급여수준",ENT_DATE"퇴사여부" 
FROM EMPLOYEE
WHERE (JOB_CODE != 'J5' AND JOB_CODE != 'J7') AND ENT_DATE IS NULL;

SELECT *
FROM EMPLOYEE;
================================================================
[문제40]
--EMPLOYEE테이블에서
--급여가 가장 높은 사원의
--사원번호,사원명,급여,부서번호를 구하시오
--급여 순으로 내림차순 하시오
SELECT EMP_ID"사원번호", EMP_NAME"사원명",SALARY"급여",DEPT_CODE"부서번호"
FROM EMPLOYEE 
WHERE SALARY=(SELECT MAX(SALARY) FROM EMPLOYEE)
ORDER BY SALARY DESC;

SELECT *
FROM LOCATION;

SELECT *
FROM NATIONAL;

SELECT *
FROM DEPARTMENT;

================================================================
================================================================
[문제26]
--'장쯔위'와 같은 연봉레벨, 같은 직급인 사원들의 
--사원번호, 이름, 부서코드, 직급코드, 연봉레벨(SAL_LEVEL) 조회 (다중열 처리)
SELECT EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE ,SAL_LEVEL
FROM EMPLOYEE
WHERE (SAL_LEVEL,JOB_CODE) = (SELECT SAL_LEVEL,JOB_CODE FROM EMPLOYEE WHERE EMP_NAME='장쯔위'); 

===========================================================
[문제27]
-- 사원들 중 월급이 5000000 이상이면 'HIGH', 3000000 이상이면 'MEDIUM', 2000000 이상이면 'LOW' 로 나머지는 'OTL'로 출력하고  
--사원명, 부서코드, 월급을 조회하시오.
--단, 월급이 많은 순으로 정렬하시오.
SELECT CASE WHEN SALARY>=5000000 THEN 'HIGH' WHEN SALARY>=3000000 THEN 'MEDIUN' WHEN SALARY>=2000000 THEN 'LOW' ELSE 'OTL' END "급여등급",DEPT_CODE"부서코드",SALARY"월급"
FROM EMPLOYEE
ORDER BY SALARY DESC;
===========================================================
[문제28]
--전형돈과 같은 직급, 같은 부서에 근무하는 
--직원들의 정보를 조회하시오 
SELECT * 
FROM EMPLOYEE 
WHERE (DEPT_CODE,JOB_CODE)= (SELECT DEPT_CODE,JOB_CODE FROM EMPLOYEE WHERE EMP_NAME = '전형돈');

--ARTMENT D, JOB J
--WHERE (E.DEPT_CODE =D.DEPT_ID) AND(E.JOB_CODE=J.JOB_CODE) AND
--(D.DEPT_ID,J.JOB_CODE) IN (SELECT D.DEPT_ID, J.JOB_CODE FROM EMPLOYEE WHERE E.EMP_NAME IN '전형돈');

SELECT*
FROM EMPLOYEE;



INTERSECT
SELECT *
FROM EMPLOYEE


SELECT *
FROM EMPLOYEE;


===========================================================
[문제 29]
--EMPLOYEE테이블에서
--각 부서 별 입사일이 가장 오래된 사원을 한 명씩 선별해
--사원번호, 사원명, 부서번호, 입사일을 조회하고 
--문제에 있는 명칭대로 컬럼명을 지정하시오
SELECT EMP_ID"사원번호",EMP_NAME"사원명",DEPT_CODE"부서번호",HIRE_DATE"입사일"
FROM EMPLOYEE
WHERE HIRE_DATE IN (SELECT MIN(HIRE_DATE) FROM EMPLOYEE GROUP BY DEPT_CODE);
===========================================================
[문제 30]
--EMPLOYEE테이블에서
--근무년수가 20년 이상 30년 미만인 사원의
--사원번호,사원명,입사일,연봉을 구하시오
--단,연봉은 보너스를 포함한 총합을 구한다. --보너스가 없는 경우에,,,? --NVL 공식 외우기
SELECT EMP_ID"사원번호",EMP_NAME"사원명",HIRE_DATE"입사일",(SALARY + (SALARY * NVL(BONUS,0)))*12 "연봉"
FROM EMPLOYEE
WHERE (SYSDATE-HIRE_DATE)>=365 *20 AND (SYSDATE-HIRE_DATE)<365*30;
--WHERE EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE) >= 20

SELECT * 
FROM LOCATION;

SELECT*
FROM EMPLOYEE;
SELECT*
FROM DEPARTMENT;


===========================================================
[문제 31]
--EMPLOYEE 테이블에서 근무국가(NATIONAL_CODE)가 'KO'인 사원들의
--이름(EMP_NAME), 연봉순위, 급여(SALARY), 근무국가(NATIONAL_CODE)를 조회하시오
--단, 연봉순위는 DENSE_RANK() 사용, ANSI(JOIN) 구문 사용, 내림차순 정렬(연봉순위)
SELECT EMP_NAME"이름",DENSE_RANK()OVER (ORDER BY SALARY DESC)"연봉순위",SALARY"급여",NATIONAL_CODE"근무국가"
FROM EMPLOYEE JOIN DEPARTMENT ON(DEPT_ID = DEPT_CODE) 
JOIN LOCATION ON (LOCAL_CODE = LOCATION_ID);

===========================================================
[문제32]
--EMPLOYEE 테이블에서 'J1' 직급의 최고 월급과 'J7' 직급의 최저 월급 조회
--단, 나머지 JOB_CODE는 '비밀' 처리
SELECT JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY = (SELECT MAX(SALARY) FROM EMPLOYEE WHERE JOB_CODE ='J1');

SELECT JOB_CODE,SALARY 
FROM EMPLOYEE
WHERE SALARY 


===========================================================
[문제 33]
--EMPLOYEE 테이블에서
--전 직원의 평균급여보다 급여가 적은 직원들의 사원명, 급여를 조회하고
--급여 내림차순으로 정렬하시오
--(단일행 서브쿼리 사용)
SELECT EMP_NAME"사원명",SALARY"급여"
FROM EMPLOYEE
WHERE (SALARY) < (SELECT AVG(SALARY) FROM EMPLOYEE)
ORDER BY SALARY DESC;
================================================================
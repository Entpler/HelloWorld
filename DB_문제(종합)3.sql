================================================================
[문제19]
--부서별로 근무하는 사원의 수가 3명 이하인 경우, 사원이 적은 부서별로 오름차순 정렬 조회

SELECT DEPT_TITLE"부서", COUNT(EMP_NAME)"사원수"
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE(+) = DEPT_ID
GROUP BY DEPT_TITLE
HAVING COUNT(EMP_NAME)<=3
ORDER BY COUNT(EMP_NAME) ASC;

================================================================
[문제20]
--EMPLOYEE 테이블에서
--직급 별로 급여평균을 조회하고 급여평균 내림차순으로 정렬하시오
--(급여평균은 TRUNC 함수 사용하여 만원단위 이하는 버림 하시오)
SELECT TRUNC(AVG(SALARY),-1)"급여평균",JOB_CODE"직급코드"
FROM EMPLOYEE
GROUP BY JOB_CODE
ORDER BY AVG(SALARY) DESC;

================================================================
[문제21]--서브쿼리 모름...
--해외영업2부(DEPT_CODE: D6)의 평균 급여보다 많이 받고, 해외영업2부에 속하지 않으며 
--관리자가 없는 사원의 사번(EMP_ID), 이름(EMP_NAME), 직급(JOB_NAME), 부서이름(DEPT_TITLE), 급여(SALARY)를 조회하시오.
--단,FROM 절에 서브쿼리 사용, JOIN은 오라클 구문 사용, 셀프 조인 사용
SELECT EMP_ID"사번", EMP_NAME "이름"-- JOB_NAME"직급", DEPT_TITLE"부서이름",SALARY"급여"
FROM EMPLOYEE E, JOB J ,DEPARTMENT D
WHERE E.SALARY (ANY SELECT AVG(SALARY) FROM EMPLOYEE  WHERE DEPT_CODE ='D6') AND
E.DEPT_CODE IN(SELECT DEPT_CODE FROM EMPLOYEE  WHERE DEPT_CODE !='D6')
--AND (E.JOB_CODE  = J.JOB_CODE) AND (E.DEPT_CODE = D.DEPT_ID);
--MANAGER_ID = (SELECT MANAGER_ID FROM EMPLOYEE E WHERE MANAGER_ID IS NULL);

================================================================
[문제22] 
--EMP에서 직급이름으로 그룹을 만들고 월급이 5000이상인 그룹 찾기
--JOB이름과, 급여 합계를 조회하시오
SELECT J.JOB_NAME"직급",SUM(SALARY)"월급"
FROM EMPLOYEE E ,JOB J
WHERE(E.JOB_CODE =J.JOB_CODE)
GROUP BY J.JOB_NAME
--HAVING SUM(SALARY)>=50000000;

================================================================
[문제23] --인라인뷰??
--EMPLOYEE 테이블에서
--입사일로부터 근무년수가 가장 긴 직원 상위 6명을
--RANK()함수를 이용하여 조회하시오
--사번, 사원명, 부서명, 직급명, 입사일을 조회하시오.

SELECT ROWNUM  "순위", EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE)"근무년도", EMP_ID"사번", EMP_NAME"사원명", DEPT_TITLE"부서명",J.JOB_NAME"직급명",HIRE_DATE"입사일"
FROM EMPLOYEE E,DEPARTMENT D,JOB J SELECT( * FROM EMPLOYEE E,DEPARTMENT D,JOB J ORDER BY "근무년도" DESC )
WHERE (DEPT_CODE = DEPT_ID) AND (J.JOB_CODE=E.JOB_CODE) AND ROWNUM<=6;

SELECT *  
FROM (SELECT EMP_ID "사번", EMP_NAME"사원명",HIRE_DATE"입사일", SALARY"급여" ,RANK() OVER(ORDER BY SALARY  DESC) "연봉순위" 
FROM EMPLOYEE)
WHERE  ROWNUM<=6;

DEPT_CODE = DEPT_ID) AND (J.JOB_CODE=E.JOB_CODE) 
==========================================================================================================================================
[문제24]
--EMPLOYEE 테이블에서 
--부서명 별로 급여가 가장 높은 직원들의
--부서명, 최대급여를 조회하시오
--단, 최대급여가 400만원 이하인 부서들만 조회하시오
--(부서명은 JOIN 활용)
SELECT D.DEPT_TITLE"부서명" ,MAX(E.SALARY)"최대급여"
FROM EMPLOYEE E,DEPARTMENT D
WHERE (D.DEPT_ID = E.DEPT_CODE)
GROUP BY DEPT_TITLE
HAVING MAX(E.SALARY) <= 4000000;

================================================================
[문제25]--서브쿼리문제
--EMPLOYEE 테이블에서 부서별 최고 급여를 확인 후, 사원 중 해당 부서와 최고 급여가 일치하는 사원의
--사번(EMP_ID), 이름(EMP_NAME), 부서이름(DEPT_TITLE), 직급(JOB_NAME), 부서코드(DEPT_CODE), 급여(SALARY)를 조회하시오.
--급여 내림차순으로 정렬, JOIN(ANSI 구문 사용), WHERE 절에서 서브쿼리로 부서별 최고 급여 확인.
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE E JOIN DEPARTMENT D ON (DEPT_CODE= DEPT_ID)
JOIN JOB J ON (E.JOB_CODE = J.JOB_CODE)
WHERE SALARY = (SELECT MAX(SALARY) FROM EMPLOYEE GROUP BY DEPT_TITLE)
ORDER BY SALARY DESC;

SELECT *
FROM EMPLOYEE;

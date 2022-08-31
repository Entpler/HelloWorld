[문제 10]
?자신의 매니저보다 급여(SALARY)를 많이 받는 직원들의
?이름(EMP_NAME),급여(SALARY),MANAGER_ID,매니저 이름(EMP_NAME)을
?급여의 내림차순으로 조회하시오.
SELECT EMP_NAME"이름",SALARY"급여",MANAGER_ID"매니저아이디"
FROM EMPLOYEE
WHERE SALARY = (SELECT SALARY FROM EMPLOYEE WHERE MANAGER_ID IS NOT NULL);

================================================================
[문제 11]--EMPLOYEE 테이블에서 부서별 그룹을 편성하여
--부서별 급여 합계, 제일 낮게 받는 부서와, 제일 높게 받는부서, 인원수를 조회
--단, 조회결과는 인원수 오름차순하여 출력하여라.
SELECT DEPT_CODE"부서코드",COUNT(*)"사원수",SUM(SALARY)"급여합계"
from employee
GRouP BY DEPT_CODE 
HAVING SUM(SALARY) = (SELECT MAX(SUM(SALARY)) from employee group by dept_code)
UNION
SELECT DEPT_CODE"부서코드",COUNT(*)"사원수",SUM(SALARY)"급여합계"
from employee
GRouP BY DEPT_CODE 
HAVING SUM(SALARY) = (SELECT min(SUM(SALARY)) from employee group by dept_code)


================================================================
[문제12]
--EMPLOYEE 테이블에서 직급별
--그룹을 편성하여 직급코드, 급여평균, 급여합계, 인원 수를 조회
--단, 조회 결과는 급여평균 오름차순하여 출력, 인원수는 3명을 초과하는 직급만 조회
SELECT JOB_CODE "직급코드", ROUND(AVG(SALARY))"급여평균", SUM(SALARY)"급여합계",COUNT(EMP_NAME)"인원수"
FROM EMPLOYEE
GROUP BY JOB_CODE
HAVING COUNT(EMP_NAME)>3
ORDER BY AVG(SALARY) ASC;
================================================================
SELECT *
FROM DEPARTMENT;
SELECT *
FROM JOB;

[문제13]
--2001년에 입사한 여자 직원이 있다.
--해당 직원과 같은 부서, 같은 직급에 해당하는 사원들을 조회하시오.
--사번, 사원명, 직급, 부서, 입사일
SELECT E.EMP_ID"사번",E.EMP_NAME"사원명",J.JOB_NAME"직급",D.DEPT_TITLE"부서",E.HIRE_DATE"입사일"
FROM EMPLOYEE E, JOB J, DEPARTMENT D
WHERE SUBSTR(E.EMP_NO,8,1) IN ('2','4') AND --AND EXTRACT(YEAR FROM E.HIRE_DATE)='2001' 
(E.JOB_CODE = J.JOB_CODE) AND (E.DEPT_CODE = D.DEPT_ID);

================================================================
[문제14]
--EMPLOYEE 테이블에서 '하이유'와 같은 부서에서 일하는 사원들의 
--사원번호, 사원명, 부서코드, 직급코드, 급여 조회
--직급코드 내림차순 조회 _아 어려웠다..

SELECT EMP_ID"사원번호", EMP_NAME"사원명",DEPT_CODE"직급코드",SALARY"급여",DEPT_TITLE "부서명"
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE=DEPT_ID
AND JOB_CODE = (SELECT JOB_CODE FROM EMPLOYEE WHERE EMP_NAME='하이유')
ORDER BY DEPT_CODE DESC;


================================================================
[문제15]
--EMPLOYEE 테이블에서 입사일이 2000년 1월 1일 이전인 사원에 대해 사원의 이름,  입사일,  부서코드, 급여를 입사일순으로 조회하시오
--(문제에 있는 이름대로 컬럼명을 따로 붙여주세요)
SELECT EMP_NAME"이름", HIRE_DATE"입사일",DEPT_CODE"부서코드",SALARY"급여"
FROM EMPLOYEE
WHERE EXTRACT(YEAR FROM HIRE_DATE)<=2000
ORDER BY HIRE_DATE;
================================================================
[문제16]
--EMPLOYEE 테이블에서 해외영업 부서(DEPT_TITLE) 소속인 사원들의
--이름(EMP_NAME), 직급(JOB_TITLE), 부서명(DEPT_TITLE), 근무국가(NATIONAL_CODE)를 조회하시오
--단, 오라클 조인 구문으로 작성하고 별칭을 반드시 입력
SELECT E.EMP_NAME"이름", J.JOB_NAME"직급", D.DEPT_TITLE"부서명",L.NATIONAL_CODE"근무국가"
FROM EMPLOYEE E, JOB J, DEPARTMENT D, LOCATION L
WHERE D.DEPT_TITLE LIKE '해외영업%'
AND (E.JOB_CODE=J.JOB_CODE) AND (D.DEPT_ID=E.DEPT_CODE) 
AND (D.LOCATION_ID = L.LOCAL_CODE);

================================================================
[문제17]
--EMPLOYEE 테이블에서
--'이태림'사원의 근속 년수를 조회하시오 (현재는 퇴사상태)--하...
SELECT EMP_NAME"사원명",(ENT_DATE-HIRE_DATE)"근속일자"
FROM EMPLOYEE
WHERE EMP_NAME = '이태림';

================================================================
[문제18]
--자신이 속한 직급의 평균 급여보다 많이 받는 사원의
--사원번호,직급명, 사원명,부서명, 급여정보 조회
SELECT E.EMP_ID "사원번호",E.SALARY"급여정보" --J.JOB_NAME"직급명",E. EMP_NAME"사원명,D.DEPT_TITLE"부서명,
FROM EMPLOYEE E
WHERE E.SALARY>=(SELECT AVG(SALARY) FROM EMPLOYEE)
--AND(E.JOB_CODE = J.JOB_CODE) AND (E.DEPT_CDOE = D.DEPT_ID)
ORDER BY 2;

--GROUP BY JOB_NAME;
--HAVING AVG(SALARY) <SALARY;
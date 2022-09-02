/*
    <VIEW 뷰>
    SELECT (쿼리문) 을 저장해 둘 수 있는 객체
    (자주 쓰는 긴 SELECT 문을 매번 다시 기술할 필요가 없음)
    임시테이블 같은 존재 (실제 데이터가 담겨있는 것은 아니다.)
*/


--실습문제 -----
---'한국' 에서 근무하는 사원들의 사번, 이름, 부서명, 급여 ,근무국가명 ,직급명을 조회하고 VIEW 를 생성하시오.

--1) JOIN 을 이용해서 컬럼조회

SELECT  E.EMP_ID, E.EMP_NAME, D.DEPT_TITLE, E.SALARY,J.JOB_CODE, NATIONAL_NAME
FROM EMPLOYEE E , DEPARTMENT D , JOB J , LOCATION L, NATIONAL N
WHERE (D.DEPT_ID = E.DEPT_CODE) AND( J.JOB_CODE = E.JOB_CODE) AND (D.LOCATION_ID=L.LOCAL_CODE) AND (L.NATIONAL_CODE=N.NATIONAL_CODE)
AND N.NATIONAL_NAME = '한국';

--2)    --전체 사원들의 사번, 이름, 부서명, 급여, 근무국가명, 직급명을 담은 뷰 생성

CREATE VIEW VW1_EMPLOYEE 
AS   
(SELECT  E.EMP_ID, E.EMP_NAME, D.DEPT_TITLE, E.SALARY,J.JOB_CODE, NATIONAL_NAME
FROM EMPLOYEE E , DEPARTMENT D , JOB J , LOCATION L, NATIONAL N
WHERE (D.DEPT_ID = E.DEPT_CODE) 
AND( J.JOB_CODE = E.JOB_CODE)
AND (D.LOCATION_ID=L.LOCAL_CODE) AND (L.NATIONAL_CODE=N.NATIONAL_CODE)
AND N.NATIONAL_NAME = '한국');

------VIEW 조회해보기-----
  
  SELECT *
     FROM VW1_EMPLOYEE
     WHERE NATIONAL_NAME = '한국';


    --3) --뷰에 보너스 컬럼이 없는 상태에서 보너스도 같이 조회하고 싶다면
    --뷰를 다시 생성하기==>CREATE  OR REPLACE VIEW 뷰명
        
    --CREATE OR REPLACE VIEW 뷰명
  --  AS (서브쿼리);
   -- =>OR REPLACE 는 생략 가능하다.
    
    CREATE OR REPLACE VIEW VW1_EMPLOYEE AS(
                                                                    SELECT  E.EMP_ID, 
                                                                    E.EMP_NAME, D.DEPT_TITLE, 
                                                                    E.SALARY,J.JOB_CODE, 
                                                                    BONUS,
                                                                    NATIONAL_NAME
                                                                    FROM EMPLOYEE E , 
                                                                    DEPARTMENT D , 
                                                                    JOB J , 
                                                                    LOCATION L, 
                                                                    NATIONAL N
                                                                    WHERE (D.DEPT_ID = E.DEPT_CODE) 
                                                                    AND( J.JOB_CODE = E.JOB_CODE)
                                                                    AND (D.LOCATION_ID=L.LOCAL_CODE)
                                                                    AND (L.NATIONAL_CODE=N.NATIONAL_CODE));
    
    
    SELECT EMP_ID, EMP_NAME, BONUS, DEPT_TITLE, NATIONAL_NAME
    FROM VW1_EMPLOYEE
    WHERE NATIONAL_NAME = '러시아';
    

    





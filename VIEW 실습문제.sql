/*
    <VIEW ��>
    SELECT (������) �� ������ �� �� �ִ� ��ü
    (���� ���� �� SELECT ���� �Ź� �ٽ� ����� �ʿ䰡 ����)
    �ӽ����̺� ���� ���� (���� �����Ͱ� ����ִ� ���� �ƴϴ�.)
*/


--�ǽ����� -----
---'�ѱ�' ���� �ٹ��ϴ� ������� ���, �̸�, �μ���, �޿� ,�ٹ������� ,���޸��� ��ȸ�ϰ� VIEW �� �����Ͻÿ�.

--1) JOIN �� �̿��ؼ� �÷���ȸ

SELECT  E.EMP_ID, E.EMP_NAME, D.DEPT_TITLE, E.SALARY,J.JOB_CODE, NATIONAL_NAME
FROM EMPLOYEE E , DEPARTMENT D , JOB J , LOCATION L, NATIONAL N
WHERE (D.DEPT_ID = E.DEPT_CODE) AND( J.JOB_CODE = E.JOB_CODE) AND (D.LOCATION_ID=L.LOCAL_CODE) AND (L.NATIONAL_CODE=N.NATIONAL_CODE)
AND N.NATIONAL_NAME = '�ѱ�';

--2)    --��ü ������� ���, �̸�, �μ���, �޿�, �ٹ�������, ���޸��� ���� �� ����

CREATE VIEW VW1_EMPLOYEE 
AS   
(SELECT  E.EMP_ID, E.EMP_NAME, D.DEPT_TITLE, E.SALARY,J.JOB_CODE, NATIONAL_NAME
FROM EMPLOYEE E , DEPARTMENT D , JOB J , LOCATION L, NATIONAL N
WHERE (D.DEPT_ID = E.DEPT_CODE) 
AND( J.JOB_CODE = E.JOB_CODE)
AND (D.LOCATION_ID=L.LOCAL_CODE) AND (L.NATIONAL_CODE=N.NATIONAL_CODE)
AND N.NATIONAL_NAME = '�ѱ�');

------VIEW ��ȸ�غ���-----
  
  SELECT *
     FROM VW1_EMPLOYEE
     WHERE NATIONAL_NAME = '�ѱ�';


    --3) --�信 ���ʽ� �÷��� ���� ���¿��� ���ʽ��� ���� ��ȸ�ϰ� �ʹٸ�
    --�並 �ٽ� �����ϱ�==>CREATE  OR REPLACE VIEW ���
        
    --CREATE OR REPLACE VIEW ���
  --  AS (��������);
   -- =>OR REPLACE �� ���� �����ϴ�.
    
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
    WHERE NATIONAL_NAME = '���þ�';
    

    





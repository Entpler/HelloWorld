================================================================
[����26]
--'������'�� ���� ��������, ���� ������ ������� 
--�����ȣ, �̸�, �μ��ڵ�, �����ڵ�, ��������(SAL_LEVEL) ��ȸ (���߿� ó��)
SELECT EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE ,SAL_LEVEL
FROM EMPLOYEE
WHERE (SAL_LEVEL,JOB_CODE) = (SELECT SAL_LEVEL,JOB_CODE FROM EMPLOYEE WHERE EMP_NAME='������'); 

===========================================================
[����27]
-- ����� �� ������ 5000000 �̻��̸� 'HIGH', 3000000 �̻��̸� 'MEDIUM', 2000000 �̻��̸� 'LOW' �� �������� 'OTL'�� ����ϰ�  
--�����, �μ��ڵ�, ������ ��ȸ�Ͻÿ�.
--��, ������ ���� ������ �����Ͻÿ�.
SELECT CASE WHEN SALARY>=5000000 THEN 'HIGH' WHEN SALARY>=3000000 THEN 'MEDIUN' WHEN SALARY>=2000000 THEN 'LOW' ELSE 'OTL' END "�޿����",DEPT_CODE"�μ��ڵ�",SALARY"����"
FROM EMPLOYEE
ORDER BY SALARY DESC;
===========================================================
[����28]
--�������� ���� ����, ���� �μ��� �ٹ��ϴ� 
--�������� ������ ��ȸ�Ͻÿ� 
SELECT * 
FROM EMPLOYEE 
WHERE (DEPT_CODE,JOB_CODE)= (SELECT DEPT_CODE,JOB_CODE FROM EMPLOYEE WHERE EMP_NAME = '������');

--ARTMENT D, JOB J
--WHERE (E.DEPT_CODE =D.DEPT_ID) AND(E.JOB_CODE=J.JOB_CODE) AND
--(D.DEPT_ID,J.JOB_CODE) IN (SELECT D.DEPT_ID, J.JOB_CODE FROM EMPLOYEE WHERE E.EMP_NAME IN '������');

SELECT*
FROM EMPLOYEE;



INTERSECT
SELECT *
FROM EMPLOYEE


SELECT *
FROM EMPLOYEE;


===========================================================
[���� 29]
--EMPLOYEE���̺���
--�� �μ� �� �Ի����� ���� ������ ����� �� �� ������
--�����ȣ, �����, �μ���ȣ, �Ի����� ��ȸ�ϰ� 
--������ �ִ� ��Ī��� �÷����� �����Ͻÿ�
SELECT EMP_ID"�����ȣ",EMP_NAME"�����",DEPT_CODE"�μ���ȣ",HIRE_DATE"�Ի���"
FROM EMPLOYEE
WHERE HIRE_DATE IN (SELECT MIN(HIRE_DATE) FROM EMPLOYEE GROUP BY DEPT_CODE);
===========================================================
[���� 30]
--EMPLOYEE���̺���
--�ٹ������ 20�� �̻� 30�� �̸��� �����
--�����ȣ,�����,�Ի���,������ ���Ͻÿ�
--��,������ ���ʽ��� ������ ������ ���Ѵ�. --���ʽ��� ���� ��쿡,,,? --NVL ���� �ܿ��
SELECT EMP_ID"�����ȣ",EMP_NAME"�����",HIRE_DATE"�Ի���",(SALARY + (SALARY * NVL(BONUS,0)))*12 "����"
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
[���� 31]
--EMPLOYEE ���̺��� �ٹ�����(NATIONAL_CODE)�� 'KO'�� �������
--�̸�(EMP_NAME), ��������, �޿�(SALARY), �ٹ�����(NATIONAL_CODE)�� ��ȸ�Ͻÿ�
--��, ���������� DENSE_RANK() ���, ANSI(JOIN) ���� ���, �������� ����(��������)
SELECT EMP_NAME"�̸�",DENSE_RANK()OVER (ORDER BY SALARY DESC)"��������",SALARY"�޿�",NATIONAL_CODE"�ٹ�����"
FROM EMPLOYEE JOIN DEPARTMENT ON(DEPT_ID = DEPT_CODE) 
JOIN LOCATION ON (LOCAL_CODE = LOCATION_ID);

===========================================================
[����32]
--EMPLOYEE ���̺��� 'J1' ������ �ְ� ���ް� 'J7' ������ ���� ���� ��ȸ
--��, ������ JOB_CODE�� '���' ó��
SELECT JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY = (SELECT MAX(SALARY) FROM EMPLOYEE WHERE JOB_CODE ='J1');

SELECT JOB_CODE,SALARY 
FROM EMPLOYEE
WHERE SALARY 


===========================================================
[���� 33]
--EMPLOYEE ���̺���
--�� ������ ��ձ޿����� �޿��� ���� �������� �����, �޿��� ��ȸ�ϰ�
--�޿� ������������ �����Ͻÿ�
--(������ �������� ���)
SELECT EMP_NAME"�����",SALARY"�޿�"
FROM EMPLOYEE
WHERE (SALARY) < (SELECT AVG(SALARY) FROM EMPLOYEE)
ORDER BY SALARY DESC;
================================================================
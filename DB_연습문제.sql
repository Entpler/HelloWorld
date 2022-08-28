[���� 1] --OK
--EMPLOYEE ���̺��� 12�� �����ڿ��� ���� �޼��� ������
--���: OOO�� 12�� OO�� ������ �����մϴ�! 
================================================================
SELECT EMP_NAME ||'�� 12��'||SUBSTR(EMP_NO,5,2)||'�� ������ �����մϴ�!' "�������ϸ޽���"
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO,3,2) ='12';

[���� 2] --OK
--EMP ���̺��� �μ��ڵ�� DEPT ���̺��� �����Ͽ� �� �μ��� �ٹ��� ��ġ�� ��ȸ
--�����, �μ��ڵ�, �μ���, �ٹ��� ��ġ ���
--1.����Ŭ ����
SELECT EMP_NAME"�μ���", DEPT_CODE "�μ��ڵ�",DEPT_TITLE"�μ���",LOCATION_ID"�ٹ�����ġ"
FROM EMPLOYEE, DEPARTMENT
WHERE (DEPT_CODE = DEPT_ID)
ORDER BY DEPT_TITLE;

================================================================
[���� 3]--OK
--EMPLOYEE ���̺��� ���� 200���� �̻� 300���� ������ ����� 
--���, �����, �Ի���, �μ��ڵ�, ���� ��ȸ (��, ������ BONUS ���� �� \999,999,999�� ��ȸ)
SELECT EMP_ID"���", EMP_NAME"�����", HIRE_DATE"�Ի���", DEPT_CODE"�μ��ڵ�",TO_CHAR(TO_NUMBER((SALARY+(SALARY*BONUS))*12),'999,999,999')"����"
FROM EMPLOYEE
WHERE (SALARY>=2000000) AND (SALARY <=3000000);
====================================================
[���� 4]
--EMPLOYEE ���̺��� ���� PHONE ��ȣ�� 011���� �����ϴ� �����
--�̸�, ���, PHONE, �μ��ڵ带 ��ȸ--OK
SELECT EMP_NAME, EMP_ID, PHONE, DEPT_CODE
FROM EMPLOYEE
WHERE SUBSTR(PHONE, 1, 3) = '011' ;
================================================================
[���� 5]
--80������ ���� ������ �� ���� '��'���� ����� �ֹι�ȣ, ������ ��ȸ
--��, �ֹι�ȣ�� [888888-2******] ���·� ��ȸ �� ���������� �������� ����--OK
SELECT EMP_NAME"������",RPAD(SUBSTR(EMP_NO,1,8),14,'*')"�ֹι�ȣ"
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO,8,1) IN ('1','3') 
ORDER BY EMP_NAME ASC;

================================================================
[���� 6]
--EMPLOYEE ���̺��� �����ڵ带 �ߺ� ����, "���� ����" ��� ��Ī�� �ο��ϰ�
--"���� ����" ������������ �����ؼ� ��ȸ--OK
SELECT DISTINCT JOB_CODE"��������"
FROM EMPLOYEE 
ORDER BY JOB_CODE ASC;
========================================================================
[���� 7]--
--EMPLOYEE ���̺��� �μ� �ο��� 3�� �̻��� �μ��� 
--�μ� �ڵ�, ���, �ְ� �޿�, ���� �޿�, �ο� �� ��ȸ 
--(��, �μ��ڵ�� �������� ��ȸ �� \999,999,999�� ��ȸ)
SELECT DEPT_CODE"�μ��ڵ�",TO_CHAR(TO_NUMBER(AVG(SALARY)),'999,999,999')"���", TO_CHAR(TO_NUMBER(MAX(SALARY)),'999,999,999')"�ְ�޿�",TO_CHAR(TO_NUMBER(MIN(SALARY)),'999,999,999')"�ּұ޿�",COUNT(EMP_NAME)"�ο���"
FROM EMPLOYEE
--WHERE COUNT(EMP_NAME)>='3'
GROUP BY DEPT_CODE
HAVING COUNT(EMP_NAME)>=3
ORDER BY DEPT_CODE ASC;
================================================================
[���� 8]
--EMPLOYEE ���̺��� 
--���� �� '��'�� ���� �����鼭, 
--�޿��� 200���� �̻� 250���� ������ 
--������ �̸��� �޿��� ��ȸ�Ͻÿ�
SELECT EMP_NAME"�̸�", SALARY"�޿�"
FROM EMPLOYEE
WHERE EMP_NAME LIKE '��%' AND SALARY >=2000000 AND SALARY <=3000000;

================================================================
[���� 9]--EMPLOYEE ���̺��� �μ��� �׷��� ���Ͽ�
--�μ��� �޿� �հ�, ���� ���� �޴� �μ���, ���� ���� �޴ºμ�, �ο����� ��ȸ
--��, ��ȸ����� �ο��� ���������Ͽ� ����Ͽ���.
SELECT DEPT_CODE"�μ��ڵ�",COUNT(*)"�����",SUM(SALARY)"�޿��հ�"
from employee
GRouP BY DEPT_CODE 
HAVING SUM(SALARY) = (SELECT MAX(SUM(SALARY)) from employee group by dept_code)
union
SELECT DEPT_CODE"�μ��ڵ�",COUNT(*)"�����",SUM(SALARY)"�޿��հ�"
from employee
GRouP BY DEPT_CODE 
HAVING SUM(SALARY) = (SELECT min(SUM(SALARY)) from employee group by dept_code)
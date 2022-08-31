[���� 10]
?�ڽ��� �Ŵ������� �޿�(SALARY)�� ���� �޴� ��������
?�̸�(EMP_NAME),�޿�(SALARY),MANAGER_ID,�Ŵ��� �̸�(EMP_NAME)��
?�޿��� ������������ ��ȸ�Ͻÿ�.
SELECT EMP_NAME"�̸�",SALARY"�޿�",MANAGER_ID"�Ŵ������̵�"
FROM EMPLOYEE
WHERE SALARY = (SELECT SALARY FROM EMPLOYEE WHERE MANAGER_ID IS NOT NULL);

================================================================
[���� 11]--EMPLOYEE ���̺��� �μ��� �׷��� ���Ͽ�
--�μ��� �޿� �հ�, ���� ���� �޴� �μ���, ���� ���� �޴ºμ�, �ο����� ��ȸ
--��, ��ȸ����� �ο��� ���������Ͽ� ����Ͽ���.
SELECT DEPT_CODE"�μ��ڵ�",COUNT(*)"�����",SUM(SALARY)"�޿��հ�"
from employee
GRouP BY DEPT_CODE 
HAVING SUM(SALARY) = (SELECT MAX(SUM(SALARY)) from employee group by dept_code)
UNION
SELECT DEPT_CODE"�μ��ڵ�",COUNT(*)"�����",SUM(SALARY)"�޿��հ�"
from employee
GRouP BY DEPT_CODE 
HAVING SUM(SALARY) = (SELECT min(SUM(SALARY)) from employee group by dept_code)


================================================================
[����12]
--EMPLOYEE ���̺��� ���޺�
--�׷��� ���Ͽ� �����ڵ�, �޿����, �޿��հ�, �ο� ���� ��ȸ
--��, ��ȸ ����� �޿���� ���������Ͽ� ���, �ο����� 3���� �ʰ��ϴ� ���޸� ��ȸ
SELECT JOB_CODE "�����ڵ�", ROUND(AVG(SALARY))"�޿����", SUM(SALARY)"�޿��հ�",COUNT(EMP_NAME)"�ο���"
FROM EMPLOYEE
GROUP BY JOB_CODE
HAVING COUNT(EMP_NAME)>3
ORDER BY AVG(SALARY) ASC;
================================================================
SELECT *
FROM DEPARTMENT;
SELECT *
FROM JOB;

[����13]
--2001�⿡ �Ի��� ���� ������ �ִ�.
--�ش� ������ ���� �μ�, ���� ���޿� �ش��ϴ� ������� ��ȸ�Ͻÿ�.
--���, �����, ����, �μ�, �Ի���
SELECT E.EMP_ID"���",E.EMP_NAME"�����",J.JOB_NAME"����",D.DEPT_TITLE"�μ�",E.HIRE_DATE"�Ի���"
FROM EMPLOYEE E, JOB J, DEPARTMENT D
WHERE SUBSTR(E.EMP_NO,8,1) IN ('2','4') AND --AND EXTRACT(YEAR FROM E.HIRE_DATE)='2001' 
(E.JOB_CODE = J.JOB_CODE) AND (E.DEPT_CODE = D.DEPT_ID);

================================================================
[����14]
--EMPLOYEE ���̺��� '������'�� ���� �μ����� ���ϴ� ������� 
--�����ȣ, �����, �μ��ڵ�, �����ڵ�, �޿� ��ȸ
--�����ڵ� �������� ��ȸ _�� �������..

SELECT EMP_ID"�����ȣ", EMP_NAME"�����",DEPT_CODE"�����ڵ�",SALARY"�޿�",DEPT_TITLE "�μ���"
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE=DEPT_ID
AND JOB_CODE = (SELECT JOB_CODE FROM EMPLOYEE WHERE EMP_NAME='������')
ORDER BY DEPT_CODE DESC;


================================================================
[����15]
--EMPLOYEE ���̺��� �Ի����� 2000�� 1�� 1�� ������ ����� ���� ����� �̸�,  �Ի���,  �μ��ڵ�, �޿��� �Ի��ϼ����� ��ȸ�Ͻÿ�
--(������ �ִ� �̸���� �÷����� ���� �ٿ��ּ���)
SELECT EMP_NAME"�̸�", HIRE_DATE"�Ի���",DEPT_CODE"�μ��ڵ�",SALARY"�޿�"
FROM EMPLOYEE
WHERE EXTRACT(YEAR FROM HIRE_DATE)<=2000
ORDER BY HIRE_DATE;
================================================================
[����16]
--EMPLOYEE ���̺��� �ؿܿ��� �μ�(DEPT_TITLE) �Ҽ��� �������
--�̸�(EMP_NAME), ����(JOB_TITLE), �μ���(DEPT_TITLE), �ٹ�����(NATIONAL_CODE)�� ��ȸ�Ͻÿ�
--��, ����Ŭ ���� �������� �ۼ��ϰ� ��Ī�� �ݵ�� �Է�
SELECT E.EMP_NAME"�̸�", J.JOB_NAME"����", D.DEPT_TITLE"�μ���",L.NATIONAL_CODE"�ٹ�����"
FROM EMPLOYEE E, JOB J, DEPARTMENT D, LOCATION L
WHERE D.DEPT_TITLE LIKE '�ؿܿ���%'
AND (E.JOB_CODE=J.JOB_CODE) AND (D.DEPT_ID=E.DEPT_CODE) 
AND (D.LOCATION_ID = L.LOCAL_CODE);

================================================================
[����17]
--EMPLOYEE ���̺���
--'���¸�'����� �ټ� ����� ��ȸ�Ͻÿ� (����� ������)--��...
SELECT EMP_NAME"�����",(ENT_DATE-HIRE_DATE)"�ټ�����"
FROM EMPLOYEE
WHERE EMP_NAME = '���¸�';

================================================================
[����18]
--�ڽ��� ���� ������ ��� �޿����� ���� �޴� �����
--�����ȣ,���޸�, �����,�μ���, �޿����� ��ȸ
SELECT E.EMP_ID "�����ȣ",E.SALARY"�޿�����" --J.JOB_NAME"���޸�",E. EMP_NAME"�����,D.DEPT_TITLE"�μ���,
FROM EMPLOYEE E
WHERE E.SALARY>=(SELECT AVG(SALARY) FROM EMPLOYEE)
--AND(E.JOB_CODE = J.JOB_CODE) AND (E.DEPT_CDOE = D.DEPT_ID)
ORDER BY 2;

--GROUP BY JOB_NAME;
--HAVING AVG(SALARY) <SALARY;
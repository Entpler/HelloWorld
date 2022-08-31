================================================================
[����19]
--�μ����� �ٹ��ϴ� ����� ���� 3�� ������ ���, ����� ���� �μ����� �������� ���� ��ȸ

SELECT DEPT_TITLE"�μ�", COUNT(EMP_NAME)"�����"
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE(+) = DEPT_ID
GROUP BY DEPT_TITLE
HAVING COUNT(EMP_NAME)<=3
ORDER BY COUNT(EMP_NAME) ASC;

================================================================
[����20]
--EMPLOYEE ���̺���
--���� ���� �޿������ ��ȸ�ϰ� �޿���� ������������ �����Ͻÿ�
--(�޿������ TRUNC �Լ� ����Ͽ� �������� ���ϴ� ���� �Ͻÿ�)
SELECT TRUNC(AVG(SALARY),-1)"�޿����",JOB_CODE"�����ڵ�"
FROM EMPLOYEE
GROUP BY JOB_CODE
ORDER BY AVG(SALARY) DESC;

================================================================
[����21]--�������� ��...
--�ؿܿ���2��(DEPT_CODE: D6)�� ��� �޿����� ���� �ް�, �ؿܿ���2�ο� ������ ������ 
--�����ڰ� ���� ����� ���(EMP_ID), �̸�(EMP_NAME), ����(JOB_NAME), �μ��̸�(DEPT_TITLE), �޿�(SALARY)�� ��ȸ�Ͻÿ�.
--��,FROM ���� �������� ���, JOIN�� ����Ŭ ���� ���, ���� ���� ���
SELECT EMP_ID"���", EMP_NAME "�̸�"-- JOB_NAME"����", DEPT_TITLE"�μ��̸�",SALARY"�޿�"
FROM EMPLOYEE E, JOB J ,DEPARTMENT D
WHERE E.SALARY (ANY SELECT AVG(SALARY) FROM EMPLOYEE  WHERE DEPT_CODE ='D6') AND
E.DEPT_CODE IN(SELECT DEPT_CODE FROM EMPLOYEE  WHERE DEPT_CODE !='D6')
--AND (E.JOB_CODE  = J.JOB_CODE) AND (E.DEPT_CODE = D.DEPT_ID);
--MANAGER_ID = (SELECT MANAGER_ID FROM EMPLOYEE E WHERE MANAGER_ID IS NULL);

================================================================
[����22] 
--EMP���� �����̸����� �׷��� ����� ������ 5000�̻��� �׷� ã��
--JOB�̸���, �޿� �հ踦 ��ȸ�Ͻÿ�
SELECT J.JOB_NAME"����",SUM(SALARY)"����"
FROM EMPLOYEE E ,JOB J
WHERE(E.JOB_CODE =J.JOB_CODE)
GROUP BY J.JOB_NAME
--HAVING SUM(SALARY)>=50000000;

================================================================
[����23] --�ζ��κ�??
--EMPLOYEE ���̺���
--�Ի��Ϸκ��� �ٹ������ ���� �� ���� ���� 6����
--RANK()�Լ��� �̿��Ͽ� ��ȸ�Ͻÿ�
--���, �����, �μ���, ���޸�, �Ի����� ��ȸ�Ͻÿ�.

SELECT ROWNUM  "����", EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE)"�ٹ��⵵", EMP_ID"���", EMP_NAME"�����", DEPT_TITLE"�μ���",J.JOB_NAME"���޸�",HIRE_DATE"�Ի���"
FROM EMPLOYEE E,DEPARTMENT D,JOB J SELECT( * FROM EMPLOYEE E,DEPARTMENT D,JOB J ORDER BY "�ٹ��⵵" DESC )
WHERE (DEPT_CODE = DEPT_ID) AND (J.JOB_CODE=E.JOB_CODE) AND ROWNUM<=6;

SELECT *  
FROM (SELECT EMP_ID "���", EMP_NAME"�����",HIRE_DATE"�Ի���", SALARY"�޿�" ,RANK() OVER(ORDER BY SALARY  DESC) "��������" 
FROM EMPLOYEE)
WHERE  ROWNUM<=6;

DEPT_CODE = DEPT_ID) AND (J.JOB_CODE=E.JOB_CODE) 
==========================================================================================================================================
[����24]
--EMPLOYEE ���̺��� 
--�μ��� ���� �޿��� ���� ���� ��������
--�μ���, �ִ�޿��� ��ȸ�Ͻÿ�
--��, �ִ�޿��� 400���� ������ �μ��鸸 ��ȸ�Ͻÿ�
--(�μ����� JOIN Ȱ��)
SELECT D.DEPT_TITLE"�μ���" ,MAX(E.SALARY)"�ִ�޿�"
FROM EMPLOYEE E,DEPARTMENT D
WHERE (D.DEPT_ID = E.DEPT_CODE)
GROUP BY DEPT_TITLE
HAVING MAX(E.SALARY) <= 4000000;

================================================================
[����25]--������������
--EMPLOYEE ���̺��� �μ��� �ְ� �޿��� Ȯ�� ��, ��� �� �ش� �μ��� �ְ� �޿��� ��ġ�ϴ� �����
--���(EMP_ID), �̸�(EMP_NAME), �μ��̸�(DEPT_TITLE), ����(JOB_NAME), �μ��ڵ�(DEPT_CODE), �޿�(SALARY)�� ��ȸ�Ͻÿ�.
--�޿� ������������ ����, JOIN(ANSI ���� ���), WHERE ������ ���������� �μ��� �ְ� �޿� Ȯ��.
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE E JOIN DEPARTMENT D ON (DEPT_CODE= DEPT_ID)
JOIN JOB J ON (E.JOB_CODE = J.JOB_CODE)
WHERE SALARY = (SELECT MAX(SALARY) FROM EMPLOYEE GROUP BY DEPT_TITLE)
ORDER BY SALARY DESC;

SELECT *
FROM EMPLOYEE;

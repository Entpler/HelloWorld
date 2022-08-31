================================================================
[���� 34]
--�޿� ����� 3���ȿ� ��� ������ ã�� �����ڵ�, ���޸�, �޿����� ��ȸ�� ��
--ROWNUM�� �ζ��κ並 �ݿ��Ͽ� ��ȸ�Ͻÿ�
SELECT JOB_CODE"�����ڵ�", JOB_NAME"���޸�"
FROM EMPLOYEE E, DEPARTMET D
WHERE (E.DEPT_CODE=D.DEPT_ID) AND SALARY = (SELECT AVG(SALARY) FROM 
(DEPT_ID=DEPT_CODE) AND (E.JOB_CODE=J.JOB_CODE)

================================================================
[���� 35]
--EMPLOYEE ���̺���
    --�޿��� 1,380,000���� ������ ���� �����ڵ�, ���� �޿����(SAL_LEVEL)�� �ش��ϴ� 
    --����� �����, �����ڵ�, �޿������ ��ȸ�Ͻÿ�
--��, �޿��� 1,380,000���� �ش������� �����Ͽ� ��ȸ�Ͻÿ�
--(���߿� �������� ���)
SELECT EMP_NAME"�����", JOB_CODE"�����ڵ�",SAL_LEVEL"�޿����"
FROM EMPLOYEE
WHERE (JOB_CODE,SAL_LEVEL) IN (SELECT JOB_CODE,SAL_LEVEL FROM EMPLOYEE WHERE SALARY = '1380000')
AND SALARY<>'1380000';


================================================================
[���� 36]
--4/4�б� ������ ���� �󿩱��� �����ϰ� �Ǿ� ���� ���޿� ���� �󿩱��� �����Ϸ� �Ѵ�.
--�޿�(SALARY)�� 400���� �ʰ� �� �޿��� 30%, 200���� �̻� 400���� �̸��̸� �޿��� 50%, 
--100�����̻� 200���� �̸��̸� �޿��� 70%�� �����Ѵ�.
--��, CASE�� ����ϰ� �޿� ������ �������� ����
SELECT EMP_ID"���", SALARY"�޿�", CASE WHEN  SALARY>'4000000' THEN SALARY*0.3 
            WHEN  SALARY >='2000000' AND SALARY <4000000 THEN SALARY*0.5
            WHEN  SALARY>='1000000' AND SALARY< 2000000 THEN SALARY*0.7
            END "�󿩱�"
FROM EMPLOYEE
ORDER BY SALARY DESC;
 
================================================================
[���� 37]
--EMPLOYEE ���̺��� ����� 200, 201, 202�� ������� ã��
--200���� ����� �ֹι�ȣ ���ڸ��� '621212'��
--201���� ����� �ֹι�ȣ ���ڸ��� '631111'��
--202���� ����� �ֹι�ȣ ���ڸ��� '861010'���� �����ϴ� UPDATE ������ �����Ͻÿ�.
SELECT EMP_ID"���",EMP_NO"�ֹι�ȣ",
CASE WHEN EMP_ID ='200' THEN REPLACE(SUBSTR(EMP_NO,1,6),'621212')
     WHEN EMP_ID ='201' THEN REPLACE(SUBSTR(EMP_NO,1,6),'631111')
     WHEN EMP_ID ='202' THEN REPLACE(SUBSTR(EMp_NO,1,6),'861010')
     END "������ֹι�ȣ"
FROM EMPLOYEE;

================================================================
[���� 38]
--EMPLOYE ���̺��� ENT_YN�� Y�� '�����', N�̸� '�ٹ���'�� ǥ���ϰ�
--������ ����� ������ '�Ϲݻ��', ������ ����� ������ '������'�� ǥ���ϰ�
--������ ���, �����, �μ��ڵ�, �����ڵ�, �ٹ� ��Ȳ, ������ ���θ� ��ȸ�Ͻÿ�.
SELECT EMP_ID"���",EMP_NAME"�����",DEPT_CODE"�μ��ڵ�",JOB_CODE"�����ڵ�",
DECODE(ENT_YN,'Y','�����','N','�ٹ���')"�ٹ���Ȳ", NVL2(MANAGER_ID,'�Ϲݻ��','������')"�����ڿ���"
FROM EMPLOYEE;

================================================================
[����39]
--EMPLOYEE ���̺��� �μ��ڵ� D5�� �����ڵ尡 J5�� �ƴϰ� J7�� �ƴ� ����� 
--�����, �μ��ڵ�, �����ڵ�, SAL_LEVEL, �ٹ����� ��ȸ
SELECT EMP_NAME"�����", DEPT_CODE"�μ��ڵ�", JOB_CODE"�����ڵ�", SAL_LEVEL"�޿�����",ENT_DATE"��翩��" 
FROM EMPLOYEE
WHERE (JOB_CODE != 'J5' AND JOB_CODE != 'J7') AND ENT_DATE IS NULL;

SELECT *
FROM EMPLOYEE;
================================================================
[����40]
--EMPLOYEE���̺���
--�޿��� ���� ���� �����
--�����ȣ,�����,�޿�,�μ���ȣ�� ���Ͻÿ�
--�޿� ������ �������� �Ͻÿ�
SELECT EMP_ID"�����ȣ", EMP_NAME"�����",SALARY"�޿�",DEPT_CODE"�μ���ȣ"
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
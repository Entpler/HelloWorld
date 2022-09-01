
-- �ǽ� ���� --
-- �������� ���α׷��� ����� ���� ���̺�� ����� --
-- �̶�, �������ǿ� �̸��� �ο��Ұ�
-- �� �÷��� �ּ� �ޱ�

-- 1. ���ǻ�鿡 ���� �����͸� ��� ���� ���ǻ� ���̺� (TB_PUBLISHER)
-- �÷� : PUB_NO (���ǻ��ȣ) -- �⺻Ű (PUBLISHER_PK)
--        PUB_NAME (���ǻ��) -- NOT NULL (PUBLISHER_NN)
--        PHONE (���ǻ���ȭ��ȣ) -- �������� ����

    CREATE TABLE TB_PUBLISHER(
    PUB_NO NUMBER,
    PUB_NAME VARCHAR2(20) CONSTRAINT PUBLISHER_NN NOT NULL,
    PHONE CHAR(13) ,
    CONSTRAINT PUBLISHER_PK  PRIMARY KEY(PUB_NO));
    
    -- 3�� ������ ���� ������ �߰��ϱ�
SELECT * 
FROM TB_PUBLISHER; 

INSERT INTO TB_PUBLISHER
VALUES (1,'������ǻ�','010-1111-2222');

INSERT INTO TB_PUBLISHER
VALUES (2,'������ǻ�','010-1111-2232');

INSERT INTO TB_PUBLISHER
VALUES (3,'�䲤���ǻ�','010-2322-0309');



    CREATE TABLE TB_BOOK(
    
    BK_NO NUMBER,
    BK_TITLE VARCHAR2(20) CONSTRAINT BOOK_NN_TITLE NOT NULL,
    BK_AUTHOR  CHAR(10) CONSTRAINT BOOK_NN_AUTHOR NOT NULL,
    BK_PRICE NUMBER,
    BK_PUB_NO NUMBER,
    CONSTRAINT BOOK_PK PRIMARY KEY (BK_NO),
    CONSTRAINT BOOK_FK FOREIGN KEY(BK_PUB_NO) REFERENCES TB_PUBLISHER(PUB_NO)
    );
-- 5�� ������ ���� ������ �߰��ϱ�
-- 2. �����鿡 ���� �����͸� ��� ���� ���� ���̺� (TB_BOOK)
-- �÷� : BK_NO (������ȣ) -- �⺻Ű (BOOK_PK)
--        BK_TITLE (������) -- NOT NULL (BOOK_NN_TITLE)
--        BK_AUTHOR (���ڸ�) -- NOT NULL (BOOK_NN_AUTHOR)
--        BK_PRICE (����)
--        BK_PUB_NO (���ǻ��ȣ) -- �ܷ�Ű(BOOK_FK) (TB_PUBLISHER ���̺��� �����ϵ���)
--                                 �� ��, �����ϰ� �ִ� �θ����� ���� �� �ڽ� �����͵� ���� �ǵ��� �Ѵ�.

INSERT INTO TB_BOOK (BK_NO, BK_TITLE, BK_AUTHOR, BK_PRICE, BK_PUB_NO)
VALUES(1, '�ڹ�������', '���ü�', 27000, 1);

INSERT INTO TB_BOOK (BK_NO, BK_TITLE, BK_AUTHOR, BK_PRICE, BK_PUB_NO)
VALUES(2, '����', '���̽�', 27000, 1);

INSERT INTO TB_BOOK (BK_NO, BK_TITLE, BK_AUTHOR, BK_PRICE, BK_PUB_NO)
VALUES(3, '�����ͺм�', 'ĳ��', 27000, 2);

INSERT INTO TB_BOOK (BK_NO, BK_TITLE, BK_AUTHOR, BK_PRICE, BK_PUB_NO)
VALUES(4, '�������', 'ũ����', 12600, 2);

INSERT INTO TB_BOOK (BK_NO, BK_TITLE, BK_AUTHOR, BK_PRICE, BK_PUB_NO)
VALUES(5, '�ݿ��ϿͶ�', '��̸�', 14850, 3);

SELECT * FROM TB_BOOK;


-- 3. ȸ���� ���� �����͸� ��� ���� ȸ�� ���̺� (TB_MEMBER)
-- �÷��� : MEMBER_NO (ȸ����ȣ) -- �⺻Ű (MEMBER_PK)
--         MEMBER_ID (���̵�) -- �ߺ����� (MEMBER_UQ)
--         MEMBER_PWD (��й�ȣ) -- NOT NULL (MEMBER_NN_PWD)
--         MEMBER_NAME (ȸ����) -- NOT NULL (MEMBER_NN_NAME)
--         GENDER (����) -- 'M' �Ǵ� 'F' �� �Էµǵ��� ���� (MEMBER_CK_GEN)
--         ADDRESS (�ּ�)
--         PHONE (����ó)
--         STATUS (Ż�𿩺�) -- �⺻������ 'N' ���� ����, �׸��� 'Y' Ȥ�� 'N' ���θ� �Էµǵ��� �������� (MEMBER_CK_ST)
--         ENROLL_DATE (������) -- �⺻������ SYSDATE, NOT NULL �������� (MEMBER_NN_EN)

CREATE TABLE  TB_MEMBER(
             MEMBER_NO NUMBER,
             MEMBER_ID VARCHAR2(20) CONSTRAINT MEMBER_UQ UNIQUE,
             MEMBER_PWD VARCHAR2(30) CONSTRAINT MEMBER_NN_PWD NOT NULL,
             MEMBER_NAME VARCHAR2(20) CONSTRAINT MEMBER_NN_NAME NOT NULL,
             GENDER CHAR(3) CHECK(GENDER IN ('��','��')),
             ADDRESS VARCHAR2(30),
             PHONE CHAR(13),
             STATUS CHAR(3) DEFAULT 'N' CONSTRAINT MEMBER_CK_ST CHECK(STATUS IN ('Y','N')) ,
             ENROLL_DATE  DATE DEFAULT SYSDATE CONSTRAINT MEMBER_NN_EN NOT NULL,
             CONSTRAINT MEMBER_PK PRIMARY KEY(MEMBER_NO));
                                                                   --DEFAULT �� �������� �ƴϹǷ� ���� ����

SELECT *
FROM TB_MEMBER;

-- 5�� ������ ���� ������ �߰��ϱ�

INSERT INTO TB_MEMBER (MEMBER_NO, MEMBER_ID, MEMBER_PWD, MEMBER_NAME, GENDER,ADDRESS,PHONE,STATUS,ENROLL_DATE)
VALUES(1,'user01','pass01','�ڸ���','��','�Ÿ���','01011112222','Y',SYSDATE);

INSERT INTO TB_MEMBER (MEMBER_NO, MEMBER_ID, MEMBER_PWD, MEMBER_NAME, GENDER,ADDRESS,PHONE,STATUS)
VALUES(2,'user02','pass02','�谳��','��','���ʵ�','0101113222','N');

INSERT INTO TB_MEMBER (MEMBER_NO, MEMBER_ID, MEMBER_PWD, MEMBER_NAME, GENDER,ADDRESS,PHONE,STATUS,ENROLL_DATE)
VALUES(3,'user03','pass03','����','��','�ѳ���','01003090901','N',SYSDATE);

INSERT INTO TB_MEMBER (MEMBER_NO, MEMBER_ID, MEMBER_PWD, MEMBER_NAME, GENDER,ADDRESS,PHONE,STATUS,ENROLL_DATE)
VALUES(4,'user04','pass04','������','��','�Ÿ���','01076702222','Y',SYSDATE);

INSERT INTO TB_MEMBER (MEMBER_NO, MEMBER_ID, MEMBER_PWD, MEMBER_NAME, GENDER,ADDRESS,PHONE,STATUS,ENROLL_DATE)
VALUES(5,'user05',' pass05', '�ڸ��', '��',' ��赿', '0101323122','N',SYSDATE);

SELECT *
FROM TB_MEMBER;


-- 4. � ȸ���� � ������ �뿩�ߴ����� ���� �뿩��� ���̺� (TB_RENT)
-- �÷� : RENT_NO (�뿩��ȣ) -- �⺻Ű (RENT_PK)
--        RENT_MEM_NO (�뿩ȸ����ȣ) -- �ܷ�Ű (RENT_FK_MEM) TB_MEMBER �� �����ϵ���
--                                    �� ��, �θ� ������ ���� �� �ڽ� ������ ���� NULL �� �ǵ��� �ɼ� ����
--        RENT_BOOK_NO (�뿩������ȣ) -- DHLFOZL (RENT_FK_BOOK) TB_BOOK �� �����ϵ���
--                                     �� ��, �θ� ������ ���� �� �ڽ� ������ ���� NULL ���� �ǵ��� �ɼ� ����
--        RENT_DATE (�뿩��) -- �⺻�� SYSDATE


CREATE TABLE  TB_RENT(
             RENT_NO NUMBER,
             RENT_MEM_NO NUMBER CONSTRAINT RENT_FK_MEM REFERENCES TB_MEMBER,
            RENT_BOOK_NO NUMBER,           
             MEMBER_NAME VARCHAR2(20) CONSTRAINT MEMBER_NN_NAME NOT NULL,
             RENT_DATE DATE DEFAULT SYSDATE,
             CONSTRAINT RENT_PK PRIMARY KEY(RENT_NO),
             CONSTRAINT RENT_KF_BOOK FOREIGN KEY(RENT_MEM_NO) REFERENCES TB_BOOK(BK_NUM) ON DELETE SET NULL,
             CONSTRAINT RENT_MEM_NO FOREIGN KEY(RENT_FK_MEM) REFERENCES TB_MEMBER (MEMBER_NUM) );
                                              









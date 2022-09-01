
-- 실습 문제 --
-- 도서관리 프로그램을 만들기 위한 테이블들 만들기 --
-- 이때, 제약조건에 이름을 부여할것
-- 각 컬럼에 주석 달기

-- 1. 출판사들에 대한 데이터를 담기 위한 출판사 테이블 (TB_PUBLISHER)
-- 컬럼 : PUB_NO (출판사번호) -- 기본키 (PUBLISHER_PK)
--        PUB_NAME (출판사명) -- NOT NULL (PUBLISHER_NN)
--        PHONE (출판사전화번호) -- 제약조건 없음

    CREATE TABLE TB_PUBLISHER(
    PUB_NO NUMBER,
    PUB_NAME VARCHAR2(20) CONSTRAINT PUBLISHER_NN NOT NULL,
    PHONE CHAR(13) ,
    CONSTRAINT PUBLISHER_PK  PRIMARY KEY(PUB_NO));
    
    -- 3개 정도의 샘플 데이터 추가하기
SELECT * 
FROM TB_PUBLISHER; 

INSERT INTO TB_PUBLISHER
VALUES (1,'댕댕출판사','010-1111-2222');

INSERT INTO TB_PUBLISHER
VALUES (2,'댕냥출판사','010-1111-2232');

INSERT INTO TB_PUBLISHER
VALUES (3,'토깽출판사','010-2322-0309');



    CREATE TABLE TB_BOOK(
    
    BK_NO NUMBER,
    BK_TITLE VARCHAR2(20) CONSTRAINT BOOK_NN_TITLE NOT NULL,
    BK_AUTHOR  CHAR(10) CONSTRAINT BOOK_NN_AUTHOR NOT NULL,
    BK_PRICE NUMBER,
    BK_PUB_NO NUMBER,
    CONSTRAINT BOOK_PK PRIMARY KEY (BK_NO),
    CONSTRAINT BOOK_FK FOREIGN KEY(BK_PUB_NO) REFERENCES TB_PUBLISHER(PUB_NO)
    );
-- 5개 정도의 샘플 데이터 추가하기
-- 2. 도서들에 대한 데이터를 담기 위한 도서 테이블 (TB_BOOK)
-- 컬럼 : BK_NO (도서번호) -- 기본키 (BOOK_PK)
--        BK_TITLE (도서명) -- NOT NULL (BOOK_NN_TITLE)
--        BK_AUTHOR (저자명) -- NOT NULL (BOOK_NN_AUTHOR)
--        BK_PRICE (가격)
--        BK_PUB_NO (출판사번호) -- 외래키(BOOK_FK) (TB_PUBLISHER 테이블을 참조하도록)
--                                 이 때, 참조하고 있는 부모데이터 삭제 시 자식 데이터도 삭제 되도록 한다.

INSERT INTO TB_BOOK (BK_NO, BK_TITLE, BK_AUTHOR, BK_PRICE, BK_PUB_NO)
VALUES(1, '자바의정석', '남궁성', 27000, 1);

INSERT INTO TB_BOOK (BK_NO, BK_TITLE, BK_AUTHOR, BK_PRICE, BK_PUB_NO)
VALUES(2, '선물', '루이스', 27000, 1);

INSERT INTO TB_BOOK (BK_NO, BK_TITLE, BK_AUTHOR, BK_PRICE, BK_PUB_NO)
VALUES(3, '데이터분석', '캐시', 27000, 2);

INSERT INTO TB_BOOK (BK_NO, BK_TITLE, BK_AUTHOR, BK_PRICE, BK_PUB_NO)
VALUES(4, '가벼운마음', '크리스', 12600, 2);

INSERT INTO TB_BOOK (BK_NO, BK_TITLE, BK_AUTHOR, BK_PRICE, BK_PUB_NO)
VALUES(5, '금요일와라', '김미리', 14850, 3);

SELECT * FROM TB_BOOK;


-- 3. 회원에 대한 데이터를 담기 위한 회원 테이블 (TB_MEMBER)
-- 컬럼명 : MEMBER_NO (회원번호) -- 기본키 (MEMBER_PK)
--         MEMBER_ID (아이디) -- 중복금지 (MEMBER_UQ)
--         MEMBER_PWD (비밀번호) -- NOT NULL (MEMBER_NN_PWD)
--         MEMBER_NAME (회원명) -- NOT NULL (MEMBER_NN_NAME)
--         GENDER (성별) -- 'M' 또는 'F' 로 입력되도록 제한 (MEMBER_CK_GEN)
--         ADDRESS (주소)
--         PHONE (연락처)
--         STATUS (탈퇴여부) -- 기본값으로 'N' 으로 지정, 그리고 'Y' 혹은 'N' 으로만 입력되도록 제약조건 (MEMBER_CK_ST)
--         ENROLL_DATE (가입일) -- 기본값으로 SYSDATE, NOT NULL 제약조건 (MEMBER_NN_EN)

CREATE TABLE  TB_MEMBER(
             MEMBER_NO NUMBER,
             MEMBER_ID VARCHAR2(20) CONSTRAINT MEMBER_UQ UNIQUE,
             MEMBER_PWD VARCHAR2(30) CONSTRAINT MEMBER_NN_PWD NOT NULL,
             MEMBER_NAME VARCHAR2(20) CONSTRAINT MEMBER_NN_NAME NOT NULL,
             GENDER CHAR(3) CHECK(GENDER IN ('남','여')),
             ADDRESS VARCHAR2(30),
             PHONE CHAR(13),
             STATUS CHAR(3) DEFAULT 'N' CONSTRAINT MEMBER_CK_ST CHECK(STATUS IN ('Y','N')) ,
             ENROLL_DATE  DATE DEFAULT SYSDATE CONSTRAINT MEMBER_NN_EN NOT NULL,
             CONSTRAINT MEMBER_PK PRIMARY KEY(MEMBER_NO));
                                                                   --DEFAULT 는 제약조건 아니므로 순서 주의

SELECT *
FROM TB_MEMBER;

-- 5개 정도의 샘플 데이터 추가하기

INSERT INTO TB_MEMBER (MEMBER_NO, MEMBER_ID, MEMBER_PWD, MEMBER_NAME, GENDER,ADDRESS,PHONE,STATUS,ENROLL_DATE)
VALUES(1,'user01','pass01','박말순','여','신림동','01011112222','Y',SYSDATE);

INSERT INTO TB_MEMBER (MEMBER_NO, MEMBER_ID, MEMBER_PWD, MEMBER_NAME, GENDER,ADDRESS,PHONE,STATUS)
VALUES(2,'user02','pass02','김개똥','여','서초동','0101113222','N');

INSERT INTO TB_MEMBER (MEMBER_NO, MEMBER_ID, MEMBER_PWD, MEMBER_NAME, GENDER,ADDRESS,PHONE,STATUS,ENROLL_DATE)
VALUES(3,'user03','pass03','고영희','여','한남동','01003090901','N',SYSDATE);

INSERT INTO TB_MEMBER (MEMBER_NO, MEMBER_ID, MEMBER_PWD, MEMBER_NAME, GENDER,ADDRESS,PHONE,STATUS,ENROLL_DATE)
VALUES(4,'user04','pass04','나땡땡','여','신림동','01076702222','Y',SYSDATE);

INSERT INTO TB_MEMBER (MEMBER_NO, MEMBER_ID, MEMBER_PWD, MEMBER_NAME, GENDER,ADDRESS,PHONE,STATUS,ENROLL_DATE)
VALUES(5,'user05',' pass05', '박명수', '남',' 방배동', '0101323122','N',SYSDATE);

SELECT *
FROM TB_MEMBER;


-- 4. 어떤 회원이 어떤 도서를 대여했는지에 대한 대여목록 테이블 (TB_RENT)
-- 컬럼 : RENT_NO (대여번호) -- 기본키 (RENT_PK)
--        RENT_MEM_NO (대여회원번호) -- 외래키 (RENT_FK_MEM) TB_MEMBER 와 참조하도록
--                                    이 때, 부모 데이터 삭제 시 자식 데이터 값이 NULL 이 되도록 옵션 설정
--        RENT_BOOK_NO (대여도서번호) -- DHLFOZL (RENT_FK_BOOK) TB_BOOK 와 참조하도록
--                                     이 때, 부모 데이터 삭제 시 자식 데이터 값이 NULL 값이 되도록 옵션 설정
--        RENT_DATE (대여일) -- 기본값 SYSDATE


CREATE TABLE  TB_RENT(
             RENT_NO NUMBER,
             RENT_MEM_NO NUMBER CONSTRAINT RENT_FK_MEM REFERENCES TB_MEMBER,
            RENT_BOOK_NO NUMBER,           
             MEMBER_NAME VARCHAR2(20) CONSTRAINT MEMBER_NN_NAME NOT NULL,
             RENT_DATE DATE DEFAULT SYSDATE,
             CONSTRAINT RENT_PK PRIMARY KEY(RENT_NO),
             CONSTRAINT RENT_KF_BOOK FOREIGN KEY(RENT_MEM_NO) REFERENCES TB_BOOK(BK_NUM) ON DELETE SET NULL,
             CONSTRAINT RENT_MEM_NO FOREIGN KEY(RENT_FK_MEM) REFERENCES TB_MEMBER (MEMBER_NUM) );
                                              









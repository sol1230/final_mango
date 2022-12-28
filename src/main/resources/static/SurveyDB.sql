
CREATE TABLE ANSWER
(
  ANSWER_UID VARCHAR(200) NOT NULL COMMENT '대표값',
  ANSWER     VARCHAR(200) NOT NULL COMMENT '문항답변',
  PRIMARY KEY (ANSWER_UID)
) COMMENT '답 문항';

CREATE TABLE QUESTION
(
  QUESTION_UID  VARCHAR(200) NOT NULL COMMENT '대표값',
  QUESTION_LIST VARCHAR(200) NOT NULL COMMENT '문항목록',
  PRIMARY KEY (QUESTION_UID)
) COMMENT '질문';

CREATE TABLE SURVEY
(
  ANSWER_UID   VARCHAR(200) NOT NULL COMMENT '설문목록대표값',
  QUESTION_UID VARCHAR(200) NOT NULL COMMENT '문항답변대표값'
) COMMENT '설문';

CREATE TABLE SURVEYOR
(
  USER_ID    INTEGER      NOT NULL COMMENT '아이디',
  NAME       VARCHAR(200) NOT NULL COMMENT '이름',
  BIRTH_DATE VARCHAR(200) NOT NULL COMMENT '생년월일',
  PASSWORD   VARCHAR(200) NOT NULL COMMENT '비밀번호',
  PHONE      INTEGER      NOT NULL COMMENT '전화번호',
  PRIMARY KEY (USER_ID)
) COMMENT '설문자';

CREATE TABLE USERS_ANSWER
(
  USER_ID      INTEGER      NOT NULL COMMENT '아이디',
  ANSWER_UID   VARCHAR(200) NOT NULL COMMENT '대표값',
  QUESTION_UID VARCHAR(200) NOT NULL COMMENT '대표값'
) COMMENT '사용자 답변';

ALTER TABLE SURVEY
  ADD CONSTRAINT FK_ANSWER_TO_SURVEY
    FOREIGN KEY (QUESTION_UID)
    REFERENCES ANSWER (ANSWER_UID);

ALTER TABLE SURVEY
  ADD CONSTRAINT FK_QUESTION_TO_SURVEY
    FOREIGN KEY (ANSWER_UID)
    REFERENCES QUESTION (QUESTION_UID);

ALTER TABLE USERS_ANSWER
  ADD CONSTRAINT FK_SURVEYOR_TO_USERS_ANSWER
    FOREIGN KEY (USER_ID)
    REFERENCES SURVEYOR (USER_ID);

ALTER TABLE USERS_ANSWER
  ADD CONSTRAINT FK_ANSWER_TO_USERS_ANSWER
    FOREIGN KEY (ANSWER_UID)
    REFERENCES ANSWER (ANSWER_UID);

ALTER TABLE USERS_ANSWER
  ADD CONSTRAINT FK_QUESTION_TO_USERS_ANSWER
    FOREIGN KEY (QUESTION_UID)
    REFERENCES QUESTION (QUESTION_UID);

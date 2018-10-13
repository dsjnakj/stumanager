prompt PL/SQL Developer import file
prompt Created on 2012��9��19�� by Administrator
set feedback off
set define off
prompt Creating STUDENT...
create table STUDENT
(
  ID    NUMBER(6) not null,
  NAME  VARCHAR2(12),
  AGE   NUMBER(3),
  SCORE NUMBER(5,1)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table STUDENT
  add constraint PK_STU primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt Loading STUDENT...
insert into STUDENT (ID, NAME, AGE, SCORE)
values (1, 'Ф����', 21, 78);
insert into STUDENT (ID, NAME, AGE, SCORE)
values (2, '����', 19, 68);
insert into STUDENT (ID, NAME, AGE, SCORE)
values (3, '��Ӣ��', 20, 70);
insert into STUDENT (ID, NAME, AGE, SCORE)
values (4, '�ﵤ', 18, 75);
insert into STUDENT (ID, NAME, AGE, SCORE)
values (5, '�����', 18, 63);
insert into STUDENT (ID, NAME, AGE, SCORE)
values (6, '�ں�', 21, 78);
insert into STUDENT (ID, NAME, AGE, SCORE)
values (7, '����', 20, 80);
insert into STUDENT (ID, NAME, AGE, SCORE)
values (8, '��ϲ��', 23, 61);
insert into STUDENT (ID, NAME, AGE, SCORE)
values (9, '����', 19, 73);
insert into STUDENT (ID, NAME, AGE, SCORE)
values (10, '��־��', 20, 83);
insert into STUDENT (ID, NAME, AGE, SCORE)
values (11, '������', 19, 65);
insert into STUDENT (ID, NAME, AGE, SCORE)
values (12, 'κ�Ľ�', 20, 96);
insert into STUDENT (ID, NAME, AGE, SCORE)
values (13, 'Ԭ��', 21, 89);
insert into STUDENT (ID, NAME, AGE, SCORE)
values (14, '������', 23, 99);
insert into STUDENT (ID, NAME, AGE, SCORE)
values (15, '¦����', 21, 96);
insert into STUDENT (ID, NAME, AGE, SCORE)
values (16, '������', 19, 60);
insert into STUDENT (ID, NAME, AGE, SCORE)
values (17, '�࿡��', 18, 75);
insert into STUDENT (ID, NAME, AGE, SCORE)
values (18, '����', 19, 68);
insert into STUDENT (ID, NAME, AGE, SCORE)
values (19, 'ղ����', 20, 80);
insert into STUDENT (ID, NAME, AGE, SCORE)
values (20, '��ܺ�', 21, 86);
insert into STUDENT (ID, NAME, AGE, SCORE)
values (21, '�Ž���', 18, 78);
commit;
prompt 21 records loaded
set feedback on
set define on
prompt Done.

select * from student;

-- oracle��ҳSQL���

-- 1���Ȳ�ѯ������������ѧ����Ϣ
select * from student stu where name like '?%' and score >= ? order by sore desc;

-- 2��ͨ����ѧ������ȡ�кź�����������Ϣ��
--    ��ָ�������к���Ϊ��ѯ����,�����ͻ���˸��кŷ�Χ������ֵ
select rownum rn,stu2.* from stu as stu2 where rownum <=?;

-- 3�������кŵ���Сֵ��Ϊ��ѯ������
--    ��ѯ��ָ����Χ������
select * from stu2 where rn >?

-- �ϲ�������������SQL
select *��from 
(select rownum rn,stu2.* from 
(select stu.* from student stu where 1=1 
and name like '%��%' and score >= 70.0 order by score desc)
 stu2 where rownum <= 5) where rn > 0



prompt PL/SQL Developer import file
prompt Created on 2012年9月19日 by Administrator
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
values (1, '肖正坐', 21, 78);
insert into STUDENT (ID, NAME, AGE, SCORE)
values (2, '李攀', 19, 68);
insert into STUDENT (ID, NAME, AGE, SCORE)
values (3, '吕英刚', 20, 70);
insert into STUDENT (ID, NAME, AGE, SCORE)
values (4, '孙丹', 18, 75);
insert into STUDENT (ID, NAME, AGE, SCORE)
values (5, '徐彬琪', 18, 63);
insert into STUDENT (ID, NAME, AGE, SCORE)
values (6, '于海', 21, 78);
insert into STUDENT (ID, NAME, AGE, SCORE)
values (7, '江瑞', 20, 80);
insert into STUDENT (ID, NAME, AGE, SCORE)
values (8, '乔喜来', 23, 61);
insert into STUDENT (ID, NAME, AGE, SCORE)
values (9, '刘诚', 19, 73);
insert into STUDENT (ID, NAME, AGE, SCORE)
values (10, '何志文', 20, 83);
insert into STUDENT (ID, NAME, AGE, SCORE)
values (11, '张明辉', 19, 65);
insert into STUDENT (ID, NAME, AGE, SCORE)
values (12, '魏文杰', 20, 96);
insert into STUDENT (ID, NAME, AGE, SCORE)
values (13, '袁真', 21, 89);
insert into STUDENT (ID, NAME, AGE, SCORE)
values (14, '荣梦男', 23, 99);
insert into STUDENT (ID, NAME, AGE, SCORE)
values (15, '娄晓健', 21, 96);
insert into STUDENT (ID, NAME, AGE, SCORE)
values (16, '朱明政', 19, 60);
insert into STUDENT (ID, NAME, AGE, SCORE)
values (17, '余俊磊', 18, 75);
insert into STUDENT (ID, NAME, AGE, SCORE)
values (18, '郭波', 19, 68);
insert into STUDENT (ID, NAME, AGE, SCORE)
values (19, '詹兴龙', 20, 80);
insert into STUDENT (ID, NAME, AGE, SCORE)
values (20, '冯杰恒', 21, 86);
insert into STUDENT (ID, NAME, AGE, SCORE)
values (21, '张娇娇', 18, 78);
commit;
prompt 21 records loaded
set feedback on
set define on
prompt Done.

select * from student;

-- oracle分页SQL语句

-- 1、先查询到符合条件的学生信息
select * from student stu where name like '?%' and score >= ? order by sore desc;

-- 2、通过的学生，获取行号和其他所有信息，
--    并指定最大的行号作为查询条件,这样就获得了该行号范围的所有值
select rownum rn,stu2.* from stu as stu2 where rownum <=?;

-- 3、再以行号的最小值作为查询条件，
--    查询到指定范围的数据
select * from stu2 where rn >?

-- 合并起来就是以下SQL
select *　from 
(select rownum rn,stu2.* from 
(select stu.* from student stu where 1=1 
and name like '%文%' and score >= 70.0 order by score desc)
 stu2 where rownum <= 5) where rn > 0



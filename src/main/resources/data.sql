insert into students_details(STUDENT_ID, DATE_OF_BIRTH, PHONE_NUMBER,STUDENT_NAME)
values(1001, current_date() , '7004290831', 'Ravi');

insert into students_details(STUDENT_ID, DATE_OF_BIRTH, PHONE_NUMBER,STUDENT_NAME)
values(10012, current_date() , '7004290831', 'Rupa');

insert into students_details(STUDENT_ID, DATE_OF_BIRTH, PHONE_NUMBER,STUDENT_NAME)
values(10021, current_date() , '7004290831', 'Soni');

insert into students_details(STUDENT_ID, DATE_OF_BIRTH, PHONE_NUMBER,STUDENT_NAME)
values(10031, current_date() , '7004290831', 'Neha');

insert into COURSES (COURSE_ID,COURSE_COST,COURSE_DESCRIPTION,COURSE_NAME,STUDENT_STUDENT_ID)
values(1,5000,'Aws course is course on clouds','AWS',1001);

insert into COURSES (COURSE_ID,COURSE_COST,COURSE_DESCRIPTION,COURSE_NAME,STUDENT_STUDENT_ID)
values(2,6000,'Azure course is course on clouds tech','Azure',10012);

insert into COURSES (COURSE_ID,COURSE_COST,COURSE_DESCRIPTION,COURSE_NAME,STUDENT_STUDENT_ID)
values(3,8000,'Used for building Application','Spring Boot',1001);
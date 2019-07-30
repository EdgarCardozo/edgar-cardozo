#FIRST TASK
create database highschool;
use highschool;
-- Student table
create table students(
					first_name VARCHAR(20) NOT NULL,
					last_name VARCHAR(20) NOT NULL,
					registration_number INT(8) PRIMARY KEY,
                    date_of_birth DATE);
-- Teacher table
create table teachers(
					id_teacher INT PRIMARY KEY,
                    first_name VARCHAR(20) NOT NULL,
                    last_name VARCHAR(20) NOT NULL,
                    date_of_birth DATE);
-- Course table
create table courses(
					course_name VARCHAR(30) PRIMARY KEY,
					id_teacher INT(8),
					CONSTRAINT FOREIGN KEY (id_teacher) REFERENCES teachers(id_teacher),
                    hours_by_week int NOT NULL,
                    schedule_time SET('monday','tuesday','wednesday', 'thursday','friday','saturday','sunday'),
                    start_time time,
                    finish_time time);
                    
-- Relationship between course and student (many to many)
create table attends(
					course VARCHAR(30),
                    student INT(8),
                    first_note INT(2),
                    second_note INT(2),
                    third_note INT(2),
                    final_note INT(2),
					CONSTRAINT FOREIGN KEY (course) REFERENCES courses(course_name),
                    CONSTRAINT FOREIGN KEY (student) REFERENCES students(registration_number),
                    PRIMARY KEY (course,student));
                    
# SECOND TASK
INSERT INTO highschool.teachers (id_teacher, first_name, last_name) VALUES ('2213', 'Carlos', 'Tevez');
INSERT INTO highschool.teachers (id_teacher, first_name, last_name) VALUES ('1167', 'Carlos', 'Bala');
INSERT INTO highschool.teachers (id_teacher, first_name, last_name) VALUES ('4587', 'Carlos', 'Bianchi');

INSERT INTO highschool.courses (course_name,id_teacher,hours_by_week,schedule_time) VALUES('BIG DATA', '2213', '16', 'monday,friday');
INSERT INTO highschool.courses (course_name,id_teacher,hours_by_week,schedule_time) VALUES('DATA SCIENCE', '4587', '2', 'monday,wednesday');
INSERT INTO highschool.courses (course_name,id_teacher,hours_by_week,schedule_time) VALUES('JAVA', '1167', '4', 'tuesday,thursday');

INSERT INTO highschool.students (first_name, last_name, registration_number) VALUES ('Edgar', 'Cardozo', '1');
INSERT INTO highschool.students (first_name, last_name, registration_number) VALUES ('Oscar', 'Cardozo', '2');
INSERT INTO highschool.students (first_name, last_name, registration_number) VALUES ('Pablo', 'Perez', '3');
INSERT INTO highschool.students (first_name, last_name, registration_number) VALUES ('Tano', 'De Rossi', '4');
INSERT INTO highschool.students (first_name, last_name, registration_number) VALUES ('Wanchope', 'Abile', '5');
INSERT INTO highschool.students (first_name, last_name, registration_number) VALUES ('Bebelo', 'Reynoso', '6');
INSERT INTO highschool.students (first_name, last_name, registration_number) VALUES ('Esteban', 'Andrada', '7');
INSERT INTO highschool.students (first_name, last_name, registration_number) VALUES ('Paolo', 'Goltz', '8');
INSERT INTO highschool.students (first_name, last_name, registration_number) VALUES ('Cristian', 'Pavon', '9');
INSERT INTO highschool.students (first_name, last_name, registration_number) VALUES ('Leo', 'Messi', '10');

INSERT INTO highschool.attends (course, student, first_note, second_note, third_note) VALUES ('BIG DATA', '1', '2', '4', '5');
INSERT INTO highschool.attends (course, student) VALUES ('BIG DATA', '2');
INSERT INTO highschool.attends (course, student) VALUES ('BIG DATA', '3');
INSERT INTO highschool.attends (course, student) VALUES ('BIG DATA', '4');
INSERT INTO highschool.attends (course, student) VALUES ('BIG DATA', '5');
INSERT INTO highschool.attends (course, student) VALUES ('BIG DATA', '6');
INSERT INTO highschool.attends (course, student) VALUES ('BIG DATA', '7');
INSERT INTO highschool.attends (course, student) VALUES ('BIG DATA', '8');
INSERT INTO highschool.attends (course, student) VALUES ('BIG DATA', '9');
INSERT INTO highschool.attends (course, student) VALUES ('BIG DATA', '10');

INSERT INTO highschool.attends (course, student) VALUES ('DATA SCIENCE', '1');
INSERT INTO highschool.attends (course, student) VALUES ('DATA SCIENCE', '2');
INSERT INTO highschool.attends (course, student) VALUES ('DATA SCIENCE', '3');
INSERT INTO highschool.attends (course, student) VALUES ('DATA SCIENCE', '4');
INSERT INTO highschool.attends (course, student) VALUES ('DATA SCIENCE', '5');
INSERT INTO highschool.attends (course, student) VALUES ('DATA SCIENCE', '6');
INSERT INTO highschool.attends (course, student) VALUES ('DATA SCIENCE', '7');
INSERT INTO highschool.attends (course, student) VALUES ('DATA SCIENCE', '8');
INSERT INTO highschool.attends (course, student) VALUES ('DATA SCIENCE', '9');
INSERT INTO highschool.attends (course, student) VALUES ('DATA SCIENCE', '10');

INSERT INTO highschool.attends (course, student) VALUES ('JAVA', '1');
INSERT INTO highschool.attends (course, student) VALUES ('JAVA', '2');
INSERT INTO highschool.attends (course, student) VALUES ('JAVA', '3');
INSERT INTO highschool.attends (course, student) VALUES ('JAVA', '4');
INSERT INTO highschool.attends (course, student) VALUES ('JAVA', '5');
INSERT INTO highschool.attends (course, student) VALUES ('JAVA', '6');
INSERT INTO highschool.attends (course, student) VALUES ('JAVA', '7');
INSERT INTO highschool.attends (course, student) VALUES ('JAVA', '8');
INSERT INTO highschool.attends (course, student) VALUES ('JAVA', '9');
INSERT INTO highschool.attends (course, student) VALUES ('JAVA', '10');

# THIRD TASK
SET @coursename='BIG DATA';
SELECT course_name AS COURSE , t.first_name AS teacherFirstName, t.last_name AS teacherLastName, s.first_name AS studentFirstName, s.last_name AS studentLastName
FROM courses c INNER JOIN teachers AS t ON c.id_teacher=t.id_teacher 
				INNER JOIN attends AS a ON c.course_name = a.course
				INNER JOIN students AS s ON a.student = s.registration_number
WHERE course_name = @coursename
ORDER BY s.last_name;

# FOURTH TASK
#SELECT if(a.final_note>=6,COUNT(a.student),NULL)/COUNT(a.student) AS mean
#FROM attends AS a
#WHERE a.course=@coursename;

SET @teacherID = 1167;
# FIFTH TASK
SELECT t.first_name AS FirstName, t.last_name AS LastName, c.schedule_time AS Days, c.start_time AS StartsAt, c.finish_time AS FinishAt
FROM courses AS c INNER JOIN teachers AS t ON c.id_teacher=t.id_teacher
WHERE t.id_teacher=@teacherID;


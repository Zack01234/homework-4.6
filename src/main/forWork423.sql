select s.name, s.age, f.name from student s left join faculty f on s.faculty_id = f.id;
select * from student s inner join avatar a on a.student_id = s.id;
-- 코드를 입력하세요
SELECT 
a.animal_id,
a.animal_type,
a.name
from animal_ins as a
join animal_outs as b 
on a.animal_id = b.animal_id
where left(a.sex_upon_intake,1) != 'N' and left(a.sex_upon_intake,1) !='S'
and (left(b.sex_upon_outcome,1) = 'N' or left(b.sex_upon_outcome,1) ='S')
order by a.animal_id

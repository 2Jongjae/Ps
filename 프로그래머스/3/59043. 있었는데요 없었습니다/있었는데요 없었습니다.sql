
SELECT 
a.animal_id,
a.name
from animal_outs as a
join animal_ins as b 
on a.animal_id = b.animal_id
where a.datetime < b.datetime
order by b.datetime 
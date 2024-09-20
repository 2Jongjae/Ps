set @hour := -1;

select (@hour := @hour +1 ) as hour,
(SELECT COUNT(*) FROM ANIMAL_OUTS WHERE HOUR(DATETIME) = @hour) 
from animal_outs
where @hour <'23'
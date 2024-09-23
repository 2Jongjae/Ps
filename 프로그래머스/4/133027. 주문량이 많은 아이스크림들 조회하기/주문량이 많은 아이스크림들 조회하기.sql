-- 코드를 입력하세요
select
a.flavor
from first_half  a
join (
    SELECT
        flavor,
        sum(total_order) as sum
from july 
group by flavor) as b 
on a.flavor = b.flavor
order by (total_order+b.sum) desc
limit 3

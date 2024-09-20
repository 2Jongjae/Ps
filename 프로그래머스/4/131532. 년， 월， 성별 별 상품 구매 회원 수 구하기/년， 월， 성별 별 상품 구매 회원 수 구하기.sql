-- 코드를 입력하세요
SELECT 
year(SALES_DATE),
month(SALES_DATE),
gender,
count(distinct a.user_id)
from user_info a
join online_sale b on a.user_id = b.user_id
where gender is not null
group by
year(sales_date),
month(SALES_DATE),
gender
order by year(sales_date),
month(SALES_DATE),
gender
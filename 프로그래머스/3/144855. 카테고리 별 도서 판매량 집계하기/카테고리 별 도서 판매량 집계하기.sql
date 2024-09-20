-- 코드를 입력하세요
SELECT 
category,
sum(sales) 
from book a
join book_sales b on a.book_id = b.book_id
where year(sales_date) = '2022' and month(sales_date) = 1
group by category
order by category
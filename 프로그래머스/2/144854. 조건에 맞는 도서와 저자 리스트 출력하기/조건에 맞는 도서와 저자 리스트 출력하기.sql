-- 코드를 입력하세요
SELECT
book_id,
b.author_name,
date_format(published_date,"%Y-%m-%d")
from book as a
left join author as b 
on a.author_id = b.author_id
where a.category = '경제'
order by published_date
with test as (
SELECT 
product_id,
sum(sales_amount) as amount
from 
offline_sale
group by product_id
)

select 
product_code,
amount*price as sales
from product as a
join test as b  
on a.product_id = b.product_id
order by sales desc,product_code
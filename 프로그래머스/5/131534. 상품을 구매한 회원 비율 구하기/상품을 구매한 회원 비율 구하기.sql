SELECT 
    YEAR(a.sales_date) AS year,
    MONTH(a.sales_date) AS month,
    COUNT(DISTINCT a.user_id) AS PURCHASED_USERS,
    round(COUNT(DISTINCT a.user_id) / (
        SELECT COUNT(user_id) 
        FROM user_info 
        WHERE YEAR(joined) = 2021
    ),1) AS PURCHASED_RATIO
FROM 
    online_sale AS a
JOIN 
    user_info AS b ON a.user_id = b.user_id
WHERE 
    YEAR(b.joined) = 2021
GROUP BY 
    YEAR(a.sales_date), MONTH(a.sales_date)
ORDER BY 
    year, month;
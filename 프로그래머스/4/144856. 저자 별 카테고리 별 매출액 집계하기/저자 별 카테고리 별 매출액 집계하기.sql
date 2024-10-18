WITH temp AS (
    SELECT *
    FROM BOOK_SALES
    WHERE YEAR(sales_date) = '2022'
    AND MONTH(sales_date) = '1'
)
SELECT
    a.author_id,
    c.author_name,
    a.category,
    SUM(b.sales * a.price) AS total_sales
FROM BOOK a
JOIN temp b ON a.book_id = b.book_id
JOIN AUTHOR c ON a.author_id = c.author_id
GROUP BY a.author_id, c.author_name, a.category
ORDER BY a.author_id, a.category DESC;
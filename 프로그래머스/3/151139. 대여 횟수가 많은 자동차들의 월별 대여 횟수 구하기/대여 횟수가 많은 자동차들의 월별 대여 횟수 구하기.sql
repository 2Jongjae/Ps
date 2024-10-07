WITH frequently_rented AS (
    SELECT car_id
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE start_date BETWEEN '2022-08-01' AND '2022-10-31'
    GROUP BY car_id
    HAVING COUNT(*) >= 5
)
SELECT
    MONTH(start_date) AS MONTH,
    car_id,
    COUNT(*) AS RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE 
    car_id IN (SELECT car_id FROM frequently_rented)
    AND start_date BETWEEN '2022-08-01' AND '2022-10-31'
GROUP BY MONTH(start_date), car_id
ORDER BY MONTH, car_id DESC
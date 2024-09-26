WITH FrontEndSkills AS (
    SELECT SUM(CODE) AS TotalCode
    FROM SKILLCODES
    WHERE CATEGORY = 'Front End'
)
SELECT 
    D.ID,
    D.EMAIL,
    D.FIRST_NAME,
    D.LAST_NAME
FROM 
    DEVELOPERS D,
    FrontEndSkills F
WHERE 
    D.SKILL_CODE & F.TotalCode > 0
ORDER BY 
    D.ID ASC;
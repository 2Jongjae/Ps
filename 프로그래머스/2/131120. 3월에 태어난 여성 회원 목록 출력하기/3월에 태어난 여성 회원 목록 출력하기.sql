-- 코드를 입력하세요
SELECT MEMBER_ID,MEMBER_NAME,GENDER,date_format(DATE_OF_BIRTH,'%Y-%m-%d') as date_of_brith
from member_profile
where month(date_of_birth) = '3' and tlno is not null and gender = 'W'
order by member_id
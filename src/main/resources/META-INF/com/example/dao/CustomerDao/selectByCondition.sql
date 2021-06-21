SELECT *
FROM customer
WHERE 1 = 1
/*%if condition.id != null */
    id = /* condition.id */1
/*%end*/
/*%if condition.firstName != null */
	AND first_name = /* condition.firstName */'Taro'
/*%end*/
/*%if condition.lastName != null */
	AND last_name = /* condition.lastName */'Yamada'
/*%end*/
ORDER BY id

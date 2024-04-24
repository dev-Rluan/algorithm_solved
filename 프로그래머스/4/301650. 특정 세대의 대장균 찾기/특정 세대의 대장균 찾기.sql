-- 코드를 작성해주세요
SELECT ed.ID 
FROM ECOLI_DATA ed 
INNER JOIN (select ed1.id 
            from ECOLI_DATA ed1
            inner join (select ID
                        from ECOLI_DATA 
                        where parent_id is null) as z 
                    on ed1.parent_id = z.id
           ) as a
       on a.id = ed.parent_id
ORDER BY ID


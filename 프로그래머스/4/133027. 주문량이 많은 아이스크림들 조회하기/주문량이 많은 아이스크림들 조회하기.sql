with withTable as(

    select * from FIRST_HALF 
    union all
    select * from JULY
    
)
select FLAVOR from withTable
group by FLAVOR
order by sum(TOTAL_ORDER) desc
limit 3
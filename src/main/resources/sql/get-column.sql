select vu.table_schema as schema
,vu.table_name as table
,col_description(pa.attrelid,0) as tableDesc
,vu.column_name as column
,col_description(pa.attrelid,pa.attnum) as columnDesc
,vu.data_type as columnType
,case when vu.data_type='character' or vu.data_type='character varying' then vu.character_maximum_length
when vu.data_type='integer' or vu.data_type='numeric' then vu.numeric_precision
when vu.data_type='timestamp without time zone' or vu.data_type='date' then vu.datetime_precision else null end as columnLength
,case when vu.data_type='integer' or vu.data_type='numeric' then vu.numeric_scale else null end as columnPoint
,vu.ordinal_position as sort
from information_schema.columns vu
join pg_catalog.pg_namespace pn on pn.nspname=vu.table_schema
join pg_catalog.pg_class pc on pc.relname=vu.table_name and pc.relnamespace=pn.oid
join pg_catalog.pg_attribute pa on pc.oid=pa.attrelid and pa.attname=vu.column_name
where vu.table_name in
(
select table_name from information_schema.tables where table_type='BASE TABLE'
)
and vu.table_schema=?
order by vu.table_schema ,vu.table_name, vu.ordinal_position

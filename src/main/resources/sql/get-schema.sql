/*select distinct table_schema from information_schema.tables
where table_type='BASE TABLE' and table_name like 't_%';*/
select schema_name from information_schema.schemata order by schema_name;

select pn.nspname as schema
,pct.relname as table
,pa.attname as column
,pci.relname as indexName
,pg_get_indexdef(pci.oid) as indexDesc
from pg_catalog.pg_index pi
join pg_catalog.pg_class pct on pct.oid=pi.indrelid
join pg_catalog.pg_class pci on pci.oid=pi.indexrelid
join pg_catalog.pg_attribute pa on pci.oid=pa.attrelid
join pg_catalog.pg_namespace pn on pn.oid=pct.relnamespace
where pn.nspname=?

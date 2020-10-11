INSERT INTO T_SETTINGS
(AUTO, CRON, SCHEMAS,SMD_TYPE)
VALUES
(false,'0 0 0/2 * * ?','bast,kz,pz,log,query','lan');

INSERT INTO T_RULES
(DESC,EXP,MSG,VALID)
VALUES
(
'字段类型只能为C,VC,INT,N,DT,D,CLOB',
'!{"C", "VC", "INT", "N", "DT", "D", "CLOB"}.contains(#colType)',
'不符合规范的字段类型【{colType}】',
true
),
(
'C类型名称必须以C_开头',
'"C".equals(#colType) and !#column.startsWith("C_")',
'C类型名称必须以C_开头',
true
),
(
'C类型长度必须是32',
'"C".equals(#colType) and #colLength!=32',
'C类型长度必须是32,目前长度【{colLength}】',
true
),
(
'VC类型名称必须以C_开头',
'"VC".equals(#colType) and !#column.startsWith("C_")',
'VC类型名称必须以VC_开头',
true
),
(
'VC类型长度必须100,300,600,900',
'"VC".equals(#colType) and !{100, 300, 600, 900}.contains(#colLength)',
'VC类型长度必须是100,300,600,900，目前长度【{colLength}】',
true
),
(
'INT类型名称必须N_开头',
'"INT".equals(#colType) and !#column.startsWith("N_")',
'INT类型名称必须N_开头',
true
),
(
'INT类型无需指定精度',
'"INT".equals(#colType) and !(#colLength==null and #colPoint==null)',
'INT类型无需指定精度，目前精度【({colLength},{colPoint})】',
true
),
(
'N类型名称必须N_开头',
'"N".equals(#colType) and !#column.startsWith("N_")',
'N类型名称必须N_开头',
true
),
(
'N类型精度必须是【(20,4)】',
'"N".equals(#colType) and !(#colLength==20 and #colPoint==4)',
'N类型精度必须是【(20,4)】，目前精度【({colLength},{colPoint})】',
true
),
(
'D类型名称必须D开头RQ结尾',
'"D".equals(#colType) and !(#column.startsWith("D_") and #column.endsWith("RQ"))',
'D类型名称必须D开头RQ结尾',
true
),
(
'D类型长度必须是0',
'"D".equals(#colType) and #colLength!=null',
'D类型长度无需指定长度,目前长度【{colLength}】',
true
),
(
'DT类型名称必须DT开头SJ结尾',
'"DT".equals(#colType) and !(#column.startsWith("DT_") and #column.endsWith("SJ"))',
'DT类型名称必须DT开头SJ结尾',
true
),
(
'DT类型长度必须是3',
'"DT".equals(#colType) and #colLength!=3',
'DT类型长度必须是3,目前长度【{colLength}】',
true
),
(
'CLOB类型名称必须LC_开头',
'"CLOB".equals(#colType) and !#column.startsWith("LC_")',
'CLOB类型名称必须LC_开头',
true
),
(
'索引命名规则',
'#indexName != null and !("I"+#table.substring(1)+#column.substring(#column.indexOf("_"))).equals(#indexName)',
'"索引【"+#indexName+"】命名不对，正确的应该是【I"+#table.substring(1)+#column.substring(#column.indexOf("_"))+"】"',
true
);

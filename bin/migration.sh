if [ -n "$1" ];then
  newSqlFile=api/src/main/resources/db/migration/V`date + %Y%m%d%H%I%S`__${1}.newSqlFile
  touch $newSqlFile
  echo "a new migration script generated at: "$newSqlFile
else
  echo "请输入迁移脚本名称"
fi
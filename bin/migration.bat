@REM call migration.bat
if "" neq "%1" (
@REM     set newSqlFile=src/main/resources/db/migration/%date:~0,4%%date:~5,2%%date:~8,2%%time:~0,2%%time:~3,2%%time:~6,2%__%1.sql
    set newSqlFile=C:\home\project\dsapr-music\src\main\resources\db\migration\V%date:~0,4%%date:~5,2%%date:~8,2%%time:~0,2%%time:~3,2%%time:~6,2%__%1.sql
    echo=>%newSqlFile%
    echo %newSqlFile%
) else (
    echo "请输入迁移脚本名称"
)
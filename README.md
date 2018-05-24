#配置手册

###mysql配置
在根目录下的application.properties里配置mysql
```$xslt
spring.datasource.url=
spring.datasource.driver-class-name=
spring.datasource.username=
spring.datasource.password=
```
分别配置数据库的url，drivername，username，password

其中数据数据库表初始化结构在/src/man/resources/db/schema.sql
一些测试的数据在/src/man/resources/db/data.sql

###使用h2数据库
如果觉得配置mysql麻烦，可以使用h2数据库，这个数据库是一种内存的数据库，
可以模仿mysql形式，使用方法只需要把application.properties注解打开
pom.xml注解打开就可以使用

###访问地址
localhost:8080/index

###excel模板
/src/man/resources/excelTemplate/学生成绩.xls
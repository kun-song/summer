# Summer

An api manager built on spring4 and angular2.

## Maven 镜像

Maven 官方的中央仓库在国内下载速度很慢，建议配置为阿里云的镜像，速度飞起：

```
<mirror>
	<id>alimaven</id>
	<mirrorOf>central</mirrorOf>
	<name>aliyun maven</name>
	<url>http://maven.aliyun.com/nexus/content/repositories/central/</url>
</mirror>
```

## 配置数据源

在 tomcat 的 conf/context.xml 添加如下代码：

```
<Resource
      name = "jdbc/EntityMappings" type = "javax.sql.DataSource"
      maxActive = "20" maxIdle = "5" maxWait = "10000"
      username = "root" password = "329015802"
      driverClass = "com.mysql.jdbc.Driver"
      url = "jdbc:mysql://localhost/EntityMappings"
      />
```

每次创建数据源只需要修改 `name` 为数据库名称，`username` `password` 为实际用户名密码，`url` 为实际数据库地址即可。

## 配置 MySQL 驱动

本实例使用 MySQL 数据库，其驱动程序为 Connector/J，下载之后放在 tomcat 下的 /lib 目录即可。
# Summer

[![Build Status](https://travis-ci.org/satansk/Summer.svg?branch=master)](https://travis-ci.org/satansk/Summer)

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
      driverClassName = "com.mysql.jdbc.Driver"
      url = "jdbc:mysql://localhost/EntityMappings"
      />
```

每次创建数据源只需要修改 `name` 为数据库名称，`username` `password` 为实际用户名密码，`url` 为实际数据库地址即可。

## JPA 配置文件

XML 格式的 JPA 配置文件位于 `src/main/resources/META-INF/persistence.xml` 中，内容如下：

```
<?xml version="1.0" encoding="UTF-8"?>
<persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence
        http://xmlns.jcp.org/xml/ns/persistence/persistence_2_1.xsd"
	version="2.1">

	<!-- 
		1. persistence-unit 定义持久化单元。
		2. name 为持久化单元的名字，用于在代码中定位该单元。
		3. transaction-type 用于指定该持久化单元使用的事务（JTA or 标准的本地事务）
		-->
	<persistence-unit name="EntityMappings" transaction-type="RESOURCE_LOCAL">
		
		<!-- 指定实现 javax.persistance.spi.PersistenceProvider 接口的类的完全限定名，这里使用 Hibernate 实现 -->
		<provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
		
		<!-- 指定数据源 -->
		<non-jta-data-source>
            java:comp/env/jdbc/EntityMappings
    </non-jta-data-source>
    
    <!-- 
    	1. 在 persistence.xml 文件所在类路径上搜索标注了 JPA 注解的类。
    	2. 例如本文件在 META-INF/ 中，构建之后将打包至 WEB-INF/classes 中，则 classes 目录将被搜索 -->
		<exclude-unlisted-classes>false</exclude-unlisted-classes>
		
		<!-- 如何在持久化单元中缓存实体，ENABLE_SELECTIVE 表示只缓存标注了 @Cacheable 注解的实体 -->
		<shared-cache-mode>ENABLE_SELECTIVE</shared-cache-mode>
		
		<!-- 关闭实体上的 Bean 验证 -->
		<validation-mode>NONE</validation-mode>
		
		<properties>
			<!-- 禁用模式生成 -->
			<property name="javax.persistence.schema-generation.database.action" value="none" />
			<!-- 使用 MySQL 方言 -->
			<property name="hibernate.dialect" value="org.hibernate.dialect.MySQLDialect" />
			<!-- 显示 SQL 语句 -->
			<property name="hibernate.show_sql" value="true" />
			<!-- 格式化输出 SQL -->
			<property name="hibernate.format_sql" value="true" />
			<!-- 显示生成 SQL 语句的 HQL 语句 -->
			<property name="hibernate.use_sql_comments" value="true" />
		</properties>
	</persistence-unit>
</persistence>
```

## 区分多个 Spring Data 模块

同一个项目中使用多个 Spring Data 模块，比如 Spring Data Jpa & Spring Data MongoDB，需要通过 `Repository` 定义或领域实体类型做出区分：

1. 若 `Repository` 继承 **模块特有** 的 `Repository` 接口（比如 `MongoRepository`），则属于该模块。
	* 若继承通用 `Repository` 则会造成歧义（比如 `Repository` 和 `CrudRepository`）。
2. 若领域类用 **模块特有** 的注解标注（比如 `@Entiry` 属于 JPA，`@Document` 属于 MongoDB），则属于该模块。
	* 在一个类上同时使用 `@Entity` `@Document` 也会造成歧义。
3. 最后，可以通过指定扫描 `Repository` 的包路径来区分（比如 `@EnableMongoRepositores` 注解的 `basePackage` 属性）。

## 配置 MySQL 驱动

本实例使用 MySQL 数据库，其驱动程序为 Connector/J，下载之后放在 tomcat 下的 /lib 目录即可。

## 开发指南

1. 进入 MongoDB 的 bin 目录，执行 `./mongod -f mongodb.conf &` 启动 MongoDB。
2. Eclipse 中启动 `tomcat`，将 summer 加入 tomcat 容器中。
3. 进入 angular-app 目录，执行 `npm start`，启动前端工程。
	* 注意 `node.js` 版本必须大于 6.9，否则启动报错。
	* 推荐使用 `nvm` 管理 `node.js` 版本。

## Pull Request 流程

1. fork 项目到个人空间
2. clone fork 到个人空间的项目
3. 添加远端仓库：`git remote add satansk git@github.com:satansk/Summer.git`
4. 拉取远端仓库，并合并到本地 `git pull satansk master`
5. 添加代码
6. commit 并且 push 到个人空间（`git push origin master`）
7. Github 个人首页上创建 pull request。

其中前三步是只需第一次设置，后续只需要后三步操作即可满足需求。
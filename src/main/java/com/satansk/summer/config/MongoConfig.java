package com.satansk.summer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

/**
 * MongoDB 配置，MongoTemplate 已经定义在 AbstractMongoConfiguration 中。
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.satansk.summer.site.repository")
public class MongoConfig extends AbstractMongoConfiguration {
	
	private static final String dbName = "Summer";
	private static final String mongoServer = "127.0.0.1";
	private static final int mongoPort = 27017;

	@Override
	protected String getDatabaseName() {
		return dbName;
	}

	@Override
	public Mongo mongo() throws Exception {
		return new MongoClient(mongoServer, mongoPort);
	}
}

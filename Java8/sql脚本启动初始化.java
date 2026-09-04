package com.xsl.meetingservice.customize;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class StartupSqlRunner implements ApplicationRunner {

	private final DataSource dataSource;
	private final Resource sqlScript;

	public StartupSqlRunner(DataSource dataSource, @Value("classpath:aaa.sql") Resource sqlScript) {
		this.dataSource = dataSource;
		this.sqlScript = sqlScript;
	}

	@Override
	public void run(ApplicationArguments args) {
		if (sqlScript == null || !sqlScript.exists()) {
			log.info("aa.sql 不存在，跳过执行");
			return;
		}
		ResourceDatabasePopulator populator = new ResourceDatabasePopulator(sqlScript);
		populator.setContinueOnError(false);
		populator.setIgnoreFailedDrops(true);
		DatabasePopulatorUtils.execute(populator, dataSource);
		log.info("aa.sql 执行完成");
	}
}


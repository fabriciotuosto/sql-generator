package org.sql.runner.guice;

import java.util.Properties;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class ConfigurationModule extends AbstractModule{

	private static final String[] confFiles = {"configuration/application.properties","configuration/database.properties"};
	
	private void bindProperties(Properties prop)
	{
		Names.bindProperties(binder(), prop);
	}

	@Override
	protected void configure() {
		for(String file : confFiles)
		{
			bindPropertiesFile(file);
		}
	}

	private void bindPropertiesFile(String fileName) {
		Properties prop = new Properties();
		try{
			prop.load(ClassLoader.getSystemResourceAsStream(fileName));
			bindProperties(prop);
		}catch(Exception e){
			throw new Error(e);
		}
	}
}

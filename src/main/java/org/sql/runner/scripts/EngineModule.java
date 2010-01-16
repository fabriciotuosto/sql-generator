	package org.sql.runner.scripts;

import org.sql.runner.annotations.Freemarker;
import org.sql.runner.annotations.Velocity;

import com.google.inject.AbstractModule;

public class EngineModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(ScriptEngine.class)
		.annotatedWith(Freemarker.class)
		.to(ScriptEngineFm.class);

		bind(ScriptEngine.class)
		.annotatedWith(Velocity.class)
		.to(ScriptEngineVm.class);
	}

}

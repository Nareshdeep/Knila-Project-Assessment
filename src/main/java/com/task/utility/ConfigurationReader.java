package com.task.utility;

public class ConfigurationReader {

	public static ConfigurationHelper getInstance() throws Exception {
		ConfigurationHelper helper = new ConfigurationHelper();
		return helper;
	}

	private ConfigurationReader() {

	}
}

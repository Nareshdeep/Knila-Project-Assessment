package com.task.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigurationHelper {

	public static Properties p;

	public ConfigurationHelper() throws Exception {

		File file = new File(
				".\\src\\main\\resource\\config\\TestData.properties");
		FileInputStream fis = new FileInputStream(file);
		p = new Properties();
		p.load(fis);

	}

	public static String getProperty(String value) {
		String property = p.getProperty(value);
		return property;
	}

}

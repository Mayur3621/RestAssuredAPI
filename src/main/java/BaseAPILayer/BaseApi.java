package BaseAPILayer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

public class BaseApi {

	public String getProperty(String key) {
		Properties prop = new Properties();
		String path = System.getProperty("user.dir") + "//resources//ApiConfig.properties";
		FileInputStream fio = null;
		try {
			fio = new FileInputStream(path);
			prop.load(fio);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop.getProperty(key);
	}

	public RequestSpecification getRequestSpecification(String basePath) {
		String date = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
		String path = System.getProperty("user.dir") + "//LogsFolder" + date + ".txt";
		FileOutputStream fio = null;
		try {
			fio = new FileOutputStream(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		PrintStream log = new PrintStream(fio);

		return RestAssured.given().baseUri(getProperty("baseuri")).basePath(basePath).log().all()
				.filter(RequestLoggingFilter.logRequestTo(log)).filter(ResponseLoggingFilter.logResponseTo(log));

	}

}

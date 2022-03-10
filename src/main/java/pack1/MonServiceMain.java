package pack1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MonServiceMain {

	public static void main(String args[]) {

		ApplicationContext context = new FileSystemXmlApplicationContext("/src/main/java/springContext.xml");

		MonService monService = (MonService) context.getBean("monService");

		System.out.println(monService.hello("from Spring !"));

	}

}
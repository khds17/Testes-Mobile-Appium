package core;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

public class BaseTest {
	
	@Rule
	public TestName testName = new TestName();
	
	@AfterClass
	public static void finalizarClasse() {
		DriverFactory.killDriver();
	}

	@After
	public void tearDown() {
		gerarScreenShot();
		DriverFactory.getDriver().resetApp();
	}
	
	public void gerarScreenShot() {
		try {
			File imagem = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(imagem, new File("target/screenshots/"+testName.getMethodName()+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void esperar(long tempo) {
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}


package pages;

import static core.DriverFactory.getDriver;

import org.openqa.selenium.By;

import core.BasePage;
import core.DriverFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class FormularioPage extends BasePage {
		
	public void escreverNome(String nome) {
		escrever(MobileBy.AccessibilityId("nome"), nome);
	}
	
	public String obterNome() {
		return obterTexto(MobileBy.AccessibilityId("nome"));
	}
	
	public void selecionarCombo(String valor) {
		selecionarCombo(MobileBy.AccessibilityId("console"), valor);
	}
	
	public String obterValorCombo() {
		return obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
	}
	
	public void clicarCheck() {
		clicar(MobileBy.AccessibilityId("check"));
	}
	
	public void clicarSwitch() {
		clicar(MobileBy.AccessibilityId("switch"));
	}
	
	public boolean isCheckMarcado() {
		return isCheckMarcado(MobileBy.AccessibilityId("check"));
	}
	
	public boolean isSwitchMarcado() {
		return isCheckMarcado(MobileBy.AccessibilityId("switch"));
	}
	
	public void clicarSeekBar(double posicao) {
		int delta = 50;
		MobileElement seek = getDriver().findElement(MobileBy.AccessibilityId("slid"));
		int y = seek.getLocation().y + (seek.getSize().height / 2);
		int xinicial = seek.getLocation().x + delta;
		int x = (int) (xinicial + ((seek.getSize().width - 2*delta) * posicao));
		tap(x, y);
	
	}
	
	public void salvar() {
		clicarPorTexto("SALVAR");
	}
	
	public void salvarDemorado() {
		clicarPorTexto("SALVAR DEMORADO");
	}
	
	public String obterNomeCadastrado() {
		return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Nome:')]"));
	}
	
	public String obterConsoleCadastrado() {
		return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));
	}
	
	public String obterCheckCadastrado() {
		return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]"));
	}
	
	public String obterSwitchCadastrado() {
		return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]"));
	}	
}

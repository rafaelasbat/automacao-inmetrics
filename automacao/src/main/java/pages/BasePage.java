package pages;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

import webdriver.DriverManager;

public class BasePage {

	public static WebDriver driver = DriverManager.getChromeDriver();

	WebDriverWait wait = new WebDriverWait(driver, 50);

	public void waitForPageLoad() {
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	}

	public void click(By by) {

		wait.until(ExpectedConditions.elementToBeClickable(by)).click();
	}

	public String getText(By by) {

		return wait.until(ExpectedConditions.visibilityOfElementLocated(by)).getText();
	}

	public void comboRandom(By by) {
		WebElement comboBoxTipo = driver.findElement(by);
		Select comboBox = new Select(comboBoxTipo);
		int randomIndex = new Random().nextInt(comboBox.getOptions().size());
		comboBox.selectByIndex(randomIndex);
	}

	public List<HashMap<String, String>> verificarGrid(WebElement tabela) {

		List<HashMap<String, String>> userTable = new ArrayList<HashMap<String, String>>();
		List<WebElement> rowElements = tabela.findElements(By.xpath(".//tr"));

		List<String> columnNames = new ArrayList<String>();
		List<WebElement> headerElements = rowElements.get(0).findElements(By.xpath(".//th"));
		headerElements.forEach(headerElement -> columnNames.add(headerElement.getText()));

		for (WebElement rowElement : rowElements) {
			HashMap<String, String> row = new HashMap<String, String>();

			int columnIndex = 0;
			List<WebElement> cellElements = rowElement.findElements(By.xpath(".//td"));
			for (WebElement cellElement : cellElements) {
				row.put(columnNames.get(columnIndex).trim(), cellElement.getText().trim());
				columnIndex++;
			}

			userTable.add(row);

		}

		return userTable;

	}

	public String verificaTipoResultados(String tipoSelecionado) {

		WebElement tabela = driver.findElement(By.xpath("/html/body/div[3]/div[6]/table"));
		List<HashMap<String, String>> grid = verificarGrid(tabela);

		WebElement tipoFiltrado = null;
		String resultado = null;

		for (int linha = 1; linha < grid.size(); linha++) {
			tipoFiltrado = driver
					.findElement(By.xpath("/html/body/div[3]/div[6]/table/tbody/tr[" + linha + "]/td[3]/span"));
			resultado = tipoFiltrado.getText();
			if (tipoSelecionado != resultado) {
				Assert.fail("Os resultados não estão de acordo com o filtro");
			}

		}
		return(resultado);

	}

}

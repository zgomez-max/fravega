package com.fravega.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PaginaHome extends TestBase {


	By buscarHeladeraLocator = By.cssSelector(".InputBar__SearchInput-t6v2m1-1");
	By buscarBtnLocator = By.cssSelector(".InputBar__SearchButton-t6v2m1-2");
	By heladeraTitleLocator = By.cssSelector(".TitleCategory__TitleCategoryStyled-sc-54msxn-0");
	By heladeraLocator = By.cssSelector("li:nth-child(1) li:nth-child(2) h4");
	By checkboxHeladeraFreezerLocator = By.xpath("//a[label[contains(text(),'Heladeras con freezer')]]");
	By checkboxSamsungLocator = By.xpath("//li/a[label[contains(text(),'Samsung')]]");
	By resultadoLocator = By.cssSelector(".listingDesktopstyled__TotalResult-wzwlr8-2 > span");
	By listaHeladeraLocator = By.name("itemsGrid");
	By breadcrumbLocator= By.xpath("//div[@name='breadcrumb']/ul/li[3]");

	public PaginaHome() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void buscarHeladera() throws InterruptedException {
		click(buscarHeladeraLocator);
		if (isDisplayed(buscarHeladeraLocator)) {
			type("Heladera", buscarHeladeraLocator);
			click(buscarBtnLocator);
			Thread.sleep(2000);
		} else {
			System.out.println("No hay resultados que coincidan con tu búsqueda");
		}
	}

  
	public void filtrarHeladeraConFreezer() throws InterruptedException {
		
		if (isDisplayed(heladeraTitleLocator)) {
		
			click(heladeraLocator);
			Thread.sleep(2000);
			click(checkboxHeladeraFreezerLocator);
			Thread.sleep(2000);

		}
	}

	public void filtrarMarcaSamsung() throws InterruptedException {
		click(checkboxSamsungLocator);
		Thread.sleep(2000);
	}

	public int obtenerCantidadResultado() {
		String cantidadText = getText(resultadoLocator);
		return Integer.parseInt(cantidadText);
	}

	public List<WebElement> obtenerListaResultados() {

		return findElements(By.xpath("//ul[@name='itemsGrid']/li"));

	}
   
	public String obtenerBreadCamb() {
		
		return getText(breadcrumbLocator);
		
	}


}

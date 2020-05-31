package com.fravega.ejercicio;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;


import com.fravega.pom.PaginaHome;

public class FrontendTest {



	PaginaHome paginaHome;

	@Before
	public void setUp() throws Exception {
		paginaHome = new PaginaHome();
		paginaHome.chromeDriverConnection();
		paginaHome.cargarUrl("https://www.fravega.com");
	}

	@Test
	public void buscarHeladerasYValidarResultador() {

		try {
			paginaHome.buscarHeladera();
			paginaHome.filtrarHeladeraConFreezer();
			paginaHome.filtrarMarcaSamsung();
			int cantidadResultados = paginaHome.obtenerCantidadResultado();
			List<WebElement> listaResultado = paginaHome.obtenerListaResultados();
			assertEquals(cantidadResultados, listaResultado.size());
			for (int i = 0; i < cantidadResultados; i++) {
				assertTrue(listaResultado.get(i).getText().contains("Samsung"));
			}
			assertEquals("Heladeras con Frezzer", paginaHome.obtenerBreadCamb());
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Fallo");
		}

	}

	@After
	public void tearDown() throws Exception {
		paginaHome.cerrarPagina();
	}
}

# fravega

## requisitos:

- acceso a internet
- cliente git
- java
- maven
- chrome
- selenium WebDriver para chrome

## instrucciones:

- ingresar al directorio y bajar los fuentes del proyecto
- ejecutar el siguiente comando de git
	git clone https://github.com/zgomez-max/fravega.git
- ingresar al directorio del proyecto
	cd fravega
- para correr los test ejecutar el siguiente comando:
	mvn test

**	Se espera que uno de los test falle ya que en el enunciado solicitaban validar que el breadcrumb diga "Heladeras con Frezzer", pero en la pagina actualmente dice "Heladeras "
  
- (opcional) para generar reportes de la ejecucion ejecutar el siguiente comando:

	mvn surefire-report:report

	Esto genera un reporte HTML que queda dentro del directorio "target\site\" y se llama "surefire-report.html".


## referencias:

- git
	https://git-scm.com/doc
- selenium
	https://www.selenium.dev/documentation/en/
- maven
	http://maven.apache.org/guides/getting-started/maven-in-five-minutes.html	

	- pluginscc
		https://maven.apache.org/surefire/maven-surefire-report-plugin/
		https://mvnrepository.com/artifact/org.apache.httpcomponents/httpclient
		https://mvnrepository.com/artifact/org.json/json


## consideraciones:

Se ejecuto las pruebas en:
- Windows 8.1 64bits
- OpenJDK 64-Bit 14.0.1
- Apache Maven 3.6.3
- Chrome 83.0.4103.61 64bits
- Selenium Chrome WebDriver 32bits

Se genero el proyecto utiilzando Eclipse IDE 2020-03

## Configuraciones:

Se debe agregar en la variable PATH los ejecutables de:
- java
- maven
- chromedriver
- git 
- chrome
  

package pom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GuidePage extends Base{
	
	By btn_guide = By.xpath ("/html/body/header/nav/ul/li[1]/a");
	By lbl_tituloGuide = By.xpath ("/html/body/div/main/h2");
	By lbl_gettingAResource = By.xpath ("/html/body/div/main/h3[1]");
	By lbl_listingAllResources = By.xpath ("/html/body/div/main/h3[2]");
	By lbl_creatingAResource = By.xpath ("/html/body/div/main/h3[3]");
	By lbl_updatingAResource = By.xpath ("/html/body/div/main/h3[4]");
	By lbl_patchingAResource = By.xpath ("/html/body/div/main/h3[5]");
	By lbl_deletingAResource = By.xpath ("/html/body/div/main/h3[6]");
	By lbl_filteringResources = By.xpath ("/html/body/div/main/h3[7]");
	By lbl_listingNestedResources = By.xpath ("/html/body/div/main/h3[8]");
	
	public GuidePage(WebDriver driver) {
		super(driver);
	}
	
	//Verifica que el webElement txt_guide exista, en caso de que exista hace click en él, lo que dirige a la sección Guide
	public void goGuidePage() throws InterruptedException 
	{
		
		if(isDisplayed(btn_guide) == true)
		{
			click(btn_guide);
		}
		
		else
		{System.out.println("No se ha encontrado el elemento web.");}
	}
	

	//Consulta si el locator enviado como parámetro está cargado en la página. 
	//De ser así compara el string enviado como parámetro con el texto obtenido del getText del locator. Caso contrario retorna false. 
	//si la comparación es correcta retorna true, caso contrario muestra un print y retorna false.
	public boolean validarTexto (By locator, String string) throws Exception {
		if (isDisplayed(locator)) {
			if (string.equals(getText(locator))){
				return true;
			}
			else
			{
				System.out.println("El texto '" + string + "' no se validó exitosamente.");
				return false;
			}
		}
		return false;
	}
	
	//Crea un array boolean. Valida las labels y guarda el valor booleano en el array. 
	//Luego recorre el array y donde encuentre el primer false retorna false. Caso contrario retorna true. 
	public boolean validarTitulos() throws Exception{
	    List<Boolean> validaciones = new ArrayList<Boolean>();
		validaciones.add((validarTexto(lbl_tituloGuide, "Guide")));
		validaciones.add((validarTexto(lbl_gettingAResource, "Getting a resource")));
		validaciones.add((validarTexto(lbl_listingAllResources, "Listing all resources")));
		validaciones.add((validarTexto(lbl_creatingAResource, "Creating a resource")));
		validaciones.add((validarTexto(lbl_updatingAResource, "Updating a resource")));
		validaciones.add((validarTexto(lbl_patchingAResource, "Patching a resource")));
		validaciones.add((validarTexto(lbl_deletingAResource, "Deleting a resource")));
		validaciones.add((validarTexto(lbl_filteringResources, "Filtering resources")));
		validaciones.add((validarTexto(lbl_listingNestedResources, "Listing nested resources")));
		
		Iterator<Boolean> it = validaciones.iterator();
		
		while(it.hasNext()) {
				if (((boolean) it.next()) != true) {
					return false;
				}
			}
		return true;
		}
}

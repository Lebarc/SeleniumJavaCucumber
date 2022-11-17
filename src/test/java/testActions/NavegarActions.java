package testActions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class NavegarActions {

    public NavegarActions() {
    }

    @FindBy(xpath = "//*[@id='teste']/div/div[2]/div/div[1]/div/div[3]/h5")
    @CacheLookup
    static WebElement BtnTeste;

    @FindBy(xpath = "//*[@id='app']/div/div/div[2]/div/div[1]/div/div[3]/h5")
    @CacheLookup
    static WebElement BtnElements;

    @FindBy(xpath = "//*[@id='app']/div/div/div[2]/div/div[2]/div/div[3]/h5")
    @CacheLookup
    static WebElement BtnForms;

    @FindBy(xpath = "//*[@id='app']/div/div/div[1]/div")
    @CacheLookup
    static WebElement TitleElementsPage;

    @FindBy(xpath = "//*[@id='app']/div/div/div[1]/div")
    @CacheLookup
    static WebElement TitleFormsPage;

    public boolean acessarSite(String url) {
        try {
            utils.ClassDriver.StartDriver();
            utils.ClassDriver.GetInstance().Driver().get(url);
            PageFactory.initElements(utils.ClassDriver.GetInstance().Driver(), this);
            utils.ClassDriver.GetInstance().Driver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        } catch (Exception e) {
            utils.ClassInfo.GetInstance().setLogMessage("Acessar o site -> " + e);
            return false;
        }
        return true;
    }

    public boolean ClicarElements() {
        try {
            if (BtnElements.isDisplayed()) {
                BtnElements.click();
                Thread.sleep(1000);
                return true;
            } else {
                utils.ClassScreenshot.captureScreenshot("ClicarElements");
                utils.ClassInfo.GetInstance().setLogMessage("ClicarElements -> Falha ao clicar em Elements");
                return false;
            }
        } catch (Exception e) {
            utils.ClassInfo.GetInstance().setLogMessage("ClicarElements -> " + e);
        }
        return false;
    }

    public boolean ValidarDirecionamentoParaElementsPage() {
        utils.ClassUtilities.WaitForElementVisible(TitleElementsPage, 20);

        try {
            if (TitleElementsPage.getText().contains("Elements")) {
                return true;
            } else {
                utils.ClassScreenshot.captureScreenshot("ValidarDirecionamentoParaElementsPage");
                utils.ClassInfo.GetInstance().setLogMessage("ValidarDirecionamentoParaElementsPage -> Falha ao visualizar a página Elements");
                return false;
            }
        } catch (Exception e) {
            utils.ClassInfo.GetInstance().setLogMessage("ValidarDirecionamentoParaElementsPage -> " + e);
        }
        return false;
    }

    public boolean ClicarForms() {

        try {
            if (BtnForms.isDisplayed()) {
                BtnForms.click();
                Thread.sleep(1000);
                return true;
            } else {
                utils.ClassScreenshot.captureScreenshot("ClicarForms");
                utils.ClassInfo.GetInstance().setLogMessage("ClicarForms -> Falha ao clicar em Elements");
                return false;
            }
        } catch (Exception e) {
            utils.ClassInfo.GetInstance().setLogMessage("ClicarForms -> " + e);
        }
        return false;
    }

    public boolean ValidarDirecionamentoParaFormsPage() {
        utils.ClassUtilities.WaitForElementVisible(TitleElementsPage, 20);

        try {
            if (TitleFormsPage.getText().contains("Forms")) {
                return true;
            } else {
                utils.ClassScreenshot.captureScreenshot("ValidarDirecionamentoParaFormsPage");
                utils.ClassInfo.GetInstance().setLogMessage("ValidarDirecionamentoParaFormsPage -> Falha ao visualizar a página Forms");
                return false;
            }
        } catch (Exception e) {
            utils.ClassInfo.GetInstance().setLogMessage("ValidarDirecionamentoParaFormsPage -> " + e);
        }
        return false;
    }
}
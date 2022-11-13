package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testActions.NavegarActions;

import static org.junit.Assert.assertTrue;

public class AcessarSiteSteps {

    NavegarActions Navegar = new NavegarActions();

    @Given("Acesso o portal {string}")
    public void acesso_o_portal(String url) {
        Navegar.acessarSite(url);
    }

    @When("Clico em elements")
    public void clicoEmElements() {
        utils.ClassInfo.GetInstance().setResultScenario(Navegar.ClicarElements());
        assertTrue(utils.ClassInfo.GetInstance().getLogMessage(), utils.ClassInfo.GetInstance().getResultScenario());
    }

    @Then("Visualizo a página Elements")
    public void visualizoAPáginaElements() {
        utils.ClassInfo.GetInstance().setResultScenario(Navegar.ValidarDirecionamentoParaElementsPage());
        assertTrue(utils.ClassInfo.GetInstance().getLogMessage(), utils.ClassInfo.GetInstance().getResultScenario());
    }
}
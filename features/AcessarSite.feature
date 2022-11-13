Feature: AcessarSite

  Scenario: Validar o acesso a tela Elements
    Given Acesso o portal "https://demoqa.com/"
    When Clico em elements
    Then Visualizo a página Elements

  Scenario: Validar o acesso a tela Forms
    Given Acesso o portal "https://demoqa.com/"
    When Clico em Forms
    Then Visualizo a página Forms


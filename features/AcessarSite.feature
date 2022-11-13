Feature: AcessarSite

  Scenario: Validar o acesso ao site
    Given Acesso o portal "https://demoqa.com/"
    When Clico em elements
    Then Visualizo a página Elements

#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Scenario connexion
  cette feature test le scénario nominal et le scénario d exception de la connexion formateur et stagiaire

  @tag1
  Scenario: CN formateur
    Given le navigateur s ouvre sur la page de connexion de quizz
    When le formateur entre son identifiant et son mot de passe
    Then il arrive sur la page d accueil et peut administrer

  @tag2
  Scenario: CE formateur
    Given le navigateur s ouvre sur la page de connexion de quizz
    When le formateur entre un identifiant ou un mot de passe errone
    Then la page affiche un message d erreur

  @tag3
  Scenario: CN stagiaire
    Given le navigateur s ouvre sur la page de connexion de quizz
    When le stagiaire entre son identifiant et son mot de passe
    Then il arrive sur la page d accueil et ne peut pas administrer

  @tag4
  Scenario: CE stagiaire
    Given le navigateur s ouvre sur la page de connexion de quizz
    When le stagiaire entre un identifiant ou un mot de passe errone
    Then la page affiche un message d erreur


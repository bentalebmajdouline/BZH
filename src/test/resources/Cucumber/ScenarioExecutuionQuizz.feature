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
Feature: Test de lancement d un quizz
  cette feature test le scénario nominal et le scénario d exception de l execution du quizz

  @tag1
  Scenario: cas nominal termine manuellement
    Given Le stagiaire est bien sur le site et connecte
    When Le stagiaire clique sur un theme affiche
    Then Le stagiaire doit valider les termes du quizz
    And Le stagiaire doit repondre aux questions du quizz
    And Le stagiaire termine manuellement le quizz
    And Le stagiaire est redirige vers le resultat

  @tag2
  Scenario: cas nominal temps ecoule
    Given Le stagiaire est bien sur le site et connecte
    When Le stagiaire clique sur un theme affiche
    Then Le stagiaire doit valider les termes du quizz
    And Le stagiaire doit repondre aux questions du quizz
    And Le temps du quizz se termine
    And Le stagiaire est redirige vers le resultat

  @tag3
  Scenario: cas exception refus termes
    Given Le stagiaire est bien sur le site et connecte
    When Le stagiaire clique sur un theme affiche
    Then Le stagiaire est redirige a la page d accueil

  @tag4
  Scenario: cas exception theme vide
    Given Le stagiaire est bien sur le site et connecte
    When Le stagiaire clique sur un theme affiche vide
    Then Un message d erreur s affiche


@tag
Feature: titre de la feature
  On veut executer le test du cucumber pour acceder a Google.fr

  @tag1
  Scenario: Fonctionalite de recherche
    Given acceder a https://testing.bzh/
    When l utilisateur consulter le catalogue
    Then l affichage de toutes les formations
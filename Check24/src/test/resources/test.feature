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

Feature: check24 using visible labels
	As a customer I want to enter my data and select an insurance
	

	Scenario Outline: lcheck24 by label
	Given I go to page "https://www.check24.de/kfz-versicherung"
	When I click button "Tarife vergleichen"
	And I click button "weiter"
	#And I click link "Versicherung wechseln"
	And I click radio "(HSN / TSN)"
	And I enter "<hsn>" in field "Herstellernummer"
	And I enter "<tsn>" in field "Typschlüsselnummer"
	
	Examples: 
	|hsn|tsn|
	|8566|540|

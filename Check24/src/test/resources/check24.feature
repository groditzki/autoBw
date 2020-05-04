Feature: KFZ-Versicherung check24
	As a customer I want to enter my data and select an insurance
	
@active
	Scenario Outline: login check24
	Given I go to page "https://www.check24.de/kfz-versicherung"
	Then I accept cookies
	When I click button "Tarife vergleichen"
  Then page with title "KFZ-Versicherungsvergleich" is shown 
	When I click radio "Versicherung wechseln" 
	And I click button "weiter"
	Then element with label "Fahrzeugschein" is shown
	When I click radio "Fahrzeugschein"
	And I enter "<hsn>" in field "Herstellernummer"
	#And I enter "<tsn>" in field "Typschlüsselnummer"
	
	Examples: 
	|hsn|tsn|
	|8566|540|
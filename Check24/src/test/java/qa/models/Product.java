package qa.models;

import java.util.List;

public class Product implements java.io.Serializable  {

	//|name|type|monatlichPreis|einmaligPreis|

	public String id;
	


	public String name;
	public String type;
	public String monatlichPreis;
	public String regularMonatlichPreis;
	public String familie;
	public String einmaligPreis;
	public String aktionText;
	public String color;
	public String speicherkapazitaet;
	public String simtype;
	public String intarif;
	public String masterContract;
	public String promotion;
	
	public String getPromotion() {
		return promotion;
	}
	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getAktionText() {
		return aktionText;
	}
	public void setAktionText(String aktionText) {
		this.aktionText = aktionText;
	}
	public String getMasterContract() {
		return masterContract;
	}
	public void setMasterContract(String masterContract) {
		this.masterContract = masterContract;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSpeicherkapazitaet() {
		return speicherkapazitaet;
	}
	public void setSpeicherkapazitaet(String speicherkapazitaet) {
		this.speicherkapazitaet = speicherkapazitaet;
	}
	public String getSimtype() {
		return simtype;
	}
	public void setSimtype(String simtype) {
		this.simtype = simtype;
	}
	public String getIntarif() {
		return intarif;
	}
	public void setIntarif(String intarif) {
		this.intarif = intarif;
	}


	public List<String> options;
	/*
	public enum type {
	    TARIF, OPTION, ENDGERAET, ZUBEHÖR,
	    INKLUSIV_OPTION 
	}
	*/
	
	public Product (String name,String monatlichPreis,String einmaligPreis) {
		this.name = name;
		this.einmaligPreis=einmaligPreis;
		this.monatlichPreis=monatlichPreis;
	}
	public Product () {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getMonatlichPreis() {
		return monatlichPreis;
	}
	public void setMonatlichPreis(String monatlichPreis) {
		if (monatlichPreis != null)
			monatlichPreis=monatlichPreis.replace("€", "");
		this.monatlichPreis = monatlichPreis;
	}
	
	public String getRegularMonatlichPreis() {
		return regularMonatlichPreis;
	}
	public void setRegularMonatlichPreis(String regularMonatlichPreis) {
		if (regularMonatlichPreis != null)
			regularMonatlichPreis=regularMonatlichPreis.replace("€", "");
		this.regularMonatlichPreis = regularMonatlichPreis;
	}
	public String getEinmaligPreis() {
		
		return einmaligPreis;
	}
	public void setEinmaligPreis(String einmaligPreis) {
		if (einmaligPreis != null)
			einmaligPreis=einmaligPreis.replace("€", "");
		this.einmaligPreis = einmaligPreis;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public boolean equals(Object t) {

	    return (t instanceof Product)
	           ? name.equals(((Product)t).getName())
	           : super.equals(t); 
	}
	public List<String> getOptions() {
		return options;
	}
	public void setOptions(List<String> tarifOptions) {
		this.options = tarifOptions;
	}
	public String getFamilie() {
		// TODO Auto-generated method stub
		return familie;
	}
	public void setFamilie(String familie) {
		// TODO Auto-generated method stub
		this.familie=familie;
	}
}

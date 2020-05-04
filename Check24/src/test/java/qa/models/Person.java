package qa.models;

import java.util.Random;

public class Person {
	
	private String customer="Fredy";
	private String anrede="Herr";
	private String title="Dr";
	private String firma="Firma tst";
	private String vorname="Fredy";
	private String lastname="FredyFredy";
	private String street="Bonnerstr";
	private String street_number="111";
	private String city ="bonn";
	private String plz="55555";
	private String email="FMB-Test-GK-Portal@telekom.de";
	private String tele_vorwahl="0228";
	private String tele_durchwahl="123456";
	private String beruf="Selbstständige";
	private String geburtsdatum="01.01.1995";

	private String ausweistype="Pass";
	private String statsangehoerigkeit="Deutschland";
	private String ausweis_nr="012345678";
	private String ausweis_aussstellungsort = "Berlin";
	private String ausweis_gueltigbis = "12.12.2025";

	private String registereintrag = "mit Eintrag";
	private String registernummer = "HRB 6794";
	private String registerort = "AN";
	private String geschaeftstaetigkeit = "Ja";
	private String authorisiertePerson = "Peter Lustig";
	private String umsatzsteuerID = "DE123475223";
	

	private String[] cities ={"Winterscheid","Hamburg","München","Köln","Frankfurt am Main","Stuttgart","Düsseldorf","Dortmund","Essen","Leipzig","Bremen","Dresden","Hannover","Nürnberg","Duisburg","Bochum","Wuppertal","Bielefeld","Bonn","Münster","Karlsruhe","Mannheim","Augsburg","Wiesbaden","Gelsenkirchen","Mönchengladbach","Braunschweig","Chemnitz","Kiel","Aachen","Halle Saale","Magdeburg","Freiburg im Breisgau","Krefeld","Lübeck","Oberhausen","Erfurt","Mainz","Rostock","Kassel","Hagen","Hamm","Saarbrücken","Mülheim an der Ruhr","Potsdam","Ludwigshafen am Rhein","Oldenburg","Leverkusen","Osnabrück","Solingen","Heidelberg","Herne","Neuss","Darmstadt","Paderborn","Regensburg","Ingolstadt","Würzburg","Fürth","Wolfsburg","Offenbach am Main","Ulm","Heilbronn","Pforzheim","Göttingen","Bottrop","Trier","Recklinghausen","Reutlingen","Bremerhaven","Koblenz","Bergisch Gladbach","Jena","Remscheid","Erlangen","Moers","Siegen","Hildesheim","Salzgitter"};
	private String[] ausweistyps = {"Personalausweis","Reisepass","ID-Card","Duldung"};// ,"Aufenthaltsbewilligung","Aufenthaltsgestattung","Aufenthaltserlaubnis","Aufenthaltsberechtigung","Aufenthaltsberichtigung"};	
	private String[] banknumbers = {"DE61503205000001622455:BSCHDEFFXXX","DE61503205000001622455:BSCHDEFFXXX"};
	private static String [] names ={"gnes","Agnieszka","Alexandra","Alina","Alma","Amelie","Andrea","Angela","Angelica","Angelika","Anica","Anika","Anita","Anja","Anna","Annemarie","Annika","Antonia","Beata","Bertha","Bettina","Bianca","Bianka","Britta","Carina","Carla","Carmen","Carola","Carolin","Caroline","Catarina","Catharina","Cathleen","Cathrin","Catrin","Celina","Charlotte","Christa","Christel","Christiane","Christin","Christina","Christine","Cindy","Clara","Claudia","Constanze","Cordula","Corinna","Cornelia","Dörte","Dörthe","Dagmar","Dana","Daniela","Denise","Diana","Dora","Doreen","Doris","Dorothea","Dorothee","Edith","Elena","Elfriede","Elisabeth","Elise","Elke","Ella","Elli","Elly","Elsa","Else","Emilia","Emilie","Emily","Emine","Emma","Erika","Erna","Esther","Eva","Evelin","Eveline","Evelyn","Evelyne","Ewa","Fatma","Filiz","Franziska","Frauke","Frida","Frieda","Friederike","Gabi","Gabriela","Gabriele","Gaby","Gerda","Gertrud","Gesa","Gisela","Grit","Hanna","Hannah","Hannelore","Hatice","Hedwig","Heidi","Heike","Helena","Helene","Helga","Henni","Henny","Herta","Hertha","Hildegard","Ida","Ilka","Ilona","Ilse","Imke","Ina","Ines","Inga","Inge","Ingeborg","Ingrid","Irene","Irina","Iris","Irma","Irmgard","Isabel","Isabell","Isabella","Isabelle","Ivonne","Jacqueline","Jana","Janet","Janett","Janette","Janin","Janina","Janine","Jaqueline","Jasmin","Jeanette","Jeannette","Jennifer","Jenny","Jessica","Jessika","Joanna","Johanna","Judith","Julia","Juliane","Jutta","Käte","Käthe","Karen","Karin","Karina","Karla","Karola","Karolin","Karoline","Katarina","Katarzyna","Katharina","Kathi","Kathie","Kathleen","Kathrin","Kati","Katie","Katja","Katrin","Kerstin","Kim","Kirsten","Kirstin","Klara","Klaudia","Konstanze","Kordula","Korinna","Kornelia","Kristiane","Kristin","Kristina","Kristine","Lara","Larissa","Laura","Lea","Leah","Lena","Leni","Leoni","Leonie","Lidia","Lieselotte","Lili","Lilli","Lilly","Lina","Linda","Lisa","Liselotte","Lotte","Louisa","Louise","Luisa","Luise","Lydia","Magdalena","Maike","Maja","Malgorzata","Mandy","Manja","Manuela","Mareike","Maren","Margarete","Margarethe","Margot","Margrit","Maria","Marianne","Marie","Marina","Marion","Marta","Martha","Martina","Maya","Meike","Melanie","Melina","Melissa","Meta","Metha","Mia","Michaela","Michelle","Minna","Miriam","Mirja","Mirjam","Monika","Monique","Nadin","Nadine","Nadja","Nancy","Natalia","Natalie","Natascha","Nathalie","Neele","Nele","Nicola","Nicole","Nikola","Nina","Olga","Pamela","Patricia","Patrizia","Paula","Peggy","Petra","Ramona","Rebecca","Rebekka","Regina","Renate","Rita","Rosemarie","Ruth","Sabine","Sabrina","Sandra","Sara","Sarah","Saskia","Sibylle","Sigrid","Silke","Silvia","Simone","Sina","Sinah","Sofia","Sofie","Sonja","Sophia","Sophie","Stefanie","Steffi","Stephanie","Susan","Susann","Susanne","Svantje","Svenja","Svetlana","Swantje","Swenja","Swetlana","Sybille","Sylke","Sylvia","Sylwia","Tamara","Tania","Tanja","Tatjana","Tina","Ulrike","Ursula","Uta","Ute","Vanessa","Vera","Verena","Veronica","Veronika","Victoria","Viktoria","Viola","Waltraud","Waltraut","Wera","Wibke","Wiebke","Wilhelmine","Yasemin","Yasmin","Yvonne"};
	
		
	private String iban;
	private String bic;
	
	public static String getRandomeName() {
		Random rand = new Random();
		String aname= names[rand.nextInt(names.length-1)];
		return aname;
	}
	public Person(String pCustomer) {
		this.customer=  "Tst" + pCustomer ;
		this.vorname=  "Tst" + pCustomer;
		setRandomValues();
	}
	public Person() {
		this.customer=  "Tst" + customer ;
		this.vorname=  "Tst" + vorname;
		setRandomValues();
	}
	public void setRandomValues() {
		Random rand = new Random();
		if (customer.endsWith("a"))
			this.anrede="Frau";
		this.lastname=new StringBuffer(this.customer).reverse().toString();
		this.plz= String.valueOf(10000+rand.nextInt((99999 - 11111)));
		this.umsatzsteuerID= "DE123456789";// + String.valueOf(rand.nextInt((999999999 - 100000000) + 1));
		this.registerort=	 cities[rand.nextInt(cities.length-1)];
		this.city= cities[rand.nextInt(cities.length-1)];
		this.ausweis_aussstellungsort=cities[rand.nextInt(cities.length-1)];
		this.street_number=String.valueOf(rand.nextInt((1000 - 1) + 1));
		this.ausweistype= ausweistyps[rand.nextInt(ausweistyps.length -1)];
		this.street= cities[rand.nextInt(cities.length-1)]+"erstr";
		int index = rand.nextInt(banknumbers.length -1);
		this.iban = banknumbers[index].split(":")[0];
		this.bic = banknumbers[index].split(":")[1];
	}
	
	
	public String getBic() {
		return bic;
	}
	public String getIban() {
		return iban;
	}
	
	
	public String getTele_vorwahl() {
		return tele_vorwahl;
	}
	public void setTele_vorwahl(String tele_vorwahl) {
		this.tele_vorwahl = tele_vorwahl;
	}
	public String getTele_durchwahl() {
		return tele_durchwahl;
	}
	public void setTele_durchwahl(String tele_durchwahl) {
		this.tele_durchwahl = tele_durchwahl;
	}
	public String getBeruf() {
		return beruf;
	}
	public void setBeruf(String beruf) {
		this.beruf = beruf;
	}
	public String getGeburtsdatum() {
		return geburtsdatum;
	}
	public void setGeburtsdatum(String geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}
	public String getAusweistype() {
		//System.out.println(">> ausweistype >> " + ausweistype);
		return ausweistype;
		
	}
	public void setAusweistype(String ausweistype) {
		this.ausweistype = ausweistype;
	}
	public String getStatsangehoerigkeit() {
		return statsangehoerigkeit;
	}
	public void setStatsangehoerigkeit(String statsangehoerigkeit) {
		this.statsangehoerigkeit = statsangehoerigkeit;
	}
	public String getAusweis_nr() {
		return ausweis_nr;
	}
	public void setAusweis_nr(String ausweis_nr) {
		this.ausweis_nr = ausweis_nr;
	}
	public String getAusweis_aussstellungsort() {
		return ausweis_aussstellungsort;
	}
	public void setAusweis_aussstellungsort(String ausweis_aussstellungsort) {
		this.ausweis_aussstellungsort = ausweis_aussstellungsort;
	}
	public String getAusweis_gueltigbis() {
		return ausweis_gueltigbis;
	}
	public void setAusweis_gueltigbis(String ausweis_gueltigbis) {
		this.ausweis_gueltigbis = ausweis_gueltigbis;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAnrede() {
		return anrede;
	}
	public void setAnrede(String anrede) {
		this.anrede = anrede;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getVorname() {
		return  vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getLastname() {
		return  lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getStreet_number() {
		return street_number;
	}
	public void setStreet_number(String street_number) {
		this.street_number = street_number;
	}
	public String getCity() {
		
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getRegistereintrag() {
		return registereintrag;
	}
	public void setRegistereintrag(String registereintrag) {
		this.registereintrag = registereintrag;
	}
	public String getRegisternummer() {
		return registernummer;
	}
	public void setRegisternummer(String registernummer) {
		this.registernummer = registernummer;
	}
	public String getRegisterort() {
		return registerort;
	}
	public void setRegisterort(String registerort) {
		this.registerort = registerort;
	}
	public String getGeschaeftstaetigkeit() {
		return geschaeftstaetigkeit;
	}
	public void setGeschaeftstaetigkeit(String geschaeftstaetigkeit) {
		this.geschaeftstaetigkeit = geschaeftstaetigkeit;
	}
	public String getAuthorisiertePerson() {
		return authorisiertePerson;
	}
	public void setAuthorisiertePerson(String authorisiertePerson) {
		this.authorisiertePerson = authorisiertePerson;
	}
	public String getUmsatzsteuerID() {
		return umsatzsteuerID;
	}
	public void setUmsatzsteuerID(String umsatzsteuerID) {
		this.umsatzsteuerID = umsatzsteuerID;
	}
	public String getPlz() {
		return plz;
	}
	public void setPlz(String plz) {
		this.plz=plz;
	}
	public String getFirma() {
		// TODO Auto-generated method stub
		return firma;
	}
	public void setFirma(String firma) {
		// TODO Auto-generated method stub
		this.firma=firma;
	}
	
}

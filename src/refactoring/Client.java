package refactoring;

import java.util.Vector;

public class Client {
 private String nif;
 private String nom;
 private String telefon;
 private Vector<Lloguer> lloguers;

 public Client(String nif, String nom, String telefon) {
 this.nif = nif;
 this.nom = nom;
 this.telefon = telefon;
 this.lloguers = new Vector<Lloguer>();
 }

 public String getNif() { return nif; }
 public String getNom() { return nom; }
 public String getTelefon() { return telefon; }

 public void setNif(String nif) { this.nif = nif; }
 public void setNom(String nom) { this.nom = nom; }
 public void setTelefon(String telefon) {
 this.telefon = telefon;
 }
 public void afegeix(Lloguer lloguer) {
 if (! lloguers.contains(lloguer) ) {
 lloguers.add(lloguer);
 }
 }
 public void elimina(Lloguer lloguer) {
 if (lloguers.contains(lloguer) ) {
 lloguers.remove(lloguer);
 }
 }
 public boolean conte(Lloguer lloguer) {
 return lloguers.contains(lloguer);
 }


 //double total = 0; Exercici 15
 //int bonificacions = 0;
 
 //for (Lloguer lloguer: lloguers) {
 // double quantitat = quantitatPerLloguer(lloguer); //Exercici 6
 //double quantitat = lloguer.quantitat(); //Exercici 7-10
 
 // afegeix lloguers freqüents
 //bonificacions += bonificacionsquantitatPerLloguer(lloguer); //Exercici 11
 // bonificacions += lloguer.bonificacions(); //Exercici 12
 // composa els resultats d'aquest lloguer

 //total += quantitat * 30; Exercici 15
 //}

 // afegeix informació final Exercici 15 i 16
 //return resultat;
 public String informe() {
 return composaCapsalera() +composaDetall() + composaPeu();
 }
 
 public String informeHTML() {
 return composaCapsaleraHTML() + composaDetallHTML() + composaPeuHTML(); // Exercici 20
 }
 public String composaCapsaleraHTML() {
 return "<h1>Informe de lloguers</h1>"+" <p>Informe de lloguers del client <em>" + getNom() + "</em> (<strong>" + getNif()+"</strong>)</p>";
 }
 public String composaPeuHTML() {
 return "<p>Import a pagar: <em>" + importeTotal()+"€</em></p>" +
 "<p>Punts guanyats: <em>"+ importeBonificacions() +"</em></p>";
 }
 public String composaDetallHTML() {
 String resultat = "<table>" + "<tr><td><strong>Marca</strong></td>" + "<td><strong>Model</strong></td>"+ "<td><strong>Import</strong></td></tr>";
 
 for (Lloguer lloguer: lloguers) {
 resultat += "\t" +
 lloguer.getVehicle().getMarca() + "</td><td>"+
 lloguer.getVehicle().getModel() + "</td><td>" +
 (lloguer.quantitat() * 30) + "€" + "</td></td>";
 }
 return resultat + "</table>";
 }
 public String composaCapsalera() {
 return "Informe de lloguers del client " +
 getNom() +
 " (" + getNif() + ")\n";
 }
 public String composaDetall() {
 String resultat ="";
 for (Lloguer lloguer: lloguers) {
 resultat += "\t" +
 lloguer.getVehicle().getMarca() +
 " " +
 lloguer.getVehicle().getModel() + ": " +
 (lloguer.quantitat() * 30) + "€" + "\n";
 }
 return resultat;
 }
 public String composaPeu() {
 return "Import a pagar: " + importeTotal() + "€\n" +
 "Punts guanyats: " + importeBonificacions() + "\n";
 }
 public int importeBonificacions() {
 int bonificacions = 0;
 for (Lloguer lloguer: lloguers) {
 bonificacions += lloguer.bonificacions(); //Exercici 12
 }
 return bonificacions;
 }
 private Vehicle getVehicle() {
	// TODO Auto-generated method stub
	return null;
	}
 public double importeTotal() { //Exercici 15
 double total =0.0;
 for (Lloguer lloguer: lloguers) {
 total += lloguer.quantitat() * 30;
 }
 return total;
 
 }
 public int bonificacionsquantitatPerLloguer(Lloguer lloguer) {
 int bonificacions = 1;

 // afegeix bonificació per dos dies de lloguer de Luxe
 if (lloguer.getVehicle().getCategoria() == Vehicle.LUXE &&
 lloguer.getDies()>1 ) {
 bonificacions ++;
 }
 return bonificacions;
 }
 
 public double quantitatPerLloguer(Lloguer lloguer) {
 double quantitat = 0; 
 // double 
	switch (getVehicle().getCategoria()) {
	case Vehicle.BASIC:
	quantitat += 3;
	if (lloguer.getDies() > 3) {
	quantitat += (lloguer.getDies() - 3) * 1.5;
	}
	break;
	case Vehicle.GENERAL:
	quantitat += 4;
	if (lloguer.getDies() > 2) {
	quantitat += (lloguer.getDies() - 2) * 2.5;
	}
	break;
	case Vehicle.LUXE:
	quantitat += lloguer.getDies() * 6;
	break;
	}
	
	return quantitat;
 }
 
}
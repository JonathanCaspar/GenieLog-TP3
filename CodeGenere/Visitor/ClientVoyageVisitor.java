package Visitor;

import Transit.Voyage.Croisiere;
import Transit.Voyage.Itineraire;
import Transit.Voyage.Vol;

public class ClientVoyageVisitor implements VoyageVisitor {

	@Override
	public void visit(Vol voy) {
		System.out.println(voy.getLieuDepart().getSigle() + "-" + voy.getLieuArrivee().getSigle() + ":[" + voy.getId() + "](" + voy.getDateDepart().toString() + ")("
				+ voy.getDateArrivee().toString() + "|" + voy.getPrix());
		System.out.println(" ");
	}

	@Override
	public void visit(Itineraire voy) {
		System.out.println(voy.getLieuDepart().getSigle() + "-" + voy.getLieuArrivee().getSigle() + ":[" + voy.getId() + "](" + voy.getDateDepart().toString() + ")("
				+ voy.getDateArrivee().toString() + "|" + voy.getPrix());
		System.out.println("Gare Intermediaire:");
		voy.printGareInt();
		System.out.println(" ");
		
	}

	@Override
	public void visit(Croisiere voy) {
		System.out.println(voy.getLieuDepart().getSigle() + "-" + voy.getLieuArrivee().getSigle() + ":[" + voy.getId() + "](" + voy.getDateDepart().toString() + ")("
				+ voy.getDateArrivee().toString() + "|" + voy.getPrix());
		System.out.println("Port Intermediaire:");
		voy.printPortInt();
		System.out.println(" ");
		
	}
}
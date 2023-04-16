package fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.sint.impl.mock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;

import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.joueur_sme.entities.dto.PartieJoueurDTO;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.joueur_sme.impl.ServiceJoueurImpl;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz_sint.modeles.IServiceStatistiqueJoueur;

public class ServiceJoueurMockOk implements IServiceStatistiqueJoueur {

	@Override
	public Collection<PartieJoueurDTO> recupererStatistiques(ServiceJoueurImpl joueur) {
		
		return new ArrayList<>();
	}

	@Override
	public TreeSet<PartieJoueurDTO> trierPartie(Collection<PartieJoueurDTO> parties) {
		
		TreeSet<PartieJoueurDTO> partiesTrier = new TreeSet<>((PartieJoueurDTO partie1, PartieJoueurDTO partie2) -> compare(partie1, partie2));
		partiesTrier.addAll(parties);
		return partiesTrier;
	}
	
	
	public static int compare(PartieJoueurDTO partie1, PartieJoueurDTO partie2) {
		if(partie1.getScore()==partie2.getScore()) {
			return partie1.getScore() - partie2.getScore();
		}
		return partie1.getSeconde()-partie2.getSeconde();
	}

}

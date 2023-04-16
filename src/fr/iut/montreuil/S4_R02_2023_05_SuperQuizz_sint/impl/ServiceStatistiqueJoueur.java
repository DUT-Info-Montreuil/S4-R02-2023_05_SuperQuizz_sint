package fr.iut.montreuil.S4_R02_2023_05_SuperQuizz_sint.impl;

import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;

import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz_sint.modeles.IServiceStatistiqueJoueur;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.joueur_sme.entities.dto.PartieJoueurDTO;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.joueur_sme.impl.ServiceJoueurImpl;

public class ServiceStatistiqueJoueur implements IServiceStatistiqueJoueur {

	@Override
	public Collection<PartieJoueurDTO> recupererStatistiques(ServiceJoueurImpl joueur) {
		Collection<PartieJoueurDTO> parties = joueur.partiesJouée();		
		return parties;
	}

	@Override
	public TreeSet<PartieJoueurDTO> trierPartie(Collection<PartieJoueurDTO> parties) {	
		Comparator<PartieJoueurDTO> comparator = new Comparator<PartieJoueurDTO>() {

			@Override
			public int compare(PartieJoueurDTO partie1, PartieJoueurDTO partie2) {
				if (partie1.getScore() == partie2.getScore()) {
					return partie1.getScore() - partie2.getScore();
				}
				return partie1.getSeconde() - partie2.getSeconde();
			}
		};
		TreeSet<PartieJoueurDTO> partiesTrier = new TreeSet<>(comparator);
		partiesTrier.addAll(parties);
		return partiesTrier;
	}
}

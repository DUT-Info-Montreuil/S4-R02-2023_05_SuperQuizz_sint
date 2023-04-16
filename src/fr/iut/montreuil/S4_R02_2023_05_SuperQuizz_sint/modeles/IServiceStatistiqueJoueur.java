package fr.iut.montreuil.S4_R02_2023_05_SuperQuizz_sint.modeles;


import java.util.Collection;
import java.util.TreeSet;

import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.joueur_sme.entities.dto.PartieJoueurDTO;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.joueur_sme.impl.ServiceJoueurImpl;

public interface IServiceStatistiqueJoueur {
	
	public Collection<PartieJoueurDTO> recupererStatistiques(ServiceJoueurImpl joueur);
	
	public TreeSet<PartieJoueurDTO> trierPartie(Collection<PartieJoueurDTO> parties);
	
}

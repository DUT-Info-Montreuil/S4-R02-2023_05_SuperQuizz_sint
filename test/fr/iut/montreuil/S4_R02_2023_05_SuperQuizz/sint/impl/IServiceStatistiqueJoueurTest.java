package fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.sint.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.TreeSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.joueur_sme.entities.dto.PartieJoueurDTO;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.sint.impl.mock.ServiceJoueurMockOk;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz_sint.impl.ServiceStatistiqueJoueur;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz_sint.modeles.IServiceStatistiqueJoueur;

class IServiceStatistiqueJoueurTest {
	
	IServiceStatistiqueJoueur statistiqueJoueur;
	@BeforeEach
	void setUp(TestInfo testInfo) throws Exception {
		statistiqueJoueur = new ServiceStatistiqueJoueur();
		System.out.println("Appel du test " + testInfo.getDisplayName());
	}

	@Test
	void trierPartieTest() {
//		statistiqueJoueur = new ServiceJoueurMockOk();
		PartieJoueurDTO parti1 = new PartieJoueurDTO(50, 50);
		PartieJoueurDTO parti2 = new PartieJoueurDTO(50, 100);
		PartieJoueurDTO parti3 = new PartieJoueurDTO(100, 50);
		
		Collection<PartieJoueurDTO> partieAttendu = new TreeSet<PartieJoueurDTO>(
				(PartieJoueurDTO partie1, PartieJoueurDTO partie2) -> compare(partie1, partie2));
		partieAttendu.addAll(Arrays.asList(parti1,parti2, parti3 ));
		Collection<PartieJoueurDTO> partieActuelle = new ArrayList<>(Arrays.asList(parti1,parti2, parti3 ));
		assertEquals(partieAttendu, statistiqueJoueur.trierPartie(partieActuelle));
		

	}
	
	public int compare(PartieJoueurDTO partie1, PartieJoueurDTO partie2) {
		if(partie1.getScore()==partie2.getScore()) {
			return partie1.getScore() - partie2.getScore();
		}
		return partie1.getSeconde()-partie2.getSeconde();
	}

	
	
}

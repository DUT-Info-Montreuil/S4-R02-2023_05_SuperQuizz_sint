package fr.iut.montreuil.S4_R02_2023_05_SuperQuizz_sint.modeles;

import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.questionnaire_sme.entities.dto.BilanStatsDTO;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz_sint.entities.BestOfQuestionnaireDTO;
import utils.exceptions.NombreDeFoisJoueExceptions;
import utils.exceptions.NombreReponseExceptions;
import utils.exceptions.PasDeStatsExceptions;

public interface IServiceSuperQuizzQuestionnaire {

    public BestOfQuestionnaireDTO bestOfQuestionnaire(BilanStatsDTO bilanStatsDTO) throws PasDeStatsExceptions, NombreDeFoisJoueExceptions, NombreReponseExceptions;
}

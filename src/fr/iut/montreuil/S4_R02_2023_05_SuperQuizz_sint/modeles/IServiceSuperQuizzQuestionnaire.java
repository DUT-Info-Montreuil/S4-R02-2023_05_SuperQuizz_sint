package fr.iut.montreuil.S4_R02_2023_05_SuperQuizz_sint.modeles;


import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.questionnaire_sme.entities.dto.QuestionnaireDTO;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz_sint.entities.BestOfQuestionnaireDTO;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz_sint.utils.exceptions.NombreDeFoisJoueExceptions;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz_sint.utils.exceptions.NombreReponseExceptions;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz_sint.utils.exceptions.PasDeStatsExceptions;


public interface IServiceSuperQuizzQuestionnaire {

    public BestOfQuestionnaireDTO bestOfQuestionnaire(QuestionnaireDTO questionnaireDTO) throws PasDeStatsExceptions, NombreDeFoisJoueExceptions, NombreReponseExceptions;
}

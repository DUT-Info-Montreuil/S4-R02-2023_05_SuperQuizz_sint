package fr.iut.montreuil.S4_R02_2023_05_SuperQuizz_sint.tests.impl.servicebestofquesionnaire.mock;

import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.questionnaire_sme.entities.dto.QuestionnaireDTO;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz_sint.entities.BestOfQuestionnaireDTO;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz_sint.modeles.IServiceSuperQuizzQuestionnaire;
import utils.exceptions.NombreDeFoisJoueExceptions;
import utils.exceptions.NombreReponseExceptions;
import utils.exceptions.PasDeStatsExceptions;

public class ServiceBestOfQuestionnaireMockStatsVideIncorrect implements IServiceSuperQuizzQuestionnaire {
    @Override
    public BestOfQuestionnaireDTO bestOfQuestionnaire(QuestionnaireDTO questionnaireDTO) throws PasDeStatsExceptions, NombreDeFoisJoueExceptions, NombreReponseExceptions {
        return null;
    }
}

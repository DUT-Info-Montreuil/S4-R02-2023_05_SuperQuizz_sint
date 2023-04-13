package fr.iut.montreuil.S4_R02_2023_05_SuperQuizz_sint.tests.impl.servicebestofquesionnaire.mock;

import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.questionnaire_sme.entities.dto.QuestionnaireDTO;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz_sint.entities.BestOfQuestionnaireDTO;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz_sint.modeles.IServiceSuperQuizzQuestionnaire;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz_sint.utils.exceptions.NombreDeFoisJoueExceptions;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz_sint.utils.exceptions.NombreReponseExceptions;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz_sint.utils.exceptions.PasDeStatsExceptions;

public class ServiceBestOfQuestionnaireMockStatsVideIncorrect implements IServiceSuperQuizzQuestionnaire {

    @Override
    public BestOfQuestionnaireDTO bestOfQuestionnaire(QuestionnaireDTO questionnaireDTO) throws PasDeStatsExceptions, NombreDeFoisJoueExceptions, NombreReponseExceptions {
        throw new PasDeStatsExceptions();
    }
}

package fr.iut.montreuil.S4_R02_2023_05_SuperQuizz_sint.tests.impl.servicebestofquesionnaire.mock;

import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.questionnaire_sme.entities.dto.BilanStatsDTO;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.questionnaire_sme.entities.dto.QuestionDTO;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.questionnaire_sme.entities.dto.QuestionnaireDTO;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.questionnaire_sme.entities.dto.StatsQuestionsDTO;

import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.questionnaire_sme.modeles.IServiceStatsQuestionnaire;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz_sint.entities.BestOfQuestionnaireDTO;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz_sint.modeles.IServiceSuperQuizzQuestionnaire;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz_sint.utils.exceptions.NombreDeFoisJoueExceptions;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz_sint.utils.exceptions.NombreReponseExceptions;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz_sint.utils.exceptions.PasDeStatsExceptions;


import java.util.ArrayList;
import java.util.List;

public class ServiceBestOfQuestionnaireMockCorrect implements IServiceSuperQuizzQuestionnaire {


    @Override
    public BestOfQuestionnaireDTO bestOfQuestionnaire(QuestionnaireDTO questionnaireDTO) throws PasDeStatsExceptions, NombreDeFoisJoueExceptions, NombreReponseExceptions {
        QuestionDTO q1 = new QuestionDTO(1,"Quelle est le président français","Macron","fr",1);
        QuestionDTO q2 = new QuestionDTO(2,"Quel est le meilleur département de l'iut","INFO","fr",1);
        QuestionDTO q3 = new QuestionDTO(3,"Quelle est le pays le plus cool","Yemen","fr",2);
        List<StatsQuestionsDTO> statsQuestions = new ArrayList();
        statsQuestions.add(new StatsQuestionsDTO(1, 7, 5));
        statsQuestions.add(new StatsQuestionsDTO(2, 7, 1));
        statsQuestions.add(new StatsQuestionsDTO(3, 7, 3));
        return new BestOfQuestionnaireDTO(1,9,q2,q1);
    }
}

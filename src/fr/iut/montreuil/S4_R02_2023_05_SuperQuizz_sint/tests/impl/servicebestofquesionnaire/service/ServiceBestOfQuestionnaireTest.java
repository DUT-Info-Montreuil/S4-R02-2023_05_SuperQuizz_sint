package fr.iut.montreuil.S4_R02_2023_05_SuperQuizz_sint.tests.impl.servicebestofquesionnaire.service;

import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.questionnaire_sme.entities.dto.QuestionDTO;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.questionnaire_sme.entities.dto.QuestionnaireDTO;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.questionnaire_sme.entities.dto.StatsQuestionsDTO;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.questionnaire_sme.impl.ServiceStatsQuestionnaireImpl;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.questionnaire_sme.utils.exceptions.IdQuestionnaireIncorrectExeptions;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz_sint.entities.BestOfQuestionnaireDTO;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz_sint.impl.ServiceSuperQuizzQuestionnaireImpl;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz_sint.modeles.IServiceSuperQuizzQuestionnaire;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz_sint.tests.impl.servicebestofquesionnaire.mock.ServiceBestOfQuestionnaireMockCorrect;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz_sint.tests.impl.servicebestofquesionnaire.mock.ServiceBestOfQuestionnaireMockNbDeFoisJoueIncorrect;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz_sint.tests.impl.servicebestofquesionnaire.mock.ServiceBestOfQuestionnaireMockNbReponseIncorrect;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz_sint.tests.impl.servicebestofquesionnaire.mock.ServiceBestOfQuestionnaireMockStatsVideIncorrect;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz_sint.utils.exceptions.NombreDeFoisJoueExceptions;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz_sint.utils.exceptions.NombreReponseExceptions;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz_sint.utils.exceptions.PasDeStatsExceptions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ServiceBestOfQuestionnaireTest {
    private IServiceSuperQuizzQuestionnaire serviceSuperQuizzQuestionnaire;

    public ServiceBestOfQuestionnaireTest() {
    }

    @BeforeEach
    public void init() {
        this.serviceSuperQuizzQuestionnaire= new ServiceSuperQuizzQuestionnaireImpl();
    }

    @Test
    public void ServiceBestOfQuestionnaireCorrect()throws PasDeStatsExceptions, NombreDeFoisJoueExceptions, NombreReponseExceptions {
        ServiceBestOfQuestionnaireMockCorrect serviceCorrect = new ServiceBestOfQuestionnaireMockCorrect();
        QuestionDTO q1 = new QuestionDTO(1,"Quelle est le président français","Macron","fr",1);
        QuestionDTO q2 = new QuestionDTO(2,"Quel est le meilleur département de l'iut","INFO","fr",1);
        QuestionDTO q3 = new QuestionDTO(3,"Quelle est le pays le plus cool","Yemen","fr",2);
        List<StatsQuestionsDTO> statsQuestions = new ArrayList();
        statsQuestions.add(new StatsQuestionsDTO(1, 7, 5));
        statsQuestions.add(new StatsQuestionsDTO(2, 7, 1));
        statsQuestions.add(new StatsQuestionsDTO(3, 7, 3));
        BestOfQuestionnaireDTO StatsCorrect = new BestOfQuestionnaireDTO(1,9,q2,q1);
        List<QuestionDTO> listeQuestions = new ArrayList();
        listeQuestions.add(q1);
        listeQuestions.add(q2);
        listeQuestions.add(q3);
        QuestionnaireDTO questionnaireDTO = new QuestionnaireDTO(1,listeQuestions);
        Assertions.assertEquals(StatsCorrect.toString(), serviceCorrect.bestOfQuestionnaire(questionnaireDTO).toString());

    }

    @Test
    public void ServiceBestOfQuestionnaireNbFoisjoueIncorrect()throws PasDeStatsExceptions, NombreDeFoisJoueExceptions, NombreReponseExceptions {
        ServiceBestOfQuestionnaireMockNbDeFoisJoueIncorrect serviceCorrect = new ServiceBestOfQuestionnaireMockNbDeFoisJoueIncorrect()
                ;
        QuestionDTO q1 = new QuestionDTO(1,"Quelle est le président français","Macron","fr",1);
        QuestionDTO q2 = new QuestionDTO(2,"Quel est le meilleur département de l'iut","INFO","fr",1);
        QuestionDTO q3 = new QuestionDTO(3,"Quelle est le pays le plus cool","Yemen","fr",2);
        List<StatsQuestionsDTO> statsQuestions = new ArrayList();
        statsQuestions.add(new StatsQuestionsDTO(1, 10, 5));
        statsQuestions.add(new StatsQuestionsDTO(2, 7, 1));
        statsQuestions.add(new StatsQuestionsDTO(3, 7, 3));
        BestOfQuestionnaireDTO Stats = new BestOfQuestionnaireDTO(1,9,q2,q1);
        List<QuestionDTO> listeQuestions = new ArrayList();
        listeQuestions.add(q1);
        listeQuestions.add(q2);
        listeQuestions.add(q3);
        QuestionnaireDTO questionnaireDTO = new QuestionnaireDTO(1,listeQuestions);
        Assertions.assertThrows(NombreDeFoisJoueExceptions.class, () -> {
            this.serviceSuperQuizzQuestionnaire.bestOfQuestionnaire(questionnaireDTO);
        });
    }

    @Test
    public void ServiceBestOfQuestionnaireNbReponseIncorrect()throws PasDeStatsExceptions, NombreDeFoisJoueExceptions, NombreReponseExceptions {
        ServiceBestOfQuestionnaireMockNbReponseIncorrect serviceReponseIncorrect = new ServiceBestOfQuestionnaireMockNbReponseIncorrect();
        QuestionDTO q1 = new QuestionDTO(1,"Quelle est le président français","Macron","fr",1);
        QuestionDTO q2 = new QuestionDTO(2,"Quel est le meilleur département de l'iut","INFO","fr",1);
        QuestionDTO q3 = new QuestionDTO(3,"Quelle est le pays le plus cool","Yemen","fr",2);
        List<StatsQuestionsDTO> statsQuestions = new ArrayList();
        statsQuestions.add(new StatsQuestionsDTO(1, 7, 5));
        statsQuestions.add(new StatsQuestionsDTO(2, 7, 9));
        statsQuestions.add(new StatsQuestionsDTO(3, 7, 3));
        BestOfQuestionnaireDTO Stats = new BestOfQuestionnaireDTO(1,9,q2,q1);
        List<QuestionDTO> listeQuestions = new ArrayList();
        listeQuestions.add(q1);
        listeQuestions.add(q2);
        listeQuestions.add(q3);
        QuestionnaireDTO questionnaireDTO = new QuestionnaireDTO(1,listeQuestions);
        Assertions.assertThrows(NombreReponseExceptions.class, () -> {
            this.serviceSuperQuizzQuestionnaire.bestOfQuestionnaire(questionnaireDTO);
        });

    }

    @Test
    public void ServiceBestOfQuestionnaireStatsVides()throws PasDeStatsExceptions, NombreDeFoisJoueExceptions, NombreReponseExceptions {
        ServiceBestOfQuestionnaireMockStatsVideIncorrect serviceStatsvide = new ServiceBestOfQuestionnaireMockStatsVideIncorrect();
        QuestionDTO q1 = new QuestionDTO(1,"Quelle est le président français","Macron","fr",1);
        QuestionDTO q2 = new QuestionDTO(2,"Quel est le meilleur département de l'iut","INFO","fr",1);
        QuestionDTO q3 = new QuestionDTO(3,"Quelle est le pays le plus cool","Yemen","fr",2);
        List<StatsQuestionsDTO> statsQuestions = new ArrayList();
        statsQuestions.add(new StatsQuestionsDTO(1, 0, 0));
        statsQuestions.add(new StatsQuestionsDTO(2, 0, 0));
        statsQuestions.add(new StatsQuestionsDTO(3, 0, 0));
        BestOfQuestionnaireDTO Stats = new BestOfQuestionnaireDTO(1,5,q2,q1);
        List<QuestionDTO> listeQuestions = new ArrayList();
        listeQuestions.add(q1);
        listeQuestions.add(q2);
        listeQuestions.add(q3);
        QuestionnaireDTO questionnaireDTO = new QuestionnaireDTO(1,listeQuestions);
        Assertions.assertThrows(PasDeStatsExceptions.class, () -> {
            this.serviceSuperQuizzQuestionnaire.bestOfQuestionnaire(questionnaireDTO);
        });
    }

}

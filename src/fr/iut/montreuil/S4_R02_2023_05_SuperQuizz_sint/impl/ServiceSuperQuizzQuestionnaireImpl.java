package fr.iut.montreuil.S4_R02_2023_05_SuperQuizz_sint.impl;

import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.questionnaire_sme.entities.dto.BilanStatsDTO;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.questionnaire_sme.entities.dto.QuestionDTO;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.questionnaire_sme.entities.dto.QuestionnaireDTO;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.questionnaire_sme.entities.dto.StatsQuestionsDTO;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz_sint.entities.BestOfQuestionnaireDTO;
import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz_sint.modeles.IServiceSuperQuizzQuestionnaire;
import utils.exceptions.NombreDeFoisJoueExceptions;
import utils.exceptions.NombreReponseExceptions;
import utils.exceptions.PasDeStatsExceptions;

import java.util.ArrayList;
import java.util.List;

public class ServiceSuperQuizzQuestionnaireImpl implements IServiceSuperQuizzQuestionnaire {

    @Override
    public BestOfQuestionnaireDTO bestOfQuestionnaire(QuestionnaireDTO questionnaireDTO) throws PasDeStatsExceptions, NombreDeFoisJoueExceptions, NombreReponseExceptions {
        BestOfQuestionnaireDTO bestOfQuestionnaireDTO = new BestOfQuestionnaireDTO();
        bestOfQuestionnaireDTO.setIdQuestionnaire(questionnaireDTO.getIdQuestionnaire());
        if (questionnaireDTO.getNbDeFoisJoueQuestionnaire() < 0)
            throw new NombreDeFoisJoueExceptions();
        bestOfQuestionnaireDTO.setNbDeFoisJoueQuestionnaire(questionnaireDTO.getNbDeFoisJoueQuestionnaire());

        QuestionDTO meilleurTaux;
        int i = 0;
        do {
            meilleurTaux = questionnaireDTO.getListeQuestions().get(i);
        } while (meilleurTaux.getStatsQuestions().getNbDeFoisJoueQuestion() <= 0);

        for (QuestionDTO questionDTO : questionnaireDTO.getListeQuestions()) {
            if (questionDTO.getStatsQuestions() == null)
                throw new PasDeStatsExceptions();
            if (questionDTO.getStatsQuestions().getNbDeFoisJoueQuestion() > bestOfQuestionnaireDTO.getNbDeFoisJoueQuestionnaire())
                throw new NombreDeFoisJoueExceptions();
            if (questionDTO.getStatsQuestions().getNbDeFoisJoueQuestion() > 0 || questionDTO.getStatsQuestions().getNbDeReussiteQuestion() > questionDTO.getStatsQuestions().getNbDeFoisJoueQuestion())
                throw new NombreReponseExceptions();

            if ((float) questionDTO.getStatsQuestions().getNbDeReussiteQuestion() / questionDTO.getStatsQuestions().getNbDeFoisJoueQuestion() >
                    (float) meilleurTaux.getStatsQuestions().getNbDeReussiteQuestion() / meilleurTaux.getStatsQuestions().getNbDeFoisJoueQuestion()) {
                meilleurTaux = questionDTO;
            } else if ((float) questionDTO.getStatsQuestions().getNbDeReussiteQuestion() / questionDTO.getStatsQuestions().getNbDeFoisJoueQuestion() ==
                    (float) meilleurTaux.getStatsQuestions().getNbDeReussiteQuestion() / meilleurTaux.getStatsQuestions().getNbDeFoisJoueQuestion()) {
                if (questionDTO.getDifficultes() > meilleurTaux.getDifficultes())
                    meilleurTaux = questionDTO;
                else if (questionDTO.getDifficultes() == meilleurTaux.getDifficultes())
                    if (questionDTO.getStatsQuestions().getNbDeFoisJoueQuestion() > meilleurTaux.getStatsQuestions().getNbDeFoisJoueQuestion())
                        meilleurTaux = questionDTO;
                    else if (questionDTO.getStatsQuestions().getNbDeFoisJoueQuestion() == meilleurTaux.getStatsQuestions().getNbDeFoisJoueQuestion())
                        if (questionDTO.getNumQuestion() < meilleurTaux.getNumQuestion())
                            meilleurTaux = questionDTO;
            }

        }
        QuestionDTO pireTaux;
        pireTaux = questionnaireDTO.getListeQuestions().get(i);

        for (QuestionDTO questionDTO : questionnaireDTO.getListeQuestions()) {
            if (questionDTO.getStatsQuestions().getNbDeFoisJoueQuestion() > 0
                    && (float) questionDTO.getStatsQuestions().getNbDeReussiteQuestion() / questionDTO.getStatsQuestions().getNbDeFoisJoueQuestion() <
                    (float) pireTaux.getStatsQuestions().getNbDeReussiteQuestion() / pireTaux.getStatsQuestions().getNbDeFoisJoueQuestion()) {
                pireTaux = questionDTO;
            } else if ((float) questionDTO.getStatsQuestions().getNbDeReussiteQuestion() / questionDTO.getStatsQuestions().getNbDeFoisJoueQuestion() ==
                    (float) pireTaux.getStatsQuestions().getNbDeReussiteQuestion() / pireTaux.getStatsQuestions().getNbDeFoisJoueQuestion()) {
                if (questionDTO.getDifficultes() < pireTaux.getDifficultes())
                    pireTaux = questionDTO;
                else if (questionDTO.getDifficultes() == pireTaux.getDifficultes())
                    if (questionDTO.getStatsQuestions().getNbDeFoisJoueQuestion() > pireTaux.getStatsQuestions().getNbDeFoisJoueQuestion())
                        pireTaux = questionDTO;
                    else if (questionDTO.getStatsQuestions().getNbDeFoisJoueQuestion() == pireTaux.getStatsQuestions().getNbDeFoisJoueQuestion())
                        if (questionDTO.getNumQuestion() < pireTaux.getNumQuestion())
                            pireTaux = questionDTO;
            }
        }

        return bestOfQuestionnaireDTO;
    }
}

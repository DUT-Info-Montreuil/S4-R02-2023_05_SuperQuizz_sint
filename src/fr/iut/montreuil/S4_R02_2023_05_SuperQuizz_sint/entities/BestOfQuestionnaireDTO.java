package fr.iut.montreuil.S4_R02_2023_05_SuperQuizz_sint.entities;


import fr.iut.montreuil.S4_R02_2023_05_SuperQuizz.questionnaire_sme.entities.dto.QuestionDTO;

public class BestOfQuestionnaireDTO {
    private int idQuestionnaire;
    private int nbDeFoisJoueQuestionnaire;
    private QuestionDTO questionPireReussite;
    private QuestionDTO  questionMeilleurReussite;

    public BestOfQuestionnaireDTO(int idQuestionnaire, int nbDeFoisJoueQuestionnaire, QuestionDTO questionPireReussite, QuestionDTO questionMeilleurReussite) {
        this.idQuestionnaire = idQuestionnaire;
        this.nbDeFoisJoueQuestionnaire = nbDeFoisJoueQuestionnaire;
        this.questionPireReussite = questionPireReussite;
        this.questionMeilleurReussite = questionMeilleurReussite;
    }

    public int getIdQuestionnaire() {
        return idQuestionnaire;
    }

    public void setIdQuestionnaire(int idQuestionnaire) {
        this.idQuestionnaire = idQuestionnaire;
    }

    public int getNbDeFoisJoueQuestionnaire() {
        return nbDeFoisJoueQuestionnaire;
    }

    public void setNbDeFoisJoueQuestionnaire(int nbDeFoisJoueQuestionnaire) {
        this.nbDeFoisJoueQuestionnaire = nbDeFoisJoueQuestionnaire;
    }

    public QuestionDTO getQuestionPireReussite() {
        return questionPireReussite;
    }

    public void setQuestionPireReussite(QuestionDTO questionPireReussite) {
        this.questionPireReussite = questionPireReussite;
    }

    public QuestionDTO getQuestionMeilleurReussite() {
        return questionMeilleurReussite;
    }

    public void setQuestionMeilleurReussite(QuestionDTO questionMeilleurReussite) {
        this.questionMeilleurReussite = questionMeilleurReussite;
    }
}


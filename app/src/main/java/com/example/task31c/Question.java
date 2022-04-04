package com.example.task31c;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class Question {

    public static List<Question> questionList = new ArrayList<>();

    String title;
    String firstAnswer;
    String secondAnswer;
    String thirdAnswer;
    String correctAnswer;
    String questionBody;
    Boolean nextQuestion;

    public Question(String title, String questionBody, String firstAnswer, String secondAnswer, String thirdAnswer, String correctAnswer, Boolean nextQuestion) {
        this.title = title;
        this.questionBody = questionBody;
        this.firstAnswer = firstAnswer;
        this.secondAnswer = secondAnswer;
        this.thirdAnswer = thirdAnswer;
        this.correctAnswer = correctAnswer;
        this.nextQuestion = nextQuestion;

    }

    public String getTitle() {
        return title;
    }

    public String getFirstAnswer() {
        return firstAnswer;
    }

    public String getSecondAnswer() {
        return secondAnswer;
    }

    public String getThirdAnswer() {
        return thirdAnswer;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public Boolean getNextQuestion() {
        return nextQuestion;
    }

    public void setNextQuestion(Boolean nextQuestion) {
        this.nextQuestion = nextQuestion;
    }

    public static void addQuestions()
    {

        Question firstQuestion = new Question("This is a Intent Question!","When declaring an Intent what do we need as parameters to go to the next Activity?", "Class, Message", "Context, Class", "Message, Context", "Context, Class", false);
        questionList.add(firstQuestion);
        Question secondQuestion = new Question("This is a View Question","Which is correct to set a TextView's text?", "View.setText()", "View = setText()", "setText.View()", "View.setText()", false);
        questionList.add(secondQuestion);
        Question thirdQuestion = new Question("This is a Type Question","When converting text to a String type what must we do before doing toString()", "String(toString(type))", "toString(type)", "Type.toString()", "Type.toString()", false);
        questionList.add(thirdQuestion);
        Question fourthQuestion = new Question("This is a Intent Question","When using putExtra what are the 2 parameters that are required", "Content, Context", "Param Name, Content", "Type, Content", "Param Name, Content", false);
        questionList.add(fourthQuestion);
        Question fifthQuestion = new Question("This is a View Question","What function allows us to use the View and it's associated id programmatically within our application?", "findViewById(View)", "getViewById()", "thisView()", "findViewById(View)", false);
        questionList.add(fifthQuestion);
    }

    public static List<Question> getQuestions()
    {
        return questionList;
    }

    public static void resetQuestions()
    {
        for (Question question: questionList)
        {
            question.nextQuestion = false;
        }
    }



}

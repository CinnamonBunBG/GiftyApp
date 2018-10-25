package com.gifty.gifty.gifts;


import com.gifty.gifty.questions.AgeQuestion;
import com.gifty.gifty.questions.BudgetQuestion;
import com.gifty.gifty.questions.GenderQuestion;
import com.gifty.gifty.questions.PersonalityQuestion;

public class Gift  {
    public static String gender, age, budget, personality;


    // methods to pass the information to the final class that
    //will display the gift ideas


    public static String getGender() {
        gender = GenderQuestion.obtainGender;
        return gender;
    }


    public static String getAge() {
        age = AgeQuestion.ages;
        return age;
    }


    public static String getBudget() {
        budget = BudgetQuestion.obtainPrice;
        return budget;
    }



    public static String getPersonality() {
        personality = PersonalityQuestion.personality;
        return personality;
    }




}

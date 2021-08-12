package com.gum.minions.minions;

import java.util.ArrayList;

public class MinionSayings {

    private static final ArrayList<String> SingleSayings = new ArrayList<>();

    private static final String[][] MinionSayings = {
            new String[] {"3,2,1","3,2,1","Rock!","Shears!","Ha, I won!", "YOU CHEATED"},
            new String[] {"Have you heard that new song yet?","Not yet, I was too busy working, haha.", "Same!"},
            new String[] {"You're shorter than me!", "We are the same size!!","Yeah right!"},
            new String[] {"Hey!, I'm a <TYPE_MINION> Minion!", "I know", "k"},
            new String[] {"Hey, wanna do something after work?", "When is that?", "Don't know"},
            new String[] {"Have you seen that new superhero movie yet?", "No, I've been working here", "Same!"}};

    public static void init() {
         MinionSaying singleConversation1 = new MinionSaying("I may be shorter than you, but I work for 2!");
         MinionSaying singleConversation2 = new MinionSaying("Hi <PLAYER>!");
         //MinionSaying singleConversation3 = new MinionSaying("Nice armor you have there <PLAYER>!");
         //MinionSaying singleConversation4 = new MinionSaying("Nice sword you have there <PLAYER>!");
         MinionSaying singleConversation3 = new MinionSaying("When is the next break?");
         MinionSaying singleConversation4 = new MinionSaying("This gets boring after awhile.");
         MinionSaying singleConversation5 = new MinionSaying("I'm your favorite, right?");
    }

    public static String[][] returnMinionSayings() {
        return MinionSayings;
    }
    public static int minionSayingsSize() {
        return MinionSayings.length;
    }
    public static int conversationSize(int index) {
        if (index > minionSayingsSize()) return -1;
        return MinionSayings[index].length;
    }

    public static ArrayList<String> returnMinion2(int index) {
        ArrayList<String> minion2 = new ArrayList<>();
        for (int i=0;i<conversationSize(index);i++) {
            if (i % 2 != 0)
                minion2.add(MinionSayings[index][i]);
        }
        return minion2;
    }

    public static ArrayList<String> returnMinion1(int index) {
        ArrayList<String> minion1 = new ArrayList<>();
        for (int i=0;i<conversationSize(index);i++) {
            if (i % 2 == 0)
                minion1.add(MinionSayings[index][i]);
        }
        return minion1;
    }


    public static ArrayList<String> returnSingleSayings() {
        return SingleSayings;
    }

    static class MinionSaying {

        MinionSaying(String conversation) {
            SingleSayings.add(conversation);
        }
    }

}



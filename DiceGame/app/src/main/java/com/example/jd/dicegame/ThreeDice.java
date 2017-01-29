package com.example.jd.dicegame;


public class ThreeDice {

    /*
     * die 1 value
     */
    protected int die1;

    /*
     * die 2 value
     */
    protected int die2;

    /*
     * die 3 value
     */
    protected int die3;

    /*
     * Three numbers are the same
     */
    private final int THREE_SAME = 60;

    /*
     * The dices resulted in the run
     */
    private final int A_RUN  = 40;

    /*
     * User have a pair
     */
    private final int A_PAIR = 20;


    /**
     * Constructor
     * @param s1 dice 1
     * @param s2 dice 2
     * @param s3 dice 3
     */
    public ThreeDice(int s1, int s2, int s3) {
        // This puts the three dice values in ascending order.
        int tmp;
        if (s2 < s1) {
            tmp = s2;
            s2 = s1;
            s1 = tmp;
        }
        if (s3 < s2) {
            tmp = s3;
            s3 = s2;
            s2 = tmp;
        }
        if (s2 < s1) {
            tmp = s2;
            s2 = s1;
            s1 = tmp;
        }
        die1 = s1;
        die2 = s2;
        die3 = s3;
    }

    // Will return true if all scores are the same.
    // This depends on the scores being ordered.
    private boolean threeSame() {
        return (die1 == die3);
    }

    // Will return true if we have a run e.g. "one, two, three",
    // "two, three, four", "three, four, five" or "four, five, six".
    // Again, this depends upon the values being ordered.
    private boolean runOfThree() {
        return (( (die1 + 1) == die2) && ( (die2 + 1) == die3));
    }

    // Will return true if exactly two of the dice are the same.
    // Note this will *not* return true if all the dice are the same.
    // Uses the fact that the die values have been ordered.
    private boolean pair() {
        return (((die1 == die2) || (die2 == die3)) && (die1 != die3));
    }

    // Will return true if dice are all different and they are not a run.
    // Note we don't need to check that die1 != die3 as we have
    // put the scores in order in the constructor.
    private boolean allDifferent() {
        return (!runOfThree() && (die1 != die2) && (die2 != die3));
    }

    /**
     * Get the total score including the extra point
     * @return total score for the throw
     */
    public int getScore() {
        int sumOfThrows = die1 + die2 + die3;
        int score = 0;
        if(threeSame())
            score = sumOfThrows + THREE_SAME;
        else if(runOfThree())
            score = sumOfThrows + A_RUN;
        else if(pair())
            score = sumOfThrows + A_PAIR;
        else
            score = sumOfThrows;
        return score;
    }


    /**
     * Get the text of achievement
     * @return text of achievement
     */
    public String getResult() {
        if (threeSame())
            return "The roll is all the same.";
        else if (runOfThree())
            return "The roll is a run.";
        else if (pair())
            return "The roll is a pair.";
        else
            return "The roll is all different.";
    }

}
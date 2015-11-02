package com.ilya.coding;

public class PrimeSoccer {

    public PrimeSoccer() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Returns the probability that at least one team will have a prime number as its final score
     * @param skillOfTeamA
     * @param skillOfTeamB
     * @return
     */
    public double getProbability(int skillOfTeamA, int skillOfTeamB) {
        // error checking / handling
        if (skillOfTeamA < 0 || skillOfTeamA > 100 || skillOfTeamB < 0 || skillOfTeamB > 100) {
            return -1;
        }

        // init variables
        double probA = skillOfTeamA * 0.01;
        double probB = skillOfTeamB * 0.01;

        return calculateProbability(probA, probB, 3, 2);
    }

    /**
     * Calculates winning probability
     * @param probA
     * @param probB
     * @param index
     * @param numWinning
     * @return
     */
    private double calculateProbability(double probA, double probB, int index, int numWinning) {
        // base cases
        if (index <= 0) {
            return 1;
        }

        if (numWinning <= 0) {
            return 0;
        }

        double winningProb = (probA + probB - probA * probB);

        return winningProb * calculateProbability(probA, probB, index - 1, numWinning - 1)
                + (1 - winningProb) * calculateProbability(probA, probB, index - 1, numWinning);
    }


    public static void main(String[] args) {
        int skillOfTeamA = 50;
        int skillOfTeamB = 50;
        System.out.println("Probability: " + new PrimeSoccer().getProbability(skillOfTeamA, skillOfTeamB));
    }

}

package javaTest;

import java.util.ArrayList;
import java.util.Arrays;

public class ChronoballResult implements Result{
    public ArrayList<Team> teams = new ArrayList<>();
    int[] scoreT1;
    int sumT1 = 0;
    int[] scoreT2;
    int sumT2 = 0;
    int[] scoreT3;
    int sumT3 = 0;
    int[] scoreT4;
    int sumT4 = 0;
    public ChronoballResult(ArrayList<Team> teams, int[] scoreT1, int[] scoreT2, int[] scoreT3, int[] scoreT4){
        this.teams = teams;
        this.scoreT1 = scoreT1;
        this.scoreT2 = scoreT2;
        this.scoreT3 = scoreT3;
        this.scoreT4 = scoreT4;
    }

    @Override
    public Team getWinner() {

        return null;
    }

    @Override
    public int getPointsForTeam(Team t) {

        return 0;
    }

    @Override
    public int getPointsAgainstTeam(Team t) {
        return 0;
    }

    @Override
    public boolean isDraw() {
        return false;
    }

    @Override
    public ArrayList<Team> getTeams() {
        return null;
    }
    public void sumTeamScore(){
        for (int val: scoreT1){
            sumT1 += val;
        }
        for (int val: scoreT2){
            sumT2 += val;
        }
        for (int val: scoreT3){
            sumT3 += val;
        }
        for (int val: scoreT4){
            sumT4 += val;
        }

//    @Override
//    public String toString(){
//        sumTeamScore();
//        String display = "Chronoball Result:\n"+
//                         teams.get(0)+" "+sumT1+"\n"+
//                         teams.get(1)+" "+sumT2+"\n"+
//                         teams.get(2)+" "+sumT3+"\n"+
//                         teams.get(3)+" "+sumT4+"\n"+
//                         "Outcome: ChronoballTeam";
//        return display;
    }
}

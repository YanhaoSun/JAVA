package javaTest;

import java.util.ArrayList;

interface Result {
    Team getWinner();
    int getPointsForTeam(Team t);
    int getPointsAgainstTeam(Team t);
    boolean isDraw();
    ArrayList<Team> getTeams();
}

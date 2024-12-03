package javaTest;

import java.util.ArrayList;

interface League {
    void addResult(Result game);
    void addTeam(Team team);
    ArrayList<Team> getTeams();
}

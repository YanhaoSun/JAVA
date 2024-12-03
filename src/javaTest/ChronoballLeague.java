package javaTest;

import java.util.ArrayList;

public class ChronoballLeague implements  League{
    public ArrayList<Team> teams = new ArrayList<>();
    public ChronoballLeague(){}
    @Override
    public void addResult(Result game) {

    }

    @Override
    public void addTeam(Team team) {
        teams.add(team);
    }
    @Override
    public ArrayList<Team> getTeams(){
        return teams;
    }
    @Override
    public String toString() {
        String display = "";
        for (int i=0; i<teams.size(); i++){
            display += "ChronoballTeam: "+teams.get(i).getName()+" Points ("+teams.get(i).getPointsFor()+") Scored ("+teams.get(i).getLeaguePoints()+")\n";
        }
        return display;
    }
}

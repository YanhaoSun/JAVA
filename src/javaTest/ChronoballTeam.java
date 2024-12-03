package javaTest;

public class ChronoballTeam implements Team{
    public String name;
    public int number;
    private int leaguePoints;
    private int pointsFor;
    private int pointsAgainst;
    public ChronoballTeam(String name, int number){
        this.name = name;
        this.number = number;
        this.leaguePoints = 0;
        this.pointsFor = 0;
        this.pointsAgainst = 0;
    }
    @Override
    public void addResult(Result game) {
        this.pointsFor += game.getPointsForTeam(this);
        this.pointsAgainst += game.getPointsAgainstTeam(this);
        if (game.getWinner() != null && game.getWinner().equals(this)) {
            this.leaguePoints += 4;
        } else if (game.isDraw()) {
            this.leaguePoints += 1;
        }
    }

    @Override
    public int getLeaguePoints() {

        return 0;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getPointsFor() {
        return 0;
    }

    @Override
    public int getPointsAgainst() {
        return 0;
    }
    @Override
    public String toString() {
        return "ChronoballTeam: "+this.name;
    }

    public static void main(String[] args) {
        Team t1 = new ChronoballTeam("Team 1", 6);
        Team t2 = new ChronoballTeam("Team 2", 6);
        Team t3 = new ChronoballTeam("Team 3", 6);
        Team t4 = new ChronoballTeam("Team 4", 6);
        League l = new ChronoballLeague();
        l.addTeam(t1);
        l.addTeam(t2);
        l.addTeam(t3);
        l.addTeam(t4);

        int []score = {1,0,0,0};
        int []zeros = {0,0,0,0};

        Result r = new ChronoballResult(l.getTeams(), score, zeros, zeros, zeros);
        System.out.println(r);

        score = new int[]{0,1,0,0};
        r = new ChronoballResult(l.getTeams(), score, zeros, zeros, zeros);
        System.out.println(r);

        score = new int[]{0,4,1,0};
        r = new ChronoballResult(l.getTeams(), score, zeros, zeros, zeros);
        System.out.println(r);

        score = new int[]{0,1,2,1};
        r = new ChronoballResult(l.getTeams(), score, zeros, zeros, zeros);
        System.out.println(r);
    }
}


public class Game {
    private GameState state;
    private int homeGoals;
    private int awayGoals;

    public Game() {
        this.state = GameState.DIDNTSTART;
        this.homeGoals = 0;
        this.awayGoals = 0;
    }

    public Game(int homeGoals, int awayGoals) {
        this.state = GameState.PLAYING;
        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;
    }

    public Game (Game g){
        this.state = g.getState();
        this.homeGoals = g.getHomeGoals();
        this.awayGoals = g.getAwayGoals();
    }

    public Game clone(Game g){
        return (new Game(g));
    }

    public GameState getState() {
        return this.state;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public int getHomeGoals() {
        return this.homeGoals;
    }

    public void setHomeGoals(int homeGoals) {
        this.homeGoals = homeGoals;
    }

    public int getAwayGoals() {
        return this.awayGoals;
    }

    public void setAwayGoals(int awayGoals) {
        this.awayGoals = awayGoals;
    }

    public String toString(){
        final StringBuffer sb = new StringBuffer("Game: {");
        sb.append("Game State: ").append(state);
        sb.append(", Score: Home ").append(homeGoals);
        sb.append(" vs ");
        sb.append(awayGoals).append(" Away");
        sb.append("}");
        return sb.toString();
    }

    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Game g = (Game) o;
        return (this.state == g.getState() && this.homeGoals == g.getHomeGoals() && this.awayGoals == g.getAwayGoals());
    }

    public void startGame(){
        this.state = GameState.PLAYING;
    }

    public void endGame(){
        this.state = GameState.FINISHED;
    }

    public void homeGoal(){
        if (this.state == GameState.PLAYING) this.homeGoals++;
    }

    public void awayGoal(){
        if (this.state == GameState.PLAYING) this.awayGoals++;
    }

    public String currentScore(){
        StringBuffer sb = new StringBuffer("Current Score: ");
        sb.append(homeGoals).append(" vs ").append(awayGoals);
        return sb.toString();
    }

}

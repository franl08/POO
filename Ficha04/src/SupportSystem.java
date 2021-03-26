import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class SupportSystem {
    private List<SupportRequest> requests;

    public SupportSystem(List<SupportRequest> requests) {
        this.setRequests(requests);
    }

    public SupportSystem() {
        this.requests = new ArrayList<>();
    }

    public SupportSystem(SupportSystem s){
        this.setRequests(s.getRequests());
    }

    public String toString(){
        System.out.println(searchRequest("Jorge", LocalDateTime.of (2020, Month.DECEMBER, 25, 12, 30)));
        StringBuilder sb = new StringBuilder("SupportSystem: ")
                .append(requests).append("\n");
        return sb.toString();
    }

    public boolean equals(Object o){
        if (o == this) return true;
        else if (o == null || o.getClass() != this.getClass()) return false;
        SupportSystem s = (SupportSystem) o;
        return (this.requests.equals(s.getRequests()));
    }

    public SupportSystem clone(){
        return new SupportSystem(this);
    }

    public List<SupportRequest> getRequests() {
        return this.requests;
    }

    public void setRequests(List<SupportRequest> requests) {
        this.requests = new ArrayList<>();
        for (SupportRequest sr : requests) this.requests.add(sr.clone());
    }

    public void insertRequest(SupportRequest sr){
        this.requests.add(sr.clone());
    }

    public int searchRequestIndex(String user, LocalDateTime date){
        int i = 0;
        for (SupportRequest sr : this.requests){
            if (sr.getUser().equals(user) && sr.getDate().equals(date)) return i;
            i++;
        }
        return -1;
    }

    public SupportRequest searchRequest (String user, LocalDateTime date){
        for (SupportRequest sr : this.requests)
            if (sr.getUser().equals(user) && sr.getDate().equals(date)) return sr.clone();
        return null;
    }

    public void solveRequest(SupportRequest sr, String emp, String desc){
        sr.setOpSol(emp);
        sr.setDateSol(LocalDateTime.now());
        sr.setDescSol(desc);
        int index = searchRequestIndex(sr.getUser(), sr.getDate());
        requests.set(index, sr);
    }

    public List<SupportRequest> solved(){
        List<SupportRequest> sol = new ArrayList<>();
        for (SupportRequest sr : this.requests)
            if (!(sr.getOpSol().equals(""))) sol.add(sr);
        return sol;
    }

    public int empSolv (String emp){
        int res = 0;
        for (SupportRequest sr : this.requests)
            if (sr.getOpSol().equals(emp)) res++;
        return res;
    }

    public String topEmp (){
        ArrayList<SupportRequest> copy = new ArrayList<SupportRequest>(this.requests);
        String top = null;
        for (SupportRequest sr : copy)
            if (top == null || empSolv(sr.getOpSol()) > empSolv(top)) top = sr.getOpSol();
        return top;
    }

    public List<SupportRequest> solved(LocalDateTime begin, LocalDateTime end){
        List<SupportRequest> sol = this.solved();
        List<SupportRequest> ans = new ArrayList<>();
        for (SupportRequest sr : sol){
            if (sr.getDateSol().compareTo(begin) >= 0 && sr.getDateSol().compareTo(end) < 0) ans.add(sr);
        }
        return ans;
    }

    public int diffDates(LocalDateTime begin, LocalDateTime end){
        return (int) ChronoUnit.MINUTES.between(begin, end);
    }

    public double averageSolveTime(){
        List<SupportRequest> sol = solved();
        int ac = 0, totTime = 0;
        for (SupportRequest sr : sol){
            totTime += diffDates(sr.getDate(), sr.getDateSol());
            ac++;
        }
        return (double) totTime / ac;
    }

    public double averageSolveTime(LocalDateTime begin, LocalDateTime end){
        List<SupportRequest> sol = solved(begin, end);
        int ac = 0, totTime = 0;
        for (SupportRequest sr : sol){
            totTime += diffDates(sr.getDate(), sr.getDateSol());
            ac++;
        }
        return (double) totTime / ac;
    }

    public SupportRequest longestReq(){
        List<SupportRequest> sol = solved();
        SupportRequest longest = null;
        for (SupportRequest sr : sol)
            if (longest == null || diffDates(longest.getDate(), longest.getDateSol()) < diffDates(sr.getDate(), sr.getDateSol()))
                longest = sr;
        return longest;
    }

    public SupportRequest longestReq(LocalDateTime begin, LocalDateTime end){
        List<SupportRequest> sol = solved(begin, end);
        SupportRequest longest = null;
        for (SupportRequest sr : sol)
            if (longest == null || diffDates(longest.getDate(), longest.getDateSol()) < diffDates(sr.getDate(), sr.getDateSol()))
                longest = sr;
        return longest;
    }

    public SupportRequest shortestReq(){
        List<SupportRequest> sol = solved();
        SupportRequest shortest = null;
        for (SupportRequest sr : sol)
            if (shortest == null || diffDates(shortest.getDate(), shortest.getDateSol()) > diffDates(sr.getDate(), sr.getDateSol()))
                shortest = sr;
        return shortest;
    }

    public SupportRequest shortestReq(LocalDateTime begin, LocalDateTime end){
        List<SupportRequest> sol = solved(begin, end);
        SupportRequest shortest = null;
        for (SupportRequest sr : sol)
            if (shortest == null || diffDates(shortest.getDate(), shortest.getDateSol()) > diffDates(sr.getDate(), sr.getDateSol()))
                shortest = sr;
        return shortest;
    }

}

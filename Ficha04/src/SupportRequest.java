import java.time.LocalDateTime;

public class SupportRequest {
    private String user;
    private LocalDateTime date;
    private String problem;
    private String description;
    private String opSol;
    private LocalDateTime dateSol;
    private String descSol;

    public SupportRequest(String user, LocalDateTime date, String problem, String description, String opSol, LocalDateTime dateSol, String descSol) {
        this.user = user;
        this.date = date;
        this.problem = problem;
        this.description = description;
        this.opSol = opSol;
        this.dateSol = dateSol;
        this.descSol = descSol;
    }

    public SupportRequest(String user, LocalDateTime date, String problem, String description) {
        this.user = user;
        this.date = date;
        this.problem = problem;
        this.description = description;
        this.opSol = "";
        this.dateSol = null;
        this.descSol = "";
    }

    public SupportRequest(String user, LocalDateTime date, String problem) {
        this.user = user;
        this.date = date;
        this.problem = problem;
        this.description = "";
        this.opSol = "";
        this.dateSol = null;
        this.descSol = "";
    }

    public SupportRequest(String user, LocalDateTime date, String problem, String opSol, LocalDateTime dateSol, String descSol) {
        this.user = user;
        this.date = date;
        this.problem = problem;
        this.description = "";
        this.opSol = opSol;
        this.dateSol = dateSol;
        this.descSol = descSol;
    }

    public SupportRequest(String user, LocalDateTime date, String problem, String description, String opSol, LocalDateTime dateSol) {
        this.user = user;
        this.date = date;
        this.problem = problem;
        this.description = description;
        this.opSol = opSol;
        this.dateSol = dateSol;
        this.descSol = "";
    }

    public SupportRequest(String user, LocalDateTime date, String problem, String opSol, LocalDateTime dateSol) {
        this.user = user;
        this.date = date;
        this.problem = problem;
        this.description = "";
        this.opSol = opSol;
        this.dateSol = dateSol;
        this.descSol = "";
    }

    public SupportRequest() {
        this.user = "";
        this.date = null;
        this.problem = "";
        this.description = "";
        this.opSol = "";
        this.dateSol = null;
        this.descSol = "";
    }

    public SupportRequest (SupportRequest s){
        this.user = s.getUser();
        this.date = s.getDate();
        this.problem = s.getProblem();
        this.description = s.getDescription();
        this.opSol = s.getOpSol();
        this.dateSol = s.getDateSol();
        this.descSol = s.getDescSol();
    }

    public String toString(){
        if (this.opSol.equals("")) {
            StringBuilder sb = new StringBuilder("Support Request: {")
                    .append("User: ").append(user)
                    .append(" | Request Date: ").append(date.toString())
                    .append(" | Problem: ").append(problem)
                    .append(" | Description: ").append(description)
                    .append(" | Waiting for solution.")
                    .append("}\n");
            return sb.toString();
        }
        else{
            StringBuilder sb = new StringBuilder("Support Request: {")
                    .append("User: ").append(user)
                    .append(" | Request Date: ").append(date.toString())
                    .append(" | Problem: ").append(problem)
                    .append(" | Description: ").append(description)
                    .append(" | Employee: ").append(opSol)
                    .append(" | Solving Date: ").append(dateSol.toString())
                    .append(" | Solution Description: ").append(descSol)
                    .append("}\n");
            return sb.toString();
        }
    }

    public boolean equals(Object o){
        if (o == this) return true;
        else if (o == null || this.getClass() != o.getClass()) return false;
        SupportRequest s = (SupportRequest) o;
        return (this.user.equals(s.getUser()) && this.date.equals(s.getDate()) && this.problem.equals(s.getProblem()) && this.description.equals(s.getDescription())
                && this.opSol.equals(s.getOpSol()) && this.dateSol.equals(s.getDateSol()) && this.descSol.equals(s.getDescSol()));
    }

    public SupportRequest clone(){
        return new SupportRequest(this);
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public LocalDateTime getDate() {
        return this.date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getProblem() {
        return this.problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOpSol() {
        return this.opSol;
    }

    public void setOpSol(String opSol) {
        this.opSol = opSol;
    }

    public LocalDateTime getDateSol() {
        return this.dateSol;
    }

    public void setDateSol(LocalDateTime dateSol) {
        this.dateSol = dateSol;
    }

    public String getDescSol() {
        return this.descSol;
    }

    public void setDescSol(String descSol) {
        this.descSol = descSol;
    }
}

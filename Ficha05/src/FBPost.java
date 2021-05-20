import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FBPost implements Comparable<FBPost>{
    private int id;
    private String user;
    private LocalDateTime date;
    private String content;
    private int likes;
    private List<String> coms;

    public FBPost(int id, String user, LocalDateTime date, String content, int likes, List<String> coms) {
        this.id = id;
        this.user = user;
        this.date = date;
        this.content = content;
        this.likes = likes;
        this.setComs(coms);
    }

    public FBPost(int id, String user, LocalDateTime date, String content, int likes) {
        this.id = id;
        this.user = user;
        this.date = date;
        this.content = content;
        this.likes = likes;
        this.coms = new ArrayList<>();
    }

    public FBPost(FBPost f){
        this.id = f.getId();
        this.user = f.getUser();
        this.date = f.getDate();
        this.content = f.getContent();
        this.likes = f.getLikes();
        this.setComs(f.getComs());
    }

    public boolean equals(Object o){
        if (this == o) return true;
        else if (o == null || this.getClass() != o.getClass()) return false;
        FBPost f = (FBPost) o;
        return (this.id == f.getId() && this.user.equals(f.getUser()) && this.date.equals(f.getDate()) && this.content.equals(f.getContent())
                && this.likes == f.getLikes() && this.coms.equals(f.getComs()));
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("FBPost: ")
                .append("Post ID: ").append(id)
                .append(" | Username: ").append(user)
                .append(" | Post Date: ").append(date)
                .append(" | Content: ").append(content)
                .append(" | Likes: ").append(likes)
                .append(" | Comments: ").append(coms.toString())
                .append("\n");
        return sb.toString();
    }

    public FBPost clone(){
        return new FBPost(this);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLikes() {
        return this.likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public List<String> getComs() {
        return this.coms;
    }

    public void setComs(List<String> coms) {
        this.coms = new ArrayList<>();
        this.coms.addAll(coms);
    }

    public int compareTo(FBPost o) {
        return this.date.compareTo(o.getDate());
    }
}
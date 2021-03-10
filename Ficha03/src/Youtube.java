import java.util.ArrayList;
import java.util.Date;

public class Youtube {
    private String videoName;
    private long content;
    private Date upDate;
    private int resolution;
    private int durMin;
    private int durSec;
    private ArrayList<String> comments;
    private int likes;
    private int dislikes;

    public Youtube(String videoName, long content, Date upDate, int resolution, int durMin, int durSec, ArrayList<String> comments, int likes, int dislikes) {
        this.videoName = videoName;
        this.content = content;
        this.upDate = upDate;
        this.resolution = resolution;
        this.durMin = durMin;
        this.durSec = durSec;
        this.comments = new ArrayList<String>(comments.size());
        for (String comm : comments) this.comments.add(comm);
        this.likes = likes;
        this.dislikes = dislikes;
    }

    public Youtube(Youtube y){
        this.videoName = y.getVideoName();
        this.content = y.getContent();
        this.upDate = y.getUpDate();
        this.resolution = y.getResolution();
        this.durMin = y.getDurMin();
        this.durSec = y.getDurSec();
        this.comments = new ArrayList<String>(y.comments.size());
        for (String comm : y.comments) this.comments.add(comm);
        this.likes = y.getLikes();
        this.dislikes = y.getDislikes();
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public long getContent() {
        return content;
    }

    public void setContent(long content) {
        this.content = content;
    }

    public Date getUpDate() {
        return upDate;
    }

    public void setUpDate(Date upDate) {
        this.upDate = upDate;
    }

    public int getResolution() {
        return resolution;
    }

    public void setResolution(int resolution) {
        this.resolution = resolution;
    }

    public int getDurMin() {
        return durMin;
    }

    public void setDurMin(int durMin) {
        this.durMin = durMin;
    }

    public int getDurSec() {
        return durSec;
    }

    public void setDurSec(int durSec) {
        this.durSec = durSec;
    }

    public ArrayList<String> getComments() {
        return comments;
    }

    public void setComments(ArrayList<String> comments) {
        this.comments = new ArrayList<String>(comments.size());
        for (String comm : comments) this.comments.add(comm);
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public String toString(){
        final StringBuffer sb = new StringBuffer("Video: {");
        sb.append("Name: ").append(videoName);
        sb.append(", Content: ").append(content);
        sb.append(", UpDate: ").append(upDate.toString());
        sb.append(", Resolution: ").append(resolution);
        sb.append(", Duration: ").append(durMin);
        sb.append(":").append(durSec);
        sb.append(", Comments: ").append(comments);
        sb.append(", Likes: ").append(likes);
        sb.append(", Dislikes: ").append(dislikes);
        sb.append("}");
        return sb.toString();
    }

    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Youtube y = (Youtube) o;
        return (this.getVideoName().equals(y.getVideoName()) && this.getContent() == y.getContent() && this.getUpDate() == y.getUpDate() && this.getResolution() == y.getResolution()
                && this.getDurMin() == y.getDurMin() && this.getDurSec() == y.getDurSec() && this.getComments().toString().equals(y.getComments().toString()) && this.getLikes() == y.getLikes()
                && this.getDislikes() == y.getDislikes());
    }

    public void insertComment(String comment){
        this.comments.add(comment);
    }

    public long daysLater(){
        Date today = new Date();
        long dif = today.getTime() - this.upDate.getTime();
        return (dif) / (24 * 60 * 60 * 1000);
    }

    public void thumbsUp(){
        this.likes++;
    }

    public String process(){
        return("" + this.content);
    }
}

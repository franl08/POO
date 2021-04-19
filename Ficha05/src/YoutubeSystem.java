import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class YoutubeSystem {
    public Map<String, Youtube> videos;

    public YoutubeSystem(){
        this.videos = new HashMap<>();
    }

    public YoutubeSystem(Map<String, Youtube> videos){
        this.setVideos(videos);
    }

    public YoutubeSystem(YoutubeSystem ys){
        this.setVideos(ys.getVideos());
    }

    public Map<String, Youtube> getVideos(){
        return this.videos.entrySet().stream().collect(Collectors.toMap(t -> t.getValue().getContent(), t -> t.getValue()));
    }

    public void setVideos(Map<String, Youtube> m){
        this.videos = new HashMap<>();
        for(Map.Entry<String, Youtube> x : m.entrySet())
            this.videos.put(x.getKey(), x.getValue().clone());
    }

    public void addVideo(Youtube y){
        this.videos.put(y.getContent(), y.clone());
    }

    public Youtube getVideo(String content){
        return this.videos.get(content).clone();
    }

    public void removeVideo(String content){
        this.videos.remove(content);
    }

    public void addLike(String content){
        this.videos.get(content).thumbsUp();
    }

    public String topLikes(){
        int maxLikes = Integer.MIN_VALUE;
        String ans = "";
        for(Map.Entry<String, Youtube> m : this.videos.entrySet())
            if(m.getValue().getLikes() > maxLikes){
                maxLikes = m.getValue().getLikes();
                ans = m.getKey();
            }
        return ans;
    }

    public String topLikes(Date start, Date end){
        int maxLikes = Integer.MIN_VALUE;
        String ans = "";
        for(Map.Entry<String, Youtube> m : this.videos.entrySet())
            if(m.getValue().getUpDate().after(start)  && m.getValue().getUpDate().before(end) && m.getValue().getLikes() > maxLikes) {
                maxLikes = m.getValue().getLikes();
                ans = m.getKey();
            }
        return ans;
    }

    public Youtube longerVideo(){
        int maxMin = 0;
        int maxSec = 0;
        Youtube ans = null;
        for(Map.Entry<String, Youtube> m : this.videos.entrySet()) {
            if (m.getValue().getDurMin() > maxMin) {
                maxMin = m.getValue().getDurMin();
                maxSec = m.getValue().getDurSec();
                ans = m.getValue();
            } else if (m.getValue().getDurMin() == maxMin && m.getValue().getDurSec() > maxSec) {
                maxMin = m.getValue().getDurMin();
                maxSec = m.getValue().getDurSec();
                ans = m.getValue();
            }
        }
        return ans;
    }
}

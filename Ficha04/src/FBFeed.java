import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FBFeed {
    private List<FBPost> feed;

    public FBFeed (List<FBPost> l){
        this.setFeed(l);
    }

    public FBFeed(FBFeed f){
        this.setFeed(f.getFeed());
    }

    public boolean equals(Object o){
        if (o == this) return true;
        else if (o == null || this.getClass() != o.getClass()) return false;
        FBFeed f = (FBFeed) o;
        return (f.getFeed().equals(f.getFeed()));
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("FBFeed: ")
                .append(feed).append("\n");
        return sb.toString();
    }

    public FBFeed clone(){
        return new FBFeed(this);
    }

    public List<FBPost> getFeed() {
        return this.feed.stream().map(FBPost::clone).collect(Collectors.toList());
    }

    public void setFeed(List<FBPost> feed) {
        this.feed = feed.stream().map(FBPost::clone).collect(Collectors.toCollection(ArrayList::new));
    }

    public int nrPosts(String user){
        return (int) this.feed.stream().filter(feed -> feed.getUser().equals(user)).count();
    }

    public List<FBPost> postsOf(String user){
        return this.feed.stream().filter(feed -> feed.getUser().equals(user)).collect(Collectors.toList());
    }

    public List<FBPost> postsOf(String user, LocalDateTime begin, LocalDateTime end){
        return this.feed.stream().filter(feed -> feed.getUser().equals(user) && feed.getDate().compareTo(begin) >= 0 && feed.getDate().compareTo(end) < 0).collect(Collectors.toList());
    }

    public FBPost getPost (int id){
        for (FBPost f : this.feed)
            if (f.getId() == id) return f;
        return null;
    }

    public void comment(FBPost post, String com){
        post.getComs().add(com);
    }

    public void comment (int postID, String com){
        comment(getPost(postID), com);
    }

    public void like (FBPost post){
        post.setLikes(post.getLikes() + 1);
    }

    public void like(int postID){
        like(getPost(postID));
    }

    public List<Integer> top5CommentsE(){
        ArrayList<FBPost> copy = new ArrayList<>(this.feed);
        List<Integer> top5 = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            FBPost mostcommented = null;
            for (FBPost f : copy)
                if (mostcommented == null || mostcommented.getComs().size() < f.getComs().size())
                    mostcommented = f;
            top5.add(mostcommented.getId());
            copy.remove(mostcommented);
        }
        return top5;
    }

    public List<Integer> top5CommentsI(){
        return this.feed.stream().sorted((Comparator<FBPost>) (p1,p2) -> p2.getComs().size() - p1.getComs().size()).limit(5).map(FBPost::getId).collect(Collectors.toList());
    }
}

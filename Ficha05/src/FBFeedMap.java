import java.time.LocalDateTime;
import java.util.*;

public class FBFeedMap {
    Map<String, List<FBPost>> posts;

    public FBFeedMap(Map<String, List<FBPost>> posts){
        this.setPosts(posts);
    }

    public void setPosts(Map<String, List<FBPost>> posts){
        this.posts = new HashMap<>();
        if(posts != null)
            for(String s : posts.keySet()){
                List<FBPost> ps = posts.get(s);
                List<FBPost> toAdd = new ArrayList<>();
                for(FBPost fp : ps)
                    toAdd.add(fp.clone());
                this.posts.put(s, toAdd);
            }
    }

    public Map<String, List<FBPost>> getPosts(){
        Map<String, List<FBPost>> ans = new HashMap<>();
        if(this.posts != null)
            for(String s : this.posts.keySet()){
                List<FBPost> ps = posts.get(s);
                List<FBPost> toAdd = new ArrayList<>();
                for(FBPost fp : ps)
                    toAdd.add(fp.clone());
                ans.put(s, toAdd);
            }
        return ans;
    }

    public void addPost(String user, FBPost post){
        if(this.posts == null){
            this.posts = new HashMap<>();
            List<FBPost> toAdd = new ArrayList<>();
            toAdd.add(post.clone());
            this.posts.put(user, toAdd);
        }
        else if(this.posts.containsKey(user)){
            List<FBPost> ps = this.posts.get(user);
            ps.add(post.clone());
        }
        else{
            List<FBPost> toAdd = new ArrayList<>();
            toAdd.add(post.clone());
            this.posts.put(user, toAdd);
        }
    }

    public void removePosts(String user, LocalDateTime di, LocalDateTime df){
        if(this.posts == null || !this.posts.containsKey(user)) return;
        List<FBPost> userPosts = this.posts.get(user);
        userPosts.removeIf(f -> f.getDate().isBefore(di) || f.getDate().isAfter(df));
    }

    public int postsNumPeriodo(LocalDateTime di, LocalDateTime df){
        int ans = 0;
        if(this.posts != null){
            for(String s : this.posts.keySet()){
                List<FBPost> tmp = this.posts.get(s);
                for(FBPost f : tmp)
                    if(f.getDate().isAfter(di) && f.getDate().isBefore(df)) ans++;
            }
        }
        return ans;
    }

    public String utilizadorMaisActivo(LocalDateTime di, LocalDateTime df){
        String ans = "n/a";
        int max = 0;
        if(this.posts != null)
            for(String s : this.posts.keySet()){
                int tmp = 0;
                List<FBPost> ps = this.posts.get(s);
                for(FBPost f : ps)
                    if(f.getDate().isBefore(df) && f.getDate().isAfter(di))
                        tmp++;
                if(tmp > max){
                    max = tmp;
                    ans = s;
                }
            }
        return ans;
    }

    public List<FBPost> timelineGlobal(){
        List<FBPost> ans = new ArrayList<>();
        for(String s : this.posts.keySet()){
            List<FBPost> tmp = this.posts.get(s);
            for(FBPost f : tmp)
                ans.add(f.clone());
        }
        Collections.sort(ans);
        return ans;
    }

    public boolean validaPostsSimultaneos(){
        for(String s : this.posts.keySet()){
            List<FBPost> tmp = this.posts.get(s);
            for(int i = 0; i < tmp.size(); i++)
                for(int j = i + 1; j < tmp.size(); j++)
                    if(tmp.get(i).getDate().isEqual(tmp.get(j).getDate())) return false;
        }
        return true;
    }
}

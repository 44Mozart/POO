
/**
 * Escreva a descrição da classe FBFeed aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.Iterator;
import java.util.TreeSet;

public class FBFeed
{
    private List<FBPost> feed;
    
    public FBFeed (){
        this.feed = new ArrayList<>();
    }
    
    public FBFeed (List<FBPost> feed){
        setFeed(feed);
    }
    
    public FBFeed (FBFeed f){
        setFeed(f.getFeed());
    }
    
    public void setFeed(List<FBPost> feed){
        this.feed = new ArrayList<>();
        for(FBPost post: feed){
            this.feed.add(post.clone());
        }
    }
    
    public List<FBPost> getFeed(){
        ArrayList aux = new ArrayList<>();
        for(FBPost post: this.feed){
            aux.add(post.clone());
        }
        return aux;
    }
    
    public int nrPost(String user){
        return (int) this.feed.stream()   
                         .filter(p -> p.getUser().equals(user))
                         .count();
    }
    
    public List<FBPost> postsOf (String user){
        return this.feed.stream()
                   .filter(p -> p.getUser().equals(user))
                   .collect(Collectors.toList());
    }
    
    public List<FBPost> postsOf (String user, LocalDate inicio, LocalDate fim){
        return this.feed.stream()
                   .filter(p -> p.getUser().equals(user) 
                           && p.getHora().isAfter(inicio) 
                           && p.getHora().isBefore(fim))
                   .collect(Collectors.toList());
    }
    
    public FBPost getPost(int id){
        FBPost post = new FBPost();
        boolean flag = false;
        Iterator<FBPost> p = this.feed.iterator();
        while(p.hasNext() && !flag){
            post = p.next();
            if(post.getId() == id){
                flag = true;
            }
        }
        return post.clone();
    }
    
    public void comment (FBPost post, String comentario){
        post.addComentario(comentario);
    }
    
    public void comment (int postid, String comentario){
        comment(getPost(postid),comentario);
    }
    
    public void like (FBPost post){
        post.addLike();
    }
    
    public void like (int postid){
        like(getPost(postid));
    }
    
    public List<Integer> top5CommentsE(){
        TreeSet<FBPost> t = new TreeSet<>();
        
        for(FBPost p: this.feed){
            t.add(p);
        }
        
        ArrayList<Integer> nova = new ArrayList<>();
        Iterator<FBPost> it = t.iterator();
        int i = 0;
        
        while(i < 5 && it.hasNext()){
            nova.add(it.next().getId());
            i++;
        }
        
        return nova;
    }
    
    public List<Integer> top5CommentsI(){
        return this.feed.stream()
                   .sorted().limit(5)
                   .map(FBPost::getId)
                   .collect(Collectors.toList());
    }
}

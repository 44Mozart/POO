

/**
 * Escreva a descrição da classe FBPost aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class FBPost
{
    private int id;
    private String user;
    private LocalDate hora;
    private String cont;
    private int like;
    private List<String> comentarios;
    
    public FBPost (){
        this.id = 0;
        this.user = new String();
        this.hora = LocalDate.now();
        this.cont = new String();
        this.like = 0;
        this.comentarios = new ArrayList<>();
    }
    
    public FBPost (int id, 
                   String user,
                   LocalDate hora,
                   String cont, 
                   int like, 
                   List<String> comentarios){
        this.id = id;
        this.user = user;
        this.hora = hora;
        this.cont = cont;
        this.like = like;
        setComentarios(comentarios);
    }
    
    public FBPost (FBPost f){
        this.id = f.id;
        this.user = f.user;
        this.hora = f.hora;
        this.cont = f.cont;
        this.like = f.like;
        setComentarios(f.getComentarios());
    }
    
    public void setId (int id){
        this.id = id;
    }
    
    public int getId (){
        return this.id;
    }
    
    public void setUser (String user){
        this.user = user;
    }
    
    public String getUser (){
        return this.user;
    }
    
    public void setHora (LocalDate hora){
        this.hora = hora;
    }
    
    public LocalDate getHora (){
        return this.hora;
    }
  
    public void setCont (String cont){
        this.user = user;
    }
    
    public String getCont (){
        return this.cont;
    }
    
    public void setLike (int like){
        this.like = like;
    }
    
    public int getLike (){
        return this.like;
    }
    
    public void setComentarios(List<String> comentarios){
        this.comentarios = new ArrayList<>();
        for(String l: comentarios){
            this.comentarios.add(l);
        }
    }
    
    public List<String> getComentarios (){
        ArrayList <String> aux = new ArrayList<>();
        for(String l: this.comentarios){
            aux.add(l);
        }
        return aux;
    }
    
    public void addComentario (String com){
        this.comentarios.add(com);
    }
    
    public void addLike(){
        this.like++;
    }
    
    public FBPost clone(){
        return new FBPost(this);
    }
    
    public boolean equals(Object o){
        if(o == this) return true;
        if(o == null || o.getClass() != this.getClass()) return false;
        FBPost f = (FBPost) o;
        return this.id == f.getId() &&
               this.user.equals(f.getUser()) &&
               this.hora.equals(f.getHora()) &&
               this.cont.equals(f.getCont()) &&
               this.like == f.getLike() &&
               this.comentarios.equals(f.getComentarios());
    }
    
    public int compareTo (FBPost p){
        int i = p.comentarios.size();
        int j = this.comentarios.size();
        return i-j;
    }
}

package Blog;

import java.util.ArrayList;

public class Blog {
    private static ArrayList<Post> posts;
    private static Repository repository;
    public Blog(Repository repo){
        repository = repo;
        posts= new ArrayList<Post>();
    }
    public boolean postEntry(Post entry){
        System.out.println("The post "+ entry+" will be posted on blog");
       return repository.savePost(entry);
    }
    public boolean deleteExistingEntry(Post toDelete){
        System.out.println("The post "+ toDelete.getTitle() + " will be deleted from blog" );
       return repository.deletePost(toDelete);
    }
    public ArrayList<Post> showTenRecentEntries(){
        try {
            System.out.println("Connecting to the Repository...");
            posts = repository.showTenRecentEntries();
            return posts;
        }catch (Exception e){
            System.out.println("Error: Couldn't connect to the Repository");
            return posts;
        }
    }
}

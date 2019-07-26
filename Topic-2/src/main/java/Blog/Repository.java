package Blog;

import java.util.ArrayList;

public interface Repository {

    boolean savePost(Post post);
    boolean deletePost(Post post);
    ArrayList<Post> showTenRecentEntries();
}

package Blog;

public class Post {
    private static String title;
    private static String content;
    public Post(){
        title = new String();
        content = new String();
    }
    public static void setTitle(String title) {
        Post.title = title;
    }
    public static void setContent(String content) {
        Post.content = content;
    }
    public static String getTitle(){
        return title;
    }
}

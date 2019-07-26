package Blog;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BlogTest {
    @Mock
    Repository mockRepository = mock(Repository.class);

    //Post a new entry
    @Test
    public void whenAPostIsUploadedThenTheItIsSavedOnRepository(){
        Post post = new Post();
        post.setTitle("Title");
        post.setContent("Content");
        //It means that the post was saved successfully
        //Mock behaviour
        when(mockRepository.savePost(post)).thenReturn(true);
        Blog blog = new Blog(mockRepository);
        //Checks the post was saved successfully
        Assert.assertTrue(blog.postEntry(post));
        //Verifies the method was called
        Mockito.verify(mockRepository).savePost(post);
    }
    //Delete an existing post
    @Test
    public void whenAPostIsDeletedTheItIsErasedFromTheRepository(){
        Post post = new Post();
        post.setTitle("Title");
        post.setContent("Content");
        //Mock behaviour
        when(mockRepository.deletePost(post)).thenReturn(true);
        Blog blog = new Blog(mockRepository);
        //Checks the blog was deleted
        Assert.assertTrue(blog.deleteExistingEntry(post));
        //Verifies the method was called
        Mockito.verify(mockRepository).deletePost(post);
    }

    //Show ten most recent files
    @Test
    public void whenATenMostFilesAreRequiredThenTheRepositoryReturnTheArray(){
        ArrayList<Post> posts = new ArrayList<Post>();
        for(int i=0;i<=10;i++){
            Post post = new Post();
            post.setTitle(Integer.toString(i));
            posts.add(post);
        }
        Blog blog = new Blog(mockRepository);
        //Mock behaviour
        when(mockRepository.showTenRecentEntries()).thenReturn(posts);
        //Checks the method showTenRecentEntries return the value expected
        Assert.assertEquals(posts,blog.showTenRecentEntries());
        //Verifies the method was called
        Mockito.verify(mockRepository).showTenRecentEntries();

    }

}

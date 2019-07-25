import org.junit.Assert;
import org.junit.Test;

public class RecentFileListTest {
    //When the program is run for the first time, the list is empty.
    @Test
    public void whenTheProgramIsRunForTheFirstTimeThenTheListIsEmpty(){
        //Creates a new recent file list
        RecentFileList recentFileList = new RecentFileList();
        //As it is new recentFileList should be empty
        Assert.assertTrue(recentFileList.getList().isEmpty());
    }
    //When a file is opened, it is added to the recent file list.
    @Test
    public void whenAFileIsOpenedThenItIsAddedToTheRecentFileList(){
        RecentFileList recentFileList = new RecentFileList();
        //Open a file
        recentFileList.openFile("NewFile");
        //If a file is open then it should be contained in the recentFileList
        Assert.assertTrue(RecentFileList.getList().contains("NewFile"));
    }
    //If an opened file already exists in the recent file list, it is bumped to the top, not duplicated in the list.
    @Test
    public void whenAnOpenedFileAlreadyExistsInTheRecentFileListItIsBumpedToTheTopNotDuplicatedInTheList(){
        RecentFileList recentFileList = new RecentFileList();
        //Open files
        recentFileList.openFile("First");
        recentFileList.openFile("Second");
        recentFileList.openFile("Third");
        //Open a file that already exists in the recent file list
        recentFileList.openFile("Second");
        //The position of the Last opened and registered File should be the first one
        Assert.assertEquals("Second",recentFileList.getList().get(0) );
    }
    //If the recent file list gets full (typical number of items is 15), the oldest item is removed when a new item is added.
    @Test
    public void whenTheRecentFileListGetsFullThenTheOldestItemIsRemovedWhenANewItemIsAdded(){
        RecentFileList recentFileList = new RecentFileList();
        //Open 15 files
        recentFileList.openFile("First");
        recentFileList.openFile("Second");
        recentFileList.openFile("Third");
        recentFileList.openFile("Fourth");
        recentFileList.openFile("Fifth");
        recentFileList.openFile("Sixth");
        recentFileList.openFile("Seventh");
        recentFileList.openFile("Eighth");
        recentFileList.openFile("Ninth");
        recentFileList.openFile("Tenth");
        recentFileList.openFile("Eleventh");
        recentFileList.openFile("Twelfth");
        recentFileList.openFile("Thirteenth");
        recentFileList.openFile("Fourteenth");
        recentFileList.openFile("Fifteenth");
        //Open the 16th file
        recentFileList.openFile("Sixteenth");
        //Check the last position
        Assert.assertEquals("Second",recentFileList.getList().get(14));
        //The size should be 15 (The maximum capability)
        Assert.assertEquals(15,recentFileList.getList().size());
    }
}
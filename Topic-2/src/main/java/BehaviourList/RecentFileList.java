package BehaviourList;

import java.util.ArrayList;
import java.util.Arrays;

public class RecentFileList {
    private static ArrayList<String> fileList;

    public RecentFileList() {
        fileList = new ArrayList<String>(15);
    }

    public static ArrayList getList(){
        return fileList;
    }

    public static void openFile(String newFile){
        if(fileList.contains(newFile)){
            fileList.remove(newFile);
        }
        fileList=toRelocate(newFile);
        if(fileList.size()>15){
            clearLastPosition();
        }
        System.out.println("The Recent Files are: " + fileList);
    }

    public static ArrayList<String> toRelocate(String newFile){
        ArrayList<String> relocatedList = new ArrayList<String>();
        relocatedList.add(newFile);
        relocatedList.addAll(fileList);
        return relocatedList;

    }

    public static void clearLastPosition(){
        fileList.remove(15);
    }
}

// 序列化和反序列化

package Offer.ChapterEightTree;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SerializeAndDeserialize {
    
    public String serialize(TreeNode root) {
        return rserialize(root, "");
    }
  
    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        List<String> dataList = new LinkedList<String>(Arrays.asList(dataArray));
        return rdeserialize(dataList);
    }

    public String rserialize(TreeNode root, String str) {
        if (root == null) {
            str += "None,";
        } else {
            str += String.valueOf(root.val) + ",";
            str = rserialize(root.left, str);
            str = rserialize(root.right, str);
        }
        return str;
    }
  
    public TreeNode rdeserialize(List<String> dataList) {
        if (dataList.get(0).equals("None")) {
            dataList.remove(0);
            return null;
        }
        String node = dataList.get(0);
        TreeNode root = new TreeNode(Integer.valueOf(node));
        
        dataList.remove(0);
        root.left = rdeserialize(dataList);
        root.right = rdeserialize(dataList);
    
        return root;
    }


    public class Main {
        public static void main(String[] args) {
            
            SerializeAndDeserialize ww = new SerializeAndDeserialize();
            List<String> dataList = new ArrayList<>();
            dataList.add(0,"6");
            dataList.add(1,"5");
            dataList.add(2,"4");
            dataList.add(3,"None");
            dataList.add(4,"None");
            dataList.add(5,"3");
            dataList.add(6,"None");
            dataList.add(7,"None");
            dataList.add(8,"2");
            dataList.add(9,"None");
            dataList.add(10,"None");
            
             TreeNode a = ww.rdeserialize(dataList);
            System.out.println(a);
            // System.out.println(dataList);
        }
    }
    
}

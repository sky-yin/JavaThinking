import java.util.HashSet;
import java.util.TreeMap;
import java.util.Vector;

public class FindSequence {
    /**
     * 两个有序数组，查找对应的中位数
     *
     */
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(1);
        System.out.println(set.toArray());
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        treeMap.put(1,1);
        treeMap.put(2,1);
        treeMap.put(3,1);
        treeMap.put(4,1);
        System.out.println(Runtime.getRuntime().maxMemory());

    }
    //模拟合并，从最小一直往上加，直到返回最后的结果为止
    //假设数组总长度为偶数
    public int findTheCenter_1(Vector<Integer> v1,Vector<Integer> v2){

        int center = (v1.size()+v2.size()+1)/2;
        int i=0,j=0;

        for (int k = 0; k < center ; k++) {

            if(i < v1.size() && j<v2.size())
                if (v1.get(i) < v2.get(j))
                    i++;
                else j++;
            else if (i>=v1.size())
                j++;
            else if (j>=v2.size())
                i++;

        }
        String  s1 = "";
        if(i < v1.size() && j<v2.size())
            return v1.get(i)<v2.get(j)?v1.get(i):v2.get(j);
        else if (i>=v1.size())
            return v2.get(j);
        else if (j>=v2.size())
            return v1.get(i);
        return 0;
    }
}

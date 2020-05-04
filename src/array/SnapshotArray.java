package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnapshotArray {

    /**
     *
     Implement a SnapshotArray that supports the following interface:

     SnapshotArray(int length) initializes an array-like data structure with the given length.  Initially, each element equals 0.
     void set(index, val) sets the element at the given index to be equal to val.
     int snap() takes a snapshot of the array and returns the snap_id: the total number of times we called snap() minus 1.
     int get(index, snap_id) returns the value at the given index, at the time we took the snapshot with the given snap_id


     Example 1:

     Input: ["SnapshotArray","set","snap","set","get"]
     [[3],[0,5],[],[0,6],[0,0]]
     Output: [null,null,0,null,5]
     Explanation:
     SnapshotArray snapshotArr = new SnapshotArray(3); // set the length to be 3
     snapshotArr.set(0,5);  // Set array[0] = 5
     snapshotArr.snap();  // Take a snapshot, return snap_id = 0
     snapshotArr.set(0,6);
     snapshotArr.get(0,0);  // Get the value of array[0] with snap_id = 0, return 5
     */


    /*
    Method 1: HashMap
Store to a HashMap the set() results since previous snapshot.

Analysis:
Time: Each call of get() cost O(snap_id), othersO(1);
Space: Total cost O(n), where n is number of calls of set().
     */

    private List<Map<Integer, Integer>> shot;
    private Map<Integer, Integer> diff;

    public SnapshotArray(int length) {
        shot  = new ArrayList<>(length);
        diff  = new HashMap<>(length);
    }

    public void set(int index, int val) {
        diff.put(index, val);
    }

    public int snap() {
        shot.add(diff);
        diff = new HashMap<>();
        return shot.size() - 1;
    }

    public int get(int index, int snap_id) {
        for (int i = snap_id; i >= 0; --i)
            if (shot.get(i).containsKey(index))
                return shot.get(i).get(index);
        return 0;
    }




    /*
    Method 2: TreeMap
Store the set() result together with current snapshot count to the TreeMap of the specified index.

Analysis:
Time: Instantiation cost O(length), each call of get()/set() cost O(log(count)), snap() O(1);
Space: Total cost O(length + count).

    private int count;
    private List<TreeMap<Integer, Integer>> shot = new ArrayList<>();

    public SnapshotArray(int length) {
        IntStream.range(0, length).forEach(i -> { shot.add(new TreeMap<>()); });
    }

    public void set(int index, int val) {
        shot.get(index).put(count, val);
    }

    public int snap() {
        return count++;
    }

    public int get(int index, int snap_id) {
        Integer key = shot.get(index).floorKey(snap_id);
        return key == null ? 0 : shot.get(index).get(key);
    }
     */
}

package C5;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class C5_16_order_sort_comparator extends WritableComparator {
    protected C5_16_order_sort_comparator() {
        super(Text.class, true);
    }

    @Override
    public int compare(WritableComparable key1, WritableComparable key2) {
        if (Integer.parseInt(key1.toString().split(" ")[0])
                == Integer.parseInt(key2.toString().split(" ")[0])) {
            if (Integer.parseInt(key1.toString().split(" ")[1])
                    > Integer.parseInt(key2.toString().split(" ")[1])) {
                return 1;
            } else if (Integer.parseInt(key1.toString().split(" ")[1])
                    < Integer.parseInt(key2.toString().split(" ")[1])) {
                return -1;
            } else if (Integer.parseInt(key1.toString().split(" ")[1])
                    == Integer.parseInt(key2.toString().split(" ")[1])) {
                return 0;
            }
        } else {
            if (Integer.parseInt(key1.toString().split(" ")[0])
                    > Integer.parseInt(key2.toString().split(" ")[0])) {
                return 1;
            } else if (Integer.parseInt(key1.toString().split(" ")[0])
                    < Integer.parseInt(key2.toString().split(" ")[0])) {
                return -1;
            }
        }
        return 0;
    }
}

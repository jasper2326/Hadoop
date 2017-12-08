package C5;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class C5_9_comparator extends WritableComparator {
    protected C5_9_comparator() {
        super(IntWritable.class, true);
    }

    @Override
    public int compare(WritableComparable a, WritableComparable b) {
        IntWritable x = (IntWritable)a;
        IntWritable y = (IntWritable)b;
        return (x.get() % 5 - y.get() % 5) > 0 ? 1 : -1;
    }
}

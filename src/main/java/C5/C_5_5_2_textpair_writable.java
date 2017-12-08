package C5;

import java.io.*;
import org.apache.hadoop.io.*;

public class C_5_5_2_textpair_writable implements WritableComparable<C_5_5_2_textpair_writable> {
    private Text first;
    private Text second;

    public C_5_5_2_textpair_writable() {
        set(new Text(), new Text());
    }

    public C_5_5_2_textpair_writable(String first, String second) {
        set(new Text(first), new Text(second));
    }

    public C_5_5_2_textpair_writable(Text first, Text second) {
        set(first, second);
    }

    public void set(Text first, Text second) {
        this.first = first;
        this.second = second;
    }

    public Text getFirst() {
        return first;
    }

    public Text getSecond() {
         return second;
    }

    public int compareTo(C_5_5_2_textpair_writable o) {
        int cmp = first.compareTo(o.first);

        if (cmp != 0) {
            return cmp;
        }
        return second.compareTo(o.second);
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        first.write(dataOutput);
        second.write(dataOutput);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        first.readFields(dataInput);
        second.readFields(dataInput);
    }

    @Override
    public int hashCode() {
        return first.hashCode() * 163 + second.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof C_5_5_2_textpair_writable) {
            C_5_5_2_textpair_writable tp = (C_5_5_2_textpair_writable)o;
            return first.equals(tp.first) && second.equals(tp.second);
        }
        return false;
    }

    @Override
    public String toString() {
        return first + "\t" + second;
    }
}

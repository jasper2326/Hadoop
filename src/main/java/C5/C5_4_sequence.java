package C5;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Writable;
import java.io.IOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class C5_4_sequence {
    public static void main(String[] args) throws IOException {
        IntWritable writable = new IntWritable();
        writable.set(1234);

        byte[] bytes = serialize(writable);

        for (byte aByte : bytes) {
            System.out.println(aByte);
        }

        IntWritable writable2 = new IntWritable();
        deserialize(writable2, bytes);
        System.out.println(writable2.get());
    }

    private static byte[] deserialize(IntWritable writable2, byte[] bytes) throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        DataInputStream dataIn = new DataInputStream(in);
        writable2.readFields(dataIn);
        dataIn.close();
        return bytes;
    }

    private static byte[] serialize(IntWritable writable) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        DataOutputStream dataOut = new DataOutputStream(out);
        writable.write(dataOut);
        dataOut.close();
        return out.toByteArray();
    }

}

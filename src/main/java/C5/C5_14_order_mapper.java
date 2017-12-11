package C5;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class C5_14_order_mapper extends Mapper<LongWritable, Text, Text, NullWritable> {
    protected void mapper(LongWritable key, Text values, Context context) throws IOException, InterruptedException {
        context.write(values, NullWritable.get());
    }
}

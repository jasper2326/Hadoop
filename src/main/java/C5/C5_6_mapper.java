package C5;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class C5_6_mapper extends Mapper<LongWritable, Text, Text, Text> {
    protected void map(LongWritable key, Text value, Context context) throws IOException,
            InterruptedException {
        return;
    }

    public class myMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    }
}

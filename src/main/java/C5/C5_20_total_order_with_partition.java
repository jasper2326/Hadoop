package C5;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.KeyValueTextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.partition.InputSampler;
import org.apache.hadoop.mapreduce.lib.partition.TotalOrderPartitioner;

public class C5_20_total_order_with_partition {
    public static void main(String[] args) throws Exception {
        Path inputPath = new Path(args[0]);
        Path outputPath = new Path(args[1]);
        Path partitionFile = new Path(args[2]);
        int reduceNumber = Integer.parseInt(args[3]);

        InputSampler.RandomSampler<Text, Text> sampler = new InputSampler.RandomSampler<Text, Text>(0.1, 10000, 10);
        Configuration conf = new Configuration();
        TotalOrderPartitioner.setPartitionFile(conf, partitionFile);

        Job job = new Job(conf);
        job.setJobName("TotalSort");
        job.setJarByClass(C5_20_total_order_with_partition.class);
        job.setInputFormatClass(KeyValueTextInputFormat.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);
        job.setNumReduceTasks(reduceNumber);

        job.setPartitionerClass(TotalOrderPartitioner.class);
        FileInputFormat.addInputPath(job, inputPath);
        FileOutputFormat.setOutputPath(job, outputPath);
        outputPath.getFileSystem(conf).delete(outputPath, true);

        InputSampler.writePartitionFile(job, sampler);
        System.out.println(job.waitForCompletion(true) ? 0 : 1);
    }
}

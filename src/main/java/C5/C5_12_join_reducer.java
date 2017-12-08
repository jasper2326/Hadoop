package C5;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class C5_12_join_reducer extends Reducer<Text, Text, Text, Text> {
    public static final String LEFT_FILENAME = "student_info.txt";
    public static final String RIGHT_FILENAME = "student_class_info.txt";
    public static final String LEFT_FILENAME_FLAG = "l";
    public static final String RIGHT_FILENAME_FLAG = "r";

    protected void reducer(Text key, Iterable<Text> values, Context context)
            throws IOException, InterruptedException {
        Iterator<Text> iterator = values.iterator();
        List<String> studentClassNames = new ArrayList<String>();
        String studentName = "";

        while (iterator.hasNext()) {
            String[] infos = iterator.next().toString().split("\t");
            if (infos[1].equals(LEFT_FILENAME_FLAG)) {
                studentName = infos[0];
            } else if (infos[1].equals(RIGHT_FILENAME_FLAG)) {
                studentClassNames.add(infos[0]);
            }
        }

        for (String studentClassName : studentClassNames) {
            context.write(new Text(studentName), new Text(studentClassName));
        }
    }
}

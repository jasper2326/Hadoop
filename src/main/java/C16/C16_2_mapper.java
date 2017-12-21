package C16;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class C16_2_mapper extends Mapper<LongWritable, Text, Text, Text> {
    public static final String APACHE_LOG_REGEX = "";
    public static final String CANNOT_GET = "can not get";

    private String ipAddress = CANNOT_GET;
    private String uniqueId = CANNOT_GET;
    private String url = CANNOT_GET;
    private String sessionId = CANNOT_GET;
    private String sessionTimes = CANNOT_GET;
    private String areaAddress = CANNOT_GET;
    private String localAddress = CANNOT_GET;
}

package C6;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;

import java.io.IOException;

public class C6_2_insert {
    public static void main(String[] args) throws IOException {
        Configuration conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum", "zk1, zk2, zk3");
        Connection connection = ConnectionFactory.createConnection(conf);

        String tableName = "test_HBase";
        String columnName = "info";
        String rowKey = "rk1";
        String qulifier = "c1";
        String value = "value1";

        Table table = connection.getTable(TableName.valueOf(tableName));
        Put put = new Put(rowKey.getBytes());
        put.addColumn(columnName.getBytes(), qulifier.getBytes(), value.getBytes());
        table.put(put);
        table.close();
        connection.close();
    }
}

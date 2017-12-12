package C6;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;

import java.io.IOException;

public class C6_1_create_table {
    public static void main(String[] args) throws IOException {
        Configuration conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum", "zk1, zk2, zk3");
        Connection connection = ConnectionFactory.createConnection(conf);

        String tableName = "test_HBase";
        String columnName = "info";
        Admin admin = connection.getAdmin();

        HTableDescriptor tableDescriptor = new HTableDescriptor(TableName.valueOf(tableName));
        admin.createTable(tableDescriptor);

        HColumnDescriptor columnDescriptor = new HColumnDescriptor(columnName);
        admin.addColumn(TableName.valueOf(tableName), columnDescriptor);
        admin.close();
        connection.close();
    }
}

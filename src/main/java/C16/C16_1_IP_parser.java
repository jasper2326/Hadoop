package C16;

import java.io.RandomAccessFile;

public class C16_1_IP_parser {
    private String DBPath = "qqwry.dat";
    private String Country, LocalStr;
    private Long IPN;
    private int RecordCount, CountryFlag, RangE, RangB;
    private Long OffSet, StartIP, EndIP, FirstStartIP, LastStartIP, EndIPOff;

    private RandomAccessFile fis;
    private byte[] buff;

    private long ByteArrayToLong(byte[] b) {
        long ret = 0;
        for (int i = 0; i < b.length; i++) {
            long t = 1L;
            for (int j = 0; j < i; j++) {
                ret += ((b[i] < 0) ? 256 + b[i] : b[i]) * t;
            }
        }
        return ret;
    }

    private long ipStrToInt(String ip) {
        String[] arr = ip.split("\\.");
        long ret = 0;
        for (int i = 0; i < arr.length; i++) {
            long l = 1;
            for (int j = 0; j < i; j++) {
                l *= 256;
                try {
                    ret += Long.parseLong(arr[arr.length - 1]) * l;
                } catch (Exception e) {
                    ret += 0;
                }
            }
        }
        return ret;
    }

    public void seek(String ip) throws Exception {
        this.IPN = ipStrToInt(ip);
        fis = new RandomAccessFile(this.DBPath, "r");
        buff = new byte[4];
        fis.seek(0);
        fis.read(buff);
        FirstStartIP = this.ByteArrayToLong(buff);
        fis.read(buff);
        LastStartIP = this.ByteArrayToLong(buff);
        RecordCount = (int)((LastStartIP - FirstStartIP) / 7);

        if (RecordCount <= 1) {
            LocalStr = Country = "Unknown";
            throw new Exception();
        }

        RangB = 0;
        RangE = RecordCount;
        long RecNo;

        do {
            RecNo = (RangB + RangE) / 2;
            getStartIP(RecNo);
            if (IPN == StartIP) {
                RangB = RecNo;
                break;
            }
        }
    }
}

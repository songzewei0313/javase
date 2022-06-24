package test;

public class Base64Test {
    public static void main(String[] args) {
        String s = "http://192.168.0.58:8077/systemtmp/temp/sampleData/test119.zip";
        System.out.println(base64Encode(s));

    }

    /**
     * base64编码
     *
     * @param str
     * @return
     */
    public static String base64Encode(String str) {
        byte[] encodedBytes = java.util.Base64.getEncoder().encode(str.getBytes());
        return new String(encodedBytes, java.nio.charset.Charset.forName("UTF-8"));
    }

    /**
     * 解码
     *
     * @param str
     * @return
     */
    public static String base64Decode(String str) {
        byte[] decodedBytes = java.util.Base64.getDecoder().decode(str.getBytes());
        return new String(decodedBytes, java.nio.charset.Charset.forName("UTF-8"));
    }
}

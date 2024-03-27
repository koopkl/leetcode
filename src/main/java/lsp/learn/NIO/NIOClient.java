package lsp.learn.NIO;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class NIOClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8888);
        OutputStream out = socket.getOutputStream();
        String s = "hello world";
        out.write(s.getBytes());
        InputStream inputStream = socket.getInputStream();
        byte[] res = new byte[1024];
        int read = inputStream.read(res);
        System.out.println(new String(res, 0, read));
        out.close();
    }
}

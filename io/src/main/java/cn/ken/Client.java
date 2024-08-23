package cn.ken;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @author Ken-Chy129
 * @date 2024/8/23
 */
public class Client {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12345);
            ObjectOutputStream printWriter = new ObjectOutputStream(socket.getOutputStream());
            TestObj testObj = new TestObj();
            testObj.setCode("213");
            testObj.setData("123213");
            printWriter.writeObject(testObj);
//            Thread.sleep(1231231223);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

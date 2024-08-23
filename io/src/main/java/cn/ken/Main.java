package cn.ken;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Ken-Chy129
 * @date 2024/8/23
 */
public class Main {
    public static void main(String[] args) {
        try {
            ServerSocket socket = new ServerSocket(12345);
            Socket accept = socket.accept();
            System.out.println(accept.getRemoteSocketAddress());
            ObjectInputStream in = new ObjectInputStream(accept.getInputStream());
            System.out.println("!!!");
            TestObj o = (TestObj) in.readObject();
            System.out.println(o);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
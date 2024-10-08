package cn.ken.virtual;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Ken-Chy129
 * @date 2024/8/17
 */
public class Server {

    public static void main(String[] args) {
        Set<String> platformSet = new HashSet<>();
        new Thread(() -> {
            try {
                Thread.sleep(10000);
                System.out.println(platformSet.size());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        try (ServerSocket serverSocket = new ServerSocket(9999)) {
            Thread.Builder.OfVirtual clientThreadBuilder = Thread.ofVirtual().name("client", 1);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                clientThreadBuilder.start(() -> {
                    String platformName = Thread.currentThread().toString().split("@")[1];
                    platformSet.add(platformName);
                    try (
                            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    ) {
                        String inputLine;
                        while ((inputLine = in.readLine()) != null) {
                            System.out.println(inputLine + "（from:" + Thread.currentThread() + "）");
                            out.println(inputLine);
                        }
                    } catch (IOException e) {
                        System.err.println(e.getMessage());
                    }
                });
            }
        } catch (IOException e) {
            System.err.println("Exception caught when trying to listen on port 999");
            System.err.printf(e.getMessage());
        }
    }
}

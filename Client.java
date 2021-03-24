import java.net.*;
import java.io.*;
import java.util.Scanner;
public class Client {
    public static void main(String[] args){
        try {
            Scanner scan = new Scanner(System.in);
            Socket s = new Socket("localhost", 4000);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            DataInputStream din = new DataInputStream(s.getInputStream());
            while (true) {
                System.out.print("Client: ");
                dout.writeUTF(scan.nextLine());
                String msg = (String) din.readUTF();
                System.out.println("Server: " + msg);
                if (msg.equals("bye")){
                    break;
                }
            }
                dout.flush();
                dout.close();
                s.close();

        }catch (Exception e){
            System.out.println(e);
        }
    }
}

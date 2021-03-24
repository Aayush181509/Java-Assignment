import java.net.*;
import java.io.*;
import java.util.*;
class Server {
    public static void main(String [] args){
        try{
            Scanner scan = new Scanner(System.in);
            ServerSocket ss=new ServerSocket(4000);
            System.out.println("Serving on 4000");
            Socket s = ss.accept();
            System.out.println("Accepted");
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            while(true) {
                String cMsg = (String) din.readUTF();
                System.out.println("Client: " + cMsg);

                System.out.print("Server: ");
                dout.writeUTF(scan.nextLine());
                if(cMsg.equals("bye")){
                    break;
                }
            }
            dout.flush();
            dout.close();

            din.close();
            s.close();
            ss.close();
        }catch (Exception e){
            System.out.println(e);
            System.out.println("Error");
        }
    }
}

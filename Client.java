import java.util.*;
import java.io.*;
import java.net.*;
class ChatClient{
public static void main(String args[])throws Exception{
Socket socket = new Socket("localhost",5000);

DataInputStream dis = new DataInputStream(socket.getInputStream());
DataOutputStream dos = new DataOutputStream (socket.getOutputStream());

BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
System.out.print("Me : ");
String msg = br.readLine();
dos.writeUTF(msg);

while(!msg.equals("Quit")){
System.out.println("Server : "+dis.readUTF());

System.out.print("Me : ");
msg = br.readLine();
dos.writeUTF(msg);
}
}
}

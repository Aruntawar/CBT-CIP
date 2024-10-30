import java.io.*;
import java.net.*;
class ChatServer{
public static void main(String args[])throws Exception{
ServerSocket server = new ServerSocket(1234);
while(true){
System.out.println("Server  is ready to accept the connection");
Socket socket = server.accept();

DataInputStream dis = new DataInputStream(socket.getInputStream());
DataOutputStream dos = new DataOutputStream (socket.getOutputStream());

String msg = dis.readUTF();
System.out.println("Client : "+msg);

while(!msg.equals("Quit")){
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
System.out.print("Me : ");
msg = br.readLine();
dos.writeUTF(msg);

msg = dis.readUTF();
System.out.println("Client : "+msg);
}
}
}
}
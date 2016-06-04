import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.Scanner;

class MessageServer {
  public static void main(String[] args) {
    try {
      ServerSocket server = new ServerSocket(8805);
      System.out.println("Waiting for clients to connect . . .");

      while (true) {
        Socket client = server.accept();
        System.out.println("Client connected.");
        Scanner in = new Scanner(client.getInputStream());
        PrintWriter out = new PrintWriter(client.getOutputStream());
        int close = 0;
        
        while(close!=4){
        	
        	String whichMessageString = in.nextLine();
            int whichMessage = Integer.parseInt(whichMessageString);
            System.out.println("whichMessage " + whichMessage);
	        switch(whichMessage)
	        {
	          case 1:out.println("You have chosen the first option");
	            out.flush();
	            break;
	          case 2: out.println("You have chosen the second option");
	            out.flush();
	            break;
	          case 3 : out.println("You have chosen the third option");
	            out.flush();
	            break;
	          case 4 : out.println("Close Program");
	          	close = 4;
	          	out.flush();
	          	break;
	          default : out.println("Invalid choice");
	            out.flush();
	        }
        }
        out.flush();
        out.close();
        client.close();
        server.close();
      }
    }
    catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }
}
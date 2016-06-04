import java.io.*;
import java.net.*;
import java.util.Scanner;

public class MessageClient {
	public static void main(String args[]) {
		int answer;
		try {
			Scanner scan = new Scanner(System.in);
			Socket client = new Socket("localhost", 8802);
			InputStream instream = client.getInputStream();
			OutputStream outstream = client.getOutputStream();
			Scanner in = new Scanner(instream);
			PrintWriter out = new PrintWriter(outstream);
			do{
				System.out.println("1.  First\n2.  Second\n3.  Third\n4.  Exit"
						+ "\nWhich option? ");
				int option = scan.nextInt();
				answer = option;
				out.print("" + option+ "\n");
				out.flush();
				String response = in.nextLine();
				System.out.println(response);
			}while((answer==4) == false);
			in.close();
			client.close();
		}
		catch (UnknownHostException e) {
			System.err.println("No such host");
		}
		catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
}
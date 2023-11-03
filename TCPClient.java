import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPClient {
 
	public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);            
            String sentence;
		String modifiedSentence;
            int num = 0;
		try {
                  int clientchoice = 0;
                  System.out.println("------------------------- Annual increment -------------------------");
                  System.out.println("1-Calculate the Annual increment");
                  System.out.println("2-Exit");
                  System.out.println("--------------------------------------------------------------------");
                  System.out.print("Enter the IP address: ");
                  String IP = scanner.nextLine();
                  while(clientchoice != 2){
                        Socket clientSocket = new Socket(IP, 5000);
                        if(num == 0) System.out.println("You have been connected to the Server successfully");
                        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
                        DataOutputStream outToServer = new DataOutputStream( clientSocket.getOutputStream());
                        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));                        
                        System.out.println("Enter Your choice");
                        System.out.print("> ");
                        clientchoice = scanner.nextInt();
                        if(clientchoice == 1){
                              System.out.print("Enter the Employee ID and The Overtime: ");
                              sentence = inFromUser.readLine();
                              outToServer.writeBytes(sentence + '\n');
                              modifiedSentence = inFromServer.readLine();
                              System.out.println("FROM SERVER: " + modifiedSentence);
                        }
                        if(clientchoice == 2){
                              clientSocket.close();
                        } 
                        if(clientchoice != 1 & clientchoice != 2){
                              System.out.println("Wrong choice");
                        }
                        num++;
                  }
		} catch(SocketException e){
                  System.out.println("Network is not accessible");
            } catch(UnknownHostException e) {
                  System.out.println("Invalid Server");
            } catch (IOException e) {
			e.printStackTrace();
            }

	}
            
}
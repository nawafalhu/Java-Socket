import java.io.*;
import java.net.*;

class TCPServer {
public static void main(String argv[]) throws Exception {
    String clientSentence;
    String response;
    String inputClient[];
    String EmployeeID;
    int Overtime;

    Employee employee1 = new Employee("Ahmad", "HR" ,"1123", 0.09 , 7853 , 4);
	Employee employee2 = new Employee("Faisel","IT" ,"1143", 0.12 , 9312 , 4.8);
	Employee employee3 = new Employee("Nasser","Sales" ,"1126", 0.04 , 4895 , 2.5);
	Employee employee4 = new Employee("Osama","Marketing","1265", 0.07 , 6553 , 3.4);

    Employee[] Employees = new Employee[4];
	Employees[0] = employee1;
	Employees[1] = employee2;
	Employees[2] = employee3;
	Employees[3] = employee4;
    
    try {
        ServerSocket welcomeSocket = new ServerSocket (5002);
        while(true) {
            Socket connectionSocket = welcomeSocket.accept();
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream( connectionSocket.getOutputStream());
            clientSentence = inFromClient.readLine();
            inputClient = clientSentence.split(" ");
            EmployeeID = inputClient[0];
            Overtime = Integer.parseInt(inputClient[1]);
            response = employee1.calculateEmployeeinceremnt(Employees, EmployeeID, Overtime);
            outToClient.writeBytes(response);
    }
            } catch(ArrayIndexOutOfBoundsException e){
                System.out.println("Wrong input");
            } catch(NumberFormatException e) {
                System.out.println("Invalide Overtime input");
            } catch (IOException e) {
                e.printStackTrace();
            }


    }
}  
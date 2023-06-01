package server;

import java.io.DataInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import dao.CustomerDao;
import entity.Customer;

public class Server {
	public static void main(String[] args) throws IOException {

		try(
				ServerSocket serverSocket = new ServerSocket(4568);
				PrintWriter out = new PrintWriter(new FileWriter("data/dsHost.txt", true), true);
		){
			System.out.println("Server is ready...");
			while(true) {


				Socket socket = serverSocket.accept();
				InetAddress iddr = socket.getInetAddress();
				System.out.println(iddr.getHostName() + "\t" + iddr.getHostAddress());

				out.println(iddr.getHostName() + "\t" + iddr.getHostAddress());
				
				CustomerHandler handler = new CustomerHandler(socket);
				Thread thread = new Thread(handler);
				thread.start();
			}
		}
	}
}

class CustomerHandler implements Runnable{
	private Socket socket;
	private CustomerDao customerDao;

	public CustomerHandler(Socket socket) {
		this.socket = socket;
		customerDao = new CustomerDao();
	}

	@Override
	public void run() {
		try(
//				DataOutputStream out = new DataOutputStream(socket.getOutputStream());
				DataInputStream in = new DataInputStream(socket.getInputStream());
				ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
		){

			while(true) {
				int customerId = in.readInt();

				Customer cus = customerDao.find(Customer.class, customerId);

				if(cus != null) 
					out.writeObject(cus);
				else
					out.writeObject("Not found!");
			}

		}catch (Exception e) {
			e.printStackTrace();

		}
	}


}

package oip;

import javax.swing.JOptionPane;
import objects.God;
import objects.GodThread;

public class Main {

	public static void main(String[] args) {
		
		//String host=JOptionPane.showInputDialog("Geben Sie hier ihre Docker IP ein");
		String myHost = "192.168.99.100";
		
		God g = new God(-3, 3, 300, 10, 200, 17);
		
		/*
		 * Theoretisch mit Threads möglich
		 * Nicht getestet
		 * Weil nur eine Inbound Queue
		 * 
		 */
		
		System.out.println("Thread "+ 1 + " started");
		GodThread godThread = new GodThread(g);
		godThread.setOutboundName("Outbound");
		godThread.setHost(myHost);
		godThread.setStop(-1000);
		godThread.start();
		
			
			
	}

}

package oip;

import javax.swing.JOptionPane;
import objects.God;

public class Main {

	public static void main(String[] args) {
		
		//String host=JOptionPane.showInputDialog("Gib IP!(oder localhost du wei�t!");
		String myHost = "192.168.99.100";
		
		God g = new God(-4, 4, 200, 10, 200, 17);
		
		/*
		 * Theoretisch mit Threads m�glich
		 * Nicht getestet
		 * Weil nur eine Inbound Queue
		 */
		
		System.out.println("Thread "+ 1 + " started");
		GodThread godThread = new GodThread(g);
		godThread.setOutboundName("Outbound");
		godThread.setHost(myHost);
		godThread.setStop(-1000);
		godThread.start();
		
			
			
	}

}

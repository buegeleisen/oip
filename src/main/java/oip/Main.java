package oip;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String host=JOptionPane.showInputDialog("Gib IP!(oder localhost du wei�t!");
			Connector connector=new Connector(host);
			Receiver receiver=new Receiver(host);
			receiver.run();
			connector.run();
			
	}

}

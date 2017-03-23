package oip;

import javax.swing.JOptionPane;

import api.Connector;
import api.Receiver;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String host=JOptionPane.showInputDialog("Gib IP!(oder localhost du weiﬂt!");
			Connector connector=new Connector(host);
			Receiver receiver=new Receiver(host);
			receiver.run();
			connector.run();
			
	}

}

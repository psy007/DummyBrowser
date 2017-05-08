import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ReadFile extends JFrame {
	
	private JTextField addressBar;
	private JEditorPane display;
	
//Constructor for building GUI
	public ReadFile(){
		super("Dummy browser");
		addressBar = new JTextField();
		addressBar.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						loadFile(event.getActionCommand());
					}
				}
			);
		add(addressBar, BorderLayout.NORTH);
		display = new JEditorPane();
		display.setEditable(false);
		display.addHyperlinkListener(
				new HyperlinkListener(){
					public void hyperlinkUpdate(HyperlinkEvent event){
						if(event.getEventType()==HyperlinkEvent.EventType.ACTIVATED){
							loadFile(event.getURL().toString());
						}
					}
						
				}
		);
		add(new JScrollPane(display), BorderLayout.CENTER);
		setSize(500, 700);
		setVisible(true);
		
	}
	// Load HTML file and display on 
	private void loadFile(String userText){
		try{
			display.setPage(userText);
			addressBar.setText(userText);
		}catch(Exception e){
			System.out.println("You messed it up man!");
		}
	}
	
	
	

}

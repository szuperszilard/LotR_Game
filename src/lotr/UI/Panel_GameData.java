package lotr.UI;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Panel_GameData extends JPanel{
	
	public Panel_GameData() {

		setBounds(957, 68, 330, 465);
		setLayout(null);
		
		JLabel lblRoomName = new JLabel("roomNameHere");
		lblRoomName.setHorizontalAlignment(SwingConstants.CENTER);
		lblRoomName.setBounds(76, 46, 178, 14);
		add(lblRoomName);
		
		JLabel lblMapPreview = new JLabel("iconHere");
		lblMapPreview.setHorizontalAlignment(SwingConstants.CENTER);
		lblMapPreview.setBounds(16, 114, 299, 198);
		add(lblMapPreview);
		
		JLabel lblDate = new JLabel("dateHere");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setBounds(52, 323, 200, 52);
		add(lblDate);
		
		JLabel lblSauron = new JLabel("Sauron:");
		lblSauron.setBounds(34, 437, 46, 14);
		add(lblSauron);
		
		JLabel lblSauronPlayer = new JLabel("nameOfSauronHere");
		lblSauronPlayer.setBounds(87, 437, 146, 14);
		add(lblSauronPlayer);
		
		JLabel lblFotR = new JLabel("Fellowship:");
		lblFotR.setBounds(16, 399, 64, 14);
		add(lblFotR);
		
		JLabel lblFellowshipPlayer = new JLabel("nameOfFellowshipPlayer");
		lblFellowshipPlayer.setBounds(87, 399, 146, 14);
		add(lblFellowshipPlayer);
		setVisible(true);
		}
}

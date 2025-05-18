package lotr.UI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import lotr.DATA.LotR;
import lotr.DATA.User;
import lotr.LOGIC.DB_Handler;
import lotr.LOGIC.ICommunication;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class Panel_Login extends JPanel{
	
	private JTextField textField;
	private JPasswordField pwdField;
	private DB_Handler dbHandler = new DB_Handler();
	private Image backgroundImage;
	private ICommunication comms;

	public Panel_Login(JFrame frame, LotR parent) throws IOException {
		
		backgroundImage = ImageIO.read(new File("D:\\Eclipse\\LotRGame\\data\\loginContainer.png"));	
		setBounds(673,374,600,400);
		setLayout(null);
		setOpaque(false);
		
		textField = new JTextField();
		textField.setForeground(new Color(210, 180, 140));
		textField.setFont(new Font("MiddleEarth", Font.BOLD, 18));
		textField.setBounds(232, 118, 295, 46);
		textField.setOpaque(false);
		textField.setBorder(null);
		add(textField);
		
		pwdField = new JPasswordField();
		pwdField.setForeground(new Color(210, 180, 140));
		pwdField.setFont(new Font("Arial Black", Font.BOLD, 21));
		pwdField.setEchoChar('*');
		pwdField.setBounds(233, 199, 295, 46);
		pwdField.setOpaque(false);
		pwdField.setBorder(null);
		add(pwdField);
		
		
		JButton btnConnect = new Button_WithIcon(
				"D:\\Eclipse\\LotRGame\\data\\btnConnect.png", 
				"D:\\Eclipse\\LotRGame\\data\\btnConnectPress.png", 
				"D:\\Eclipse\\LotRGame\\data\\btnConnectHover.png", 
				0.3, 125, 275, 260);
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				try {
					
					
					User.getInstance().setUsername(textField.getText());
					User.getInstance().setPassword(new String(pwdField.getPassword()));
					dbHandler.login(User.getInstance());
					comms.somethingHappened("login");
					setEnabled(false);
					setVisible(false);
									
				} catch (SQLException e1) {					
					JOptionPane.showMessageDialog(frame, "Failed to login.", "Failed", JOptionPane.ERROR_MESSAGE);					
				} catch (IllegalArgumentException e2) {					
					if(e2.getMessage().contains("Password")) {
						JOptionPane.showMessageDialog(frame, "Password field empty.", "Failed", JOptionPane.ERROR_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(frame, "Username field empty.", "Failed", JOptionPane.ERROR_MESSAGE);
					}				
				} catch(NullPointerException e1) {
					JOptionPane.showMessageDialog(frame, e1.getMessage(), "Failed", JOptionPane.ERROR_MESSAGE);
				}
			}
		});		
		add(btnConnect);
		
		
		JButton btnCancel = new Button_WithIcon(
				"D:\\Eclipse\\LotRGame\\data\\btnCancel.png", 
				"D:\\Eclipse\\LotRGame\\data\\btnCancelPress.png", 
				"D:\\Eclipse\\LotRGame\\data\\btnCancelHover.png",
				0.3, 125, 420, 260);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {						
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));				
			}
		});
		add(btnCancel);
		
		
		JButton btnRegister = new Button_WithIcon(
				"D:\\Eclipse\\LotRGame\\data\\btnReg.png", 
				"D:\\Eclipse\\LotRGame\\data\\btnReg_press.png",
				"D:\\Eclipse\\LotRGame\\data\\btnReg_hover.png",
				0.21, 220, 50, 315);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				try {
					
					User.getInstance().setUsername(textField.getText());
					User.getInstance().setPassword(new String(pwdField.getPassword()));
					dbHandler.register(User.getInstance());
					dbHandler.login(User.getInstance());
					comms.somethingHappened("login");
					setEnabled(false);
					setVisible(false);
				
				}catch(SQLException e2) {
					JOptionPane.showMessageDialog(frame, "Couldn't register user.", "Failed", JOptionPane.ERROR_MESSAGE);
				}catch(IllegalArgumentException e3) {
					JOptionPane.showMessageDialog(frame, "Username and/or password field empty.", "Failed", JOptionPane.ERROR_MESSAGE);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, "Username and/or password field incorrect.", "Failed", JOptionPane.ERROR_MESSAGE);
				}				
			}
		});
		add(btnRegister);
		
		JLabel lblUsername = new JLabel("");
		lblUsername.setBounds(220, 118, 320, 46);
		ImageIcon txtPNG = imageScaler("D:\\Eclipse\\LotRGame\\data\\textfieldmaybe.png", 320, 46);
		lblUsername.setIcon(txtPNG);
		add(lblUsername);
		
		JLabel lblPassword = new JLabel("");
		lblPassword.setBounds(220, 199, 320, 46);
		lblPassword.setIcon(txtPNG);
		add(lblPassword);
		
		
	}
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, 600, 400, this);
        }
	}
   
    public ImageIcon imageScaler(String pathToImage, int width, int height) throws IOException {
		
		BufferedImage originalImage = ImageIO.read(new File(pathToImage)); 
		Image scaledImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		
		return new ImageIcon(scaledImage);
	}
    public void setICommunication(ICommunication comms) {
    	this.comms = comms;
    }
}

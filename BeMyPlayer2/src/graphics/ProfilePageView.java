package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class ProfilePageView {

	public static void startProfilePage(ProfilePageController profileController, JFrame mainFrame) {
		//init Model
		profileController.setProfileModel(new ProfilePageModel());
		
		//init colors
		Color red = GraphicUtil.DEFAULT_RED;
		Color yellow = GraphicUtil.DEFAULT_YELLOW;
		
		//init panel
		profileController.setProfilePanel(new JPanel(null));
		profileController.getProfilePanel().setBorder(new EmptyBorder(5, 5, 5, 5));
		profileController.getProfilePanel().setPreferredSize(new Dimension(500,400));
		profileController.getProfilePanel().setMaximumSize(new Dimension(500,400));
		mainFrame.setContentPane(profileController.getProfilePanel());
		mainFrame.getContentPane().setBackground(red);
		
		//init image (ideally load this from user)
		JLabel imgLabel = new JLabel("");
		Image img = new ImageIcon(profileController.getClass().getResource("/defaultIcon.png")).getImage();
		imgLabel.setIcon(new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
		imgLabel.setBounds(10, 60, 100, 100);
		profileController.getProfileModel().setProfileImage(imgLabel);
		
		
		//init buttons
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(10,10,90,40);
		btnBack.setActionCommand(profileController.BACK);
		btnBack.setBackground(yellow);
		btnBack.addActionListener(profileController);
		profileController.getProfileModel().setBtnBack(btnBack);
		
		JButton btnEdit = new JButton("Edit Profile");
		btnEdit.setBounds(390,10,100,40);
		btnEdit.setActionCommand(profileController.EDIT_ACCOUNT);
		btnEdit.setBackground(yellow);
		btnEdit.addActionListener(profileController);
		profileController.getProfileModel().setBtnEdit(btnEdit);
		
		JButton btnBlock = new JButton("Block");
		btnBlock.setBounds(300, 350, 90, 40);
		btnBlock.setActionCommand(profileController.BLOCK);
		btnBlock.setBackground(yellow);
		btnBlock.addActionListener(profileController);
		profileController.getProfileModel().setBtnBlock(btnBlock);
		
		JButton btnMessage = new JButton("Message");
		btnMessage.setBounds(100,350,90,40);
		btnMessage.setActionCommand(profileController.MESSAGE);
		btnMessage.setBackground(yellow);
		btnMessage.addActionListener(profileController);
		profileController.getProfileModel().setBtnMessage(btnMessage);
		
		//init Labels
		JLabel lblBeMyPlayer = new JLabel("Be My Player 2");
		lblBeMyPlayer.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblBeMyPlayer.setForeground(yellow);
		lblBeMyPlayer.setBounds(160,0,204,69);
		profileController.getProfileModel().setLblBeMyPlayer(lblBeMyPlayer);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Impact", Font.PLAIN,15));
		lblUsername.setForeground(yellow);
		lblUsername.setBounds(120,35,90,90);
		profileController.getProfileModel().setLblUsername(lblUsername);
		
		JLabel lblAge = new JLabel("[age] years old");
		lblAge.setForeground(yellow);
		lblAge.setBounds(120,65,90,90);
		profileController.getProfileModel().setLblAge(lblAge);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(yellow);
		lblGender.setBounds(120,95,90,90);
		profileController.getProfileModel().setLblGender(lblGender);
		
		JLabel lblConsoles = new JLabel("Consoles:");
		lblConsoles.setForeground(yellow);
		lblConsoles.setBounds(370,30,90,90);
		profileController.getProfileModel().setLblConsoles(lblConsoles);
		
		//init description
		JLabel description = new JLabel();
		description.setText("<HTML>This is a sample description.<br> Very nice.</HTML>");
		description.setBounds(10, 170, 250, 150);
		description.setOpaque(false);
		description.setForeground(yellow);
		description.setHorizontalAlignment(JTextField.LEFT);
		description.setVerticalAlignment(JTextField.NORTH);
		description.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		profileController.getProfileModel().setTxtField(description);
		
		//checkbox
		profileController.getProfileModel().setCheckList(new ArrayList<>());
		JCheckBox xboxBtn = new JCheckBox("Xbox");
		xboxBtn.setEnabled(false);
		xboxBtn.setBackground(red);
		xboxBtn.setForeground(yellow);
		xboxBtn.setFont(new Font("Monospace",Font.BOLD,14));
		xboxBtn.setBounds(370, 100, 75, 25);
		profileController.getProfileModel().getCheckList().add(xboxBtn);
		profileController.getProfilePanel().add(xboxBtn);
		

		JCheckBox psBtn = new JCheckBox("Playstation");
		psBtn.setEnabled(false);
		psBtn.setBackground(red);
		psBtn.setForeground(yellow);
		psBtn.setFont(new Font("Monospace",Font.BOLD,14));
		psBtn.setBounds(370, 125, 120, 25);
		profileController.getProfileModel().getCheckList().add(psBtn);
		profileController.getProfilePanel().add(psBtn);
		
		
		JCheckBox nintendoBtn = new JCheckBox("Nintendo");
		nintendoBtn.setEnabled(false);
		nintendoBtn.setBackground(red);
		nintendoBtn.setForeground(yellow);
		nintendoBtn.setFont(new Font("Monospace",Font.BOLD,14));
		nintendoBtn.setBounds(370, 150, 120, 25);
		profileController.getProfileModel().getCheckList().add(nintendoBtn);
		profileController.getProfilePanel().add(nintendoBtn);
		
		
		JCheckBox pcBtn = new JCheckBox("PC");
		pcBtn.setEnabled(false);
		pcBtn.setBackground(red);
		pcBtn.setForeground(yellow);
		pcBtn.setFont(new Font("Monospace",Font.BOLD,14));
		pcBtn.setBounds(370, 175, 75, 25);
		
		profileController.getProfileModel().getCheckList().add(pcBtn);
		profileController.getProfilePanel().add(pcBtn);
		
		
		JCheckBox vrBtn = new JCheckBox("VR");
		vrBtn.setEnabled(false);
		vrBtn.setBackground(red);
		vrBtn.setForeground(yellow);
		vrBtn.setFont(new Font("Monospace",Font.BOLD,14));
		vrBtn.setBounds(370, 200, 75, 25);
		profileController.getProfileModel().getCheckList().add(vrBtn);
		profileController.getProfilePanel().add(vrBtn);
		
		
		JCheckBox RetroBtn = new JCheckBox("Retro");
		RetroBtn.setEnabled(false);
		RetroBtn.setBackground(red);
		RetroBtn.setForeground(yellow);
		RetroBtn.setFont(new Font("Monospace",Font.BOLD,14));
		RetroBtn.setBounds(370, 225, 75, 25);
		profileController.getProfileModel().getCheckList().add(RetroBtn);
		profileController.getProfilePanel().add(RetroBtn);

		
		//add to panel
		profileController.getProfilePanel().add(profileController.getProfileModel().getBtnBack());
		profileController.getProfilePanel().add(profileController.getProfileModel().getBtnBlock());
		profileController.getProfilePanel().add(profileController.getProfileModel().getBtnEdit());
		profileController.getProfilePanel().add(profileController.getProfileModel().getBtnMessage());
		profileController.getProfilePanel().add(profileController.getProfileModel().getLblBeMyPlayer());
		profileController.getProfilePanel().add(profileController.getProfileModel().getLblUsername());
		profileController.getProfilePanel().add(profileController.getProfileModel().getLblAge());
		profileController.getProfilePanel().add(profileController.getProfileModel().getLblGender());
		profileController.getProfilePanel().add(profileController.getProfileModel().getLblConsoles());
		profileController.getProfilePanel().add(profileController.getProfileModel().getProfileImage());
		profileController.getProfilePanel().add(profileController.getProfileModel().getTxtField());
		
		
		//pack and set visible
		mainFrame.pack();
		mainFrame.setVisible(true);
	}
}
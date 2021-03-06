package profilePage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import createAccount.CreateAccountPageModel;
import firebase.DBFailureException;
import graphics.Colors;
import graphics.Fonts;
import images.BackgroundPanel;
import images.CircularImage;
import images.ImgButton;
import model.ClientManager;
import model.ResourceManager;
import profileBrief.ProfileBioBox;

/**
 * The Class ProfilePageView.
 */
public class ProfilePageView {
	
	/** The logger. */
	private static Logger logger = Logger.getLogger(ProfilePageView.class.getName());
	
	/**
	 * Start profile page.
	 *
	 * @param profileController the profile controller
	 * @param mainFrame the main frame
	 */
	public static void startProfilePage(ProfilePageController profileController, JFrame mainFrame) {
		//init Model
		profileController.setProfileModel(new ProfilePageModel());
		JLabel heartImage = new JLabel();
		//init panel
		profileController.setProfilePanel(new BackgroundPanel(null));
		profileController.getProfilePanel().setBorder(new EmptyBorder(5, 5, 5, 5));
		profileController.getProfilePanel().setPreferredSize(new Dimension(500,400));
		profileController.getProfilePanel().setMaximumSize(new Dimension(500,400));
		mainFrame.setContentPane(profileController.getProfilePanel());
		
		
		//init buttons
		ImgButton btnBack = new ImgButton("Back");
		btnBack.setBounds(10,10,110,40);
		btnBack.setActionCommand(ProfilePageController.BACK);
		btnBack.setBackground(Colors.Yellow);
		btnBack.setFont(Fonts.getFont((float)12));
		btnBack.setForeground(Colors.Red);
		btnBack.addActionListener(profileController);
		profileController.getProfileModel().setBtnBack(btnBack);
		
		//	pull information for fields from account passed 
		if(profileController.isActiveAccount()) {
			CircularImage imgLabel = new CircularImage();
			BufferedImage img = null;
			
			try {
				img = ClientManager.getProfileImage(ClientManager.getActiveUserID());
				
			} catch (DBFailureException e) {
				logger.warning("failed to load profile picture for " + ClientManager.getActiveUserID());
				img = ResourceManager.loadImage("defaultIcon.png");
			}
			
			if(img == null) {
				img = ResourceManager.loadImage("defaultIcon.png");
			}
			
			imgLabel.setIcon(new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
			imgLabel.setBounds(10, 60, 100, 100);
			profileController.getProfileModel().setProfileImage(imgLabel);
			ImgButton btnEdit = new ImgButton("Edit Profile");
			btnEdit.setBounds(370,10,120,40);
			btnEdit.setActionCommand(ProfilePageController.EDIT_ACCOUNT);
			btnEdit.setBackground(Colors.Yellow);
			btnEdit.setFont(Fonts.getFont((float)12));
			btnEdit.setForeground(Colors.Red);
			btnEdit.addActionListener(profileController);
			profileController.getProfileModel().setBtnEdit(btnEdit);
			profileController.getProfilePanel().add(profileController.getProfileModel().getBtnEdit());
		
		} else {
			CircularImage imgLabel = new CircularImage();
			BufferedImage img = null;
			try {
				img = ClientManager.getProfileImage(profileController.getProfile().getUserId());
			} catch (DBFailureException e) {
				logger.warning("failed to load profile picture for " + ClientManager.getOtherProfile().getUserId());
			}
			
			if(img == null) {
				img = CreateAccountPageModel.DEFAULT_PROFILE_IMAGE;
			}
			
			imgLabel.setIcon(new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
			imgLabel.setBounds(10, 60, 100, 100);
			profileController.getProfileModel().setProfileImage(imgLabel);
			ImgButton btnBlock = new ImgButton("Block");
			btnBlock.setBounds(370, 330, 90, 40);
			btnBlock.setActionCommand(ProfilePageController.BLOCK);
			btnBlock.setBackground(Colors.Yellow);
			btnBlock.addActionListener(profileController);
			btnBlock.setFont(Fonts.getFont((float)12));
			btnBlock.setForeground(Colors.Red);
			profileController.getProfileModel().setBtnBlock(btnBlock);
			profileController.getProfilePanel().add(profileController.getProfileModel().getBtnBlock());
			
			try {
				if (ClientManager.getMatch(ClientManager.getActiveAccount().getAccountProfile(),
						ClientManager.getOtherProfile()).getClientMatchStatus()
						.equals(ClientManager.getMatch(ClientManager.getActiveAccount().getAccountProfile()
								,ClientManager.getOtherProfile()).getOtherMatchStatus())) {
					
					ImgButton btnMessage = new ImgButton("Message");
					btnMessage.setBounds(370,270,90,40);
					btnMessage.setActionCommand(ProfilePageController.MESSAGE);
					btnMessage.setBackground(Colors.Yellow);
					btnMessage.setFont(Fonts.getFont((float)12));
					btnMessage.setForeground(Colors.Red);
					btnMessage.addActionListener(profileController);
					profileController.getProfileModel().setBtnMessage(btnMessage);
					profileController.getProfilePanel().add(profileController.getProfileModel().getBtnMessage());
				}
				
			}catch (Exception e) {
				
			}
		}
		
		//init Labels
		JLabel lblBeMyPlayer = new JLabel("Be My Player 2");
		lblBeMyPlayer.setFont(Fonts.getFont((float) 20));
		lblBeMyPlayer.setForeground(Colors.Yellow);
		lblBeMyPlayer.setBounds(145,0,204,69);
		profileController.getProfileModel().setLblBeMyPlayer(lblBeMyPlayer);
		
		BufferedImage img1 = ResourceManager.loadImage("splash_heart.png");
		heartImage .setIcon(new ImageIcon(new ImageIcon(img1).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
		heartImage.setBounds(315, 22, 30, 30);
		
		
		
		JLabel lblUsername = new JLabel();
		lblUsername.setText(profileController.getProfile().getUsername());
		lblUsername.setFont(Fonts.getFont((float)15));
		lblUsername.setForeground(Colors.Yellow);
		lblUsername.setBounds(120,35, 120,90);
		profileController.getProfileModel().setLblUsername(lblUsername);
		

		/*Age stuff*/
		JLabel lblAge = new JLabel();
		LocalDate now = LocalDate.now();
		Date nowDate = java.sql.Date.valueOf(now);
		Calendar cnow = Calendar.getInstance();
		cnow.setTime(nowDate);
		Date bday = profileController.getProfile().getDateOB();
		Calendar cbday = Calendar.getInstance();
		cbday.setTime(bday);
		int diff = cnow.get(Calendar.YEAR) - cbday.get(Calendar.YEAR);
		if(cnow.get(Calendar.MONTH) == cbday.get(Calendar.MONTH) && cnow.get(Calendar.DATE) < cbday.get(Calendar.DATE) ) {
			diff--;
		} else if(cnow.get(Calendar.MONTH) < cbday.get(Calendar.MONTH)) {
			diff --;
		}
		lblAge.setFont(Fonts.getFont(12f));
		lblAge.setText(Integer.toString(diff) + " years old");
		lblAge.setForeground(Colors.Yellow);
		lblAge.setBounds(120,65,150,90);
		profileController.getProfileModel().setLblAge(lblAge);
		
		JLabel lblGender = new JLabel();
		lblGender.setText(profileController.getProfile().getGender());
		lblGender.setForeground(Colors.Yellow);
		lblGender.setFont(Fonts.getFont(12f));
		lblGender.setBounds(120,95,90,90);
		profileController.getProfileModel().setLblGender(lblGender);
		
		JLabel lblConsoles = new JLabel("Consoles:");
		lblConsoles.setForeground(Colors.Yellow);
		lblConsoles.setFont(Fonts.getFont(12f));
		lblConsoles.setBounds(370,30,90,90);
		profileController.getProfileModel().setLblConsoles(lblConsoles);
		
		//init description
		ProfileBioBox description = new ProfileBioBox();
		if(profileController.isActiveAccount()) {
			description.setText(ClientManager.getActiveAccount().getAccountProfile().getDescription());
		}
		else {
			description.setText(profileController.getProfile().getDescription());
		}
		
		
		description.setBounds(20, 170, 300, 200);
		description.setOpaque(false);
		description.setForeground(Colors.Yellow);
		description.setHorizontalAlignment(JTextField.LEFT);
		description.setVerticalAlignment(JTextField.NORTH);
		profileController.getProfileModel().setTxtField(description);
		
		//checkbox
		profileController.getProfileModel().setCheckList(new ArrayList<JCheckBox>());
		JCheckBox xboxBtn = new JCheckBox("Xbox");
		if(profileController.getProfile().getPlatforms().get(0)) {
			xboxBtn.setSelected(true);
		}
		xboxBtn.setEnabled(false);
		xboxBtn.setBackground(Colors.Red);
		xboxBtn.setForeground(Colors.Yellow);
		xboxBtn.setFont(Fonts.getFont((float)14));
		xboxBtn.setBounds(370, 100, 75, 25);
		profileController.getProfileModel().getCheckList().add(xboxBtn);
		profileController.getProfilePanel().add(xboxBtn);
		

		JCheckBox psBtn = new JCheckBox("Playstation");
		if(profileController.getProfile().getPlatforms().get(1)) {
			psBtn.setSelected(true);
		}
		psBtn.setEnabled(false);
		psBtn.setBackground(Colors.Red);
		psBtn.setForeground(Colors.Yellow);
		psBtn.setFont(Fonts.getFont(14f));
		psBtn.setBounds(370, 125, 120, 25);
		profileController.getProfileModel().getCheckList().add(psBtn);
		profileController.getProfilePanel().add(psBtn);
		
		
		JCheckBox nintendoBtn = new JCheckBox("Nintendo");if(profileController.getProfile().getPlatforms().get(2)) {
			nintendoBtn.setSelected(true);
		}
		nintendoBtn.setEnabled(false);
		nintendoBtn.setBackground(Colors.Red);
		nintendoBtn.setForeground(Colors.Yellow);
		nintendoBtn.setFont(Fonts.getFont(14f));
		nintendoBtn.setBounds(370, 150, 120, 25);
		profileController.getProfileModel().getCheckList().add(nintendoBtn);
		profileController.getProfilePanel().add(nintendoBtn);
		
		
		JCheckBox pcBtn = new JCheckBox("PC");
		if(profileController.getProfile().getPlatforms().get(3)) {
			pcBtn.setSelected(true);
		}
		pcBtn.setEnabled(false);
		pcBtn.setBackground(Colors.Red);
		pcBtn.setForeground(Colors.Yellow);
		pcBtn.setFont(Fonts.getFont(14f));
		pcBtn.setBounds(370, 175, 75, 25);
		
		profileController.getProfileModel().getCheckList().add(pcBtn);
		profileController.getProfilePanel().add(pcBtn);
		
		
		JCheckBox vrBtn = new JCheckBox("VR");
		if(profileController.getProfile().getPlatforms().get(4)) {
			vrBtn.setSelected(true);
		}
		vrBtn.setEnabled(false);
		vrBtn.setBackground(Colors.Red);
		vrBtn.setForeground(Colors.Yellow);
		vrBtn.setFont(Fonts.getFont(14f));
		vrBtn.setBounds(370, 200, 75, 25);
		profileController.getProfileModel().getCheckList().add(vrBtn);
		profileController.getProfilePanel().add(vrBtn);
		
		
		JCheckBox RetroBtn = new JCheckBox("Retro");if(profileController.getProfile().getPlatforms().get(5)) {
			RetroBtn.setSelected(true);
		}
		RetroBtn.setEnabled(false);
		RetroBtn.setBackground(Colors.Red);
		RetroBtn.setForeground(Colors.Yellow);
		RetroBtn.setFont(Fonts.getFont(14f));
		RetroBtn.setBounds(370, 225, 75, 25);
		profileController.getProfileModel().getCheckList().add(RetroBtn);
		profileController.getProfilePanel().add(RetroBtn);

		
		//add to panel
		profileController.getProfilePanel().add(heartImage);
		profileController.getProfilePanel().add(profileController.getProfileModel().getBtnBack());
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
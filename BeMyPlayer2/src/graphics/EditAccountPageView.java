package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class EditAccountPageView {
	
	public static void launchEditPage(EditAccountPageController editController, JFrame mainFrame) {
		//set model
		editController.setEditAccountModel(new EditAccountPageModel());
		//init colors
		Color red = new Color(128,0,0);
		Color yellow = new Color(255,215,0);
		//	init panel
		editController.setEditAccountPanel(new JPanel(null));
		editController.getEditAccountPanel().setBorder(new EmptyBorder(5, 5, 5, 5));
		editController.getEditAccountPanel().setPreferredSize(new Dimension(500,400));
		editController.getEditAccountPanel().setMaximumSize(new Dimension(500,400));
		mainFrame.setContentPane(editController.getEditAccountPanel());
		mainFrame.getContentPane().setBackground(red);
		
		//init bemyplayer2 label
		JLabel lblBeMyPlayer = new JLabel("Be My Player 2");
		lblBeMyPlayer.setForeground(yellow);
		lblBeMyPlayer.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblBeMyPlayer.setBounds(160,0,204,69);
		editController.getEditAccountModel().setLblBeMyPlayer(lblBeMyPlayer);
		
		//init Buttons
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(10,10,90,40);
		btnBack.setBackground(yellow);
		btnBack.setActionCommand(editController.BACK);
		btnBack.addActionListener(editController);
		editController.getEditAccountModel().setBtnBack(btnBack);
		
		JButton btnProfile = new JButton("Edit Profile Details");
		btnProfile.setBounds(100,100,150,40);
		btnProfile.setBackground(yellow);
		btnProfile.setActionCommand(editController.PROFILE);
		btnProfile.addActionListener(editController);
		editController.getEditAccountModel().setBtnProfile(btnProfile);
		
		JButton btnQuestionnaire = new JButton("Edit Gaming Details");
		btnQuestionnaire.addActionListener(editController);
		btnQuestionnaire.setBounds(100,150,150,40);
		btnQuestionnaire.setBackground(yellow);
		btnQuestionnaire.setActionCommand(editController.QUESTIONNAIRE);
		editController.getEditAccountModel().setBtnQuestionnaire(btnQuestionnaire);
		
		JButton btnAccount = new JButton("Edit Account Details");
		btnAccount.setBounds(100,200,150,40);
		btnAccount.setBackground(yellow);
		btnAccount.setActionCommand(editController.ACCOUNT);
		btnAccount.addActionListener(editController);
		editController.getEditAccountModel().setBtnAccount(btnAccount);
		
		JButton btnUpgrade = new JButton("Upgrade Account!");
		btnUpgrade.setBounds(100,250,150,40);
		btnUpgrade.setBackground(yellow);
		btnUpgrade.setActionCommand(editController.UPGRADE);
		btnUpgrade.addActionListener(editController);
		editController.getEditAccountModel().setBtnUpgrade(btnUpgrade);
		
		//add to panel
		editController.getEditAccountPanel().add(editController.getEditAccountModel().getBtnBack());
		editController.getEditAccountPanel().add(editController.getEditAccountModel().getBtnProfile());
		editController.getEditAccountPanel().add(editController.getEditAccountModel().getBtnQuestionnaire());
		editController.getEditAccountPanel().add(editController.getEditAccountModel().getBtnAccount());
		editController.getEditAccountPanel().add(editController.getEditAccountModel().getBtnUpgrade());
		editController.getEditAccountPanel().add(editController.getEditAccountModel().getLblBeMyPlayer());
		
		//pack and make visible
		mainFrame.pack();
		mainFrame.setVisible(true);
		
	}
	
	public static void launchEditAccountPage(EditAccountPageController editController, JFrame mainFrame) {
	
		//get mdoel
		editController.setEditAccountModel(new EditAccountPageModel());

		//init colors
		Color red = new Color(128,0,0);
		Color yellow = new Color(255,215,0);
		
		//	init panel
		editController.setEditAccountPanel(new JPanel(null));
		editController.getEditAccountPanel().setBorder(new EmptyBorder(5, 5, 5, 5));
		editController.getEditAccountPanel().setPreferredSize(new Dimension(500,400));
		editController.getEditAccountPanel().setMaximumSize(new Dimension(500,400));
		mainFrame.setContentPane(editController.getEditAccountPanel());
		mainFrame.getContentPane().setBackground(red);
		
		
		//	init buttons and add to panel
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(45,345,90,40);
		btnCancel.setBackground(yellow);
		btnCancel.setActionCommand(editController.CANCEL);
		btnCancel.addActionListener(editController);
		editController.getEditAccountModel().setBtnCancel(btnCancel);
		editController.getEditAccountPanel().add(editController.getEditAccountModel().getBtnCancel());
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(345,345,90,40);
		btnSubmit.setBackground(yellow);
		btnSubmit.setActionCommand(editController.SUBMIT);
		btnSubmit.addActionListener(editController);
		editController.getEditAccountModel().setBtnSubmit(btnSubmit);
		editController.getEditAccountPanel().add(editController.getEditAccountModel().getBtnSubmit());
		
		
		//	init fields and listeners 
		JPasswordField pwdEnterPass = new JPasswordField();
		pwdEnterPass.setHorizontalAlignment(SwingConstants.CENTER);
		pwdEnterPass.setBounds(45, 165, 128, 32);
		editController.getEditAccountModel().setPwdEnterPass(pwdEnterPass);
		editController.getEditAccountPanel().add(editController.getEditAccountModel().getPwdEnterPass());
		
		
		JPasswordField pwdValidatePass= new JPasswordField();
		pwdValidatePass.setHorizontalAlignment(SwingConstants.CENTER);
		
		pwdValidatePass.setBounds(45, 240, 128, 32);
		editController.getEditAccountModel().setPwdValidatePass(pwdValidatePass);
		editController.getEditAccountPanel().add(editController.getEditAccountModel().getPwdValidatePass());
		
		JFormattedTextField frmtdtxtfldEnterUsername = new JFormattedTextField();
		frmtdtxtfldEnterUsername.setHorizontalAlignment(SwingConstants.CENTER);
		
		frmtdtxtfldEnterUsername.setBounds(45, 95, 128, 32);
		editController.getEditAccountModel().setFrmtdtxtfldEnterUsername(frmtdtxtfldEnterUsername);
		editController.getEditAccountPanel().add(editController.getEditAccountModel().getFrmtdtxtfldEnterUsername());
		
		JFormattedTextField secQA = new JFormattedTextField();
		secQA.setHorizontalAlignment(SwingConstants.CENTER);
		secQA.setText("");
		
		secQA.setBounds(275, 205, 128, 32);
		editController.getEditAccountModel().setSecQA(secQA);
		editController.getEditAccountPanel().add(editController.getEditAccountModel().getSecQA());
		
		JFormattedTextField age = new JFormattedTextField();
		age.setHorizontalAlignment(SwingConstants.CENTER);
		
		//age.setText("enter age");
		age.setBounds(275, 95, 128, 32);
		editController.getEditAccountModel().setAge(age);
		editController.getEditAccountPanel().add(age);
		//	init drop downs
		
		JComboBox gender = new JComboBox();
		gender.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) {
        		editController.getEditAccountModel().setGender(e.getItem().toString());
        		//capController.getCreateAccountPageModel().setGender(e.getItem().toString());
        	}
        });
		gender.setToolTipText("Gender");
		gender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		gender.setBounds(275, 275, 94, 22);
		gender.setVisible(true);
		
		editController.getEditAccountModel().setGenderBox(gender);
		editController.getEditAccountPanel().add(gender);
		
		//	security question
		JComboBox securityQuestions = new JComboBox();
		securityQuestions.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) {
        		editController.getEditAccountModel().setSecurityQuestions(e.getItem().toString());
        	}
        });
		securityQuestions.setToolTipText("Security Question");
		securityQuestions.setModel(new DefaultComboBoxModel(new String[] {"Q1", "Q2"}));
		securityQuestions.setBounds(275, 170, 94, 22);
		securityQuestions.setVisible(true);
		
		editController.getEditAccountModel().setSecurityQ(securityQuestions);
		editController.getEditAccountPanel().add(securityQuestions);
		
		//	set text
		JLabel lblAccInfo = new JLabel("Account Info");
		lblAccInfo.setForeground(yellow);
		lblAccInfo.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblAccInfo.setBounds(45, 0, 204, 69);
		editController.getEditAccountPanel().add(lblAccInfo);
		//capController.getCreateAccountPanel().add(lblAccInfo);
		
		JLabel lbldob = new JLabel("Age:");
		lbldob.setForeground(yellow);
		lbldob.setFont(new Font("Monospaced", Font.BOLD, 12));
		lbldob.setBounds(275, 65, 204, 32);
		editController.getEditAccountPanel().add(lbldob);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(yellow);
		lblGender.setFont(new Font("Monospaced", Font.BOLD, 12));
		lblGender.setBounds(275, 245, 204, 32);	
		editController.getEditAccountPanel().add(lblGender);
		
		JLabel lblSecQ = new JLabel("Security Question");
		lblSecQ.setForeground(yellow);
		lblSecQ.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblSecQ.setBounds(275, 110, 204, 69);
		editController.getEditAccountPanel().add(lblSecQ);
	
		JLabel pwdField1Prmpt = new JLabel("Enter Password:");
		pwdField1Prmpt.setForeground(yellow);
		pwdField1Prmpt.setFont(new Font("Monospaced",Font.BOLD,12));
		pwdField1Prmpt.setBounds(45, 135, 128, 32);
		editController.getEditAccountPanel().add(pwdField1Prmpt);
		
		JLabel pwdfield2PrmptLoc = new JLabel("Re-enter Password:");
		pwdfield2PrmptLoc.setForeground(yellow);
		pwdfield2PrmptLoc.setFont(new Font("Monospaced",Font.BOLD,12));
		pwdfield2PrmptLoc.setBounds(45,205,155,32);
		editController.getEditAccountPanel().add(pwdfield2PrmptLoc);
		
		JLabel userFieldPrmptLoc = new JLabel("Enter Username:");
		userFieldPrmptLoc.setForeground(yellow);
		userFieldPrmptLoc.setFont(new Font("Monospaced",Font.BOLD,12));
		userFieldPrmptLoc.setBounds(45,65,128,32);
		editController.getEditAccountPanel().add(userFieldPrmptLoc);
		
		JLabel answerPrompt = new JLabel("Answer:");
		answerPrompt.setForeground(yellow);
		answerPrompt.setFont(new Font("Monospaced",Font.BOLD,12));
		answerPrompt.setBounds(220,205,128,32);
		editController.getEditAccountPanel().add(answerPrompt);
		
		//add to panel
		
		//	set attributes, pack and set visible 
		mainFrame.pack();
		mainFrame.setVisible(true);
		//set attributes in loginController:
	}
	
	public static void launchEditQuestionnairePage(EditAccountPageController editController, JFrame mainFrame) {
		
		//init colors
		Color red = new Color(128,0,0);
		Color yellow = new Color(255,215,0);
		
		//	 set up panel

		editController.setEditAccountPanel(new JPanel(null));
		editController.getEditAccountPanel().setBorder(new EmptyBorder(5, 5, 5, 5));
		editController.getEditAccountPanel().setPreferredSize(new Dimension(500,400));
		editController.getEditAccountPanel().setMaximumSize(new Dimension(500,400));
		mainFrame.setContentPane(editController.getEditAccountPanel());
		mainFrame.getContentPane().setBackground(red);

		//Checkboxes
		editController.getEditAccountModel().setCheckList(new ArrayList<>());
		
		JCheckBox xboxBtn = new JCheckBox("Xbox");
		xboxBtn.setBackground(red);
		xboxBtn.setForeground(yellow);
		xboxBtn.setFont(new Font("Monospace",Font.BOLD,14));
		xboxBtn.setBounds(45, 80, 75, 25);
		editController.getEditAccountModel().getCheckList().add(xboxBtn);
		editController.getEditAccountPanel().add(xboxBtn);
		

		JCheckBox psBtn = new JCheckBox("Playstation");
		psBtn.setBackground(red);
		psBtn.setForeground(yellow);
		psBtn.setFont(new Font("Monospace",Font.BOLD,14));
		psBtn.setBounds(45, 105, 120, 25);
		editController.getEditAccountModel().getCheckList().add(psBtn);
		editController.getEditAccountPanel().add(psBtn);
		
		
		JCheckBox nintendoBtn = new JCheckBox("Nintendo");
		nintendoBtn.setBackground(red);
		nintendoBtn.setForeground(yellow);
		nintendoBtn.setFont(new Font("Monospace",Font.BOLD,14));
		nintendoBtn.setBounds(45, 130, 120, 25);
		editController.getEditAccountModel().getCheckList().add(nintendoBtn);
		editController.getEditAccountPanel().add(nintendoBtn);
		
		
		JCheckBox pcBtn = new JCheckBox("PC");
		pcBtn.setBackground(red);
		pcBtn.setForeground(yellow);
		pcBtn.setFont(new Font("Monospace",Font.BOLD,14));
		pcBtn.setBounds(45, 155, 75, 25);
		editController.getEditAccountModel().getCheckList().add(pcBtn);
		editController.getEditAccountPanel().add(pcBtn);
		
		
		JCheckBox vrBtn = new JCheckBox("VR");
		vrBtn.setBackground(red);
		vrBtn.setForeground(yellow);
		vrBtn.setFont(new Font("Monospace",Font.BOLD,14));
		vrBtn.setBounds(45, 180, 75, 25);
		editController.getEditAccountModel().getCheckList().add(vrBtn);
		editController.getEditAccountPanel().add(vrBtn);
		
		
		JCheckBox RetroBtn = new JCheckBox("Retro");
		RetroBtn.setBackground(red);
		RetroBtn.setForeground(yellow);
		RetroBtn.setFont(new Font("Monospace",Font.BOLD,14));
		RetroBtn.setBounds(45, 205, 75, 25);
		editController.getEditAccountModel().getCheckList().add(RetroBtn);
		editController.getEditAccountPanel().add(RetroBtn);
		
		
		//	action adventure fps mmo moba puzzle platformer rythem rpg rts strategy sandbox 
		//	genres
		JCheckBox actionBtn = new JCheckBox("Action");
		actionBtn.setBackground(red);
		actionBtn.setForeground(yellow);
		actionBtn.setFont(new Font("Monospace",Font.BOLD,14));
		actionBtn.setBounds(245, 80, 75, 25);
		editController.getEditAccountModel().getCheckList().add(actionBtn);
		editController.getEditAccountPanel().add(actionBtn);
		
		
		JCheckBox advBtn = new JCheckBox("Adventure");
		advBtn.setBackground(red);
		advBtn.setForeground(yellow);
		advBtn.setFont(new Font("Monospace",Font.BOLD,14));
		advBtn.setBounds(245, 105, 120, 25);
		editController.getEditAccountModel().getCheckList().add(advBtn);
		editController.getEditAccountPanel().add(advBtn);
		
		
		JCheckBox FPSBtn = new JCheckBox("FPS");
		FPSBtn.setBackground(red);
		FPSBtn.setForeground(yellow);
		FPSBtn.setFont(new Font("Monospace",Font.BOLD,14));
		FPSBtn.setBounds(245, 130, 120, 25);
		editController.getEditAccountModel().getCheckList().add(FPSBtn);
		editController.getEditAccountPanel().add(FPSBtn);
		
		
		JCheckBox MMOBtn = new JCheckBox("MMO");
		MMOBtn.setBackground(red);
		MMOBtn.setForeground(yellow);
		MMOBtn.setFont(new Font("Monospace",Font.BOLD,14));
		MMOBtn.setBounds(245, 155, 75, 25);
		editController.getEditAccountModel().getCheckList().add(MMOBtn);
		editController.getEditAccountPanel().add(MMOBtn);
		
		
		JCheckBox MOBABtn = new JCheckBox("MOBA");
		MOBABtn.setBackground(red);
		MOBABtn.setForeground(yellow);
		MOBABtn.setFont(new Font("Monospace",Font.BOLD,14));
		MOBABtn.setBounds(245, 180, 75, 25);
		editController.getEditAccountModel().getCheckList().add(MOBABtn);
		editController.getEditAccountPanel().add(MOBABtn);
		
		
		JCheckBox pzlBtn = new JCheckBox("Puzzle");
		pzlBtn.setBackground(red);
		pzlBtn.setForeground(yellow);
		pzlBtn.setFont(new Font("Monospace",Font.BOLD,14));
		pzlBtn.setBounds(245, 205, 125, 25);
		editController.getEditAccountModel().getCheckList().add(pzlBtn);
		editController.getEditAccountPanel().add(pzlBtn);
		
		
		JCheckBox rythBtn = new JCheckBox("Rythm");
		rythBtn.setBackground(red);
		rythBtn.setForeground(yellow);
		rythBtn.setFont(new Font("Monospace",Font.BOLD,14));
		rythBtn.setBounds(365, 80, 75, 25);
		editController.getEditAccountModel().getCheckList().add(RetroBtn);
		editController.getEditAccountPanel().add(rythBtn);
		
		
		JCheckBox platBtn = new JCheckBox("Platformer");
		platBtn.setBackground(red);
		platBtn.setForeground(yellow);
		platBtn.setFont(new Font("Monospace",Font.BOLD,14));
		platBtn.setBounds(365, 105, 125, 25);
		editController.getEditAccountModel().getCheckList().add(platBtn);
		editController.getEditAccountPanel().add(platBtn);
		
		
		JCheckBox RTSBtn = new JCheckBox("RTS");
		RTSBtn.setBackground(red);
		RTSBtn.setForeground(yellow);
		RTSBtn.setFont(new Font("Monospace",Font.BOLD,14));
		RTSBtn.setBounds(365, 130, 75, 25);
		editController.getEditAccountModel().getCheckList().add(RTSBtn);
		editController.getEditAccountPanel().add(RTSBtn);
		
		
		JCheckBox RPGBtn = new JCheckBox("RPG");
		RPGBtn.setBackground(red);
		RPGBtn.setForeground(yellow);
		RPGBtn.setFont(new Font("Monospace",Font.BOLD,14));
		RPGBtn.setBounds(365, 155, 75, 25);
		editController.getEditAccountModel().getCheckList().add(RPGBtn);
		editController.getEditAccountPanel().add(RPGBtn);
		
		
		JCheckBox stratBtn = new JCheckBox("Strategy");
		stratBtn.setBackground(red);
		stratBtn.setForeground(yellow);
		stratBtn.setFont(new Font("Monospace",Font.BOLD,14));
		stratBtn.setBounds(365, 180, 125, 25);
		editController.getEditAccountModel().getCheckList().add(stratBtn);
		editController.getEditAccountPanel().add(stratBtn);
		
		JCheckBox sandBtn = new JCheckBox("Sandbox");
		sandBtn.setBackground(red);
		sandBtn.setForeground(yellow);
		sandBtn.setFont(new Font("Monospace",Font.BOLD,14));
		sandBtn.setBounds(365, 205, 125, 25);
		editController.getEditAccountModel().getCheckList().add(sandBtn);
		editController.getEditAccountPanel().add(sandBtn);
		
		
		//		init buttons and add to panel
		JButton backbtn = new JButton("Cancel");
		backbtn.setBounds(45, 345, 90, 40);
		backbtn.setBackground(yellow);
		backbtn.setActionCommand(EditAccountPageController.CANCEL);
		backbtn.addActionListener(editController);
		editController.getEditAccountModel().setBtnCancel(backbtn);
		editController.getEditAccountPanel().add(backbtn);
		
		JButton nextbtn = new JButton("Submit");
		nextbtn.setBounds(345, 345, 90, 40);
		nextbtn.setBackground(yellow);
		nextbtn.setActionCommand(EditAccountPageController.SUBMIT);
		nextbtn.addActionListener(editController);
		editController.getEditAccountModel().setBtnSubmit(nextbtn);
		editController.getEditAccountPanel().add(nextbtn);
	
		
		//	Labels 
		JLabel choosePlatPrmpt = new JLabel("Gaming platforms");
		choosePlatPrmpt.setForeground(yellow);
		choosePlatPrmpt.setFont(new Font("Monospaced", Font.BOLD, 18));
		choosePlatPrmpt.setBounds(25, 0, 300, 69);
		editController.getEditAccountPanel().add(choosePlatPrmpt);
		
		JLabel chooseGenrePrmpt = new JLabel("Favorite genres");
		chooseGenrePrmpt.setForeground(yellow);
		chooseGenrePrmpt.setFont(new Font("Monospaced", Font.BOLD, 16));
		chooseGenrePrmpt.setBounds(245, 0, 250, 69);
		editController.getEditAccountPanel().add(chooseGenrePrmpt);
		
		
		//pack and make visible
		mainFrame.pack();
		mainFrame.setVisible(true);
	}
	
	public static void launchEditProfilePage(EditAccountPageController editController, JFrame mainFrame) {
		
		//init colors
		Color red = new Color(128,0,0);
		Color yellow = new Color(255,215,0);
		
		//	 set up panel
		editController.setEditAccountPanel(new JPanel(null));
		editController.getEditAccountPanel().setBorder(new EmptyBorder(5, 5, 5, 5));
		editController.getEditAccountPanel().setPreferredSize(new Dimension(500,400));
		editController.getEditAccountPanel().setMaximumSize(new Dimension(500,400));
		mainFrame.setContentPane(editController.getEditAccountPanel());
		mainFrame.getContentPane().setBackground(red);
		
		//	default icon
		Image img1;

		img1 = new ImageIcon(editController.getClass().getResource("/defaultIcon.png")).getImage();
		
		
		//lblNewLabel.setIcon(new ImageIcon(new ImageIcon(img1).getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT)));
		//lblNewLabel.setBounds(75, 25, 150, 150);
		editController.getEditAccountModel().setImagePath(img1.toString());
		final JButton setIcon = new JButton(new ImageIcon(new ImageIcon(img1).getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT)));
		setIcon.setBounds(125,25,150,150);
		setIcon.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e) {
                addActionPerformed();
            }

			private void addActionPerformed() {
				//				load images
				JFileChooser fc = new JFileChooser();
				FileFilter imageFilter = new FileNameExtensionFilter(
					    "Image files", ImageIO.getReaderFileSuffixes());
				fc.addChoosableFileFilter(imageFilter);
				fc.setAcceptAllFileFilterUsed(false);
				fc.setCurrentDirectory(new java.io.File("."));
				Image img1 = null;
				//	force file chooser
				File f = null;
				int returnValue = fc.showOpenDialog(null);
				if(returnValue == JFileChooser.APPROVE_OPTION) {
					f = fc.getSelectedFile();
				}
				
//				set images
				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				if(f != null) {
					img1 = new ImageIcon(f.getAbsolutePath()).getImage();
					editController.getEditAccountModel().setImagePath(f.getAbsolutePath());
				}
				else if(f == null){
					img1 = new ImageIcon(editController.getClass().getResource("/defaultIcon.png")).getImage();
					editController.getEditAccountModel().setImagePath(img1.toString());
				}
				setIcon.setIcon(new ImageIcon(new ImageIcon(img1).getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT)));
				//setIcon.setIcon(new ImageIcon(new ImageIcon(img1).getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT)));
				setIcon.setBounds(125, 25, 150, 150);
				editController.getEditAccountModel().setProfileImg(img1);
				
			}});
		editController.getEditAccountPanel().add(setIcon);
		
		//	text field
		JLabel lblAccInfo = new JLabel("<--- Set Avatar");
		lblAccInfo.setForeground(yellow);
		lblAccInfo.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblAccInfo.setBounds(300, 0, 215, 115);
		editController.getEditAccountPanel().add(lblAccInfo);
		
		//	description box
		JFormattedTextField description = new JFormattedTextField();
		description.setHorizontalAlignment(SwingConstants.CENTER);

		description.setBounds(125, 230, 250, 150);
		editController.getEditAccountModel().setCharDescription(description);
		editController.getEditAccountPanel().add(editController.getEditAccountModel().getCharDescription());
		
		//	load submit button
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(385, 345, 90, 40);
		btnSubmit.setBackground(yellow);
		btnSubmit.setActionCommand(EditAccountPageController.SUBMIT);
		btnSubmit.addActionListener(editController);
		editController.getEditAccountModel().setBtnSubmit(btnSubmit);
		editController.getEditAccountPanel().add(btnSubmit);
		
		//	load back button
		JButton backbtn = new JButton("Cancel");
		backbtn.setBounds(25, 345, 90, 40);
		backbtn.setBackground(yellow);
		backbtn.setActionCommand(EditAccountPageController.CANCEL);
		backbtn.addActionListener(editController);
		editController.getEditAccountModel().setBtnCancel(backbtn);
		editController.getEditAccountPanel().add(editController.getEditAccountModel().getBtnCancel());
		
		JLabel descritionPrmpt = new JLabel("Describe yourself:");
		descritionPrmpt.setForeground(yellow);
		descritionPrmpt.setFont(new Font("Monospaced",Font.BOLD,20));
		descritionPrmpt.setBounds(125,190,265,32);
		editController.getEditAccountPanel().add(descritionPrmpt);
		
		//pack and set visible
		mainFrame.pack();
		mainFrame.setVisible(true);

	}

}
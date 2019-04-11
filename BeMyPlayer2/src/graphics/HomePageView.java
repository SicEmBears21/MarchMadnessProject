package graphics;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class HomePageView {
	
	public static void launchHomePage(HomePageController homeController, JFrame mainFrame) {
		//init model
		homeController.setHomePageModel(new HomePageModel());
		
		//init colors
		Color red = new Color(134,48,111);
		Color yellow = new Color(254, 195, 123);
		
		//init panel
		homeController.setHomePanel(new BackgroundPanel(null));
		homeController.getHomePanel().setBorder(new EmptyBorder(5, 5, 5, 5));
		homeController.getHomePanel().setPreferredSize(new Dimension(500,400));
		homeController.getHomePanel().setMaximumSize(new Dimension(500,400));
		mainFrame.setContentPane(homeController.getHomePanel());

		//init buttons
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(10, 10, 90, 40);
		btnLogout.setActionCommand(homeController.LOGOUT);
		btnLogout.setBackground(yellow);
		btnLogout.setFont(Fonts.getFont((float) 12));
		btnLogout.setForeground(Colors.Red);
		btnLogout.addActionListener(homeController);
		homeController.getHomePageModel().setBtnLogout(btnLogout);
		
		JButton btnAccount = new JButton("My Profile");
		btnAccount.setBounds(390,10,100,40);
		btnAccount.setActionCommand(homeController.ACCOUNT);
		btnAccount.setBackground(yellow);
		btnAccount.setFont(Fonts.getFont((float) 12));
		btnAccount.setForeground(Colors.Red);
		btnAccount.addActionListener(homeController);
		homeController.getHomePageModel().setBtnProfile(btnAccount);
		
		JButton btnLove = new JButton("Find Love");
		btnLove.setBounds(30,100,200,140);
		btnLove.setActionCommand(homeController.FIND_LOVE);
		btnLove.setBackground(yellow);
		btnLove.setFont(Fonts.getFont((float) 12));
		btnLove.setForeground(Colors.Red);
		btnLove.addActionListener(homeController);
		homeController.getHomePageModel().setBtnFindLove(btnLove);
		
		JButton btnFriends = new JButton("Find Friends");
		btnFriends.setBounds(270,100,200,140);
		btnFriends.setActionCommand(homeController.FIND_FRIENDS);
		btnFriends.setBackground(yellow);
		btnFriends.setFont(Fonts.getFont((float) 12));
		btnFriends.setForeground(Colors.Red);
		btnFriends.addActionListener(homeController);
		homeController.getHomePageModel().setBtnFindFriends(btnFriends);
		
		JButton btnSupport = new JButton("<HTML><U>Support</U></HTML>");
		btnSupport.setBounds(0,360,90,40);
		btnSupport.setActionCommand(homeController.SUPPORT);
		btnSupport.setOpaque(true);
		btnSupport.setContentAreaFilled(false);
		btnSupport.setBorderPainted(false);
		btnSupport.setForeground(Colors.Yellow);
		btnSupport.setFont(Fonts.getFont((float) 12));
		
		btnSupport.addActionListener(homeController);
		homeController.getHomePageModel().setBtnSupport(btnSupport);
		
		JButton btnMatches = new JButton("View Matches");
		btnMatches.setBounds(60,270,360,90);
		btnMatches.setActionCommand(homeController.VIEW_MATCHES);
		btnMatches.setBackground(yellow);
		btnMatches.setFont(Fonts.getFont((float) 12));
		btnMatches.setForeground(Colors.Red);
		btnMatches.addActionListener(homeController);
		homeController.getHomePageModel().setBtnViewMatches(btnMatches);
		
		//init Label
		JLabel lblBeMyPlayer = new JLabel("Be My Player 2");
		lblBeMyPlayer.setFont(Fonts.getFont((float) 20));
		lblBeMyPlayer.setForeground(Colors.Yellow);
		lblBeMyPlayer.setBounds(160,0,204,69);
		homeController.getHomePageModel().setLblBeMyPlayer(lblBeMyPlayer);
		//mainFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("filepath"));
		
		
		//add to frame
		homeController.getHomePanel().add(homeController.getHomePageModel().getBtnFindFriends());
		homeController.getHomePanel().add(homeController.getHomePageModel().getBtnFindLove());
		homeController.getHomePanel().add(homeController.getHomePageModel().getBtnLogout());
		homeController.getHomePanel().add(homeController.getHomePageModel().getBtnProfile());
		homeController.getHomePanel().add(homeController.getHomePageModel().getBtnSupport());
		homeController.getHomePanel().add(homeController.getHomePageModel().getBtnViewMatches());
		homeController.getHomePanel().add(homeController.getHomePageModel().getLblBeMyPlayer());
		
		
		//pack and set visible
		mainFrame.pack();
		mainFrame.setVisible(true);
		
	}

}

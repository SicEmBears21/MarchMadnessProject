package graphics;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import firebase.DBFailureException;
import model.Account;
import model.InformationExpert;

public class ViewMatchesController extends PageController{
//	action commands 	
	public static final String NEXT = "next";
	public static final String BACK="back";
	public static final String SUBMIT = "submit";
	public static final String PROFILE = "profileclick";
	private ViewMatchesModel viewMatchesModel;
	private JPanel viewMatchesPanel;
	private int pageNum;
	private Account a;
	private JFrame copyFrame;
	private ProfileBriefModel brief = null;
	private static Logger logger = Logger.getLogger(ViewMatchesController.class.getName());
	
	public void launchPage(JFrame mainFrame, String back) {
		if(back != null) {
			backPage = back;
		}
		this.a = new Account();
		this.copyFrame = mainFrame;
		ViewMatchesView.startViewMatches(this,mainFrame,a);
	}
	//	check command 
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand() == BACK) {
			logger.info("back");
			GraphicsController.processPage(PageCreator.HOME_PAGE, backPage);
		}
		else if(e.getActionCommand() == PROFILE) {
			String text = ((JButton) e.getSource()).getName();
			logger.info("launch profile brief for: " + text);
			try {
				InformationExpert.setOtherProfile(text);
			} catch (DBFailureException e1) {
				// TODO Auto-generated catch block
				logger.warning("database failed to load profile");
			}
			if(brief == null) {
				brief = new ProfileBriefModel(InformationExpert.getOtherProfile(),new Rectangle(250,120,215,245),PageCreator.MATCHES_PAGE);
			}
			else {
				this.copyFrame.remove(brief);
				brief = new ProfileBriefModel(InformationExpert.getOtherProfile(),new Rectangle(250,120,215,245),PageCreator.MATCHES_PAGE);
			}
			this.copyFrame.add(brief);
			this.copyFrame.repaint();
		}
	}
	public JPanel getViewMatchesPanel() {
		return viewMatchesPanel;
	}
	public void setViewMatchesPanel(JPanel viewMatchesPanel) {
		this.viewMatchesPanel = viewMatchesPanel;
	}
	public ViewMatchesModel getViewMatchesModel() {
		return viewMatchesModel;
	}
	public void setViewMatchesModel(ViewMatchesModel viewMatchesModel) {
		this.viewMatchesModel = viewMatchesModel;
	}
	
}

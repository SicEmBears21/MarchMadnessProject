package credits;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import firebase.DBFailureException;
import graphics.GraphicsController;
import graphics.InvalidPopup;
import graphics.PageController;
import graphics.PageCreator;
import model.ClientManager;
import profileBrief.ProfileBriefModel;

/**
 * The Class CreditsPageController.
 */
public class CreditsPageController extends PageController{
	
	/** The Constant BACK. */
	public static final String BACK = "back";
	
	/** The Constant PROFILE. */
	public static final String PROFILE = "profileclick";
	
	/** The logger. */
	private static Logger logger = Logger.getLogger(CreditsPageController.class.getName());
	
	/** The copy frame. */
	private JFrame copyFrame = null;
	
	/** The credits panel. */
	private JPanel creditsPanel = null;
	
	/** The brief. */
	private ProfileBriefModel brief = null;
	
	/* (non-Javadoc)
	 * @see graphics.PageController#launchPage(javax.swing.JFrame, java.lang.String)
	 */
	public void launchPage(JFrame mainFrame, String back) {
		backPage = PageCreator.CREDITS_PAGE;
		this.copyFrame = mainFrame;
		CreditsPageView.launchPage(this,mainFrame);
	}
	
	/* (non-Javadoc)
	 * @see graphics.PageController#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == BACK) {
			logger.info("Returning to home page");
			GraphicsController.processPage(PageCreator.HOME_PAGE,backPage);
		}
		else if(e.getActionCommand() == PROFILE){
			String text = ((JButton) e.getSource()).getName();
			logger.info("launch profile brief for: " + text);
			try {
				ClientManager.setOtherProfile(text);
			} catch (DBFailureException e1) {
				logger.severe("database failed to load profile");
				InvalidPopup p = new InvalidPopup(this.getCreditsPanel(),"Database failed to load profiles");
			}
			if(brief == null) {
				brief = new ProfileBriefModel(ClientManager.getOtherProfile(),new Rectangle(250,120,215,245),backPage);
			}
			else {
				this.copyFrame.remove(brief);
				brief = new ProfileBriefModel(ClientManager.getOtherProfile(),new Rectangle(250,120,215,245),backPage);
			}
			this.copyFrame.add(brief);
			this.copyFrame.revalidate();
			brief.repaint();
			this.creditsPanel.revalidate();
		}
	}
	
	/**
	 * Gets the credits panel.
	 *
	 * @return the credits panel
	 */
	public JPanel getCreditsPanel() {
		return creditsPanel;
	}
	
	/**
	 * Sets the credits panel.
	 *
	 * @param creditsPanel the new credits panel
	 */
	public void setCreditsPanel(JPanel creditsPanel) {
		this.creditsPanel = creditsPanel;
	}
	
	/**
	 * Gets the creators.
	 *
	 * @return the creators
	 */
	public List<String> getCreators(){
		List<String> creators = new ArrayList<>();
		/*hardcoded accounts of creators*/
		creators.add("sBMUWYKVuwXMHUhURkgZ");
		creators.add("ye3oAXBbQIGaCkG3XNIW");
		creators.add("xIjqV0bMIM6hGW3TAsvr");
		creators.add("SaZIwE9M21H5eAc4L4qz");
		creators.add("M2npjd5rVBlQaWRd8sBs");
		creators.add("PBvdWFjjvC1FhFEmjovx");
		
		return creators;
	}
}

package messaging;

import javax.swing.*;

import firebase.DBFailureException;
import graphics.ExternalListener;
import graphics.GraphicsController;
import graphics.InvalidPopup;
import graphics.PageController;
import graphics.PageCreator;
import model.Account;
import model.Profile;
import model.ClientManager;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The Class MessageController.
 */
public class MessageController extends PageController implements ExternalListener, KeyListener{
    
    /** The Constant SEND. */
    public static final String SEND = "send";
    
    /** The Constant BACK. */
    public static final String BACK = "back";
    
    /** The Constant REFRESH. */
    public static final String REFRESH = "refresh";

    /** The message model. */
    private MessageModel messageModel = null;
    
    /** The current thread. */
    private MessageThread currentThread = null;
    
    /** The message panel. */
    private JPanel messagePanel = null;
    
    /** The account. */
    private Account account;
    
    /** The other prof. */
    private Profile otherProf; 
    
    /** The logger. */
    private static Logger logger = Logger.getLogger(MessageController.class.getName());
    
    /* (non-Javadoc)
     * @see graphics.PageController#launchPage(javax.swing.JFrame, java.lang.String)
     */
    public void launchPage(JFrame mainFrame, String back) {
    	if(back != null) {
    		backPage = back;
    	}
    	setOtherProf(ClientManager.getOtherProfile());
    	account = ClientManager.getActiveAccount();
        try {
            currentThread = ClientManager.getMessageThread(ClientManager.getActiveUserID(), ClientManager.getOtherProfile().getUserId());
            if(currentThread != null) {
                currentThread.setUpdateListener(this);
            }else {
            	currentThread = ClientManager.getNewMessageThread(ClientManager.getActiveUserID(), ClientManager.getOtherProfile().getUserId());
            	currentThread.setUpdateListener(this);
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error- could not find message thread");
        }
        MessageView.startMessagePage(this,mainFrame);
    }
    
    /**
     * Gets the account.
     *
     * @return the account
     */
    public Account getAccount() {
    	return account;
    }

    /* (non-Javadoc)
     * @see graphics.PageController#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()) {
            case SEND:
            	
                if (validateMsg()){
                	
                    Message newMessage = new Message();
                    newMessage.setMessage(this.getMessageModel().getSendBox().getText());
                    newMessage.setSenderId(ClientManager.getActiveUserID());
                    newMessage.setTimestampNow();
                    
                    try {
						if(!ClientManager.addMessage(ClientManager.getActiveUserID(), ClientManager.getOtherProfile().getUserId(), newMessage)) {
							List<String> warnings = new ArrayList<String>();
							warnings.add("Message could not be sent.");
							InvalidPopup p = new InvalidPopup(this.messagePanel, warnings);
						}
					} catch (DBFailureException e1) {
						List<String> warnings = new ArrayList<String>();
						warnings.add("Connection was lost.\nMessage could not be sent.");
						InvalidPopup p = new InvalidPopup(this.messagePanel, warnings);
						logger.log(Level.SEVERE, "Databse Failure during message sending: ", e1);
					}
            		this.getMessageModel().getSendBox().setText("");
                }
                break;
            case BACK:
                logger.info("Back");
                GraphicsController.processPage(PageCreator.PROFILE_PAGE,backPage);
                break;
            case REFRESH:
                logger.info("Refreshed");
        }
    }
    
    public void updateMessageArea() {
    	//current method is clear the message area and re-add everything
    	//better method would be to dynamically determine what needs to be added
    	
    	this.getMessageModel().getThread().setText("");

    	
    	for (int i = 0; i < getCurrentThread().getMessages().size(); i++){
            if (getCurrentThread().getMessages().get(i).getSenderId().equals(ClientManager.getActiveUserID())){
                this.getMessageModel().getThread().append("Me: ");
                this.getMessageModel().getThread().append(getCurrentThread().getMessages().get(i).getMessage());
                this.getMessageModel().getThread().append("\n");
            }
            else {
            	this.getMessageModel().getThread().append(ClientManager.getOtherProfile().getUsername() + ": ");
            	this.getMessageModel().getThread().append(getCurrentThread().getMessages().get(i).getMessage());
            	this.getMessageModel().getThread().append("\n");
            }
        }
	}
    

    /**
     * Validate msg.
     *
     * @return true, if successful
     */
    public boolean validateMsg() {
        boolean valid = true;

        //	CHECK FIELDS ARE NOT EMPTY OR SQL COMMANDS TO DELETE OUR TABLES
        //	VALIDATION FROM CREATE ACCOUNT PAGE + DATABASE VALIDATION
        List<String> warnings = new ArrayList<>();
        if(this.messageModel.getSendBox().getText().equals("")) {
            valid = false;
            warnings.add("Don't be shy! Enter a message.\n");
        }
        if(valid == false) {
            InvalidPopup p = new InvalidPopup(this.messagePanel, warnings);
        }
        return valid;
    }

    /**
     * Gets the message model.
     *
     * @return the message model
     */
    public MessageModel getMessageModel() {
        return messageModel;
    }

    /**
     * Sets the message model.
     *
     * @param messageModel the new message model
     */
    public void setMessageModel(MessageModel messageModel) {
        this.messageModel = messageModel;
    }

    /**
     * Gets the message panel.
     *
     * @return the message panel
     */
    public JPanel getMessagePanel() {
        return messagePanel;
    }

    /**
     * Sets the message panel.
     *
     * @param messagePanel the new message panel
     */
    public void setMessagePanel(JPanel messagePanel) {
        this.messagePanel = messagePanel;
    }

	/**
	 * Gets the other prof.
	 *
	 * @return the other prof
	 */
	public Profile getOtherProf() {
		return otherProf;
	}

	/**
	 * Sets the other prof.
	 *
	 * @param otherProf the new other prof
	 */
	public void setOtherProf(Profile otherProf) {
		this.otherProf = otherProf;
	}

    /**
     * Gets the current thread.
     *
     * @return the current thread
     */
    public MessageThread getCurrentThread() {
        return currentThread;
    }

    /**
     * Sets the current thread.
     *
     * @param currentThread the new current thread
     */
    public void setCurrentThread(MessageThread currentThread) {
        this.currentThread = currentThread;
        this.currentThread.setUpdateListener(this);
    }

	@Override
	public void externalUpdate() {
		this.updateMessageArea();
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if(e.getKeyChar() == KeyEvent.VK_ENTER) {
			this.getMessageModel().getBtnSend().doClick();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//do nothing
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//do nothing
		
	}

}

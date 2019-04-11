package model;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;

/*import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import firebase.DBFailureException;
import firebase.FireBaseAdapter;
import firebase.FireBaseSchema;*/

public class InformationExpert {
	
	private static Account activeUserAccount = null;
	private static List<Profile> allProfiles = null;
	private static List<Match> allMatches = null;
	//private static FireBaseAdapter databaseAdapter = null;
	
	
	
	public static void initializeAdapter() {
		//databaseAdapter = new FireBaseAdapter();
		
		/*if(!databaseAdapter.initializeDBConnection()){
			//error, could not initialize database
		}*/
		
		//should database dump these, also other account should be null until needed

		activeUserAccount = new Account();
		//otherAccount = null;
	}
	
	
	
	public static boolean attemptAddNewAccount(Account a)  {
		return true;//databaseAdapter.attemptAddNewAccount(a);
	}
	
	public static Account getUserAccount(String userId)  {
		Account temp = new Account();
		return temp; //databaseAdapter.getUserAccountWithProfile(userId);
	}
	
	public static boolean updateUserAccount(Account a)  {
		return true;//databaseAdapter.updateUserAccount(a);
	}
	
	public static boolean updateUserProfile(Account a)  {
		return true;//databaseAdapter.updateProfile(a.getAccountProfile());
	}
	
	public static Account getActiveAccount() {
		return activeUserAccount;
	}
	
	public static void setActiveAccount(Account a) {
		System.out.println("setting active account " + a.getEmail());
		activeUserAccount = a;
	}
	
	
	public static boolean isActiveUser(Account a) {
		if(a == activeUserAccount) {
			return true;
		}
		return false;
	}
	
	public static String authenticateUserAccount(String userEmail, String passwordHash)  {
		return "Great";//databaseAdapter.authenticateUserAccount(userEmail, passwordHash);
	}
	
	public static Account getUserAccountNoProfile(String userId) {
		Account temp = new Account();
		return temp;//databaseAdapter.getUserAccountNoProfile(userId);
	}
	
	public static Account getUserAccountWithProfile(String userId) {
		Account temp = new Account();
		return temp;//databaseAdapter.getUserAccountWithProfile(userId);
	}
	
	public static String getActiveUserID() {
		return activeUserAccount.getUserId();
	}
	
	
	public static BufferedImage getProfileImage(String userID)  {
		BufferedImage temp = new BufferedImage(0, 0, BufferedImage.TYPE_CUSTOM);
		return temp;//databaseAdapter.getProfileImage(userID);
	}
	
	public static void addProfileImage(BufferedImage pic, String userID)  {
		//databaseAdapter.addProfileImage(pic, userID);
	}
	
	public static void updateAccount(Account a)  {
		//databaseAdapter.updateUserAccount(a);
	}
	
	public static void updateProfile(Profile p)  {
		//databaseAdapter.updateProfile(p);
	}
}

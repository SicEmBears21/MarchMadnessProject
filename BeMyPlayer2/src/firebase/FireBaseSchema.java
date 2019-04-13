package firebase;

import java.util.Date;

import com.google.cloud.Timestamp;

public class FireBaseSchema {
	
	public static final String ACCOUNTS_TABLE = "Accounts",
							   PROFILES_TABLE = "Profiles",
							   MATCHES_TABLE = "Matches",
							   MATCHES_TABLE_COLLECTION = "userMatches",
							   MESSAGE_THREADS_TABLE = "MessageThreads";
	
	public static final String PROFILE_IMAGE_PREFIX = "p_img-";
	
	public static Date parseDate(Object obj) {
		//perform additional formatting on Date object as needed:
		if(obj instanceof Timestamp) {
			return ((Timestamp) obj).toDate();
		}else if(obj instanceof Date) {
			return (Date) obj;
		}
		
		return null;
	}
	
	public static String toProfileImageIndex(String userId) {
		return PROFILE_IMAGE_PREFIX + userId;
	}
	//Handle any additional Schema based logic here...
}
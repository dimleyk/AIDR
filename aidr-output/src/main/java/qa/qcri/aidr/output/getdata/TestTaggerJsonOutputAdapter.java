package qa.qcri.aidr.output.getdata;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import qa.qcri.aidr.output.utils.TaggerJsonOutputAdapter;

public class TestTaggerJsonOutputAdapter {
	public static void main(String args[]) {
		String testString1 = "{\"filter_level\":\"medium\",\"text\":\"@wongt0n You in Japan now?\",\"contributors\":null,\"geo\":null,\"retweeted\":false,\"in_reply_to_screen_name\":\"wongt0n\",\"truncated\":false,\"entities\":{\"hashtags\":[],\"symbols\":[],\"urls\":[],\"user_mentions\":[{\"id\":123834194,\"indices\":[0,8],\"screen_name\":\"wongt0n\",\"id_str\":\"123834194\",\"name\":\"Lazy Wong~\"}]},\"lang\":\"en\",\"in_reply_to_status_id_str\":\"421190875260014592\",\"id\":421193072316149761,\"aidr\":{\"features\":[{\"words\":[\"\",\"japan_now\",\"japan\",\"now\",\"_you\",\"you\",\"in_japan\",\"in\",\"you_in\"],\"type\":\"wordvector\"}],\"crisis_code\":\"japan_chem_explosion\",\"nominal_labels\":[],\"doctype\":\"twitter\",\"crisis_name\":\"Explosion at Japan chemical factory\"},\"source\":\"web\",\"in_reply_to_user_id_str\":\"123834194\",\"favorited\":false,\"in_reply_to_status_id\":421190875260014592,\"retweet_count\":0,\"created_at\":\"Thu Jan 09 08:13:48 +0000 2014\",\"in_reply_to_user_id\":123834194,\"favorite_count\":0,\"id_str\":\"421193072316149761\",\"place\":null,\"user\":{\"location\":\"\",\"default_profile\":false,\"profile_background_tile\":true,\"statuses_count\":10045,\"lang\":\"en\",\"profile_link_color\":\"1212E3\",\"profile_banner_url\":\"https://pbs.twimg.com/profile_banners/457120810/1358321901\",\"id\":457120810,\"following\":null,\"protected\":false,\"favourites_count\":7,\"profile_text_color\":\"E60ED4\",\"contributors_enabled\":false,\"verified\":false,\"description\":\"An ordinary SONE who fall in love with Taeyeon+Jessica+Sunny+Tiffany+Hyoyeon+Yuri+Sooyoung+Yoona+Seohyun = SNSD. Spazzing and sharing is my vacation on twitter.\",\"name\":\"~~\uC18C\uC2DC\uB77C\uC11C \uD589\uBCF5\uD574\uC694~~\",\"profile_sidebar_border_color\":\"FFFFFF\",\"profile_background_color\":\"EDFAFA\",\"created_at\":\"Sat Jan 07 01:51:54 +0000 2012\",\"default_profile_image\":false,\"followers_count\":47,\"geo_enabled\":false,\"profile_image_url_https\":\"https://pbs.twimg.com/profile_images/378800000219857862/9606b10e2dd7d700111f4c5be7384f63_normal.jpeg\",\"profile_background_image_url\":\"http://a0.twimg.com/profile_background_images/889556219/7456374b70ecfea67145b0214f15a988.jpeg\",\"profile_background_image_url_https\":\"https://si0.twimg.com/profile_background_images/889556219/7456374b70ecfea67145b0214f15a988.jpeg\",\"follow_request_sent\":null,\"url\":null,\"utc_offset\":28800,\"time_zone\":\"Kuala Lumpur\",\"notifications\":null,\"profile_use_background_image\":true,\"friends_count\":127,\"profile_sidebar_fill_color\":\"E1D2F5\",\"screen_name\":\"blueagle90\",\"id_str\":\"457120810\",\"profile_image_url\":\"http://pbs.twimg.com/profile_images/378800000219857862/9606b10e2dd7d700111f4c5be7384f63_normal.jpeg\",\"listed_count\":0,\"is_translator\":false},\"coordinates\":null}";
		String testString2 = "{\"filter_level\":\"medium\",\"text\":\"@wongt0n You in Japan now?\",\"contributors\":null,\"geo\":null,\"retweeted\":false,\"in_reply_to_screen_name\":\"wongt0n\",\"truncated\":false,\"entities\":{\"hashtags\":[],\"symbols\":[],\"urls\":[],\"user_mentions\":[{\"id\":123834194,\"indices\":[0,8],\"screen_name\":\"wongt0n\",\"id_str\":\"123834194\",\"name\":\"Lazy Wong~\"}]},\"lang\":\"en\",\"in_reply_to_status_id_str\":\"421190875260014592\",\"id\":421193072316149761,\"aidr\":{\"features\":[{\"words\":[\"\",\"2009\",\"edition\",\"_#mp3\",\"#mp3_#music\",\"408_the\",\"the_end\",\"peas_2009\",\"#mp3\",\"the\",\"edition_black\",\"end_japan\",\"eyed_peas\",\"#music_408\",\"408\",\"japan\",\"japan_edition\",\"black_eyed\",\"#music\",\"eyed\",\"end\",\"black\",\"peas\"],\"type\":\"wordvector\"}],\"crisis_code\":\"japan_chem_explosion\",\"nominal_labels\":[{\"label_name\":\"Not related to crisis\",\"source_id\":289,\"from_human\":false,\"attribute_description\":\"Informative messages enhancing situational awareness, v1.0\",\"label_code\":\"030_not_info\",\"confidence\":0.54,\"label_description\":\"Not related to the crisis\",\"attribute_code\":\"informative_v1\",\"attribute_name\":\"Informative v1.0\"}],\"doctype\":\"twitter\",\"crisis_name\":\"Explosion at Japan chemical factory\"},\"source\":\"web\",\"in_reply_to_user_id_str\":\"123834194\",\"favorited\":false,\"in_reply_to_status_id\":421190875260014592,\"retweet_count\":0,\"created_at\":\"Thu Jan 09 08:13:48 +0000 2014\",\"in_reply_to_user_id\":123834194,\"favorite_count\":0,\"id_str\":\"421193072316149761\",\"place\":null,\"user\":{\"location\":\"\",\"default_profile\":false,\"profile_background_tile\":true,\"statuses_count\":10045,\"lang\":\"en\",\"profile_link_color\":\"1212E3\",\"profile_banner_url\":\"https://pbs.twimg.com/profile_banners/457120810/1358321901\",\"id\":457120810,\"following\":null,\"protected\":false,\"favourites_count\":7,\"profile_text_color\":\"E60ED4\",\"contributors_enabled\":false,\"verified\":false,\"description\":\"An ordinary SONE who fall in love with Taeyeon+Jessica+Sunny+Tiffany+Hyoyeon+Yuri+Sooyoung+Yoona+Seohyun = SNSD. Spazzing and sharing is my vacation on twitter.\",\"name\":\"~~\uC18C\uC2DC\uB77C\uC11C \uD589\uBCF5\uD574\uC694~~\",\"profile_sidebar_border_color\":\"FFFFFF\",\"profile_background_color\":\"EDFAFA\",\"created_at\":\"Sat Jan 07 01:51:54 +0000 2012\",\"default_profile_image\":false,\"followers_count\":47,\"geo_enabled\":false,\"profile_image_url_https\":\"https://pbs.twimg.com/profile_images/378800000219857862/9606b10e2dd7d700111f4c5be7384f63_normal.jpeg\",\"profile_background_image_url\":\"http://a0.twimg.com/profile_background_images/889556219/7456374b70ecfea67145b0214f15a988.jpeg\",\"profile_background_image_url_https\":\"https://si0.twimg.com/profile_background_images/889556219/7456374b70ecfea67145b0214f15a988.jpeg\",\"follow_request_sent\":null,\"url\":null,\"utc_offset\":28800,\"time_zone\":\"Kuala Lumpur\",\"notifications\":null,\"profile_use_background_image\":true,\"friends_count\":127,\"profile_sidebar_fill_color\":\"E1D2F5\",\"screen_name\":\"blueagle90\",\"id_str\":\"457120810\",\"profile_image_url\":\"http://pbs.twimg.com/profile_images/378800000219857862/9606b10e2dd7d700111f4c5be7384f63_normal.jpeg\",\"listed_count\":0,\"is_translator\":false},\"coordinates\":null}";
		String testString3 = "{\"filter_level\":\"medium\",\"text\":\"@wongt0n You in Japan now?\",\"contributors\":null,\"geo\":null,\"retweeted\":false,\"in_reply_to_screen_name\":\"wongt0n\",\"truncated\":false,\"entities\":{\"hashtags\":[],\"symbols\":[],\"urls\":[],\"user_mentions\":[{\"id\":123834194,\"indices\":[0,8],\"screen_name\":\"wongt0n\",\"id_str\":\"123834194\",\"name\":\"Lazy Wong~\"}]},\"lang\":\"en\",\"in_reply_to_status_id_str\":\"421190875260014592\",\"id\":421193072316149761,\"aidr\":{\"features\":[{\"words\":[\"\",\"2009\",\"edition\",\"_#mp3\",\"#mp3_#music\",\"408_the\",\"the_end\",\"peas_2009\",\"#mp3\",\"the\",\"edition_black\",\"end_japan\",\"eyed_peas\",\"#music_408\",\"408\",\"japan\",\"japan_edition\",\"black_eyed\",\"#music\",\"eyed\",\"end\",\"black\",\"peas\"],\"type\":\"wordvector\"}],\"crisis_code\":\"japan_chem_explosion\",\"nominal_labels\":[{\"label_name\":\"Not related to crisis\",\"source_id\":289,\"from_human\":false,\"attribute_description\":\"Informative messages enhancing situational awareness, v1.0\",\"label_code\":\"030_not_info\",\"confidence\":0.54,\"label_description\":\"Not related to the crisis\",\"attribute_code\":\"informative_v1\",\"attribute_name\":\"Informative v1.0\"}, {\"label_name\":\"Not related to crisis\",\"source_id\":289,\"from_human\":false,\"attribute_description\":\"Informative messages enhancing situational awareness, v1.0\",\"label_code\":\"030_not_info\",\"confidence\":0.8433459674,\"label_description\":\"Not related to the crisis\",\"attribute_code\":\"informative_v1\",\"attribute_name\":\"Informative v1.0\"}, {\"label_name\":\"Not related to crisis\",\"source_id\":289,\"from_human\":false,\"attribute_description\":\"Informative messages enhancing situational awareness, v1.0\",\"label_code\":\"030_not_info\",\"confidence\":0.20,\"label_description\":\"related to the crisis\",\"attribute_code\":\"informative_v1\",\"attribute_name\":\"Informative v1.0\"}],\"doctype\":\"twitter\",\"crisis_name\":\"Explosion at Japan chemical factory\"},\"source\":\"web\",\"in_reply_to_user_id_str\":\"123834194\",\"favorited\":false,\"in_reply_to_status_id\":421190875260014592,\"retweet_count\":0,\"created_at\":\"Thu Jan 09 08:13:48 +0000 2014\",\"in_reply_to_user_id\":123834194,\"favorite_count\":0,\"id_str\":\"421193072316149761\",\"place\":null,\"user\":{\"location\":\"\",\"default_profile\":false,\"profile_background_tile\":true,\"statuses_count\":10045,\"lang\":\"en\",\"profile_link_color\":\"1212E3\",\"profile_banner_url\":\"https://pbs.twimg.com/profile_banners/457120810/1358321901\",\"id\":457120810,\"following\":null,\"protected\":false,\"favourites_count\":7,\"profile_text_color\":\"E60ED4\",\"contributors_enabled\":false,\"verified\":false,\"description\":\"An ordinary SONE who fall in love with Taeyeon+Jessica+Sunny+Tiffany+Hyoyeon+Yuri+Sooyoung+Yoona+Seohyun = SNSD. Spazzing and sharing is my vacation on twitter.\",\"name\":\"~~\uC18C\uC2DC\uB77C\uC11C \uD589\uBCF5\uD574\uC694~~\",\"profile_sidebar_border_color\":\"FFFFFF\",\"profile_background_color\":\"EDFAFA\",\"created_at\":\"Sat Jan 07 01:51:54 +0000 2012\",\"default_profile_image\":false,\"followers_count\":47,\"geo_enabled\":false,\"profile_image_url_https\":\"https://pbs.twimg.com/profile_images/378800000219857862/9606b10e2dd7d700111f4c5be7384f63_normal.jpeg\",\"profile_background_image_url\":\"http://a0.twimg.com/profile_background_images/889556219/7456374b70ecfea67145b0214f15a988.jpeg\",\"profile_background_image_url_https\":\"https://si0.twimg.com/profile_background_images/889556219/7456374b70ecfea67145b0214f15a988.jpeg\",\"follow_request_sent\":null,\"url\":null,\"utc_offset\":28800,\"time_zone\":\"Kuala Lumpur\",\"notifications\":null,\"profile_use_background_image\":true,\"friends_count\":127,\"profile_sidebar_fill_color\":\"E1D2F5\",\"screen_name\":\"blueagle90\",\"id_str\":\"457120810\",\"profile_image_url\":\"http://pbs.twimg.com/profile_images/378800000219857862/9606b10e2dd7d700111f4c5be7384f63_normal.jpeg\",\"listed_count\":0,\"is_translator\":false},\"coordinates\":null}";
		
		System.out.println("TaggerJsonOutputAdapter:");
		TaggerJsonOutputAdapter obj = new TaggerJsonOutputAdapter();
		String testout1 = obj.buildJsonString(testString1, false);
		System.out.println("testString 1: " + testout1);
		
		String testout2 = obj.buildJsonString(testString2, false);
		System.out.println("testString 2: " + testout2);
		
		String testout3 = obj.buildJsonString(testString3, false);
		System.out.println("testString 3: " + testout3);
		
		System.out.println("Date : " + extractTweetTimestampField(testout3));
		
	}

	public static Date extractTweetTimestampField(String tweet) {
		String offsetString = "\"created_at\":\"";
		StringBuffer strBuff = new StringBuffer();
		strBuff.append(tweet.substring(tweet.indexOf(offsetString) + offsetString.length(), tweet.indexOf("\",", tweet.indexOf(offsetString))));
		
		System.out.println(strBuff.toString());
		
		// Tue Feb 18 08:46:03 +0000 2014
		SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss ZZZ yyyy");
		formatter.setTimeZone(TimeZone.getTimeZone("GMT"));
		try {
			return formatter.parse(strBuff.toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}



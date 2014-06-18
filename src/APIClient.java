import java.io.IOException;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;

import com.bluerover.api.BlueroverApi;
import com.bluerover.api.Result;

public class APIClient {

	Timer timer;
	BlueroverApi api;

	public APIClient(TreeMap<String, String> pCreds) {
		timer = new Timer();
		api = new BlueroverApi();
		api.setCredentials(pCreds);
	}

	//Schedule a recurring event call that occurs every X seconds
	public void scheduleEventCall(int seconds) {
		timer.scheduleAtFixedRate(new callEventTask(), 0, seconds * 1000);
	}

	class callEventTask extends TimerTask {

		@Override
		public void run() {
			//time duration of 10s
			TreeMap<String, String> times = new TreeMap<String, String>();
			long startTime = System.currentTimeMillis() / 1000L - 10 * 1000;
			long endTime = System.currentTimeMillis() / 1000L;
			times.put("start_time", Objects.toString(startTime, null));
			times.put("end_time", Objects.toString(endTime, null));
			times.put("page", "0");
			Result result = null;
			try {
				result = api.getEvents(Objects.toString(
						System.currentTimeMillis() / 1000L - 10 * 1000, null), Objects
						.toString(System.currentTimeMillis() / 1000L, null), "0");
			} catch (IOException e) {
				System.err.println("Error with connecting to server");
				e.printStackTrace();
			}
			System.out.println(result);
		}
	}

	public static void main(String[] args) throws Exception {
		TreeMap<String, String> creds = new TreeMap<String, String>();
		creds.put("key", "yXIJ1omZUNtbo6wNjMOkKYBLNJakn0nr/OzgVtDKh2i5lDktVT2xv5xfbYlCkW+Z");
		creds.put("token", "9DquKlyhPKpZ35mxcjG/JUqWAd//U12O13ja6Wqp");
		creds.put("baseURL", "http://developers.bluerover.us");
		APIClient client = new APIClient(creds);
		
		client.scheduleEventCall(10);
	}
}

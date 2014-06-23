import com.bluerover.events.CallBack;
import com.bluerover.model.Event;

/**
 *  
 * A sample callback that prints out the event data it receives
 *
 */

public class SampleCallBack implements CallBack {

	/**
	 * e : the event received from the event stream
	 */
	@Override
	public void onData(Event e) {
		System.out.println("in the callback");
		System.out.println("My event object " + e.toString());
	}

}

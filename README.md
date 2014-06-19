java-api-test-client
===============

BlueRover Java API Test Client


Public Methods
--------------

* `APIClient` **APIClient**(*creds*)

    Instanstiate a BlueroverApi object and set its credentials.
      
    **Parameters:**
      
    `HashMap<String,String> creds` : API credentials containing the following:
      
      *   `String key` : authentication key for your user
      *   `String token` : authentication token for your user
      *   `String baseURL` : the address where you are pointing to, normally **developers.bluerover.us**
      
    **Returns:** Constructs `APIClient` object

* `void` **scheduleEventCall**(*seconds*)

    Schedule a recurring getEvents(startTime,endTime,page) call that occurs every X seconds. It is currently set to fetch events that occured in the past 10 seconds. However, a **better** solution may be to use the previous call's end time in order to avoid disjoint sets.

    **Parameters:**
    
      *   `int seconds` : number of seconds between each call
      
* `void` **scheduleDeviceCall**(*seconds*)

    Schedule a recurring getDevices() call that occurs every X seconds.

    **Parameters:**
    
      *   `int seconds` : number of seconds between each call
      
* `void` **scheduleRfidCall**(*seconds*)

    Schedule a recurring getRfids() call that occurs every X seconds.

    **Parameters:**
    
      *   `int seconds` : number of seconds between each call

###Standard operation

```Java

    //insert your credentials into the map
    HashMap<String,String> creds = new HashMap<String,String>();
    creds.put("key", "YOUR_KEY_HERE");
	creds.put("token", "YOUR_TOKEN_HERE");
	creds.put("baseURL", "http://developers.bluerover.us");
    
    APIClient client = new APIClient(creds);
    
    //Schedule a recurring event call every 10 seconds
    client.scheduleEventCall(10);
```

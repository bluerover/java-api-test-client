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

    Schedule a recurring getEvents(startTime,endTime,page) call that occurs every X seconds. It is currently set to fetch events that occured in the past 10 seconds.

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

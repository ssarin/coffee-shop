// The purpose of this class is to model a television

/**
 * This a Television class with manufacturer name, screen size, channel and volume.
 * It also stores the power state of the television
 * 
 * @author Surtej Sarin
 */

public class Television {
	String MANUFACTURER; 	// holds the band of the television
	int SCREEN_SIZE; 	// holds the screen size of the television
	boolean powerOn; 	// boolean: true/on, false/off
	int channel; 		// holds the channel currently being viewed
	int volume; 		// a number value representing the loudness (0 being no sound).
	

	
	// Write comments describing the purpose of the constructor above the method header.
	/**
	 * This a Constructor Method which takes in two parameters, a manufacturer’s brand
	 * and a screen size. These parameters will bring in information.
	 * Power is set to off by default, Channel is set to 2 and Volume set to 20.
	 * @author Surtej Sarin
	 */
	public Television (String manu, int screen){
		MANUFACTURER = manu;
		SCREEN_SIZE = screen;
		powerOn = false;
		channel = 2;
		volume = 20;	
	}
	
	
	// accessor methods
	/**
	 * Accessor methods to get the volume, channel, Manufacturer name and size
	 * @author Surtej Sarin
	 */
	public int getVolume (){
		return volume;
	}
	public int getChannel(){
		return channel;
	}
	public String getManufacturer (){
		return MANUFACTURER;
	}
	public int getScreenSize(){
		return SCREEN_SIZE;
	}
	
	
	// mutator methods
	/**
	 * 
	 * @author Surtej Sarin
	 */
	public void setChannel (int ch){
		channel = ch;
	}
	public void power(){
		powerOn = !powerOn;
	}
	public void increaseVolume(){
		volume = volume +1;
	}
	public void decreaseVolume(){
		volume = volume - 1;
	}
}

/*
 * 
 */
package com.gvn.pets.model.device;

import java.lang.reflect.Method;
import java.util.UUID;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * Getting some infomation for a smartphone device is as shown below:
 * 		- Unique number (IMEI, MEID, ESN, IMSI)
 * 		- The WLAN MAC Address string
 * 		- The Hardware Serial Number
 * 		- ANDROID_ID
 * 		- The Bluetooth Address string
 * @Note Uses some permission below:
 * 	<uses-permission android:name="android.permission.READ_PHONE_STATE" />
 *	<uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
 *	<uses-permission android:name="android.permission.INTERNET" />
 *	<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
 *	<uses-permission android:name="android.permission.BLUETOOTH" />
 * @author DucHM
 * @cellphone 0989 664 386
 *
 */

public class ReadDeviceInfo {
	private static final String TAG = "ReadDeviceInfo";
	
	/**
	 * Getting some infomation for a smartphone device is as shown below:
	 * 		- Unique number (IMEI, MEID, ESN, IMSI)
	 *  	- The WLAN MAC Address string
	 *  	- The Hardware Serial Number
	 */
	public static String getMergeDeviceInfo(Context context) {
		try {
			return getDeviceId(context) + getMacAddress(context) + ":" + getSubscriberId(context) + ":" + getHwIdSerialSerial2();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "";
	}
	
	/**
	 * Getting some infomation for a smartphone device is as shown below:
	 * 		- Unique number (IMEI, MEID, ESN, IMSI)
	 *  	- The WLAN MAC Address string
	 *  	- The Hardware Serial Number
	 */
	public static String getDeviceIdMacAddress(Context context) {
		try {
			return getDeviceId(context) + getMacAddress(context);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "";
	}
	
	/**
	 * getDeviceId() function Returns the unique device ID. for
	 * example,the IMEI for GSM and the MEID or ESN for CDMA phones.
	 */
	public static String getDeviceId(Context context) {
		try {
			if (context == null) return "";
			String imeistring = "";
			TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
			imeistring = telephonyManager.getDeviceId();
			Log.d(TAG, ("IMEI No=" + imeistring));
			return nullToEmpty(imeistring);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "";
	}
	
	/**
	 * getSubscriberId() function Returns the unique subscriber ID,
	 * for example, the IMSI for a GSM phone.
	 */
	public static String getSubscriberId(Context context) {
		try {
			if (context == null) return "";
			String imsistring = "";
			TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
			imsistring = telephonyManager.getSubscriberId();
			Log.d(TAG, ("IMSI No=" + imsistring));
			return nullToEmpty(imsistring);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "";
	}
	
	/**
	 * System Property ro.serialno returns the serial number as
	 * unique number Works for Android 2.3 and above
	 */
	public static String getHwIdSerialSerial2() {
	    try {
	    	String wIdSerialSerial2 = "";
			String hwID = android.os.SystemProperties.get("ro.serialno", "unknown");
			Log.d(TAG, ("HwID=" + hwID));
			wIdSerialSerial2 += nullToEmpty(hwID);
			String serialnum = "";
			try {
				Class<?> c = Class.forName("android.os.SystemProperties");
				Method get = c.getMethod("get", String.class, String.class);
				serialnum = (String) (get.invoke(c, "ro.serialno", "unknown"));
				Log.d(TAG, ("SerialNum=" + serialnum));
				wIdSerialSerial2 += ":" + nullToEmpty(serialnum);
			} catch (Exception ignored) {
			}
			String serialnum2 = "";
			try {
				//Class myclass = Class.forName("android.os.SystemProperties");
				Class<?> myclass = Class.forName("android.os.SystemProperties");
				Method[] methods = myclass.getMethods();
				Object[] params = new Object[] { new String("ro.serialno"), new String("Unknown") };
				serialnum2 = (String) (methods[2].invoke(myclass, params));
				Log.d(TAG, ("SerialNum2=" + serialnum2));
				wIdSerialSerial2 += ":" + nullToEmpty(serialnum2);
			} catch (Exception ignored) {
			}
		    return nullToEmpty(wIdSerialSerial2);
		} catch (Exception e) {
			// TODO: handle exception
		}
	    return "";
	}
	
	/**
	 * Settings.Secure.ANDROID_ID returns the unique DeviceID Works
	 * for Android 2.2 and above.
	 * The value may change if a factory reset is performed on the device
	 */
	public static String getAndroidId(Context context) {
	    try {
	    	if (context == null) return "";
	    	final String androidId = "" + android.provider.Settings.Secure.getString(context.getContentResolver(), android.provider.Settings.Secure.ANDROID_ID);
	    	Log.d(TAG, ("ANDROID_ID=" + androidId));
		    return nullToEmpty(androidId);
		} catch (Exception e) {
			// TODO: handle exception
		}
	    return "";
	}
	
	public static String getMacAddress(Context context) {
	    try {
	    	if (context == null) return "";
	    	final String macAddr;
	    	
		    //WifiManager wifiMan = (WifiManager) this.getSystemService(Context.WIFI_SERVICE);
	    	WifiManager wifiMan = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
		    WifiInfo wifiInf = wifiMan.getConnectionInfo();

		    macAddr = wifiInf.getMacAddress();
		    Log.d(TAG, ("MAC=" + macAddr));
		    return nullToEmpty(macAddr);
		} catch (Exception e) {
			// TODO: handle exception
		}
	    return "";
	}
	
	public static String getUUID(Context context) {
	    try {
	    	if (context == null) return "";
	    	final String macAddr, androidId;
	    	
		    //WifiManager wifiMan = (WifiManager) this.getSystemService(Context.WIFI_SERVICE);
	    	WifiManager wifiMan = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
		    WifiInfo wifiInf = wifiMan.getConnectionInfo();

		    macAddr = nullToEmpty(wifiInf.getMacAddress());
		    Log.d(TAG, ("MAC=" + macAddr));
		    androidId = "" + android.provider.Settings.Secure.getString(context.getContentResolver(), android.provider.Settings.Secure.ANDROID_ID);

		    UUID deviceUuid = new UUID(androidId.hashCode(), macAddr.hashCode());
		    Log.d(TAG, ("DeviceUuid=" + nullToEmpty(deviceUuid.toString())));
		    // Maybe save this: deviceUuid.toString()); to the preferences.
		    return nullToEmpty(deviceUuid.toString());
		} catch (Exception e) {
		}
	    return "";
	}
	
	/**
	 * Returns the hardware address of the local Bluetooth adapter. 
	 * @param context
	 * @return
	 */
	public static String getBluetoothAddress(Context context) {
		try {
			BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
			if (mBluetoothAdapter != null) {
				return nullToEmpty(mBluetoothAdapter.getAddress());
			}
			// Device does not support Bluetooth
			return "";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "";
	}
	
	/**
	 * Null to empty.
	 *
	 * @param input the input
	 * @return the string
	 */
	private static String nullToEmpty(Object input) {
		return (input == null ? "" : ("null".equals(input)?"": input.toString()));
	}
}
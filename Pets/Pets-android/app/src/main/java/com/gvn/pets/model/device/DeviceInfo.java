/*
 * 
 */
package com.gvn.pets.model.device;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import com.gvn.pets.utils.StringUtils;

import org.json.JSONException;
import org.json.JSONObject;


// TODO: Auto-generated Javadoc
/**
 * * @author DucHM
 */
public class DeviceInfo implements Parcelable {
	
	/** The id. */
	private String id;
	
	/** The os version. */
	private String osVersion;
	
	/** The model. */
	private String model;
	
	/** The sdk vervion. */
	private String sdkVervion;
	
	/** The device. */
	private String device;
	
	/** The product. */
	private String product;
	
	/** The serial. */
	private String serial;
	
	/** The user. */
	private String user;
	
	/** The imei. */
	private String imei;
	
	/** The imeiOld. */
	private String imeiOld;
	
	private String macAddress; 
	private String bluetoothAddress;
	
	/** The hardware. */
	private String hardware;
	
	/** The manufacturer. */
	private String manufacturer;
	
	/** The is tablet device. */
	private String isTablet;
	
	/** The device info key. */
	public static String DEVICE_INFO_KEY = "deviceInfo";
	
	/** The id key. */
	public static String ID_KEY = "id";
	
	/** The os version key. */
	public static String OS_VERSION_KEY = "osVersion";
	
	/** The model key. */
	public static String MODEL_KEY = "model";
	
	/** The sdk version key. */
	public static String SDK_VERSION_KEY = "sdkVervion";
	
	/** The device key. */
	public static String DEVICE_KEY = "device";
	
	/** The product key. */
	public static String PRODUCT_KEY = "product";
	
	/** The serial key. */
	public static String SERIAL_KEY = "serial";
	
	/** The user key. */
	public static String USER_KEY = "user";
	
	/** The imei key. */
	public static String IMEI_KEY = "imei";
	/** The imei older key. */
	public static String IMEI_OLD_KEY = "imeiOld";
	
	/** The hardware key. */
	public static String HARDWARE_KEY = "hardware";
	
	/** The manufacturer key. */
	public static String MANUFACTURER_KEY = "manufacturer";

	/** The manufacturer key. */
	public static String MAC_ADDRESS_KEY = "macAddress";
	/** The manufacturer key. */
	public static String BLUETOOTH_ADDRESS_KEY = "bluetoothAddress";
	public static String TABLET_KEY = "tablet";
	
	
	/**
	 * Standard basic constructor for non-parcel
	 * object creation.
	 */
	public DeviceInfo() {

	}

	/**
	 * Instantiates a new device info.
	 *
	 * @param id the id
	 * @param osVersion the os version
	 * @param model the model
	 * @param sdkVervion the sdk vervion
	 * @param device the device
	 * @param product the product
	 * @param serial the serial
	 * @param user the user
	 * @param imei the imei
	 * @param hardware the hardware
	 * @param manufacturer the manufacturer
	 */
	public DeviceInfo(String id, String osVersion, String model,
			String sdkVervion, String device, String product, String serial,
			String user, String imei, String hardware, String manufacturer, String macAddress, String bluetoothAddress) {
		
		String imeiOld = (StringUtils.isEmptyOrNull(imei) ? StringUtils.replaceAll((id
				+ model + device + serial), " ", "") : imei);
		
		imei = (StringUtils.isEmptyOrNull(imei) ? 
				(StringUtils.isEmptyOrNull(macAddress) ? StringUtils.nullToEmpty(bluetoothAddress) : 
					StringUtils.nullToEmpty(macAddress)) : imei);
		Log.i("DeviceInfo", "DeviceID=" + imei);
		setId(id);
		setOsVersion(osVersion);
		setModel(model);
		setSdkVervion(sdkVervion);
		setDevice(device);
		setProduct(product);
		setSerial(serial);
		setUser(user);
		setImei("adr_" + imei);
		//setImei("adr_84934543815");//
		setImeiOld("adr_" + imeiOld);
		setHardware(hardware);
		setManufacturer(manufacturer);
		setMacAddress(macAddress);
		setBluetoothAddress(bluetoothAddress);
		if (StringUtils.isEmptyOrNull(imei)) setIsTablet("true");
		else setIsTablet("false");
	}

	/* (non-Javadoc)
	 * @see android.os.Parcelable#describeContents()
	 */
	@Override
	public int describeContents() {
		return 0;
	}
	
	// We just need to write each field into the 
	// parcel. When we read from parcel, they 
	// will come back in the same order
	// Lưu các biến vào Parcel, khi đọc thì sẽ được đọc theo thứ tự khi ghi.
	// First in - First out
	/* (non-Javadoc)
	 * @see android.os.Parcelable#writeToParcel(android.os.Parcel, int)
	 */
	@Override
	public void writeToParcel(Parcel parcel, int arg1) {
		parcel.writeString(id);
		parcel.writeString(osVersion);
		parcel.writeString(model);
		parcel.writeString(sdkVervion);
		parcel.writeString(device);
		parcel.writeString(product);
		parcel.writeString(serial);
		parcel.writeString(user);
		parcel.writeString(imei);
		parcel.writeString(imeiOld);
		parcel.writeString(hardware);
		parcel.writeString(manufacturer);
		parcel.writeString(macAddress);
		parcel.writeString(bluetoothAddress);
		parcel.writeString(isTablet);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String deviceInfo = "";
		if (!StringUtils.isEmptyOrNull(id)) deviceInfo = "\nBuildID:" + id;
		if (!StringUtils.isEmptyOrNull(osVersion)) deviceInfo += "\nOSVersion:" + osVersion;
		if (!StringUtils.isEmptyOrNull(model)) deviceInfo += "\nModel:" + model;
		if (!StringUtils.isEmptyOrNull(sdkVervion)) deviceInfo += "\nSdkVervion:" + sdkVervion;
		if (!StringUtils.isEmptyOrNull(device)) deviceInfo += "\nDevice:" + device;
		if (!StringUtils.isEmptyOrNull(product)) deviceInfo += "\nProduct:" + product;
		if (!StringUtils.isEmptyOrNull(serial)) deviceInfo += "\nSerial:" + serial;
		if (!StringUtils.isEmptyOrNull(user)) deviceInfo += "\nUser:" + user;
		if (!StringUtils.isEmptyOrNull(hardware)) deviceInfo += "\nHardware:" + hardware;
		if (!StringUtils.isEmptyOrNull(imei)) deviceInfo += "\nDeviceUDID:" + StringUtils.replace(imei, "adr_", "");
		//if (!StringUtils.isEmptyOrNull(imeiOld)) deviceInfo += "\nDeviceUdIdOld:" + StringUtils.replace(imeiOld, "adr_", "");
		if (!StringUtils.isEmptyOrNull(manufacturer)) deviceInfo += "\nManufacturer:" + manufacturer;
		if (!StringUtils.isEmptyOrNull(isTablet)) deviceInfo += "\nTablet:" + isTablet;
		if (!StringUtils.isEmptyOrNull(macAddress)) deviceInfo += "\nMacAddress:" + macAddress;
		if (!StringUtils.isEmptyOrNull(bluetoothAddress)) deviceInfo += "\nBluetoothAddress:" + bluetoothAddress;
		
		return deviceInfo;
	}

	public String deviceInfoString() {
		String deviceInfo = "";
		if (!StringUtils.isEmptyOrNull(id)) deviceInfo = "BuildID:" + id;
		if (!StringUtils.isEmptyOrNull(osVersion)) deviceInfo += "|OSVersion:" + osVersion;
		if (!StringUtils.isEmptyOrNull(model)) deviceInfo += "|Model:" + model;
		if (!StringUtils.isEmptyOrNull(sdkVervion)) deviceInfo += "|SdkVervion:" + sdkVervion;
		if (!StringUtils.isEmptyOrNull(device)) deviceInfo += "|Device:" + device;
		if (!StringUtils.isEmptyOrNull(product)) deviceInfo += "|Product:" + product;
		if (!StringUtils.isEmptyOrNull(serial)) deviceInfo += "|Serial:" + serial;
		if (!StringUtils.isEmptyOrNull(user)) deviceInfo += "|User:" + user;
		if (!StringUtils.isEmptyOrNull(hardware)) deviceInfo += "|Hardware:" + hardware;
		if (!StringUtils.isEmptyOrNull(imei)) deviceInfo += "|DeviceUDID:" + StringUtils.replace(imei, "adr_", "");
		//if (!StringUtils.isEmptyOrNull(imeiOld)) deviceInfo += "|DeviceUdIdOld:" + StringUtils.replace(imeiOld, "adr_", "");
		if (!StringUtils.isEmptyOrNull(manufacturer)) deviceInfo += "|Manufacturer:" + manufacturer;
		if (!StringUtils.isEmptyOrNull(isTablet)) deviceInfo += "|Tablet:" + isTablet;
		if (!StringUtils.isEmptyOrNull(macAddress)) deviceInfo += "|MacAddress:" + macAddress;
		if (!StringUtils.isEmptyOrNull(bluetoothAddress)) deviceInfo += "|BluetoothAddress:" + bluetoothAddress;
		
		return deviceInfo;
	}
	
	public JSONObject toJSON() {
		JSONObject json = new JSONObject();
		try {
			json.put("BuildID", getId());
			json.put("OSVersion", getOsVersion());
			json.put("Model", getModel());
			json.put("Device", getSdkVervion());
			json.put("DeviceUDID", getDevice());
			json.put("Manufacturer", getProduct());
			json.put("Serial", getSerial());
			json.put("User", getUser());
			json.put("Hardware", getHardware());
			json.put("Tablet", getIsTablet());
			json.put("MacAddress", getMacAddress());
			json.put("BluetoothAddress", getBluetoothAddress());
		} catch (JSONException ex) {
			ex.printStackTrace();
		}
		return json;
	}
	
	/**
	 * This field is needed for Android to be able to create new objects,
	 * individually or as arrays.
	 * This also means that you can use use the default 
	 * constructor to create the object and use another method to
	 * hyrdate it as necessary. 
	 * I just find it easier to use the constructor.
	 * It makes sense for the way my brain thinks ;
	 */
	public static final Creator<DeviceInfo> CREATOR = new Creator<DeviceInfo>() {
		@Override
		public DeviceInfo createFromParcel(Parcel in) {
			return new DeviceInfo(in);
		}

		@Override
		public DeviceInfo[] newArray(int size) {
			return new DeviceInfo[size];
		}
	};

	/**
	 * Constructor to use when re-constructing object from a parcel.
	 *
	 * @param parcel a parcel from which to read this object
	 */
	public DeviceInfo(Parcel parcel) {
		id = parcel.readString();
		osVersion = parcel.readString();
		model = parcel.readString();
		sdkVervion = parcel.readString();
		device = parcel.readString();
		product = parcel.readString();
		serial = parcel.readString();
		user = parcel.readString();
		imei = parcel.readString();
		imeiOld = parcel.readString();
		hardware = parcel.readString();
		manufacturer = parcel.readString();
		macAddress = parcel.readString();
		bluetoothAddress = parcel.readString();
		isTablet = parcel.readString();
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the os version.
	 *
	 * @return the os version
	 */
	public String getOsVersion() {
		return osVersion;
	}

	/**
	 * Sets the os version.
	 *
	 * @param osVersion the new os version
	 */
	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}

	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * Sets the model.
	 *
	 * @param model the new model
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * Gets the sdk vervion.
	 *
	 * @return the sdk vervion
	 */
	public String getSdkVervion() {
		return sdkVervion;
	}

	/**
	 * Sets the sdk vervion.
	 *
	 * @param sdkVervion the new sdk vervion
	 */
	public void setSdkVervion(String sdkVervion) {
		this.sdkVervion = sdkVervion;
	}

	/**
	 * Gets the device.
	 *
	 * @return the device
	 */
	public String getDevice() {
		return device;
	}

	/**
	 * Sets the device.
	 *
	 * @param device the new device
	 */
	public void setDevice(String device) {
		this.device = device;
	}

	/**
	 * Gets the product.
	 *
	 * @return the product
	 */
	public String getProduct() {
		return product;
	}

	/**
	 * Sets the product.
	 *
	 * @param product the new product
	 */
	public void setProduct(String product) {
		this.product = product;
	}

	/**
	 * Gets the serial.
	 *
	 * @return the serial
	 */
	public String getSerial() {
		return serial;
	}

	/**
	 * Sets the serial.
	 *
	 * @param serial the new serial
	 */
	public void setSerial(String serial) {
		this.serial = serial;
	}

	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * Sets the user.
	 *
	 * @param user the new user
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * Gets the imei.
	 *
	 * @return the imei
	 */
	public String getImei() {
		return imei;
	}

	/**
	 * Sets the imei.
	 *
	 * @param imei the new imei
	 */
	public void setImei(String imei) {
		this.imei = imei;
	}

	/**
	 * Gets the hardware.
	 *
	 * @return the hardware
	 */
	public String getHardware() {
		return hardware;
	}

	/**
	 * Sets the hardware.
	 *
	 * @param hardware the new hardware
	 */
	public void setHardware(String hardware) {
		this.hardware = hardware;
	}

	/**
	 * Gets the manufacturer.
	 *
	 * @return the manufacturer
	 */
	public String getManufacturer() {
		return manufacturer;
	}

	/**
	 * Sets the manufacturer.
	 *
	 * @param manufacturer the new manufacturer
	 */
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getImeiOld() {
		return imeiOld;
	}

	public void setImeiOld(String imeiOld) {
		this.imeiOld = imeiOld;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public String getBluetoothAddress() {
		return bluetoothAddress;
	}

	public void setBluetoothAddress(String bluetoothAddress) {
		this.bluetoothAddress = bluetoothAddress;
	}

	public String getIsTablet() {
		return isTablet;
	}

	public void setIsTablet(String isTablet) {
		this.isTablet = isTablet;
	}
	
}

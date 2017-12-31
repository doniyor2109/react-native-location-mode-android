package com.doniyor2109;

import android.content.Context;
import android.location.LocationManager;
import java.util.*;
import com.facebook.react.bridge.*;

public class RNLocationModeAndroidModule extends ReactContextBaseJavaModule {
    private final String HIGH_ACCURACY  = "HIGH_ACCURACY";
    private final String BATTERY_SAVING = "BATTERY_SAVING";
    private final String DEVICE_ONLY    = "DEVICE_ONLY";
    private final String LOCATION_OFF   = "LOCATION_OFF";

    public RNLocationModeAndroidModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "RNLocationModeAndroid";
    }

    @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants = new HashMap<>();

        constants.put(HIGH_ACCURACY, HIGH_ACCURACY);
        constants.put(BATTERY_SAVING, BATTERY_SAVING);
        constants.put(DEVICE_ONLY, DEVICE_ONLY);
        constants.put(LOCATION_OFF, LOCATION_OFF);

        return constants;
    }

    @ReactMethod
    public void getMode(Promise promise) {
        LocationManager locationManager  = (LocationManager) this.getReactApplicationContext().getSystemService(Context.LOCATION_SERVICE);
        boolean isNetworkProviderEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        boolean isGPSProviderEnabled     = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        String result                    = LOCATION_OFF;

        if (isNetworkProviderEnabled && isGPSProviderEnabled) {
            result = HIGH_ACCURACY;
        } else if (isGPSProviderEnabled) {
            result = DEVICE_ONLY;
        } else if (isNetworkProviderEnabled) {
            result = BATTERY_SAVING;
        }

        promise.resolve(result);
    }
}
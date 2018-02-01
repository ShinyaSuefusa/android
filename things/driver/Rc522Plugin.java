package org.apache.cordova.android.things.driver;

import com.galarzaa.androidthings.Rc522;
import com.nilhcem.androidthings.driver.lcdpcf8574.LcdPcf8574;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shinya on 2018/01/31.
 */
public class Rc522Plugin extends CordovaPlugin {
    private Map<String, Rc522> deviceMap = new HashMap<>();

    @Override
    public void onDestroy() {
        for (Rc522 device : deviceMap.values()) {
            try {
                device.close();
            } catch (Exception e) {
                // Do nothing.
            }
        }
        deviceMap.clear();
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if ("closeAll".equals(action)) {
            onDestroy();
            callbackContext.success();
            return true;
        }


    }
}
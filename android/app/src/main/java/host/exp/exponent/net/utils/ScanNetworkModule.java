package host.exp.exponent.net.utils;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class ScanNetworkModule extends ReactContextBaseJavaModule {

    public ScanNetworkModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "ScanNetworkModule";
    }

    @ReactMethod
    public void getPrivateIP(Callback errorCallback, Callback successCallback) {
        successCallback.invoke("192.168.1.1");
    }
}

package host.exp.exponent;

import com.facebook.react.ReactPackage;

import org.unimodules.core.interfaces.Package;

import java.util.Arrays;
import java.util.List;

import expo.loaders.provider.interfaces.AppLoaderPackagesProviderInterface;
import host.exp.exponent.generated.BasePackageList;
import host.exp.exponent.net.utils.ScanNetworkPackage;
import okhttp3.OkHttpClient;

// Needed for `react-native link`
// import com.facebook.react.ReactApplication;
import com.pusherman.networkinfo.RNNetworkInfoPackage;
import com.peel.react.TcpSocketsModule;

public class MainApplication extends ExpoApplication implements AppLoaderPackagesProviderInterface<ReactPackage> {

  @Override
  public boolean isDebug() {
    return BuildConfig.DEBUG;
  }

  // Needed for `react-native link`
  public List<ReactPackage> getPackages() {
    return Arrays.<ReactPackage>asList(
        // Add your own packages here!
        // TODO: add native modules!

        // Needed for `react-native link`
        // new MainReactPackage(),
            new RNNetworkInfoPackage(),
            new TcpSocketsModule(),
            new ScanNetworkPackage()
    );
  }

  public List<Package> getExpoPackages() {
    return new BasePackageList().getPackageList();
  }

  @Override
  public String gcmSenderId() {
    return getString(R.string.gcm_defaultSenderId);
  }

  public static OkHttpClient.Builder okHttpClientBuilder(OkHttpClient.Builder builder) {
    // Customize/override OkHttp client here
    return builder;
  }
}

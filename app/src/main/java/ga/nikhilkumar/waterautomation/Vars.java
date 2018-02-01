package ga.nikhilkumar.waterautomation;

import android.content.Context;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;

import java.util.List;

import static android.content.Context.WIFI_SERVICE;

/**
 * Created by Nikhil on 27/01/2018.
 */

public abstract class Vars extends Context  {
    static String networkSSID = "Nikhil";
    static String networkPass = "password";
    final String ip="";
    void connect(){
        WifiConfiguration conf = new WifiConfiguration();
        conf.SSID = "\"" +networkSSID+ "\"";
        conf.wepKeys[0] = "\"" + networkPass + "\"";
        conf.wepTxKeyIndex = 0;
        conf.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.NONE);
        conf.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.WEP40);
        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        wifiManager.addNetwork(conf);
        List<WifiConfiguration> list = wifiManager.getConfiguredNetworks();
        for( WifiConfiguration i : list ) {
            if(i.SSID != null && i.SSID.equals("\"" + networkSSID + "\"")) {
                wifiManager.disconnect();
                wifiManager.enableNetwork(i.networkId, true);
                wifiManager.reconnect();
                break;
            }
        }
    }
}

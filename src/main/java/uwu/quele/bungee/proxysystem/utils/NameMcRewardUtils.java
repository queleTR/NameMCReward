package uwu.quele.bungee.proxysystem.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/*
 * Author: quele
 * problems? add me on discord
 * discord: quele#0008
 */

public class NameMcRewardUtils {

    public static CompletableFuture<Boolean> checkAsync(UUID uuid) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                final URL url = new URL(
                        "https://api.namemc.com/server/hypetime.eu/likes?profile=" + uuid.toString());
                final URLConnection connection = url.openConnection();
                connection.setRequestProperty("User-Agent",
                        "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
                final BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));
                String line = null;
                boolean ret = false;
                while ((line = bufferedReader.readLine()) != null) {
                    line = line.toLowerCase();
                    if (line.contains("true")) {
                        ret = true;
                        break;
                    }
                }
                bufferedReader.close();
                return ret;
            } catch (Exception ex) {
                ex.printStackTrace();
                return false;
            }
        });
    }
}

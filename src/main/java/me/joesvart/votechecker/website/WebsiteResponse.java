package me.joesvart.votechecker.website;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import org.bukkit.plugin.java.JavaPlugin;

public class WebsiteResponse {

    public static void getResponse(JavaPlugin plugin,
                                   String url,
                                   WebsiteCallback callback
    ) {

        plugin.getServer().getScheduler().runTaskAsynchronously(plugin, () -> {
            try (BufferedReader reader =
                         new BufferedReader(
                                 new InputStreamReader(
                                         new URL(url).openStream()))) {

                callback.callback(reader.readLine());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }
}
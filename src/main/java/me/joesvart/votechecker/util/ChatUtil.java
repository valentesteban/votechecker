package me.joesvart.votechecker.util;

import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class ChatUtil {

    /**
     * Translate string.
     *
     * @param in the in
     * @return the string
     */
    public static String translate(String in) {
        return ChatColor.translateAlternateColorCodes('&', in);
    }

    /**
     * Translate list.
     *
     * @param lines the lines
     * @return the list
     */
    public static List<String> translate(List<String> lines) {
        List<String> toReturn = new ArrayList<>();

        for (String line : lines) {
            toReturn.add(ChatColor.translateAlternateColorCodes('&', line));
        }

        return toReturn;
    }

    /**
     * Translate list.
     *
     * @param lines the lines
     * @return the list
     */
    public static List<String> translate(String[] lines) {
        List<String> toReturn = new ArrayList<>();

        for (String line : lines) {
            if (line != null) {
                toReturn.add(ChatColor.translateAlternateColorCodes('&', line));
            }
        }

        return toReturn;
    }
}
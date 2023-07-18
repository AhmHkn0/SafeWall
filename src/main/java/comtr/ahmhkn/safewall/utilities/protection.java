package comtr.ahmhkn.safewall.utilities;

import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;

public class protection {

    private static HashSet<UUID> whiteList;
    private static Integer threshold;
    private static boolean protection;

    public static void register() {
        whiteList = new HashSet<>();
        threshold = 0;
        protection = false;
    }

    public static void addWhitelist(UUID uuid) {
        whiteList.add(uuid);
    }

    public static void addThreshold() {
        threshold += 1;
    }

    public static void reduceThreshold() {
        if (threshold > 0)
            threshold -= 1;
    }

    public static HashSet<UUID> getWhiteList() {
        return whiteList;
    }

    public static Integer getThreshold() {
        return threshold;
    }

    public static boolean getProtection() {
        return protection;
    }



}

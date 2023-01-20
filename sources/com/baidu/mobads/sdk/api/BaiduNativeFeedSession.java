package com.baidu.mobads.sdk.api;

import java.util.HashMap;

/* loaded from: classes.dex */
public class BaiduNativeFeedSession {
    private static HashMap<String, String> sessionHashMap = new HashMap<>();
    private static BaiduNativeFeedSession theInstance;

    private BaiduNativeFeedSession() {
    }

    public static synchronized BaiduNativeFeedSession getInstance() {
        BaiduNativeFeedSession baiduNativeFeedSession;
        synchronized (BaiduNativeFeedSession.class) {
            if (theInstance == null) {
                theInstance = new BaiduNativeFeedSession();
            }
            baiduNativeFeedSession = theInstance;
        }
        return baiduNativeFeedSession;
    }

    public int getSequenceId(int i2) {
        int i3 = 1;
        if (i2 < 1) {
            return 1;
        }
        try {
            if (sessionHashMap.containsKey(i2 + "")) {
                int parseInt = Integer.parseInt(sessionHashMap.get(i2 + "")) + 1;
                if (parseInt >= 1) {
                    i3 = parseInt;
                }
                sessionHashMap.put(i2 + "", i3 + "");
            } else {
                sessionHashMap.put(i2 + "", "1");
            }
        } catch (Exception unused) {
        }
        return i3;
    }
}

package cn.thinkingdata.android.utils;

import java.util.Map;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes.dex */
public interface h {

    /* loaded from: classes.dex */
    public static class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    String a(String str, String str2, boolean z, SSLSocketFactory sSLSocketFactory, Map<String, String> map);
}

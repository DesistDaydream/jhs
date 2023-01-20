package com.huawei.hms.framework.network.grs.h.g;

import android.content.Context;
import android.content.res.AssetManager;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.tencent.android.tpns.mqtt.MqttTopic;
import e.k.c.a.a.j.i;
import e.k.c.a.a.j.k;
import e.k.c.a.a.j.p.b;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes2.dex */
public class a {
    private static final HostnameVerifier a = new b();

    public static HostnameVerifier a() {
        return a;
    }

    public static SSLSocketFactory a(Context context) {
        try {
            AssetManager assets = context.getAssets();
            return new i(new k(assets.open(GrsApp.getInstance().getBrand(MqttTopic.TOPIC_LEVEL_SEPARATOR) + "grs_sp.bks"), ""));
        } catch (IOException | KeyManagementException | NoSuchAlgorithmException e2) {
            throw new AssertionError(e2);
        }
    }
}

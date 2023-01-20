package com.ss.android.socialbase.appdownloader.b;

import android.os.Build;
import android.text.TextUtils;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.tencent.android.tpns.mqtt.MqttTopic;

/* loaded from: classes3.dex */
public class a {
    public static final String a;

    static {
        StringBuilder sb = new StringBuilder();
        String str = Build.VERSION.RELEASE;
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(str);
        boolean z3 = !TextUtils.isEmpty(Build.ID);
        z = (!"REL".equals(Build.VERSION.CODENAME) || TextUtils.isEmpty(Build.MODEL)) ? false : false;
        sb.append("AppDownloader");
        if (z2) {
            sb.append(MqttTopic.TOPIC_LEVEL_SEPARATOR);
            sb.append(str);
        }
        sb.append(" (Linux; U; Android");
        if (z2) {
            sb.append(ExpandableTextView.N);
            sb.append(str);
        }
        if (z || z3) {
            sb.append(";");
            if (z) {
                sb.append(ExpandableTextView.N);
                sb.append(Build.MODEL);
            }
            if (z3) {
                sb.append(" Build/");
                sb.append(Build.ID);
            }
        }
        sb.append(")");
        a = sb.toString();
    }
}

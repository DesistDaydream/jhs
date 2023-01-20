package d.a.a;

import android.content.Context;
import android.content.res.Resources;
import cn.thinkingdata.android.TDPresetProperties;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class k {

    /* renamed from: d  reason: collision with root package name */
    private static final Map<Context, k> f9292d = new HashMap();
    private String a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f9293c;

    private k(Context context) {
        this.b = 10;
        this.f9293c = 10000;
        Resources resources = context.getResources();
        String packageName = context.getPackageName();
        try {
            this.a = packageName;
            this.a = resources.getString(resources.getIdentifier("TADeFaultMainProcessName", "string", packageName));
        } catch (Exception unused) {
        }
        try {
            this.b = resources.getInteger(resources.getIdentifier("TARetentionDays", "integer", packageName));
        } catch (Exception unused2) {
        }
        try {
            this.f9293c = resources.getInteger(resources.getIdentifier("TADatabaseLimit", "integer", packageName));
        } catch (Exception unused3) {
        }
        TDPresetProperties.initDisableList(context);
    }

    public static k b(Context context) {
        k kVar;
        Map<Context, k> map = f9292d;
        synchronized (map) {
            kVar = map.get(context);
            if (kVar == null) {
                kVar = new k(context);
                map.put(context, kVar);
            }
        }
        return kVar;
    }

    public long a() {
        int i2 = this.b;
        return 86400000 * ((i2 > 10 || i2 < 0) ? 10 : 10);
    }

    public String c() {
        return this.a;
    }

    public int d() {
        return Math.max(this.f9293c, 5000);
    }
}

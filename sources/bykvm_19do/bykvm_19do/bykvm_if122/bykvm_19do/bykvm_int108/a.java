package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_int108;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.msdk.adapter.config.DefaultAdapterClasses;
import com.bytedance.msdk.adapter.config.ITTAdapterConfiguration;
import com.bytedance.msdk.adapter.util.Preconditions;
import com.bytedance.msdk.adapter.util.Reflection;
import com.bytedance.msdk.api.v2.ad.custom.init.GMCustomAdapterConfiguration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class a {
    private final Map<String, ITTAdapterConfiguration> a = new ConcurrentHashMap();
    private final Map<String, GMCustomAdapterConfiguration> b = new ConcurrentHashMap();

    public ITTAdapterConfiguration a(String str) {
        String classNameByAdnName = DefaultAdapterClasses.getClassNameByAdnName(str);
        if (TextUtils.isEmpty(classNameByAdnName)) {
            return null;
        }
        ITTAdapterConfiguration iTTAdapterConfiguration = this.a.get(classNameByAdnName);
        if (iTTAdapterConfiguration == null) {
            try {
                ITTAdapterConfiguration iTTAdapterConfiguration2 = (ITTAdapterConfiguration) Reflection.instantiateClassWithEmptyConstructor(classNameByAdnName, ITTAdapterConfiguration.class);
                if (iTTAdapterConfiguration2 != null) {
                    try {
                        this.a.put(classNameByAdnName, iTTAdapterConfiguration2);
                    } catch (Throwable unused) {
                    }
                }
                return iTTAdapterConfiguration2;
            } catch (Throwable unused2) {
            }
        }
        return iTTAdapterConfiguration;
    }

    public String a(Context context, Map<String, Object> map, String str) {
        Preconditions.checkNotNull(context);
        GMCustomAdapterConfiguration b = b(str);
        if (b != null) {
            return b.getBiddingToken(null, null);
        }
        ITTAdapterConfiguration a = a(str);
        if (a != null) {
            return a.getBiddingToken(context, map);
        }
        return null;
    }

    public Map<String, ITTAdapterConfiguration> a() {
        ITTAdapterConfiguration iTTAdapterConfiguration;
        for (String str : DefaultAdapterClasses.getClassNamesSet()) {
            try {
                if ((this.a.containsKey(str) ? this.a.get(str) : null) == null && (iTTAdapterConfiguration = (ITTAdapterConfiguration) Reflection.instantiateClassWithEmptyConstructor(str, ITTAdapterConfiguration.class)) != null) {
                    this.a.put(str, iTTAdapterConfiguration);
                }
            } catch (Exception unused) {
            }
        }
        return this.a;
    }

    public void a(String str, GMCustomAdapterConfiguration gMCustomAdapterConfiguration) {
        this.b.put(str, gMCustomAdapterConfiguration);
    }

    public GMCustomAdapterConfiguration b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.b.get(str);
    }

    public Map<String, Object> b(Context context, Map<String, Object> map, String str) {
        Preconditions.checkNotNull(context);
        GMCustomAdapterConfiguration b = b(str);
        if (b != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("buyerId", b.getBiddingToken(context, map));
            hashMap.put("sdkInfo", b.getSdkInfo(context, map));
            return hashMap;
        }
        ITTAdapterConfiguration a = a(str);
        if (a == null) {
            return null;
        }
        return a.getBiddingTokenMap(context, map);
    }
}

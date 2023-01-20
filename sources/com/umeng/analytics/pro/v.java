package com.umeng.analytics.pro;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qcloud.tuikit.tuichat.ui.view.input.TIMMentionEditText;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.i;
import com.umeng.analytics.vshelper.PageNameMonitor;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class v {

    /* renamed from: c  reason: collision with root package name */
    private static final int f7279c = 5;

    /* renamed from: d  reason: collision with root package name */
    private static JSONArray f7280d = new JSONArray();

    /* renamed from: e  reason: collision with root package name */
    private static Object f7281e = new Object();

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, Long> f7282f = new HashMap();
    public Stack<String> a = new Stack<>();
    public com.umeng.analytics.vshelper.a b = PageNameMonitor.getInstance();

    public static void a(Context context) {
        String jSONArray;
        if (context != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                synchronized (f7281e) {
                    jSONArray = f7280d.toString();
                    f7280d = new JSONArray();
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put("__a", new JSONArray(jSONArray));
                    if (jSONObject.length() > 0) {
                        i.a(context).a(u.a().c(), jSONObject, i.a.PAGE);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public int a() {
        return 2;
    }

    public void b(String str) {
        Long l2;
        Context appContext;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.f7282f.containsKey(str)) {
            synchronized (this.f7282f) {
                l2 = this.f7282f.get(str);
                this.f7282f.remove(str);
            }
            if (l2 == null) {
                return;
            }
            if (UMConfigure.isDebugLog() && this.a.size() > 0 && str.equals(this.a.peek())) {
                this.a.pop();
            }
            long currentTimeMillis = System.currentTimeMillis() - l2.longValue();
            synchronized (f7281e) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(d.v, str);
                    jSONObject.put("duration", currentTimeMillis);
                    jSONObject.put(d.x, l2);
                    jSONObject.put("type", a());
                    f7280d.put(jSONObject);
                    if (f7280d.length() >= 5 && (appContext = UMGlobalContext.getAppContext(null)) != null) {
                        UMWorkDispatch.sendEvent(appContext, 4099, CoreProtocol.getInstance(appContext), null);
                    }
                } catch (Throwable unused) {
                }
            }
            if (!UMConfigure.isDebugLog() || this.a.size() == 0) {
                return;
            }
            UMLog.aq(j.E, 0, "\\|", new String[]{TIMMentionEditText.TIM_MENTION_TAG}, new String[]{str}, null, null);
        } else if (UMConfigure.isDebugLog() && this.a.size() == 0) {
            UMLog.aq(j.G, 0, "\\|", new String[]{TIMMentionEditText.TIM_MENTION_TAG}, new String[]{str}, null, null);
        }
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (UMConfigure.isDebugLog() && this.a.size() != 0) {
            UMLog.aq(j.F, 0, "\\|", new String[]{TIMMentionEditText.TIM_MENTION_TAG}, new String[]{this.a.peek()}, null, null);
        }
        this.b.customPageBegin(str);
        synchronized (this.f7282f) {
            this.f7282f.put(str, Long.valueOf(System.currentTimeMillis()));
            if (UMConfigure.isDebugLog()) {
                this.a.push(str);
            }
        }
    }

    public void b() {
        String str;
        synchronized (this.f7282f) {
            str = null;
            long j2 = 0;
            for (Map.Entry<String, Long> entry : this.f7282f.entrySet()) {
                if (entry.getValue().longValue() > j2) {
                    long longValue = entry.getValue().longValue();
                    str = entry.getKey();
                    j2 = longValue;
                }
            }
        }
        if (str != null) {
            b(str);
        }
    }
}

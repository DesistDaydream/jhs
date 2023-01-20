package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_for12;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.j;
import bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.m;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.umeng.analytics.pro.d;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {
    public JSONObject a;

    public a() {
        this.a = new JSONObject();
    }

    public a(JSONObject jSONObject) {
        this.a = jSONObject;
    }

    public static a a(long j2, Context context, @Nullable Thread thread, @NonNull Throwable th) {
        if (j2 == 0) {
            j2 = System.currentTimeMillis();
        }
        a aVar = new a();
        aVar.a("isJava", (Object) 1);
        aVar.a("event_type", "java_crash");
        aVar.a("timestamp", Long.valueOf(System.currentTimeMillis()));
        aVar.a("data", m.a(th));
        aVar.a("isOOM", Boolean.valueOf(m.b(th)));
        aVar.a("crash_time", Long.valueOf(j2));
        aVar.a(ContentProviderManager.PLUGIN_PROCESS_NAME, bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.a.b(context));
        if (!bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.a.g(context)) {
            aVar.a("remote_process", (Object) 1);
        }
        bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.a.a(context, aVar.a());
        String name = thread == null ? null : thread.getName();
        if (name != null) {
            aVar.a("crash_thread_name", name);
        }
        aVar.a("all_thread_stacks", m.a(name));
        return aVar;
    }

    public a a(int i2, String str) {
        try {
            this.a.put("miniapp_id", i2);
            this.a.put("miniapp_version", str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return this;
    }

    public a a(long j2) {
        try {
            a(d.p, Long.valueOf(j2));
            a("app_start_time_readable", new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.getDefault()).format(new Date(j2)));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return this;
    }

    public a a(b bVar) {
        a("header", bVar.a());
        return this;
    }

    public a a(bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1.bykvm_19do.b bVar) {
        a("activity_trace", bVar.a());
        a("running_tasks", bVar.b());
        return this;
    }

    public a a(@NonNull String str) {
        if (!TextUtils.isEmpty(str)) {
            a("session_id", str);
        }
        return this;
    }

    public a a(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        for (String str : list) {
            jSONArray.put(str);
        }
        a("logcat", jSONArray);
        return this;
    }

    public a a(Map<? extends String, ? extends String> map) {
        if (map != null) {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                try {
                    jSONObject.put(str, map.get(str));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            a("filters", jSONObject);
        }
        return this;
    }

    public a a(JSONObject jSONObject) {
        a("storage", jSONObject);
        return this;
    }

    public JSONObject a() {
        return this.a;
    }

    public void a(@NonNull String str, @Nullable Object obj) {
        try {
            this.a.put(str, obj);
        } catch (Exception e2) {
            j.b(e2);
        }
    }

    public a b(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null && !list.isEmpty()) {
            for (String str : list) {
                jSONArray.put(str);
            }
        }
        a("patch_info", jSONArray);
        return this;
    }

    public a b(Map<String, Integer> map) {
        JSONArray jSONArray = new JSONArray();
        if (map != null) {
            try {
                for (String str : map.keySet()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("package_name", str);
                    jSONObject.put("version_code", map.get(str));
                    jSONArray.put(jSONObject);
                }
            } catch (Exception unused) {
            }
        }
        this.a.put("plugin_info", jSONArray);
        return this;
    }

    public a c(Map<Integer, String> map) {
        if (map != null && map.size() > 0) {
            JSONObject jSONObject = new JSONObject();
            for (Integer num : map.keySet()) {
                try {
                    jSONObject.put(String.valueOf(num), map.get(num));
                } catch (JSONException e2) {
                    j.b(e2);
                }
            }
            try {
                this.a.put("sdk_info", jSONObject);
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
        return this;
    }
}

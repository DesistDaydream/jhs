package e.l.n.f;

import com.baidu.mobads.sdk.internal.bp;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import h.r0;
import h.t1;
import h.t2.u;
import java.io.IOException;
import k.e.a.d;
import k.e.a.e;
import kotlin.Result;
import l.h;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class c<T> implements h<ResponseBody, T> {
    @d
    private final Gson a;
    @d
    private final TypeAdapter<T> b;

    public c(@d Gson gson, @d TypeAdapter<T> typeAdapter) {
        this.a = gson;
        this.b = typeAdapter;
    }

    @Override // l.h
    @e
    /* renamed from: a */
    public T convert(@d ResponseBody responseBody) throws IOException {
        Object m106constructorimpl;
        String string = responseBody.string();
        JSONObject jSONObject = new JSONObject();
        T t = null;
        if (u.u2(string, "[", false, 2, null)) {
            JSONArray jSONArray = new JSONArray(string);
            jSONObject.put("code", 1);
            jSONObject.put("msg", bp.o);
            jSONObject.put("data", jSONArray);
        } else {
            if (string.length() == 0) {
                string = "{}";
            }
            JSONObject jSONObject2 = new JSONObject(string);
            if (jSONObject2.has(com.umeng.analytics.pro.d.O)) {
                jSONObject.put("code", jSONObject2.optInt("code"));
                jSONObject.put("msg", jSONObject2.optString("msg"));
                jSONObject.put("message", jSONObject2.optString("message"));
            } else {
                jSONObject.put("code", 1);
                jSONObject.put("msg", bp.o);
                jSONObject.put("data", jSONObject2);
            }
        }
        try {
            Result.a aVar = Result.Companion;
            t = this.b.b(jSONObject.toString());
            m106constructorimpl = Result.m106constructorimpl(t1.a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            m106constructorimpl = Result.m106constructorimpl(r0.a(th));
        }
        if (Result.m109exceptionOrNullimpl(m106constructorimpl) != null) {
            TypeAdapter<T> typeAdapter = this.b;
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("code", -1);
            jSONObject3.put("msg", "数据解析失败");
            jSONObject3.put("message", "数据解析失败");
            t1 t1Var = t1.a;
            return typeAdapter.b(jSONObject3.toString());
        }
        return t;
    }
}

package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.c0;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.v2.GMNetworkPlatformConst;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class l implements bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.c {
    public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_if122.a<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.a> a;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public final /* synthetic */ List a;
        public final /* synthetic */ bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.b b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f965c;

        public a(List list, bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.b bVar, List list2) {
            this.a = list;
            this.b = bVar;
            this.f965c = list2;
        }

        @Override // java.lang.Runnable
        public void run() {
            g a = l.this.a(this.a);
            if (this.b == null || a == null) {
                return;
            }
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.b bVar = new bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.b(a.a, a.b, a.f960c, a.f961d, "");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.a(bVar, this.f965c));
            this.b.a(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g a(List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.a> list) {
        try {
            if (this.a == null) {
                this.a = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.e();
            }
        } catch (Exception unused) {
        }
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_if122.a<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.a> aVar = this.a;
        if (aVar == null) {
            return null;
        }
        return aVar.a(list);
    }

    private void a(JSONObject jSONObject, int i2, long j2, int i3, JSONObject jSONObject2) {
        if (jSONObject != null) {
            try {
                String optString = jSONObject.optString("event_extra");
                if (TextUtils.isEmpty(optString)) {
                    return;
                }
                JSONObject jSONObject3 = new JSONObject(optString);
                jSONObject3.putOpt("size", Integer.valueOf(i2));
                jSONObject3.putOpt("batchId", Long.valueOf(j2));
                jSONObject3.putOpt("batchIndex", Integer.valueOf(i3));
                jSONObject3.putOpt("preEventId", jSONObject2 != null ? jSONObject2.optString("event_id") : GMNetworkPlatformConst.AD_NETWORK_NO_PRICE);
                jSONObject.put("event_extra", jSONObject3.toString());
            } catch (Throwable unused) {
            }
        }
    }

    private void b(JSONObject jSONObject, int i2, long j2, int i3, JSONObject jSONObject2) {
        if (jSONObject != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("params");
                if (optJSONObject != null) {
                    a(optJSONObject, i2, j2, i3, jSONObject2 != null ? jSONObject2.optJSONObject("params") : null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.c
    public void a(List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> list, @Nullable bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.b bVar) {
        Object aVar;
        if (list != null && list.size() > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = null;
            int i2 = 0;
            for (bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar2 : list) {
                JSONObject d2 = aVar2.d();
                byte e2 = aVar2.e();
                byte b = aVar2.b();
                if (e2 == 2 && b == 3) {
                    b(d2, list.size(), currentTimeMillis, i2, jSONObject);
                    aVar = new i(aVar2.i(), d2);
                } else if (e2 == 2 && b == 0) {
                    a(d2, list.size(), currentTimeMillis, i2, jSONObject);
                    aVar = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.a(aVar2.i(), d2);
                } else {
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.putOpt("not_v1v3", d2);
                        jSONObject2.putOpt("batchId", Long.valueOf(currentTimeMillis));
                        jSONObject2.putOpt("batchIndex", Integer.valueOf(i2));
                        c0.a(jSONObject2);
                    } catch (Throwable unused) {
                    }
                    i2++;
                    jSONObject = d2;
                }
                arrayList.add(aVar);
                i2++;
                jSONObject = d2;
            }
            if (arrayList.size() > 0) {
                ThreadHelper.getLogUploadExecutor().execute(new a(arrayList, bVar, list));
            }
        }
    }
}

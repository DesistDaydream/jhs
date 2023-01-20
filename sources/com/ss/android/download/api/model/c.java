package com.ss.android.download.api.model;

import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.downloadlib.addownload.j;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class c {
    private String a;
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final String f5152c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f5153d;

    /* renamed from: e  reason: collision with root package name */
    private final long f5154e;

    /* renamed from: f  reason: collision with root package name */
    private final String f5155f;

    /* renamed from: g  reason: collision with root package name */
    private final long f5156g;

    /* renamed from: h  reason: collision with root package name */
    private final JSONObject f5157h;

    /* renamed from: i  reason: collision with root package name */
    private final JSONObject f5158i;

    /* renamed from: j  reason: collision with root package name */
    private final List<String> f5159j;

    /* renamed from: k  reason: collision with root package name */
    private final int f5160k;

    /* renamed from: l  reason: collision with root package name */
    private final Object f5161l;

    /* renamed from: m  reason: collision with root package name */
    private final String f5162m;
    private final boolean n;
    private final String o;
    private final JSONObject p;

    /* loaded from: classes3.dex */
    public static class a {
        private String a;
        private String b;

        /* renamed from: c  reason: collision with root package name */
        private String f5163c;

        /* renamed from: e  reason: collision with root package name */
        private long f5165e;

        /* renamed from: f  reason: collision with root package name */
        private String f5166f;

        /* renamed from: g  reason: collision with root package name */
        private long f5167g;

        /* renamed from: h  reason: collision with root package name */
        private JSONObject f5168h;

        /* renamed from: i  reason: collision with root package name */
        private JSONObject f5169i;

        /* renamed from: j  reason: collision with root package name */
        private Map<String, Object> f5170j;

        /* renamed from: k  reason: collision with root package name */
        private List<String> f5171k;

        /* renamed from: l  reason: collision with root package name */
        private int f5172l;

        /* renamed from: m  reason: collision with root package name */
        private Object f5173m;
        private String n;
        private String p;
        private JSONObject q;

        /* renamed from: d  reason: collision with root package name */
        private boolean f5164d = false;
        private boolean o = false;

        public a a(boolean z) {
            this.o = z;
            return this;
        }

        public a b(String str) {
            this.f5163c = str;
            return this;
        }

        public a c(String str) {
            this.f5166f = str;
            return this;
        }

        public a d(String str) {
            this.n = str;
            return this;
        }

        public a a(String str) {
            this.b = str;
            return this;
        }

        public a b(long j2) {
            this.f5167g = j2;
            return this;
        }

        public a a(long j2) {
            this.f5165e = j2;
            return this;
        }

        public a b(boolean z) {
            this.f5164d = z;
            return this;
        }

        public a a(JSONObject jSONObject) {
            this.f5168h = jSONObject;
            return this;
        }

        public a b(JSONObject jSONObject) {
            this.f5169i = jSONObject;
            return this;
        }

        public a a(List<String> list) {
            this.f5171k = list;
            return this;
        }

        public a a(int i2) {
            this.f5172l = i2;
            return this;
        }

        public a a(Object obj) {
            this.f5173m = obj;
            return this;
        }

        public c a() {
            if (TextUtils.isEmpty(this.a)) {
                this.a = BaseConstants.CATEGORY_UMENG;
            }
            JSONObject jSONObject = new JSONObject();
            if (this.f5168h == null) {
                this.f5168h = new JSONObject();
            }
            try {
                Map<String, Object> map = this.f5170j;
                if (map != null && !map.isEmpty()) {
                    for (Map.Entry<String, Object> entry : this.f5170j.entrySet()) {
                        if (!this.f5168h.has(entry.getKey())) {
                            this.f5168h.putOpt(entry.getKey(), entry.getValue());
                        }
                    }
                }
                if (this.o) {
                    this.p = this.f5163c;
                    JSONObject jSONObject2 = new JSONObject();
                    this.q = jSONObject2;
                    if (this.f5164d) {
                        jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, this.f5168h.toString());
                    } else {
                        Iterator<String> keys = this.f5168h.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            this.q.put(next, this.f5168h.get(next));
                        }
                    }
                    this.q.put("category", this.a);
                    this.q.put(RemoteMessageConst.Notification.TAG, this.b);
                    this.q.put("value", this.f5165e);
                    this.q.put("ext_value", this.f5167g);
                    if (!TextUtils.isEmpty(this.n)) {
                        this.q.put("refer", this.n);
                    }
                    JSONObject jSONObject3 = this.f5169i;
                    if (jSONObject3 != null) {
                        this.q = com.ss.android.download.api.c.b.a(jSONObject3, this.q);
                    }
                    if (this.f5164d) {
                        if (!this.q.has("log_extra") && !TextUtils.isEmpty(this.f5166f)) {
                            this.q.put("log_extra", this.f5166f);
                        }
                        this.q.put(BaseConstants.EVENT_LABEL_IS_AD_EVENT, "1");
                    }
                }
                if (this.f5164d) {
                    jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, this.f5168h.toString());
                    if (!jSONObject.has("log_extra") && !TextUtils.isEmpty(this.f5166f)) {
                        jSONObject.put("log_extra", this.f5166f);
                    }
                    jSONObject.put(BaseConstants.EVENT_LABEL_IS_AD_EVENT, "1");
                } else {
                    jSONObject.put("extra", this.f5168h);
                }
                if (!TextUtils.isEmpty(this.n)) {
                    jSONObject.putOpt("refer", this.n);
                }
                JSONObject jSONObject4 = this.f5169i;
                if (jSONObject4 != null) {
                    jSONObject = com.ss.android.download.api.c.b.a(jSONObject4, jSONObject);
                }
                this.f5168h = jSONObject;
            } catch (Exception e2) {
                j.s().a(e2, "DownloadEventModel build");
            }
            return new c(this);
        }
    }

    public c(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.f5152c = aVar.f5163c;
        this.f5153d = aVar.f5164d;
        this.f5154e = aVar.f5165e;
        this.f5155f = aVar.f5166f;
        this.f5156g = aVar.f5167g;
        this.f5157h = aVar.f5168h;
        this.f5158i = aVar.f5169i;
        this.f5159j = aVar.f5171k;
        this.f5160k = aVar.f5172l;
        this.f5161l = aVar.f5173m;
        this.n = aVar.o;
        this.o = aVar.p;
        this.p = aVar.q;
        this.f5162m = aVar.n;
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.f5152c;
    }

    public boolean d() {
        return this.f5153d;
    }

    public long e() {
        return this.f5154e;
    }

    public String f() {
        return this.f5155f;
    }

    public long g() {
        return this.f5156g;
    }

    public JSONObject h() {
        return this.f5157h;
    }

    public JSONObject i() {
        return this.f5158i;
    }

    public List<String> j() {
        return this.f5159j;
    }

    public int k() {
        return this.f5160k;
    }

    public Object l() {
        return this.f5161l;
    }

    public boolean m() {
        return this.n;
    }

    public String n() {
        return this.o;
    }

    public JSONObject o() {
        return this.p;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("category: ");
        sb.append(this.a);
        sb.append("\ttag: ");
        sb.append(this.b);
        sb.append("\tlabel: ");
        sb.append(this.f5152c);
        sb.append("\nisAd: ");
        sb.append(this.f5153d);
        sb.append("\tadId: ");
        sb.append(this.f5154e);
        sb.append("\tlogExtra: ");
        sb.append(this.f5155f);
        sb.append("\textValue: ");
        sb.append(this.f5156g);
        sb.append("\nextJson: ");
        sb.append(this.f5157h);
        sb.append("\nparamsJson: ");
        sb.append(this.f5158i);
        sb.append("\nclickTrackUrl: ");
        List<String> list = this.f5159j;
        sb.append(list != null ? list.toString() : "");
        sb.append("\teventSource: ");
        sb.append(this.f5160k);
        sb.append("\textraObject: ");
        Object obj = this.f5161l;
        sb.append(obj != null ? obj.toString() : "");
        sb.append("\nisV3: ");
        sb.append(this.n);
        sb.append("\tV3EventName: ");
        sb.append(this.o);
        sb.append("\tV3EventParams: ");
        JSONObject jSONObject = this.p;
        sb.append(jSONObject != null ? jSONObject.toString() : "");
        return sb.toString();
    }
}

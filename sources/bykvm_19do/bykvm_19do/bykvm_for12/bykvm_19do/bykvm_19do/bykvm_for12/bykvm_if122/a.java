package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122;

import android.net.Uri;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a0;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.d;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.e;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.f;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.r;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.s;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.v;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.y;
import com.tencent.android.tpns.mqtt.MqttTopic;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class a extends b {

    /* renamed from: g  reason: collision with root package name */
    public static final d f261g = new d.a().b().a();

    /* renamed from: e  reason: collision with root package name */
    private d f262e;

    /* renamed from: f  reason: collision with root package name */
    private Map<String, String> f263f;

    /* renamed from: bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0017a implements f {
        public final /* synthetic */ bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a a;

        public C0017a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a aVar) {
            this.a = aVar;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.f
        public void a(e eVar, a0 a0Var) throws IOException {
            if (this.a != null) {
                HashMap hashMap = new HashMap();
                if (a0Var != null) {
                    r m2 = a0Var.m();
                    if (m2 != null) {
                        for (int i2 = 0; i2 < m2.b(); i2++) {
                            hashMap.put(m2.a(i2), m2.b(i2));
                        }
                    }
                    this.a.a(a.this, new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.b(a0Var.n(), a0Var.k(), a0Var.o(), hashMap, a0Var.i().l(), a0Var.t(), a0Var.r()));
                }
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.f
        public void a(e eVar, IOException iOException) {
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a aVar = this.a;
            if (aVar != null) {
                aVar.a(a.this, iOException);
            }
        }
    }

    static {
        new d.a().a();
    }

    public a(v vVar) {
        super(vVar);
        this.f262e = f261g;
        this.f263f = new HashMap();
    }

    public void a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a aVar) {
        y.a aVar2 = new y.a();
        s.a aVar3 = new s.a();
        try {
            Uri parse = Uri.parse(this.f265d);
            aVar3.e(parse.getScheme());
            aVar3.c(parse.getHost());
            String encodedPath = parse.getEncodedPath();
            if (!TextUtils.isEmpty(encodedPath)) {
                if (encodedPath.startsWith(MqttTopic.TOPIC_LEVEL_SEPARATOR)) {
                    encodedPath = encodedPath.substring(1);
                }
                aVar3.a(encodedPath);
            }
            Set<String> queryParameterNames = parse.getQueryParameterNames();
            if (queryParameterNames != null && queryParameterNames.size() > 0) {
                for (String str : queryParameterNames) {
                    this.f263f.put(str, parse.getQueryParameter(str));
                }
            }
            for (Map.Entry<String, String> entry : this.f263f.entrySet()) {
                aVar3.a(entry.getKey(), entry.getValue());
            }
            a(aVar2);
            aVar2.a(this.f262e);
            aVar2.a((Object) a());
            this.a.a(aVar2.a(aVar3.a()).b().a()).a(new C0017a(aVar));
        } catch (Throwable th) {
            th.printStackTrace();
            aVar.a(this, new IOException("Url is not a valid HTTP or HTTPS URL"));
        }
    }

    public void b(String str, String str2) {
        if (str == null) {
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.d.a("GetExecutor", "name cannot be null !!!");
        } else {
            this.f263f.put(str, str2);
        }
    }
}

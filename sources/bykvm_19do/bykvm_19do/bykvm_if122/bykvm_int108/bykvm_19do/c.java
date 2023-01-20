package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.bykvm_19do;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.v;
import com.bytedance.msdk.adapter.config.DefaultAdapterClasses;
import com.bytedance.msdk.adapter.config.IGMInitAdnResult;
import com.bytedance.msdk.adapter.config.ITTAdapterConfiguration;
import com.bytedance.msdk.adapter.config.TTOnNetworkInitializationFinishedListener;
import com.bytedance.msdk.api.AdError;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class c {
    private Context a;
    private IGMInitAdnResult b;

    /* loaded from: classes.dex */
    public class a implements IGMInitAdnResult {
        public a() {
        }

        @Override // com.bytedance.msdk.adapter.config.IGMInitAdnResult
        public void fail(@NonNull AdError adError) {
            if (c.this.b != null) {
                c.this.b.fail(adError);
            }
            if (adError != null) {
                String b = c.this.b();
                Boolean bool = Boolean.FALSE;
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.a.a(b, new Pair(bool, "errorCode = " + adError.code + " errorMessage = " + adError.message));
            }
        }

        @Override // com.bytedance.msdk.adapter.config.IGMInitAdnResult
        public void success() {
            if (c.this.b != null) {
                c.this.b.success();
            }
            if (TextUtils.equals(c.this.b(), "pangle")) {
                v.d(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d());
            }
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.a.a(c.this.b(), new Pair(Boolean.TRUE, ""));
        }
    }

    /* loaded from: classes.dex */
    public class b implements TTOnNetworkInitializationFinishedListener {
        public b() {
        }

        @Override // com.bytedance.msdk.adapter.config.TTOnNetworkInitializationFinishedListener
        public void onNetworkInitializationFinished(@NonNull Class<? extends ITTAdapterConfiguration> cls, @NonNull AdError adError) {
            if (TextUtils.equals(c.this.b(), "pangle")) {
                v.d(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d());
            }
            if (adError.code == 30011) {
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.a.a(c.this.b(), new Pair(Boolean.TRUE, ""));
                return;
            }
            String b = c.this.b();
            Boolean bool = Boolean.FALSE;
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.a.a(b, new Pair(bool, "errorCode = " + adError.code + " errorMessage = " + adError.message));
        }
    }

    public c(Context context) {
        this.a = context;
    }

    private void a(ITTAdapterConfiguration iTTAdapterConfiguration, Map<String, Object> map) {
        iTTAdapterConfiguration.initAdn(this.a, map, new a());
    }

    private void a(boolean z) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a a2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().a(b());
        if (z || a2 != null) {
            g();
        }
    }

    private void b(ITTAdapterConfiguration iTTAdapterConfiguration, Map<String, Object> map) {
        iTTAdapterConfiguration.initializeNetwork(this.a, map, new b());
    }

    private void g() {
        try {
            if (this.a == null) {
                throw new Exception("adn init context is null");
            }
            String a2 = a();
            if (!TextUtils.isEmpty(a2)) {
                throw new Exception("adn init " + a2);
            }
            Map<String, ITTAdapterConfiguration> e2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.a.e();
            if (e2 == null) {
                throw new Exception("adn init adpters is null");
            }
            ITTAdapterConfiguration iTTAdapterConfiguration = e2.get(DefaultAdapterClasses.getClassNameByAdnName(b()));
            if (iTTAdapterConfiguration == null) {
                throw new Exception("adn init configuration is null");
            }
            Map<String, Object> d2 = d();
            if (d2 == null) {
                throw new Exception("adn init getConfig() is null");
            }
            if (iTTAdapterConfiguration.isNewInitFunction()) {
                a(iTTAdapterConfiguration, d2);
            } else {
                b(iTTAdapterConfiguration, d2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.a.a(b(), new Pair(Boolean.FALSE, th.toString()));
        }
    }

    public abstract String a();

    public void a(IGMInitAdnResult iGMInitAdnResult) {
        this.b = iGMInitAdnResult;
        e();
    }

    public abstract String b();

    public void b(IGMInitAdnResult iGMInitAdnResult) {
        this.b = iGMInitAdnResult;
        f();
    }

    public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a c() {
        return bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().a(b());
    }

    public abstract Map<String, Object> d();

    public void e() {
        a(false);
    }

    public void f() {
        a(true);
    }
}

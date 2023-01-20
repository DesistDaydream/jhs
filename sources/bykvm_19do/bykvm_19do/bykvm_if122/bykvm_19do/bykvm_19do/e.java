package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.error.AdBreakError;

/* loaded from: classes.dex */
public abstract class e extends bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.f {

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public final /* synthetic */ AdError a;

        public a(AdError adError) {
            this.a = adError;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.b(this.a);
        }
    }

    /* loaded from: classes.dex */
    public class b implements bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.d {
        public b() {
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.d
        public void callback() {
            Log.i("TMe", "adn init registerADNInitCallback load config v2 --------------------");
            e.this.h0();
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.a.k();
            e.super.S();
        }
    }

    public e(Context context, String str) {
        super(context, str);
    }

    private boolean e0() {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar = this.f894d;
        if (cVar != null) {
            for (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j jVar : cVar.B()) {
                if (TextUtils.equals(jVar.e(), "pangle") && jVar.G()) {
                    return true;
                }
            }
        }
        return false;
    }

    private AdError f0() {
        AdSlot adSlot;
        if (!this.K || (adSlot = this.f898h) == null) {
            return null;
        }
        AdSlot shallowCopy = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.b.getShallowCopy(adSlot);
        shallowCopy.setLinkedId(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.g.d());
        AdBreakError adBreakError = new AdBreakError(AdError.ERROR_CODE_LOADED, AdError.getMessage(AdError.ERROR_CODE_LOADED));
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar = this.f894d;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(shallowCopy, cVar != null ? cVar.C() : null, true, j(), (int) AdError.ERROR_CODE_LOADED);
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar2 = this.f894d;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(shallowCopy, adBreakError, cVar2 != null ? cVar2.C() : null, j());
        return adBreakError;
    }

    private AdError g0() {
        AdSlot adSlot;
        if (!this.L || (adSlot = this.f898h) == null) {
            return null;
        }
        AdSlot shallowCopy = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.b.getShallowCopy(adSlot);
        shallowCopy.setLinkedId(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.g.d());
        AdBreakError adBreakError = new AdBreakError(AdError.ERROR_CODE_SHOWED, AdError.getMessage(AdError.ERROR_CODE_SHOWED));
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar = this.f894d;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(shallowCopy, cVar != null ? cVar.C() : null, true, j(), (int) AdError.ERROR_CODE_SHOWED);
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar2 = this.f894d;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(shallowCopy, adBreakError, cVar2 != null ? cVar2.C() : null, j());
        return adBreakError;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0() {
        if (e0() && bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.a.g()) {
            ThreadHelper.runOnThreadPool(new c());
        } else {
            super.S();
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    public void S() {
        String str;
        if (!bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().q()) {
            str = "adn init load config v1 --------------------";
        } else if (!bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().u()) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().a(new b());
            return;
        } else {
            str = "adn init load config v2 --------------------";
        }
        Log.i("TMe", str);
        h0();
    }

    public boolean d0() {
        if (this.f898h == null) {
            return true;
        }
        AdError g0 = g0();
        if (g0 == null && (g0 = f0()) == null) {
            return true;
        }
        ThreadHelper.runOnUiThread(new a(g0));
        return false;
    }
}

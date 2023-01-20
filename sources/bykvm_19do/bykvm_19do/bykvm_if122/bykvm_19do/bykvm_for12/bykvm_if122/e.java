package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122;

import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.base.TTBaseAd;

/* loaded from: classes.dex */
public class e implements Comparable<e> {
    public TTBaseAd a;
    public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d b;

    /* renamed from: c  reason: collision with root package name */
    private long f843c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f844d = false;

    /* renamed from: e  reason: collision with root package name */
    private AdSlot f845e;

    public e(TTBaseAd tTBaseAd, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d dVar, long j2, AdSlot adSlot) {
        this.a = tTBaseAd;
        this.b = dVar;
        this.f843c = j2;
        this.f845e = adSlot;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(e eVar) {
        return this.a.compareTo(eVar.a);
    }

    public AdSlot a() {
        return this.f845e;
    }

    public void a(boolean z) {
        this.f844d = z;
    }

    public long b() {
        return this.f843c;
    }

    public boolean c() {
        return this.f844d;
    }
}

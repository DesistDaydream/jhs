package com.tencent.bugly.crashreport.crash;

/* loaded from: classes3.dex */
public final class a implements Comparable<a> {
    public long a = -1;
    public long b = -1;

    /* renamed from: c  reason: collision with root package name */
    public String f6562c = null;

    /* renamed from: d  reason: collision with root package name */
    public boolean f6563d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6564e = false;

    /* renamed from: f  reason: collision with root package name */
    public int f6565f = 0;

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(a aVar) {
        int i2;
        a aVar2 = aVar;
        if (aVar2 == null || this.b - aVar2.b > 0) {
            return 1;
        }
        return i2 < 0 ? -1 : 0;
    }
}

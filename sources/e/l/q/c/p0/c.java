package e.l.q.c.p0;

import androidx.annotation.ColorRes;
import androidx.camera.view.PreviewView;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import h.k2.v.u;

/* loaded from: classes2.dex */
public final class c {
    @k.e.a.d
    private String a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f14178c;

    /* renamed from: d  reason: collision with root package name */
    private int f14179d;
    @k.e.a.d

    /* renamed from: e  reason: collision with root package name */
    private String f14180e;

    /* renamed from: f  reason: collision with root package name */
    private int f14181f;

    /* renamed from: g  reason: collision with root package name */
    private int f14182g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f14183h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f14184i;

    /* renamed from: j  reason: collision with root package name */
    private int f14185j;
    @k.e.a.d

    /* renamed from: k  reason: collision with root package name */
    private final ObservableBoolean f14186k;
    @k.e.a.d

    /* renamed from: l  reason: collision with root package name */
    private final ObservableInt f14187l;

    public c(@k.e.a.d String str, int i2, int i3, int i4, @k.e.a.d String str2, @ColorRes int i5, @ColorRes int i6, boolean z, boolean z2, int i7) {
        this.a = str;
        this.b = i2;
        this.f14178c = i3;
        this.f14179d = i4;
        this.f14180e = str2;
        this.f14181f = i5;
        this.f14182g = i6;
        this.f14183h = z;
        this.f14184i = z2;
        this.f14185j = i7;
        this.f14186k = new ObservableBoolean(z2);
        this.f14187l = new ObservableInt(i7);
    }

    public final int a() {
        return this.b;
    }

    public final int b() {
        return this.f14178c;
    }

    public final int c() {
        return this.f14179d;
    }

    @k.e.a.d
    public final ObservableBoolean d() {
        return this.f14186k;
    }

    @k.e.a.d
    public final ObservableInt e() {
        return this.f14187l;
    }

    public final int f() {
        return this.f14185j;
    }

    @k.e.a.d
    public final String g() {
        return this.a;
    }

    @k.e.a.d
    public final String h() {
        return this.f14180e;
    }

    public final int i() {
        return this.f14181f;
    }

    public final int j() {
        return this.f14182g;
    }

    public final boolean k() {
        return this.f14183h;
    }

    public final boolean l() {
        return this.f14184i;
    }

    public final void m(boolean z) {
        this.f14183h = z;
    }

    public final void n(int i2) {
        this.b = i2;
    }

    public final void o(int i2) {
        this.f14178c = i2;
    }

    public final void p(int i2) {
        this.f14179d = i2;
    }

    public final void q(int i2) {
        this.f14185j = i2;
        this.f14187l.set(i2);
    }

    public final void r(boolean z) {
        this.f14184i = z;
        this.f14186k.set(z);
    }

    public final void s(@k.e.a.d String str) {
        this.a = str;
    }

    public final void t(@k.e.a.d String str) {
        this.f14180e = str;
    }

    public final void u(int i2) {
        this.f14181f = i2;
    }

    public final void v(int i2) {
        this.f14182g = i2;
    }

    public /* synthetic */ c(String str, int i2, int i3, int i4, String str2, int i5, int i6, boolean z, boolean z2, int i7, int i8, u uVar) {
        this(str, i2, (i8 & 4) != 0 ? 0 : i3, (i8 & 8) != 0 ? 0 : i4, (i8 & 16) != 0 ? "" : str2, (i8 & 32) != 0 ? 17170432 : i5, (i8 & 64) != 0 ? PreviewView.DEFAULT_BACKGROUND_COLOR : i6, (i8 & 128) != 0 ? false : z, (i8 & 256) != 0 ? false : z2, (i8 & 512) != 0 ? 0 : i7);
    }
}

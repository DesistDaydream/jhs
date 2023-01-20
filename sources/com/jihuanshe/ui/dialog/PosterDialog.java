package com.jihuanshe.ui.dialog;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.vector.ext.bind.BindViewKt;
import e.l.k.k5;
import e.l.q.a.w;
import e.n.p;
import e.t.j.h.g;
import h.k2.v.n0;
import h.k2.v.u;
import h.m2.e;
import h.p2.n;
import k.e.a.d;
import kotlin.jvm.internal.PropertyReference1Impl;

/* loaded from: classes2.dex */
public final class PosterDialog extends w {
    @d

    /* renamed from: e  reason: collision with root package name */
    private final e f3993e = BindViewKt.r(this, R.id.posterIv);
    @d

    /* renamed from: f  reason: collision with root package name */
    private final g f3994f;
    @d

    /* renamed from: g  reason: collision with root package name */
    private final g f3995g;
    @d

    /* renamed from: h  reason: collision with root package name */
    private final p f3996h;

    /* renamed from: j  reason: collision with root package name */
    public static final /* synthetic */ n<Object>[] f3992j = {n0.r(new PropertyReference1Impl(n0.d(PosterDialog.class), "posterIv", "getPosterIv()Landroid/widget/ImageView;"))};
    @d

    /* renamed from: i  reason: collision with root package name */
    public static final a f3991i = new a(null);

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @d
        public final PosterDialog a(@d String str) {
            PosterDialog posterDialog = new PosterDialog();
            Bundle bundle = new Bundle();
            bundle.putString("url", str);
            posterDialog.setArguments(bundle);
            return posterDialog;
        }
    }

    public PosterDialog() {
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.f3994f = dVar.a(new PosterDialog$onPosterClick$1(this));
        this.f3995g = dVar.a(new PosterDialog$onCloseClick$1(this));
        this.f3996h = new p(null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageView E() {
        return (ImageView) this.f3993e.a(this, f3992j[0]);
    }

    @d
    public final g C() {
        return this.f3995g;
    }

    @d
    public final g D() {
        return this.f3994f;
    }

    @d
    public final p F() {
        return this.f3996h;
    }

    @Override // e.l.q.a.w
    public void d() {
        p pVar = this.f3996h;
        Bundle arguments = getArguments();
        pVar.setValue(arguments == null ? null : arguments.getString("url"));
    }

    @Override // e.l.q.a.w
    @d
    public ViewDataBinding p(@k.e.a.e ViewGroup viewGroup) {
        k5 d2 = k5.d(getLayoutInflater());
        d2.h(this);
        return d2;
    }

    @Override // e.l.q.a.w
    public void y(@k.e.a.e Bundle bundle) {
    }
}

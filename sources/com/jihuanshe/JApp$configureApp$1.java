package com.jihuanshe;

import android.content.Context;
import androidx.core.view.ViewCompat;
import com.caverock.androidsvg.SVG;
import com.jihuanshe.base.ui.widget.load.ErrorView;
import com.jihuanshe.base.ui.widget.load.LoadingView;
import e.t.i.a;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class JApp$configureApp$1 extends Lambda implements l<a, t1> {
    public static final JApp$configureApp$1 INSTANCE = new JApp$configureApp$1();

    /* renamed from: com.jihuanshe.JApp$configureApp$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<Context, ErrorView> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // h.k2.u.l
        @d
        public final ErrorView invoke(@d Context context) {
            return new ErrorView(context, null, 0, 6, null);
        }
    }

    /* renamed from: com.jihuanshe.JApp$configureApp$1$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass2 extends Lambda implements l<Context, LoadingView> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // h.k2.u.l
        @d
        public final LoadingView invoke(@d Context context) {
            return new LoadingView(context);
        }
    }

    public JApp$configureApp$1() {
        super(1);
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(a aVar) {
        invoke2(aVar);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d a aVar) {
        aVar.n(true);
        aVar.k(R.color.common_bg_color);
        aVar.s(ViewCompat.MEASURED_STATE_MASK);
        aVar.m(SVG.R);
        aVar.o(AnonymousClass1.INSTANCE);
        aVar.r(AnonymousClass2.INSTANCE);
        aVar.q(JApp.f3738j);
    }
}

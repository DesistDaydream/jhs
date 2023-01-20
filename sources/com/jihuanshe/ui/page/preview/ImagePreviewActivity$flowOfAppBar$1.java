package com.jihuanshe.ui.page.preview;

import com.vector.design.ui.nav.TextAttrs;
import com.vector.util.Screen;
import e.t.o.d;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ImagePreviewActivity$flowOfAppBar$1 extends Lambda implements l<TextAttrs, t1> {
    public static final ImagePreviewActivity$flowOfAppBar$1 INSTANCE = new ImagePreviewActivity$flowOfAppBar$1();

    public ImagePreviewActivity$flowOfAppBar$1() {
        super(1);
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(TextAttrs textAttrs) {
        invoke2(textAttrs);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d TextAttrs textAttrs) {
        Boolean bool = Boolean.TRUE;
        textAttrs.F(bool);
        textAttrs.H(Screen.a.l() - d.a.c(e.t.o.d.a, null, 1, null).d(96));
        textAttrs.J("查看卡图");
        textAttrs.x(bool);
    }
}

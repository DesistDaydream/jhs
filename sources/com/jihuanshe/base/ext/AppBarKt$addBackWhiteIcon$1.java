package com.jihuanshe.base.ext;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.view.View;
import com.jihuanshe.base.R;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.vector.design.ui.nav.ImageAttrs;
import com.vector.util.Res;
import e.t.o.d;
import h.k2.u.a;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/vector/design/ui/nav/ImageAttrs;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class AppBarKt$addBackWhiteIcon$1 extends Lambda implements l<ImageAttrs, t1> {
    public final /* synthetic */ Activity $activity;
    public final /* synthetic */ int $back;
    public final /* synthetic */ a<Boolean> $block;

    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", AdvanceSetting.NETWORK_TYPE, "Landroid/view/View;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    /* renamed from: com.jihuanshe.base.ext.AppBarKt$addBackWhiteIcon$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<View, t1> {
        public final /* synthetic */ Activity $activity;
        public final /* synthetic */ a<Boolean> $block;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(a<Boolean> aVar, Activity activity) {
            super(1);
            this.$block = aVar;
            this.$activity = activity;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(View view) {
            invoke2(view);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@d View view) {
            a<Boolean> aVar = this.$block;
            boolean z = false;
            if (aVar != null && aVar.invoke().booleanValue()) {
                z = true;
            }
            if (z) {
                return;
            }
            this.$activity.finish();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppBarKt$addBackWhiteIcon$1(int i2, a<Boolean> aVar, Activity activity) {
        super(1);
        this.$back = i2;
        this.$block = aVar;
        this.$activity = activity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(ImageAttrs imageAttrs) {
        invoke2(imageAttrs);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d ImageAttrs imageAttrs) {
        d.a aVar = e.t.o.d.a;
        imageAttrs.D(d.a.c(aVar, null, 1, null).d(45));
        imageAttrs.v(d.a.c(aVar, null, 1, null).d(32));
        imageAttrs.z(d.a.c(aVar, null, 1, null).d(24));
        imageAttrs.B(true);
        imageAttrs.x(R.drawable.icon_back);
        imageAttrs.C(ColorStateList.valueOf(Res.k(R.color.white)));
        imageAttrs.t(this.$back);
        imageAttrs.g(new AnonymousClass1(this.$block, this.$activity));
    }
}

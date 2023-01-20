package com.vector.view.pager;

import android.os.Message;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", AdvanceSetting.NETWORK_TYPE, "Landroid/os/Message;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ViewPager$scrollHandler$1 extends Lambda implements l<Message, t1> {
    public final /* synthetic */ ViewPager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewPager$scrollHandler$1(ViewPager viewPager) {
        super(1);
        this.this$0 = viewPager;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Message message) {
        invoke2(message);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d Message message) {
        this.this$0.scrollOnce();
        ViewPager viewPager = this.this$0;
        viewPager.sendScrollMessage(viewPager.getInterval());
    }
}

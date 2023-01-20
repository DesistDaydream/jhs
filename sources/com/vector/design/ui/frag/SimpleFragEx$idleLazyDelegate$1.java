package com.vector.design.ui.frag;

import android.os.MessageQueue;
import com.vector.design.ui.decor.DecorView;
import com.vector.design.ui.frag.SimpleFragEx$idleLazyDelegate$1;
import h.k2.u.a;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Landroid/os/MessageQueue$IdleHandler;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class SimpleFragEx$idleLazyDelegate$1 extends Lambda implements a<MessageQueue.IdleHandler> {
    public final /* synthetic */ SimpleFragEx this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleFragEx$idleLazyDelegate$1(SimpleFragEx simpleFragEx) {
        super(0);
        this.this$0 = simpleFragEx;
    }

    /* renamed from: invoke$lambda-0 */
    public static final boolean m43invoke$lambda0(SimpleFragEx simpleFragEx) {
        DecorView decorView;
        decorView = simpleFragEx.b;
        if (decorView != null) {
            decorView.e();
        }
        simpleFragEx.g();
        return false;
    }

    @Override // h.k2.u.a
    @d
    public final MessageQueue.IdleHandler invoke() {
        final SimpleFragEx simpleFragEx = this.this$0;
        return new MessageQueue.IdleHandler() { // from class: e.t.k.a.g.a
            @Override // android.os.MessageQueue.IdleHandler
            public final boolean queueIdle() {
                boolean m43invoke$lambda0;
                m43invoke$lambda0 = SimpleFragEx$idleLazyDelegate$1.m43invoke$lambda0(simpleFragEx);
                return m43invoke$lambda0;
            }
        };
    }
}

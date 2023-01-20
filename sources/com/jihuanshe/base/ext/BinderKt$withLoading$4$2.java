package com.jihuanshe.base.ext;

import androidx.exifinterface.media.ExifInterface;
import com.eth.model.NLive;
import e.t.k.a.f.h;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "state", "Lcom/eth/model/NLive$State;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class BinderKt$withLoading$4$2 extends Lambda implements l<NLive.State, t1> {
    public final /* synthetic */ h $dialog;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BinderKt$withLoading$4$2(h hVar) {
        super(1);
        this.$dialog = hVar;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(NLive.State state) {
        invoke2(state);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d NLive.State state) {
        if (state == NLive.State.LOADING) {
            this.$dialog.W();
        } else {
            this.$dialog.n();
        }
    }
}

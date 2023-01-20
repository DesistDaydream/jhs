package com.jihuanshe.base.ext;

import androidx.exifinterface.media.ExifInterface;
import com.eth.model.NLive;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.vector.design.ui.decor.ViewState;
import com.vector.design.ui.frag.SimpleFragEx;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, AdvanceSetting.NETWORK_TYPE, "Lcom/eth/model/NLive$State;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class BinderKt$withViewState$2$1 extends Lambda implements l<NLive.State, t1> {
    public final /* synthetic */ SimpleFragEx $frag;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[NLive.State.values().length];
            iArr[NLive.State.LOADING.ordinal()] = 1;
            iArr[NLive.State.ERROR.ordinal()] = 2;
            iArr[NLive.State.CANCEL.ordinal()] = 3;
            iArr[NLive.State.SUCCESS.ordinal()] = 4;
            a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BinderKt$withViewState$2$1(SimpleFragEx simpleFragEx) {
        super(1);
        this.$frag = simpleFragEx;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(NLive.State state) {
        invoke2(state);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d NLive.State state) {
        ViewState viewState;
        SimpleFragEx simpleFragEx = this.$frag;
        int i2 = a.a[state.ordinal()];
        if (i2 == 1) {
            viewState = ViewState.LOADING;
        } else if (i2 != 2 && i2 != 3 && i2 != 4) {
            throw new NoWhenBranchMatchedException();
        } else {
            viewState = ViewState.NORMAL;
        }
        simpleFragEx.R(viewState);
    }
}

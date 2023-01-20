package com.vector.databinding.adapter;

import android.widget.TextView;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import e.t.j.h.b;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", AdvanceSetting.NETWORK_TYPE, ""}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class TextViewBinding$setTextChangeListener$1 extends Lambda implements l<CharSequence, t1> {
    public final /* synthetic */ b $binding;
    public final /* synthetic */ TextView $view;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextViewBinding$setTextChangeListener$1(b bVar, TextView textView) {
        super(1);
        this.$binding = bVar;
        this.$view = textView;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(CharSequence charSequence) {
        invoke2(charSequence);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d CharSequence charSequence) {
        this.$binding.a().invoke(this.$view, charSequence);
    }
}

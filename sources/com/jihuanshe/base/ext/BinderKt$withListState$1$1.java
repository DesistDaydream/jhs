package com.jihuanshe.base.ext;

import androidx.exifinterface.media.ExifInterface;
import com.jihuanshe.base.model.Result;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.vector.design.ui.delegate.LoadMore;
import e.l.h.i.b;
import e.l.h.i.c;
import e.l.h.i.e;
import e.t.a;
import e.t.l.h;
import e.t.v.j.g;
import h.k2.u.l;
import h.t1;
import java.util.List;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0016\u0010\u0003\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u0001H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0004H\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, AdvanceSetting.NETWORK_TYPE, "Lkotlin/Pair;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class BinderKt$withListState$1$1 extends Lambda implements l<Pair<? extends T, ? extends T>, t1> {
    public final /* synthetic */ g<?> $view;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BinderKt$withListState$1$1(g<?> gVar) {
        super(1);
        this.$view = gVar;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Object obj) {
        invoke((Pair) obj);
        return t1.a;
    }

    public final void invoke(@d Pair<? extends T, ? extends T> pair) {
        Object second = pair.getSecond();
        g<?> gVar = this.$view;
        if (second != null && (second instanceof List)) {
            if (((List) second).size() < a.c().g()) {
                gVar.f(LoadMore.State.NO_MORE);
            } else {
                gVar.e();
            }
        }
        new h();
        Object second2 = pair.getSecond();
        g<?> gVar2 = this.$view;
        if (second2 != null && (second2 instanceof b)) {
            Object a = ((b) second2).a();
            if (a instanceof e) {
                if (((e) a).c()) {
                    gVar2.e();
                } else {
                    gVar2.f(LoadMore.State.NO_MORE);
                }
            }
        }
        new h();
        Object second3 = pair.getSecond();
        g<?> gVar3 = this.$view;
        if (second3 != null && (second3 instanceof Result)) {
            Object data = ((Result) second3).getData();
            e eVar = null;
            if (data instanceof b) {
                b bVar = (b) data;
                if (bVar.a() instanceof e) {
                    eVar = (e) bVar.a();
                }
            } else if (data instanceof e) {
                eVar = (e) data;
            }
            if (eVar != null && eVar.c()) {
                gVar3.e();
            } else {
                gVar3.f(LoadMore.State.NO_MORE);
            }
        }
        new h();
        Object second4 = pair.getSecond();
        g<?> gVar4 = this.$view;
        if (second4 != null && (second4 instanceof e.l.h.i.d)) {
            if (((e.l.h.i.d) second4).b() == 0) {
                gVar4.f(LoadMore.State.NO_MORE);
            } else {
                gVar4.e();
            }
        }
        new h();
        Object second5 = pair.getSecond();
        g<?> gVar5 = this.$view;
        if (second5 != null && (second5 instanceof e)) {
            if (((e) second5).c()) {
                gVar5.e();
            } else {
                gVar5.f(LoadMore.State.NO_MORE);
            }
        }
        new h();
        Object second6 = pair.getSecond();
        g<?> gVar6 = this.$view;
        if (second6 != null && (second6 instanceof Pair)) {
            List c2 = ((c) ((Pair) second6).getSecond()).c();
            if ((c2 == null ? 0 : c2.size()) < a.c().g()) {
                gVar6.f(LoadMore.State.NO_MORE);
            } else {
                gVar6.e();
            }
        }
        new h();
        Object second7 = pair.getSecond();
        g<?> gVar7 = this.$view;
        if (second7 != null && (second7 instanceof c)) {
            List c3 = ((c) second7).c();
            if ((c3 != null ? c3.size() : 0) < a.c().g()) {
                gVar7.f(LoadMore.State.NO_MORE);
            } else {
                gVar7.e();
            }
        }
        new h();
    }
}

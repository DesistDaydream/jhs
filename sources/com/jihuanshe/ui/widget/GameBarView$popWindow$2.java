package com.jihuanshe.ui.widget;

import android.content.Context;
import com.jihuanshe.model.Game;
import h.k2.u.a;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class GameBarView$popWindow$2 extends Lambda implements a<GamesPopupWindow> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ GameBarView this$0;

    /* renamed from: com.jihuanshe.ui.widget.GameBarView$popWindow$2$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<Boolean, t1> {
        public final /* synthetic */ GameBarView this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(GameBarView gameBarView) {
            super(1);
            this.this$0 = gameBarView;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return t1.a;
        }

        public final void invoke(boolean z) {
            l<Boolean, t1> showState = this.this$0.getShowState();
            if (showState == null) {
                return;
            }
            showState.invoke(Boolean.FALSE);
        }
    }

    /* renamed from: com.jihuanshe.ui.widget.GameBarView$popWindow$2$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass2 extends Lambda implements l<Game, t1> {
        public final /* synthetic */ GameBarView this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(GameBarView gameBarView) {
            super(1);
            this.this$0 = gameBarView;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(Game game) {
            invoke2(game);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@d Game game) {
            l<Game, t1> listener = this.this$0.getListener();
            if (listener == null) {
                return;
            }
            listener.invoke(game);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameBarView$popWindow$2(Context context, GameBarView gameBarView) {
        super(0);
        this.$context = context;
        this.this$0 = gameBarView;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final GamesPopupWindow invoke() {
        return new GamesPopupWindow(this.$context, new AnonymousClass1(this.this$0), new AnonymousClass2(this.this$0), Boolean.valueOf(this.this$0.getFitter()));
    }
}

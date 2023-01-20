package com.vector.design.ui.adapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.vector.R;
import com.vector.ext.view.ViewKt;
import h.k2.k;
import h.k2.u.p;
import h.k2.v.u;
import h.t1;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u0007H\u0016J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u0007H\u0016RR\u0010\u0005\u001a:\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006j\u0004\u0018\u0001`\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012RR\u0010\u0013\u001a:\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0006j\u0004\u0018\u0001`\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0010\"\u0004\b\u0017\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/vector/design/ui/adapter/RecyclerClickSupport;", "Landroidx/recyclerview/widget/RecyclerView$OnChildAttachStateChangeListener;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "(Landroidx/recyclerview/widget/RecyclerView;)V", "onItemClick", "Lkotlin/Function2;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "", "position", "", "Lcom/vector/design/ui/adapter/OnItemClick;", "getOnItemClick", "()Lkotlin/jvm/functions/Function2;", "setOnItemClick", "(Lkotlin/jvm/functions/Function2;)V", "onItemLongClick", "", "Lcom/vector/design/ui/adapter/OnItemLongClick;", "getOnItemLongClick", "setOnItemLongClick", "onChildViewAttachedToWindow", "onChildViewDetachedFromWindow", "Companion", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class RecyclerClickSupport implements RecyclerView.OnChildAttachStateChangeListener {
    @d

    /* renamed from: d */
    public static final a f7735d = new a(null);
    @d
    private final RecyclerView a;
    @e
    private p<? super View, ? super Integer, t1> b;
    @e

    /* renamed from: c */
    private p<? super View, ? super Integer, Boolean> f7736c;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/vector/design/ui/adapter/RecyclerClickSupport$Companion;", "", "()V", "with", "Lcom/vector/design/ui/adapter/RecyclerClickSupport;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @k
        @d
        public final RecyclerClickSupport a(@d RecyclerView recyclerView) {
            RecyclerClickSupport recyclerClickSupport = (RecyclerClickSupport) recyclerView.getTag(R.id.item_click_support);
            return recyclerClickSupport == null ? new RecyclerClickSupport(recyclerView, null) : recyclerClickSupport;
        }
    }

    private RecyclerClickSupport(RecyclerView recyclerView) {
        this.a = recyclerView;
        recyclerView.setTag(R.id.item_click_support, this);
        recyclerView.addOnChildAttachStateChangeListener(this);
    }

    public /* synthetic */ RecyclerClickSupport(RecyclerView recyclerView, u uVar) {
        this(recyclerView);
    }

    @k
    @d
    public static final RecyclerClickSupport f(@d RecyclerView recyclerView) {
        return f7735d.a(recyclerView);
    }

    @e
    public final p<View, Integer, t1> b() {
        return this.b;
    }

    @e
    public final p<View, Integer, Boolean> c() {
        return this.f7736c;
    }

    public final void d(@e p<? super View, ? super Integer, t1> pVar) {
        this.b = pVar;
    }

    public final void e(@e p<? super View, ? super Integer, Boolean> pVar) {
        this.f7736c = pVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public void onChildViewAttachedToWindow(@d View view) {
        ViewKt.B(view, new RecyclerClickSupport$onChildViewAttachedToWindow$1(this));
        ViewKt.z(view, new RecyclerClickSupport$onChildViewAttachedToWindow$2(this));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public void onChildViewDetachedFromWindow(@d View view) {
        view.setOnClickListener(null);
        view.setOnLongClickListener(null);
    }
}

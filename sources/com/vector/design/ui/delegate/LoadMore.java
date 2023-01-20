package com.vector.design.ui.delegate;

import com.baidu.mobads.sdk.internal.bp;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.qiniu.android.collect.ReportItem;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/vector/design/ui/delegate/LoadMore;", "", "Delegate", "Listener", "State", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public interface LoadMore {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/vector/design/ui/delegate/LoadMore$State;", "", "(Ljava/lang/String;I)V", "CONTINUE", bp.f1533l, "END", "NO_MORE", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public enum State {
        CONTINUE,
        ERROR,
        END,
        NO_MORE
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&J+\u0010\b\u001a\u00020\u00032!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00030\nH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000bH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000bH&¨\u0006\u0011"}, d2 = {"Lcom/vector/design/ui/delegate/LoadMore$Delegate;", "", "changeEmptyFooterState", "", TTLogUtil.TAG_EVENT_SHOW, "", "changeErrorFooterState", "resetLoadMoreState", "setOnLoadMoreListener", ReportItem.LogTypeBlock, "Lkotlin/Function1;", "Lcom/vector/design/ui/delegate/LoadMore$State;", "Lkotlin/ParameterName;", "name", "state", "startLoadMore", "stopLoadMore", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public interface a {
        void b(boolean z);

        void c(boolean z);

        void e();

        void f(@d State state);

        void g(@d State state);

        void setOnLoadMoreListener(@d l<? super State, t1> lVar);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/vector/design/ui/delegate/LoadMore$Listener;", "", "onLoadMore", "", "lastState", "Lcom/vector/design/ui/delegate/LoadMore$State;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public interface b {
        void a(@d State state);
    }
}

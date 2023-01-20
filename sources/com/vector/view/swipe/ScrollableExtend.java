package com.vector.view.swipe;

import com.baidu.mobads.sdk.internal.bp;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0001\u000bJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&¨\u0006\f"}, d2 = {"Lcom/vector/view/swipe/ScrollableExtend;", "", "changeState", "", "state", "Lcom/vector/view/swipe/ScrollableExtend$State;", "onError", "onFinish", "onLoading", "onNormal", "onReady", "State", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public interface ScrollableExtend {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/vector/view/swipe/ScrollableExtend$State;", "", "(Ljava/lang/String;I)V", "IDLE", "LOADING", bp.f1533l, "READY", "FINISH", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public enum State {
        IDLE,
        LOADING,
        ERROR,
        READY,
        FINISH
    }

    void a(@d State state);

    void b();

    void c();

    void onError();

    void onFinish();

    void onReady();
}

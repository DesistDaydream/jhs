package com.eth.adapter;

import i.b.v3.h;
import java.lang.reflect.Type;
import k.e.a.d;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;
import l.e;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0012\u0012\u0004\u0012\u0002H\u0001\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/eth/adapter/FlowCallAdapter;", "R", "Lretrofit2/CallAdapter;", "Lkotlinx/coroutines/flow/Flow;", "responseType", "Ljava/lang/reflect/Type;", "(Ljava/lang/reflect/Type;)V", "adapt", "call", "Lretrofit2/Call;", "eth_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class FlowCallAdapter<R> implements e<R, Flow<?>> {
    @d
    private final Type a;

    public FlowCallAdapter(@d Type type) {
        this.a = type;
    }

    @Override // l.e
    @d
    /* renamed from: a */
    public Flow<?> adapt(@d l.d<R> dVar) {
        return h.N0(new FlowCallAdapter$adapt$1(dVar, null));
    }

    @Override // l.e
    @d
    public Type responseType() {
        return this.a;
    }
}

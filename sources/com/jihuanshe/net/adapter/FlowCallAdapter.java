package com.jihuanshe.net.adapter;

import com.jihuanshe.base.model.Result;
import h.k2.v.u;
import i.b.v3.h;
import java.lang.reflect.Type;
import k.e.a.d;
import kotlinx.coroutines.flow.Flow;
import l.e;

/* loaded from: classes2.dex */
public final class FlowCallAdapter<D> implements e<Result<D>, Flow<?>> {
    @d
    public static final Companion Companion = new Companion(null);
    @d
    private static final String TAG = "FlowCallAdapter";
    @d
    private final Type responseType;

    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(u uVar) {
            this();
        }
    }

    public FlowCallAdapter(@d Type type) {
        this.responseType = type;
    }

    @Override // l.e
    @d
    public Type responseType() {
        return this.responseType;
    }

    @Override // l.e
    @d
    public Flow<?> adapt(@d l.d<Result<D>> dVar) {
        return h.N0(new FlowCallAdapter$adapt$1(dVar, null));
    }
}

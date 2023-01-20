package com.jihuanshe.net.adapter;

import h.k2.v.u;
import i.b.v3.h;
import java.lang.reflect.Type;
import k.e.a.d;
import kotlinx.coroutines.flow.Flow;
import l.e;

/* loaded from: classes2.dex */
public final class RawFlowCallAdapter<D> implements e<D, Flow<?>> {
    @d
    public static final Companion Companion = new Companion(null);
    @d
    public static final String TAG = "RawFlowAdapter";
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

    public RawFlowCallAdapter(@d Type type) {
        this.responseType = type;
    }

    @Override // l.e
    @d
    public Type responseType() {
        return this.responseType;
    }

    @Override // l.e
    @d
    public Flow<?> adapt(@d l.d<D> dVar) {
        return h.N0(new RawFlowCallAdapter$adapt$1(dVar, null));
    }
}

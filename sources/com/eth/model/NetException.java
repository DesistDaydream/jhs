package com.eth.model;

import h.k2.v.u;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/eth/model/NetException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "code", "", "message", "(Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "eth_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class NetException extends Exception {
    @d
    private final String code;

    public NetException(@d String str, @e String str2) {
        super(str2);
        this.code = str;
    }

    @d
    public final String getCode() {
        return this.code;
    }

    public /* synthetic */ NetException(String str, String str2, int i2, u uVar) {
        this(str, (i2 & 2) != 0 ? "" : str2);
    }
}

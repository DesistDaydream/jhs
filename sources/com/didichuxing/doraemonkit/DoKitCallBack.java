package com.didichuxing.doraemonkit;

import com.didichuxing.doraemonkit.kit.network.bean.NetworkRecord;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ\u001f\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\bJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/didichuxing/doraemonkit/DoKitCallBack;", "", "", "value", "", "filePath", "Lh/t1;", "onCpuCallBack", "(FLjava/lang/String;)V", "onFpsCallBack", "onMemoryCallBack", "Lcom/didichuxing/doraemonkit/kit/network/bean/NetworkRecord;", "record", "onNetworkCallBack", "(Lcom/didichuxing/doraemonkit/kit/network/bean/NetworkRecord;)V", "dokit-no-op_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public interface DoKitCallBack {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static void onCpuCallBack(DoKitCallBack doKitCallBack, float f2, @d String str) {
        }

        public static void onFpsCallBack(DoKitCallBack doKitCallBack, float f2, @d String str) {
        }

        public static void onMemoryCallBack(DoKitCallBack doKitCallBack, float f2, @d String str) {
        }

        public static void onNetworkCallBack(DoKitCallBack doKitCallBack, @d NetworkRecord networkRecord) {
        }
    }

    void onCpuCallBack(float f2, @d String str);

    void onFpsCallBack(float f2, @d String str);

    void onMemoryCallBack(float f2, @d String str);

    void onNetworkCallBack(@d NetworkRecord networkRecord);
}

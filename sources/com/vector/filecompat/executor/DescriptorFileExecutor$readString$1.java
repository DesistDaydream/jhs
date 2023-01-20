package com.vector.filecompat.executor;

import android.content.res.AssetFileDescriptor;
import android.util.Log;
import e.t.l.n;
import h.h2.b;
import h.k2.u.l;
import h.t1;
import java.io.FileInputStream;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "descriptor", "Landroid/content/res/AssetFileDescriptor;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class DescriptorFileExecutor$readString$1 extends Lambda implements l<AssetFileDescriptor, t1> {
    public final /* synthetic */ Ref.ObjectRef<String> $content;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DescriptorFileExecutor$readString$1(Ref.ObjectRef<String> objectRef) {
        super(1);
        this.$content = objectRef;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(AssetFileDescriptor assetFileDescriptor) {
        invoke2(assetFileDescriptor);
        return t1.a;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [T, java.lang.String] */
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d AssetFileDescriptor assetFileDescriptor) {
        FileInputStream fileInputStream = new FileInputStream(assetFileDescriptor.getFileDescriptor());
        try {
            this.$content.element = n.a(fileInputStream);
            t1 t1Var = t1.a;
            b.a(fileInputStream, null);
        } catch (Throwable th) {
            Log.e("safeUse", String.valueOf(th.getMessage()));
        }
    }
}

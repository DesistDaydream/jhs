package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.android.tpush.common.MessageKey;
import h.k2.u.l;
import h.k2.u.r;
import h.t1;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J*\u0010\r\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000f"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "text", "", MessageKey.MSG_ACCEPT_TIME_START, "", "count", "after", "onTextChanged", "before", "core-ktx_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class TextViewKt$addTextChangedListener$textWatcher$1 implements TextWatcher {
    public final /* synthetic */ l<Editable, t1> $afterTextChanged;
    public final /* synthetic */ r<CharSequence, Integer, Integer, Integer, t1> $beforeTextChanged;
    public final /* synthetic */ r<CharSequence, Integer, Integer, Integer, t1> $onTextChanged;

    /* JADX WARN: Multi-variable type inference failed */
    public TextViewKt$addTextChangedListener$textWatcher$1(l<? super Editable, t1> lVar, r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, t1> rVar, r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, t1> rVar2) {
        this.$afterTextChanged = lVar;
        this.$beforeTextChanged = rVar;
        this.$onTextChanged = rVar2;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(@e Editable editable) {
        this.$afterTextChanged.invoke(editable);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(@e CharSequence charSequence, int i2, int i3, int i4) {
        this.$beforeTextChanged.invoke(charSequence, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(@e CharSequence charSequence, int i2, int i3, int i4) {
        this.$onTextChanged.invoke(charSequence, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
    }
}

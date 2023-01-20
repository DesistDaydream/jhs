package e.t.u;

import android.text.InputFilter;
import android.text.Spanned;
import com.tencent.android.tpush.common.MessageKey;
import e.j.a.b.c.r.c0;
import h.k2.v.f0;
import h.t1;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0002\u0014\u0015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J:\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/vector/util/ContentInputFilter;", "Landroid/text/InputFilter$LengthFilter;", "maxInput", "", "(I)V", c0.a.a, "Lcom/vector/util/ContentInputFilter$onFullListener;", "getMaxInput", "()I", "filter", "", MessageKey.MSG_SOURCE, MessageKey.MSG_ACCEPT_TIME_START, MessageKey.MSG_ACCEPT_TIME_END, "dest", "Landroid/text/Spanned;", "dstart", "dend", "setOnFullListener", "", "Companion", "onFullListener", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class d extends InputFilter.LengthFilter {
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    public static final a f14663c = new a(null);
    private final int a;
    @k.e.a.e
    private b b;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\r"}, d2 = {"Lcom/vector/util/ContentInputFilter$Companion;", "", "()V", "getFwCharNum", "", "str", "", "getLength", "isFullwidthCharacter", "", "ch", "", "isNull", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(h.k2.v.u uVar) {
            this();
        }

        public final int a(@k.e.a.d String str) {
            int length;
            int i2 = 0;
            if (d(str) || (length = str.length()) <= 0) {
                return 0;
            }
            int i3 = 0;
            while (true) {
                int i4 = i2 + 1;
                if (c(str.charAt(i2))) {
                    i3++;
                }
                if (i4 >= length) {
                    return i3;
                }
                i2 = i4;
            }
        }

        public final int b(@k.e.a.d String str) {
            int i2 = 0;
            if (d(str)) {
                return 0;
            }
            int length = str.length();
            int length2 = str.length();
            if (length2 > 0) {
                while (true) {
                    int i3 = i2 + 1;
                    if (c(str.charAt(i2))) {
                        length++;
                    }
                    if (i3 >= length2) {
                        break;
                    }
                    i2 = i3;
                }
            }
            return length;
        }

        public final boolean c(char c2) {
            if (c2 < ' ' || c2 > 127) {
                if (!(65377 <= c2 && c2 <= 65439)) {
                    return true;
                }
            }
            return false;
        }

        public final boolean d(@k.e.a.e String str) {
            return str == null || f0.g("", str);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/vector/util/ContentInputFilter$onFullListener;", "", "isFull", "", "()Lkotlin/Unit;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public interface b {
        @k.e.a.d
        t1 c();
    }

    public d(int i2) {
        super(i2);
        this.a = i2;
    }

    public final int a() {
        return this.a;
    }

    public final void b(@k.e.a.e b bVar) {
        this.b = bVar;
    }

    @Override // android.text.InputFilter.LengthFilter, android.text.InputFilter
    @k.e.a.e
    public CharSequence filter(@k.e.a.d CharSequence charSequence, int i2, int i3, @k.e.a.d Spanned spanned, int i4, int i5) {
        a aVar = f14663c;
        int b2 = aVar.b(spanned.subSequence(i4, i5).toString());
        int b3 = aVar.b(spanned.toString());
        int b4 = aVar.b(charSequence.subSequence(i2, i3).toString());
        int i6 = this.a - (b3 - b2);
        if (i6 <= 0) {
            b bVar = this.b;
            if (bVar != null) {
                bVar.c();
            }
            return "";
        } else if (i6 >= b4) {
            return null;
        } else {
            int i7 = 0;
            int i8 = i2;
            while (i8 <= i3) {
                i7 += f14663c.c(charSequence.charAt(i8)) ? 2 : 1;
                if (i7 > i6) {
                    break;
                }
                i8++;
            }
            b bVar2 = this.b;
            if (bVar2 != null) {
                bVar2.c();
            }
            return charSequence.subSequence(i2, i8);
        }
    }
}

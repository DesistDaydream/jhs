package h.o2;

import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import h.a2.l1;
import h.f1;
import h.s0;
import h.v1;
import java.util.NoSuchElementException;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B \u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\t\u0010\n\u001a\u00020\u000bH\u0096\u0002J\u0015\u0010\r\u001a\u00020\u0003H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\b\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\u00020\u0003X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\t\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0010"}, d2 = {"Lkotlin/ranges/UIntProgressionIterator;", "Lkotlin/collections/UIntIterator;", "first", "Lkotlin/UInt;", "last", "step", "", "(IIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "finalElement", ExpandableTextView.P, "hasNext", "", "next", "nextUInt", "nextUInt-pVg5ArA", "()I", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
@s0(version = "1.3")
/* loaded from: classes3.dex */
public final class s extends l1 {
    private final int a;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private final int f14979c;

    /* renamed from: d  reason: collision with root package name */
    private int f14980d;

    private s(int i2, int i3, int i4) {
        this.a = i3;
        boolean z = true;
        int c2 = v1.c(i2, i3);
        if (i4 <= 0 ? c2 < 0 : c2 > 0) {
            z = false;
        }
        this.b = z;
        this.f14979c = f1.i(i4);
        this.f14980d = this.b ? i2 : i3;
    }

    @Override // h.a2.l1
    public int d() {
        int i2 = this.f14980d;
        if (i2 == this.a) {
            if (this.b) {
                this.b = false;
            } else {
                throw new NoSuchElementException();
            }
        } else {
            this.f14980d = f1.i(this.f14979c + i2);
        }
        return i2;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b;
    }

    public /* synthetic */ s(int i2, int i3, int i4, h.k2.v.u uVar) {
        this(i2, i3, i4);
    }
}

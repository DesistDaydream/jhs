package e.b.a.p.k;

import androidx.annotation.NonNull;
import e.b.a.p.k.y.a;
import java.io.File;

/* loaded from: classes.dex */
public class d<DataType> implements a.b {
    private final e.b.a.p.a<DataType> a;
    private final DataType b;

    /* renamed from: c  reason: collision with root package name */
    private final e.b.a.p.f f9517c;

    public d(e.b.a.p.a<DataType> aVar, DataType datatype, e.b.a.p.f fVar) {
        this.a = aVar;
        this.b = datatype;
        this.f9517c = fVar;
    }

    @Override // e.b.a.p.k.y.a.b
    public boolean a(@NonNull File file) {
        return this.a.a(this.b, file, this.f9517c);
    }
}

package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.ToNumberPolicy;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.stream.JsonToken;
import e.j.e.p;
import e.j.e.q;
import e.j.e.u.c;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class ObjectTypeAdapter extends TypeAdapter<Object> {

    /* renamed from: c  reason: collision with root package name */
    private static final q f3212c = k(ToNumberPolicy.DOUBLE);
    private final Gson a;
    private final p b;

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            a = iArr;
            try {
                iArr[JsonToken.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[JsonToken.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[JsonToken.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[JsonToken.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[JsonToken.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static q j(p pVar) {
        if (pVar == ToNumberPolicy.DOUBLE) {
            return f3212c;
        }
        return k(pVar);
    }

    private static q k(final p pVar) {
        return new q() { // from class: com.google.gson.internal.bind.ObjectTypeAdapter.1
            @Override // e.j.e.q
            public <T> TypeAdapter<T> a(Gson gson, e.j.e.t.a<T> aVar) {
                if (aVar.getRawType() == Object.class) {
                    return new ObjectTypeAdapter(gson, p.this);
                }
                return null;
            }
        };
    }

    @Override // com.google.gson.TypeAdapter
    public Object e(e.j.e.u.a aVar) throws IOException {
        switch (a.a[aVar.C0().ordinal()]) {
            case 1:
                ArrayList arrayList = new ArrayList();
                aVar.j();
                while (aVar.H()) {
                    arrayList.add(e(aVar));
                }
                aVar.q();
                return arrayList;
            case 2:
                LinkedTreeMap linkedTreeMap = new LinkedTreeMap();
                aVar.k();
                while (aVar.H()) {
                    linkedTreeMap.put(aVar.o0(), e(aVar));
                }
                aVar.r();
                return linkedTreeMap;
            case 3:
                return aVar.A0();
            case 4:
                return this.b.readNumber(aVar);
            case 5:
                return Boolean.valueOf(aVar.Y());
            case 6:
                aVar.x0();
                return null;
            default:
                throw new IllegalStateException();
        }
    }

    @Override // com.google.gson.TypeAdapter
    public void i(c cVar, Object obj) throws IOException {
        if (obj == null) {
            cVar.Y();
            return;
        }
        TypeAdapter q = this.a.q(obj.getClass());
        if (q instanceof ObjectTypeAdapter) {
            cVar.n();
            cVar.r();
            return;
        }
        q.i(cVar, obj);
    }

    private ObjectTypeAdapter(Gson gson, p pVar) {
        this.a = gson;
        this.b = pVar;
    }
}

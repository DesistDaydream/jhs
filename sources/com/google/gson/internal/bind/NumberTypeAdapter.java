package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.ToNumberPolicy;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonToken;
import e.j.e.p;
import e.j.e.q;
import e.j.e.u.c;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class NumberTypeAdapter extends TypeAdapter<Number> {
    private static final q b = k(ToNumberPolicy.LAZILY_PARSED_NUMBER);
    private final p a;

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            a = iArr;
            try {
                iArr[JsonToken.NULL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[JsonToken.NUMBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private NumberTypeAdapter(p pVar) {
        this.a = pVar;
    }

    public static q j(p pVar) {
        if (pVar == ToNumberPolicy.LAZILY_PARSED_NUMBER) {
            return b;
        }
        return k(pVar);
    }

    private static q k(p pVar) {
        return new q() { // from class: com.google.gson.internal.bind.NumberTypeAdapter.1
            @Override // e.j.e.q
            public <T> TypeAdapter<T> a(Gson gson, e.j.e.t.a<T> aVar) {
                if (aVar.getRawType() == Number.class) {
                    return NumberTypeAdapter.this;
                }
                return null;
            }
        };
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: l */
    public Number e(e.j.e.u.a aVar) throws IOException {
        JsonToken C0 = aVar.C0();
        int i2 = a.a[C0.ordinal()];
        if (i2 == 1) {
            aVar.x0();
            return null;
        } else if (i2 != 2 && i2 != 3) {
            throw new JsonSyntaxException("Expecting number, got: " + C0 + "; at path " + aVar.getPath());
        } else {
            return this.a.readNumber(aVar);
        }
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: m */
    public void i(c cVar, Number number) throws IOException {
        cVar.F0(number);
    }
}

package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonToken;
import e.j.e.q;
import e.j.e.s.d;
import e.j.e.s.g;
import e.j.e.u.c;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* loaded from: classes2.dex */
public final class DefaultDateTypeAdapter<T extends Date> extends TypeAdapter<T> {

    /* renamed from: c  reason: collision with root package name */
    private static final String f3209c = "DefaultDateTypeAdapter";
    private final b<T> a;
    private final List<DateFormat> b;

    /* loaded from: classes2.dex */
    public static abstract class b<T extends Date> {
        public static final b<Date> b = new a(Date.class);
        private final Class<T> a;

        /* loaded from: classes2.dex */
        public class a extends b<Date> {
            public a(Class cls) {
                super(cls);
            }

            @Override // com.google.gson.internal.bind.DefaultDateTypeAdapter.b
            public Date f(Date date) {
                return date;
            }
        }

        public b(Class<T> cls) {
            this.a = cls;
        }

        private final q e(DefaultDateTypeAdapter<T> defaultDateTypeAdapter) {
            return TypeAdapters.b(this.a, defaultDateTypeAdapter);
        }

        public final q a(int i2) {
            return e(new DefaultDateTypeAdapter<>(this, i2));
        }

        public final q b(int i2, int i3) {
            return e(new DefaultDateTypeAdapter<>(this, i2, i3));
        }

        public final q c(String str) {
            return e(new DefaultDateTypeAdapter<>(this, str));
        }

        public final q d() {
            return e(new DefaultDateTypeAdapter<>(this, 2, 2));
        }

        public abstract T f(Date date);
    }

    private Date j(e.j.e.u.a aVar) throws IOException {
        String A0 = aVar.A0();
        synchronized (this.b) {
            for (DateFormat dateFormat : this.b) {
                try {
                    return dateFormat.parse(A0);
                } catch (ParseException unused) {
                }
            }
            try {
                return e.j.e.s.k.c.a.g(A0, new ParsePosition(0));
            } catch (ParseException e2) {
                throw new JsonSyntaxException("Failed parsing '" + A0 + "' as Date; at path " + aVar.F(), e2);
            }
        }
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: k */
    public T e(e.j.e.u.a aVar) throws IOException {
        if (aVar.C0() == JsonToken.NULL) {
            aVar.x0();
            return null;
        }
        return this.a.f(j(aVar));
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: l */
    public void i(c cVar, Date date) throws IOException {
        String format;
        if (date == null) {
            cVar.Y();
            return;
        }
        DateFormat dateFormat = this.b.get(0);
        synchronized (this.b) {
            format = dateFormat.format(date);
        }
        cVar.G0(format);
    }

    public String toString() {
        DateFormat dateFormat = this.b.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + ')';
        }
        return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
    }

    private DefaultDateTypeAdapter(b<T> bVar, String str) {
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        this.a = (b) e.j.e.s.a.b(bVar);
        Locale locale = Locale.US;
        arrayList.add(new SimpleDateFormat(str, locale));
        if (Locale.getDefault().equals(locale)) {
            return;
        }
        arrayList.add(new SimpleDateFormat(str));
    }

    private DefaultDateTypeAdapter(b<T> bVar, int i2) {
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        this.a = (b) e.j.e.s.a.b(bVar);
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateInstance(i2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateInstance(i2));
        }
        if (d.e()) {
            arrayList.add(g.d(i2));
        }
    }

    private DefaultDateTypeAdapter(b<T> bVar, int i2, int i3) {
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        this.a = (b) e.j.e.s.a.b(bVar);
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(i2, i3, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(i2, i3));
        }
        if (d.e()) {
            arrayList.add(g.e(i2, i3));
        }
    }
}

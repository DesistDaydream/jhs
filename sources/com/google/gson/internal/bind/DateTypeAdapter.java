package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonToken;
import e.j.e.q;
import e.j.e.s.d;
import e.j.e.s.g;
import e.j.e.t.a;
import e.j.e.u.c;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* loaded from: classes2.dex */
public final class DateTypeAdapter extends TypeAdapter<Date> {
    public static final q b = new q() { // from class: com.google.gson.internal.bind.DateTypeAdapter.1
        @Override // e.j.e.q
        public <T> TypeAdapter<T> a(Gson gson, a<T> aVar) {
            if (aVar.getRawType() == Date.class) {
                return new DateTypeAdapter();
            }
            return null;
        }
    };
    private final List<DateFormat> a;

    public DateTypeAdapter() {
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(2, 2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (d.e()) {
            arrayList.add(g.e(2, 2));
        }
    }

    private Date j(e.j.e.u.a aVar) throws IOException {
        String A0 = aVar.A0();
        synchronized (this.a) {
            for (DateFormat dateFormat : this.a) {
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
    public Date e(e.j.e.u.a aVar) throws IOException {
        if (aVar.C0() == JsonToken.NULL) {
            aVar.x0();
            return null;
        }
        return j(aVar);
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: l */
    public void i(c cVar, Date date) throws IOException {
        String format;
        if (date == null) {
            cVar.Y();
            return;
        }
        DateFormat dateFormat = this.a.get(0);
        synchronized (this.a) {
            format = dateFormat.format(date);
        }
        cVar.G0(format);
    }
}

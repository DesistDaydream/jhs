package com.github.aachartmodel.aainfographics.aatools;

import e.j.a.c.m.o;
import e.t.u.b0;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import k.b.a.a.n.l;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ%\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aatools/AADate;", "", "", "year", "month", "day", "", "AADateUTC", "(III)J", "<init>", "()V", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class AADate {
    public static final AADate INSTANCE = new AADate();

    private AADate() {
    }

    public final long AADateUTC(int i2, int i3, int i4) {
        Date date;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(b0.a.b);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(o.a));
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(i2);
            sb.append(l.f16189d);
            sb.append(i3);
            sb.append(l.f16189d);
            sb.append(i4);
            date = simpleDateFormat.parse(sb.toString());
        } catch (ParseException e2) {
            e2.printStackTrace();
            date = null;
        }
        return date.getTime();
    }
}

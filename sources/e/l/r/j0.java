package e.l.r;

/* loaded from: classes2.dex */
public final class j0 {
    @k.e.a.d
    public static final j0 a = new j0();

    private j0() {
    }

    @k.e.a.d
    public final String a(long j2) {
        return b(j2, Boolean.FALSE);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    @k.e.a.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String b(long r13, @k.e.a.e java.lang.Boolean r15) {
        /*
            r12 = this;
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            if (r15 != 0) goto L9
            java.lang.Boolean r15 = java.lang.Boolean.FALSE
        L9:
            java.math.BigDecimal r1 = new java.math.BigDecimal
            java.lang.String r2 = "1000"
            r1.<init>(r2)
            java.math.BigDecimal r2 = new java.math.BigDecimal
            java.lang.String r3 = "10000"
            r2.<init>(r3)
            java.math.BigDecimal r3 = new java.math.BigDecimal
            java.lang.String r4 = "100000000"
            r3.<init>(r4)
            java.math.BigDecimal r4 = new java.math.BigDecimal
            r4.<init>(r13)
            boolean r15 = r15.booleanValue()
            r5 = 1
            if (r15 == 0) goto L3f
            int r15 = r4.compareTo(r1)
            if (r15 == 0) goto L3c
            int r15 = r4.compareTo(r1)
            if (r15 != r5) goto L37
            goto L3c
        L37:
            java.lang.String r13 = java.lang.String.valueOf(r13)
            goto L3e
        L3c:
            java.lang.String r13 = "999+"
        L3e:
            return r13
        L3f:
            int r13 = r4.compareTo(r2)
            r14 = -1
            java.lang.String r15 = ""
            if (r13 != r14) goto L50
            java.lang.String r13 = r4.toString()
            r0.append(r13)
            goto L7f
        L50:
            int r13 = r4.compareTo(r2)
            r1 = 4
            if (r13 != 0) goto L5d
            int r13 = r4.compareTo(r2)
            if (r13 == r5) goto L63
        L5d:
            int r13 = r4.compareTo(r3)
            if (r13 != r14) goto L72
        L63:
            java.math.BigDecimal r13 = r4.divide(r2)
            java.math.BigDecimal r13 = r13.setScale(r5, r1)
            java.lang.String r13 = r13.toString()
            java.lang.String r1 = "万"
            goto L90
        L72:
            int r13 = r4.compareTo(r3)
            if (r13 == 0) goto L82
            int r13 = r4.compareTo(r3)
            if (r13 != r5) goto L7f
            goto L82
        L7f:
            r13 = r15
            r1 = r13
            goto L90
        L82:
            java.math.BigDecimal r13 = r4.divide(r3)
            java.math.BigDecimal r13 = r13.setScale(r5, r1)
            java.lang.String r13 = r13.toString()
            java.lang.String r1 = "亿"
        L90:
            boolean r15 = h.k2.v.f0.g(r15, r13)
            java.lang.String r2 = "0"
            r3 = 0
            if (r15 != 0) goto Ld0
            r8 = 0
            r9 = 0
            r10 = 6
            r11 = 0
            java.lang.String r7 = "."
            r6 = r13
            int r15 = kotlin.text.StringsKt__StringsKt.r3(r6, r7, r8, r9, r10, r11)
            if (r15 != r14) goto Lad
            r0.append(r13)
            r0.append(r1)
            goto Ld0
        Lad:
            int r15 = r15 + r5
            int r14 = r15 + 1
            java.lang.String r4 = r13.substring(r15, r14)
            boolean r4 = h.k2.v.f0.g(r4, r2)
            if (r4 != 0) goto Lc5
            java.lang.String r13 = r13.substring(r3, r14)
            r0.append(r13)
            r0.append(r1)
            goto Ld0
        Lc5:
            int r15 = r15 - r5
            java.lang.String r13 = r13.substring(r3, r15)
            r0.append(r13)
            r0.append(r1)
        Ld0:
            int r13 = r0.length()
            if (r13 != 0) goto Ld7
            goto Ld8
        Ld7:
            r5 = 0
        Ld8:
            if (r5 == 0) goto Ldb
            goto Ldf
        Ldb:
            java.lang.String r2 = r0.toString()
        Ldf:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.r.j0.b(long, java.lang.Boolean):java.lang.String");
    }
}

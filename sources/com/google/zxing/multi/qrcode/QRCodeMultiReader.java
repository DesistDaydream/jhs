package com.google.zxing.multi.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.ResultMetadataType;
import e.j.f.b;
import e.j.f.k;
import e.j.f.l;
import e.j.f.q.d;
import e.j.f.q.f;
import e.j.f.t.c;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class QRCodeMultiReader extends e.j.f.w.a implements c {

    /* renamed from: c  reason: collision with root package name */
    private static final k[] f3257c = new k[0];

    /* renamed from: d  reason: collision with root package name */
    private static final l[] f3258d = new l[0];

    /* loaded from: classes2.dex */
    public static final class SAComparator implements Serializable, Comparator<k> {
        private SAComparator() {
        }

        @Override // java.util.Comparator
        public int compare(k kVar, k kVar2) {
            Map<ResultMetadataType, Object> e2 = kVar.e();
            ResultMetadataType resultMetadataType = ResultMetadataType.STRUCTURED_APPEND_SEQUENCE;
            return Integer.compare(((Integer) e2.get(resultMetadataType)).intValue(), ((Integer) kVar2.e().get(resultMetadataType)).intValue());
        }
    }

    private static List<k> h(List<k> list) {
        boolean z;
        Iterator<k> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                if (it.next().e().containsKey(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE)) {
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        if (z) {
            ArrayList arrayList = new ArrayList();
            ArrayList<k> arrayList2 = new ArrayList();
            for (k kVar : list) {
                arrayList.add(kVar);
                if (kVar.e().containsKey(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE)) {
                    arrayList2.add(kVar);
                }
            }
            Collections.sort(arrayList2, new SAComparator());
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            int i3 = 0;
            for (k kVar2 : arrayList2) {
                sb.append(kVar2.g());
                i2 += kVar2.d().length;
                Map<ResultMetadataType, Object> e2 = kVar2.e();
                ResultMetadataType resultMetadataType = ResultMetadataType.BYTE_SEGMENTS;
                if (e2.containsKey(resultMetadataType)) {
                    for (byte[] bArr : (Iterable) kVar2.e().get(resultMetadataType)) {
                        i3 += bArr.length;
                    }
                }
            }
            byte[] bArr2 = new byte[i2];
            byte[] bArr3 = new byte[i3];
            int i4 = 0;
            int i5 = 0;
            for (k kVar3 : arrayList2) {
                System.arraycopy(kVar3.d(), 0, bArr2, i4, kVar3.d().length);
                i4 += kVar3.d().length;
                Map<ResultMetadataType, Object> e3 = kVar3.e();
                ResultMetadataType resultMetadataType2 = ResultMetadataType.BYTE_SEGMENTS;
                if (e3.containsKey(resultMetadataType2)) {
                    for (byte[] bArr4 : (Iterable) kVar3.e().get(resultMetadataType2)) {
                        System.arraycopy(bArr4, 0, bArr3, i5, bArr4.length);
                        i5 += bArr4.length;
                    }
                }
            }
            k kVar4 = new k(sb.toString(), bArr2, f3258d, BarcodeFormat.QR_CODE);
            if (i3 > 0) {
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(bArr3);
                kVar4.j(ResultMetadataType.BYTE_SEGMENTS, arrayList3);
            }
            arrayList.add(kVar4);
            return arrayList;
        }
        return list;
    }

    @Override // e.j.f.t.c
    public k[] b(b bVar) throws NotFoundException {
        return d(bVar, null);
    }

    @Override // e.j.f.t.c
    public k[] d(b bVar, Map<DecodeHintType, ?> map) throws NotFoundException {
        f[] n;
        ArrayList arrayList = new ArrayList();
        for (f fVar : new e.j.f.t.d.a.a(bVar.b()).n(map)) {
            try {
                d c2 = f().c(fVar.a(), map);
                l[] b = fVar.b();
                if (c2.f() instanceof e.j.f.w.c.f) {
                    ((e.j.f.w.c.f) c2.f()).a(b);
                }
                k kVar = new k(c2.j(), c2.g(), b, BarcodeFormat.QR_CODE);
                List<byte[]> a2 = c2.a();
                if (a2 != null) {
                    kVar.j(ResultMetadataType.BYTE_SEGMENTS, a2);
                }
                String b2 = c2.b();
                if (b2 != null) {
                    kVar.j(ResultMetadataType.ERROR_CORRECTION_LEVEL, b2);
                }
                if (c2.k()) {
                    kVar.j(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(c2.i()));
                    kVar.j(ResultMetadataType.STRUCTURED_APPEND_PARITY, Integer.valueOf(c2.h()));
                }
                arrayList.add(kVar);
            } catch (ReaderException unused) {
            }
        }
        if (arrayList.isEmpty()) {
            return f3257c;
        }
        List<k> h2 = h(arrayList);
        return (k[]) h2.toArray(new k[h2.size()]);
    }
}

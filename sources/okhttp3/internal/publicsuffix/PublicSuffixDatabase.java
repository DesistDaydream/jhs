package okhttp3.internal.publicsuffix;

import h.a2.t;
import h.h2.b;
import h.k2.v.f0;
import h.k2.v.u;
import h.t1;
import j.o;
import j.z;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u001c\u0010\fJ\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0012\u001a\u00020\u00108\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0012\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0011\u0010\u0018¨\u0006\u001e"}, d2 = {"Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;", "", "", "domain", "", "splitDomain", "(Ljava/lang/String;)Ljava/util/List;", "domainLabels", "findMatchingRule", "(Ljava/util/List;)Ljava/util/List;", "Lh/t1;", "readTheListUninterruptibly", "()V", "readTheList", "getEffectiveTldPlusOne", "(Ljava/lang/String;)Ljava/lang/String;", "", "publicSuffixListBytes", "publicSuffixExceptionListBytes", "setListBytes", "([B[B)V", "Ljava/util/concurrent/atomic/AtomicBoolean;", "listRead", "Ljava/util/concurrent/atomic/AtomicBoolean;", "[B", "Ljava/util/concurrent/CountDownLatch;", "readCompleteLatch", "Ljava/util/concurrent/CountDownLatch;", "<init>", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class PublicSuffixDatabase {
    private static final char EXCEPTION_MARKER = '!';
    @d
    public static final String PUBLIC_SUFFIX_RESOURCE = "publicsuffixes.gz";
    private byte[] publicSuffixExceptionListBytes;
    private byte[] publicSuffixListBytes;
    public static final Companion Companion = new Companion(null);
    private static final byte[] WILDCARD_LABEL = {(byte) 42};
    private static final List<String> PREVAILING_RULE = t.k("*");
    private static final PublicSuffixDatabase instance = new PublicSuffixDatabase();
    private final AtomicBoolean listRead = new AtomicBoolean(false);
    private final CountDownLatch readCompleteLatch = new CountDownLatch(1);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ+\u0010\b\u001a\u0004\u0018\u00010\u0007*\u00020\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u00078\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lokhttp3/internal/publicsuffix/PublicSuffixDatabase$Companion;", "", "", "", "labels", "", "labelIndex", "", "binarySearch", "([B[[BI)Ljava/lang/String;", "Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;", "get", "()Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;", "", "EXCEPTION_MARKER", "C", "", "PREVAILING_RULE", "Ljava/util/List;", "PUBLIC_SUFFIX_RESOURCE", "Ljava/lang/String;", "WILDCARD_LABEL", "[B", "instance", "Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public final String binarySearch(byte[] bArr, byte[][] bArr2, int i2) {
            int i3;
            boolean z;
            int and;
            int and2;
            int length = bArr.length;
            int i4 = 0;
            while (i4 < length) {
                int i5 = (i4 + length) / 2;
                while (i5 > -1 && bArr[i5] != ((byte) 10)) {
                    i5--;
                }
                int i6 = i5 + 1;
                int i7 = 1;
                while (true) {
                    i3 = i6 + i7;
                    if (bArr[i3] == ((byte) 10)) {
                        break;
                    }
                    i7++;
                }
                int i8 = i3 - i6;
                int i9 = i2;
                boolean z2 = false;
                int i10 = 0;
                int i11 = 0;
                while (true) {
                    if (z2) {
                        and = 46;
                        z = false;
                    } else {
                        z = z2;
                        and = Util.and(bArr2[i9][i10], 255);
                    }
                    and2 = and - Util.and(bArr[i6 + i11], 255);
                    if (and2 != 0) {
                        break;
                    }
                    i11++;
                    i10++;
                    if (i11 == i8) {
                        break;
                    } else if (bArr2[i9].length != i10) {
                        z2 = z;
                    } else if (i9 == bArr2.length - 1) {
                        break;
                    } else {
                        i9++;
                        z2 = true;
                        i10 = -1;
                    }
                }
                if (and2 >= 0) {
                    if (and2 <= 0) {
                        int i12 = i8 - i11;
                        int length2 = bArr2[i9].length - i10;
                        int length3 = bArr2.length;
                        for (int i13 = i9 + 1; i13 < length3; i13++) {
                            length2 += bArr2[i13].length;
                        }
                        if (length2 >= i12) {
                            if (length2 <= i12) {
                                return new String(bArr, i6, i8, StandardCharsets.UTF_8);
                            }
                        }
                    }
                    i4 = i3 + 1;
                }
                length = i6 - 1;
            }
            return null;
        }

        @d
        public final PublicSuffixDatabase get() {
            return PublicSuffixDatabase.instance;
        }

        public /* synthetic */ Companion(u uVar) {
            this();
        }
    }

    private final List<String> findMatchingRule(List<String> list) {
        String str;
        String str2;
        String str3;
        List<String> E;
        List<String> E2;
        if (!this.listRead.get() && this.listRead.compareAndSet(false, true)) {
            readTheListUninterruptibly();
        } else {
            try {
                this.readCompleteLatch.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
        if (this.publicSuffixListBytes != null) {
            int size = list.size();
            byte[][] bArr = new byte[size];
            for (int i2 = 0; i2 < size; i2++) {
                String str4 = list.get(i2);
                Charset charset = StandardCharsets.UTF_8;
                Objects.requireNonNull(str4, "null cannot be cast to non-null type java.lang.String");
                bArr[i2] = str4.getBytes(charset);
            }
            int i3 = 0;
            while (true) {
                str = null;
                if (i3 >= size) {
                    str2 = null;
                    break;
                }
                str2 = Companion.binarySearch(this.publicSuffixListBytes, bArr, i3);
                if (str2 != null) {
                    break;
                }
                i3++;
            }
            if (size > 1) {
                byte[][] bArr2 = (byte[][]) bArr.clone();
                int length = bArr2.length - 1;
                for (int i4 = 0; i4 < length; i4++) {
                    bArr2[i4] = WILDCARD_LABEL;
                    String binarySearch = Companion.binarySearch(this.publicSuffixListBytes, bArr2, i4);
                    if (binarySearch != null) {
                        str3 = binarySearch;
                        break;
                    }
                }
            }
            str3 = null;
            if (str3 != null) {
                int i5 = size - 1;
                int i6 = 0;
                while (true) {
                    if (i6 >= i5) {
                        break;
                    }
                    String binarySearch2 = Companion.binarySearch(this.publicSuffixExceptionListBytes, bArr, i6);
                    if (binarySearch2 != null) {
                        str = binarySearch2;
                        break;
                    }
                    i6++;
                }
            }
            if (str != null) {
                return StringsKt__StringsKt.R4(EXCEPTION_MARKER + str, new char[]{'.'}, false, 0, 6, null);
            } else if (str2 == null && str3 == null) {
                return PREVAILING_RULE;
            } else {
                if (str2 == null || (E = StringsKt__StringsKt.R4(str2, new char[]{'.'}, false, 0, 6, null)) == null) {
                    E = CollectionsKt__CollectionsKt.E();
                }
                if (str3 == null || (E2 = StringsKt__StringsKt.R4(str3, new char[]{'.'}, false, 0, 6, null)) == null) {
                    E2 = CollectionsKt__CollectionsKt.E();
                }
                return E.size() > E2.size() ? E : E2;
            }
        }
        throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.".toString());
    }

    private final void readTheList() throws IOException {
        InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream(PUBLIC_SUFFIX_RESOURCE);
        if (resourceAsStream == null) {
            return;
        }
        o d2 = z.d(new j.u(z.m(resourceAsStream)));
        try {
            byte[] L = d2.L(d2.readInt());
            byte[] L2 = d2.L(d2.readInt());
            t1 t1Var = t1.a;
            b.a(d2, null);
            synchronized (this) {
                this.publicSuffixListBytes = L;
                this.publicSuffixExceptionListBytes = L2;
            }
            this.readCompleteLatch.countDown();
        } finally {
        }
    }

    private final void readTheListUninterruptibly() {
        boolean z = false;
        while (true) {
            try {
                try {
                    readTheList();
                    break;
                } catch (InterruptedIOException unused) {
                    Thread.interrupted();
                    z = true;
                } catch (IOException e2) {
                    Platform.Companion.get().log("Failed to read public suffix list", 5, e2);
                    if (z) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    return;
                }
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    private final List<String> splitDomain(String str) {
        List<String> R4 = StringsKt__StringsKt.R4(str, new char[]{'.'}, false, 0, 6, null);
        return f0.g((String) CollectionsKt___CollectionsKt.c3(R4), "") ? CollectionsKt___CollectionsKt.Q1(R4, 1) : R4;
    }

    @e
    public final String getEffectiveTldPlusOne(@d String str) {
        int size;
        int size2;
        List<String> splitDomain = splitDomain(IDN.toUnicode(str));
        List<String> findMatchingRule = findMatchingRule(splitDomain);
        if (splitDomain.size() != findMatchingRule.size() || findMatchingRule.get(0).charAt(0) == '!') {
            if (findMatchingRule.get(0).charAt(0) == '!') {
                size = splitDomain.size();
                size2 = findMatchingRule.size();
            } else {
                size = splitDomain.size();
                size2 = findMatchingRule.size() + 1;
            }
            return SequencesKt___SequencesKt.X0(SequencesKt___SequencesKt.d0(CollectionsKt___CollectionsKt.n1(splitDomain(str)), size - size2), ".", null, null, 0, null, null, 62, null);
        }
        return null;
    }

    public final void setListBytes(@d byte[] bArr, @d byte[] bArr2) {
        this.publicSuffixListBytes = bArr;
        this.publicSuffixExceptionListBytes = bArr2;
        this.listRead.set(true);
        this.readCompleteLatch.countDown();
    }
}

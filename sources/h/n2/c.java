package h.n2;

import h.g2.f;
import h.g2.l;
import h.s0;
import java.util.Random;
import kotlin.Metadata;
import kotlin.random.KotlinRandom;
import kotlin.random.PlatformRandom;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\t\u0010\u0000\u001a\u00020\u0001H\u0081\b\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0000\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\u0001H\u0007\u001a\f\u0010\t\u001a\u00020\u0001*\u00020\bH\u0007¨\u0006\n"}, d2 = {"defaultPlatformRandom", "Lkotlin/random/Random;", "doubleFromParts", "", "hi26", "", "low27", "asJavaRandom", "Ljava/util/Random;", "asKotlinRandom", "kotlin-stdlib"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class c {
    @s0(version = "1.3")
    @k.e.a.d
    public static final Random a(@k.e.a.d kotlin.random.Random random) {
        Random impl;
        a aVar = (a) (!(random instanceof a) ? null : random);
        return (aVar == null || (impl = aVar.getImpl()) == null) ? new KotlinRandom(random) : impl;
    }

    @s0(version = "1.3")
    @k.e.a.d
    public static final kotlin.random.Random b(@k.e.a.d Random random) {
        kotlin.random.Random impl;
        KotlinRandom kotlinRandom = (KotlinRandom) (!(random instanceof KotlinRandom) ? null : random);
        return (kotlinRandom == null || (impl = kotlinRandom.getImpl()) == null) ? new PlatformRandom(random) : impl;
    }

    @f
    private static final kotlin.random.Random c() {
        return l.a.b();
    }

    public static final double d(int i2, int i3) {
        return ((i2 << 27) + i3) / 9007199254740992L;
    }
}

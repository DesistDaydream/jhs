package h.o2;

import androidx.exifinterface.media.ExifInterface;
import h.k2.v.f0;
import h.o2.a;
import h.o2.i;
import h.o2.l;
import h.s0;
import h.x1;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.random.Random;

@Metadata(d1 = {"\u0000n\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\n\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\u001a'\u0010\u0000\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002*\u0002H\u00012\u0006\u0010\u0003\u001a\u0002H\u0001¢\u0006\u0002\u0010\u0004\u001a\u0012\u0010\u0000\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0005\u001a\u0012\u0010\u0000\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0006\u001a\u0012\u0010\u0000\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0007\u001a\u0012\u0010\u0000\u001a\u00020\b*\u00020\b2\u0006\u0010\u0003\u001a\u00020\b\u001a\u0012\u0010\u0000\u001a\u00020\t*\u00020\t2\u0006\u0010\u0003\u001a\u00020\t\u001a\u0012\u0010\u0000\u001a\u00020\n*\u00020\n2\u0006\u0010\u0003\u001a\u00020\n\u001a'\u0010\u000b\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002*\u0002H\u00012\u0006\u0010\f\u001a\u0002H\u0001¢\u0006\u0002\u0010\u0004\u001a\u0012\u0010\u000b\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005\u001a\u0012\u0010\u000b\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006\u001a\u0012\u0010\u000b\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007\u001a\u0012\u0010\u000b\u001a\u00020\b*\u00020\b2\u0006\u0010\f\u001a\u00020\b\u001a\u0012\u0010\u000b\u001a\u00020\t*\u00020\t2\u0006\u0010\f\u001a\u00020\t\u001a\u0012\u0010\u000b\u001a\u00020\n*\u00020\n2\u0006\u0010\f\u001a\u00020\n\u001a3\u0010\r\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002*\u0002H\u00012\b\u0010\u0003\u001a\u0004\u0018\u0001H\u00012\b\u0010\f\u001a\u0004\u0018\u0001H\u0001¢\u0006\u0002\u0010\u000e\u001a/\u0010\r\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002*\u0002H\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0010H\u0007¢\u0006\u0002\u0010\u0011\u001a-\u0010\r\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002*\u0002H\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0012¢\u0006\u0002\u0010\u0013\u001a\u001a\u0010\r\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005\u001a\u001a\u0010\r\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006\u001a\u001a\u0010\r\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007\u001a\u001a\u0010\r\u001a\u00020\b*\u00020\b2\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b\u001a\u0018\u0010\r\u001a\u00020\b*\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u0012\u001a\u001a\u0010\r\u001a\u00020\t*\u00020\t2\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t\u001a\u0018\u0010\r\u001a\u00020\t*\u00020\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u0012\u001a\u001a\u0010\r\u001a\u00020\n*\u00020\n2\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n\u001a\u001c\u0010\u0014\u001a\u00020\u0015*\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0087\n¢\u0006\u0002\u0010\u0019\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050\u00122\u0006\u0010\u001a\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050\u00122\u0006\u0010\u001a\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0002\b\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050\u00122\u0006\u0010\u001a\u001a\u00020\bH\u0087\u0002¢\u0006\u0002\b\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050\u00122\u0006\u0010\u001a\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\b\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050\u00122\u0006\u0010\u001a\u001a\u00020\nH\u0087\u0002¢\u0006\u0002\b\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\u0002¢\u0006\u0002\b\u001c\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u001a\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0002\b\u001c\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u001a\u001a\u00020\bH\u0087\u0002¢\u0006\u0002\b\u001c\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u001a\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\b\u001c\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u001a\u001a\u00020\nH\u0087\u0002¢\u0006\u0002\b\u001c\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\u0002¢\u0006\u0002\b\u001d\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u001a\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\u001d\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u001a\u001a\u00020\bH\u0087\u0002¢\u0006\u0002\b\u001d\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u001a\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\b\u001d\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u001a\u001a\u00020\nH\u0087\u0002¢\u0006\u0002\b\u001d\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\u0002¢\u0006\u0002\b\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\u001a\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\u001a\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0002\b\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\u001a\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\b\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\u001a\u001a\u00020\nH\u0087\u0002¢\u0006\u0002\b\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\u0002¢\u0006\u0002\b\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u001a\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u001a\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0002\b\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u001a\u001a\u00020\bH\u0087\u0002¢\u0006\u0002\b\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u001a\u001a\u00020\nH\u0087\u0002¢\u0006\u0002\b\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\u0002¢\u0006\u0002\b \u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u001a\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b \u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u001a\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0002\b \u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u001a\u001a\u00020\bH\u0087\u0002¢\u0006\u0002\b \u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u001a\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\b \u001a\u001c\u0010\u0014\u001a\u00020\u0015*\u00020!2\b\u0010\u0017\u001a\u0004\u0018\u00010\bH\u0087\n¢\u0006\u0002\u0010\"\u001a\u001c\u0010\u0014\u001a\u00020\u0015*\u00020#2\b\u0010\u0017\u001a\u0004\u0018\u00010\tH\u0087\n¢\u0006\u0002\u0010$\u001a\u0015\u0010%\u001a\u00020&*\u00020\u00052\u0006\u0010'\u001a\u00020\u0005H\u0086\u0004\u001a\u0015\u0010%\u001a\u00020&*\u00020\u00052\u0006\u0010'\u001a\u00020\bH\u0086\u0004\u001a\u0015\u0010%\u001a\u00020(*\u00020\u00052\u0006\u0010'\u001a\u00020\tH\u0086\u0004\u001a\u0015\u0010%\u001a\u00020&*\u00020\u00052\u0006\u0010'\u001a\u00020\nH\u0086\u0004\u001a\u0015\u0010%\u001a\u00020)*\u00020\u00182\u0006\u0010'\u001a\u00020\u0018H\u0086\u0004\u001a\u0015\u0010%\u001a\u00020&*\u00020\b2\u0006\u0010'\u001a\u00020\u0005H\u0086\u0004\u001a\u0015\u0010%\u001a\u00020&*\u00020\b2\u0006\u0010'\u001a\u00020\bH\u0086\u0004\u001a\u0015\u0010%\u001a\u00020(*\u00020\b2\u0006\u0010'\u001a\u00020\tH\u0086\u0004\u001a\u0015\u0010%\u001a\u00020&*\u00020\b2\u0006\u0010'\u001a\u00020\nH\u0086\u0004\u001a\u0015\u0010%\u001a\u00020(*\u00020\t2\u0006\u0010'\u001a\u00020\u0005H\u0086\u0004\u001a\u0015\u0010%\u001a\u00020(*\u00020\t2\u0006\u0010'\u001a\u00020\bH\u0086\u0004\u001a\u0015\u0010%\u001a\u00020(*\u00020\t2\u0006\u0010'\u001a\u00020\tH\u0086\u0004\u001a\u0015\u0010%\u001a\u00020(*\u00020\t2\u0006\u0010'\u001a\u00020\nH\u0086\u0004\u001a\u0015\u0010%\u001a\u00020&*\u00020\n2\u0006\u0010'\u001a\u00020\u0005H\u0086\u0004\u001a\u0015\u0010%\u001a\u00020&*\u00020\n2\u0006\u0010'\u001a\u00020\bH\u0086\u0004\u001a\u0015\u0010%\u001a\u00020(*\u00020\n2\u0006\u0010'\u001a\u00020\tH\u0086\u0004\u001a\u0015\u0010%\u001a\u00020&*\u00020\n2\u0006\u0010'\u001a\u00020\nH\u0086\u0004\u001a\r\u0010*\u001a\u00020\u0018*\u00020\u0016H\u0087\b\u001a\u0014\u0010*\u001a\u00020\u0018*\u00020\u00162\u0006\u0010*\u001a\u00020+H\u0007\u001a\r\u0010*\u001a\u00020\b*\u00020!H\u0087\b\u001a\u0014\u0010*\u001a\u00020\b*\u00020!2\u0006\u0010*\u001a\u00020+H\u0007\u001a\r\u0010*\u001a\u00020\t*\u00020#H\u0087\b\u001a\u0014\u0010*\u001a\u00020\t*\u00020#2\u0006\u0010*\u001a\u00020+H\u0007\u001a\u0014\u0010,\u001a\u0004\u0018\u00010\u0018*\u00020\u0016H\u0087\b¢\u0006\u0002\u0010-\u001a\u001b\u0010,\u001a\u0004\u0018\u00010\u0018*\u00020\u00162\u0006\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u0010.\u001a\u0014\u0010,\u001a\u0004\u0018\u00010\b*\u00020!H\u0087\b¢\u0006\u0002\u0010/\u001a\u001b\u0010,\u001a\u0004\u0018\u00010\b*\u00020!2\u0006\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u00100\u001a\u0014\u0010,\u001a\u0004\u0018\u00010\t*\u00020#H\u0087\b¢\u0006\u0002\u00101\u001a\u001b\u0010,\u001a\u0004\u0018\u00010\t*\u00020#2\u0006\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u00102\u001a\n\u00103\u001a\u00020)*\u00020)\u001a\n\u00103\u001a\u00020&*\u00020&\u001a\n\u00103\u001a\u00020(*\u00020(\u001a\u0015\u00104\u001a\u00020)*\u00020)2\u0006\u00104\u001a\u00020\bH\u0086\u0004\u001a\u0015\u00104\u001a\u00020&*\u00020&2\u0006\u00104\u001a\u00020\bH\u0086\u0004\u001a\u0015\u00104\u001a\u00020(*\u00020(2\u0006\u00104\u001a\u00020\tH\u0086\u0004\u001a\u0013\u00105\u001a\u0004\u0018\u00010\u0005*\u00020\u0006H\u0000¢\u0006\u0002\u00106\u001a\u0013\u00105\u001a\u0004\u0018\u00010\u0005*\u00020\u0007H\u0000¢\u0006\u0002\u00107\u001a\u0013\u00105\u001a\u0004\u0018\u00010\u0005*\u00020\bH\u0000¢\u0006\u0002\u00108\u001a\u0013\u00105\u001a\u0004\u0018\u00010\u0005*\u00020\tH\u0000¢\u0006\u0002\u00109\u001a\u0013\u00105\u001a\u0004\u0018\u00010\u0005*\u00020\nH\u0000¢\u0006\u0002\u0010:\u001a\u0013\u0010;\u001a\u0004\u0018\u00010\b*\u00020\u0006H\u0000¢\u0006\u0002\u0010<\u001a\u0013\u0010;\u001a\u0004\u0018\u00010\b*\u00020\u0007H\u0000¢\u0006\u0002\u0010=\u001a\u0013\u0010;\u001a\u0004\u0018\u00010\b*\u00020\tH\u0000¢\u0006\u0002\u0010>\u001a\u0013\u0010?\u001a\u0004\u0018\u00010\t*\u00020\u0006H\u0000¢\u0006\u0002\u0010@\u001a\u0013\u0010?\u001a\u0004\u0018\u00010\t*\u00020\u0007H\u0000¢\u0006\u0002\u0010A\u001a\u0013\u0010B\u001a\u0004\u0018\u00010\n*\u00020\u0006H\u0000¢\u0006\u0002\u0010C\u001a\u0013\u0010B\u001a\u0004\u0018\u00010\n*\u00020\u0007H\u0000¢\u0006\u0002\u0010D\u001a\u0013\u0010B\u001a\u0004\u0018\u00010\n*\u00020\bH\u0000¢\u0006\u0002\u0010E\u001a\u0013\u0010B\u001a\u0004\u0018\u00010\n*\u00020\tH\u0000¢\u0006\u0002\u0010F\u001a\u0015\u0010G\u001a\u00020!*\u00020\u00052\u0006\u0010'\u001a\u00020\u0005H\u0086\u0004\u001a\u0015\u0010G\u001a\u00020!*\u00020\u00052\u0006\u0010'\u001a\u00020\bH\u0086\u0004\u001a\u0015\u0010G\u001a\u00020#*\u00020\u00052\u0006\u0010'\u001a\u00020\tH\u0086\u0004\u001a\u0015\u0010G\u001a\u00020!*\u00020\u00052\u0006\u0010'\u001a\u00020\nH\u0086\u0004\u001a\u0015\u0010G\u001a\u00020\u0016*\u00020\u00182\u0006\u0010'\u001a\u00020\u0018H\u0086\u0004\u001a\u0015\u0010G\u001a\u00020!*\u00020\b2\u0006\u0010'\u001a\u00020\u0005H\u0086\u0004\u001a\u0015\u0010G\u001a\u00020!*\u00020\b2\u0006\u0010'\u001a\u00020\bH\u0086\u0004\u001a\u0015\u0010G\u001a\u00020#*\u00020\b2\u0006\u0010'\u001a\u00020\tH\u0086\u0004\u001a\u0015\u0010G\u001a\u00020!*\u00020\b2\u0006\u0010'\u001a\u00020\nH\u0086\u0004\u001a\u0015\u0010G\u001a\u00020#*\u00020\t2\u0006\u0010'\u001a\u00020\u0005H\u0086\u0004\u001a\u0015\u0010G\u001a\u00020#*\u00020\t2\u0006\u0010'\u001a\u00020\bH\u0086\u0004\u001a\u0015\u0010G\u001a\u00020#*\u00020\t2\u0006\u0010'\u001a\u00020\tH\u0086\u0004\u001a\u0015\u0010G\u001a\u00020#*\u00020\t2\u0006\u0010'\u001a\u00020\nH\u0086\u0004\u001a\u0015\u0010G\u001a\u00020!*\u00020\n2\u0006\u0010'\u001a\u00020\u0005H\u0086\u0004\u001a\u0015\u0010G\u001a\u00020!*\u00020\n2\u0006\u0010'\u001a\u00020\bH\u0086\u0004\u001a\u0015\u0010G\u001a\u00020#*\u00020\n2\u0006\u0010'\u001a\u00020\tH\u0086\u0004\u001a\u0015\u0010G\u001a\u00020!*\u00020\n2\u0006\u0010'\u001a\u00020\nH\u0086\u0004¨\u0006H"}, d2 = {"coerceAtLeast", ExifInterface.GPS_DIRECTION_TRUE, "", "minimumValue", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "", "", "", "", "", "", "coerceAtMost", "maximumValue", "coerceIn", "(Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "range", "Lkotlin/ranges/ClosedFloatingPointRange;", "(Ljava/lang/Comparable;Lkotlin/ranges/ClosedFloatingPointRange;)Ljava/lang/Comparable;", "Lkotlin/ranges/ClosedRange;", "(Ljava/lang/Comparable;Lkotlin/ranges/ClosedRange;)Ljava/lang/Comparable;", "contains", "", "Lkotlin/ranges/CharRange;", "element", "", "(Lkotlin/ranges/CharRange;Ljava/lang/Character;)Z", "value", "byteRangeContains", "doubleRangeContains", "floatRangeContains", "intRangeContains", "longRangeContains", "shortRangeContains", "Lkotlin/ranges/IntRange;", "(Lkotlin/ranges/IntRange;Ljava/lang/Integer;)Z", "Lkotlin/ranges/LongRange;", "(Lkotlin/ranges/LongRange;Ljava/lang/Long;)Z", "downTo", "Lkotlin/ranges/IntProgression;", "to", "Lkotlin/ranges/LongProgression;", "Lkotlin/ranges/CharProgression;", "random", "Lkotlin/random/Random;", "randomOrNull", "(Lkotlin/ranges/CharRange;)Ljava/lang/Character;", "(Lkotlin/ranges/CharRange;Lkotlin/random/Random;)Ljava/lang/Character;", "(Lkotlin/ranges/IntRange;)Ljava/lang/Integer;", "(Lkotlin/ranges/IntRange;Lkotlin/random/Random;)Ljava/lang/Integer;", "(Lkotlin/ranges/LongRange;)Ljava/lang/Long;", "(Lkotlin/ranges/LongRange;Lkotlin/random/Random;)Ljava/lang/Long;", "reversed", "step", "toByteExactOrNull", "(D)Ljava/lang/Byte;", "(F)Ljava/lang/Byte;", "(I)Ljava/lang/Byte;", "(J)Ljava/lang/Byte;", "(S)Ljava/lang/Byte;", "toIntExactOrNull", "(D)Ljava/lang/Integer;", "(F)Ljava/lang/Integer;", "(J)Ljava/lang/Integer;", "toLongExactOrNull", "(D)Ljava/lang/Long;", "(F)Ljava/lang/Long;", "toShortExactOrNull", "(D)Ljava/lang/Short;", "(F)Ljava/lang/Short;", "(I)Ljava/lang/Short;", "(J)Ljava/lang/Short;", "until", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/ranges/RangesKt")
/* loaded from: classes3.dex */
public class q extends p {
    public static final float A(float f2, float f3, float f4) {
        if (f3 <= f4) {
            return f2 < f3 ? f3 : f2 > f4 ? f4 : f2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + f4 + " is less than minimum " + f3 + '.');
    }

    @s0(version = "1.3")
    public static final int A0(@k.e.a.d k kVar, @k.e.a.d Random random) {
        try {
            return h.n2.d.h(random, kVar);
        } catch (IllegalArgumentException e2) {
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    public static final int B(int i2, int i3, int i4) {
        if (i3 <= i4) {
            return i2 < i3 ? i3 : i2 > i4 ? i4 : i2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i4 + " is less than minimum " + i3 + '.');
    }

    @h.g2.f
    @s0(version = "1.3")
    private static final long B0(n nVar) {
        return C0(nVar, Random.Default);
    }

    public static final int C(int i2, @k.e.a.d g<Integer> gVar) {
        if (gVar instanceof f) {
            return ((Number) G(Integer.valueOf(i2), (f) gVar)).intValue();
        }
        if (!gVar.isEmpty()) {
            return i2 < gVar.getStart().intValue() ? gVar.getStart().intValue() : i2 > gVar.getEndInclusive().intValue() ? gVar.getEndInclusive().intValue() : i2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + gVar + '.');
    }

    @s0(version = "1.3")
    public static final long C0(@k.e.a.d n nVar, @k.e.a.d Random random) {
        try {
            return h.n2.d.i(random, nVar);
        } catch (IllegalArgumentException e2) {
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    public static final long D(long j2, long j3, long j4) {
        if (j3 <= j4) {
            return j2 < j3 ? j3 : j2 > j4 ? j4 : j2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + j4 + " is less than minimum " + j3 + '.');
    }

    @h.g2.f
    @x1(markerClass = {h.o.class})
    @s0(version = "1.4")
    private static final Character D0(c cVar) {
        return E0(cVar, Random.Default);
    }

    public static final long E(long j2, @k.e.a.d g<Long> gVar) {
        if (gVar instanceof f) {
            return ((Number) G(Long.valueOf(j2), (f) gVar)).longValue();
        }
        if (!gVar.isEmpty()) {
            return j2 < gVar.getStart().longValue() ? gVar.getStart().longValue() : j2 > gVar.getEndInclusive().longValue() ? gVar.getEndInclusive().longValue() : j2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + gVar + '.');
    }

    @x1(markerClass = {h.o.class})
    @k.e.a.e
    @s0(version = "1.4")
    public static final Character E0(@k.e.a.d c cVar, @k.e.a.d Random random) {
        if (cVar.isEmpty()) {
            return null;
        }
        return Character.valueOf((char) random.nextInt(cVar.d(), cVar.f() + 1));
    }

    @k.e.a.d
    public static final <T extends Comparable<? super T>> T F(@k.e.a.d T t, @k.e.a.e T t2, @k.e.a.e T t3) {
        if (t2 != null && t3 != null) {
            if (t2.compareTo(t3) <= 0) {
                if (t.compareTo(t2) < 0) {
                    return t2;
                }
                if (t.compareTo(t3) > 0) {
                    return t3;
                }
            } else {
                throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + t3 + " is less than minimum " + t2 + '.');
            }
        } else if (t2 != null && t.compareTo(t2) < 0) {
            return t2;
        } else {
            if (t3 != null && t.compareTo(t3) > 0) {
                return t3;
            }
        }
        return t;
    }

    @h.g2.f
    @x1(markerClass = {h.o.class})
    @s0(version = "1.4")
    private static final Integer F0(k kVar) {
        return G0(kVar, Random.Default);
    }

    @s0(version = "1.1")
    @k.e.a.d
    public static final <T extends Comparable<? super T>> T G(@k.e.a.d T t, @k.e.a.d f<T> fVar) {
        if (!fVar.isEmpty()) {
            return (!fVar.a(t, fVar.getStart()) || fVar.a(fVar.getStart(), t)) ? (!fVar.a(fVar.getEndInclusive(), t) || fVar.a(t, fVar.getEndInclusive())) ? t : fVar.getEndInclusive() : fVar.getStart();
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + fVar + '.');
    }

    @x1(markerClass = {h.o.class})
    @k.e.a.e
    @s0(version = "1.4")
    public static final Integer G0(@k.e.a.d k kVar, @k.e.a.d Random random) {
        if (kVar.isEmpty()) {
            return null;
        }
        return Integer.valueOf(h.n2.d.h(random, kVar));
    }

    @k.e.a.d
    public static final <T extends Comparable<? super T>> T H(@k.e.a.d T t, @k.e.a.d g<T> gVar) {
        if (gVar instanceof f) {
            return (T) G(t, (f) gVar);
        }
        if (!gVar.isEmpty()) {
            return t.compareTo(gVar.getStart()) < 0 ? gVar.getStart() : t.compareTo(gVar.getEndInclusive()) > 0 ? gVar.getEndInclusive() : t;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + gVar + '.');
    }

    @h.g2.f
    @x1(markerClass = {h.o.class})
    @s0(version = "1.4")
    private static final Long H0(n nVar) {
        return I0(nVar, Random.Default);
    }

    public static final short I(short s, short s2, short s3) {
        if (s2 <= s3) {
            return s < s2 ? s2 : s > s3 ? s3 : s;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((int) s3) + " is less than minimum " + ((int) s2) + '.');
    }

    @x1(markerClass = {h.o.class})
    @k.e.a.e
    @s0(version = "1.4")
    public static final Long I0(@k.e.a.d n nVar, @k.e.a.d Random random) {
        if (nVar.isEmpty()) {
            return null;
        }
        return Long.valueOf(h.n2.d.i(random, nVar));
    }

    @h.g2.f
    @s0(version = "1.3")
    private static final boolean J(c cVar, Character ch) {
        return ch != null && cVar.m(ch.charValue());
    }

    @k.e.a.d
    public static final a J0(@k.e.a.d a aVar) {
        return a.f14959d.a(aVar.f(), aVar.d(), -aVar.g());
    }

    @h.g2.f
    @s0(version = "1.3")
    private static final boolean K(k kVar, Integer num) {
        return num != null && kVar.m(num.intValue());
    }

    @k.e.a.d
    public static final i K0(@k.e.a.d i iVar) {
        return i.f14965d.a(iVar.f(), iVar.d(), -iVar.g());
    }

    @h.g2.f
    @s0(version = "1.3")
    private static final boolean L(n nVar, Long l2) {
        return l2 != null && nVar.m(l2.longValue());
    }

    @k.e.a.d
    public static final l L0(@k.e.a.d l lVar) {
        return l.f14971d.a(lVar.f(), lVar.d(), -lVar.g());
    }

    @h.k2.g(name = "shortRangeContains")
    public static final boolean M0(@k.e.a.d g<Short> gVar, byte b) {
        return gVar.contains(Short.valueOf(b));
    }

    @h.k2.g(name = "doubleRangeContains")
    public static final boolean N(@k.e.a.d g<Double> gVar, float f2) {
        return gVar.contains(Double.valueOf(f2));
    }

    @h.k2.g(name = "shortRangeContains")
    @h.j(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @h.i(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    public static final /* synthetic */ boolean N0(g<Short> gVar, double d2) {
        Short e1 = e1(d2);
        if (e1 != null) {
            return gVar.contains(e1);
        }
        return false;
    }

    @h.k2.g(name = "shortRangeContains")
    @h.j(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @h.i(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    public static final /* synthetic */ boolean O0(g<Short> gVar, float f2) {
        Short f1 = f1(f2);
        if (f1 != null) {
            return gVar.contains(f1);
        }
        return false;
    }

    @h.k2.g(name = "shortRangeContains")
    public static final boolean P0(@k.e.a.d g<Short> gVar, int i2) {
        Short g1 = g1(i2);
        if (g1 != null) {
            return gVar.contains(g1);
        }
        return false;
    }

    @h.k2.g(name = "shortRangeContains")
    public static final boolean Q0(@k.e.a.d g<Short> gVar, long j2) {
        Short h1 = h1(j2);
        if (h1 != null) {
            return gVar.contains(h1);
        }
        return false;
    }

    @k.e.a.d
    public static final a R(char c2, char c3) {
        return a.f14959d.a(c2, c3, -1);
    }

    @k.e.a.d
    public static final a R0(@k.e.a.d a aVar, int i2) {
        p.a(i2 > 0, Integer.valueOf(i2));
        a.C0426a c0426a = a.f14959d;
        char d2 = aVar.d();
        char f2 = aVar.f();
        if (aVar.g() <= 0) {
            i2 = -i2;
        }
        return c0426a.a(d2, f2, i2);
    }

    @k.e.a.d
    public static final i S(byte b, byte b2) {
        return i.f14965d.a(b, b2, -1);
    }

    @k.e.a.d
    public static final i S0(@k.e.a.d i iVar, int i2) {
        p.a(i2 > 0, Integer.valueOf(i2));
        i.a aVar = i.f14965d;
        int d2 = iVar.d();
        int f2 = iVar.f();
        if (iVar.g() <= 0) {
            i2 = -i2;
        }
        return aVar.a(d2, f2, i2);
    }

    @k.e.a.d
    public static final i T(byte b, int i2) {
        return i.f14965d.a(b, i2, -1);
    }

    @k.e.a.d
    public static final l T0(@k.e.a.d l lVar, long j2) {
        p.a(j2 > 0, Long.valueOf(j2));
        l.a aVar = l.f14971d;
        long d2 = lVar.d();
        long f2 = lVar.f();
        if (lVar.g() <= 0) {
            j2 = -j2;
        }
        return aVar.a(d2, f2, j2);
    }

    @k.e.a.d
    public static final i U(byte b, short s) {
        return i.f14965d.a(b, s, -1);
    }

    @k.e.a.e
    public static final Byte U0(double d2) {
        double d3 = 127;
        if (d2 < -128 || d2 > d3) {
            return null;
        }
        return Byte.valueOf((byte) d2);
    }

    @k.e.a.d
    public static final i V(int i2, byte b) {
        return i.f14965d.a(i2, b, -1);
    }

    @k.e.a.e
    public static final Byte V0(float f2) {
        float f3 = 127;
        if (f2 < -128 || f2 > f3) {
            return null;
        }
        return Byte.valueOf((byte) f2);
    }

    @k.e.a.d
    public static final i W(int i2, int i3) {
        return i.f14965d.a(i2, i3, -1);
    }

    @k.e.a.e
    public static final Byte W0(int i2) {
        if (-128 <= i2 && 127 >= i2) {
            return Byte.valueOf((byte) i2);
        }
        return null;
    }

    @k.e.a.d
    public static final i X(int i2, short s) {
        return i.f14965d.a(i2, s, -1);
    }

    @k.e.a.e
    public static final Byte X0(long j2) {
        long j3 = 127;
        if (-128 <= j2 && j3 >= j2) {
            return Byte.valueOf((byte) j2);
        }
        return null;
    }

    @k.e.a.d
    public static final i Y(short s, byte b) {
        return i.f14965d.a(s, b, -1);
    }

    @k.e.a.e
    public static final Byte Y0(short s) {
        short s2 = (short) 127;
        if (((short) (-128)) <= s && s2 >= s) {
            return Byte.valueOf((byte) s);
        }
        return null;
    }

    @k.e.a.d
    public static final i Z(short s, int i2) {
        return i.f14965d.a(s, i2, -1);
    }

    @k.e.a.e
    public static final Integer Z0(double d2) {
        double d3 = Integer.MAX_VALUE;
        if (d2 < Integer.MIN_VALUE || d2 > d3) {
            return null;
        }
        return Integer.valueOf((int) d2);
    }

    @k.e.a.d
    public static final i a0(short s, short s2) {
        return i.f14965d.a(s, s2, -1);
    }

    @k.e.a.e
    public static final Integer a1(float f2) {
        float f3 = Integer.MAX_VALUE;
        if (f2 < Integer.MIN_VALUE || f2 > f3) {
            return null;
        }
        return Integer.valueOf((int) f2);
    }

    @k.e.a.d
    public static final l b0(byte b, long j2) {
        return l.f14971d.a(b, j2, -1L);
    }

    @k.e.a.e
    public static final Integer b1(long j2) {
        long j3 = Integer.MAX_VALUE;
        if (Integer.MIN_VALUE <= j2 && j3 >= j2) {
            return Integer.valueOf((int) j2);
        }
        return null;
    }

    @k.e.a.d
    public static final l c0(int i2, long j2) {
        return l.f14971d.a(i2, j2, -1L);
    }

    @k.e.a.e
    public static final Long c1(double d2) {
        double d3 = Long.MAX_VALUE;
        if (d2 < Long.MIN_VALUE || d2 > d3) {
            return null;
        }
        return Long.valueOf((long) d2);
    }

    @k.e.a.d
    public static final l d0(long j2, byte b) {
        return l.f14971d.a(j2, b, -1L);
    }

    @k.e.a.e
    public static final Long d1(float f2) {
        float f3 = (float) Long.MAX_VALUE;
        if (f2 < ((float) Long.MIN_VALUE) || f2 > f3) {
            return null;
        }
        return Long.valueOf(f2);
    }

    @k.e.a.d
    public static final l e0(long j2, int i2) {
        return l.f14971d.a(j2, i2, -1L);
    }

    @k.e.a.e
    public static final Short e1(double d2) {
        double d3 = 32767;
        if (d2 < -32768 || d2 > d3) {
            return null;
        }
        return Short.valueOf((short) d2);
    }

    @h.k2.g(name = "byteRangeContains")
    @h.j(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @h.i(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    public static final /* synthetic */ boolean f(g<Byte> gVar, double d2) {
        Byte U0 = U0(d2);
        if (U0 != null) {
            return gVar.contains(U0);
        }
        return false;
    }

    @k.e.a.d
    public static final l f0(long j2, long j3) {
        return l.f14971d.a(j2, j3, -1L);
    }

    @k.e.a.e
    public static final Short f1(float f2) {
        float f3 = 32767;
        if (f2 < -32768 || f2 > f3) {
            return null;
        }
        return Short.valueOf((short) f2);
    }

    @h.k2.g(name = "byteRangeContains")
    @h.j(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @h.i(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    public static final /* synthetic */ boolean g(g<Byte> gVar, float f2) {
        Byte V0 = V0(f2);
        if (V0 != null) {
            return gVar.contains(V0);
        }
        return false;
    }

    @k.e.a.d
    public static final l g0(long j2, short s) {
        return l.f14971d.a(j2, s, -1L);
    }

    @k.e.a.e
    public static final Short g1(int i2) {
        if (-32768 <= i2 && 32767 >= i2) {
            return Short.valueOf((short) i2);
        }
        return null;
    }

    @h.k2.g(name = "byteRangeContains")
    public static final boolean h(@k.e.a.d g<Byte> gVar, int i2) {
        Byte W0 = W0(i2);
        if (W0 != null) {
            return gVar.contains(W0);
        }
        return false;
    }

    @k.e.a.d
    public static final l h0(short s, long j2) {
        return l.f14971d.a(s, j2, -1L);
    }

    @k.e.a.e
    public static final Short h1(long j2) {
        long j3 = 32767;
        if (-32768 <= j2 && j3 >= j2) {
            return Short.valueOf((short) j2);
        }
        return null;
    }

    @h.k2.g(name = "byteRangeContains")
    public static final boolean i(@k.e.a.d g<Byte> gVar, long j2) {
        Byte X0 = X0(j2);
        if (X0 != null) {
            return gVar.contains(X0);
        }
        return false;
    }

    @k.e.a.d
    public static final c i1(char c2, char c3) {
        return f0.t(c3, 0) <= 0 ? c.f14964f.a() : new c(c2, (char) (c3 - 1));
    }

    @h.k2.g(name = "byteRangeContains")
    public static final boolean j(@k.e.a.d g<Byte> gVar, short s) {
        Byte Y0 = Y0(s);
        if (Y0 != null) {
            return gVar.contains(Y0);
        }
        return false;
    }

    @h.k2.g(name = "floatRangeContains")
    public static final boolean j0(@k.e.a.d g<Float> gVar, double d2) {
        return gVar.contains(Float.valueOf((float) d2));
    }

    @k.e.a.d
    public static final k j1(byte b, byte b2) {
        return new k(b, b2 - 1);
    }

    public static final byte k(byte b, byte b2) {
        return b < b2 ? b2 : b;
    }

    @k.e.a.d
    public static final k k1(byte b, int i2) {
        if (i2 <= Integer.MIN_VALUE) {
            return k.f14970f.a();
        }
        return new k(b, i2 - 1);
    }

    public static final double l(double d2, double d3) {
        return d2 < d3 ? d3 : d2;
    }

    @k.e.a.d
    public static final k l1(byte b, short s) {
        return new k(b, s - 1);
    }

    public static final float m(float f2, float f3) {
        return f2 < f3 ? f3 : f2;
    }

    @k.e.a.d
    public static final k m1(int i2, byte b) {
        return new k(i2, b - 1);
    }

    public static final int n(int i2, int i3) {
        return i2 < i3 ? i3 : i2;
    }

    @h.k2.g(name = "intRangeContains")
    public static final boolean n0(@k.e.a.d g<Integer> gVar, byte b) {
        return gVar.contains(Integer.valueOf(b));
    }

    @k.e.a.d
    public static final k n1(int i2, int i3) {
        if (i3 <= Integer.MIN_VALUE) {
            return k.f14970f.a();
        }
        return new k(i2, i3 - 1);
    }

    public static final long o(long j2, long j3) {
        return j2 < j3 ? j3 : j2;
    }

    @h.k2.g(name = "intRangeContains")
    @h.j(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @h.i(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    public static final /* synthetic */ boolean o0(g<Integer> gVar, double d2) {
        Integer Z0 = Z0(d2);
        if (Z0 != null) {
            return gVar.contains(Z0);
        }
        return false;
    }

    @k.e.a.d
    public static final k o1(int i2, short s) {
        return new k(i2, s - 1);
    }

    @k.e.a.d
    public static final <T extends Comparable<? super T>> T p(@k.e.a.d T t, @k.e.a.d T t2) {
        return t.compareTo(t2) < 0 ? t2 : t;
    }

    @h.k2.g(name = "intRangeContains")
    @h.j(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @h.i(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    public static final /* synthetic */ boolean p0(g<Integer> gVar, float f2) {
        Integer a1 = a1(f2);
        if (a1 != null) {
            return gVar.contains(a1);
        }
        return false;
    }

    @k.e.a.d
    public static final k p1(short s, byte b) {
        return new k(s, b - 1);
    }

    public static final short q(short s, short s2) {
        return s < s2 ? s2 : s;
    }

    @h.k2.g(name = "intRangeContains")
    public static final boolean q0(@k.e.a.d g<Integer> gVar, long j2) {
        Integer b1 = b1(j2);
        if (b1 != null) {
            return gVar.contains(b1);
        }
        return false;
    }

    @k.e.a.d
    public static final k q1(short s, int i2) {
        if (i2 <= Integer.MIN_VALUE) {
            return k.f14970f.a();
        }
        return new k(s, i2 - 1);
    }

    public static final byte r(byte b, byte b2) {
        return b > b2 ? b2 : b;
    }

    @h.k2.g(name = "intRangeContains")
    public static final boolean r0(@k.e.a.d g<Integer> gVar, short s) {
        return gVar.contains(Integer.valueOf(s));
    }

    @k.e.a.d
    public static final k r1(short s, short s2) {
        return new k(s, s2 - 1);
    }

    public static final double s(double d2, double d3) {
        return d2 > d3 ? d3 : d2;
    }

    @h.k2.g(name = "longRangeContains")
    public static final boolean s0(@k.e.a.d g<Long> gVar, byte b) {
        return gVar.contains(Long.valueOf(b));
    }

    @k.e.a.d
    public static final n s1(byte b, long j2) {
        if (j2 <= Long.MIN_VALUE) {
            return n.f14976f.a();
        }
        return new n(b, j2 - 1);
    }

    public static final float t(float f2, float f3) {
        return f2 > f3 ? f3 : f2;
    }

    @h.k2.g(name = "longRangeContains")
    @h.j(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @h.i(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    public static final /* synthetic */ boolean t0(g<Long> gVar, double d2) {
        Long c1 = c1(d2);
        if (c1 != null) {
            return gVar.contains(c1);
        }
        return false;
    }

    @k.e.a.d
    public static final n t1(int i2, long j2) {
        if (j2 <= Long.MIN_VALUE) {
            return n.f14976f.a();
        }
        return new n(i2, j2 - 1);
    }

    public static final int u(int i2, int i3) {
        return i2 > i3 ? i3 : i2;
    }

    @h.k2.g(name = "longRangeContains")
    @h.j(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @h.i(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    public static final /* synthetic */ boolean u0(g<Long> gVar, float f2) {
        Long d1 = d1(f2);
        if (d1 != null) {
            return gVar.contains(d1);
        }
        return false;
    }

    @k.e.a.d
    public static final n u1(long j2, byte b) {
        return new n(j2, b - 1);
    }

    public static final long v(long j2, long j3) {
        return j2 > j3 ? j3 : j2;
    }

    @h.k2.g(name = "longRangeContains")
    public static final boolean v0(@k.e.a.d g<Long> gVar, int i2) {
        return gVar.contains(Long.valueOf(i2));
    }

    @k.e.a.d
    public static final n v1(long j2, int i2) {
        return new n(j2, i2 - 1);
    }

    @k.e.a.d
    public static final <T extends Comparable<? super T>> T w(@k.e.a.d T t, @k.e.a.d T t2) {
        return t.compareTo(t2) > 0 ? t2 : t;
    }

    @h.k2.g(name = "longRangeContains")
    public static final boolean w0(@k.e.a.d g<Long> gVar, short s) {
        return gVar.contains(Long.valueOf(s));
    }

    @k.e.a.d
    public static final n w1(long j2, long j3) {
        if (j3 <= Long.MIN_VALUE) {
            return n.f14976f.a();
        }
        return new n(j2, j3 - 1);
    }

    public static final short x(short s, short s2) {
        return s > s2 ? s2 : s;
    }

    @h.g2.f
    @s0(version = "1.3")
    private static final char x0(c cVar) {
        return y0(cVar, Random.Default);
    }

    @k.e.a.d
    public static final n x1(long j2, short s) {
        return new n(j2, s - 1);
    }

    public static final byte y(byte b, byte b2, byte b3) {
        if (b2 <= b3) {
            return b < b2 ? b2 : b > b3 ? b3 : b;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((int) b3) + " is less than minimum " + ((int) b2) + '.');
    }

    @s0(version = "1.3")
    public static final char y0(@k.e.a.d c cVar, @k.e.a.d Random random) {
        try {
            return (char) random.nextInt(cVar.d(), cVar.f() + 1);
        } catch (IllegalArgumentException e2) {
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @k.e.a.d
    public static final n y1(short s, long j2) {
        if (j2 <= Long.MIN_VALUE) {
            return n.f14976f.a();
        }
        return new n(s, j2 - 1);
    }

    public static final double z(double d2, double d3, double d4) {
        if (d3 <= d4) {
            return d2 < d3 ? d3 : d2 > d4 ? d4 : d2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + d4 + " is less than minimum " + d3 + '.');
    }

    @h.g2.f
    @s0(version = "1.3")
    private static final int z0(k kVar) {
        return A0(kVar, Random.Default);
    }
}

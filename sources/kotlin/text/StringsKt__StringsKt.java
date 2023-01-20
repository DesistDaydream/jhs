package kotlin.text;

import com.tencent.android.tpush.common.MessageKey;
import com.tencent.bugly.Bugly;
import h.a2.n;
import h.a2.r;
import h.a2.t;
import h.g2.f;
import h.j0;
import h.k2.g;
import h.k2.u.l;
import h.k2.v.f0;
import h.o;
import h.o2.i;
import h.o2.k;
import h.o2.q;
import h.q0;
import h.q2.m;
import h.s0;
import h.t2.b;
import h.t2.c;
import h.t2.u;
import h.x1;
import h.z0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.sequences.SequencesKt___SequencesKt;

@Metadata(d1 = {"\u0000|\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0019\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b!\u001a\u001c\u0010\t\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u001c\u0010\u000e\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u001f\u0010\u000f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\rH\u0086\u0002\u001a\u001f\u0010\u000f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\rH\u0086\u0002\u001a\u0015\u0010\u000f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0087\n\u001a\u0018\u0010\u0014\u001a\u00020\r*\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0000\u001a\u0018\u0010\u0015\u001a\u00020\r*\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0000\u001a\u001c\u0010\u0016\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u001c\u0010\u0016\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\r\u001a:\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0018\u00010\u0019*\u00020\u00022\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\n0\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001aE\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0018\u00010\u0019*\u00020\u00022\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\n0\u001b2\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\rH\u0002¢\u0006\u0002\b\u001e\u001a:\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0018\u00010\u0019*\u00020\u00022\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\n0\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u0012\u0010 \u001a\u00020\r*\u00020\u00022\u0006\u0010!\u001a\u00020\u0006\u001a7\u0010\"\u001a\u0002H#\"\f\b\u0000\u0010$*\u00020\u0002*\u0002H#\"\u0004\b\u0001\u0010#*\u0002H$2\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H#0&H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010'\u001a7\u0010(\u001a\u0002H#\"\f\b\u0000\u0010$*\u00020\u0002*\u0002H#\"\u0004\b\u0001\u0010#*\u0002H$2\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H#0&H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010'\u001a&\u0010)\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a;\u0010)\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u001d\u001a\u00020\rH\u0002¢\u0006\u0002\b+\u001a&\u0010)\u001a\u00020\u0006*\u00020\u00022\u0006\u0010,\u001a\u00020\n2\b\b\u0002\u0010\u001c\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a&\u0010-\u001a\u00020\u0006*\u00020\u00022\u0006\u0010.\u001a\u00020/2\b\b\u0002\u0010\u001c\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a,\u0010-\u001a\u00020\u0006*\u00020\u00022\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\n0\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a\r\u00100\u001a\u00020\r*\u00020\u0002H\u0087\b\u001a\r\u00101\u001a\u00020\r*\u00020\u0002H\u0087\b\u001a\r\u00102\u001a\u00020\r*\u00020\u0002H\u0087\b\u001a \u00103\u001a\u00020\r*\u0004\u0018\u00010\u0002H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a \u00104\u001a\u00020\r*\u0004\u0018\u00010\u0002H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a\r\u00105\u001a\u000206*\u00020\u0002H\u0086\u0002\u001a&\u00107\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a&\u00107\u001a\u00020\u0006*\u00020\u00022\u0006\u0010,\u001a\u00020\n2\b\b\u0002\u0010\u001c\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a&\u00108\u001a\u00020\u0006*\u00020\u00022\u0006\u0010.\u001a\u00020/2\b\b\u0002\u0010\u001c\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a,\u00108\u001a\u00020\u0006*\u00020\u00022\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\n0\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u0010\u00109\u001a\b\u0012\u0004\u0012\u00020\n0:*\u00020\u0002\u001a\u0010\u0010;\u001a\b\u0012\u0004\u0012\u00020\n0<*\u00020\u0002\u001a\u0015\u0010=\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0087\f\u001a\u000f\u0010>\u001a\u00020\n*\u0004\u0018\u00010\nH\u0087\b\u001a\u001c\u0010?\u001a\u00020\u0002*\u00020\u00022\u0006\u0010@\u001a\u00020\u00062\b\b\u0002\u0010A\u001a\u00020\u0011\u001a\u001c\u0010?\u001a\u00020\n*\u00020\n2\u0006\u0010@\u001a\u00020\u00062\b\b\u0002\u0010A\u001a\u00020\u0011\u001a\u001c\u0010B\u001a\u00020\u0002*\u00020\u00022\u0006\u0010@\u001a\u00020\u00062\b\b\u0002\u0010A\u001a\u00020\u0011\u001a\u001c\u0010B\u001a\u00020\n*\u00020\n2\u0006\u0010@\u001a\u00020\u00062\b\b\u0002\u0010A\u001a\u00020\u0011\u001aG\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00010:*\u00020\u00022\u000e\u0010D\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0E2\b\b\u0002\u0010\u001c\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010F\u001a\u00020\u0006H\u0002¢\u0006\u0004\bG\u0010H\u001a=\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00010:*\u00020\u00022\u0006\u0010D\u001a\u00020/2\b\b\u0002\u0010\u001c\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010F\u001a\u00020\u0006H\u0002¢\u0006\u0002\bG\u001a4\u0010I\u001a\u00020\r*\u00020\u00022\u0006\u0010J\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010K\u001a\u00020\u00062\u0006\u0010@\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0000\u001a\u0012\u0010L\u001a\u00020\u0002*\u00020\u00022\u0006\u0010M\u001a\u00020\u0002\u001a\u0012\u0010L\u001a\u00020\n*\u00020\n2\u0006\u0010M\u001a\u00020\u0002\u001a\u001a\u0010N\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u0006\u001a\u0012\u0010N\u001a\u00020\u0002*\u00020\u00022\u0006\u0010O\u001a\u00020\u0001\u001a\u001d\u0010N\u001a\u00020\n*\u00020\n2\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u0006H\u0087\b\u001a\u0015\u0010N\u001a\u00020\n*\u00020\n2\u0006\u0010O\u001a\u00020\u0001H\u0087\b\u001a\u0012\u0010P\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0002\u001a\u0012\u0010P\u001a\u00020\n*\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0002\u001a\u0012\u0010Q\u001a\u00020\u0002*\u00020\u00022\u0006\u0010R\u001a\u00020\u0002\u001a\u001a\u0010Q\u001a\u00020\u0002*\u00020\u00022\u0006\u0010M\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0002\u001a\u0012\u0010Q\u001a\u00020\n*\u00020\n2\u0006\u0010R\u001a\u00020\u0002\u001a\u001a\u0010Q\u001a\u00020\n*\u00020\n2\u0006\u0010M\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0002\u001a.\u0010S\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0014\b\b\u0010T\u001a\u000e\u0012\u0004\u0012\u00020V\u0012\u0004\u0012\u00020\u00020UH\u0087\bø\u0001\u0000\u001a\u001d\u0010S\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010W\u001a\u00020\nH\u0087\b\u001a$\u0010X\u001a\u00020\n*\u00020\n2\u0006\u0010R\u001a\u00020\u00112\u0006\u0010W\u001a\u00020\n2\b\b\u0002\u0010Y\u001a\u00020\n\u001a$\u0010X\u001a\u00020\n*\u00020\n2\u0006\u0010R\u001a\u00020\n2\u0006\u0010W\u001a\u00020\n2\b\b\u0002\u0010Y\u001a\u00020\n\u001a$\u0010Z\u001a\u00020\n*\u00020\n2\u0006\u0010R\u001a\u00020\u00112\u0006\u0010W\u001a\u00020\n2\b\b\u0002\u0010Y\u001a\u00020\n\u001a$\u0010Z\u001a\u00020\n*\u00020\n2\u0006\u0010R\u001a\u00020\n2\u0006\u0010W\u001a\u00020\n2\b\b\u0002\u0010Y\u001a\u00020\n\u001a$\u0010[\u001a\u00020\n*\u00020\n2\u0006\u0010R\u001a\u00020\u00112\u0006\u0010W\u001a\u00020\n2\b\b\u0002\u0010Y\u001a\u00020\n\u001a$\u0010[\u001a\u00020\n*\u00020\n2\u0006\u0010R\u001a\u00020\n2\u0006\u0010W\u001a\u00020\n2\b\b\u0002\u0010Y\u001a\u00020\n\u001a$\u0010\\\u001a\u00020\n*\u00020\n2\u0006\u0010R\u001a\u00020\u00112\u0006\u0010W\u001a\u00020\n2\b\b\u0002\u0010Y\u001a\u00020\n\u001a$\u0010\\\u001a\u00020\n*\u00020\n2\u0006\u0010R\u001a\u00020\n2\u0006\u0010W\u001a\u00020\n2\b\b\u0002\u0010Y\u001a\u00020\n\u001a\u001d\u0010]\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010W\u001a\u00020\nH\u0087\b\u001a)\u0010^\u001a\u00020\n*\u00020\n2\u0012\u0010T\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110UH\u0087\bø\u0001\u0000¢\u0006\u0002\b_\u001a)\u0010^\u001a\u00020\n*\u00020\n2\u0012\u0010T\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00020UH\u0087\bø\u0001\u0000¢\u0006\u0002\b`\u001a\"\u0010a\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u00062\u0006\u0010W\u001a\u00020\u0002\u001a\u001a\u0010a\u001a\u00020\u0002*\u00020\u00022\u0006\u0010O\u001a\u00020\u00012\u0006\u0010W\u001a\u00020\u0002\u001a%\u0010a\u001a\u00020\n*\u00020\n2\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u00062\u0006\u0010W\u001a\u00020\u0002H\u0087\b\u001a\u001d\u0010a\u001a\u00020\n*\u00020\n2\u0006\u0010O\u001a\u00020\u00012\u0006\u0010W\u001a\u00020\u0002H\u0087\b\u001a=\u0010b\u001a\b\u0012\u0004\u0012\u00020\n0<*\u00020\u00022\u0012\u0010D\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0E\"\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010F\u001a\u00020\u0006¢\u0006\u0002\u0010c\u001a0\u0010b\u001a\b\u0012\u0004\u0012\u00020\n0<*\u00020\u00022\n\u0010D\u001a\u00020/\"\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010F\u001a\u00020\u0006\u001a/\u0010b\u001a\b\u0012\u0004\u0012\u00020\n0<*\u00020\u00022\u0006\u0010R\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010F\u001a\u00020\u0006H\u0002¢\u0006\u0002\bd\u001a%\u0010b\u001a\b\u0012\u0004\u0012\u00020\n0<*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010F\u001a\u00020\u0006H\u0087\b\u001a=\u0010e\u001a\b\u0012\u0004\u0012\u00020\n0:*\u00020\u00022\u0012\u0010D\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0E\"\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010F\u001a\u00020\u0006¢\u0006\u0002\u0010f\u001a0\u0010e\u001a\b\u0012\u0004\u0012\u00020\n0:*\u00020\u00022\n\u0010D\u001a\u00020/\"\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010F\u001a\u00020\u0006\u001a\u001c\u0010g\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u001c\u0010g\u001a\u00020\r*\u00020\u00022\u0006\u0010M\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\r\u001a$\u0010g\u001a\u00020\r*\u00020\u00022\u0006\u0010M\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u0012\u0010h\u001a\u00020\u0002*\u00020\u00022\u0006\u0010O\u001a\u00020\u0001\u001a\u001d\u0010h\u001a\u00020\u0002*\u00020\n2\u0006\u0010i\u001a\u00020\u00062\u0006\u0010j\u001a\u00020\u0006H\u0087\b\u001a\u001f\u0010k\u001a\u00020\n*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00062\b\b\u0002\u0010*\u001a\u00020\u0006H\u0087\b\u001a\u0012\u0010k\u001a\u00020\n*\u00020\u00022\u0006\u0010O\u001a\u00020\u0001\u001a\u0012\u0010k\u001a\u00020\n*\u00020\n2\u0006\u0010O\u001a\u00020\u0001\u001a\u001c\u0010l\u001a\u00020\n*\u00020\n2\u0006\u0010R\u001a\u00020\u00112\b\b\u0002\u0010Y\u001a\u00020\n\u001a\u001c\u0010l\u001a\u00020\n*\u00020\n2\u0006\u0010R\u001a\u00020\n2\b\b\u0002\u0010Y\u001a\u00020\n\u001a\u001c\u0010m\u001a\u00020\n*\u00020\n2\u0006\u0010R\u001a\u00020\u00112\b\b\u0002\u0010Y\u001a\u00020\n\u001a\u001c\u0010m\u001a\u00020\n*\u00020\n2\u0006\u0010R\u001a\u00020\n2\b\b\u0002\u0010Y\u001a\u00020\n\u001a\u001c\u0010n\u001a\u00020\n*\u00020\n2\u0006\u0010R\u001a\u00020\u00112\b\b\u0002\u0010Y\u001a\u00020\n\u001a\u001c\u0010n\u001a\u00020\n*\u00020\n2\u0006\u0010R\u001a\u00020\n2\b\b\u0002\u0010Y\u001a\u00020\n\u001a\u001c\u0010o\u001a\u00020\n*\u00020\n2\u0006\u0010R\u001a\u00020\u00112\b\b\u0002\u0010Y\u001a\u00020\n\u001a\u001c\u0010o\u001a\u00020\n*\u00020\n2\u0006\u0010R\u001a\u00020\n2\b\b\u0002\u0010Y\u001a\u00020\n\u001a\f\u0010p\u001a\u00020\r*\u00020\nH\u0007\u001a\u0013\u0010q\u001a\u0004\u0018\u00010\r*\u00020\nH\u0007¢\u0006\u0002\u0010r\u001a\n\u0010s\u001a\u00020\u0002*\u00020\u0002\u001a$\u0010s\u001a\u00020\u0002*\u00020\u00022\u0012\u0010t\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0UH\u0086\bø\u0001\u0000\u001a\u0016\u0010s\u001a\u00020\u0002*\u00020\u00022\n\u0010.\u001a\u00020/\"\u00020\u0011\u001a\r\u0010s\u001a\u00020\n*\u00020\nH\u0087\b\u001a$\u0010s\u001a\u00020\n*\u00020\n2\u0012\u0010t\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0UH\u0086\bø\u0001\u0000\u001a\u0016\u0010s\u001a\u00020\n*\u00020\n2\n\u0010.\u001a\u00020/\"\u00020\u0011\u001a\n\u0010u\u001a\u00020\u0002*\u00020\u0002\u001a$\u0010u\u001a\u00020\u0002*\u00020\u00022\u0012\u0010t\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0UH\u0086\bø\u0001\u0000\u001a\u0016\u0010u\u001a\u00020\u0002*\u00020\u00022\n\u0010.\u001a\u00020/\"\u00020\u0011\u001a\r\u0010u\u001a\u00020\n*\u00020\nH\u0087\b\u001a$\u0010u\u001a\u00020\n*\u00020\n2\u0012\u0010t\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0UH\u0086\bø\u0001\u0000\u001a\u0016\u0010u\u001a\u00020\n*\u00020\n2\n\u0010.\u001a\u00020/\"\u00020\u0011\u001a\n\u0010v\u001a\u00020\u0002*\u00020\u0002\u001a$\u0010v\u001a\u00020\u0002*\u00020\u00022\u0012\u0010t\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0UH\u0086\bø\u0001\u0000\u001a\u0016\u0010v\u001a\u00020\u0002*\u00020\u00022\n\u0010.\u001a\u00020/\"\u00020\u0011\u001a\r\u0010v\u001a\u00020\n*\u00020\nH\u0087\b\u001a$\u0010v\u001a\u00020\n*\u00020\n2\u0012\u0010t\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0UH\u0086\bø\u0001\u0000\u001a\u0016\u0010v\u001a\u00020\n*\u00020\n2\n\u0010.\u001a\u00020/\"\u00020\u0011\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006w"}, d2 = {"indices", "Lkotlin/ranges/IntRange;", "", "getIndices", "(Ljava/lang/CharSequence;)Lkotlin/ranges/IntRange;", "lastIndex", "", "getLastIndex", "(Ljava/lang/CharSequence;)I", "commonPrefixWith", "", "other", "ignoreCase", "", "commonSuffixWith", "contains", "char", "", "regex", "Lkotlin/text/Regex;", "contentEqualsIgnoreCaseImpl", "contentEqualsImpl", "endsWith", "suffix", "findAnyOf", "Lkotlin/Pair;", "strings", "", "startIndex", "last", "findAnyOf$StringsKt__StringsKt", "findLastAnyOf", "hasSurrogatePairAt", "index", "ifBlank", "R", "C", "defaultValue", "Lkotlin/Function0;", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ifEmpty", "indexOf", "endIndex", "indexOf$StringsKt__StringsKt", "string", "indexOfAny", "chars", "", "isEmpty", "isNotBlank", "isNotEmpty", "isNullOrBlank", "isNullOrEmpty", "iterator", "Lkotlin/collections/CharIterator;", "lastIndexOf", "lastIndexOfAny", "lineSequence", "Lkotlin/sequences/Sequence;", "lines", "", "matches", "orEmpty", "padEnd", "length", "padChar", "padStart", "rangesDelimitedBy", "delimiters", "", "limit", "rangesDelimitedBy$StringsKt__StringsKt", "(Ljava/lang/CharSequence;[Ljava/lang/String;IZI)Lkotlin/sequences/Sequence;", "regionMatchesImpl", "thisOffset", "otherOffset", "removePrefix", "prefix", "removeRange", "range", "removeSuffix", "removeSurrounding", "delimiter", "replace", "transform", "Lkotlin/Function1;", "Lkotlin/text/MatchResult;", "replacement", "replaceAfter", "missingDelimiterValue", "replaceAfterLast", "replaceBefore", "replaceBeforeLast", "replaceFirst", "replaceFirstChar", "replaceFirstCharWithChar", "replaceFirstCharWithCharSequence", "replaceRange", "split", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Ljava/util/List;", "split$StringsKt__StringsKt", "splitToSequence", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Lkotlin/sequences/Sequence;", "startsWith", "subSequence", MessageKey.MSG_ACCEPT_TIME_START, MessageKey.MSG_ACCEPT_TIME_END, "substring", "substringAfter", "substringAfterLast", "substringBefore", "substringBeforeLast", "toBooleanStrict", "toBooleanStrictOrNull", "(Ljava/lang/String;)Ljava/lang/Boolean;", "trim", "predicate", "trimEnd", "trimStart", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/text/StringsKt")
/* loaded from: classes4.dex */
public class StringsKt__StringsKt extends u {

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"kotlin/text/StringsKt__StringsKt$iterator$1", "Lkotlin/collections/CharIterator;", "index", "", "hasNext", "", "nextChar", "", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes4.dex */
    public static final class a extends r {
        private int a;
        public final /* synthetic */ CharSequence b;

        public a(CharSequence charSequence) {
            this.b = charSequence;
        }

        @Override // h.a2.r
        public char d() {
            CharSequence charSequence = this.b;
            int i2 = this.a;
            this.a = i2 + 1;
            return charSequence.charAt(i2);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a < this.b.length();
        }
    }

    @f
    private static final boolean A3(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static /* synthetic */ String A4(String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str4 = str;
        }
        return y4(str, str2, str3, str4);
    }

    @e
    @s0(version = "1.5")
    public static final Boolean A5(@d String str) {
        int hashCode = str.hashCode();
        if (hashCode != 3569038) {
            if (hashCode == 97196323 && str.equals(Bugly.SDK_IS_DEV)) {
                return Boolean.FALSE;
            }
        } else if (str.equals("true")) {
            return Boolean.TRUE;
        }
        return null;
    }

    @d
    public static final r B3(@d CharSequence charSequence) {
        return new a(charSequence);
    }

    @d
    public static final String B4(@d String str, char c2, @d String str2, @d String str3) {
        int E3 = E3(str, c2, 0, false, 6, null);
        return E3 == -1 ? str3 : I4(str, 0, E3, str2).toString();
    }

    @d
    public static final CharSequence B5(@d CharSequence charSequence) {
        int length = charSequence.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean r = b.r(charSequence.charAt(!z ? i2 : length));
            if (z) {
                if (!r) {
                    break;
                }
                length--;
            } else if (r) {
                i2++;
            } else {
                z = true;
            }
        }
        return charSequence.subSequence(i2, length + 1);
    }

    public static final int C3(@d CharSequence charSequence, char c2, int i2, boolean z) {
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(c2, i2);
        }
        return H3(charSequence, new char[]{c2}, i2, z);
    }

    @d
    public static final String C4(@d String str, @d String str2, @d String str3, @d String str4) {
        int F3 = F3(str, str2, 0, false, 6, null);
        return F3 == -1 ? str4 : I4(str, 0, F3, str3).toString();
    }

    @d
    public static final CharSequence C5(@d CharSequence charSequence, @d l<? super Character, Boolean> lVar) {
        int length = charSequence.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean booleanValue = lVar.invoke(Character.valueOf(charSequence.charAt(!z ? i2 : length))).booleanValue();
            if (z) {
                if (!booleanValue) {
                    break;
                }
                length--;
            } else if (booleanValue) {
                i2++;
            } else {
                z = true;
            }
        }
        return charSequence.subSequence(i2, length + 1);
    }

    public static final int D3(@d CharSequence charSequence, @d String str, int i2, boolean z) {
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(str, i2);
        }
        return o3(charSequence, str, i2, 0, z, true);
    }

    public static /* synthetic */ String D4(String str, char c2, String str2, String str3, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str3 = str;
        }
        return B4(str, c2, str2, str3);
    }

    @d
    public static final CharSequence D5(@d CharSequence charSequence, @d char... cArr) {
        int length = charSequence.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean K7 = ArraysKt___ArraysKt.K7(cArr, charSequence.charAt(!z ? i2 : length));
            if (z) {
                if (!K7) {
                    break;
                }
                length--;
            } else if (K7) {
                i2++;
            } else {
                z = true;
            }
        }
        return charSequence.subSequence(i2, length + 1);
    }

    public static /* synthetic */ int E3(CharSequence charSequence, char c2, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = i3(charSequence);
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return C3(charSequence, c2, i2, z);
    }

    public static /* synthetic */ String E4(String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str4 = str;
        }
        return C4(str, str2, str3, str4);
    }

    @f
    private static final String E5(String str) {
        Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.CharSequence");
        return B5(str).toString();
    }

    public static /* synthetic */ int F3(CharSequence charSequence, String str, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = i3(charSequence);
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return D3(charSequence, str, i2, z);
    }

    @f
    private static final String F4(CharSequence charSequence, Regex regex, String str) {
        return regex.replaceFirst(charSequence, str);
    }

    @d
    public static final String F5(@d String str, @d l<? super Character, Boolean> lVar) {
        int length = str.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean booleanValue = lVar.invoke(Character.valueOf(str.charAt(!z ? i2 : length))).booleanValue();
            if (z) {
                if (!booleanValue) {
                    break;
                }
                length--;
            } else if (booleanValue) {
                i2++;
            } else {
                z = true;
            }
        }
        return str.subSequence(i2, length + 1).toString();
    }

    public static final int G3(@d CharSequence charSequence, @d Collection<String> collection, int i2, boolean z) {
        Integer first;
        Pair<Integer, String> d3 = d3(charSequence, collection, i2, z, true);
        if (d3 == null || (first = d3.getFirst()) == null) {
            return -1;
        }
        return first.intValue();
    }

    @g(name = "replaceFirstCharWithChar")
    @j0
    @s0(version = "1.5")
    @f
    @x1(markerClass = {o.class})
    private static final String G4(String str, l<? super Character, Character> lVar) {
        if (str.length() > 0) {
            char charValue = lVar.invoke(Character.valueOf(str.charAt(0))).charValue();
            Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
            String substring = str.substring(1);
            return String.valueOf(charValue) + substring;
        }
        return str;
    }

    @d
    public static final String G5(@d String str, @d char... cArr) {
        int length = str.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean K7 = ArraysKt___ArraysKt.K7(cArr, str.charAt(!z ? i2 : length));
            if (z) {
                if (!K7) {
                    break;
                }
                length--;
            } else if (K7) {
                i2++;
            } else {
                z = true;
            }
        }
        return str.subSequence(i2, length + 1).toString();
    }

    public static final int H3(@d CharSequence charSequence, @d char[] cArr, int i2, boolean z) {
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(ArraysKt___ArraysKt.ss(cArr), i2);
        }
        for (int u = q.u(i2, i3(charSequence)); u >= 0; u--) {
            char charAt = charSequence.charAt(u);
            int length = cArr.length;
            boolean z2 = false;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                } else if (c.J(cArr[i3], charAt, z)) {
                    z2 = true;
                    break;
                } else {
                    i3++;
                }
            }
            if (z2) {
                return u;
            }
        }
        return -1;
    }

    @g(name = "replaceFirstCharWithCharSequence")
    @j0
    @s0(version = "1.5")
    @f
    @x1(markerClass = {o.class})
    private static final String H4(String str, l<? super Character, ? extends CharSequence> lVar) {
        if (str.length() > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(lVar.invoke(Character.valueOf(str.charAt(0))).toString());
            Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
            sb.append(str.substring(1));
            return sb.toString();
        }
        return str;
    }

    @d
    public static final CharSequence H5(@d CharSequence charSequence) {
        int length = charSequence.length();
        do {
            length--;
            if (length < 0) {
                return "";
            }
        } while (b.r(charSequence.charAt(length)));
        return charSequence.subSequence(0, length + 1);
    }

    public static /* synthetic */ int I3(CharSequence charSequence, Collection collection, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = i3(charSequence);
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return G3(charSequence, collection, i2, z);
    }

    @d
    public static final CharSequence I4(@d CharSequence charSequence, int i2, int i3, @d CharSequence charSequence2) {
        if (i3 >= i2) {
            StringBuilder sb = new StringBuilder();
            sb.append(charSequence, 0, i2);
            sb.append(charSequence2);
            sb.append(charSequence, i3, charSequence.length());
            return sb;
        }
        throw new IndexOutOfBoundsException("End index (" + i3 + ") is less than start index (" + i2 + ").");
    }

    @d
    public static final CharSequence I5(@d CharSequence charSequence, @d l<? super Character, Boolean> lVar) {
        int length = charSequence.length();
        do {
            length--;
            if (length < 0) {
                return "";
            }
        } while (lVar.invoke(Character.valueOf(charSequence.charAt(length))).booleanValue());
        return charSequence.subSequence(0, length + 1);
    }

    public static /* synthetic */ int J3(CharSequence charSequence, char[] cArr, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = i3(charSequence);
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return H3(charSequence, cArr, i2, z);
    }

    @d
    public static final CharSequence J4(@d CharSequence charSequence, @d k kVar, @d CharSequence charSequence2) {
        return I4(charSequence, kVar.getStart().intValue(), kVar.getEndInclusive().intValue() + 1, charSequence2);
    }

    @d
    public static final CharSequence J5(@d CharSequence charSequence, @d char... cArr) {
        int length = charSequence.length();
        do {
            length--;
            if (length < 0) {
                return "";
            }
        } while (ArraysKt___ArraysKt.K7(cArr, charSequence.charAt(length)));
        return charSequence.subSequence(0, length + 1);
    }

    @d
    public static final m<String> K3(@d CharSequence charSequence) {
        return W4(charSequence, new String[]{"\r\n", "\n", "\r"}, false, 0, 6, null);
    }

    @f
    private static final String K4(String str, int i2, int i3, CharSequence charSequence) {
        Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.CharSequence");
        return I4(str, i2, i3, charSequence).toString();
    }

    @f
    private static final String K5(String str) {
        Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.CharSequence");
        return H5(str).toString();
    }

    @d
    public static final List<String> L3(@d CharSequence charSequence) {
        return SequencesKt___SequencesKt.V2(K3(charSequence));
    }

    @f
    private static final String L4(String str, k kVar, CharSequence charSequence) {
        Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.CharSequence");
        return J4(str, kVar, charSequence).toString();
    }

    @d
    public static final String L5(@d String str, @d l<? super Character, Boolean> lVar) {
        CharSequence charSequence;
        int length = str.length();
        while (true) {
            length--;
            if (length < 0) {
                charSequence = "";
                break;
            } else if (!lVar.invoke(Character.valueOf(str.charAt(length))).booleanValue()) {
                charSequence = str.subSequence(0, length + 1);
                break;
            }
        }
        return charSequence.toString();
    }

    @f
    private static final boolean M3(CharSequence charSequence, Regex regex) {
        return regex.matches(charSequence);
    }

    @f
    private static final List<String> M4(CharSequence charSequence, Regex regex, int i2) {
        return regex.split(charSequence, i2);
    }

    @d
    public static final String M5(@d String str, @d char... cArr) {
        CharSequence charSequence;
        int length = str.length();
        while (true) {
            length--;
            if (length < 0) {
                charSequence = "";
                break;
            } else if (!ArraysKt___ArraysKt.K7(cArr, str.charAt(length))) {
                charSequence = str.subSequence(0, length + 1);
                break;
            }
        }
        return charSequence.toString();
    }

    @d
    public static final String N2(@d CharSequence charSequence, @d CharSequence charSequence2, boolean z) {
        int min = Math.min(charSequence.length(), charSequence2.length());
        int i2 = 0;
        while (i2 < min && c.J(charSequence.charAt(i2), charSequence2.charAt(i2), z)) {
            i2++;
        }
        int i3 = i2 - 1;
        if (j3(charSequence, i3) || j3(charSequence2, i3)) {
            i2--;
        }
        return charSequence.subSequence(0, i2).toString();
    }

    @f
    private static final String N3(String str) {
        return str != null ? str : "";
    }

    @d
    public static final List<String> N4(@d CharSequence charSequence, @d char[] cArr, boolean z, int i2) {
        if (cArr.length == 1) {
            return P4(charSequence, String.valueOf(cArr[0]), z, i2);
        }
        Iterable<k> G = SequencesKt___SequencesKt.G(Y3(charSequence, cArr, 0, z, i2, 2, null));
        ArrayList arrayList = new ArrayList(h.a2.u.Y(G, 10));
        for (k kVar : G) {
            arrayList.add(g5(charSequence, kVar));
        }
        return arrayList;
    }

    @d
    public static final CharSequence N5(@d CharSequence charSequence) {
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!b.r(charSequence.charAt(i2))) {
                return charSequence.subSequence(i2, charSequence.length());
            }
        }
        return "";
    }

    public static /* synthetic */ String O2(CharSequence charSequence, CharSequence charSequence2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return N2(charSequence, charSequence2, z);
    }

    @d
    public static final CharSequence O3(@d CharSequence charSequence, int i2, char c2) {
        if (i2 >= 0) {
            if (i2 <= charSequence.length()) {
                return charSequence.subSequence(0, charSequence.length());
            }
            StringBuilder sb = new StringBuilder(i2);
            sb.append(charSequence);
            int length = i2 - charSequence.length();
            int i3 = 1;
            if (1 <= length) {
                while (true) {
                    sb.append(c2);
                    if (i3 == length) {
                        break;
                    }
                    i3++;
                }
            }
            return sb;
        }
        throw new IllegalArgumentException("Desired length " + i2 + " is less than zero.");
    }

    @d
    public static final List<String> O4(@d CharSequence charSequence, @d String[] strArr, boolean z, int i2) {
        if (strArr.length == 1) {
            String str = strArr[0];
            if (!(str.length() == 0)) {
                return P4(charSequence, str, z, i2);
            }
        }
        Iterable<k> G = SequencesKt___SequencesKt.G(Z3(charSequence, strArr, 0, z, i2, 2, null));
        ArrayList arrayList = new ArrayList(h.a2.u.Y(G, 10));
        for (k kVar : G) {
            arrayList.add(g5(charSequence, kVar));
        }
        return arrayList;
    }

    @d
    public static final CharSequence O5(@d CharSequence charSequence, @d l<? super Character, Boolean> lVar) {
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!lVar.invoke(Character.valueOf(charSequence.charAt(i2))).booleanValue()) {
                return charSequence.subSequence(i2, charSequence.length());
            }
        }
        return "";
    }

    @d
    public static final String P2(@d CharSequence charSequence, @d CharSequence charSequence2, boolean z) {
        int length;
        int length2 = charSequence.length();
        int min = Math.min(length2, charSequence2.length());
        int i2 = 0;
        while (i2 < min && c.J(charSequence.charAt((length2 - i2) - 1), charSequence2.charAt((length - i2) - 1), z)) {
            i2++;
        }
        if (j3(charSequence, (length2 - i2) - 1) || j3(charSequence2, (length - i2) - 1)) {
            i2--;
        }
        return charSequence.subSequence(length2 - i2, length2).toString();
    }

    @d
    public static final String P3(@d String str, int i2, char c2) {
        return O3(str, i2, c2).toString();
    }

    private static final List<String> P4(CharSequence charSequence, String str, boolean z, int i2) {
        int i3 = 0;
        if (i2 >= 0) {
            int n3 = n3(charSequence, str, 0, z);
            if (n3 != -1 && i2 != 1) {
                boolean z2 = i2 > 0;
                ArrayList arrayList = new ArrayList(z2 ? q.u(i2, 10) : 10);
                do {
                    arrayList.add(charSequence.subSequence(i3, n3).toString());
                    i3 = str.length() + n3;
                    if (z2 && arrayList.size() == i2 - 1) {
                        break;
                    }
                    n3 = n3(charSequence, str, i3, z);
                } while (n3 != -1);
                arrayList.add(charSequence.subSequence(i3, charSequence.length()).toString());
                return arrayList;
            }
            return t.k(charSequence.toString());
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i2 + '.').toString());
    }

    @d
    public static final CharSequence P5(@d CharSequence charSequence, @d char... cArr) {
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!ArraysKt___ArraysKt.K7(cArr, charSequence.charAt(i2))) {
                return charSequence.subSequence(i2, charSequence.length());
            }
        }
        return "";
    }

    public static /* synthetic */ String Q2(CharSequence charSequence, CharSequence charSequence2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return P2(charSequence, charSequence2, z);
    }

    public static /* synthetic */ CharSequence Q3(CharSequence charSequence, int i2, char c2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            c2 = ' ';
        }
        return O3(charSequence, i2, c2);
    }

    public static /* synthetic */ List Q4(CharSequence charSequence, Regex regex, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return regex.split(charSequence, i2);
    }

    @f
    private static final String Q5(String str) {
        Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.CharSequence");
        return N5(str).toString();
    }

    public static final boolean R2(@d CharSequence charSequence, char c2, boolean z) {
        return q3(charSequence, c2, 0, z, 2, null) >= 0;
    }

    public static /* synthetic */ String R3(String str, int i2, char c2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            c2 = ' ';
        }
        return P3(str, i2, c2);
    }

    public static /* synthetic */ List R4(CharSequence charSequence, char[] cArr, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z = false;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return N4(charSequence, cArr, z, i2);
    }

    @d
    public static final String R5(@d String str, @d l<? super Character, Boolean> lVar) {
        CharSequence charSequence;
        int length = str.length();
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                charSequence = "";
                break;
            } else if (!lVar.invoke(Character.valueOf(str.charAt(i2))).booleanValue()) {
                charSequence = str.subSequence(i2, str.length());
                break;
            } else {
                i2++;
            }
        }
        return charSequence.toString();
    }

    public static final boolean S2(@d CharSequence charSequence, @d CharSequence charSequence2, boolean z) {
        if (charSequence2 instanceof String) {
            if (r3(charSequence, (String) charSequence2, 0, z, 2, null) >= 0) {
                return true;
            }
        } else if (p3(charSequence, charSequence2, 0, charSequence.length(), z, false, 16, null) >= 0) {
            return true;
        }
        return false;
    }

    @d
    public static final CharSequence S3(@d CharSequence charSequence, int i2, char c2) {
        if (i2 >= 0) {
            if (i2 <= charSequence.length()) {
                return charSequence.subSequence(0, charSequence.length());
            }
            StringBuilder sb = new StringBuilder(i2);
            int length = i2 - charSequence.length();
            int i3 = 1;
            if (1 <= length) {
                while (true) {
                    sb.append(c2);
                    if (i3 == length) {
                        break;
                    }
                    i3++;
                }
            }
            sb.append(charSequence);
            return sb;
        }
        throw new IllegalArgumentException("Desired length " + i2 + " is less than zero.");
    }

    public static /* synthetic */ List S4(CharSequence charSequence, String[] strArr, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z = false;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return O4(charSequence, strArr, z, i2);
    }

    @d
    public static final String S5(@d String str, @d char... cArr) {
        CharSequence charSequence;
        int length = str.length();
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                charSequence = "";
                break;
            } else if (!ArraysKt___ArraysKt.K7(cArr, str.charAt(i2))) {
                charSequence = str.subSequence(i2, str.length());
                break;
            } else {
                i2++;
            }
        }
        return charSequence.toString();
    }

    @f
    private static final boolean T2(CharSequence charSequence, Regex regex) {
        return regex.containsMatchIn(charSequence);
    }

    @d
    public static final String T3(@d String str, int i2, char c2) {
        return S3(str, i2, c2).toString();
    }

    @d
    public static final m<String> T4(@d CharSequence charSequence, @d char[] cArr, boolean z, int i2) {
        return SequencesKt___SequencesKt.d1(Y3(charSequence, cArr, 0, z, i2, 2, null), new StringsKt__StringsKt$splitToSequence$2(charSequence));
    }

    public static /* synthetic */ boolean U2(CharSequence charSequence, char c2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return R2(charSequence, c2, z);
    }

    public static /* synthetic */ CharSequence U3(CharSequence charSequence, int i2, char c2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            c2 = ' ';
        }
        return S3(charSequence, i2, c2);
    }

    @d
    public static final m<String> U4(@d CharSequence charSequence, @d String[] strArr, boolean z, int i2) {
        return SequencesKt___SequencesKt.d1(Z3(charSequence, strArr, 0, z, i2, 2, null), new StringsKt__StringsKt$splitToSequence$1(charSequence));
    }

    public static /* synthetic */ boolean V2(CharSequence charSequence, CharSequence charSequence2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return S2(charSequence, charSequence2, z);
    }

    public static /* synthetic */ String V3(String str, int i2, char c2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            c2 = ' ';
        }
        return T3(str, i2, c2);
    }

    public static /* synthetic */ m V4(CharSequence charSequence, char[] cArr, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z = false;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return T4(charSequence, cArr, z, i2);
    }

    public static final boolean W2(@e CharSequence charSequence, @e CharSequence charSequence2) {
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return u.K1((String) charSequence, (String) charSequence2, true);
        }
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
            return false;
        }
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!c.J(charSequence.charAt(i2), charSequence2.charAt(i2), true)) {
                return false;
            }
        }
        return true;
    }

    private static final m<k> W3(CharSequence charSequence, char[] cArr, int i2, boolean z, int i3) {
        if (i3 >= 0) {
            return new h.t2.f(charSequence, i2, i3, new StringsKt__StringsKt$rangesDelimitedBy$2(cArr, z));
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i3 + '.').toString());
    }

    public static /* synthetic */ m W4(CharSequence charSequence, String[] strArr, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z = false;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return U4(charSequence, strArr, z, i2);
    }

    public static final boolean X2(@e CharSequence charSequence, @e CharSequence charSequence2) {
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return f0.g(charSequence, charSequence2);
        }
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
            return false;
        }
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (charSequence.charAt(i2) != charSequence2.charAt(i2)) {
                return false;
            }
        }
        return true;
    }

    private static final m<k> X3(CharSequence charSequence, String[] strArr, int i2, boolean z, int i3) {
        if (i3 >= 0) {
            return new h.t2.f(charSequence, i2, i3, new StringsKt__StringsKt$rangesDelimitedBy$4(n.t(strArr), z));
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i3 + '.').toString());
    }

    public static final boolean X4(@d CharSequence charSequence, char c2, boolean z) {
        return charSequence.length() > 0 && c.J(charSequence.charAt(0), c2, z);
    }

    public static final boolean Y2(@d CharSequence charSequence, char c2, boolean z) {
        return charSequence.length() > 0 && c.J(charSequence.charAt(i3(charSequence)), c2, z);
    }

    public static /* synthetic */ m Y3(CharSequence charSequence, char[] cArr, int i2, boolean z, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            z = false;
        }
        if ((i4 & 8) != 0) {
            i3 = 0;
        }
        return W3(charSequence, cArr, i2, z, i3);
    }

    public static final boolean Y4(@d CharSequence charSequence, @d CharSequence charSequence2, int i2, boolean z) {
        if (!z && (charSequence instanceof String) && (charSequence2 instanceof String)) {
            return u.t2((String) charSequence, (String) charSequence2, i2, false, 4, null);
        }
        return a4(charSequence, i2, charSequence2, 0, charSequence2.length(), z);
    }

    public static final boolean Z2(@d CharSequence charSequence, @d CharSequence charSequence2, boolean z) {
        if (!z && (charSequence instanceof String) && (charSequence2 instanceof String)) {
            return u.J1((String) charSequence, (String) charSequence2, false, 2, null);
        }
        return a4(charSequence, charSequence.length() - charSequence2.length(), charSequence2, 0, charSequence2.length(), z);
    }

    public static /* synthetic */ m Z3(CharSequence charSequence, String[] strArr, int i2, boolean z, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            z = false;
        }
        if ((i4 & 8) != 0) {
            i3 = 0;
        }
        return X3(charSequence, strArr, i2, z, i3);
    }

    public static final boolean Z4(@d CharSequence charSequence, @d CharSequence charSequence2, boolean z) {
        if (!z && (charSequence instanceof String) && (charSequence2 instanceof String)) {
            return u.u2((String) charSequence, (String) charSequence2, false, 2, null);
        }
        return a4(charSequence, 0, charSequence2, 0, charSequence2.length(), z);
    }

    public static /* synthetic */ boolean a3(CharSequence charSequence, char c2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return Y2(charSequence, c2, z);
    }

    public static final boolean a4(@d CharSequence charSequence, int i2, @d CharSequence charSequence2, int i3, int i4, boolean z) {
        if (i3 < 0 || i2 < 0 || i2 > charSequence.length() - i4 || i3 > charSequence2.length() - i4) {
            return false;
        }
        for (int i5 = 0; i5 < i4; i5++) {
            if (!c.J(charSequence.charAt(i2 + i5), charSequence2.charAt(i3 + i5), z)) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ boolean a5(CharSequence charSequence, char c2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return X4(charSequence, c2, z);
    }

    public static /* synthetic */ boolean b3(CharSequence charSequence, CharSequence charSequence2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return Z2(charSequence, charSequence2, z);
    }

    @d
    public static final CharSequence b4(@d CharSequence charSequence, @d CharSequence charSequence2) {
        if (c5(charSequence, charSequence2, false, 2, null)) {
            return charSequence.subSequence(charSequence2.length(), charSequence.length());
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    public static /* synthetic */ boolean b5(CharSequence charSequence, CharSequence charSequence2, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z = false;
        }
        return Y4(charSequence, charSequence2, i2, z);
    }

    @e
    public static final Pair<Integer, String> c3(@d CharSequence charSequence, @d Collection<String> collection, int i2, boolean z) {
        return d3(charSequence, collection, i2, z, false);
    }

    @d
    public static final String c4(@d String str, @d CharSequence charSequence) {
        return c5(str, charSequence, false, 2, null) ? str.substring(charSequence.length()) : str;
    }

    public static /* synthetic */ boolean c5(CharSequence charSequence, CharSequence charSequence2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return Z4(charSequence, charSequence2, z);
    }

    public static final Pair<Integer, String> d3(CharSequence charSequence, Collection<String> collection, int i2, boolean z, boolean z2) {
        Object obj;
        Object obj2;
        if (!z && collection.size() == 1) {
            String str = (String) CollectionsKt___CollectionsKt.S4(collection);
            int r3 = !z2 ? r3(charSequence, str, i2, false, 4, null) : F3(charSequence, str, i2, false, 4, null);
            if (r3 < 0) {
                return null;
            }
            return z0.a(Integer.valueOf(r3), str);
        }
        i kVar = !z2 ? new k(q.n(i2, 0), charSequence.length()) : q.W(q.u(i2, i3(charSequence)), 0);
        if (charSequence instanceof String) {
            int d2 = kVar.d();
            int f2 = kVar.f();
            int g2 = kVar.g();
            if (g2 < 0 ? d2 >= f2 : d2 <= f2) {
                while (true) {
                    Iterator<T> it = collection.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj2 = null;
                            break;
                        }
                        obj2 = it.next();
                        String str2 = (String) obj2;
                        if (u.d2(str2, 0, (String) charSequence, d2, str2.length(), z)) {
                            break;
                        }
                    }
                    String str3 = (String) obj2;
                    if (str3 == null) {
                        if (d2 == f2) {
                            break;
                        }
                        d2 += g2;
                    } else {
                        return z0.a(Integer.valueOf(d2), str3);
                    }
                }
            }
        } else {
            int d3 = kVar.d();
            int f3 = kVar.f();
            int g3 = kVar.g();
            if (g3 < 0 ? d3 >= f3 : d3 <= f3) {
                while (true) {
                    Iterator<T> it2 = collection.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it2.next();
                        String str4 = (String) obj;
                        if (a4(str4, 0, charSequence, d3, str4.length(), z)) {
                            break;
                        }
                    }
                    String str5 = (String) obj;
                    if (str5 == null) {
                        if (d3 == f3) {
                            break;
                        }
                        d3 += g3;
                    } else {
                        return z0.a(Integer.valueOf(d3), str5);
                    }
                }
            }
        }
        return null;
    }

    @d
    public static final CharSequence d4(@d CharSequence charSequence, int i2, int i3) {
        if (i3 >= i2) {
            if (i3 == i2) {
                return charSequence.subSequence(0, charSequence.length());
            }
            StringBuilder sb = new StringBuilder(charSequence.length() - (i3 - i2));
            sb.append(charSequence, 0, i2);
            sb.append(charSequence, i3, charSequence.length());
            return sb;
        }
        throw new IndexOutOfBoundsException("End index (" + i3 + ") is less than start index (" + i2 + ").");
    }

    @d
    public static final CharSequence d5(@d CharSequence charSequence, @d k kVar) {
        return charSequence.subSequence(kVar.getStart().intValue(), kVar.getEndInclusive().intValue() + 1);
    }

    public static /* synthetic */ Pair e3(CharSequence charSequence, Collection collection, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return c3(charSequence, collection, i2, z);
    }

    @d
    public static final CharSequence e4(@d CharSequence charSequence, @d k kVar) {
        return d4(charSequence, kVar.getStart().intValue(), kVar.getEndInclusive().intValue() + 1);
    }

    @f
    @h.i(message = "Use parameters named startIndex and endIndex.", replaceWith = @q0(expression = "subSequence(startIndex = start, endIndex = end)", imports = {}))
    private static final CharSequence e5(String str, int i2, int i3) {
        return str.subSequence(i2, i3);
    }

    @e
    public static final Pair<Integer, String> f3(@d CharSequence charSequence, @d Collection<String> collection, int i2, boolean z) {
        return d3(charSequence, collection, i2, z, true);
    }

    @f
    private static final String f4(String str, int i2, int i3) {
        Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.CharSequence");
        return d4(str, i2, i3).toString();
    }

    @f
    private static final String f5(CharSequence charSequence, int i2, int i3) {
        return charSequence.subSequence(i2, i3).toString();
    }

    public static /* synthetic */ Pair g3(CharSequence charSequence, Collection collection, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = i3(charSequence);
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return f3(charSequence, collection, i2, z);
    }

    @f
    private static final String g4(String str, k kVar) {
        Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.CharSequence");
        return e4(str, kVar).toString();
    }

    @d
    public static final String g5(@d CharSequence charSequence, @d k kVar) {
        return charSequence.subSequence(kVar.getStart().intValue(), kVar.getEndInclusive().intValue() + 1).toString();
    }

    @d
    public static final k h3(@d CharSequence charSequence) {
        return new k(0, charSequence.length() - 1);
    }

    @d
    public static final CharSequence h4(@d CharSequence charSequence, @d CharSequence charSequence2) {
        if (b3(charSequence, charSequence2, false, 2, null)) {
            return charSequence.subSequence(0, charSequence.length() - charSequence2.length());
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    @d
    public static final String h5(@d String str, @d k kVar) {
        return str.substring(kVar.getStart().intValue(), kVar.getEndInclusive().intValue() + 1);
    }

    public static final int i3(@d CharSequence charSequence) {
        return charSequence.length() - 1;
    }

    @d
    public static final String i4(@d String str, @d CharSequence charSequence) {
        return b3(str, charSequence, false, 2, null) ? str.substring(0, str.length() - charSequence.length()) : str;
    }

    public static /* synthetic */ String i5(CharSequence charSequence, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = charSequence.length();
        }
        return charSequence.subSequence(i2, i3).toString();
    }

    public static final boolean j3(@d CharSequence charSequence, int i2) {
        return i2 >= 0 && charSequence.length() + (-2) >= i2 && Character.isHighSurrogate(charSequence.charAt(i2)) && Character.isLowSurrogate(charSequence.charAt(i2 + 1));
    }

    @d
    public static final CharSequence j4(@d CharSequence charSequence, @d CharSequence charSequence2) {
        return k4(charSequence, charSequence2, charSequence2);
    }

    @d
    public static final String j5(@d String str, char c2, @d String str2) {
        int q3 = q3(str, c2, 0, false, 6, null);
        return q3 == -1 ? str2 : str.substring(q3 + 1, str.length());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @f
    @s0(version = "1.3")
    private static final <C extends CharSequence & R, R> R k3(C c2, h.k2.u.a<? extends R> aVar) {
        return u.U1(c2) ? aVar.invoke() : c2;
    }

    @d
    public static final CharSequence k4(@d CharSequence charSequence, @d CharSequence charSequence2, @d CharSequence charSequence3) {
        if (charSequence.length() >= charSequence2.length() + charSequence3.length() && c5(charSequence, charSequence2, false, 2, null) && b3(charSequence, charSequence3, false, 2, null)) {
            return charSequence.subSequence(charSequence2.length(), charSequence.length() - charSequence3.length());
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    @d
    public static final String k5(@d String str, @d String str2, @d String str3) {
        int r3 = r3(str, str2, 0, false, 6, null);
        return r3 == -1 ? str3 : str.substring(r3 + str2.length(), str.length());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @f
    @s0(version = "1.3")
    private static final <C extends CharSequence & R, R> R l3(C c2, h.k2.u.a<? extends R> aVar) {
        return c2.length() == 0 ? aVar.invoke() : c2;
    }

    @d
    public static final String l4(@d String str, @d CharSequence charSequence) {
        return m4(str, charSequence, charSequence);
    }

    public static /* synthetic */ String l5(String str, char c2, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = str;
        }
        return j5(str, c2, str2);
    }

    public static final int m3(@d CharSequence charSequence, char c2, int i2, boolean z) {
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(c2, i2);
        }
        return t3(charSequence, new char[]{c2}, i2, z);
    }

    @d
    public static final String m4(@d String str, @d CharSequence charSequence, @d CharSequence charSequence2) {
        return (str.length() >= charSequence.length() + charSequence2.length() && c5(str, charSequence, false, 2, null) && b3(str, charSequence2, false, 2, null)) ? str.substring(charSequence.length(), str.length() - charSequence2.length()) : str;
    }

    public static /* synthetic */ String m5(String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str3 = str;
        }
        return k5(str, str2, str3);
    }

    public static final int n3(@d CharSequence charSequence, @d String str, int i2, boolean z) {
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(str, i2);
        }
        return p3(charSequence, str, i2, charSequence.length(), z, false, 16, null);
    }

    @f
    private static final String n4(CharSequence charSequence, Regex regex, String str) {
        return regex.replace(charSequence, str);
    }

    @d
    public static final String n5(@d String str, char c2, @d String str2) {
        int E3 = E3(str, c2, 0, false, 6, null);
        return E3 == -1 ? str2 : str.substring(E3 + 1, str.length());
    }

    private static final int o3(CharSequence charSequence, CharSequence charSequence2, int i2, int i3, boolean z, boolean z2) {
        i W;
        if (!z2) {
            W = new k(q.n(i2, 0), q.u(i3, charSequence.length()));
        } else {
            W = q.W(q.u(i2, i3(charSequence)), q.n(i3, 0));
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int d2 = W.d();
            int f2 = W.f();
            int g2 = W.g();
            if (g2 >= 0) {
                if (d2 > f2) {
                    return -1;
                }
            } else if (d2 < f2) {
                return -1;
            }
            while (!u.d2((String) charSequence2, 0, (String) charSequence, d2, charSequence2.length(), z)) {
                if (d2 == f2) {
                    return -1;
                }
                d2 += g2;
            }
            return d2;
        }
        int d3 = W.d();
        int f3 = W.f();
        int g3 = W.g();
        if (g3 >= 0) {
            if (d3 > f3) {
                return -1;
            }
        } else if (d3 < f3) {
            return -1;
        }
        while (!a4(charSequence2, 0, charSequence, d3, charSequence2.length(), z)) {
            if (d3 == f3) {
                return -1;
            }
            d3 += g3;
        }
        return d3;
    }

    @f
    private static final String o4(CharSequence charSequence, Regex regex, l<? super h.t2.k, ? extends CharSequence> lVar) {
        return regex.replace(charSequence, lVar);
    }

    @d
    public static final String o5(@d String str, @d String str2, @d String str3) {
        int F3 = F3(str, str2, 0, false, 6, null);
        return F3 == -1 ? str3 : str.substring(F3 + str2.length(), str.length());
    }

    public static /* synthetic */ int p3(CharSequence charSequence, CharSequence charSequence2, int i2, int i3, boolean z, boolean z2, int i4, Object obj) {
        return o3(charSequence, charSequence2, i2, i3, z, (i4 & 16) != 0 ? false : z2);
    }

    @d
    public static final String p4(@d String str, char c2, @d String str2, @d String str3) {
        int q3 = q3(str, c2, 0, false, 6, null);
        return q3 == -1 ? str3 : I4(str, q3 + 1, str.length(), str2).toString();
    }

    public static /* synthetic */ String p5(String str, char c2, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = str;
        }
        return n5(str, c2, str2);
    }

    public static /* synthetic */ int q3(CharSequence charSequence, char c2, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return m3(charSequence, c2, i2, z);
    }

    @d
    public static final String q4(@d String str, @d String str2, @d String str3, @d String str4) {
        int r3 = r3(str, str2, 0, false, 6, null);
        return r3 == -1 ? str4 : I4(str, r3 + str2.length(), str.length(), str3).toString();
    }

    public static /* synthetic */ String q5(String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str3 = str;
        }
        return o5(str, str2, str3);
    }

    public static /* synthetic */ int r3(CharSequence charSequence, String str, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return n3(charSequence, str, i2, z);
    }

    public static /* synthetic */ String r4(String str, char c2, String str2, String str3, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str3 = str;
        }
        return p4(str, c2, str2, str3);
    }

    @d
    public static final String r5(@d String str, char c2, @d String str2) {
        int q3 = q3(str, c2, 0, false, 6, null);
        return q3 == -1 ? str2 : str.substring(0, q3);
    }

    public static final int s3(@d CharSequence charSequence, @d Collection<String> collection, int i2, boolean z) {
        Integer first;
        Pair<Integer, String> d3 = d3(charSequence, collection, i2, z, false);
        if (d3 == null || (first = d3.getFirst()) == null) {
            return -1;
        }
        return first.intValue();
    }

    public static /* synthetic */ String s4(String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str4 = str;
        }
        return q4(str, str2, str3, str4);
    }

    @d
    public static final String s5(@d String str, @d String str2, @d String str3) {
        int r3 = r3(str, str2, 0, false, 6, null);
        return r3 == -1 ? str3 : str.substring(0, r3);
    }

    public static final int t3(@d CharSequence charSequence, @d char[] cArr, int i2, boolean z) {
        boolean z2;
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(ArraysKt___ArraysKt.ss(cArr), i2);
        }
        int n = q.n(i2, 0);
        int i3 = i3(charSequence);
        if (n > i3) {
            return -1;
        }
        while (true) {
            char charAt = charSequence.charAt(n);
            int length = cArr.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length) {
                    z2 = false;
                    break;
                } else if (c.J(cArr[i4], charAt, z)) {
                    z2 = true;
                    break;
                } else {
                    i4++;
                }
            }
            if (z2) {
                return n;
            }
            if (n == i3) {
                return -1;
            }
            n++;
        }
    }

    @d
    public static final String t4(@d String str, char c2, @d String str2, @d String str3) {
        int E3 = E3(str, c2, 0, false, 6, null);
        return E3 == -1 ? str3 : I4(str, E3 + 1, str.length(), str2).toString();
    }

    public static /* synthetic */ String t5(String str, char c2, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = str;
        }
        return r5(str, c2, str2);
    }

    public static /* synthetic */ int u3(CharSequence charSequence, Collection collection, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return s3(charSequence, collection, i2, z);
    }

    @d
    public static final String u4(@d String str, @d String str2, @d String str3, @d String str4) {
        int F3 = F3(str, str2, 0, false, 6, null);
        return F3 == -1 ? str4 : I4(str, F3 + str2.length(), str.length(), str3).toString();
    }

    public static /* synthetic */ String u5(String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str3 = str;
        }
        return s5(str, str2, str3);
    }

    public static /* synthetic */ int v3(CharSequence charSequence, char[] cArr, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return t3(charSequence, cArr, i2, z);
    }

    public static /* synthetic */ String v4(String str, char c2, String str2, String str3, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str3 = str;
        }
        return t4(str, c2, str2, str3);
    }

    @d
    public static final String v5(@d String str, char c2, @d String str2) {
        int E3 = E3(str, c2, 0, false, 6, null);
        return E3 == -1 ? str2 : str.substring(0, E3);
    }

    @f
    private static final boolean w3(CharSequence charSequence) {
        return charSequence.length() == 0;
    }

    public static /* synthetic */ String w4(String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str4 = str;
        }
        return u4(str, str2, str3, str4);
    }

    @d
    public static final String w5(@d String str, @d String str2, @d String str3) {
        int F3 = F3(str, str2, 0, false, 6, null);
        return F3 == -1 ? str3 : str.substring(0, F3);
    }

    @f
    private static final boolean x3(CharSequence charSequence) {
        return !u.U1(charSequence);
    }

    @d
    public static final String x4(@d String str, char c2, @d String str2, @d String str3) {
        int q3 = q3(str, c2, 0, false, 6, null);
        return q3 == -1 ? str3 : I4(str, 0, q3, str2).toString();
    }

    public static /* synthetic */ String x5(String str, char c2, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = str;
        }
        return v5(str, c2, str2);
    }

    @f
    private static final boolean y3(CharSequence charSequence) {
        return charSequence.length() > 0;
    }

    @d
    public static final String y4(@d String str, @d String str2, @d String str3, @d String str4) {
        int r3 = r3(str, str2, 0, false, 6, null);
        return r3 == -1 ? str4 : I4(str, 0, r3, str3).toString();
    }

    public static /* synthetic */ String y5(String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str3 = str;
        }
        return w5(str, str2, str3);
    }

    @f
    private static final boolean z3(CharSequence charSequence) {
        return charSequence == null || u.U1(charSequence);
    }

    public static /* synthetic */ String z4(String str, char c2, String str2, String str3, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str3 = str;
        }
        return x4(str, c2, str2, str3);
    }

    @s0(version = "1.5")
    public static final boolean z5(@d String str) {
        int hashCode = str.hashCode();
        if (hashCode != 3569038) {
            if (hashCode == 97196323 && str.equals(Bugly.SDK_IS_DEV)) {
                return false;
            }
        } else if (str.equals("true")) {
            return true;
        }
        throw new IllegalArgumentException("The string doesn't represent a boolean value: " + str);
    }
}

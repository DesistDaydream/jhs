package h.a2;

import androidx.exifinterface.media.ExifInterface;
import h.t1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000f\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001aJ\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010\u0005\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0086\bø\u0001\u0000\u001a$\u0010\b\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004\u001aJ\u0010\b\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010\u0005\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0086\bø\u0001\u0000\u001a9\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070\n\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004H\u0087\b\u001a6\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070\f\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004\u001a'\u0010\r\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004H\u0087\b\u001aJ\u0010\r\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010\u0005\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0086\bø\u0001\u0000\u001a[\u0010\u000f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\b\b\u0002\u0010\u0010*\u00020\u0011*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042 \u0010\u0012\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0006\u0012\u0004\u0018\u0001H\u00100\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001a]\u0010\u0014\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\b\b\u0002\u0010\u0010*\u00020\u0011*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042 \u0010\u0012\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0006\u0012\u0004\u0018\u0001H\u00100\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001a\\\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0016\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0010*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042$\u0010\u0012\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\n0\u0006H\u0086\bø\u0001\u0000\u001aa\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0016\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0010*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042$\u0010\u0012\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\f0\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\b\u0017\u001au\u0010\u0018\u001a\u0002H\u0019\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0010\"\u0010\b\u0003\u0010\u0019*\n\u0012\u0006\b\u0000\u0012\u0002H\u00100\u001a*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u001b\u001a\u0002H\u00192$\u0010\u0012\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\n0\u0006H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001aw\u0010\u0018\u001a\u0002H\u0019\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0010\"\u0010\b\u0003\u0010\u0019*\n\u0012\u0006\b\u0000\u0012\u0002H\u00100\u001a*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u001b\u001a\u0002H\u00192$\u0010\u0012\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\f0\u0006H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001c\u001aJ\u0010\u001e\u001a\u00020\u001f\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010 \u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020\u001f0\u0006H\u0087\bø\u0001\u0000\u001aV\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0016\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0010*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010\u0012\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0086\bø\u0001\u0000\u001a\\\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0016\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\b\b\u0002\u0010\u0010*\u00020\u0011*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042 \u0010\u0012\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0006\u0012\u0004\u0018\u0001H\u00100\u0006H\u0086\bø\u0001\u0000\u001au\u0010#\u001a\u0002H\u0019\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\b\b\u0002\u0010\u0010*\u00020\u0011\"\u0010\b\u0003\u0010\u0019*\n\u0012\u0006\b\u0000\u0012\u0002H\u00100\u001a*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u001b\u001a\u0002H\u00192 \u0010\u0012\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0006\u0012\u0004\u0018\u0001H\u00100\u0006H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001ao\u0010$\u001a\u0002H\u0019\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0010\"\u0010\b\u0003\u0010\u0019*\n\u0012\u0006\b\u0000\u0012\u0002H\u00100\u001a*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u001b\u001a\u0002H\u00192\u001e\u0010\u0012\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001ah\u0010%\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100&*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\bø\u0001\u0000\u001ah\u0010(\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100&*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\bø\u0001\u0000\u001a_\u0010)\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100&*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010*\u001aJ\u0010)\u001a\u00020+\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020+0\u0006H\u0087\bø\u0001\u0000\u001aJ\u0010)\u001a\u00020,\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020,0\u0006H\u0087\bø\u0001\u0000\u001aa\u0010-\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100&*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010*\u001aQ\u0010-\u001a\u0004\u0018\u00010+\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020+0\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010.\u001aQ\u0010-\u001a\u0004\u0018\u00010,\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020,0\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010/\u001aq\u00100\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0010*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001a\u00101\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u001002j\n\u0012\u0006\b\u0000\u0012\u0002H\u0010`32\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\u00104\u001as\u00105\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0010*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001a\u00101\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u001002j\n\u0012\u0006\b\u0000\u0012\u0002H\u0010`32\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\u00104\u001ai\u00106\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000422\u00101\u001a.\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000702j\u0016\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007`3H\u0087\b\u001ai\u00107\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000422\u00101\u001a.\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000702j\u0016\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007`3H\u0087\b\u001ah\u00108\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100&*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\bø\u0001\u0000\u001ah\u00109\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100&*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\bø\u0001\u0000\u001a_\u0010:\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100&*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010*\u001aJ\u0010:\u001a\u00020+\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020+0\u0006H\u0087\bø\u0001\u0000\u001aJ\u0010:\u001a\u00020,\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020,0\u0006H\u0087\bø\u0001\u0000\u001aa\u0010;\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100&*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010*\u001aQ\u0010;\u001a\u0004\u0018\u00010+\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020+0\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010.\u001aQ\u0010;\u001a\u0004\u0018\u00010,\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020,0\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010/\u001aq\u0010<\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0010*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001a\u00101\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u001002j\n\u0012\u0006\b\u0000\u0012\u0002H\u0010`32\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\u00104\u001as\u0010=\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0010*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001a\u00101\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u001002j\n\u0012\u0006\b\u0000\u0012\u0002H\u0010`32\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\u00104\u001ah\u0010>\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000422\u00101\u001a.\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000702j\u0016\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007`3H\u0007\u001ai\u0010?\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000422\u00101\u001a.\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000702j\u0016\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007`3H\u0087\b\u001a$\u0010@\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004\u001aJ\u0010@\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010\u0005\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0086\bø\u0001\u0000\u001aY\u0010A\u001a\u0002HB\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0016\b\u0002\u0010B*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004*\u0002HB2\u001e\u0010 \u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020\u001f0\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010C\u001an\u0010D\u001a\u0002HB\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0016\b\u0002\u0010B*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004*\u0002HB23\u0010 \u001a/\u0012\u0013\u0012\u00110\u000e¢\u0006\f\bF\u0012\b\bG\u0012\u0004\b\b(H\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020\u001f0EH\u0087\bø\u0001\u0000¢\u0006\u0002\u0010I\u001a6\u0010J\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030K0\u0016\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006L"}, d2 = {"all", "", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "predicate", "Lkotlin/Function1;", "", k.b.a.a.n.n.c.b, "asIterable", "", "asSequence", "Lkotlin/sequences/Sequence;", "count", "", "firstNotNullOf", "R", "", "transform", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "firstNotNullOfOrNull", "flatMap", "", "flatMapSequence", "flatMapTo", "C", "", "destination", "(Ljava/util/Map;Ljava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "flatMapSequenceTo", "forEach", "", "action", "map", "mapNotNull", "mapNotNullTo", "mapTo", "maxBy", "", "selector", "maxByOrNull", "maxOf", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/lang/Comparable;", "", "", "maxOfOrNull", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/lang/Double;", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/lang/Float;", "maxOfWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/util/Map;Ljava/util/Comparator;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "maxOfWithOrNull", "maxWith", "maxWithOrNull", "minBy", "minByOrNull", "minOf", "minOfOrNull", "minOfWith", "minOfWithOrNull", "minWith", "minWithOrNull", "none", "onEach", "M", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "onEachIndexed", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "index", "(Ljava/util/Map;Lkotlin/jvm/functions/Function2;)Ljava/util/Map;", "toList", "Lkotlin/Pair;", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/collections/MapsKt")
/* loaded from: classes3.dex */
public class u0 extends t0 {
    @h.g2.f
    @h.s0(version = "1.4")
    private static final <K, V> Map.Entry<K, V> A1(Map<? extends K, ? extends V> map, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        return (Map.Entry) CollectionsKt___CollectionsKt.b4(map.entrySet(), comparator);
    }

    public static final <K, V> boolean B1(@k.e.a.d Map<? extends K, ? extends V> map) {
        return map.isEmpty();
    }

    public static final <K, V> boolean C1(@k.e.a.d Map<? extends K, ? extends V> map, @k.e.a.d h.k2.u.l<? super Map.Entry<? extends K, ? extends V>, Boolean> lVar) {
        if (map.isEmpty()) {
            return true;
        }
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (lVar.invoke(entry).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @h.s0(version = "1.1")
    @k.e.a.d
    public static final <K, V, M extends Map<? extends K, ? extends V>> M D1(@k.e.a.d M m2, @k.e.a.d h.k2.u.l<? super Map.Entry<? extends K, ? extends V>, t1> lVar) {
        for (Map.Entry<K, V> entry : m2.entrySet()) {
            lVar.invoke(entry);
        }
        return m2;
    }

    @h.s0(version = "1.4")
    @k.e.a.d
    public static final <K, V, M extends Map<? extends K, ? extends V>> M E1(@k.e.a.d M m2, @k.e.a.d h.k2.u.p<? super Integer, ? super Map.Entry<? extends K, ? extends V>, t1> pVar) {
        int i2 = 0;
        for (Object obj : m2.entrySet()) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            pVar.invoke(Integer.valueOf(i2), obj);
            i2 = i3;
        }
        return m2;
    }

    @k.e.a.d
    public static final <K, V> List<Pair<K, V>> F1(@k.e.a.d Map<? extends K, ? extends V> map) {
        if (map.size() == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return CollectionsKt__CollectionsKt.E();
        }
        Map.Entry<? extends K, ? extends V> next = it.next();
        if (!it.hasNext()) {
            return t.k(new Pair(next.getKey(), next.getValue()));
        }
        ArrayList arrayList = new ArrayList(map.size());
        arrayList.add(new Pair(next.getKey(), next.getValue()));
        do {
            Map.Entry<? extends K, ? extends V> next2 = it.next();
            arrayList.add(new Pair(next2.getKey(), next2.getValue()));
        } while (it.hasNext());
        return arrayList;
    }

    public static final <K, V> boolean L0(@k.e.a.d Map<? extends K, ? extends V> map, @k.e.a.d h.k2.u.l<? super Map.Entry<? extends K, ? extends V>, Boolean> lVar) {
        if (map.isEmpty()) {
            return true;
        }
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (!lVar.invoke(entry).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <K, V> boolean M0(@k.e.a.d Map<? extends K, ? extends V> map) {
        return !map.isEmpty();
    }

    public static final <K, V> boolean N0(@k.e.a.d Map<? extends K, ? extends V> map, @k.e.a.d h.k2.u.l<? super Map.Entry<? extends K, ? extends V>, Boolean> lVar) {
        if (map.isEmpty()) {
            return false;
        }
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (lVar.invoke(entry).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @h.g2.f
    private static final <K, V> Iterable<Map.Entry<K, V>> O0(Map<? extends K, ? extends V> map) {
        return map.entrySet();
    }

    @k.e.a.d
    public static final <K, V> h.q2.m<Map.Entry<K, V>> P0(@k.e.a.d Map<? extends K, ? extends V> map) {
        return CollectionsKt___CollectionsKt.n1(map.entrySet());
    }

    @h.g2.f
    private static final <K, V> int Q0(Map<? extends K, ? extends V> map) {
        return map.size();
    }

    public static final <K, V> int R0(@k.e.a.d Map<? extends K, ? extends V> map, @k.e.a.d h.k2.u.l<? super Map.Entry<? extends K, ? extends V>, Boolean> lVar) {
        int i2 = 0;
        if (map.isEmpty()) {
            return 0;
        }
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (lVar.invoke(entry).booleanValue()) {
                i2++;
            }
        }
        return i2;
    }

    @h.g2.f
    @h.s0(version = "1.5")
    private static final <K, V, R> R S0(Map<? extends K, ? extends V> map, h.k2.u.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        R r;
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                r = null;
                break;
            }
            r = lVar.invoke(it.next());
            if (r != null) {
                break;
            }
        }
        if (r != null) {
            return r;
        }
        throw new NoSuchElementException("No element of the map was transformed to a non-null value.");
    }

    @h.g2.f
    @h.s0(version = "1.5")
    private static final <K, V, R> R T0(Map<? extends K, ? extends V> map, h.k2.u.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            R invoke = lVar.invoke(entry);
            if (invoke != null) {
                return invoke;
            }
        }
        return null;
    }

    @k.e.a.d
    public static final <K, V, R> List<R> U0(@k.e.a.d Map<? extends K, ? extends V> map, @k.e.a.d h.k2.u.l<? super Map.Entry<? extends K, ? extends V>, ? extends Iterable<? extends R>> lVar) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            y.q0(arrayList, lVar.invoke(entry));
        }
        return arrayList;
    }

    @h.k2.g(name = "flatMapSequence")
    @h.j0
    @h.s0(version = "1.4")
    @k.e.a.d
    public static final <K, V, R> List<R> V0(@k.e.a.d Map<? extends K, ? extends V> map, @k.e.a.d h.k2.u.l<? super Map.Entry<? extends K, ? extends V>, ? extends h.q2.m<? extends R>> lVar) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            y.r0(arrayList, lVar.invoke(entry));
        }
        return arrayList;
    }

    @h.k2.g(name = "flatMapSequenceTo")
    @h.j0
    @h.s0(version = "1.4")
    @k.e.a.d
    public static final <K, V, R, C extends Collection<? super R>> C W0(@k.e.a.d Map<? extends K, ? extends V> map, @k.e.a.d C c2, @k.e.a.d h.k2.u.l<? super Map.Entry<? extends K, ? extends V>, ? extends h.q2.m<? extends R>> lVar) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            y.r0(c2, lVar.invoke(entry));
        }
        return c2;
    }

    @k.e.a.d
    public static final <K, V, R, C extends Collection<? super R>> C X0(@k.e.a.d Map<? extends K, ? extends V> map, @k.e.a.d C c2, @k.e.a.d h.k2.u.l<? super Map.Entry<? extends K, ? extends V>, ? extends Iterable<? extends R>> lVar) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            y.q0(c2, lVar.invoke(entry));
        }
        return c2;
    }

    @h.g2.e
    public static final <K, V> void Y0(@k.e.a.d Map<? extends K, ? extends V> map, @k.e.a.d h.k2.u.l<? super Map.Entry<? extends K, ? extends V>, t1> lVar) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            lVar.invoke(entry);
        }
    }

    @k.e.a.d
    public static final <K, V, R> List<R> Z0(@k.e.a.d Map<? extends K, ? extends V> map, @k.e.a.d h.k2.u.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            arrayList.add(lVar.invoke(entry));
        }
        return arrayList;
    }

    @k.e.a.d
    public static final <K, V, R> List<R> a1(@k.e.a.d Map<? extends K, ? extends V> map, @k.e.a.d h.k2.u.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            R invoke = lVar.invoke(entry);
            if (invoke != null) {
                arrayList.add(invoke);
            }
        }
        return arrayList;
    }

    @k.e.a.d
    public static final <K, V, R, C extends Collection<? super R>> C b1(@k.e.a.d Map<? extends K, ? extends V> map, @k.e.a.d C c2, @k.e.a.d h.k2.u.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            R invoke = lVar.invoke(entry);
            if (invoke != null) {
                c2.add(invoke);
            }
        }
        return c2;
    }

    @k.e.a.d
    public static final <K, V, R, C extends Collection<? super R>> C c1(@k.e.a.d Map<? extends K, ? extends V> map, @k.e.a.d C c2, @k.e.a.d h.k2.u.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            c2.add(lVar.invoke(entry));
        }
        return c2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.g2.f
    @h.j(errorSince = "1.5", warningSince = "1.4")
    @h.i(message = "Use maxByOrNull instead.", replaceWith = @h.q0(expression = "this.maxByOrNull(selector)", imports = {}))
    private static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> d1(Map<? extends K, ? extends V> map, h.k2.u.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        Object obj;
        Iterator it = map.entrySet().iterator();
        if (it.hasNext()) {
            Object obj2 = (Object) it.next();
            if (it.hasNext()) {
                R invoke = lVar.invoke(obj2);
                Object obj3 = obj2;
                do {
                    Object obj4 = (Object) it.next();
                    R invoke2 = lVar.invoke(obj4);
                    obj2 = obj3;
                    if (invoke.compareTo(invoke2) < 0) {
                        invoke = invoke2;
                        obj2 = (Object) obj4;
                    }
                    obj3 = obj2;
                } while (it.hasNext());
                obj = obj2;
            } else {
                obj = obj2;
            }
        } else {
            obj = null;
        }
        return (Map.Entry) obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.g2.f
    @h.s0(version = "1.4")
    private static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> e1(Map<? extends K, ? extends V> map, h.k2.u.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        Object obj;
        Iterator it = map.entrySet().iterator();
        if (it.hasNext()) {
            Object obj2 = (Object) it.next();
            if (it.hasNext()) {
                R invoke = lVar.invoke(obj2);
                Object obj3 = obj2;
                do {
                    Object obj4 = (Object) it.next();
                    R invoke2 = lVar.invoke(obj4);
                    obj2 = obj3;
                    if (invoke.compareTo(invoke2) < 0) {
                        invoke = invoke2;
                        obj2 = (Object) obj4;
                    }
                    obj3 = obj2;
                } while (it.hasNext());
                obj = obj2;
            } else {
                obj = obj2;
            }
        } else {
            obj = null;
        }
        return (Map.Entry) obj;
    }

    @h.g2.f
    @h.j0
    @h.s0(version = "1.4")
    private static final <K, V> double f1(Map<? extends K, ? extends V> map, h.k2.u.l<? super Map.Entry<? extends K, ? extends V>, Double> lVar) {
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            double doubleValue = lVar.invoke((Object) it.next()).doubleValue();
            while (it.hasNext()) {
                doubleValue = Math.max(doubleValue, lVar.invoke((Object) it.next()).doubleValue());
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    @h.g2.f
    @h.j0
    @h.s0(version = "1.4")
    private static final <K, V> float g1(Map<? extends K, ? extends V> map, h.k2.u.l<? super Map.Entry<? extends K, ? extends V>, Float> lVar) {
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            float floatValue = lVar.invoke((Object) it.next()).floatValue();
            while (it.hasNext()) {
                floatValue = Math.max(floatValue, lVar.invoke((Object) it.next()).floatValue());
            }
            return floatValue;
        }
        throw new NoSuchElementException();
    }

    @h.g2.f
    @h.j0
    @h.s0(version = "1.4")
    private static final <K, V, R extends Comparable<? super R>> R h1(Map<? extends K, ? extends V> map, h.k2.u.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            R invoke = lVar.invoke((Object) it.next());
            while (it.hasNext()) {
                R invoke2 = lVar.invoke((Object) it.next());
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
            }
            return invoke;
        }
        throw new NoSuchElementException();
    }

    @h.g2.f
    @h.j0
    @h.s0(version = "1.4")
    private static final <K, V, R extends Comparable<? super R>> R i1(Map<? extends K, ? extends V> map, h.k2.u.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            R invoke = lVar.invoke((Object) it.next());
            while (it.hasNext()) {
                R invoke2 = lVar.invoke((Object) it.next());
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
            }
            return invoke;
        }
        return null;
    }

    @h.g2.f
    @h.j0
    @h.s0(version = "1.4")
    private static final <K, V> Double j1(Map<? extends K, ? extends V> map, h.k2.u.l<? super Map.Entry<? extends K, ? extends V>, Double> lVar) {
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            double doubleValue = lVar.invoke((Object) it.next()).doubleValue();
            while (it.hasNext()) {
                doubleValue = Math.max(doubleValue, lVar.invoke((Object) it.next()).doubleValue());
            }
            return Double.valueOf(doubleValue);
        }
        return null;
    }

    @h.g2.f
    @h.j0
    @h.s0(version = "1.4")
    private static final <K, V> Float k1(Map<? extends K, ? extends V> map, h.k2.u.l<? super Map.Entry<? extends K, ? extends V>, Float> lVar) {
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            float floatValue = lVar.invoke((Object) it.next()).floatValue();
            while (it.hasNext()) {
                floatValue = Math.max(floatValue, lVar.invoke((Object) it.next()).floatValue());
            }
            return Float.valueOf(floatValue);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.g2.f
    @h.j0
    @h.s0(version = "1.4")
    private static final <K, V, R> R l1(Map<? extends K, ? extends V> map, Comparator<? super R> comparator, h.k2.u.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            Object obj = (R) lVar.invoke((Object) it.next());
            while (it.hasNext()) {
                R invoke = lVar.invoke((Object) it.next());
                if (comparator.compare(obj, invoke) < 0) {
                    obj = invoke;
                }
            }
            return (R) obj;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.g2.f
    @h.j0
    @h.s0(version = "1.4")
    private static final <K, V, R> R m1(Map<? extends K, ? extends V> map, Comparator<? super R> comparator, h.k2.u.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            Object obj = (R) lVar.invoke((Object) it.next());
            while (it.hasNext()) {
                R invoke = lVar.invoke((Object) it.next());
                if (comparator.compare(obj, invoke) < 0) {
                    obj = (Object) invoke;
                }
            }
            return obj;
        }
        return null;
    }

    @h.g2.f
    @h.j(errorSince = "1.5", warningSince = "1.4")
    @h.i(message = "Use maxWithOrNull instead.", replaceWith = @h.q0(expression = "this.maxWithOrNull(comparator)", imports = {}))
    private static final <K, V> Map.Entry<K, V> n1(Map<? extends K, ? extends V> map, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        return (Map.Entry) CollectionsKt___CollectionsKt.J3(map.entrySet(), comparator);
    }

    @h.g2.f
    @h.s0(version = "1.4")
    private static final <K, V> Map.Entry<K, V> o1(Map<? extends K, ? extends V> map, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        return (Map.Entry) CollectionsKt___CollectionsKt.J3(map.entrySet(), comparator);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.j(errorSince = "1.5", warningSince = "1.4")
    @k.e.a.e
    @h.i(message = "Use minByOrNull instead.", replaceWith = @h.q0(expression = "this.minByOrNull(selector)", imports = {}))
    public static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> p1(@k.e.a.d Map<? extends K, ? extends V> map, @k.e.a.d h.k2.u.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        Object obj;
        Iterator it = map.entrySet().iterator();
        if (it.hasNext()) {
            Object obj2 = (Object) it.next();
            if (it.hasNext()) {
                R invoke = lVar.invoke(obj2);
                Object obj3 = obj2;
                do {
                    Object obj4 = (Object) it.next();
                    R invoke2 = lVar.invoke(obj4);
                    obj2 = obj3;
                    if (invoke.compareTo(invoke2) > 0) {
                        invoke = invoke2;
                        obj2 = (Object) obj4;
                    }
                    obj3 = obj2;
                } while (it.hasNext());
                obj = obj2;
            } else {
                obj = obj2;
            }
        } else {
            obj = null;
        }
        return (Map.Entry) obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.g2.f
    @h.s0(version = "1.4")
    private static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> q1(Map<? extends K, ? extends V> map, h.k2.u.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        Object obj;
        Iterator it = map.entrySet().iterator();
        if (it.hasNext()) {
            Object obj2 = (Object) it.next();
            if (it.hasNext()) {
                R invoke = lVar.invoke(obj2);
                Object obj3 = obj2;
                do {
                    Object obj4 = (Object) it.next();
                    R invoke2 = lVar.invoke(obj4);
                    obj2 = obj3;
                    if (invoke.compareTo(invoke2) > 0) {
                        invoke = invoke2;
                        obj2 = (Object) obj4;
                    }
                    obj3 = obj2;
                } while (it.hasNext());
                obj = obj2;
            } else {
                obj = obj2;
            }
        } else {
            obj = null;
        }
        return (Map.Entry) obj;
    }

    @h.g2.f
    @h.j0
    @h.s0(version = "1.4")
    private static final <K, V> double r1(Map<? extends K, ? extends V> map, h.k2.u.l<? super Map.Entry<? extends K, ? extends V>, Double> lVar) {
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            double doubleValue = lVar.invoke((Object) it.next()).doubleValue();
            while (it.hasNext()) {
                doubleValue = Math.min(doubleValue, lVar.invoke((Object) it.next()).doubleValue());
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    @h.g2.f
    @h.j0
    @h.s0(version = "1.4")
    private static final <K, V> float s1(Map<? extends K, ? extends V> map, h.k2.u.l<? super Map.Entry<? extends K, ? extends V>, Float> lVar) {
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            float floatValue = lVar.invoke((Object) it.next()).floatValue();
            while (it.hasNext()) {
                floatValue = Math.min(floatValue, lVar.invoke((Object) it.next()).floatValue());
            }
            return floatValue;
        }
        throw new NoSuchElementException();
    }

    @h.g2.f
    @h.j0
    @h.s0(version = "1.4")
    private static final <K, V, R extends Comparable<? super R>> R t1(Map<? extends K, ? extends V> map, h.k2.u.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            R invoke = lVar.invoke((Object) it.next());
            while (it.hasNext()) {
                R invoke2 = lVar.invoke((Object) it.next());
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
            }
            return invoke;
        }
        throw new NoSuchElementException();
    }

    @h.g2.f
    @h.j0
    @h.s0(version = "1.4")
    private static final <K, V, R extends Comparable<? super R>> R u1(Map<? extends K, ? extends V> map, h.k2.u.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            R invoke = lVar.invoke((Object) it.next());
            while (it.hasNext()) {
                R invoke2 = lVar.invoke((Object) it.next());
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
            }
            return invoke;
        }
        return null;
    }

    @h.g2.f
    @h.j0
    @h.s0(version = "1.4")
    private static final <K, V> Double v1(Map<? extends K, ? extends V> map, h.k2.u.l<? super Map.Entry<? extends K, ? extends V>, Double> lVar) {
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            double doubleValue = lVar.invoke((Object) it.next()).doubleValue();
            while (it.hasNext()) {
                doubleValue = Math.min(doubleValue, lVar.invoke((Object) it.next()).doubleValue());
            }
            return Double.valueOf(doubleValue);
        }
        return null;
    }

    @h.g2.f
    @h.j0
    @h.s0(version = "1.4")
    private static final <K, V> Float w1(Map<? extends K, ? extends V> map, h.k2.u.l<? super Map.Entry<? extends K, ? extends V>, Float> lVar) {
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            float floatValue = lVar.invoke((Object) it.next()).floatValue();
            while (it.hasNext()) {
                floatValue = Math.min(floatValue, lVar.invoke((Object) it.next()).floatValue());
            }
            return Float.valueOf(floatValue);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.g2.f
    @h.j0
    @h.s0(version = "1.4")
    private static final <K, V, R> R x1(Map<? extends K, ? extends V> map, Comparator<? super R> comparator, h.k2.u.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            Object obj = (R) lVar.invoke((Object) it.next());
            while (it.hasNext()) {
                R invoke = lVar.invoke((Object) it.next());
                if (comparator.compare(obj, invoke) > 0) {
                    obj = invoke;
                }
            }
            return (R) obj;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.g2.f
    @h.j0
    @h.s0(version = "1.4")
    private static final <K, V, R> R y1(Map<? extends K, ? extends V> map, Comparator<? super R> comparator, h.k2.u.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            Object obj = (R) lVar.invoke((Object) it.next());
            while (it.hasNext()) {
                R invoke = lVar.invoke((Object) it.next());
                if (comparator.compare(obj, invoke) > 0) {
                    obj = (Object) invoke;
                }
            }
            return obj;
        }
        return null;
    }

    @h.j(errorSince = "1.5", warningSince = "1.4")
    @k.e.a.e
    @h.i(message = "Use minWithOrNull instead.", replaceWith = @h.q0(expression = "this.minWithOrNull(comparator)", imports = {}))
    public static final <K, V> Map.Entry<K, V> z1(@k.e.a.d Map<? extends K, ? extends V> map, @k.e.a.d Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        return (Map.Entry) CollectionsKt___CollectionsKt.b4(map.entrySet(), comparator);
    }
}

package com.github.aachartmodel.aainfographics.aachartcreator;

import android.content.Context;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AAScrollablePlotArea;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AAStyle;
import com.github.aachartmodel.aainfographics.aatools.AABuilder;
import h.k2.v.u;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000y\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0003\b\u0091\u0001\u0018\u0000 Û\u00012\u00020\u0001:\u0002Û\u0001B±\u0004\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010'\u0012\u0010\b\u0002\u00101\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u000100\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u00107\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u000100\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u001b\u0012\u0010\b\u0002\u0010C\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u000100\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u001b\u0012\u0010\b\u0002\u0010I\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u000100\u0012\n\b\u0002\u0010J\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010L\u001a\u0004\u0018\u00010K¢\u0006\u0006\bÙ\u0001\u0010Ú\u0001J\u0015\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u000bJ\u0015\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\f¢\u0006\u0004\b\u0013\u0010\u000eJ\u0015\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\t¢\u0006\u0004\b\u0014\u0010\u000bJ\u0015\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u001e¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010\"\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020!¢\u0006\u0004\b\"\u0010#J\u0015\u0010%\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020$¢\u0006\u0004\b%\u0010&J\u0017\u0010(\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010'¢\u0006\u0004\b(\u0010)J\u0017\u0010*\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010'¢\u0006\u0004\b*\u0010)J\u0017\u0010+\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010'¢\u0006\u0004\b+\u0010)J\u0017\u0010,\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010'¢\u0006\u0004\b,\u0010)J\u0017\u0010-\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b-\u0010\u000bJ\u0017\u0010.\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010'¢\u0006\u0004\b.\u0010)J\u0017\u0010/\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010'¢\u0006\u0004\b/\u0010)J\u001d\u00101\u001a\u00020\u00002\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u000100¢\u0006\u0004\b1\u00102J\u0017\u00103\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010'¢\u0006\u0004\b3\u0010)J\u0015\u00104\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\f¢\u0006\u0004\b4\u0010\u000eJ\u0017\u00105\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010'¢\u0006\u0004\b5\u0010)J\u0017\u00106\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b6\u0010\bJ\u001b\u00107\u001a\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\t00¢\u0006\u0004\b7\u00108J\u0017\u00109\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b9\u0010\u001dJ\u0017\u0010:\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b:\u0010\u001dJ\u0017\u0010;\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010'¢\u0006\u0004\b;\u0010)J\u0017\u0010<\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010'¢\u0006\u0004\b<\u0010)J\u0017\u0010=\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010'¢\u0006\u0004\b=\u0010)J\u0015\u0010>\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\t¢\u0006\u0004\b>\u0010\u000bJ\u0017\u0010?\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b?\u0010\u001dJ\u0017\u0010@\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b@\u0010\u001dJ\u0017\u0010A\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\bA\u0010\u001dJ\u0017\u0010B\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010'¢\u0006\u0004\bB\u0010)J\u001b\u0010C\u001a\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u000100¢\u0006\u0004\bC\u0010DJ\u0017\u0010E\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010'¢\u0006\u0004\bE\u0010)J\u0015\u0010F\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\bF\u0010GJ\u0017\u0010H\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\bH\u0010\u001dJ\u001b\u0010I\u001a\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u000100¢\u0006\u0004\bI\u0010DJ\u0017\u0010J\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010'¢\u0006\u0004\bJ\u0010)J\u0015\u0010L\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020K¢\u0006\u0004\bL\u0010MR$\u0010F\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bF\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR$\u0010H\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR$\u0010A\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010S\u001a\u0004\bX\u0010U\"\u0004\bY\u0010WR$\u0010\u0014\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R$\u00103\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR$\u0010<\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010_\u001a\u0004\bd\u0010a\"\u0004\be\u0010cR$\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010Z\u001a\u0004\bf\u0010\\\"\u0004\bg\u0010^R$\u0010:\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010S\u001a\u0004\bh\u0010U\"\u0004\bi\u0010WR$\u00104\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u0010j\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR$\u00106\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u0010o\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010Z\u001a\u0004\bt\u0010\\\"\u0004\bu\u0010^R$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010v\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR$\u0010;\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010_\u001a\u0004\b{\u0010a\"\u0004\b|\u0010cR$\u0010B\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010_\u001a\u0004\b}\u0010a\"\u0004\b~\u0010cR.\u0010C\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u0001008\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0004\bC\u0010\u007f\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0006\b\u0082\u0001\u0010\u0083\u0001R&\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b\u0007\u0010o\u001a\u0005\b\u0084\u0001\u0010q\"\u0005\b\u0085\u0001\u0010sR&\u0010/\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b/\u0010_\u001a\u0005\b\u0086\u0001\u0010a\"\u0005\b\u0087\u0001\u0010cR)\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\"\u0010\u0088\u0001\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001\"\u0006\b\u008b\u0001\u0010\u008c\u0001R&\u0010-\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b-\u0010Z\u001a\u0005\b\u008d\u0001\u0010\\\"\u0005\b\u008e\u0001\u0010^R&\u0010E\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\bE\u0010_\u001a\u0005\b\u008f\u0001\u0010a\"\u0005\b\u0090\u0001\u0010cR&\u00109\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b9\u0010S\u001a\u0005\b\u0091\u0001\u0010U\"\u0005\b\u0092\u0001\u0010WR&\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b\r\u0010j\u001a\u0005\b\u0093\u0001\u0010l\"\u0005\b\u0094\u0001\u0010nR)\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\u0004\u0010\u0095\u0001\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001\"\u0006\b\u0098\u0001\u0010\u0099\u0001R&\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b\u001c\u0010S\u001a\u0005\b\u009a\u0001\u0010U\"\u0005\b\u009b\u0001\u0010WR&\u0010>\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b>\u0010Z\u001a\u0005\b\u009c\u0001\u0010\\\"\u0005\b\u009d\u0001\u0010^R/\u00107\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u0001008\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b7\u0010\u009e\u0001\u001a\u0006\b\u009f\u0001\u0010 \u0001\"\u0006\b¡\u0001\u0010¢\u0001R)\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\u0011\u0010£\u0001\u001a\u0006\b¤\u0001\u0010¥\u0001\"\u0006\b¦\u0001\u0010§\u0001R&\u0010J\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\bJ\u0010_\u001a\u0005\b¨\u0001\u0010a\"\u0005\b©\u0001\u0010cR&\u0010=\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b=\u0010_\u001a\u0005\bª\u0001\u0010a\"\u0005\b«\u0001\u0010cR.\u0010I\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u0001008\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0004\bI\u0010\u007f\u001a\u0006\b¬\u0001\u0010\u0081\u0001\"\u0006\b\u00ad\u0001\u0010\u0083\u0001R)\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\u0019\u0010®\u0001\u001a\u0006\b¯\u0001\u0010°\u0001\"\u0006\b±\u0001\u0010²\u0001R)\u0010L\u001a\u0004\u0018\u00010K8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bL\u0010³\u0001\u001a\u0006\b´\u0001\u0010µ\u0001\"\u0006\b¶\u0001\u0010·\u0001R&\u0010(\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b(\u0010_\u001a\u0005\b¸\u0001\u0010a\"\u0005\b¹\u0001\u0010cR&\u0010?\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b?\u0010S\u001a\u0005\bº\u0001\u0010U\"\u0005\b»\u0001\u0010WR&\u0010*\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b*\u0010_\u001a\u0005\b¼\u0001\u0010a\"\u0005\b½\u0001\u0010cR)\u0010%\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b%\u0010¾\u0001\u001a\u0006\b¿\u0001\u0010À\u0001\"\u0006\bÁ\u0001\u0010Â\u0001R/\u00101\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u0001008\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b1\u0010Ã\u0001\u001a\u0006\bÄ\u0001\u0010Å\u0001\"\u0006\bÆ\u0001\u0010Ç\u0001R&\u0010@\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b@\u0010S\u001a\u0005\bÈ\u0001\u0010U\"\u0005\bÉ\u0001\u0010WR&\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b\u0013\u0010j\u001a\u0005\bÊ\u0001\u0010l\"\u0005\bË\u0001\u0010nR&\u00105\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b5\u0010_\u001a\u0005\bÌ\u0001\u0010a\"\u0005\bÍ\u0001\u0010cR&\u0010+\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b+\u0010_\u001a\u0005\bÎ\u0001\u0010a\"\u0005\bÏ\u0001\u0010cR&\u0010.\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b.\u0010_\u001a\u0005\bÐ\u0001\u0010a\"\u0005\bÑ\u0001\u0010cR)\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\u001f\u0010Ò\u0001\u001a\u0006\bÓ\u0001\u0010Ô\u0001\"\u0006\bÕ\u0001\u0010Ö\u0001R&\u0010,\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b,\u0010_\u001a\u0005\b×\u0001\u0010a\"\u0005\bØ\u0001\u0010c¨\u0006Ü\u0001"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartModel;", "", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartAnimationType;", "prop", "animationType", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartAnimationType;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartModel;", "", "animationDuration", "(Ljava/lang/Integer;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartModel;", "", "title", "(Ljava/lang/String;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartModel;", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStyle;", "titleStyle", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStyle;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartModel;", "subtitle", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartAlignType;", "subtitleAlign", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartAlignType;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartModel;", "subtitleStyle", "axesTextColor", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartType;", "chartType", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartType;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartModel;", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartStackingType;", "stacking", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartStackingType;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartModel;", "", "markerRadius", "(Ljava/lang/Number;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartModel;", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartSymbolType;", "markerSymbol", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartSymbolType;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartModel;", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartSymbolStyleType;", "markerSymbolStyle", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartSymbolStyleType;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartModel;", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartZoomType;", "zoomType", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartZoomType;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartModel;", "", "inverted", "(Ljava/lang/Boolean;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartModel;", "xAxisReversed", "yAxisReversed", "tooltipEnabled", "tooltipValueSuffix", "gradientColorEnable", "polar", "", "margin", "([Ljava/lang/Number;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartModel;", "dataLabelsEnabled", "dataLabelsStyle", "xAxisLabelsEnabled", "xAxisTickInterval", "categories", "([Ljava/lang/String;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartModel;", "xAxisGridLineWidth", "yAxisGridLineWidth", "xAxisVisible", "yAxisVisible", "yAxisLabelsEnabled", "yAxisTitle", "yAxisLineWidth", "yAxisMin", "yAxisMax", "yAxisAllowDecimals", "colorsTheme", "([Ljava/lang/Object;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartModel;", "legendEnabled", "backgroundColor", "(Ljava/lang/Object;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartModel;", "borderRadius", "series", "touchEventEnabled", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAScrollablePlotArea;", "scrollablePlotArea", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAScrollablePlotArea;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartModel;", "Ljava/lang/Object;", "getBackgroundColor", "()Ljava/lang/Object;", "setBackgroundColor", "(Ljava/lang/Object;)V", "Ljava/lang/Number;", "getBorderRadius", "()Ljava/lang/Number;", "setBorderRadius", "(Ljava/lang/Number;)V", "getYAxisMax", "setYAxisMax", "Ljava/lang/String;", "getAxesTextColor", "()Ljava/lang/String;", "setAxesTextColor", "(Ljava/lang/String;)V", "Ljava/lang/Boolean;", "getDataLabelsEnabled", "()Ljava/lang/Boolean;", "setDataLabelsEnabled", "(Ljava/lang/Boolean;)V", "getYAxisVisible", "setYAxisVisible", "getSubtitle", "setSubtitle", "getYAxisGridLineWidth", "setYAxisGridLineWidth", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStyle;", "getDataLabelsStyle", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStyle;", "setDataLabelsStyle", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStyle;)V", "Ljava/lang/Integer;", "getXAxisTickInterval", "()Ljava/lang/Integer;", "setXAxisTickInterval", "(Ljava/lang/Integer;)V", "getTitle", "setTitle", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartType;", "getChartType", "()Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartType;", "setChartType", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartType;)V", "getXAxisVisible", "setXAxisVisible", "getYAxisAllowDecimals", "setYAxisAllowDecimals", "[Ljava/lang/Object;", "getColorsTheme", "()[Ljava/lang/Object;", "setColorsTheme", "([Ljava/lang/Object;)V", "getAnimationDuration", "setAnimationDuration", "getPolar", "setPolar", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartSymbolStyleType;", "getMarkerSymbolStyle", "()Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartSymbolStyleType;", "setMarkerSymbolStyle", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartSymbolStyleType;)V", "getTooltipValueSuffix", "setTooltipValueSuffix", "getLegendEnabled", "setLegendEnabled", "getXAxisGridLineWidth", "setXAxisGridLineWidth", "getTitleStyle", "setTitleStyle", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartAnimationType;", "getAnimationType", "()Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartAnimationType;", "setAnimationType", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartAnimationType;)V", "getMarkerRadius", "setMarkerRadius", "getYAxisTitle", "setYAxisTitle", "[Ljava/lang/String;", "getCategories", "()[Ljava/lang/String;", "setCategories", "([Ljava/lang/String;)V", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartAlignType;", "getSubtitleAlign", "()Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartAlignType;", "setSubtitleAlign", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartAlignType;)V", "getTouchEventEnabled", "setTouchEventEnabled", "getYAxisLabelsEnabled", "setYAxisLabelsEnabled", "getSeries", "setSeries", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartStackingType;", "getStacking", "()Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartStackingType;", "setStacking", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartStackingType;)V", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAScrollablePlotArea;", "getScrollablePlotArea", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAScrollablePlotArea;", "setScrollablePlotArea", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAScrollablePlotArea;)V", "getInverted", "setInverted", "getYAxisLineWidth", "setYAxisLineWidth", "getXAxisReversed", "setXAxisReversed", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartZoomType;", "getZoomType", "()Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartZoomType;", "setZoomType", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartZoomType;)V", "[Ljava/lang/Number;", "getMargin", "()[Ljava/lang/Number;", "setMargin", "([Ljava/lang/Number;)V", "getYAxisMin", "setYAxisMin", "getSubtitleStyle", "setSubtitleStyle", "getXAxisLabelsEnabled", "setXAxisLabelsEnabled", "getYAxisReversed", "setYAxisReversed", "getGradientColorEnable", "setGradientColorEnable", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartSymbolType;", "getMarkerSymbol", "()Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartSymbolType;", "setMarkerSymbol", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartSymbolType;)V", "getTooltipEnabled", "setTooltipEnabled", "<init>", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartAnimationType;Ljava/lang/Integer;Ljava/lang/String;Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStyle;Ljava/lang/String;Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartAlignType;Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStyle;Ljava/lang/String;Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartType;Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartStackingType;Ljava/lang/Number;Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartSymbolType;Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartSymbolStyleType;Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartZoomType;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;[Ljava/lang/Number;Ljava/lang/Boolean;Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStyle;Ljava/lang/Boolean;Ljava/lang/Integer;[Ljava/lang/String;Ljava/lang/Number;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Boolean;Ljava/lang/Number;[Ljava/lang/Object;Ljava/lang/Boolean;Ljava/lang/Object;Ljava/lang/Number;[Ljava/lang/Object;Ljava/lang/Boolean;Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAScrollablePlotArea;)V", "Companion", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class AAChartModel {
    public static final Companion Companion = new Companion(null);
    @e
    private Integer animationDuration;
    @e
    private AAChartAnimationType animationType;
    @e
    private String axesTextColor;
    @e
    private Object backgroundColor;
    @e
    private Number borderRadius;
    @e
    private String[] categories;
    @e
    private AAChartType chartType;
    @e
    private Object[] colorsTheme;
    @e
    private Boolean dataLabelsEnabled;
    @e
    private AAStyle dataLabelsStyle;
    @e
    private Boolean gradientColorEnable;
    @e
    private Boolean inverted;
    @e
    private Boolean legendEnabled;
    @e
    private Number[] margin;
    @e
    private Number markerRadius;
    @e
    private AAChartSymbolType markerSymbol;
    @e
    private AAChartSymbolStyleType markerSymbolStyle;
    @e
    private Boolean polar;
    @e
    private AAScrollablePlotArea scrollablePlotArea;
    @e
    private Object[] series;
    @e
    private AAChartStackingType stacking;
    @e
    private String subtitle;
    @e
    private AAChartAlignType subtitleAlign;
    @e
    private AAStyle subtitleStyle;
    @e
    private String title;
    @e
    private AAStyle titleStyle;
    @e
    private Boolean tooltipEnabled;
    @e
    private String tooltipValueSuffix;
    @e
    private Boolean touchEventEnabled;
    @e
    private Number xAxisGridLineWidth;
    @e
    private Boolean xAxisLabelsEnabled;
    @e
    private Boolean xAxisReversed;
    @e
    private Integer xAxisTickInterval;
    @e
    private Boolean xAxisVisible;
    @e
    private Boolean yAxisAllowDecimals;
    @e
    private Number yAxisGridLineWidth;
    @e
    private Boolean yAxisLabelsEnabled;
    @e
    private Number yAxisLineWidth;
    @e
    private Number yAxisMax;
    @e
    private Number yAxisMin;
    @e
    private Boolean yAxisReversed;
    @e
    private String yAxisTitle;
    @e
    private Boolean yAxisVisible;
    @e
    private AAChartZoomType zoomType;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartModel$Companion;", "", "Landroid/content/Context;", "context", "Lcom/github/aachartmodel/aainfographics/aatools/AABuilder;", "Builder", "(Landroid/content/Context;)Lcom/github/aachartmodel/aainfographics/aatools/AABuilder;", "<init>", "()V", "charts_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        @d
        public final AABuilder Builder(@d Context context) {
            return new AABuilder(context);
        }

        public /* synthetic */ Companion(u uVar) {
            this();
        }
    }

    public AAChartModel() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 4095, null);
    }

    public AAChartModel(@e AAChartAnimationType aAChartAnimationType, @e Integer num, @e String str, @e AAStyle aAStyle, @e String str2, @e AAChartAlignType aAChartAlignType, @e AAStyle aAStyle2, @e String str3, @e AAChartType aAChartType, @e AAChartStackingType aAChartStackingType, @e Number number, @e AAChartSymbolType aAChartSymbolType, @e AAChartSymbolStyleType aAChartSymbolStyleType, @e AAChartZoomType aAChartZoomType, @e Boolean bool, @e Boolean bool2, @e Boolean bool3, @e Boolean bool4, @e String str4, @e Boolean bool5, @e Boolean bool6, @e Number[] numberArr, @e Boolean bool7, @e AAStyle aAStyle3, @e Boolean bool8, @e Integer num2, @e String[] strArr, @e Number number2, @e Boolean bool9, @e Boolean bool10, @e Boolean bool11, @e String str5, @e Number number3, @e Number number4, @e Number number5, @e Boolean bool12, @e Number number6, @e Object[] objArr, @e Boolean bool13, @e Object obj, @e Number number7, @e Object[] objArr2, @e Boolean bool14, @e AAScrollablePlotArea aAScrollablePlotArea) {
        this.animationType = aAChartAnimationType;
        this.animationDuration = num;
        this.title = str;
        this.titleStyle = aAStyle;
        this.subtitle = str2;
        this.subtitleAlign = aAChartAlignType;
        this.subtitleStyle = aAStyle2;
        this.axesTextColor = str3;
        this.chartType = aAChartType;
        this.stacking = aAChartStackingType;
        this.markerRadius = number;
        this.markerSymbol = aAChartSymbolType;
        this.markerSymbolStyle = aAChartSymbolStyleType;
        this.zoomType = aAChartZoomType;
        this.inverted = bool;
        this.xAxisReversed = bool2;
        this.yAxisReversed = bool3;
        this.tooltipEnabled = bool4;
        this.tooltipValueSuffix = str4;
        this.gradientColorEnable = bool5;
        this.polar = bool6;
        this.margin = numberArr;
        this.dataLabelsEnabled = bool7;
        this.dataLabelsStyle = aAStyle3;
        this.xAxisLabelsEnabled = bool8;
        this.xAxisTickInterval = num2;
        this.categories = strArr;
        this.xAxisGridLineWidth = number2;
        this.xAxisVisible = bool9;
        this.yAxisVisible = bool10;
        this.yAxisLabelsEnabled = bool11;
        this.yAxisTitle = str5;
        this.yAxisLineWidth = number3;
        this.yAxisMin = number4;
        this.yAxisMax = number5;
        this.yAxisAllowDecimals = bool12;
        this.yAxisGridLineWidth = number6;
        this.colorsTheme = objArr;
        this.legendEnabled = bool13;
        this.backgroundColor = obj;
        this.borderRadius = number7;
        this.series = objArr2;
        this.touchEventEnabled = bool14;
        this.scrollablePlotArea = aAScrollablePlotArea;
    }

    @d
    public final AAChartModel animationDuration(@e Integer num) {
        this.animationDuration = num;
        return this;
    }

    @d
    public final AAChartModel animationType(@d AAChartAnimationType aAChartAnimationType) {
        this.animationType = aAChartAnimationType;
        return this;
    }

    @d
    public final AAChartModel axesTextColor(@d String str) {
        this.axesTextColor = str;
        return this;
    }

    @d
    public final AAChartModel backgroundColor(@d Object obj) {
        this.backgroundColor = obj;
        return this;
    }

    @d
    public final AAChartModel borderRadius(@e Number number) {
        this.borderRadius = number;
        return this;
    }

    @d
    public final AAChartModel categories(@d String[] strArr) {
        this.categories = strArr;
        return this;
    }

    @d
    public final AAChartModel chartType(@d AAChartType aAChartType) {
        this.chartType = aAChartType;
        return this;
    }

    @d
    public final AAChartModel colorsTheme(@d Object[] objArr) {
        this.colorsTheme = objArr;
        return this;
    }

    @d
    public final AAChartModel dataLabelsEnabled(@e Boolean bool) {
        this.dataLabelsEnabled = bool;
        return this;
    }

    @d
    public final AAChartModel dataLabelsStyle(@d AAStyle aAStyle) {
        this.dataLabelsStyle = aAStyle;
        return this;
    }

    @e
    public final Integer getAnimationDuration() {
        return this.animationDuration;
    }

    @e
    public final AAChartAnimationType getAnimationType() {
        return this.animationType;
    }

    @e
    public final String getAxesTextColor() {
        return this.axesTextColor;
    }

    @e
    public final Object getBackgroundColor() {
        return this.backgroundColor;
    }

    @e
    public final Number getBorderRadius() {
        return this.borderRadius;
    }

    @e
    public final String[] getCategories() {
        return this.categories;
    }

    @e
    public final AAChartType getChartType() {
        return this.chartType;
    }

    @e
    public final Object[] getColorsTheme() {
        return this.colorsTheme;
    }

    @e
    public final Boolean getDataLabelsEnabled() {
        return this.dataLabelsEnabled;
    }

    @e
    public final AAStyle getDataLabelsStyle() {
        return this.dataLabelsStyle;
    }

    @e
    public final Boolean getGradientColorEnable() {
        return this.gradientColorEnable;
    }

    @e
    public final Boolean getInverted() {
        return this.inverted;
    }

    @e
    public final Boolean getLegendEnabled() {
        return this.legendEnabled;
    }

    @e
    public final Number[] getMargin() {
        return this.margin;
    }

    @e
    public final Number getMarkerRadius() {
        return this.markerRadius;
    }

    @e
    public final AAChartSymbolType getMarkerSymbol() {
        return this.markerSymbol;
    }

    @e
    public final AAChartSymbolStyleType getMarkerSymbolStyle() {
        return this.markerSymbolStyle;
    }

    @e
    public final Boolean getPolar() {
        return this.polar;
    }

    @e
    public final AAScrollablePlotArea getScrollablePlotArea() {
        return this.scrollablePlotArea;
    }

    @e
    public final Object[] getSeries() {
        return this.series;
    }

    @e
    public final AAChartStackingType getStacking() {
        return this.stacking;
    }

    @e
    public final String getSubtitle() {
        return this.subtitle;
    }

    @e
    public final AAChartAlignType getSubtitleAlign() {
        return this.subtitleAlign;
    }

    @e
    public final AAStyle getSubtitleStyle() {
        return this.subtitleStyle;
    }

    @e
    public final String getTitle() {
        return this.title;
    }

    @e
    public final AAStyle getTitleStyle() {
        return this.titleStyle;
    }

    @e
    public final Boolean getTooltipEnabled() {
        return this.tooltipEnabled;
    }

    @e
    public final String getTooltipValueSuffix() {
        return this.tooltipValueSuffix;
    }

    @e
    public final Boolean getTouchEventEnabled() {
        return this.touchEventEnabled;
    }

    @e
    public final Number getXAxisGridLineWidth() {
        return this.xAxisGridLineWidth;
    }

    @e
    public final Boolean getXAxisLabelsEnabled() {
        return this.xAxisLabelsEnabled;
    }

    @e
    public final Boolean getXAxisReversed() {
        return this.xAxisReversed;
    }

    @e
    public final Integer getXAxisTickInterval() {
        return this.xAxisTickInterval;
    }

    @e
    public final Boolean getXAxisVisible() {
        return this.xAxisVisible;
    }

    @e
    public final Boolean getYAxisAllowDecimals() {
        return this.yAxisAllowDecimals;
    }

    @e
    public final Number getYAxisGridLineWidth() {
        return this.yAxisGridLineWidth;
    }

    @e
    public final Boolean getYAxisLabelsEnabled() {
        return this.yAxisLabelsEnabled;
    }

    @e
    public final Number getYAxisLineWidth() {
        return this.yAxisLineWidth;
    }

    @e
    public final Number getYAxisMax() {
        return this.yAxisMax;
    }

    @e
    public final Number getYAxisMin() {
        return this.yAxisMin;
    }

    @e
    public final Boolean getYAxisReversed() {
        return this.yAxisReversed;
    }

    @e
    public final String getYAxisTitle() {
        return this.yAxisTitle;
    }

    @e
    public final Boolean getYAxisVisible() {
        return this.yAxisVisible;
    }

    @e
    public final AAChartZoomType getZoomType() {
        return this.zoomType;
    }

    @d
    public final AAChartModel gradientColorEnable(@e Boolean bool) {
        this.gradientColorEnable = bool;
        return this;
    }

    @d
    public final AAChartModel inverted(@e Boolean bool) {
        this.inverted = bool;
        return this;
    }

    @d
    public final AAChartModel legendEnabled(@e Boolean bool) {
        this.legendEnabled = bool;
        return this;
    }

    @d
    public final AAChartModel margin(@e Number[] numberArr) {
        this.margin = numberArr;
        return this;
    }

    @d
    public final AAChartModel markerRadius(@e Number number) {
        this.markerRadius = number;
        return this;
    }

    @d
    public final AAChartModel markerSymbol(@d AAChartSymbolType aAChartSymbolType) {
        this.markerSymbol = aAChartSymbolType;
        return this;
    }

    @d
    public final AAChartModel markerSymbolStyle(@d AAChartSymbolStyleType aAChartSymbolStyleType) {
        this.markerSymbolStyle = aAChartSymbolStyleType;
        return this;
    }

    @d
    public final AAChartModel polar(@e Boolean bool) {
        this.polar = bool;
        return this;
    }

    @d
    public final AAChartModel scrollablePlotArea(@d AAScrollablePlotArea aAScrollablePlotArea) {
        this.scrollablePlotArea = aAScrollablePlotArea;
        return this;
    }

    @d
    public final AAChartModel series(@d Object[] objArr) {
        this.series = objArr;
        return this;
    }

    public final void setAnimationDuration(@e Integer num) {
        this.animationDuration = num;
    }

    public final void setAnimationType(@e AAChartAnimationType aAChartAnimationType) {
        this.animationType = aAChartAnimationType;
    }

    public final void setAxesTextColor(@e String str) {
        this.axesTextColor = str;
    }

    public final void setBackgroundColor(@e Object obj) {
        this.backgroundColor = obj;
    }

    public final void setBorderRadius(@e Number number) {
        this.borderRadius = number;
    }

    public final void setCategories(@e String[] strArr) {
        this.categories = strArr;
    }

    public final void setChartType(@e AAChartType aAChartType) {
        this.chartType = aAChartType;
    }

    public final void setColorsTheme(@e Object[] objArr) {
        this.colorsTheme = objArr;
    }

    public final void setDataLabelsEnabled(@e Boolean bool) {
        this.dataLabelsEnabled = bool;
    }

    public final void setDataLabelsStyle(@e AAStyle aAStyle) {
        this.dataLabelsStyle = aAStyle;
    }

    public final void setGradientColorEnable(@e Boolean bool) {
        this.gradientColorEnable = bool;
    }

    public final void setInverted(@e Boolean bool) {
        this.inverted = bool;
    }

    public final void setLegendEnabled(@e Boolean bool) {
        this.legendEnabled = bool;
    }

    public final void setMargin(@e Number[] numberArr) {
        this.margin = numberArr;
    }

    public final void setMarkerRadius(@e Number number) {
        this.markerRadius = number;
    }

    public final void setMarkerSymbol(@e AAChartSymbolType aAChartSymbolType) {
        this.markerSymbol = aAChartSymbolType;
    }

    public final void setMarkerSymbolStyle(@e AAChartSymbolStyleType aAChartSymbolStyleType) {
        this.markerSymbolStyle = aAChartSymbolStyleType;
    }

    public final void setPolar(@e Boolean bool) {
        this.polar = bool;
    }

    public final void setScrollablePlotArea(@e AAScrollablePlotArea aAScrollablePlotArea) {
        this.scrollablePlotArea = aAScrollablePlotArea;
    }

    public final void setSeries(@e Object[] objArr) {
        this.series = objArr;
    }

    public final void setStacking(@e AAChartStackingType aAChartStackingType) {
        this.stacking = aAChartStackingType;
    }

    public final void setSubtitle(@e String str) {
        this.subtitle = str;
    }

    public final void setSubtitleAlign(@e AAChartAlignType aAChartAlignType) {
        this.subtitleAlign = aAChartAlignType;
    }

    public final void setSubtitleStyle(@e AAStyle aAStyle) {
        this.subtitleStyle = aAStyle;
    }

    public final void setTitle(@e String str) {
        this.title = str;
    }

    public final void setTitleStyle(@e AAStyle aAStyle) {
        this.titleStyle = aAStyle;
    }

    public final void setTooltipEnabled(@e Boolean bool) {
        this.tooltipEnabled = bool;
    }

    public final void setTooltipValueSuffix(@e String str) {
        this.tooltipValueSuffix = str;
    }

    public final void setTouchEventEnabled(@e Boolean bool) {
        this.touchEventEnabled = bool;
    }

    public final void setXAxisGridLineWidth(@e Number number) {
        this.xAxisGridLineWidth = number;
    }

    public final void setXAxisLabelsEnabled(@e Boolean bool) {
        this.xAxisLabelsEnabled = bool;
    }

    public final void setXAxisReversed(@e Boolean bool) {
        this.xAxisReversed = bool;
    }

    public final void setXAxisTickInterval(@e Integer num) {
        this.xAxisTickInterval = num;
    }

    public final void setXAxisVisible(@e Boolean bool) {
        this.xAxisVisible = bool;
    }

    public final void setYAxisAllowDecimals(@e Boolean bool) {
        this.yAxisAllowDecimals = bool;
    }

    public final void setYAxisGridLineWidth(@e Number number) {
        this.yAxisGridLineWidth = number;
    }

    public final void setYAxisLabelsEnabled(@e Boolean bool) {
        this.yAxisLabelsEnabled = bool;
    }

    public final void setYAxisLineWidth(@e Number number) {
        this.yAxisLineWidth = number;
    }

    public final void setYAxisMax(@e Number number) {
        this.yAxisMax = number;
    }

    public final void setYAxisMin(@e Number number) {
        this.yAxisMin = number;
    }

    public final void setYAxisReversed(@e Boolean bool) {
        this.yAxisReversed = bool;
    }

    public final void setYAxisTitle(@e String str) {
        this.yAxisTitle = str;
    }

    public final void setYAxisVisible(@e Boolean bool) {
        this.yAxisVisible = bool;
    }

    public final void setZoomType(@e AAChartZoomType aAChartZoomType) {
        this.zoomType = aAChartZoomType;
    }

    @d
    public final AAChartModel stacking(@d AAChartStackingType aAChartStackingType) {
        this.stacking = aAChartStackingType;
        return this;
    }

    @d
    public final AAChartModel subtitle(@d String str) {
        this.subtitle = str;
        return this;
    }

    @d
    public final AAChartModel subtitleAlign(@d AAChartAlignType aAChartAlignType) {
        this.subtitleAlign = aAChartAlignType;
        return this;
    }

    @d
    public final AAChartModel subtitleStyle(@d AAStyle aAStyle) {
        this.subtitleStyle = aAStyle;
        return this;
    }

    @d
    public final AAChartModel title(@d String str) {
        this.title = str;
        return this;
    }

    @d
    public final AAChartModel titleStyle(@d AAStyle aAStyle) {
        this.titleStyle = aAStyle;
        return this;
    }

    @d
    public final AAChartModel tooltipEnabled(@e Boolean bool) {
        this.tooltipEnabled = bool;
        return this;
    }

    @d
    public final AAChartModel tooltipValueSuffix(@e String str) {
        this.tooltipValueSuffix = str;
        return this;
    }

    @d
    public final AAChartModel touchEventEnabled(@e Boolean bool) {
        this.touchEventEnabled = bool;
        return this;
    }

    @d
    public final AAChartModel xAxisGridLineWidth(@e Number number) {
        this.xAxisGridLineWidth = number;
        return this;
    }

    @d
    public final AAChartModel xAxisLabelsEnabled(@e Boolean bool) {
        this.xAxisLabelsEnabled = bool;
        return this;
    }

    @d
    public final AAChartModel xAxisReversed(@e Boolean bool) {
        this.xAxisReversed = bool;
        return this;
    }

    @d
    public final AAChartModel xAxisTickInterval(@e Integer num) {
        this.xAxisTickInterval = num;
        return this;
    }

    @d
    public final AAChartModel xAxisVisible(@e Boolean bool) {
        this.xAxisVisible = bool;
        return this;
    }

    @d
    public final AAChartModel yAxisAllowDecimals(@e Boolean bool) {
        this.yAxisAllowDecimals = bool;
        return this;
    }

    @d
    public final AAChartModel yAxisGridLineWidth(@e Number number) {
        this.yAxisGridLineWidth = number;
        return this;
    }

    @d
    public final AAChartModel yAxisLabelsEnabled(@e Boolean bool) {
        this.yAxisLabelsEnabled = bool;
        return this;
    }

    @d
    public final AAChartModel yAxisLineWidth(@e Number number) {
        this.yAxisLineWidth = number;
        return this;
    }

    @d
    public final AAChartModel yAxisMax(@e Number number) {
        this.yAxisMax = number;
        return this;
    }

    @d
    public final AAChartModel yAxisMin(@e Number number) {
        this.yAxisMin = number;
        return this;
    }

    @d
    public final AAChartModel yAxisReversed(@e Boolean bool) {
        this.yAxisReversed = bool;
        return this;
    }

    @d
    public final AAChartModel yAxisTitle(@d String str) {
        this.yAxisTitle = str;
        return this;
    }

    @d
    public final AAChartModel yAxisVisible(@e Boolean bool) {
        this.yAxisVisible = bool;
        return this;
    }

    @d
    public final AAChartModel zoomType(@d AAChartZoomType aAChartZoomType) {
        this.zoomType = aAChartZoomType;
        return this;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ AAChartModel(com.github.aachartmodel.aainfographics.aachartcreator.AAChartAnimationType r43, java.lang.Integer r44, java.lang.String r45, com.github.aachartmodel.aainfographics.aaoptionsmodel.AAStyle r46, java.lang.String r47, com.github.aachartmodel.aainfographics.aachartcreator.AAChartAlignType r48, com.github.aachartmodel.aainfographics.aaoptionsmodel.AAStyle r49, java.lang.String r50, com.github.aachartmodel.aainfographics.aachartcreator.AAChartType r51, com.github.aachartmodel.aainfographics.aachartcreator.AAChartStackingType r52, java.lang.Number r53, com.github.aachartmodel.aainfographics.aachartcreator.AAChartSymbolType r54, com.github.aachartmodel.aainfographics.aachartcreator.AAChartSymbolStyleType r55, com.github.aachartmodel.aainfographics.aachartcreator.AAChartZoomType r56, java.lang.Boolean r57, java.lang.Boolean r58, java.lang.Boolean r59, java.lang.Boolean r60, java.lang.String r61, java.lang.Boolean r62, java.lang.Boolean r63, java.lang.Number[] r64, java.lang.Boolean r65, com.github.aachartmodel.aainfographics.aaoptionsmodel.AAStyle r66, java.lang.Boolean r67, java.lang.Integer r68, java.lang.String[] r69, java.lang.Number r70, java.lang.Boolean r71, java.lang.Boolean r72, java.lang.Boolean r73, java.lang.String r74, java.lang.Number r75, java.lang.Number r76, java.lang.Number r77, java.lang.Boolean r78, java.lang.Number r79, java.lang.Object[] r80, java.lang.Boolean r81, java.lang.Object r82, java.lang.Number r83, java.lang.Object[] r84, java.lang.Boolean r85, com.github.aachartmodel.aainfographics.aaoptionsmodel.AAScrollablePlotArea r86, int r87, int r88, h.k2.v.u r89) {
        /*
            Method dump skipped, instructions count: 580
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.aachartmodel.aainfographics.aachartcreator.AAChartModel.<init>(com.github.aachartmodel.aainfographics.aachartcreator.AAChartAnimationType, java.lang.Integer, java.lang.String, com.github.aachartmodel.aainfographics.aaoptionsmodel.AAStyle, java.lang.String, com.github.aachartmodel.aainfographics.aachartcreator.AAChartAlignType, com.github.aachartmodel.aainfographics.aaoptionsmodel.AAStyle, java.lang.String, com.github.aachartmodel.aainfographics.aachartcreator.AAChartType, com.github.aachartmodel.aainfographics.aachartcreator.AAChartStackingType, java.lang.Number, com.github.aachartmodel.aainfographics.aachartcreator.AAChartSymbolType, com.github.aachartmodel.aainfographics.aachartcreator.AAChartSymbolStyleType, com.github.aachartmodel.aainfographics.aachartcreator.AAChartZoomType, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.String, java.lang.Boolean, java.lang.Boolean, java.lang.Number[], java.lang.Boolean, com.github.aachartmodel.aainfographics.aaoptionsmodel.AAStyle, java.lang.Boolean, java.lang.Integer, java.lang.String[], java.lang.Number, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.String, java.lang.Number, java.lang.Number, java.lang.Number, java.lang.Boolean, java.lang.Number, java.lang.Object[], java.lang.Boolean, java.lang.Object, java.lang.Number, java.lang.Object[], java.lang.Boolean, com.github.aachartmodel.aainfographics.aaoptionsmodel.AAScrollablePlotArea, int, int, h.k2.v.u):void");
    }
}

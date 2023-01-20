package com.github.aachartmodel.aainfographics.aatools;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartAlignType;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartAnimationType;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartModel;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartStackingType;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartSymbolStyleType;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartSymbolType;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartType;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartZoomType;
import com.github.aachartmodel.aainfographics.aachartcreator.AASeriesElement;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AAScrollablePlotArea;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AAStyle;
import com.tencent.android.tpush.common.MessageKey;
import e.u.a.g.c;
import h.k2.v.s0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\u0015\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b7\u0018\u00002\u00020\u0001B\u0012\u0012\u0007\u0010¸\u0001\u001a\u00020z¢\u0006\u0006\b¹\u0001\u0010º\u0001B\u001d\b\u0016\u0012\u0007\u0010¸\u0001\u001a\u00020z\u0012\u0007\u0010»\u0001\u001a\u00020\u0012¢\u0006\u0006\b¹\u0001\u0010¼\u0001J/\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0004\"\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\f\u001a\u00020\u0006*\u00020\u0002H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ-\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0004\"\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u001b\u0010\u001dJ\u0015\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u001e¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010!\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0006¢\u0006\u0004\b!\u0010\u001cJ-\u0010!\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0004\"\u0004\u0018\u00010\u0001¢\u0006\u0004\b!\u0010\u001dJ\u0015\u0010#\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\"¢\u0006\u0004\b#\u0010$J\u0015\u0010%\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u001e¢\u0006\u0004\b%\u0010 J\u0015\u0010&\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0006¢\u0006\u0004\b&\u0010\u001cJ\u0015\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u0002¢\u0006\u0004\b&\u0010\u001aJ\u0015\u0010(\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b(\u0010\u001aJ\u0015\u0010*\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020)¢\u0006\u0004\b*\u0010+J\u0015\u0010-\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020,¢\u0006\u0004\b-\u0010.J\u0015\u00100\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020/¢\u0006\u0004\b0\u00101J\u0015\u00102\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b2\u0010\u001aJ\u0015\u00104\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u000203¢\u0006\u0004\b4\u00105J\u0015\u00107\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u000206¢\u0006\u0004\b7\u00108J\u0015\u0010:\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u000209¢\u0006\u0004\b:\u0010;J\u0015\u0010=\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020<¢\u0006\u0004\b=\u0010>J\u0015\u0010?\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020<¢\u0006\u0004\b?\u0010>J\u0015\u0010@\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020<¢\u0006\u0004\b@\u0010>J\u0015\u0010A\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020<¢\u0006\u0004\bA\u0010>J\u0015\u0010B\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0006¢\u0006\u0004\bB\u0010\u001cJ-\u0010B\u001a\u00020\u00002\u0006\u0010C\u001a\u00020\u00022\u0016\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0004\"\u0004\u0018\u00010\u0001¢\u0006\u0004\bB\u0010\u001dJ\u0015\u0010D\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020<¢\u0006\u0004\bD\u0010>J\u0015\u0010E\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020<¢\u0006\u0004\bE\u0010>J!\u0010F\u001a\u00020\u00002\u0012\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020/0\u0004\"\u00020/¢\u0006\u0004\bF\u0010GJ-\u0010F\u001a\u00020\u00002\u0006\u0010H\u001a\u00020/2\u0006\u0010I\u001a\u00020/2\u0006\u0010J\u001a\u00020/2\u0006\u0010K\u001a\u00020/¢\u0006\u0004\bF\u0010LJ-\u0010F\u001a\u00020\u00002\u0006\u0010M\u001a\u00020\u00022\u0006\u0010N\u001a\u00020\u00022\u0006\u0010O\u001a\u00020\u00022\u0006\u0010P\u001a\u00020\u0002¢\u0006\u0004\bF\u0010QJ\u0015\u0010R\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020<¢\u0006\u0004\bR\u0010>J\u0015\u0010S\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u001e¢\u0006\u0004\bS\u0010 J\u0015\u0010T\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020<¢\u0006\u0004\bT\u0010>J\u0015\u0010U\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\bU\u0010\u001aJ!\u0010V\u001a\u00020\u00002\u0012\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0004\"\u00020\u0006¢\u0006\u0004\bV\u0010WJ\u0019\u0010V\u001a\u00020\u00002\n\u0010Y\u001a\u00020X\"\u00020\u0002¢\u0006\u0004\bV\u0010ZJ\u0015\u0010[\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020/¢\u0006\u0004\b[\u00101J\u0015\u0010[\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b[\u0010\u001aJ\u0015\u0010\\\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020/¢\u0006\u0004\b\\\u00101J\u0015\u0010\\\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\\\u0010\u001aJ\u0015\u0010]\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020<¢\u0006\u0004\b]\u0010>J\u0015\u0010^\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020<¢\u0006\u0004\b^\u0010>J\u0015\u0010_\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020<¢\u0006\u0004\b_\u0010>J\u0015\u0010`\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0006¢\u0006\u0004\b`\u0010\u001cJ-\u0010`\u001a\u00020\u00002\u0006\u0010C\u001a\u00020\u00022\u0016\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0004\"\u0004\u0018\u00010\u0001¢\u0006\u0004\b`\u0010\u001dJ\u0015\u0010a\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020/¢\u0006\u0004\ba\u00101J\u0015\u0010a\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\ba\u0010\u001aJ\u0017\u0010b\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010/¢\u0006\u0004\bb\u00101J\u0015\u0010b\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\bb\u0010\u001aJ\u0017\u0010c\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010/¢\u0006\u0004\bc\u00101J\u0015\u0010c\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\bc\u0010\u001aJ\u0015\u0010d\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020<¢\u0006\u0004\bd\u0010>J\u001b\u0010e\u001a\u00020\u00002\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0004\be\u0010fJ!\u0010e\u001a\u00020\u00002\u0012\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0004\"\u00020\u0006¢\u0006\u0004\be\u0010WJ\u0019\u0010e\u001a\u00020\u00002\n\u0010g\u001a\u00020X\"\u00020\u0002¢\u0006\u0004\be\u0010ZJ\u0015\u0010h\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020<¢\u0006\u0004\bh\u0010>J\u0015\u0010i\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0006¢\u0006\u0004\bi\u0010\u001cJ\u0015\u0010i\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\bi\u0010\u001aJ\u0015\u0010j\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020/¢\u0006\u0004\bj\u00101J\u0015\u0010j\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\bj\u0010\u001aJ!\u0010l\u001a\u00020\u00002\u0012\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020k0\u0004\"\u00020k¢\u0006\u0004\bl\u0010mJ\u0015\u0010n\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020<¢\u0006\u0004\bn\u0010>J\u0015\u0010p\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020o¢\u0006\u0004\bp\u0010qJ\r\u0010r\u001a\u00020\u0012¢\u0006\u0004\br\u0010sR\u0018\u0010t\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bt\u0010uR\u0018\u0010v\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010wR\u0018\u0010x\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010yR\u001e\u0010|\u001a\n {*\u0004\u0018\u00010z0z8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b|\u0010}R\u0018\u0010~\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b~\u0010yR\u0018\u0010\u007f\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u007f\u0010yR\u001a\u0010\u0080\u0001\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0080\u0001\u0010yR\u001b\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R!\u0010\u0083\u0001\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u001a\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0085\u0001\u0010uR#\u0010\u0087\u0001\u001a\f {*\u0005\u0018\u00010\u0086\u00010\u0086\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001b\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R\u001a\u0010\u008b\u0001\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008b\u0001\u0010wR\u001a\u0010\u008c\u0001\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008c\u0001\u0010wR\u001a\u0010\u008d\u0001\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008d\u0001\u0010yR\u001a\u0010\u008e\u0001\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008e\u0001\u0010yR!\u0010\u008f\u0001\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R\u001a\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0091\u0001\u0010uR\u001b\u0010\u0092\u0001\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0092\u0001\u0010\u0093\u0001R\u001b\u0010\u0094\u0001\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0094\u0001\u0010\u0095\u0001R\u001b\u0010\u0096\u0001\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0096\u0001\u0010\u0097\u0001R\u001b\u0010\u0098\u0001\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0098\u0001\u0010\u0099\u0001R\u001b\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009a\u0001\u0010\u009b\u0001R\u001a\u0010\u009c\u0001\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u009c\u0001\u0010yR\u001a\u0010\u009d\u0001\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u009d\u0001\u0010yR\u001a\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u009e\u0001\u0010uR\u001a\u0010\u009f\u0001\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u009f\u0001\u0010yR\u001a\u0010 \u0001\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b \u0001\u0010wR\u001a\u0010¡\u0001\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¡\u0001\u0010yR\u001a\u0010¢\u0001\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¢\u0001\u0010yR\u001b\u0010£\u0001\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b£\u0001\u0010¤\u0001R\u001a\u0010¥\u0001\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¥\u0001\u0010wR\u001b\u0010¦\u0001\u001a\u0004\u0018\u00010o8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¦\u0001\u0010§\u0001R\u001b\u0010¨\u0001\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¨\u0001\u0010©\u0001R\u001b\u0010ª\u0001\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bª\u0001\u0010\u008a\u0001R\u001a\u0010«\u0001\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b«\u0001\u0010uR!\u0010¬\u0001\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¬\u0001\u0010\u00ad\u0001R\u001b\u0010®\u0001\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b®\u0001\u0010\u008a\u0001R!\u0010¯\u0001\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¯\u0001\u0010\u0090\u0001R\u001a\u0010°\u0001\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b°\u0001\u0010wR\u001a\u0010±\u0001\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b±\u0001\u0010yR\u001a\u0010²\u0001\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b²\u0001\u0010yR\u001a\u0010³\u0001\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b³\u0001\u0010yR\u001a\u0010´\u0001\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b´\u0001\u0010wR\u001b\u0010µ\u0001\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bµ\u0001\u0010\u009b\u0001R\u001b\u0010¶\u0001\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¶\u0001\u0010·\u0001¨\u0006½\u0001"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aatools/AABuilder;", "", "", "id", "", "formatArgs", "", "getString", "(I[Ljava/lang/Object;)Ljava/lang/String;", "colorResId", "getColor", "(I)I", "toColorString", "(I)Ljava/lang/String;", "dimenResId", "", "getDimen", "(I)F", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartModel;", "prop", "set", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartModel;)Lcom/github/aachartmodel/aainfographics/aatools/AABuilder;", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartAnimationType;", "setAnimationType", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartAnimationType;)Lcom/github/aachartmodel/aainfographics/aatools/AABuilder;", "setAnimationDuration", "(I)Lcom/github/aachartmodel/aainfographics/aatools/AABuilder;", "setTitle", "(Ljava/lang/String;)Lcom/github/aachartmodel/aainfographics/aatools/AABuilder;", "(I[Ljava/lang/Object;)Lcom/github/aachartmodel/aainfographics/aatools/AABuilder;", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStyle;", "setTitleStyle", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStyle;)Lcom/github/aachartmodel/aainfographics/aatools/AABuilder;", "setSubtitle", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartAlignType;", "setSubtitleAlign", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartAlignType;)Lcom/github/aachartmodel/aainfographics/aatools/AABuilder;", "setSubtitleStyle", "setAxesTextColor", "color", "setAxesTextColorRes", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartType;", "setChartType", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartType;)Lcom/github/aachartmodel/aainfographics/aatools/AABuilder;", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartStackingType;", "setStacking", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartStackingType;)Lcom/github/aachartmodel/aainfographics/aatools/AABuilder;", "", "setMarkerRadius", "(Ljava/lang/Number;)Lcom/github/aachartmodel/aainfographics/aatools/AABuilder;", "setMarkerRadiusRes", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartSymbolType;", "setMarkerSymbol", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartSymbolType;)Lcom/github/aachartmodel/aainfographics/aatools/AABuilder;", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartSymbolStyleType;", "setMarkerSymbolStyle", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartSymbolStyleType;)Lcom/github/aachartmodel/aainfographics/aatools/AABuilder;", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartZoomType;", "setZoomType", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartZoomType;)Lcom/github/aachartmodel/aainfographics/aatools/AABuilder;", "", "setInverted", "(Z)Lcom/github/aachartmodel/aainfographics/aatools/AABuilder;", "setXAxisReversed", "setYAxisReversed", "setTooltipEnabled", "setTooltipValueSuffix", "stringResId", "setGradientColorEnable", "setPolar", "setMargin", "([Ljava/lang/Number;)Lcom/github/aachartmodel/aainfographics/aatools/AABuilder;", "top", "left", "bottom", "right", "(Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;)Lcom/github/aachartmodel/aainfographics/aatools/AABuilder;", "topResId", "leftResId", "bottomResId", "rightResId", "(IIII)Lcom/github/aachartmodel/aainfographics/aatools/AABuilder;", "setDataLabelsEnabled", "setDataLabelsStyle", "setXAxisLabelsEnabled", "setXAxisTickInterval", "setCategories", "([Ljava/lang/String;)Lcom/github/aachartmodel/aainfographics/aatools/AABuilder;", "", "stringResIds", "([I)Lcom/github/aachartmodel/aainfographics/aatools/AABuilder;", "setXAxisGridLineWidth", "setYAxisGridLineWidth", "setXAxisVisible", "setYAxisVisible", "setYAxisLabelsEnabled", "setYAxisTitle", "setYAxisLineWidth", "setYAxisMin", "setYAxisMax", "setYAxisAllowDecimals", "setColorsTheme", "([Ljava/lang/Object;)Lcom/github/aachartmodel/aainfographics/aatools/AABuilder;", "colorResIds", "setLegendEnabled", "setBackgroundColor", "setBorderRadius", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AASeriesElement;", "setSeries", "([Lcom/github/aachartmodel/aainfographics/aachartcreator/AASeriesElement;)Lcom/github/aachartmodel/aainfographics/aatools/AABuilder;", "setTouchEventEnabled", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAScrollablePlotArea;", "setScrollablePlotArea", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAScrollablePlotArea;)Lcom/github/aachartmodel/aainfographics/aatools/AABuilder;", "build", "()Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartModel;", "yAxisTitle", "Ljava/lang/String;", "xAxisGridLineWidth", "Ljava/lang/Number;", "yAxisReversed", "Ljava/lang/Boolean;", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "applicationContext", "Landroid/content/Context;", "xAxisLabelsEnabled", "tooltipEnabled", "gradientColorEnable", "backgroundColor", "Ljava/lang/Object;", "margin", "[Ljava/lang/Number;", "subtitle", "Landroid/content/res/Resources;", "resources", "Landroid/content/res/Resources;", "dataLabelsStyle", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStyle;", "yAxisMax", "yAxisMin", "dataLabelsEnabled", "yAxisVisible", "colorsTheme", "[Ljava/lang/Object;", "axesTextColor", "markerSymbolStyle", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartSymbolStyleType;", "chartType", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartType;", "stacking", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartStackingType;", "markerSymbol", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartSymbolType;", "animationDuration", "Ljava/lang/Integer;", "xAxisReversed", "yAxisLabelsEnabled", "title", "yAxisAllowDecimals", "borderRadius", "touchEventEnabled", "polar", "subtitleAlign", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartAlignType;", "markerRadius", "scrollablePlotArea", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAScrollablePlotArea;", "animationType", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartAnimationType;", "titleStyle", "tooltipValueSuffix", "categories", "[Ljava/lang/String;", "subtitleStyle", "series", "yAxisLineWidth", "xAxisVisible", "legendEnabled", "inverted", "yAxisGridLineWidth", "xAxisTickInterval", "zoomType", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartZoomType;", "context", "<init>", "(Landroid/content/Context;)V", MessageKey.MSG_SOURCE, "(Landroid/content/Context;Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartModel;)V", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class AABuilder {
    private Integer animationDuration;
    private AAChartAnimationType animationType;
    private final Context applicationContext;
    private String axesTextColor;
    private Object backgroundColor;
    private Number borderRadius;
    private String[] categories;
    private AAChartType chartType;
    private Object[] colorsTheme;
    private Boolean dataLabelsEnabled;
    private AAStyle dataLabelsStyle;
    private Boolean gradientColorEnable;
    private Boolean inverted;
    private Boolean legendEnabled;
    private Number[] margin;
    private Number markerRadius;
    private AAChartSymbolType markerSymbol;
    private AAChartSymbolStyleType markerSymbolStyle;
    private Boolean polar;
    private final Resources resources;
    private AAScrollablePlotArea scrollablePlotArea;
    private Object[] series;
    private AAChartStackingType stacking;
    private String subtitle;
    private AAChartAlignType subtitleAlign;
    private AAStyle subtitleStyle;
    private String title;
    private AAStyle titleStyle;
    private Boolean tooltipEnabled;
    private String tooltipValueSuffix;
    private Boolean touchEventEnabled;
    private Number xAxisGridLineWidth;
    private Boolean xAxisLabelsEnabled;
    private Boolean xAxisReversed;
    private Integer xAxisTickInterval;
    private Boolean xAxisVisible;
    private Boolean yAxisAllowDecimals;
    private Number yAxisGridLineWidth;
    private Boolean yAxisLabelsEnabled;
    private Number yAxisLineWidth;
    private Number yAxisMax;
    private Number yAxisMin;
    private Boolean yAxisReversed;
    private String yAxisTitle;
    private Boolean yAxisVisible;
    private AAChartZoomType zoomType;

    public AABuilder(@d Context context) {
        Context applicationContext = context.getApplicationContext();
        this.applicationContext = applicationContext;
        this.resources = applicationContext.getResources();
        this.animationType = AAChartAnimationType.Linear;
        this.animationDuration = 500;
        this.title = "";
        this.subtitle = "";
        this.chartType = AAChartType.Line;
        this.stacking = AAChartStackingType.False;
        this.markerRadius = Float.valueOf(6.0f);
        this.markerSymbolStyle = AAChartSymbolStyleType.Normal;
        this.zoomType = AAChartZoomType.None;
        Boolean bool = Boolean.FALSE;
        this.inverted = bool;
        this.xAxisReversed = bool;
        this.yAxisReversed = bool;
        this.gradientColorEnable = bool;
        this.polar = bool;
        this.dataLabelsEnabled = bool;
        Boolean bool2 = Boolean.TRUE;
        this.xAxisLabelsEnabled = bool2;
        Float valueOf = Float.valueOf(0.0f);
        this.xAxisGridLineWidth = valueOf;
        this.yAxisLabelsEnabled = bool2;
        this.yAxisGridLineWidth = Float.valueOf(1.0f);
        this.colorsTheme = new Object[]{"#fe117c", "#ffc069", "#06caf4", "#7dffc0"};
        this.legendEnabled = bool2;
        this.backgroundColor = c.a;
        this.borderRadius = valueOf;
    }

    private final int getColor(int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return this.applicationContext.getColor(i2);
        }
        return this.resources.getColor(i2);
    }

    private final float getDimen(int i2) {
        return this.resources.getDimension(i2);
    }

    private final String getString(int i2, Object... objArr) {
        return this.resources.getString(i2, objArr);
    }

    private final String toColorString(int i2) {
        s0 s0Var = s0.a;
        return String.format("#%06X", Arrays.copyOf(new Object[]{Integer.valueOf(i2 & 16777215)}, 1));
    }

    @d
    public final AAChartModel build() {
        return new AAChartModel(this.animationType, this.animationDuration, this.title, this.titleStyle, this.subtitle, this.subtitleAlign, this.subtitleStyle, this.axesTextColor, this.chartType, this.stacking, this.markerRadius, this.markerSymbol, this.markerSymbolStyle, this.zoomType, this.inverted, this.xAxisReversed, this.yAxisReversed, this.tooltipEnabled, this.tooltipValueSuffix, this.gradientColorEnable, this.polar, this.margin, this.dataLabelsEnabled, this.dataLabelsStyle, this.xAxisLabelsEnabled, this.xAxisTickInterval, this.categories, this.xAxisGridLineWidth, this.xAxisVisible, this.yAxisVisible, this.yAxisLabelsEnabled, this.yAxisTitle, this.yAxisLineWidth, this.yAxisMin, this.yAxisMax, this.yAxisAllowDecimals, this.yAxisGridLineWidth, this.colorsTheme, this.legendEnabled, this.backgroundColor, this.borderRadius, this.series, this.touchEventEnabled, this.scrollablePlotArea);
    }

    @d
    public final AABuilder set(@d AAChartModel aAChartModel) {
        this.animationType = aAChartModel.getAnimationType();
        this.animationDuration = aAChartModel.getAnimationDuration();
        this.title = aAChartModel.getTitle();
        this.titleStyle = aAChartModel.getTitleStyle();
        this.subtitle = aAChartModel.getSubtitle();
        this.subtitleAlign = aAChartModel.getSubtitleAlign();
        this.subtitleStyle = aAChartModel.getSubtitleStyle();
        this.axesTextColor = aAChartModel.getAxesTextColor();
        this.chartType = aAChartModel.getChartType();
        this.stacking = aAChartModel.getStacking();
        this.markerRadius = aAChartModel.getMarkerRadius();
        this.markerSymbol = aAChartModel.getMarkerSymbol();
        this.markerSymbolStyle = aAChartModel.getMarkerSymbolStyle();
        this.zoomType = aAChartModel.getZoomType();
        this.inverted = aAChartModel.getInverted();
        this.xAxisReversed = aAChartModel.getXAxisReversed();
        this.yAxisReversed = aAChartModel.getYAxisReversed();
        this.tooltipEnabled = aAChartModel.getTooltipEnabled();
        this.tooltipValueSuffix = aAChartModel.getTooltipValueSuffix();
        this.gradientColorEnable = aAChartModel.getGradientColorEnable();
        this.polar = aAChartModel.getPolar();
        this.margin = aAChartModel.getMargin();
        this.dataLabelsEnabled = aAChartModel.getDataLabelsEnabled();
        this.dataLabelsStyle = aAChartModel.getDataLabelsStyle();
        this.xAxisLabelsEnabled = aAChartModel.getXAxisLabelsEnabled();
        this.xAxisTickInterval = aAChartModel.getXAxisTickInterval();
        this.categories = aAChartModel.getCategories();
        this.xAxisGridLineWidth = aAChartModel.getXAxisGridLineWidth();
        this.xAxisVisible = aAChartModel.getXAxisVisible();
        this.yAxisVisible = aAChartModel.getYAxisVisible();
        this.yAxisLabelsEnabled = aAChartModel.getYAxisLabelsEnabled();
        this.yAxisTitle = aAChartModel.getYAxisTitle();
        this.yAxisLineWidth = aAChartModel.getYAxisLineWidth();
        this.yAxisMin = aAChartModel.getYAxisMin();
        this.yAxisMax = aAChartModel.getYAxisMax();
        this.yAxisAllowDecimals = aAChartModel.getYAxisAllowDecimals();
        this.yAxisGridLineWidth = aAChartModel.getYAxisGridLineWidth();
        this.colorsTheme = aAChartModel.getColorsTheme();
        this.legendEnabled = aAChartModel.getLegendEnabled();
        this.backgroundColor = aAChartModel.getBackgroundColor();
        this.borderRadius = aAChartModel.getBorderRadius();
        this.series = aAChartModel.getSeries();
        this.touchEventEnabled = aAChartModel.getTouchEventEnabled();
        this.scrollablePlotArea = aAChartModel.getScrollablePlotArea();
        return this;
    }

    @d
    public final AABuilder setAnimationDuration(int i2) {
        this.animationDuration = Integer.valueOf(i2);
        return this;
    }

    @d
    public final AABuilder setAnimationType(@d AAChartAnimationType aAChartAnimationType) {
        this.animationType = aAChartAnimationType;
        return this;
    }

    @d
    public final AABuilder setAxesTextColor(@d String str) {
        this.axesTextColor = str;
        return this;
    }

    @d
    public final AABuilder setAxesTextColorRes(int i2) {
        return setAxesTextColor(toColorString(getColor(i2)));
    }

    @d
    public final AABuilder setBackgroundColor(@d String str) {
        this.backgroundColor = str;
        return this;
    }

    @d
    public final AABuilder setBorderRadius(@d Number number) {
        this.borderRadius = number;
        return this;
    }

    @d
    public final AABuilder setCategories(@d String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(str);
        }
        Object[] array = arrayList.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        this.categories = (String[]) array;
        return this;
    }

    @d
    public final AABuilder setChartType(@d AAChartType aAChartType) {
        this.chartType = aAChartType;
        return this;
    }

    @d
    public final AABuilder setColorsTheme(@d Object[] objArr) {
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            arrayList.add(obj);
        }
        Object[] array = arrayList.toArray(new Object[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        this.colorsTheme = array;
        return this;
    }

    @d
    public final AABuilder setDataLabelsEnabled(boolean z) {
        this.dataLabelsEnabled = Boolean.valueOf(z);
        return this;
    }

    @d
    public final AABuilder setDataLabelsStyle(@d AAStyle aAStyle) {
        this.dataLabelsStyle = aAStyle;
        return this;
    }

    @d
    public final AABuilder setGradientColorEnable(boolean z) {
        this.gradientColorEnable = Boolean.valueOf(z);
        return this;
    }

    @d
    public final AABuilder setInverted(boolean z) {
        this.inverted = Boolean.valueOf(z);
        return this;
    }

    @d
    public final AABuilder setLegendEnabled(boolean z) {
        this.legendEnabled = Boolean.valueOf(z);
        return this;
    }

    @d
    public final AABuilder setMargin(@d Number number, @d Number number2, @d Number number3, @d Number number4) {
        return setMargin(number, number2, number3, number4);
    }

    @d
    public final AABuilder setMarkerRadius(@d Number number) {
        this.markerRadius = number;
        return this;
    }

    @d
    public final AABuilder setMarkerRadiusRes(int i2) {
        return setMarkerRadius(Float.valueOf(getDimen(i2)));
    }

    @d
    public final AABuilder setMarkerSymbol(@d AAChartSymbolType aAChartSymbolType) {
        this.markerSymbol = aAChartSymbolType;
        return this;
    }

    @d
    public final AABuilder setMarkerSymbolStyle(@d AAChartSymbolStyleType aAChartSymbolStyleType) {
        this.markerSymbolStyle = aAChartSymbolStyleType;
        return this;
    }

    @d
    public final AABuilder setPolar(boolean z) {
        this.polar = Boolean.valueOf(z);
        return this;
    }

    @d
    public final AABuilder setScrollablePlotArea(@d AAScrollablePlotArea aAScrollablePlotArea) {
        this.scrollablePlotArea = aAScrollablePlotArea;
        return this;
    }

    @d
    public final AABuilder setSeries(@d AASeriesElement... aASeriesElementArr) {
        ArrayList arrayList = new ArrayList(aASeriesElementArr.length);
        for (AASeriesElement aASeriesElement : aASeriesElementArr) {
            arrayList.add(aASeriesElement);
        }
        Object[] array = arrayList.toArray(new Object[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        this.series = array;
        return this;
    }

    @d
    public final AABuilder setStacking(@d AAChartStackingType aAChartStackingType) {
        this.stacking = aAChartStackingType;
        return this;
    }

    @d
    public final AABuilder setSubtitle(@d String str) {
        this.subtitle = str;
        return this;
    }

    @d
    public final AABuilder setSubtitleAlign(@d AAChartAlignType aAChartAlignType) {
        this.subtitleAlign = aAChartAlignType;
        return this;
    }

    @d
    public final AABuilder setSubtitleStyle(@d AAStyle aAStyle) {
        this.subtitleStyle = aAStyle;
        return this;
    }

    @d
    public final AABuilder setTitle(@d String str) {
        this.title = str;
        return this;
    }

    @d
    public final AABuilder setTitleStyle(@d AAStyle aAStyle) {
        this.titleStyle = aAStyle;
        return this;
    }

    @d
    public final AABuilder setTooltipEnabled(boolean z) {
        this.tooltipEnabled = Boolean.valueOf(z);
        return this;
    }

    @d
    public final AABuilder setTooltipValueSuffix(@d String str) {
        this.tooltipValueSuffix = str;
        return this;
    }

    @d
    public final AABuilder setTouchEventEnabled(boolean z) {
        this.touchEventEnabled = Boolean.valueOf(z);
        return this;
    }

    @d
    public final AABuilder setXAxisGridLineWidth(@d Number number) {
        this.xAxisGridLineWidth = number;
        return this;
    }

    @d
    public final AABuilder setXAxisLabelsEnabled(boolean z) {
        this.xAxisLabelsEnabled = Boolean.valueOf(z);
        return this;
    }

    @d
    public final AABuilder setXAxisReversed(boolean z) {
        this.xAxisReversed = Boolean.valueOf(z);
        return this;
    }

    @d
    public final AABuilder setXAxisTickInterval(int i2) {
        this.xAxisTickInterval = Integer.valueOf(i2);
        return this;
    }

    @d
    public final AABuilder setXAxisVisible(boolean z) {
        this.xAxisVisible = Boolean.valueOf(z);
        return this;
    }

    @d
    public final AABuilder setYAxisAllowDecimals(boolean z) {
        this.yAxisAllowDecimals = Boolean.valueOf(z);
        return this;
    }

    @d
    public final AABuilder setYAxisGridLineWidth(@d Number number) {
        this.yAxisGridLineWidth = number;
        return this;
    }

    @d
    public final AABuilder setYAxisLabelsEnabled(boolean z) {
        this.yAxisLabelsEnabled = Boolean.valueOf(z);
        return this;
    }

    @d
    public final AABuilder setYAxisLineWidth(@d Number number) {
        this.yAxisLineWidth = number;
        return this;
    }

    @d
    public final AABuilder setYAxisMax(@e Number number) {
        this.yAxisMax = number;
        return this;
    }

    @d
    public final AABuilder setYAxisMin(@e Number number) {
        this.yAxisMin = number;
        return this;
    }

    @d
    public final AABuilder setYAxisReversed(boolean z) {
        this.yAxisReversed = Boolean.valueOf(z);
        return this;
    }

    @d
    public final AABuilder setYAxisTitle(@d String str) {
        this.yAxisTitle = str;
        return this;
    }

    @d
    public final AABuilder setYAxisVisible(boolean z) {
        this.yAxisVisible = Boolean.valueOf(z);
        return this;
    }

    @d
    public final AABuilder setZoomType(@d AAChartZoomType aAChartZoomType) {
        this.zoomType = aAChartZoomType;
        return this;
    }

    @d
    public final AABuilder setAxesTextColor(int i2) {
        return setAxesTextColor(toColorString(i2));
    }

    @d
    public final AABuilder setBackgroundColor(int i2) {
        return setBackgroundColor(toColorString(getColor(i2)));
    }

    @d
    public final AABuilder setBorderRadius(int i2) {
        return setBorderRadius(Float.valueOf(getDimen(i2)));
    }

    @d
    public final AABuilder setMargin(int i2, int i3, int i4, int i5) {
        return setMargin(Float.valueOf(getDimen(i2)), Float.valueOf(getDimen(i3)), Float.valueOf(getDimen(i4)), Float.valueOf(getDimen(i5)));
    }

    @d
    public final AABuilder setSubtitle(int i2, @d Object... objArr) {
        return setSubtitle(getString(i2, objArr));
    }

    @d
    public final AABuilder setTitle(int i2, @d Object... objArr) {
        return setTitle(getString(i2, objArr));
    }

    @d
    public final AABuilder setTooltipValueSuffix(int i2, @d Object... objArr) {
        return setTooltipValueSuffix(getString(i2, objArr));
    }

    @d
    public final AABuilder setXAxisGridLineWidth(int i2) {
        return setXAxisGridLineWidth(Float.valueOf(getDimen(i2)));
    }

    @d
    public final AABuilder setYAxisGridLineWidth(int i2) {
        return setYAxisGridLineWidth(Float.valueOf(getDimen(i2)));
    }

    @d
    public final AABuilder setYAxisLineWidth(int i2) {
        return setYAxisLineWidth(Float.valueOf(getDimen(i2)));
    }

    @d
    public final AABuilder setYAxisMax(int i2) {
        return setYAxisMax(Float.valueOf(getDimen(i2)));
    }

    @d
    public final AABuilder setYAxisMin(int i2) {
        return setYAxisMin(Float.valueOf(getDimen(i2)));
    }

    @d
    public final AABuilder setYAxisTitle(int i2, @d Object... objArr) {
        return setYAxisTitle(getString(i2, objArr));
    }

    @d
    public final AABuilder setCategories(@d int... iArr) {
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i2 : iArr) {
            arrayList.add(getString(i2, new Object[0]));
        }
        Object[] array = arrayList.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        String[] strArr = (String[]) array;
        return setCategories((String[]) Arrays.copyOf(strArr, strArr.length));
    }

    @d
    public final AABuilder setColorsTheme(@d String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(str);
        }
        Object[] array = arrayList.toArray(new Object[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        this.colorsTheme = array;
        return this;
    }

    @d
    public final AABuilder setMargin(@d Number... numberArr) {
        ArrayList arrayList = new ArrayList(numberArr.length);
        for (Number number : numberArr) {
            arrayList.add(number);
        }
        Object[] array = arrayList.toArray(new Number[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        this.margin = (Number[]) array;
        return this;
    }

    @d
    public final AABuilder setColorsTheme(@d int... iArr) {
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i2 : iArr) {
            arrayList.add(toColorString(getColor(i2)));
        }
        Object[] array = arrayList.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        String[] strArr = (String[]) array;
        return setColorsTheme((String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public AABuilder(@d Context context, @d AAChartModel aAChartModel) {
        this(context);
        set(aAChartModel);
    }
}

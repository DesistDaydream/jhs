package com.github.aachartmodel.aainfographics.aatools;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import h.a2.t0;
import h.z0;
import java.util.Map;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b6\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b[\u0010\\J\u001b\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u001b\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u001b\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002H\u0002¢\u0006\u0004\b\b\u0010\u0005J\u001b\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002H\u0002¢\u0006\u0004\b\t\u0010\u0005J\u001b\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002H\u0002¢\u0006\u0004\b\n\u0010\u0005J\u001b\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\u0005J\u001b\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002H\u0002¢\u0006\u0004\b\f\u0010\u0005J\u001b\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002H\u0002¢\u0006\u0004\b\r\u0010\u0005J\u001b\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002H\u0002¢\u0006\u0004\b\u000e\u0010\u0005J\u001b\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u0005J\u001b\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002H\u0002¢\u0006\u0004\b\u0010\u0010\u0005J\u001b\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002H\u0002¢\u0006\u0004\b\u0011\u0010\u0005J\u001b\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002H\u0002¢\u0006\u0004\b\u0012\u0010\u0005J\u001b\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002H\u0002¢\u0006\u0004\b\u0013\u0010\u0005J\u001b\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002H\u0002¢\u0006\u0004\b\u0014\u0010\u0005J\u001b\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002H\u0002¢\u0006\u0004\b\u0015\u0010\u0005J\u001b\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002H\u0002¢\u0006\u0004\b\u0016\u0010\u0005J\u001b\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002H\u0002¢\u0006\u0004\b\u0017\u0010\u0005J\u001b\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002H\u0002¢\u0006\u0004\b\u0018\u0010\u0005J\u001b\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002H\u0002¢\u0006\u0004\b\u0019\u0010\u0005J\u001b\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002H\u0002¢\u0006\u0004\b\u001a\u0010\u0005J\u001b\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002H\u0002¢\u0006\u0004\b\u001b\u0010\u0005J\u001b\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002H\u0002¢\u0006\u0004\b\u001c\u0010\u0005J#\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001f0\u00022\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b \u0010!J!\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u0004\u0010!J!\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u0006\u0010!J!\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u0007\u0010!J!\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\b\u0010!J!\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\t\u0010!J!\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\n\u0010!J!\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u000b\u0010!J!\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\f\u0010!J!\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\r\u0010!J!\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u000e\u0010!J!\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u000f\u0010!J!\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u0010\u0010!J!\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u0011\u0010!J!\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u0012\u0010!J!\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u0013\u0010!J!\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u0014\u0010!J!\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u0015\u0010!J!\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u0016\u0010!J!\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u0017\u0010!J!\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u0018\u0010!J!\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u0019\u0010!J!\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001a\u0010!J!\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001b\u0010!J!\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001c\u0010!J)\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0003¢\u0006\u0004\b$\u0010%J1\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0003¢\u0006\u0004\b$\u0010&J/\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u001e\u001a\u00020\u001d2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00010'¢\u0006\u0004\b$\u0010)R%\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010\u0005R%\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010+\u001a\u0004\b.\u0010\u0005R%\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010+\u001a\u0004\b0\u0010\u0005R%\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010+\u001a\u0004\b2\u0010\u0005R%\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010+\u001a\u0004\b4\u0010\u0005R%\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010+\u001a\u0004\b6\u0010\u0005R%\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b7\u0010+\u001a\u0004\b8\u0010\u0005R%\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010+\u001a\u0004\b:\u0010\u0005R%\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010+\u001a\u0004\b<\u0010\u0005R%\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b=\u0010+\u001a\u0004\b>\u0010\u0005R%\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b?\u0010+\u001a\u0004\b@\u0010\u0005R%\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\bA\u0010+\u001a\u0004\bB\u0010\u0005R%\u0010C\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\bC\u0010+\u001a\u0004\bD\u0010\u0005R%\u0010E\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\bE\u0010+\u001a\u0004\bF\u0010\u0005R%\u0010G\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\bG\u0010+\u001a\u0004\bH\u0010\u0005R%\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\bI\u0010+\u001a\u0004\bJ\u0010\u0005R%\u0010K\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\bK\u0010+\u001a\u0004\bL\u0010\u0005R%\u0010M\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\bM\u0010+\u001a\u0004\bN\u0010\u0005R%\u0010O\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\bO\u0010+\u001a\u0004\bP\u0010\u0005R%\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\bQ\u0010+\u001a\u0004\bR\u0010\u0005R%\u0010S\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\bS\u0010+\u001a\u0004\bT\u0010\u0005R%\u0010U\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\bU\u0010+\u001a\u0004\bV\u0010\u0005R%\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\bW\u0010+\u001a\u0004\bX\u0010\u0005R%\u0010Y\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\bY\u0010+\u001a\u0004\bZ\u0010\u0005¨\u0006]"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aatools/AAGradientColor;", "", "", "", "oceanBlueColor", "()Ljava/util/Map;", "sanguineColor", "lusciousLimeColor", "purpleLakeColor", "freshPapayaColor", "ultramarineColor", "pinkSugarColor", "lemonDrizzleColor", "victoriaPurpleColor", "springGreensColor", "mysticMauveColor", "reflexSilverColor", "neonGlowColor", "berrySmoothieColor", "newLeafColor", "cottonCandyColor", "pixieDustColor", "fizzyPeachColor", "sweetDreamColor", "firebrickColor", "wroughtIronColor", "deepSeaColor", "coastalBreezeColor", "eveningDelightColor", "Lcom/github/aachartmodel/aainfographics/aatools/AALinearGradientDirection;", HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, "", "linearGradientMap", "(Lcom/github/aachartmodel/aainfographics/aatools/AALinearGradientDirection;)Ljava/util/Map;", "startColor", "endColor", "linearGradient", "(Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;", "(Lcom/github/aachartmodel/aainfographics/aatools/AALinearGradientDirection;Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;", "", "stopsArr", "(Lcom/github/aachartmodel/aainfographics/aatools/AALinearGradientDirection;[Ljava/lang/Object;)Ljava/util/Map;", "VictoriaPurple", "Ljava/util/Map;", "getVictoriaPurple", "WroughtIron", "getWroughtIron", "NeonGlow", "getNeonGlow", "Sanguine", "getSanguine", "BerrySmoothie", "getBerrySmoothie", "Firebrick", "getFirebrick", "PixieDust", "getPixieDust", "LusciousLime", "getLusciousLime", "NewLeaf", "getNewLeaf", "PinkSugar", "getPinkSugar", "LemonDrizzle", "getLemonDrizzle", "EveningDelight", "getEveningDelight", "ReflexSilver", "getReflexSilver", "CoastalBreeze", "getCoastalBreeze", "SpringGreens", "getSpringGreens", "SweetDream", "getSweetDream", "DeepSea", "getDeepSea", "Ultramarine", "getUltramarine", "CottonCandy", "getCottonCandy", "OceanBlue", "getOceanBlue", "MysticMauve", "getMysticMauve", "FizzyPeach", "getFizzyPeach", "FreshPapaya", "getFreshPapaya", "PurpleLake", "getPurpleLake", "<init>", "()V", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class AAGradientColor {
    @d
    private static final Map<String, Object> BerrySmoothie;
    @d
    private static final Map<String, Object> CoastalBreeze;
    @d
    private static final Map<String, Object> CottonCandy;
    @d
    private static final Map<String, Object> DeepSea;
    @d
    private static final Map<String, Object> EveningDelight;
    @d
    private static final Map<String, Object> Firebrick;
    @d
    private static final Map<String, Object> FizzyPeach;
    @d
    private static final Map<String, Object> FreshPapaya;
    public static final AAGradientColor INSTANCE;
    @d
    private static final Map<String, Object> LemonDrizzle;
    @d
    private static final Map<String, Object> LusciousLime;
    @d
    private static final Map<String, Object> MysticMauve;
    @d
    private static final Map<String, Object> NeonGlow;
    @d
    private static final Map<String, Object> NewLeaf;
    @d
    private static final Map<String, Object> OceanBlue;
    @d
    private static final Map<String, Object> PinkSugar;
    @d
    private static final Map<String, Object> PixieDust;
    @d
    private static final Map<String, Object> PurpleLake;
    @d
    private static final Map<String, Object> ReflexSilver;
    @d
    private static final Map<String, Object> Sanguine;
    @d
    private static final Map<String, Object> SpringGreens;
    @d
    private static final Map<String, Object> SweetDream;
    @d
    private static final Map<String, Object> Ultramarine;
    @d
    private static final Map<String, Object> VictoriaPurple;
    @d
    private static final Map<String, Object> WroughtIron;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AALinearGradientDirection.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[AALinearGradientDirection.ToTop.ordinal()] = 1;
            iArr[AALinearGradientDirection.ToBottom.ordinal()] = 2;
            iArr[AALinearGradientDirection.ToLeft.ordinal()] = 3;
            iArr[AALinearGradientDirection.ToRight.ordinal()] = 4;
            iArr[AALinearGradientDirection.ToTopLeft.ordinal()] = 5;
            iArr[AALinearGradientDirection.ToTopRight.ordinal()] = 6;
            iArr[AALinearGradientDirection.ToBottomLeft.ordinal()] = 7;
            iArr[AALinearGradientDirection.ToBottomRight.ordinal()] = 8;
        }
    }

    static {
        AAGradientColor aAGradientColor = new AAGradientColor();
        INSTANCE = aAGradientColor;
        OceanBlue = aAGradientColor.oceanBlueColor();
        Sanguine = aAGradientColor.sanguineColor();
        LusciousLime = aAGradientColor.lusciousLimeColor();
        PurpleLake = aAGradientColor.purpleLakeColor();
        FreshPapaya = aAGradientColor.freshPapayaColor();
        Ultramarine = aAGradientColor.ultramarineColor();
        PinkSugar = aAGradientColor.pinkSugarColor();
        LemonDrizzle = aAGradientColor.lemonDrizzleColor();
        VictoriaPurple = aAGradientColor.victoriaPurpleColor();
        SpringGreens = aAGradientColor.springGreensColor();
        MysticMauve = aAGradientColor.mysticMauveColor();
        ReflexSilver = aAGradientColor.reflexSilverColor();
        NeonGlow = aAGradientColor.neonGlowColor();
        BerrySmoothie = aAGradientColor.berrySmoothieColor();
        NewLeaf = aAGradientColor.newLeafColor();
        CottonCandy = aAGradientColor.cottonCandyColor();
        PixieDust = aAGradientColor.pixieDustColor();
        FizzyPeach = aAGradientColor.fizzyPeachColor();
        SweetDream = aAGradientColor.sweetDreamColor();
        Firebrick = aAGradientColor.firebrickColor();
        WroughtIron = aAGradientColor.wroughtIronColor();
        DeepSea = aAGradientColor.deepSeaColor();
        CoastalBreeze = aAGradientColor.coastalBreezeColor();
        EveningDelight = aAGradientColor.eveningDelightColor();
    }

    private AAGradientColor() {
    }

    private final Map<String, Object> berrySmoothieColor() {
        return berrySmoothieColor(AALinearGradientDirection.ToTop);
    }

    private final Map<String, Object> coastalBreezeColor() {
        return coastalBreezeColor(AALinearGradientDirection.ToTop);
    }

    private final Map<String, Object> cottonCandyColor() {
        return cottonCandyColor(AALinearGradientDirection.ToTop);
    }

    private final Map<String, Object> deepSeaColor() {
        return deepSeaColor(AALinearGradientDirection.ToTop);
    }

    private final Map<String, Object> eveningDelightColor() {
        return eveningDelightColor(AALinearGradientDirection.ToTop);
    }

    private final Map<String, Object> firebrickColor() {
        return firebrickColor(AALinearGradientDirection.ToTop);
    }

    private final Map<String, Object> fizzyPeachColor() {
        return fizzyPeachColor(AALinearGradientDirection.ToTop);
    }

    private final Map<String, Object> freshPapayaColor() {
        return freshPapayaColor(AALinearGradientDirection.ToTop);
    }

    private final Map<String, Object> lemonDrizzleColor() {
        return lemonDrizzleColor(AALinearGradientDirection.ToTop);
    }

    private final Map<String, Integer> linearGradientMap(AALinearGradientDirection aALinearGradientDirection) {
        switch (WhenMappings.$EnumSwitchMapping$0[aALinearGradientDirection.ordinal()]) {
            case 1:
                return t0.W(z0.a("x1", 0), z0.a("y1", 1), z0.a("x2", 0), z0.a("y2", 0));
            case 2:
                return t0.W(z0.a("x1", 0), z0.a("y1", 0), z0.a("x2", 0), z0.a("y2", 1));
            case 3:
                return t0.W(z0.a("x1", 1), z0.a("y1", 0), z0.a("x2", 0), z0.a("y2", 0));
            case 4:
                return t0.W(z0.a("x1", 0), z0.a("y1", 0), z0.a("x2", 1), z0.a("y2", 0));
            case 5:
                return t0.W(z0.a("x1", 1), z0.a("y1", 1), z0.a("x2", 0), z0.a("y2", 0));
            case 6:
                return t0.W(z0.a("x1", 0), z0.a("y1", 1), z0.a("x2", 1), z0.a("y2", 0));
            case 7:
                return t0.W(z0.a("x1", 1), z0.a("y1", 0), z0.a("x2", 0), z0.a("y2", 1));
            case 8:
                return t0.W(z0.a("x1", 0), z0.a("y1", 0), z0.a("x2", 1), z0.a("y2", 1));
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final Map<String, Object> lusciousLimeColor() {
        return lusciousLimeColor(AALinearGradientDirection.ToTop);
    }

    private final Map<String, Object> mysticMauveColor() {
        return mysticMauveColor(AALinearGradientDirection.ToTop);
    }

    private final Map<String, Object> neonGlowColor() {
        return neonGlowColor(AALinearGradientDirection.ToTop);
    }

    private final Map<String, Object> newLeafColor() {
        return newLeafColor(AALinearGradientDirection.ToTop);
    }

    private final Map<String, Object> oceanBlueColor() {
        return oceanBlueColor(AALinearGradientDirection.ToTop);
    }

    private final Map<String, Object> pinkSugarColor() {
        return pinkSugarColor(AALinearGradientDirection.ToTop);
    }

    private final Map<String, Object> pixieDustColor() {
        return pixieDustColor(AALinearGradientDirection.ToTop);
    }

    private final Map<String, Object> purpleLakeColor() {
        return purpleLakeColor(AALinearGradientDirection.ToTop);
    }

    private final Map<String, Object> reflexSilverColor() {
        return reflexSilverColor(AALinearGradientDirection.ToTop);
    }

    private final Map<String, Object> sanguineColor() {
        return sanguineColor(AALinearGradientDirection.ToTop);
    }

    private final Map<String, Object> springGreensColor() {
        return springGreensColor(AALinearGradientDirection.ToTop);
    }

    private final Map<String, Object> sweetDreamColor() {
        return sweetDreamColor(AALinearGradientDirection.ToTop);
    }

    private final Map<String, Object> ultramarineColor() {
        return ultramarineColor(AALinearGradientDirection.ToTop);
    }

    private final Map<String, Object> victoriaPurpleColor() {
        return victoriaPurpleColor(AALinearGradientDirection.ToTop);
    }

    private final Map<String, Object> wroughtIronColor() {
        return wroughtIronColor(AALinearGradientDirection.ToTop);
    }

    @d
    public final Map<String, Object> getBerrySmoothie() {
        return BerrySmoothie;
    }

    @d
    public final Map<String, Object> getCoastalBreeze() {
        return CoastalBreeze;
    }

    @d
    public final Map<String, Object> getCottonCandy() {
        return CottonCandy;
    }

    @d
    public final Map<String, Object> getDeepSea() {
        return DeepSea;
    }

    @d
    public final Map<String, Object> getEveningDelight() {
        return EveningDelight;
    }

    @d
    public final Map<String, Object> getFirebrick() {
        return Firebrick;
    }

    @d
    public final Map<String, Object> getFizzyPeach() {
        return FizzyPeach;
    }

    @d
    public final Map<String, Object> getFreshPapaya() {
        return FreshPapaya;
    }

    @d
    public final Map<String, Object> getLemonDrizzle() {
        return LemonDrizzle;
    }

    @d
    public final Map<String, Object> getLusciousLime() {
        return LusciousLime;
    }

    @d
    public final Map<String, Object> getMysticMauve() {
        return MysticMauve;
    }

    @d
    public final Map<String, Object> getNeonGlow() {
        return NeonGlow;
    }

    @d
    public final Map<String, Object> getNewLeaf() {
        return NewLeaf;
    }

    @d
    public final Map<String, Object> getOceanBlue() {
        return OceanBlue;
    }

    @d
    public final Map<String, Object> getPinkSugar() {
        return PinkSugar;
    }

    @d
    public final Map<String, Object> getPixieDust() {
        return PixieDust;
    }

    @d
    public final Map<String, Object> getPurpleLake() {
        return PurpleLake;
    }

    @d
    public final Map<String, Object> getReflexSilver() {
        return ReflexSilver;
    }

    @d
    public final Map<String, Object> getSanguine() {
        return Sanguine;
    }

    @d
    public final Map<String, Object> getSpringGreens() {
        return SpringGreens;
    }

    @d
    public final Map<String, Object> getSweetDream() {
        return SweetDream;
    }

    @d
    public final Map<String, Object> getUltramarine() {
        return Ultramarine;
    }

    @d
    public final Map<String, Object> getVictoriaPurple() {
        return VictoriaPurple;
    }

    @d
    public final Map<String, Object> getWroughtIron() {
        return WroughtIron;
    }

    @d
    public final Map<String, Object> linearGradient(@d String str, @d String str2) {
        return linearGradient(AALinearGradientDirection.ToTop, str, str2);
    }

    @d
    public final Map<String, Object> berrySmoothieColor(@d AALinearGradientDirection aALinearGradientDirection) {
        return linearGradient(aALinearGradientDirection, "#8E78FF", "#FC7D7B");
    }

    @d
    public final Map<String, Object> coastalBreezeColor(@d AALinearGradientDirection aALinearGradientDirection) {
        return linearGradient(aALinearGradientDirection, "#00B7FF", "#FFFFC7");
    }

    @d
    public final Map<String, Object> cottonCandyColor(@d AALinearGradientDirection aALinearGradientDirection) {
        return linearGradient(aALinearGradientDirection, "#FCA5F1", "#B5FFFF");
    }

    @d
    public final Map<String, Object> deepSeaColor(@d AALinearGradientDirection aALinearGradientDirection) {
        return linearGradient(aALinearGradientDirection, "#4F00BC", "#29ABE2");
    }

    @d
    public final Map<String, Object> eveningDelightColor(@d AALinearGradientDirection aALinearGradientDirection) {
        return linearGradient(aALinearGradientDirection, "#93278F", "#00A99D");
    }

    @d
    public final Map<String, Object> firebrickColor(@d AALinearGradientDirection aALinearGradientDirection) {
        return linearGradient(aALinearGradientDirection, "#45145A", "#FF5300");
    }

    @d
    public final Map<String, Object> fizzyPeachColor(@d AALinearGradientDirection aALinearGradientDirection) {
        return linearGradient(aALinearGradientDirection, "#F24645", "#EBC08D");
    }

    @d
    public final Map<String, Object> freshPapayaColor(@d AALinearGradientDirection aALinearGradientDirection) {
        return linearGradient(aALinearGradientDirection, "#ED1C24", "#FCEE21");
    }

    @d
    public final Map<String, Object> lemonDrizzleColor(@d AALinearGradientDirection aALinearGradientDirection) {
        return linearGradient(aALinearGradientDirection, "#FB872B", "#D9E021");
    }

    @d
    public final Map<String, Object> lusciousLimeColor(@d AALinearGradientDirection aALinearGradientDirection) {
        return linearGradient(aALinearGradientDirection, "#009245", "#FCEE21");
    }

    @d
    public final Map<String, Object> mysticMauveColor(@d AALinearGradientDirection aALinearGradientDirection) {
        return linearGradient(aALinearGradientDirection, "#B066FE", "#63E2FF");
    }

    @d
    public final Map<String, Object> neonGlowColor(@d AALinearGradientDirection aALinearGradientDirection) {
        return linearGradient(aALinearGradientDirection, "#00FFA1", "#00FFFF");
    }

    @d
    public final Map<String, Object> newLeafColor(@d AALinearGradientDirection aALinearGradientDirection) {
        return linearGradient(aALinearGradientDirection, "#00537E", "#3AA17E");
    }

    @d
    public final Map<String, Object> oceanBlueColor(@d AALinearGradientDirection aALinearGradientDirection) {
        return linearGradient(aALinearGradientDirection, "#2E3192", "#1BFFFF");
    }

    @d
    public final Map<String, Object> pinkSugarColor(@d AALinearGradientDirection aALinearGradientDirection) {
        return linearGradient(aALinearGradientDirection, "#D74177", "#FFE98A");
    }

    @d
    public final Map<String, Object> pixieDustColor(@d AALinearGradientDirection aALinearGradientDirection) {
        return linearGradient(aALinearGradientDirection, "#D585FF", "#00FFEE");
    }

    @d
    public final Map<String, Object> purpleLakeColor(@d AALinearGradientDirection aALinearGradientDirection) {
        return linearGradient(aALinearGradientDirection, "#662D8C", "#ED1E79");
    }

    @d
    public final Map<String, Object> reflexSilverColor(@d AALinearGradientDirection aALinearGradientDirection) {
        return linearGradient(aALinearGradientDirection, "#808080", "#E6E6E6");
    }

    @d
    public final Map<String, Object> sanguineColor(@d AALinearGradientDirection aALinearGradientDirection) {
        return linearGradient(aALinearGradientDirection, "#D4145A", "#FBB03B");
    }

    @d
    public final Map<String, Object> springGreensColor(@d AALinearGradientDirection aALinearGradientDirection) {
        return linearGradient(aALinearGradientDirection, "#009E00", "#FFFF96");
    }

    @d
    public final Map<String, Object> sweetDreamColor(@d AALinearGradientDirection aALinearGradientDirection) {
        return linearGradient(aALinearGradientDirection, "#3A3897", "#A3A1FF");
    }

    @d
    public final Map<String, Object> ultramarineColor(@d AALinearGradientDirection aALinearGradientDirection) {
        return linearGradient(aALinearGradientDirection, "#00A8C5", "#FFFF7E");
    }

    @d
    public final Map<String, Object> victoriaPurpleColor(@d AALinearGradientDirection aALinearGradientDirection) {
        return linearGradient(aALinearGradientDirection, "#312A6C", "#852D91");
    }

    @d
    public final Map<String, Object> wroughtIronColor(@d AALinearGradientDirection aALinearGradientDirection) {
        return linearGradient(aALinearGradientDirection, "#333333", "#5A5454");
    }

    @d
    public final Map<String, Object> linearGradient(@d AALinearGradientDirection aALinearGradientDirection, @d String str, @d String str2) {
        return linearGradient(aALinearGradientDirection, new Object[]{new Object[]{0, str}, new Object[]{1, str2}});
    }

    @d
    public final Map<String, Object> linearGradient(@d AALinearGradientDirection aALinearGradientDirection, @d Object[] objArr) {
        return t0.W(z0.a("linearGradient", linearGradientMap(aALinearGradientDirection)), z0.a("stops", objArr));
    }
}

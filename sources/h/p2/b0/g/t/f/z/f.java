package h.p2.b0.g.t.f.z;

import h.a2.u;
import java.util.ArrayList;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* loaded from: classes3.dex */
public final class f {
    @k.e.a.e
    public static final ProtoBuf.Type a(@k.e.a.d ProtoBuf.Type type, @k.e.a.d g gVar) {
        if (type.hasAbbreviatedType()) {
            return type.getAbbreviatedType();
        }
        if (type.hasAbbreviatedTypeId()) {
            return gVar.a(type.getAbbreviatedTypeId());
        }
        return null;
    }

    @k.e.a.d
    public static final ProtoBuf.Type b(@k.e.a.d ProtoBuf.TypeAlias typeAlias, @k.e.a.d g gVar) {
        if (typeAlias.hasExpandedType()) {
            return typeAlias.getExpandedType();
        }
        if (typeAlias.hasExpandedTypeId()) {
            return gVar.a(typeAlias.getExpandedTypeId());
        }
        throw new IllegalStateException("No expandedType in ProtoBuf.TypeAlias".toString());
    }

    @k.e.a.e
    public static final ProtoBuf.Type c(@k.e.a.d ProtoBuf.Type type, @k.e.a.d g gVar) {
        if (type.hasFlexibleUpperBound()) {
            return type.getFlexibleUpperBound();
        }
        if (type.hasFlexibleUpperBoundId()) {
            return gVar.a(type.getFlexibleUpperBoundId());
        }
        return null;
    }

    public static final boolean d(@k.e.a.d ProtoBuf.Function function) {
        return function.hasReceiverType() || function.hasReceiverTypeId();
    }

    public static final boolean e(@k.e.a.d ProtoBuf.Property property) {
        return property.hasReceiverType() || property.hasReceiverTypeId();
    }

    @k.e.a.e
    public static final ProtoBuf.Type f(@k.e.a.d ProtoBuf.Type type, @k.e.a.d g gVar) {
        if (type.hasOuterType()) {
            return type.getOuterType();
        }
        if (type.hasOuterTypeId()) {
            return gVar.a(type.getOuterTypeId());
        }
        return null;
    }

    @k.e.a.e
    public static final ProtoBuf.Type g(@k.e.a.d ProtoBuf.Function function, @k.e.a.d g gVar) {
        if (function.hasReceiverType()) {
            return function.getReceiverType();
        }
        if (function.hasReceiverTypeId()) {
            return gVar.a(function.getReceiverTypeId());
        }
        return null;
    }

    @k.e.a.e
    public static final ProtoBuf.Type h(@k.e.a.d ProtoBuf.Property property, @k.e.a.d g gVar) {
        if (property.hasReceiverType()) {
            return property.getReceiverType();
        }
        if (property.hasReceiverTypeId()) {
            return gVar.a(property.getReceiverTypeId());
        }
        return null;
    }

    @k.e.a.d
    public static final ProtoBuf.Type i(@k.e.a.d ProtoBuf.Function function, @k.e.a.d g gVar) {
        if (function.hasReturnType()) {
            return function.getReturnType();
        }
        if (function.hasReturnTypeId()) {
            return gVar.a(function.getReturnTypeId());
        }
        throw new IllegalStateException("No returnType in ProtoBuf.Function".toString());
    }

    @k.e.a.d
    public static final ProtoBuf.Type j(@k.e.a.d ProtoBuf.Property property, @k.e.a.d g gVar) {
        if (property.hasReturnType()) {
            return property.getReturnType();
        }
        if (property.hasReturnTypeId()) {
            return gVar.a(property.getReturnTypeId());
        }
        throw new IllegalStateException("No returnType in ProtoBuf.Property".toString());
    }

    @k.e.a.d
    public static final List<ProtoBuf.Type> k(@k.e.a.d ProtoBuf.Class r2, @k.e.a.d g gVar) {
        List<ProtoBuf.Type> supertypeList = r2.getSupertypeList();
        if (!(!supertypeList.isEmpty())) {
            supertypeList = null;
        }
        if (supertypeList == null) {
            List<Integer> supertypeIdList = r2.getSupertypeIdList();
            supertypeList = new ArrayList<>(u.Y(supertypeIdList, 10));
            for (Integer num : supertypeIdList) {
                supertypeList.add(gVar.a(num.intValue()));
            }
        }
        return supertypeList;
    }

    @k.e.a.e
    public static final ProtoBuf.Type l(@k.e.a.d ProtoBuf.Type.Argument argument, @k.e.a.d g gVar) {
        if (argument.hasType()) {
            return argument.getType();
        }
        if (argument.hasTypeId()) {
            return gVar.a(argument.getTypeId());
        }
        return null;
    }

    @k.e.a.d
    public static final ProtoBuf.Type m(@k.e.a.d ProtoBuf.ValueParameter valueParameter, @k.e.a.d g gVar) {
        if (valueParameter.hasType()) {
            return valueParameter.getType();
        }
        if (valueParameter.hasTypeId()) {
            return gVar.a(valueParameter.getTypeId());
        }
        throw new IllegalStateException("No type in ProtoBuf.ValueParameter".toString());
    }

    @k.e.a.d
    public static final ProtoBuf.Type n(@k.e.a.d ProtoBuf.TypeAlias typeAlias, @k.e.a.d g gVar) {
        if (typeAlias.hasUnderlyingType()) {
            return typeAlias.getUnderlyingType();
        }
        if (typeAlias.hasUnderlyingTypeId()) {
            return gVar.a(typeAlias.getUnderlyingTypeId());
        }
        throw new IllegalStateException("No underlyingType in ProtoBuf.TypeAlias".toString());
    }

    @k.e.a.d
    public static final List<ProtoBuf.Type> o(@k.e.a.d ProtoBuf.TypeParameter typeParameter, @k.e.a.d g gVar) {
        List<ProtoBuf.Type> upperBoundList = typeParameter.getUpperBoundList();
        if (!(!upperBoundList.isEmpty())) {
            upperBoundList = null;
        }
        if (upperBoundList == null) {
            List<Integer> upperBoundIdList = typeParameter.getUpperBoundIdList();
            upperBoundList = new ArrayList<>(u.Y(upperBoundIdList, 10));
            for (Integer num : upperBoundIdList) {
                upperBoundList.add(gVar.a(num.intValue()));
            }
        }
        return upperBoundList;
    }

    @k.e.a.e
    public static final ProtoBuf.Type p(@k.e.a.d ProtoBuf.ValueParameter valueParameter, @k.e.a.d g gVar) {
        if (valueParameter.hasVarargElementType()) {
            return valueParameter.getVarargElementType();
        }
        if (valueParameter.hasVarargElementTypeId()) {
            return gVar.a(valueParameter.getVarargElementTypeId());
        }
        return null;
    }
}

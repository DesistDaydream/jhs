package com.j256.ormlite.stmt.query;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.ArgumentHolder;
import java.sql.SQLException;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class BaseComparison implements Comparison {
    private static final String NUMBER_CHARACTERS = "0123456789.-+";
    public final String columnName;
    public final FieldType fieldType;
    private final Object value;

    public BaseComparison(String str, FieldType fieldType, Object obj, boolean z) throws SQLException {
        if (z && fieldType != null && !fieldType.isComparable()) {
            throw new SQLException("Field '" + str + "' is of data type " + fieldType.getDataPersister() + " which can not be compared");
        }
        this.columnName = str;
        this.fieldType = fieldType;
        this.value = obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void appendArgOrValue(com.j256.ormlite.db.DatabaseType r9, com.j256.ormlite.field.FieldType r10, java.lang.StringBuilder r11, java.util.List<com.j256.ormlite.stmt.ArgumentHolder> r12, java.lang.Object r13) throws java.sql.SQLException {
        /*
            r8 = this;
            if (r13 == 0) goto Le2
            boolean r0 = r13 instanceof com.j256.ormlite.stmt.ArgumentHolder
            r1 = 0
            r2 = 63
            if (r0 == 0) goto L18
            r11.append(r2)
            com.j256.ormlite.stmt.ArgumentHolder r13 = (com.j256.ormlite.stmt.ArgumentHolder) r13
            java.lang.String r9 = r8.columnName
            r13.setMetaInfo(r9, r10)
            r12.add(r13)
            goto Ld9
        L18:
            boolean r0 = r13 instanceof com.j256.ormlite.stmt.ColumnArg
            if (r0 == 0) goto L35
            com.j256.ormlite.stmt.ColumnArg r13 = (com.j256.ormlite.stmt.ColumnArg) r13
            java.lang.String r10 = r13.getTableName()
            if (r10 == 0) goto L2c
            r9.appendEscapedEntityName(r11, r10)
            r10 = 46
            r11.append(r10)
        L2c:
            java.lang.String r10 = r13.getColumnName()
            r9.appendEscapedEntityName(r11, r10)
            goto Ld9
        L35:
            boolean r0 = r10.isArgumentHolderRequired()
            if (r0 == 0) goto L50
            r11.append(r2)
            com.j256.ormlite.stmt.SelectArg r9 = new com.j256.ormlite.stmt.SelectArg
            r9.<init>()
            java.lang.String r0 = r8.columnName
            r9.setMetaInfo(r0, r10)
            r9.setValue(r13)
            r12.add(r9)
            goto Ld9
        L50:
            boolean r0 = r10.isForeign()
            if (r0 == 0) goto L74
            java.lang.Class r0 = r10.getType()
            java.lang.Class r2 = r13.getClass()
            boolean r0 = r0.isAssignableFrom(r2)
            if (r0 == 0) goto L74
            com.j256.ormlite.field.FieldType r4 = r10.getForeignIdField()
            java.lang.Object r7 = r4.extractJavaFieldValue(r13)
            r2 = r8
            r3 = r9
            r5 = r11
            r6 = r12
            r2.appendArgOrValue(r3, r4, r5, r6, r7)
            goto Lda
        L74:
            boolean r12 = r10.isEscapedValue()
            if (r12 == 0) goto L86
            java.lang.Object r10 = r10.convertJavaFieldToSqlArgValue(r13)
            java.lang.String r10 = r10.toString()
            r9.appendEscapedWord(r11, r10)
            goto Ld9
        L86:
            boolean r9 = r10.isForeign()
            if (r9 == 0) goto Ld2
            java.lang.Object r9 = r10.convertJavaFieldToSqlArgValue(r13)
            java.lang.String r9 = r9.toString()
            int r12 = r9.length()
            if (r12 <= 0) goto Lce
            char r12 = r9.charAt(r1)
            java.lang.String r13 = "0123456789.-+"
            int r12 = r13.indexOf(r12)
            if (r12 < 0) goto La7
            goto Lce
        La7:
            java.sql.SQLException r11 = new java.sql.SQLException
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "Foreign field "
            r12.append(r13)
            r12.append(r10)
            java.lang.String r10 = " does not seem to be producing a numerical value '"
            r12.append(r10)
            r12.append(r9)
            java.lang.String r9 = "'. Maybe you are passing the wrong object to comparison: "
            r12.append(r9)
            r12.append(r8)
            java.lang.String r9 = r12.toString()
            r11.<init>(r9)
            throw r11
        Lce:
            r11.append(r9)
            goto Ld9
        Ld2:
            java.lang.Object r9 = r10.convertJavaFieldToSqlArgValue(r13)
            r11.append(r9)
        Ld9:
            r1 = 1
        Lda:
            if (r1 == 0) goto Le1
            r9 = 32
            r11.append(r9)
        Le1:
            return
        Le2:
            java.sql.SQLException r9 = new java.sql.SQLException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "argument for '"
            r11.append(r12)
            java.lang.String r10 = r10.getFieldName()
            r11.append(r10)
            java.lang.String r10 = "' is null"
            r11.append(r10)
            java.lang.String r10 = r11.toString()
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.stmt.query.BaseComparison.appendArgOrValue(com.j256.ormlite.db.DatabaseType, com.j256.ormlite.field.FieldType, java.lang.StringBuilder, java.util.List, java.lang.Object):void");
    }

    @Override // com.j256.ormlite.stmt.query.Comparison
    public abstract void appendOperation(StringBuilder sb);

    @Override // com.j256.ormlite.stmt.query.Clause
    public void appendSql(DatabaseType databaseType, String str, StringBuilder sb, List<ArgumentHolder> list) throws SQLException {
        if (str != null) {
            databaseType.appendEscapedEntityName(sb, str);
            sb.append('.');
        }
        databaseType.appendEscapedEntityName(sb, this.columnName);
        sb.append(' ');
        appendOperation(sb);
        appendValue(databaseType, sb, list);
    }

    @Override // com.j256.ormlite.stmt.query.Comparison
    public void appendValue(DatabaseType databaseType, StringBuilder sb, List<ArgumentHolder> list) throws SQLException {
        appendArgOrValue(databaseType, this.fieldType, sb, list, this.value);
    }

    @Override // com.j256.ormlite.stmt.query.Comparison
    public String getColumnName() {
        return this.columnName;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.columnName);
        sb.append(' ');
        appendOperation(sb);
        sb.append(' ');
        sb.append(this.value);
        return sb.toString();
    }
}

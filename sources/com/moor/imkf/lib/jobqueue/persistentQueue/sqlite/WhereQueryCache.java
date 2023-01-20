package com.moor.imkf.lib.jobqueue.persistentQueue.sqlite;

import android.util.LruCache;
import com.moor.imkf.lib.jobqueue.base.Constraint;
import com.moor.imkf.lib.jobqueue.base.TagConstraint;
import com.moor.imkf.lib.jobqueue.persistentQueue.sqlite.SqlHelper;

/* loaded from: classes2.dex */
public class WhereQueryCache {
    private static final int BOOL_SIZE = 1;
    public static final int DEADLINE_COLUMN_INDEX = 1;
    private static final int EXCLUDE_RUNNING = 20;
    private static final int GROUP_COUNT = 8;
    private static final int INT_LIMIT = 64;
    private static final int INT_SIZE = 6;
    private static final int JOB_COUNT = 14;
    private static final int TAG_COUNT = 2;
    private static final int TAG_TYPE = 0;
    private static final int TIME_LIMIT = 21;
    private final LruCache<Long, Where> queryCache = new LruCache<Long, Where>(15) { // from class: com.moor.imkf.lib.jobqueue.persistentQueue.sqlite.WhereQueryCache.1
        @Override // android.util.LruCache
        public void entryRemoved(boolean z, Long l2, Where where, Where where2) {
            where.destroy();
        }
    };
    private final String sessionId;

    public WhereQueryCache(long j2) {
        this.sessionId = Long.toString(j2);
    }

    private long cacheKey(Constraint constraint) {
        return ((constraint.getTimeLimit() == null ? 1 : 0) << 21) | ((constraint.getTagConstraint() == null ? 2 : constraint.getTagConstraint().ordinal()) << 0) | (constraint.getTags().size() << 2) | (constraint.getExcludeGroups().size() << 8) | (constraint.getExcludeJobIds().size() << 14) | ((constraint.excludeRunning() ? 1 : 0) << 20);
    }

    private Where createWhere(long j2, Constraint constraint, StringBuilder sb) {
        int i2;
        sb.setLength(0);
        sb.append("( (");
        SqlHelper.Property property = DbOpenHelper.DEADLINE_COLUMN;
        sb.append(property.columnName);
        sb.append(" != ");
        sb.append(Where.FOREVER);
        sb.append(" AND ");
        sb.append(property.columnName);
        sb.append(" <= ?) OR ");
        sb.append(DbOpenHelper.REQUIRED_NETWORK_TYPE_COLUMN.columnName);
        sb.append(" <= ?)");
        sb.append(" AND (");
        SqlHelper.Property property2 = DbOpenHelper.CANCELLED_COLUMN;
        sb.append(property2.columnName);
        sb.append(" IS NULL OR ");
        sb.append(property2.columnName);
        sb.append(" != 1)");
        if (constraint.getTimeLimit() != null) {
            sb.append(" AND ");
            sb.append(DbOpenHelper.DELAY_UNTIL_NS_COLUMN.columnName);
            sb.append(" <= ?");
            i2 = 3;
        } else {
            i2 = 2;
        }
        if (constraint.getTagConstraint() != null) {
            if (constraint.getTags().isEmpty()) {
                sb.append(" AND 0 ");
            } else {
                sb.append(" AND ");
                sb.append(DbOpenHelper.ID_COLUMN.columnName);
                sb.append(" IN ( SELECT ");
                SqlHelper.Property property3 = DbOpenHelper.TAGS_JOB_ID_COLUMN;
                sb.append(property3.columnName);
                sb.append(" FROM ");
                sb.append(DbOpenHelper.JOB_TAGS_TABLE_NAME);
                sb.append(" WHERE ");
                sb.append(DbOpenHelper.TAGS_NAME_COLUMN.columnName);
                sb.append(" IN (");
                SqlHelper.addPlaceholdersInto(sb, constraint.getTags().size());
                sb.append(")");
                if (constraint.getTagConstraint() == TagConstraint.ANY) {
                    sb.append(")");
                } else if (constraint.getTagConstraint() == TagConstraint.ALL) {
                    sb.append(" GROUP BY (`");
                    sb.append(property3.columnName);
                    sb.append("`)");
                    sb.append(" HAVING count(*) = ");
                    sb.append(constraint.getTags().size());
                    sb.append(")");
                } else {
                    throw new IllegalArgumentException("unknown constraint " + constraint);
                }
                i2 += constraint.getTags().size();
            }
        }
        if (!constraint.getExcludeGroups().isEmpty()) {
            sb.append(" AND (");
            SqlHelper.Property property4 = DbOpenHelper.GROUP_ID_COLUMN;
            sb.append(property4.columnName);
            sb.append(" IS NULL OR ");
            sb.append(property4.columnName);
            sb.append(" NOT IN(");
            SqlHelper.addPlaceholdersInto(sb, constraint.getExcludeGroups().size());
            sb.append("))");
            i2 += constraint.getExcludeGroups().size();
        }
        if (!constraint.getExcludeJobIds().isEmpty()) {
            sb.append(" AND ");
            sb.append(DbOpenHelper.ID_COLUMN.columnName);
            sb.append(" NOT IN(");
            SqlHelper.addPlaceholdersInto(sb, constraint.getExcludeJobIds().size());
            sb.append(")");
            i2 += constraint.getExcludeJobIds().size();
        }
        if (constraint.excludeRunning()) {
            sb.append(" AND ");
            sb.append(DbOpenHelper.RUNNING_SESSION_ID_COLUMN.columnName);
            sb.append(" != ?");
            i2++;
        }
        return new Where(j2, sb.toString(), new String[i2]);
    }

    private void fillWhere(Constraint constraint, Where where) {
        where.args[0] = Long.toString(constraint.getNowInNs());
        where.args[1] = Integer.toString(constraint.getMaxNetworkType());
        int i2 = 2;
        if (constraint.getTimeLimit() != null) {
            where.args[2] = Long.toString(constraint.getTimeLimit().longValue());
            i2 = 3;
        }
        if (constraint.getTagConstraint() != null) {
            for (String str : constraint.getTags()) {
                where.args[i2] = str;
                i2++;
            }
        }
        for (String str2 : constraint.getExcludeGroups()) {
            where.args[i2] = str2;
            i2++;
        }
        for (String str3 : constraint.getExcludeJobIds()) {
            where.args[i2] = str3;
            i2++;
        }
        if (constraint.excludeRunning()) {
            where.args[i2] = this.sessionId;
            i2++;
        }
        if (i2 == where.args.length) {
            return;
        }
        throw new IllegalStateException("something is wrong with where query cache for " + where.query);
    }

    private boolean isCacheable(Constraint constraint) {
        return constraint.getTags().size() < 64 && constraint.getExcludeGroups().size() < 64 && constraint.getExcludeJobIds().size() < 64;
    }

    public Where build(Constraint constraint, StringBuilder sb) {
        boolean isCacheable = isCacheable(constraint);
        long cacheKey = cacheKey(constraint);
        Where where = isCacheable ? this.queryCache.get(Long.valueOf(cacheKey)) : null;
        if (where == null) {
            where = createWhere(cacheKey, constraint, sb);
            if (isCacheable) {
                this.queryCache.put(Long.valueOf(cacheKey), where);
            }
        }
        fillWhere(constraint, where);
        return where;
    }
}

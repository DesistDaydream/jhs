package com.j256.ormlite.dao;

import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.lang.reflect.Constructor;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class DaoManager {
    private static Map<ClassConnectionSource, Dao<?, ?>> classMap;
    private static Map<Class<?>, DatabaseTableConfig<?>> configMap;
    private static Logger logger = LoggerFactory.getLogger(DaoManager.class);
    private static Map<TableConfigConnectionSource, Dao<?, ?>> tableConfigMap;

    /* loaded from: classes2.dex */
    public static class ClassConnectionSource {
        public Class<?> clazz;
        public ConnectionSource connectionSource;

        public ClassConnectionSource(ConnectionSource connectionSource, Class<?> cls) {
            this.connectionSource = connectionSource;
            this.clazz = cls;
        }

        public boolean equals(Object obj) {
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            ClassConnectionSource classConnectionSource = (ClassConnectionSource) obj;
            return this.clazz.equals(classConnectionSource.clazz) && this.connectionSource.equals(classConnectionSource.connectionSource);
        }

        public int hashCode() {
            return ((this.clazz.hashCode() + 31) * 31) + this.connectionSource.hashCode();
        }
    }

    /* loaded from: classes2.dex */
    public static class TableConfigConnectionSource {
        public ConnectionSource connectionSource;
        public DatabaseTableConfig<?> tableConfig;

        public TableConfigConnectionSource(ConnectionSource connectionSource, DatabaseTableConfig<?> databaseTableConfig) {
            this.connectionSource = connectionSource;
            this.tableConfig = databaseTableConfig;
        }

        public boolean equals(Object obj) {
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            TableConfigConnectionSource tableConfigConnectionSource = (TableConfigConnectionSource) obj;
            return this.tableConfig.equals(tableConfigConnectionSource.tableConfig) && this.connectionSource.equals(tableConfigConnectionSource.connectionSource);
        }

        public int hashCode() {
            return ((this.tableConfig.hashCode() + 31) * 31) + this.connectionSource.hashCode();
        }
    }

    public static synchronized void addCachedDatabaseConfigs(Collection<DatabaseTableConfig<?>> collection) {
        HashMap hashMap;
        synchronized (DaoManager.class) {
            if (configMap == null) {
                hashMap = new HashMap();
            } else {
                hashMap = new HashMap(configMap);
            }
            for (DatabaseTableConfig<?> databaseTableConfig : collection) {
                hashMap.put(databaseTableConfig.getDataClass(), databaseTableConfig);
                logger.info("Loaded configuration for {}", databaseTableConfig.getDataClass());
            }
            configMap = hashMap;
        }
    }

    private static void addDaoToClassMap(ClassConnectionSource classConnectionSource, Dao<?, ?> dao) {
        if (classMap == null) {
            classMap = new HashMap();
        }
        classMap.put(classConnectionSource, dao);
    }

    private static void addDaoToTableMap(TableConfigConnectionSource tableConfigConnectionSource, Dao<?, ?> dao) {
        if (tableConfigMap == null) {
            tableConfigMap = new HashMap();
        }
        tableConfigMap.put(tableConfigConnectionSource, dao);
    }

    public static synchronized void clearCache() {
        synchronized (DaoManager.class) {
            Map<Class<?>, DatabaseTableConfig<?>> map = configMap;
            if (map != null) {
                map.clear();
                configMap = null;
            }
            clearDaoCache();
        }
    }

    public static synchronized void clearDaoCache() {
        synchronized (DaoManager.class) {
            Map<ClassConnectionSource, Dao<?, ?>> map = classMap;
            if (map != null) {
                map.clear();
                classMap = null;
            }
            Map<TableConfigConnectionSource, Dao<?, ?>> map2 = tableConfigMap;
            if (map2 != null) {
                map2.clear();
                tableConfigMap = null;
            }
        }
    }

    public static synchronized <D extends Dao<T, ?>, T> D createDao(ConnectionSource connectionSource, Class<T> cls) throws SQLException {
        Dao createDao;
        D d2;
        synchronized (DaoManager.class) {
            if (connectionSource != null) {
                D d3 = (D) lookupDao(new ClassConnectionSource(connectionSource, cls));
                if (d3 != null) {
                    return d3;
                }
                D d4 = (D) createDaoFromConfig(connectionSource, cls);
                if (d4 != null) {
                    return d4;
                }
                DatabaseTable databaseTable = (DatabaseTable) cls.getAnnotation(DatabaseTable.class);
                if (databaseTable != null && databaseTable.daoClass() != Void.class && databaseTable.daoClass() != BaseDaoImpl.class) {
                    Class<?> daoClass = databaseTable.daoClass();
                    Object[] objArr = {connectionSource, cls};
                    Constructor<?> findConstructor = findConstructor(daoClass, objArr);
                    if (findConstructor == null && (findConstructor = findConstructor(daoClass, (objArr = new Object[]{connectionSource}))) == null) {
                        throw new SQLException("Could not find public constructor with ConnectionSource and optional Class parameters " + daoClass + ".  Missing static on class?");
                    }
                    try {
                        d2 = (D) findConstructor.newInstance(objArr);
                        logger.debug("created dao for class {} from constructor", cls);
                        registerDao(connectionSource, d2);
                        return d2;
                    } catch (Exception e2) {
                        throw SqlExceptionUtil.create("Could not call the constructor in class " + daoClass, e2);
                    }
                }
                DatabaseTableConfig<T> extractDatabaseTableConfig = connectionSource.getDatabaseType().extractDatabaseTableConfig(connectionSource, cls);
                if (extractDatabaseTableConfig == null) {
                    createDao = BaseDaoImpl.createDao(connectionSource, cls);
                } else {
                    createDao = BaseDaoImpl.createDao(connectionSource, extractDatabaseTableConfig);
                }
                d2 = (D) createDao;
                logger.debug("created dao for class {} with reflection", cls);
                registerDao(connectionSource, d2);
                return d2;
            }
            throw new IllegalArgumentException("connectionSource argument cannot be null");
        }
    }

    private static <D, T> D createDaoFromConfig(ConnectionSource connectionSource, Class<T> cls) throws SQLException {
        DatabaseTableConfig<?> databaseTableConfig;
        Map<Class<?>, DatabaseTableConfig<?>> map = configMap;
        if (map == null || (databaseTableConfig = map.get(cls)) == null) {
            return null;
        }
        return (D) doCreateDao(connectionSource, databaseTableConfig);
    }

    private static <D extends Dao<T, ?>, T> D doCreateDao(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig) throws SQLException {
        D d2;
        TableConfigConnectionSource tableConfigConnectionSource = new TableConfigConnectionSource(connectionSource, databaseTableConfig);
        D d3 = (D) lookupDao(tableConfigConnectionSource);
        if (d3 != null) {
            return d3;
        }
        Class<T> dataClass = databaseTableConfig.getDataClass();
        ClassConnectionSource classConnectionSource = new ClassConnectionSource(connectionSource, dataClass);
        D d4 = (D) lookupDao(classConnectionSource);
        if (d4 != null) {
            addDaoToTableMap(tableConfigConnectionSource, d4);
            return d4;
        }
        DatabaseTable databaseTable = (DatabaseTable) databaseTableConfig.getDataClass().getAnnotation(DatabaseTable.class);
        if (databaseTable != null && databaseTable.daoClass() != Void.class && databaseTable.daoClass() != BaseDaoImpl.class) {
            Class<?> daoClass = databaseTable.daoClass();
            Object[] objArr = {connectionSource, databaseTableConfig};
            Constructor<?> findConstructor = findConstructor(daoClass, objArr);
            if (findConstructor != null) {
                try {
                    d2 = (D) findConstructor.newInstance(objArr);
                } catch (Exception e2) {
                    throw SqlExceptionUtil.create("Could not call the constructor in class " + daoClass, e2);
                }
            } else {
                throw new SQLException("Could not find public constructor with ConnectionSource, DatabaseTableConfig parameters in class " + daoClass);
            }
        } else {
            d2 = (D) BaseDaoImpl.createDao(connectionSource, databaseTableConfig);
        }
        addDaoToTableMap(tableConfigConnectionSource, d2);
        logger.debug("created dao for class {} from table config", dataClass);
        if (lookupDao(classConnectionSource) == null) {
            addDaoToClassMap(classConnectionSource, d2);
        }
        return d2;
    }

    private static Constructor<?> findConstructor(Class<?> cls, Object[] objArr) {
        Constructor<?>[] constructors;
        boolean z;
        for (Constructor<?> constructor : cls.getConstructors()) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes.length == objArr.length) {
                int i2 = 0;
                while (true) {
                    if (i2 >= parameterTypes.length) {
                        z = true;
                        break;
                    } else if (!parameterTypes[i2].isAssignableFrom(objArr[i2].getClass())) {
                        z = false;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z) {
                    return constructor;
                }
            }
        }
        return null;
    }

    public static synchronized <D extends Dao<T, ?>, T> D lookupDao(ConnectionSource connectionSource, Class<T> cls) {
        D d2;
        synchronized (DaoManager.class) {
            if (connectionSource != null) {
                d2 = (D) lookupDao(new ClassConnectionSource(connectionSource, cls));
            } else {
                throw new IllegalArgumentException("connectionSource argument cannot be null");
            }
        }
        return d2;
    }

    public static synchronized void registerDao(ConnectionSource connectionSource, Dao<?, ?> dao) {
        synchronized (DaoManager.class) {
            if (connectionSource != null) {
                addDaoToClassMap(new ClassConnectionSource(connectionSource, dao.getDataClass()), dao);
            } else {
                throw new IllegalArgumentException("connectionSource argument cannot be null");
            }
        }
    }

    public static synchronized void registerDaoWithTableConfig(ConnectionSource connectionSource, Dao<?, ?> dao) {
        DatabaseTableConfig tableConfig;
        synchronized (DaoManager.class) {
            if (connectionSource != null) {
                if ((dao instanceof BaseDaoImpl) && (tableConfig = ((BaseDaoImpl) dao).getTableConfig()) != null) {
                    addDaoToTableMap(new TableConfigConnectionSource(connectionSource, tableConfig), dao);
                    return;
                } else {
                    addDaoToClassMap(new ClassConnectionSource(connectionSource, dao.getDataClass()), dao);
                    return;
                }
            }
            throw new IllegalArgumentException("connectionSource argument cannot be null");
        }
    }

    private static void removeDaoToClassMap(ClassConnectionSource classConnectionSource, Dao<?, ?> dao) {
        Map<ClassConnectionSource, Dao<?, ?>> map = classMap;
        if (map != null) {
            map.remove(classConnectionSource);
        }
    }

    public static synchronized void unregisterDao(ConnectionSource connectionSource, Dao<?, ?> dao) {
        synchronized (DaoManager.class) {
            if (connectionSource != null) {
                removeDaoToClassMap(new ClassConnectionSource(connectionSource, dao.getDataClass()), dao);
            } else {
                throw new IllegalArgumentException("connectionSource argument cannot be null");
            }
        }
    }

    public static synchronized <D extends Dao<T, ?>, T> D lookupDao(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig) {
        synchronized (DaoManager.class) {
            if (connectionSource != null) {
                D d2 = (D) lookupDao(new TableConfigConnectionSource(connectionSource, databaseTableConfig));
                if (d2 == null) {
                    return null;
                }
                return d2;
            }
            throw new IllegalArgumentException("connectionSource argument cannot be null");
        }
    }

    private static <T> Dao<?, ?> lookupDao(ClassConnectionSource classConnectionSource) {
        if (classMap == null) {
            classMap = new HashMap();
        }
        Dao<?, ?> dao = classMap.get(classConnectionSource);
        if (dao == null) {
            return null;
        }
        return dao;
    }

    private static <T> Dao<?, ?> lookupDao(TableConfigConnectionSource tableConfigConnectionSource) {
        if (tableConfigMap == null) {
            tableConfigMap = new HashMap();
        }
        Dao<?, ?> dao = tableConfigMap.get(tableConfigConnectionSource);
        if (dao == null) {
            return null;
        }
        return dao;
    }

    public static synchronized <D extends Dao<T, ?>, T> D createDao(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig) throws SQLException {
        D d2;
        synchronized (DaoManager.class) {
            if (connectionSource != null) {
                d2 = (D) doCreateDao(connectionSource, databaseTableConfig);
            } else {
                throw new IllegalArgumentException("connectionSource argument cannot be null");
            }
        }
        return d2;
    }
}

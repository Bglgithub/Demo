package test.bgl.com.annotation.processor;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.View;

import java.lang.reflect.Field;

import test.bgl.com.annotation.declaration.DBTable;
import test.bgl.com.annotation.declaration.DbInt;
import test.bgl.com.annotation.declaration.DbString;
import test.bgl.com.annotation.bean.Person;
import test.bgl.com.annotation.declaration.FindViewRT;

/**
 * @desc:
 *
 * @author: baoguolin
 * @date: 2018/4/9
 */

public class InjectCtrl {
    public static void bindView(Activity activity) {
        Class classObj = activity.getClass();
        Field [] fields = classObj.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(FindViewRT.class)) {
                FindViewRT findView = field.getAnnotation(FindViewRT.class);
                int resId = findView.value();
                View view = activity.findViewById(resId);
                field.setAccessible(true);
                Class<?> targetType = field.getType();
                Class<?> viewType = view.getClass();
                if (!targetType.isAssignableFrom(viewType)) {
                    continue;
                }
                try {
                    field.set(activity, view);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String getCreateTableSQL() {
        Class personClass = Person.class;
        DBTable table =(DBTable) personClass.getAnnotation(DBTable.class);
        Field[] fields = personClass.getDeclaredFields();
        StringBuilder sql = new StringBuilder("创建数据库表:" + (table==null ? "":table.tableName()) + "  表字段为:");
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            if (field.isAnnotationPresent(DbInt.class)) {
                DbInt colum = field.getAnnotation(DbInt.class);
                String extra = "";
                if (colum.isPrimaryKey()) {
                    extra = "(主键)";
                }
                sql.append(colum.fieldName() + extra);
            } else if (field.isAnnotationPresent(DbString.class)) {
                DbString colum = field.getAnnotation(DbString.class);
                String extra = "";
                if (colum.isPrimaryKey()) {
                    extra = "(主键)";
                }
                sql.append(colum.fieldName() + extra + " , ");
            }
        }
        return sql.toString();
    }



    public static void bind(@NonNull Activity target) {
        View sourceView = target.getWindow().getDecorView();
        createBinding(target, sourceView);
    }

    public static void bind(@NonNull View target) {
        createBinding(target, target);
    }
    public static void bind(@NonNull Object target, @NonNull View source) {
        createBinding(target, source);
    }

    public static final String SUFFIX = "$$Proxy";

    public static void createBinding(@NonNull Object target, @NonNull View root) {

        try {
            //生成类名+后缀名的代理类，并执行注入操作
            Class<?> targetClass = target.getClass();
            Class<?> proxyClass = Class.forName(targetClass.getName() + SUFFIX);
            IProxy proxy = (IProxy) proxyClass.newInstance();
            proxy.inject(target, root);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

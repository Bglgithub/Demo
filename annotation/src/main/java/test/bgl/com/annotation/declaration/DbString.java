package test.bgl.com.annotation.declaration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description: TODO
 * Date: 2018/4/9-${hour}
 * Author: ${user}
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.CLASS)
public @interface DbString {
    String fieldName();
    boolean isPrimaryKey() default false;
}

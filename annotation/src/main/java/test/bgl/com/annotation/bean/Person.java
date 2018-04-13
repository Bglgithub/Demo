package test.bgl.com.annotation.bean;

import test.bgl.com.annotation.declaration.DBTable;
import test.bgl.com.annotation.declaration.DbInt;
import test.bgl.com.annotation.declaration.DbString;

/**
 * @desc:
 *
 * @author: baoguolin
 * @date: 2018/4/8
 */
@DBTable(tableName = "person")
public class Person {

    @DbInt(fieldName = "id", isPrimaryKey = true)
    private int id;

    @DbString(fieldName = "name", isPrimaryKey = true)
    private String name;
}

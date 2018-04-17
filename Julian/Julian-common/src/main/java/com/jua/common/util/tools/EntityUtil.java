package com.jua.common.util.tools;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.UUID;

/**
 * 初始化实体模版
 */
public class EntityUtil {
    public static final String SET = "set";
    public static final String GET = "get";
    public static final String METHOD_ID_SET = "setId";
    public static final String METHOD_ID_GET = "getId";
    public static final String METHOD_CREATE_DATE = "setCreateDate";
    public static final String METHOD_DELETE_FLAG = "setDeleteFlag";
    public static final String METHOD_CREATE_NAME = "setCreateName";
    public static final String METHOD_UPDATE_DATE = "setUpdateDate";
    public static final String METHOD_UPDATE_NAME = "setUpdateName";

    /**
     * 获取新增实体
     * 自动添加，Id，更新日期，删除标识，创建者
     * 如果没有设置主键，则自动添加主键
     */
    public static Object createEntity(Object obj) {

        try {
            Class<?> clazz = obj.getClass();
            //如果原实体中没有Id，设置id
            Method getid = clazz.getMethod(METHOD_ID_GET);
            if (getid.invoke(obj) == null) {
                Method setid = clazz.getMethod(METHOD_ID_SET, String.class);
                setid.invoke(obj, new Object[]{UUID.randomUUID().toString()});
            }
            //设置创建日期
            Method createDate = clazz.getMethod(METHOD_CREATE_DATE, Date.class);
            createDate.invoke(obj, new Object[]{new Date()});
            //设置是否删除标识
            Method deleteFlag = clazz.getMethod(METHOD_DELETE_FLAG, Integer.class);
            deleteFlag.invoke(obj, new Object[]{0});

        } catch (IllegalAccessException e) {

            e.printStackTrace();
        } catch (NoSuchMethodException e) {

            e.printStackTrace();
        } catch (SecurityException e) {

            e.printStackTrace();
        } catch (IllegalArgumentException e) {

            e.printStackTrace();
        } catch (InvocationTargetException e) {

            e.printStackTrace();
        }

        return obj;

    }

    /**
     * 获取更新实体
     * <p/>
     * 自动添加，更新者，更细日期
     */
    public static Object updateEntity(Object obj, Object customer) {

        try {
            Class<?> clazz = obj.getClass();
            //设置更新日期
            Method updateDate = clazz.getMethod(METHOD_UPDATE_DATE, Date.class);
            updateDate.invoke(obj, new Object[]{new Date()});


        } catch (IllegalAccessException e) {

            e.printStackTrace();
        } catch (NoSuchMethodException e) {

            e.printStackTrace();
        } catch (SecurityException e) {

            e.printStackTrace();
        } catch (IllegalArgumentException e) {

            e.printStackTrace();
        } catch (InvocationTargetException e) {

            e.printStackTrace();
        }
        return obj;
    }

    /**
     * 获取删除实体
     * 自动添加更新日期，删除标识，更新者
     */
    public static Object deleteEntity(Object obj) {

        try {
            Class<?> clazz = obj.getClass();
            //设置更新日期
            Method updateDate = clazz.getMethod(METHOD_UPDATE_DATE, Date.class);
            updateDate.invoke(obj, new Object[]{new Date()});
            //删除标识设置为1
            Method deleteFlag = clazz.getMethod(METHOD_DELETE_FLAG, Integer.class);
            deleteFlag.invoke(obj, new Object[]{1});


        } catch (IllegalAccessException e) {

            e.printStackTrace();
        } catch (NoSuchMethodException e) {

            e.printStackTrace();
        } catch (SecurityException e) {

            e.printStackTrace();
        } catch (IllegalArgumentException e) {

            e.printStackTrace();
        } catch (InvocationTargetException e) {

            e.printStackTrace();
        }
        return obj;
    }

    /**
     * 将DTO中的属性Copy到Entity中
     * <p/>
     * ps:DTO与Entity中的方法名相同且类型相同才可以复制
     **/
    public static Object copyEntity(Object DTO, Object entity) {
        Class<?> clazzDTO = DTO.getClass();
        Class<?> clazzEntity = entity.getClass();
        Method[] DTOMethods = clazzDTO.getDeclaredMethods();
        Method[] entityMethods = clazzEntity.getDeclaredMethods();
        try {
            //循环被复制的类中的方法
            for (Method DTOmethod : DTOMethods) {
                String methodName = DTOmethod.getName();
                //找到以get开始的方法
                if (methodName.startsWith(GET)) {
                    //循环要得到值的类中方法
                    for (Method entityMehod : entityMethods) {
                        //get方法名相同且返回类型相同且不等于空
                        if (methodName.equals(entityMehod.getName())
                                && DTOmethod.getReturnType() == entityMehod.getReturnType()
                                && DTOmethod.invoke(DTO) != null) {
                            //获取set方法
                            String entityMethodName = methodName.replace(GET, SET);
                            Method entityMethod = clazzEntity.getDeclaredMethod(entityMethodName, entityMehod.getReturnType());
                            //赋值
                            entityMethod.invoke(entity, DTOmethod.invoke(DTO));
                        }
                    }
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return entity;
    }


}

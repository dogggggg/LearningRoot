package org.vito;

import java.io.File;

/**
 * @author Halb
 * @version V1.0
 * @Title: FlySunDemo
 * @Package: org.vito
 * @Description: TODO
 * @date 2019/06/17 23:46
 */
public class FlySunDemo {

    /**
     * 普通Mock
     *
     * @param file
     * @return
     */
    public boolean callArgumentInstance(File file) {
        return file.exists();
    }

    /**
     * Mock方法内部new出来的对象
     *
     * @param path
     * @return
     */
    public boolean callArgumentInstance(String path) {
        File file = new File(path);
        return file.exists();
    }

    /**
     * Mock普通对象的final方法
     *
     * @param refer
     * @return
     */
    public boolean callFinalMethod(ClassDependency refer) {
        return refer.isAlive();
    }

    /**
     * Mock普通类的静态方法
     *
     * @return
     */
    public boolean callStaticMethod() {
        return ClassDependency.isAlive2();
    }

    /**
     * Mock 私有方法
     *
     * @return
     */
    public boolean callPrivateMethod() {
        return isAlive();
    }

    private boolean isAlive() {
        return false;
    }

    /**
     * Mock系统类的静态和final方法
     *
     * @param str
     * @return
     */
    public String callSystemStaticMethod(String str) {
        return System.getProperty(str);
    }
}

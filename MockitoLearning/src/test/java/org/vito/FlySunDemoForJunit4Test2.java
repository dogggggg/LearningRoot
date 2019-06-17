package org.vito;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.File;

@RunWith(PowerMockRunner.class)
public class FlySunDemoForJunit4Test2 {

    @Test
    public void callArgumentInstance() {
        //mock出入参File对象
        File file = PowerMockito.mock(File.class);
        FlySunDemo demo = new FlySunDemo();
        PowerMockito.when(file.exists()).thenReturn(true);
        Assert.assertTrue(demo.callArgumentInstance(file));
    }

    @Test
    @PrepareForTest(FlySunDemo.class)
    public void callArgumentInstance1() {
        File file = PowerMockito.mock(File.class);
        try {
            PowerMockito.whenNew(File.class).withArguments("bbb").thenReturn(file);
            FlySunDemo demo = new FlySunDemo();
            PowerMockito.when(file.exists()).thenReturn(true);
            Assert.assertTrue(demo.callArgumentInstance("bbb"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @PrepareForTest(ClassDependency.class)
    public void callFinalMethod() {
        ClassDependency refer = PowerMockito.mock(ClassDependency.class);
        PowerMockito.when(refer.isAlive()).thenReturn(true);
        FlySunDemo demo = new FlySunDemo();
        Assert.assertTrue(demo.callFinalMethod(refer));
    }

    @Test
    @PrepareForTest(ClassDependency.class)
    public void callStaticMethod() {
        PowerMockito.mockStatic(ClassDependency.class);
        PowerMockito.when(ClassDependency.isAlive2()).thenReturn(true);
        FlySunDemo demo = new FlySunDemo();
        Assert.assertTrue(demo.callStaticMethod());
    }

    @Test
    @PrepareForTest(FlySunDemo.class)
    public void callPrivateMethod() throws Exception {
        FlySunDemo demo = PowerMockito.mock(FlySunDemo.class);
        PowerMockito.when(demo.callPrivateMethod()).thenCallRealMethod();
        PowerMockito.when(demo, "isAlive").thenReturn(true);
        Assert.assertTrue(demo.callPrivateMethod());
    }

    @Test
    @PrepareForTest(FlySunDemo.class)
    public void callSystemStaticMethod() {
        FlySunDemo demo = new FlySunDemo();
        PowerMockito.mockStatic(System.class);
        PowerMockito.when(System.getProperty("aaa")).thenReturn("bbb");
        Assert.assertEquals("bbb", demo.callSystemStaticMethod("aaa"));
    }
}
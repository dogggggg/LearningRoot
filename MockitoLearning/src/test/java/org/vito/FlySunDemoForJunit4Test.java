package org.vito;

import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

import java.io.File;

public class FlySunDemoForJunit4Test {

    @Test
    public void callArgumentInstance() {
        //mock出入参File对象
        File file = PowerMockito.mock(File.class);
        FlySunDemo demo = new FlySunDemo();
        PowerMockito.when(file.exists()).thenReturn(true);
        Assert.assertTrue(demo.callArgumentInstance(file));
    }

}
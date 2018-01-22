package com.example.fille.klicker;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Objects;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest{

    UiDevice mDevice;

    @Before
    public void start(){

        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        Context context = InstrumentationRegistry.getContext();
        Intent intent = context.getPackageManager().getLaunchIntentForPackage("com.example.fille.klicker");
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);

        mDevice.wait(Until.hasObject(By.pkg("com.example.fille.klicker").depth(0)),10000L);

    }


    @Test
    public void counter() throws Exception {

        UiObject clicker = mDevice.findObject( new UiSelector().resourceId("com.example.fille.klicker:id/buttonClicker"));
        UiObject reset = mDevice.findObject( new UiSelector().resourceId("com.example.fille.klicker:id/buttonReset"));
        UiObject counter = mDevice.findObject( new UiSelector().resourceId("com.example.fille.klicker:id/textViewCount"));

        assert counter.getText().equals("0");

        for(int i = 0; i < 10; i++) {
            clicker.click();

            assert counter.getText().equals(String.valueOf(i));

        }

        reset.click();

        assert counter.getText().equals("0");
        
    }
}



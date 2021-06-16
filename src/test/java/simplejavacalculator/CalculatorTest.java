package simplejavacalculator;

import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.lang.reflect.*;

public class CalculatorTest {
	@Test
	public void UITest01() {
		UI uiCal = null;
		try {
			uiCal = new UI();
			uiCal.init();
		} catch (IOException e) {
			e.printStackTrace();
			Assert.fail();
		}

		//Simulate
		try {
			performUI(1,uiCal);
			performUI("butAdd",uiCal);
			performUI(1,uiCal);
			performUI("butEqual",uiCal);
			Double value = uiCal.reader();
			Assert.assertEquals(2.0,value, 0.01);
		} catch (NoSuchFieldException | IllegalAccessException e) {
			e.printStackTrace();
			Assert.fail();
		}

	}

	@Test
	public void UITest02() {
		UI uiCal = null;
		try {
			uiCal = new UI();
			uiCal.init();
		} catch (IOException e) {
			e.printStackTrace();
			Assert.fail();
		}

		//Simulate
		try {
			performUI(5,uiCal);
			performUI("butSquare",uiCal);
			Double value = uiCal.reader();
			Assert.assertEquals(25.0,value, 0.01);

			performUI("butTan", uiCal);
			value = uiCal.reader();
			Assert.assertTrue(value + 0.134 > 0);
			Assert.assertTrue(value + 0.133 < 0);

		} catch (NoSuchFieldException | IllegalAccessException e) {
			e.printStackTrace();
			Assert.fail();
		}

	}

	@Test
	public void UITest03() {
		UI uiCal = null;
		try {
			uiCal = new UI();
			uiCal.init();
		} catch (IOException e) {
			e.printStackTrace();
			Assert.fail();
		}

		//Simulate
		try {
			performUI(4,uiCal);
			performUI("butMultiply",uiCal);
			performUI(4,uiCal);
			performUI("butEqual",uiCal);
			Double value = uiCal.reader();
			Assert.assertEquals(16.0,value, 0.01);
		} catch (NoSuchFieldException | IllegalAccessException e) {
			e.printStackTrace();
			Assert.fail();
		}

	}

    @Test
	public void  UITest04() {
        try {
            Class<?> bufferedImageCustom = Class.forName("simplejavacalculator.BufferedImageCustom");
            Constructor<?> constructor = bufferedImageCustom.getDeclaredConstructor();
            constructor.setAccessible(true);
            Object bImage = constructor.newInstance();
            Method method = bImage.getClass().getMethod("imageReturn");
            method.setAccessible(true);
            Image image = (Image)method.invoke(bImage);
            Assert.assertNotNull(image);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Assert.fail();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            Assert.fail();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            Assert.fail();
        } catch (InstantiationException e) {
            e.printStackTrace();
            Assert.fail();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            Assert.fail();
        }

    }

	public static void performUI(String btn, UI ui) throws NoSuchFieldException, IllegalAccessException {
		Field field = ui.getClass().getDeclaredField(btn);
		field.setAccessible(true);
		Object b =  field.get(ui);
		ActionEvent e = new ActionEvent(b,ActionEvent.ACTION_PERFORMED, "");
		ui.actionPerformed(e);
	}

	public static void performUI(int btn, UI ui) throws NoSuchFieldException, IllegalAccessException {
		Field field = ui.getClass().getDeclaredField("but");
		field.setAccessible(true);
		Object but =  field.get(ui);
		Object b = Array.get(but,btn);
		ActionEvent e = new ActionEvent(b,ActionEvent.ACTION_PERFORMED, "");
		ui.actionPerformed(e);
	}
}

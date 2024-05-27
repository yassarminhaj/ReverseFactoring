package com.tawrid.function
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection
import java.awt.event.KeyEvent

import com.kms.katalon.core.annotation.Keyword

public class RobotFileUpload {

	public static void keywordUploadFile(String fileName) {
		Robot robot = new Robot()
		if(System.getProperty("os.name").contains("Mac OS X")) {

			File file = new File(fileName)
			StringSelection stringSelection = new StringSelection(file.getAbsolutePath())
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(stringSelection, null);

			robot.keyPress(KeyEvent.VK_META)
			robot.keyPress(KeyEvent.VK_TAB)
			robot.keyRelease(KeyEvent.VK_META)
			robot.keyRelease(KeyEvent.VK_TAB)
			robot.delay(2000)

			robot.keyPress(KeyEvent.VK_META)
			robot.keyPress(KeyEvent.VK_SHIFT)
			robot.keyPress(KeyEvent.VK_G)
			robot.keyRelease(KeyEvent.VK_META)
			robot.keyRelease(KeyEvent.VK_SHIFT)
			robot.keyRelease(KeyEvent.VK_G)
			robot.delay(1000)
			robot.keyPress(KeyEvent.VK_META)
			robot.keyPress(KeyEvent.VK_V)
			robot.keyRelease(KeyEvent.VK_META)
			robot.keyRelease(KeyEvent.VK_V)

			robot.keyPress(KeyEvent.VK_ENTER)
			robot.keyRelease(KeyEvent.VK_ENTER)
			robot.delay(1000)
			robot.keyPress(KeyEvent.VK_ENTER)
			robot.keyRelease(KeyEvent.VK_ENTER)
		}
		else if(System.getProperty("os.name").contains("Window")){

			println(System.getProperty("os.name"))
			File file = new File(fileName)
			StringSelection stringSelection = new StringSelection(file.getAbsolutePath())
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(stringSelection, null);

			robot.delay(250);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.delay(150);
			robot.keyRelease(KeyEvent.VK_ENTER);
		}
		else {
			println("Please try Robot Keyword for Linux")
		}
	}
}

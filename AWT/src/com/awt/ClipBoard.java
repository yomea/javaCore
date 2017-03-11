package com.awt;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.Transferable;

public class ClipBoard {
	
	public static void main(String[] args) {
		
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		Transferable transferable = clipboard.getContents(null);
	}

}

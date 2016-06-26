//        This file is part of the Yildiz-Online project, licenced under the MIT License
//        (MIT)
//
//        Copyright (c) 2016 Grégory Van den Borre
//
//        More infos available: http://yildiz.bitbucket.org
//
//        Permission is hereby granted, free of charge, to any person obtaining a copy
//        of this software and associated documentation files (the "Software"), to deal
//        in the Software without restriction, including without limitation the rights
//        to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
//        copies of the Software, and to permit persons to whom the Software is
//        furnished to do so, subject to the following conditions:
//
//        The above copyright notice and this permission notice shall be included in all
//        copies or substantial portions of the Software.
//
//        THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
//        IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
//        FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
//        AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
//        LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
//        OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
//        SOFTWARE.

package be.yildiz.module.window;

import be.yildiz.common.Size;
import be.yildiz.module.window.input.WindowInputListener;

/**
 * Window engine.
 *
 * @author Grégory Van den Borre
 */
public interface WindowEngine {

    /**
     * Create a new cursor.
     *
     * @param cursor Contains the data to build the cursor.
     */
    void createCursor(Cursor cursor);

    /**
     * Set the title for the main window.
     *
     * @param title Title to print.
     */
    void setWindowTitle(String title);

    /**
     * Set a new cursor in the game window.
     *
     * @param cursor Cursor to use.
     */
    void setCursor(Cursor cursor);

    /**
     * Update the window wrapping the game viewports.
     */
    void updateWindow();

    /**
     * Display the mouse.
     */
    void showCursor();

    /**
     * Hide the mouse.
     */
    void hideCursor();

    /**
     * @return The screen coordinates.
     */
    Size getScreenSize();

    /**
     * Set the window icon.
     *
     * @param file Icon file.
     */
    void setWindowIcon(String file);

    /**
     * Delete the resources used when loading the engine.
     */
    void deleteLoadingResources();

    /**
     * @return The handle of this window.
     */
    WindowHandle getHandle();

    /**
     * Add an input listener to retrieve input event from this window.
     *
     * @param listener Listener to add.
     */
    void registerInput(WindowInputListener listener);
}

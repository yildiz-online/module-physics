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

package be.yildiz.module.window.input;

import be.yildiz.common.client.gui.listener.ArrowKey;
import be.yildiz.common.client.gui.listener.SpecialKey;
import be.yildiz.common.vector.Point2D;

/**
 * Simple adapter with empty implementations.
 *
 * @author Grégory Van den Borre
 */
@Deprecated
//Listener now expose default method -> this class is no longer useful
public class WindowsInputAdapter implements WindowInputListener {
    @Override
    public void keyboardKeyPressed(char character) {

    }

    @Override
    public void keyboardEnterKeyPressed() {

    }

    @Override
    public void specialKeyPressed(SpecialKey key) {

    }

    @Override
    public void keyboardNumberPressed(int number) {

    }

    @Override
    public void keyboardDeleteKeyPressed() {

    }

    @Override
    public void keyboardArrowPressed(ArrowKey key) {

    }

    @Override
    public void keyReleased(int keyCode) {

    }

    @Override
    public void mouseLeftReleased(Point2D position) {

    }

    @Override
    public void mouseRightReleased(Point2D position) {

    }

    @Override
    public void mouseLeftClick(int x, int y) {

    }

    @Override
    public void mouseRightClick(Point2D position) {

    }

    @Override
    public void mouseDoubleClick(Point2D position) {

    }

    @Override
    public void mouseDragRight(Point2D position, Point2D delta) {

    }

    @Override
    public void mouseDragLeft(Point2D position, Point2D delta) {

    }

    @Override
    public void mouseDragWheel(Point2D position, Point2D delta) {

    }

    @Override
    public void mouseMove(Point2D cursorPosition) {

    }

    @Override
    public void mouseWheel(Point2D cursorPosition, int count) {

    }
}

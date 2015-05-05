/*
 * Copyright 2015 Red Hat, Inc.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published
 * by the Free Software Foundation; either version 2, or (at your
 * option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; see the file COPYING.  If not see
 * <http://www.gnu.org/licenses/>.
 */

package com.redhat.byteman.jli.helper;

/**
 * Byteman Helper class example
 */
public class JliHelper {

    public static void activated() {
        System.out.println("JliHelper#activated");
    }

    public static void installed(String ruleName) {
        System.out.println("JliHelper#installed: [" + ruleName + "]");
    }

    public static void uninstalled(String ruleName) {
        System.out.println("JliHelper#uninstalled: [" + ruleName + "]");
    }

    public static void deactivated() {
        System.out.println("JliHelper#deactivated");
    }

    public boolean doSomething(String message) {
        System.out.println("doSomething: [" + message + "]");
        return true;
    }
}

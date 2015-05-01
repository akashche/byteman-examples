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

package com.redhat.byteman.jli.agentasm;

import java.lang.instrument.Instrumentation;

/**
 * java.lang.instrument hello world agent example
 */
public class JliAgent {

    public static void premain(String agentArgs, Instrumentation inst) {
        inst.addTransformer(new JliTransformerAsm());
        System.out.println("Hello from premain!");
    }
}

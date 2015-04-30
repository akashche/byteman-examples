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

package com.redhat.byteman.jli.agent;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * java.lang.instrument transformer example
 */
class JliTransformer implements ClassFileTransformer {

    @Override
    public byte[] transform(ClassLoader classLoader, String s, Class<?> aClass, ProtectionDomain protectionDomain, byte[] bytes) throws IllegalClassFormatException {
        if (null != classLoader) {
            System.out.println("Transform called, classLoader: [" + classLoader + "], s: [" + s + "]," +
                    " protectionDomain: [" + protectionDomain + "]");
            if ("com/redhat/byteman/jli/JliApp".equals(s)) {
                byte[] transformed = new byte[bytes.length];
                System.arraycopy(bytes, 0, transformed, 0, bytes.length);
                for (int i = 0; i < transformed.length - 3; i++) {
                    if ('J' == transformed[i] && 'L' == transformed[i+1] && 'I' == transformed[i+2]) {
                        transformed[i] = 'T';
                        transformed[i + 1] = 'R';
                        transformed[i + 2] = 'N';
                        break;
                    }
                }
                return transformed;
            }
        }
        return bytes;
    }
}

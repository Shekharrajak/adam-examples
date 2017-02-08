/**
 * Copyright 2015-2017 held jointly by the individual authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.heuermh.adam.examples;

/**
 * Count alignments example implemented in Java.
 *
 * @author  Michael Heuer
 */
public final class JavaCountAlignments {

    /**
     * Main.
     *
     * @param args command line arguments
     */
    public static void main(final String[] args) {
        if (args.length < 1) {
            System.err.println("at least one argument required, e.g. foo.sam");
            System.exit(1);
        }

        // ...see https://github.com/bigdatagenomics/adam/issues/855
    }
}

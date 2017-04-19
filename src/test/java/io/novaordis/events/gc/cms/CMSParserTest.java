/*
 * Copyright (c) 2017 Nova Ordis LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.novaordis.events.gc.cms;

import io.novaordis.events.api.parser.GCParser;
import io.novaordis.events.api.parser.MultiLineGCParserTest;
import io.novaordis.events.gc.CollectorType;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author Ovidiu Feodorov <ovidiu@novaordis.com>
 * @since 2/14/17
 */
public class CMSParserTest extends MultiLineGCParserTest {

    // Constants -------------------------------------------------------------------------------------------------------

    // Static ----------------------------------------------------------------------------------------------------------

    // Attributes ------------------------------------------------------------------------------------------------------

    // Constructors ----------------------------------------------------------------------------------------------------

    // Public ----------------------------------------------------------------------------------------------------------

    // Tests -----------------------------------------------------------------------------------------------------------

    @Test
    public void buildInstance() throws Exception {

        GCParser p = GCParser.buildInstance(CollectorType.CMS);

        assertNotNull(p);
        assertTrue(p instanceof CMSParser);
    }

    // TODO when I have a CMS log
    // @Test
    public void buildInstance_FileHeuristics() throws Exception {

        File logFile = new File(baseDirectory, "src/test/resources/data/jvm-???-CMS-???.log");
        assertTrue(logFile.isFile());

        GCParser p = GCParser.buildInstance(logFile);

        assertNotNull(p);
        assertTrue(p instanceof CMSParser);
    }

    // Package protected -----------------------------------------------------------------------------------------------

    // Protected -------------------------------------------------------------------------------------------------------

    @Override
    protected CMSParser getGCParserToTest() throws Exception {

        return new CMSParser();
    }

    // Private ---------------------------------------------------------------------------------------------------------

    // Inner classes ---------------------------------------------------------------------------------------------------

}

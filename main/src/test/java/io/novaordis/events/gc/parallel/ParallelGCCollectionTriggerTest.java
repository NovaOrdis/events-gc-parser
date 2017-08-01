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

package io.novaordis.events.gc.parallel;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Ovidiu Feodorov <ovidiu@novaordis.com>
 * @since 4/20/17
 */
public class ParallelGCCollectionTriggerTest {

    // Constants -------------------------------------------------------------------------------------------------------

    // Static ----------------------------------------------------------------------------------------------------------

    // Attributes ------------------------------------------------------------------------------------------------------

    // Constructors ----------------------------------------------------------------------------------------------------

    // Public ----------------------------------------------------------------------------------------------------------

    // Tests -----------------------------------------------------------------------------------------------------------

    @Test
    public void logMarker() throws Exception {

        for(ParallelGCCollectionTrigger t: ParallelGCCollectionTrigger.values()) {

            String marker = t.getLogMarker();
            ParallelGCCollectionTrigger t2 = ParallelGCCollectionTrigger.fromLogMarker(marker);

            assertEquals(t, t2);
        }
    }

    // find() ----------------------------------------------------------------------------------------------------------

    @Test
    public void fromLogMarker_Null() throws Exception {

        ParallelGCCollectionTrigger t = ParallelGCCollectionTrigger.fromLogMarker(null);
        assertNull(t);
    }

    @Test
    public void fromLogMarker_NoSuchMarker() throws Exception {

        ParallelGCCollectionTrigger t = ParallelGCCollectionTrigger.fromLogMarker("invalid log marker");
        assertNull(t);
    }

    // Package protected -----------------------------------------------------------------------------------------------

    // Protected -------------------------------------------------------------------------------------------------------

    // Private ---------------------------------------------------------------------------------------------------------

    // Inner classes ---------------------------------------------------------------------------------------------------

}
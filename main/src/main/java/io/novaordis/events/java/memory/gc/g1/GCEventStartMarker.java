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

package io.novaordis.events.java.memory.gc.g1;

/**
 * @author Ovidiu Feodorov <ovidiu@novaordis.com>
 * @since 2/14/17
 */
public class GCEventStartMarker {

    // Constants -------------------------------------------------------------------------------------------------------

    // Static ----------------------------------------------------------------------------------------------------------

    // Attributes ------------------------------------------------------------------------------------------------------

    private Time time;
    private int eventStart;
    private int contentStart;


    // Constructors ----------------------------------------------------------------------------------------------------

    /**
     * @param eventStart, int contentStart the start index.
     *
     * @exception IllegalArgumentException if time is null
     */
    public GCEventStartMarker(Time time, int eventStart, int contentStart) {

        if (time == null) {

            throw new IllegalArgumentException("null time");
        }

        this.time = time;
        this.eventStart = eventStart;
        this.contentStart = contentStart;
    }

    // Public ----------------------------------------------------------------------------------------------------------

    /**
     * The index in line of the first character of the event - usually the timestamp.
     */
    public int getEventStart() {

        return eventStart;

    }

    /**
     * The index in line of the first character of the event's content - the part that follows after the timestamp
     * information.
     */
    public int getContentStart() {

        return contentStart;

    }


    /**
     * The event timestamp. May be absolute, if the log was recorded with -XX:+PrintGCDateStamps or relative to the
     * start of the log
     */
    public Time getTime() {

        return time;

    }

    @Override
    public String toString() {

        return "<" + eventStart + "[" + time + "]" + contentStart + ">";
    }

    // Package protected -----------------------------------------------------------------------------------------------

    // Protected -------------------------------------------------------------------------------------------------------

    // Private ---------------------------------------------------------------------------------------------------------

    // Inner classes ---------------------------------------------------------------------------------------------------

}

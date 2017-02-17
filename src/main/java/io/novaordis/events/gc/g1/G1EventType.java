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

package io.novaordis.events.gc.g1;

import io.novaordis.events.api.gc.GCEventType;

/**
 * @author Ovidiu Feodorov <ovidiu@novaordis.com>
 * @since 2/15/17
 */
public enum G1EventType implements GCEventType {

    // Constants -------------------------------------------------------------------------------------------------------

    //
    // stops application threads
    //
    // this kind of event is characterized by its scope (G1CollectionScope) and trigger (see G1CollectionTrigger)
    //

    COLLECTION,

    //
    // the beginning of the concurrent cycle is a young collection that was marked as such; it stops application threads
    //

    //
    // does not stop the app threads
    // however, young generation collection cannot happen during this phase
    //
    CONCURRENT_CYCLE_ROOT_REGION_SCAN_START("concurrent-root-region-scan-start"),

    //
    // does not stop the app threads
    //
    CONCURRENT_CYCLE_ROOT_REGION_SCAN_END("concurrent-root-region-scan-end"),

    //
    // does not stop the app threads
    //
    CONCURRENT_CYCLE_CONCURRENT_MARK_START("concurrent-mark-start"),

    //
    // does not stop the app threads
    //
    CONCURRENT_CYCLE_CONCURRENT_MARK_END("concurrent-mark-end"),


    //
    // stops application threads
    //
    CONCURRENT_CYCLE_REMARK(" remark "),
    CONCURRENT_CYCLE_FINALIZE_MARKING("Finalize Marking"),
    CONCURRENT_CYCLE_REF_PROC("ref-proc"),
    CONCURRENT_CYCLE_UNLOADING("Unloading"),

    //
    // stops application threads
    //
    CONCURRENT_CYCLE_CLEANUP(" cleanup "),

    //
    // does not stop the app threads
    // sometimes does not occur
    //
    CONCURRENT_CYCLE_CONCURRENT_CLEANUP_START("concurrent-cleanup-start"),

    //
    // does not stop the app threads
    // sometimes does not occur
    //
    CONCURRENT_CYCLE_CONCURRENT_CLEANUP_END("concurrent-cleanup-end"),

    ;

    // Static ----------------------------------------------------------------------------------------------------------

    /**
     * Attempts to find an event type marker on the line and returns the corresponding enum instance. If more than one
     * known marker are present, the current implementation returns the one that was declared first in this class.
     * If no event trigger is identified, the method returns null.
     */
    static G1EventType find(String line) {

        if (line == null) {

            return null;
        }

        for(G1EventType t: values()) {

            String marker = t.getLogMarker();

            if (marker == null) {

                continue;
            }

            int i = line.indexOf(marker);

            if (i != -1) {

                return t;
            }
        }

        return null;
    }

    /**
     * @return null if the external value is not among the known values.
     */
    static G1EventType fromExternalValue(String externalValue) {

        for(G1EventType et: values()) {

            if (et.toExternalValue().equals(externalValue)) {

                return et;
            }
        }

        return null;
    }

    // Attributes ------------------------------------------------------------------------------------------------------

    private String logMarker;

    // Constructors ----------------------------------------------------------------------------------------------------

    G1EventType() {

        this(null);
    }

    G1EventType(String logMarker) {

        this.logMarker = logMarker;
    }

    // Public ----------------------------------------------------------------------------------------------------------

    @Override
    public String toExternalValue() {

        return toString();
    }

    public String getLogMarker() {

        return logMarker;
    }

}

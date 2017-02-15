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

package io.novaordis.events.api.parser;

import io.novaordis.events.api.event.Event;

import java.util.List;

/**
 * A parser were events may span multiple lines, as it is the case of garbage collection logs. At the same time,
 * mutiple events can be found on a single line.
 *
 * @author Ovidiu Feodorov <ovidiu@novaordis.com>
 * @since 2/14/17
 */
public interface MultiLineParser {

    // Constants -------------------------------------------------------------------------------------------------------

    // Static ----------------------------------------------------------------------------------------------------------

    // Public ----------------------------------------------------------------------------------------------------------

    /**
     * @return may return an empty list but never null.
     */
    List<Event> parse(String line) throws ParsingException;

    /**
     * Processes the remaining accumulated state and closes the parser. A parser that was closed cannot be re-used.
     *
     * @return may return an empty list but never null.
     */
    List<Event> close() throws ParsingException;


}
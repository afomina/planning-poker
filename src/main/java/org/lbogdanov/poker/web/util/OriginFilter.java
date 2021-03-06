/**
 * Copyright 2012 Leonid Bogdanov
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
package org.lbogdanov.poker.web.util;

import org.apache.wicket.Session;
import org.apache.wicket.atmosphere.AtmosphereEvent;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;


/**
 * Can prevent sending a message to its originator.
 * 
 * @author Leonid Bogdanov
 */
public class OriginFilter implements Predicate<AtmosphereEvent> {

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean apply(AtmosphereEvent input) {
        return !Objects.equal(((Message<?>) input.getPayload()).origin, Session.get().getId());
    }

}

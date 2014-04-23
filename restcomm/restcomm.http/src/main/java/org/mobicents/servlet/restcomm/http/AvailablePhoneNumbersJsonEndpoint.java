/*
 * TeleStax, Open Source Cloud Communications
 * Copyright 2011-2013, Telestax Inc and individual contributors
 * by the @authors tag.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.mobicents.servlet.restcomm.http;

import static javax.ws.rs.core.Response.status;
import static javax.ws.rs.core.Response.Status.BAD_REQUEST;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.mobicents.servlet.restcomm.annotations.concurrency.ThreadSafe;

/**
 * @author <a href="mailto:gvagenas@gmail.com">gvagenas</a>
 *
 */
@Path("/Accounts/{accountSid}/AvailablePhoneNumbers.json/US/Local")
@ThreadSafe
public class AvailablePhoneNumbersJsonEndpoint extends AvailablePhoneNumbersEndpoint {
    public AvailablePhoneNumbersJsonEndpoint() {
        super();
    }

    @GET
    public Response getAvailablePhoneNumber(@PathParam("accountSid") final String accountSid,
            @QueryParam("AreaCode") String areaCode) {
        if (areaCode != null && !areaCode.isEmpty()) {
            return getAvailablePhoneNumbersByAreaCode(accountSid, areaCode, MediaType.APPLICATION_JSON_TYPE);
        } else {
            return status(BAD_REQUEST).build();
        }
    }
}
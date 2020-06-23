/*
 * Copyright 2015-2020 52°North Initiative for Geospatial Open Source
 * Software GmbH
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
package org.n52.shetland.w3c.wsdl;

import java.net.URI;
import java.util.Collection;

import javax.xml.namespace.QName;

import com.google.common.collect.ImmutableList;

/**
 *
 * @author <a href="mailto:c.autermann@52north.org">Christian Autermann</a>
 *
 * @since 4.0.0
 */
public class Fault {

    public static final Fault EXCEPTION_MESSAGE = new Fault("ExceptionMessage",
            WSDLConstants.OWS_EXCEPTION_ACTION);

    public static final Fault REQUEST_EXTENSION_NOT_SUPPORTED_EXCEPTION = new Fault(
            "RequestExtensionNotSupportedException", WSDLConstants.SWES_EXCEPTION_ACTION);

    public static final Fault INVALID_REQUEST_EXCEPTION = new Fault("InvalidRequestException",
            WSDLConstants.SWES_EXCEPTION_ACTION);

    public static final Fault NO_APPLICABLE_CODE_EXCEPTION = new Fault("NoApplicableCodeException",
            WSDLConstants.OWS_EXCEPTION_ACTION);

    public static final Fault INVALID_UPDATE_SEQUENCE_EXCEPTION = new Fault("InvalidUpdateSequenceException",
            WSDLConstants.OWS_EXCEPTION_ACTION);

    public static final Fault VERSION_NEGOTIATION_FAILED_EXCEPTION = new Fault(
            "VersionNegotiationFailedException", WSDLConstants.OWS_EXCEPTION_ACTION);

    public static final Fault MISSING_PARAMETER_VALUE_EXCEPTION = new Fault("MissingParameterValueException",
            WSDLConstants.OWS_EXCEPTION_ACTION);

    public static final Fault INVALID_PARAMETER_VALUE_EXCEPTION = new Fault("InvalidParameterValueException",
            WSDLConstants.OWS_EXCEPTION_ACTION);

    public static final Fault OPERATION_NOT_SUPPORTED_EXCEPTION = new Fault("OperationNotSupportedException",
            WSDLConstants.OWS_EXCEPTION_ACTION);

    // public static final Collection<WSDLFault> DEFAULT_FAULTS =
    // ImmutableList.of(MISSING_PARAMETER_VALUE_EXCEPTION,
    // INVALID_PARAMETER_VALUE_EXCEPTION, OPERATION_NOT_SUPPORTED_EXCEPTION,
    // NO_APPLICABLE_CODE_EXCEPTION,
    // INVALID_REQUEST_EXCEPTION, REQUEST_EXTENSION_NOT_SUPPORTED_EXCEPTION);

    public static final Collection<Fault> DEFAULT_FAULTS = ImmutableList.of(EXCEPTION_MESSAGE);

    private final String name;

    private final URI action;

    public Fault(String name, URI action) {
        this.name = name;
        this.action = action;
    }

    public String getName() {
        return name;
    }

    public URI getAction() {
        return action;
    }

    public void setName(String name2) {
        // TODO Auto-generated method stub

    }

    public void setMessage(Message message) {
        // TODO Auto-generated method stub

    }

    public void setExtensionAttribute(QName qnWsamAction, String string) {
        // TODO Auto-generated method stub

    }
}

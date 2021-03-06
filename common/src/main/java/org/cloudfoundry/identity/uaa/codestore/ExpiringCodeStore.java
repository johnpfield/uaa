/*******************************************************************************
 *     Cloud Foundry 
 *     Copyright (c) [2009-2014] Pivotal Software, Inc. All Rights Reserved.
 *
 *     This product is licensed to you under the Apache License, Version 2.0 (the "License").
 *     You may not use this product except in compliance with the License.
 *
 *     This product includes a number of subcomponents with
 *     separate copyright notices and license terms. Your use of these
 *     subcomponents is subject to the terms and conditions of the
 *     subcomponent's license, as noted in the LICENSE file.
 *******************************************************************************/
package org.cloudfoundry.identity.uaa.codestore;

import java.sql.Timestamp;

import org.springframework.security.oauth2.common.util.RandomValueStringGenerator;

public interface ExpiringCodeStore {

    /**
     * Generate and persist a one-time code with an expiry date.
     * 
     * @param data JSON object to be associated with the code
     * @return code
     * @throws java.lang.NullPointerException if data or expiresAt is null
     * @throws java.lang.IllegalArgumentException if expiresAt is in the past
     */
    public ExpiringCode generateCode(String data, Timestamp expiresAt);

    /**
     * Retrieve a code and delete it if it exists.
     * 
     * @param code
     * @return code or null if the code is not found
     * @throws java.lang.NullPointerException if the code is null
     */
    public ExpiringCode retrieveCode(String code);

    /**
     * Set the code generator for this store.
     * 
     * @param generator Code generator
     */
    public void setGenerator(RandomValueStringGenerator generator);
}

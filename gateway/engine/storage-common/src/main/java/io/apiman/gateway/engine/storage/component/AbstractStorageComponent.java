/*
 * Copyright 2018 Pete Cornish
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.apiman.gateway.engine.storage.component;

import io.apiman.gateway.engine.storage.store.IBackingStore;
import io.apiman.gateway.engine.storage.store.IBackingStoreProvider;

/**
 * Common base class for components backed by a store.
 *
 * @author Pete Cornish
 */
abstract public class AbstractStorageComponent {
    private final IBackingStoreProvider storeProvider;
    private final String storeName;

    /**
     * Constructor.
     */
    public AbstractStorageComponent(IBackingStoreProvider storeProvider,
                                    String storeName) {

        this.storeProvider = storeProvider;
        this.storeName = storeName;
    }

    /**
     * Returns an instance of the store.
     *
     * @return the Map
     */
    public IBackingStore getStore() {
        return storeProvider.get(storeName);
    }

    /**
     * Builds a key derived from the namespace.
     *
     * @param namespace    the namespace
     * @param propertyName the property name
     * @return the namespaced key
     */
    protected String buildNamespacedKey(String namespace, String propertyName) {
        return namespace + "." + propertyName;
    }
}

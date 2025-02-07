/*
 * Copyright (C) 2015-2022 52°North Spatial Information Research GmbH
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
package org.n52.shetland.inspire.dls;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.n52.shetland.inspire.InspireConformity;
import org.n52.shetland.inspire.InspireKeyword;
import org.n52.shetland.inspire.InspireLanguageISO6392B;
import org.n52.shetland.inspire.InspireMandatoryKeyword;
import org.n52.shetland.inspire.InspireMetadataPointOfContact;
import org.n52.shetland.inspire.InspireResourceLocator;
import org.n52.shetland.inspire.InspireSupportedLanguages;
import org.n52.shetland.inspire.InspireTemporalReference;
import org.n52.shetland.inspire.InspireUniqueResourceIdentifier;
import org.n52.shetland.inspire.dls.InspireCapabilities.InspireExtendedCapabilitiesConformity;
import org.n52.shetland.inspire.dls.InspireCapabilities.InspireExtendedCapabilitiesKeyword;
import org.n52.shetland.inspire.dls.InspireCapabilities.InspireExtendedCapabilitiesMandatoryKeyword;
import org.n52.shetland.inspire.dls.InspireCapabilities.InspireExtendedCapabilitiesMetadataDate;
import org.n52.shetland.inspire.dls.InspireCapabilities.InspireExtendedCapabilitiesMetadataPointOfContact;
import org.n52.shetland.inspire.dls.InspireCapabilities.InspireExtendedCapabilitiesMetadataURL;
import org.n52.shetland.inspire.dls.InspireCapabilities.InspireExtendedCapabilitiesResourceLocator;
import org.n52.shetland.inspire.dls.InspireCapabilities.InspireExtendedCapabilitiesResourceType;
import org.n52.shetland.inspire.dls.InspireCapabilities.InspireExtendedCapabilitiesSpatialDataServiceType;
import org.n52.shetland.inspire.dls.InspireCapabilities.InspireExtendedCapabilitiesTemporalReference;
import org.n52.shetland.inspire.dls.InspireCapabilities.InspireServiceSpatialDataResourceType;
import org.n52.shetland.inspire.dls.InspireCapabilities.InspireSpatialDataServiceType;
import org.n52.shetland.ogc.gml.time.TimeInstant;
import org.n52.shetland.util.CollectionHelper;

import com.google.common.collect.Lists;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * Service internal object to represent the full INSPIRE DLS ExtendedCapabilities
 *
 * @author <a href="mailto:c.hollmann@52north.org">Carsten Hollmann</a>
 * @since 1.0.0
 *
 */
public class FullInspireExtendedCapabilities extends InspireExtendedCapabilitiesDLS
        implements InspireExtendedCapabilitiesResourceLocator, InspireExtendedCapabilitiesMetadataURL,
        InspireExtendedCapabilitiesResourceType,
        InspireExtendedCapabilitiesTemporalReference<FullInspireExtendedCapabilities>,
        InspireExtendedCapabilitiesConformity, InspireExtendedCapabilitiesMetadataPointOfContact,
        InspireExtendedCapabilitiesMetadataDate, InspireExtendedCapabilitiesMandatoryKeyword,
        InspireExtendedCapabilitiesKeyword, InspireExtendedCapabilitiesSpatialDataServiceType {

    /* ResourceLocator 1..* */
    private List<InspireResourceLocator> resourceLocator = Lists.newArrayList();

    /* ResourceType 1..1 */
    private InspireServiceSpatialDataResourceType resourceType = InspireServiceSpatialDataResourceType.service;

    /* TemporalReference 1..* */
    private List<InspireTemporalReference> temporalReferences = Lists.newArrayList();

    /* Conformity 1..* */
    private List<InspireConformity> conformities = Lists.newArrayList();

    /* MetadataPointOfContact 1..* */
    private List<InspireMetadataPointOfContact> metadataPointOfContacts = Lists.newArrayList();

    /* MetadataDate 1..1 */
    private TimeInstant metadataDate;

    /* SpatialDataServiceType 1..1 */
    private InspireSpatialDataServiceType spatialDataServiceType = InspireSpatialDataServiceType.download;

    /* MandatoryKeyword 1..* */
    private List<InspireMandatoryKeyword> mandatoryKeywords = Lists.newArrayList();

    /* Keyword 0..* */
    private List<InspireKeyword> keywords = Lists.newArrayList();

    /* MetadataUrl" 0..1 */
    private InspireResourceLocator metadataUrl;

    /**
     * constructor
     *
     * @param resourceLocator
     *            resourceLocator to set
     * @param supportedLanguages
     *            Supported languages to set
     * @param responseLanguage
     *            Response language to set
     * @param spatialDataSetIdentifier
     *            Spatial dataset identifier to set
     */
    public FullInspireExtendedCapabilities(InspireResourceLocator resourceLocator,
            InspireSupportedLanguages supportedLanguages, InspireLanguageISO6392B responseLanguage,
            InspireUniqueResourceIdentifier spatialDataSetIdentifier) {
        super(supportedLanguages, responseLanguage, spatialDataSetIdentifier);
        addResourceLocator(resourceLocator);
    }

    /**
     * constructor
     *
     * @param resourceLocators
     *            resourceLocators to set
     * @param supportedLanguages
     *            Supported languages to set
     * @param responseLanguage
     *            Response language to set
     * @param spatialDataSetIdentifier
     *            Spatial dataset identifier to set
     */
    public FullInspireExtendedCapabilities(Collection<InspireResourceLocator> resourceLocators,
            InspireSupportedLanguages supportedLanguages, InspireLanguageISO6392B responseLanguage,
            InspireUniqueResourceIdentifier spatialDataSetIdentifier) {
        super(supportedLanguages, responseLanguage, spatialDataSetIdentifier);
        setResourceLocator(resourceLocators);
    }

    /**
     * constructor
     *
     * @param resourceLocator
     *            resourceLocator to set
     * @param supportedLanguages
     *            Supported languages to set
     * @param responseLanguage
     *            Response language to set
     * @param spatialDataSetIdentifiers
     *            Spatial dataset identifiers to set
     */
    public FullInspireExtendedCapabilities(InspireResourceLocator resourceLocator,
            InspireSupportedLanguages supportedLanguages, InspireLanguageISO6392B responseLanguage,
            Collection<InspireUniqueResourceIdentifier> spatialDataSetIdentifiers) {
        super(supportedLanguages, responseLanguage, spatialDataSetIdentifiers);
        addResourceLocator(resourceLocator);
    }

    /**
     * constructor
     *
     * @param resourceLocators
     *            resourceLocators to set
     * @param supportedLanguages
     *            Supported languages to set
     * @param responseLanguage
     *            Response language to set
     * @param spatialDataSetIdentifiers
     *            Spatial dataset identifiers to set
     */
    public FullInspireExtendedCapabilities(Collection<InspireResourceLocator> resourceLocators,
            InspireSupportedLanguages supportedLanguages, InspireLanguageISO6392B responseLanguage,
            Collection<InspireUniqueResourceIdentifier> spatialDataSetIdentifiers) {
        super(supportedLanguages, responseLanguage, spatialDataSetIdentifiers);
        setResourceLocator(resourceLocators);
    }

    @Override
    public List<InspireResourceLocator> getResourceLocator() {
        return Collections.unmodifiableList(resourceLocator);
    }

    @Override
    public InspireExtendedCapabilitiesResourceLocator setResourceLocator(
            Collection<InspireResourceLocator> resourceLocator) {
        this.resourceLocator.clear();
        if (CollectionHelper.isNotEmpty(resourceLocator)) {

            this.resourceLocator.addAll(resourceLocator);
        }
        return this;
    }

    @Override
    public InspireExtendedCapabilitiesResourceLocator addResourceLocator(InspireResourceLocator resourceLocator) {
        if (resourceLocator != null) {
            this.resourceLocator.add(resourceLocator);
        }
        return this;
    }

    @Override
    public boolean isSetResourceLocators() {
        return CollectionHelper.isNotEmpty(getResourceLocator());
    }

    @Override
    @SuppressFBWarnings({ "EI_EXPOSE_REP" })
    public InspireResourceLocator getMetadataUrl() {
        return metadataUrl;
    }

    @Override
    @SuppressFBWarnings({ "EI_EXPOSE_REP2" })
    public FullInspireExtendedCapabilities setMetadataUrl(InspireResourceLocator metadataUrl) {
        this.metadataUrl = metadataUrl;
        return this;
    }

    @Override
    @SuppressFBWarnings({ "EI_EXPOSE_REP2" })
    public boolean isSetMetadataUrl() {
        return getMetadataUrl() != null;
    }

    @Override
    public String toString() {
        return String.format(
                "%s %n[%n \tresourceLocator=%s," + "%n resourceType=%s," + "%n temporalReferences=%s,"
                        + "%n conformity=%s," + "%n metadataPointOfContacts=%s," + "%n metadataDate=%s,"
                        + "%n spatialDataServiceType=%s," + "%n mandatoryKeywords=%s," + "%n keywords=%s,"
                        + "%n supportedLanguages=%s," + "%n responseLanguage=%s," + "%n metadataUrl=%s%n]",
                this.getClass().getSimpleName(), CollectionHelper.collectionToString(getResourceLocator()),
                getResourceType(), CollectionHelper.collectionToString(getTemporalReferences()),
                CollectionHelper.collectionToString(getConformity()),
                CollectionHelper.collectionToString(getMetadataPointOfContacts()), getMetadataDate(),
                getSpatialDataServiceType(), CollectionHelper.collectionToString(getMandatoryKeywords()),
                CollectionHelper.collectionToString(getKeywords()), getSupportedLanguages(), getResponseLanguage(),
                getMetadataUrl());
    }

    @Override
    public InspireServiceSpatialDataResourceType getResourceType() {
        return resourceType;
    }

    @Override
    public InspireExtendedCapabilitiesResourceType setResourceType(
            InspireServiceSpatialDataResourceType resourceType) {
        this.resourceType = resourceType;
        return this;
    }

    @Override
    public boolean isSetResourceType() {
        return getResourceType() != null;
    }

    @Override
    public List<InspireTemporalReference> getTemporalReferences() {
        return Collections.unmodifiableList(temporalReferences);
    }

    @Override
    public FullInspireExtendedCapabilities setTemporalReferences(
            Collection<InspireTemporalReference> temporalReferences) {
        this.temporalReferences.clear();
        if (CollectionHelper.isNotEmpty(temporalReferences)) {
            this.temporalReferences.addAll(temporalReferences);
        }
        return this;
    }

    @Override
    public FullInspireExtendedCapabilities addTemporalReference(InspireTemporalReference temporalReference) {
        if (temporalReference != null) {
            this.temporalReferences.add(temporalReference);
        }
        return this;
    }

    @Override
    public boolean isSetTemporalReferences() {
        return CollectionHelper.isNotEmpty(getTemporalReferences());
    }

    @Override
    public List<InspireConformity> getConformity() {
        return Collections.unmodifiableList(conformities);
    }

    @Override
    public FullInspireExtendedCapabilities setConformity(Collection<InspireConformity> conformities) {
        this.conformities.clear();
        if (CollectionHelper.isNotEmpty(conformities)) {
            this.conformities.addAll(conformities);
        }
        return this;
    }

    @Override
    public FullInspireExtendedCapabilities addConformity(InspireConformity conformity) {
        this.conformities.add(conformity);
        return this;
    }

    @Override
    public boolean isSetConformity() {
        return CollectionHelper.isNotEmpty(getConformity());
    }

    @Override
    public List<InspireMetadataPointOfContact> getMetadataPointOfContacts() {
        return Collections.unmodifiableList(metadataPointOfContacts);
    }

    @Override
    public FullInspireExtendedCapabilities setMetadataPointOfContacts(
            Collection<InspireMetadataPointOfContact> metadataPointOfContacts) {
        this.metadataPointOfContacts.clear();
        if (CollectionHelper.isNotEmpty(metadataPointOfContacts)) {
            this.metadataPointOfContacts.addAll(metadataPointOfContacts);
        }
        return this;
    }

    @Override
    public FullInspireExtendedCapabilities addMetadataPointOfContact(
            InspireMetadataPointOfContact metadataPointOfContact) {
        if (metadataPointOfContact != null) {
            this.metadataPointOfContacts.add(metadataPointOfContact);
        }
        return this;
    }

    @Override
    public boolean isSetMetadataPointOfContact() {
        return CollectionHelper.isNotEmpty(this.metadataPointOfContacts);
    }

    @SuppressFBWarnings({ "EI_EXPOSE_REP" })
    public TimeInstant getMetadataDate() {
        return metadataDate;
    }

    @Override
    @SuppressFBWarnings({ "EI_EXPOSE_REP2" })
    public FullInspireExtendedCapabilities setMetadataDate(TimeInstant metadataDate) {
        this.metadataDate = metadataDate;
        return this;
    }

    @Override
    public boolean isSetMetadataDate() {
        return getMetadataDate() != null;
    }

    @Override
    public InspireSpatialDataServiceType getSpatialDataServiceType() {
        return spatialDataServiceType;
    }

    @Override
    public InspireExtendedCapabilitiesSpatialDataServiceType setSpatialDataServiceType(
            InspireSpatialDataServiceType spatialDataServiceType) {
        this.spatialDataServiceType = spatialDataServiceType;
        return this;
    }

    @Override
    public boolean isSetSpatialDataServiceType() {
        return getSpatialDataServiceType() != null;
    }

    @Override
    public List<InspireMandatoryKeyword> getMandatoryKeywords() {
        return Collections.unmodifiableList(mandatoryKeywords);
    }

    @Override
    public FullInspireExtendedCapabilities setMandatoryKeywords(
            Collection<InspireMandatoryKeyword> mandatoryKeywords) {
        this.mandatoryKeywords.clear();
        if (CollectionHelper.isNotEmpty(mandatoryKeywords)) {
            this.mandatoryKeywords.addAll(mandatoryKeywords);
        }
        return this;
    }

    @Override
    public FullInspireExtendedCapabilities addMandatoryKeyword(InspireMandatoryKeyword mandatoryKeyword) {
        if (mandatoryKeyword != null) {
            this.mandatoryKeywords.add(mandatoryKeyword);
        }
        return this;
    }

    @Override
    public boolean isSetMandatoryKeyword() {
        return getMandatoryKeywords() != null;
    }

    @Override
    public List<InspireKeyword> getKeywords() {
        return Collections.unmodifiableList(keywords);
    }

    @Override
    public FullInspireExtendedCapabilities setKeywords(Collection<InspireKeyword> keywords) {
        this.keywords.clear();
        if (CollectionHelper.isNotEmpty(keywords)) {

            this.keywords.addAll(keywords);
        }
        return this;
    }

    @Override
    public FullInspireExtendedCapabilities addKeyword(InspireKeyword keyword) {
        if (keyword != null) {
            keywords.add(keyword);
        }
        return this;
    }

    @Override
    public boolean isSetKeywords() {
        return CollectionHelper.isNotEmpty(getKeywords());
    }
}

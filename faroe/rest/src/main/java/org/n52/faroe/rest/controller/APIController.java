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
package org.n52.faroe.rest.controller;

import java.util.Set;

import org.n52.faroe.SettingDefinition;
import org.n52.faroe.rest.settings.SettingsAPI;
import org.n52.faroeR.rest.entities.Groups;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/", produces = { "application/json" })
public class APIController {

    @Autowired
    private SettingsAPI api;
    
    private MultiValueMap<String, String> otherParams;

    @GetMapping(path = "/groups")
    public Set<SettingDefinition<?>> getGroup() {

        return this.api.getSettings();

    }

    @GetMapping(path = "/groups/{groupTitle}")
    public Groups getGroupbyTitle(@PathVariable String groupTitle) {
        return this.api.getSettingsbyTitle(groupTitle);
    }

    @PostMapping(path = "/groups", consumes = "application/json")
    public Groups addGroup(@RequestBody Groups group) {

        return this.api.addSettings(group);

    }

    @PutMapping(path = "/groups", consumes = "application/json")
    public Groups updateGroup(@RequestBody Groups group) {

        return this.api.updateSettings(group);

    }

    @DeleteMapping(path = "/groups/{groupTitle}")
    public ResponseEntity<HttpStatus> deleteGroup(@PathVariable String groupTitle) {
        try {
            this.api.deleteGroup(groupTitle);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

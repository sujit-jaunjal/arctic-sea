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
package org.n52.bjornoya.schedule;

import org.joda.time.DateTime;
import org.n52.shetland.util.DateTimeHelper;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.PersistJobDataAfterExecution;

@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public interface TemporalHarvesterJob extends Job {

    default DateTime getLastUpdateTime(JobExecutionContext context) {
        if (context.getPreviousFireTime() != null) {
            return new DateTime(context.getPreviousFireTime());
        }
        return new DateTime(context.getFireTime())
                .minus(DateTimeHelper.getMinutesSince(new DateTime(context.getFireTime()),
                        new DateTime(context.getNextFireTime())));
    }

}

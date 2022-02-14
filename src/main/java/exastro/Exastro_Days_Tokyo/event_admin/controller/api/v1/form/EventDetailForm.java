/*   Copyright 2021 NEC Corporation
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package exastro.Exastro_Days_Tokyo.event_admin.controller.api.v1.form;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventDetailForm {
	
	private int eventId;
	
	private String eventName;
	
	private String eventOverview;
	
	private Date eventDate;
	
	private String eventVenue;
	
	private boolean deleteFlag;
	
	public EventDetailForm() {
	}
	
	public EventDetailForm(String eventName, Date eventDate) {
		this.eventName = eventName;
		this.eventDate = eventDate;
		this.deleteFlag = false;
	}

	public EventDetailForm(String eventName, String eventOverview, Date eventDate, String eventVenue) {
		this.eventName = eventName;
		this.eventOverview = eventOverview;		
		this.eventDate = eventDate;
		this.eventVenue = eventVenue;
		this.deleteFlag = false;
	}
	
	public EventDetailForm(int eventId, String eventName, String eventOverview, Date eventDate, String eventVenue) {
		this.eventId = eventId;
		this.eventName = eventName;
		this.eventOverview = eventOverview;		
		this.eventDate = eventDate;
		this.eventVenue = eventVenue;
	}
	
	public EventDetailForm(int eventId, String eventName, String eventOverview, Date eventDate, String eventVenue, boolean deleteFlag) {
		this.eventId = eventId;
		this.eventName = eventName;
		this.eventOverview = eventOverview;		
		this.eventDate = eventDate;
		this.eventVenue = eventVenue;
		this.deleteFlag = deleteFlag;
	}
	
}

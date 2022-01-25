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

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
/**
 * The persistent class for the events database table.
 * 
 */
public class EventDetailForm {
	
	private int eventId;
	
	private String eventName;
	
	private String eventOverview;
	
	private Date eventDate;
//	private Timestamp eventDate;
	
	private String eventVenue;
	
	private boolean deleteFlag;
	
	public EventDetailForm() {
	}
	
	public EventDetailForm(String eventName, Date eventDate) {
		this.eventName = eventName;
		this.eventDate = eventDate;
		this.deleteFlag = false;
	}

	public EventDetailForm(String eventName, String eventOverView, String eventVenue) {
		this.eventName = eventName;
		this.eventOverview = eventOverview;		
//		this.eventDate = eventDate;
		this.eventVenue = eventVenue;
	}
	
	public EventDetailForm(int eventId, String eventName, String eventOverView, Date eventDate, String eventVenue, boolean deleteFlag) {
		this.eventId = eventId;
		this.eventName = eventName;
		this.eventOverview = eventOverview;		
		this.eventDate = eventDate;
		this.eventVenue = eventVenue;
		this.deleteFlag = deleteFlag;
	}

	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
	public String getEventOverview() {
		return eventOverview;
	}
	public void setEventOverview(String eventOverview) {
		this.eventOverview = eventOverview;
	}
	
	public Date getEventDate() {
		return eventDate;
	}
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	
	public String getEventVenue() {
		return eventVenue;
	}
	public void setEventVenue(String eventVenue) {
		this.eventVenue = eventVenue;
	}

	public boolean getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	
}
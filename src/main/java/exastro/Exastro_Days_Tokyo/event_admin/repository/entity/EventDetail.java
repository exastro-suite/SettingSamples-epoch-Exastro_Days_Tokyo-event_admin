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

package exastro.Exastro_Days_Tokyo.event_admin.repository.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
/**
 * The persistent class for the events database table.
 * 
 */
@Entity
@Table(name="events")
public class EventDetail {
	
	@Id
	@Column(name="event_id")
	private int eventId;
	
	@Column(name="event_name")
	private String eventName;
	
	@Column(name="event_overview")
	private String eventOverview;
	
	@Column(name="event_date")
	private Timestamp eventDate;
	
	@Column(name="event_venue")
	private String eventVenue;
	
	@Column(name="delete_flag")
	private boolean deleteFlag;
	
	public EventDetail() {
	}
	
	public EventDetail(String eventName, Timestamp eventDate) {
		this.eventName = eventName;
		this.eventDate = eventDate;
		this.deleteFlag = false;
	}

	public EventDetail(String eventName, String eventOverView, String eventVenue) {
		this.eventName = eventName;
		this.eventOverview = eventOverview;		
		this.eventVenue = eventVenue;
	}
	
	public EventDetail(String eventName, String eventOverView, Timestamp eventDate, String eventVenue, boolean deleteFlag) {
		this.eventName = eventName;
		this.eventOverview = eventOverview;		
		this.eventDate = eventDate;
		this.eventVenue = eventVenue;
		this.deleteFlag = deleteFlag;
	}

	public EventDetail(int eventId, String eventName, String eventOverView, Timestamp eventDate, String eventVenue, boolean deleteFlag) {
		this(eventName, eventOverView, eventDate, eventVenue, deleteFlag);
		this.eventId = eventId;
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
	
	public Timestamp getEventDate() {
		return eventDate;
	}
	public void setEventDate(Timestamp eventDate) {
		this.eventDate = eventDate;
//		this.eventDate = new Timestamp(System.currentTimeMillis());
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

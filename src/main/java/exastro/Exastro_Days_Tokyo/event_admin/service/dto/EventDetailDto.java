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

package exastro.Exastro_Days_Tokyo.event_admin.service.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EventDetailDto extends EventDto{
	private String eventName;
	private String eventOverview;
	private Date eventDate;
	private String eventVenue;
	private List<Integer> speakerIDs = new ArrayList<Integer>();
	private boolean deleteFlag;

	public EventDetailDto() {
		
	}
	
	public EventDetailDto(int eventId, String eventName, 
			String eventOverview, Date eventDate, String eventVenue) {
		super(eventId, eventName, eventDate);
		this.eventOverview = eventOverview;
		this.eventVenue = eventVenue;
	}

	public EventDetailDto(int eventId, String eventName,
			String eventOverview, Date eventDate, String eventVenue, List<Integer> speakerIDs, boolean deleteFlag) {
		this(eventId, eventName,eventOverview, eventDate, eventVenue, deleteFlag);
		this.speakerIDs = new ArrayList<Integer>(speakerIDs);
	}
	public EventDetailDto(int eventId, String eventName, String eventOverView, Date eventDate,String eventVenue, boolean deleteFlag) {
		this(eventName, eventOverView, eventDate, eventVenue, deleteFlag);
		this.eventId = eventId;
	}	

	public EventDetailDto(String eventName, String eventOverview, Date eventDate,String eventVenue, boolean deleteFlag) {
		this.eventName = eventName;
		this.eventOverview = eventOverview;	
		this.eventDate = eventDate;
		this.eventVenue = eventVenue;
		this.deleteFlag = deleteFlag;
	}	
	
	public List<Integer> getSpeakerIDs() {
		return speakerIDs;
	}
	public void setSpeakerIDs(List<Integer> speakerIDs) {
		this.speakerIDs = speakerIDs;
	}
	public String getEventOverview() {
		return eventOverview;
	}
	public void setEventOverview(String eventOverview) {
		this.eventOverview = eventOverview;
	}
	public String getEventVenue() {
		return eventVenue;
	}
	public void setEventVenue(String eventVenue) {
		this.eventVenue = eventVenue;
	}
	public boolean isDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(boolean deleteFlag) {
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

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	private int eventId;

}


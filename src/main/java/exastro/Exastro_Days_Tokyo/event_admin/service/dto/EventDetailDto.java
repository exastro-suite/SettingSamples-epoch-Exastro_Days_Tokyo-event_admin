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

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventDetailDto {
	
	private int eventId;
	private String eventName;
	private Date eventDate;
	private String eventOverview;
	private String eventVenue;
	private boolean deleteFlag;
	
	public EventDetailDto(int eventId, String eventName, Date eventDate, String eventOverview, String eventVenue) {
		this.eventId = eventId;
		this.eventName = eventName;
		this.eventDate = eventDate;
		this.eventOverview = eventOverview;
		this.eventVenue = eventVenue;
	}
	
	public EventDetailDto(String eventName, String eventOverview, Date eventDate, String eventVenue) {
		this.eventName = eventName;
		this.eventDate = eventDate;
		this.eventOverview = eventOverview;	
		this.eventVenue = eventVenue;
	}
}

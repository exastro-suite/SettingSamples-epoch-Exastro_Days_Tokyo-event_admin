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

package exastro.Exastro_Days_Tokyo.event_admin.service;

import org.springframework.stereotype.Service;

import exastro.Exastro_Days_Tokyo.event_admin.repository.vo.EventDetailVO;
import exastro.Exastro_Days_Tokyo.event_admin.service.dto.EventDetailDto;

@Service
public class EventAdminService extends BaseEventService implements EventService {

	public EventAdminService() {
		
	}

	public EventDetailDto getEventDetail(int eventId) {

		logger.debug("method called. [ " + Thread.currentThread().getStackTrace()[1].getMethodName() + " ]");
		
		EventDetailDto eventDetail = null;
		
		try {
			EventDetailVO edvo = repository.getEventDetail(eventId);
			eventDetail = new EventDetailDto(edvo.getEventId(), edvo.getEventName(), edvo.getEventDate(),
					edvo.getEventOverview(), edvo.getEventVenue());
		}
		catch(Exception e) {
			throw e;
		}
		
		return eventDetail;
	}

	public String registerEvent(EventDetailDto ev) {

		EventDetailVO eventDetail = null;
		String resultStr = null;
		try {
			eventDetail = new EventDetailVO(ev.getEventName(), ev.getEventOverview(), ev.getEventDate(),
					ev.getEventVenue());
		    resultStr = repository.registerEvent(eventDetail);
		}
		catch(Exception e) {
			logger.debug(e.getMessage(), e);
			throw e;
		}

		return resultStr;
	}

	public String updateEvent(EventDetailDto ev) {

		EventDetailVO eventDetail = null;
		String resultStr = null;
		try {
			eventDetail = new EventDetailVO(ev.getEventId(), ev.getEventName(), ev.getEventOverview(), ev.getEventDate(),
					ev.getEventVenue());
		    resultStr = repository.updateEvent(eventDetail);
		}
		catch(Exception e) {
			logger.debug(e.getMessage(), e);
			throw e;
		}

		return resultStr;
	}

	public String deleteEvent(int eventId) {
		
		String resultStr = null;
		try {
		    resultStr = repository.deleteEvent(eventId);
		}
		catch(Exception e) {
			logger.debug(e.getMessage(), e);
			throw e;
		}

		return resultStr;
	}
}

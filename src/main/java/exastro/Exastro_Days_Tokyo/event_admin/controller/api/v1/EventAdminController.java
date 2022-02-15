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

package exastro.Exastro_Days_Tokyo.event_admin.controller.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import exastro.Exastro_Days_Tokyo.event_admin.controller.api.v1.form.EventDetailForm;
import exastro.Exastro_Days_Tokyo.event_admin.service.EventAdminService;
import exastro.Exastro_Days_Tokyo.event_admin.service.dto.EventDetailDto;

@RestController
@RequestMapping("/api/v1/event")
public class EventAdminController extends BaseEventController {
	
	public EventAdminController(@Autowired EventAdminService service) {
		this.service = service;
	}
	
	//イベント詳細取得「
	@GetMapping("/{eventId}")
	public EventDetailForm getEventDetail(@PathVariable(value = "eventId") @Validated int eventId) {
		
		logger.debug("method called. [ " + Thread.currentThread().getStackTrace()[1].getMethodName() + " ]");
		
		EventDetailForm eventDetail = null;
		
		try {
			EventDetailDto eventDetailDto = service.getEventDetail(eventId);
			eventDetail = new EventDetailForm(eventDetailDto.getEventId(), eventDetailDto.getEventName(),
					eventDetailDto.getEventOverview(), eventDetailDto.getEventDate(), eventDetailDto.getEventVenue());
		}
		catch(Exception e) {
			logger.debug(e.getMessage(), e);
			throw e;
		}
		
		return eventDetail;
	}
	
	//イベント登録
	@RequestMapping(path = "", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED) 
	public String registerEvent(@RequestBody EventDetailForm ea) {
		
		logger.debug("method called. [ " + Thread.currentThread().getStackTrace()[1].getMethodName() + " ]");
		
		String resultStr = null;
		try {
			EventDetailDto ev = new EventDetailDto(ea.getEventName(), ea.getEventOverview(), ea.getEventDate(),
					ea.getEventVenue());
			
			resultStr = service.registerEvent(ev);
		}
		catch(Exception e) {
			logger.debug(e.getMessage(), e);
			throw e;
		}
		
		return resultStr;
	}
	
	//イベント更新
	@PutMapping("/{eventId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public String updateEvent(@PathVariable(value = "eventId") @Validated int eventId, @RequestBody EventDetailForm ea) {
		
		logger.debug("method called. [ " + Thread.currentThread().getStackTrace()[1].getMethodName() + " ]");
		
		String resultStr = null;
		try {
			// validate data
			if(eventId != ea.getEventId()) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid data.");
			}
			
			EventDetailDto ev = new EventDetailDto(eventId, ea.getEventName(), ea.getEventDate(),
					ea.getEventOverview(), ea.getEventVenue());
			
			resultStr = service.updateEvent(ev);
		
		}
		catch(Exception e) {
			logger.debug(e.getMessage(), e);
			throw e;
		}
		
		return resultStr;
	}
	
	//イベント削除
	@DeleteMapping("/{eventId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public String deleteEvent(@PathVariable(value = "eventId") @Validated int eventId) {
		
		logger.debug("method called. [ " + Thread.currentThread().getStackTrace()[1].getMethodName() + " ]");
		
		String resultStr = null;
		try {
			resultStr = service.deleteEvent(eventId);
		
		}
		catch(Exception e) {
			logger.debug(e.getMessage(), e);
			throw e;
		}
		
		return resultStr;
	}
	
}

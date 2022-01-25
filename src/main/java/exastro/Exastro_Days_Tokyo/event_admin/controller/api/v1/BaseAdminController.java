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

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import exastro.Exastro_Days_Tokyo.event_admin.controller.api.v1.form.EventForm;
import exastro.Exastro_Days_Tokyo.event_admin.service.EventService;

public class BaseAdminController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	protected EventService service;
	
	
	public BaseAdminController() {
		
	}
	//イベント一覧取得
	@GetMapping("")
	public List<EventForm> event() {
		
		List<EventForm> eventList = null;
		
		try {
//			eventList = service.getEvent()
//					.stream()
//					.map(e -> new EventForm(e.getEventId(), e.getEventName(), e.getEventDate()))
//					.collect(Collectors.toList());
		}
		catch(Exception e) {
			throw e;
		}
		
		return eventList;
	}
}

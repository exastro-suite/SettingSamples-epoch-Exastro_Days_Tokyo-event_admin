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

package exastro.Exastro_Days_Tokyo.event_admin.repository;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import exastro.Exastro_Days_Tokyo.event_admin.repository.config.ConnectionConfig;
import exastro.Exastro_Days_Tokyo.event_admin.repository.vo.EventDetailVO;
import exastro.Exastro_Days_Tokyo.event_admin.repository.vo.EventVO;

@Repository
public class EventRepository extends BaseRepository {

	@Autowired
	public EventRepository(@Qualifier("configEvent") ConnectionConfig connectionConfig,
			RestTemplate restTemplate) {
		this.connectionConfig = connectionConfig;
		this.restTemplate = restTemplate;
	}
	
	public List<EventVO> getEvent() {
		
		logger.debug("method called. [ " + Thread.currentThread().getStackTrace()[1].getMethodName() + " ]");
		
		String apiPath = "/api/v1/event";
		String apiUrl = connectionConfig.buildBaseUri() + apiPath;
		
		EventVO[] resBody = null;
		try {
			
			logger.debug("restTemplate.getForEntity [apiUrl: " + apiUrl + "]");
			resBody = restTemplate.getForObject(apiUrl, EventVO[].class);
			
			return Arrays.asList(resBody);
		}
		catch(Exception e) {
			throw e;
		}
	}
	
	public EventDetailVO getEventDetail(int eventId) {
		
		logger.debug("method called. [ " + Thread.currentThread().getStackTrace()[1].getMethodName() + " ]");
		
		String apiPath = "/api/v1/event/{eventId}";
		String apiUrl = connectionConfig.buildBaseUri() + apiPath;
		
		EventDetailVO resBody = null;
		try {
			
			logger.debug("restTemplate.getForEntity [apiUrl: " + apiUrl + "], [eventId: " + eventId + "]");
			resBody = restTemplate.getForObject(apiUrl, EventDetailVO.class, eventId);
			
			return resBody;
		}
		catch(Exception e) {
			throw e;
		}
	}
	
	public String registerEvent(EventDetailVO ev) {
		
		logger.debug("method called. [ " + Thread.currentThread().getStackTrace()[1].getMethodName() + " ]");
		
		String apiPath = "/api/v1/event";
		String apiUrl = connectionConfig.buildBaseUri() + apiPath;
		
		String resultStr = null;
		
		try {
			
			logger.debug("restTemplate.postForLocation [apiUrl: " + apiUrl + "], [body: " + ev.toString() + "]");
			restTemplate.postForLocation(apiUrl, ev);
			
			resultStr = "{\"result\":\"ok\"}";
			return resultStr;
		}
		catch(Exception e) {
			throw e;
		}
	}
	
	public String updateEvent(EventDetailVO ev) {
		logger.debug("method called. [ " + Thread.currentThread().getStackTrace()[1].getMethodName() + " ]");
		
		String apiPath = "/api/v1/event/" + ev.getEventId();
		String apiUrl = connectionConfig.buildBaseUri() + apiPath;

		String resultStr = null;
		try {
			
			EventDetailVO evo = new EventDetailVO(ev.getEventId(), ev.getEventName(),
						ev.getEventOverview(), new Timestamp(ev.getEventDate().getTime()),
						ev.getEventVenue());
			
			logger.debug("restTemplate.put [apiUrl: " + apiUrl + "], [body: " + ev.toString() + "]");
			restTemplate.put(apiUrl, evo);
		    resultStr = "{\"result\":\"ok\"}";
			return resultStr;
		}
		catch(Exception e) {
			throw e;
		}
	}
	
	public String deleteEvent(int eventId) {
		
		logger.debug("method called. [ " + Thread.currentThread().getStackTrace()[1].getMethodName() + " ]");
		
		String apiPath = "/api/v1/event/{eventId}";
		String apiUrl = connectionConfig.buildBaseUri() + apiPath;

		String resultStr = null;
		try {
			
			logger.debug("restTemplate.getForEntity [apiUrl: " + apiUrl + "], [eventId: " + eventId + "]");
			restTemplate.delete(apiUrl, eventId);

		    resultStr = "{\"result\":\"ok\"}";
			return resultStr;
		}
		catch(Exception e) {
			throw e;
		}
	}
}

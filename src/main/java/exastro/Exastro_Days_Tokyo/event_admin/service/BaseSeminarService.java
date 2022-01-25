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

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import exastro.Exastro_Days_Tokyo.event_admin.repository.SeminarRepository;
import exastro.Exastro_Days_Tokyo.event_admin.service.dto.SeminarListDto;

public abstract class BaseSeminarService {

	@Autowired
	protected SeminarRepository repository;
	
	public BaseSeminarService() {
		
	}

	public List<SeminarListDto> getSeminar(int eventId) {
		
		List<SeminarListDto> seminarList = null;
		
		try {
			seminarList = repository.findByEventEventId(eventId)
					.stream()
					.map(e -> new SeminarListDto(e.getSeminarId(),e.getMstSeminar().getSeminarName(), e.getBlock().getBlockId(), e.getBlock().getBlockName(), e.getStartDatetime()))
					.collect(Collectors.toList());
		}
		catch(Exception e) {
			throw e;
		}
		
		return seminarList;
	}
}

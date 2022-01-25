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

import org.springframework.stereotype.Service;

import exastro.Exastro_Days_Tokyo.event_admin.repository.entity.SeminarDetail;
import exastro.Exastro_Days_Tokyo.event_admin.service.dto.SeminarDetailDto;

@Service
public class SeminarAdminServiceImpl extends BaseSeminarService implements SeminarAdminService {


	public SeminarAdminServiceImpl() {
		
	}

	public SeminarDetailDto getSeminarDetail(int seminarId) {
		
		SeminarDetailDto seminarInfo =null;

		try {
			//セミナーID に紐づくセミナー情報を取得
			SeminarDetail ev = repository.findBySeminarId(seminarId);
			seminarInfo = new SeminarDetailDto(ev.getSeminarId(), ev.getMstSeminar().getSeminarName(), ev.getBlock().getBlockId(), ev.getBlock().getBlockName(),
					 ev.getStartDatetime(), ev.getSpeakerId(), ev.getMstSeminar().getSeminarOverview(), ev.getMstSeminar().getCapacity());
		}
		catch(Exception e) {
			throw e;
		}

		return seminarInfo;
	}

	public List<Integer> getSpeakerIdList(int eventId) {
		
		List<Integer> speakerIdList = null;
		
		try {
			speakerIdList = repository.findDetailByEventEventId(eventId)
					.stream()
					.map(e -> e.getSpeakerId())
					.filter(e -> e != null)
					.distinct()
					.collect(Collectors.toList());
		}
		catch(Exception e) {
			throw e;
		}
		
		return speakerIdList;
	}

}

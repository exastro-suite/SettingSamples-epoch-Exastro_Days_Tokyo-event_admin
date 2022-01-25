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
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import exastro.Exastro_Days_Tokyo.event_admin.controller.api.v1.form.SeminarListForm;
import exastro.Exastro_Days_Tokyo.event_admin.service.SeminarService;

//@RestController
//@RequestMapping("/api/v1/seminar")
public class BaseSeminarController {
	
	@Autowired
	protected SeminarService service;
	
	public BaseSeminarController() {
		
	}

	@GetMapping("")
	public List<SeminarListForm> seminar(@RequestParam(name = "eventId", required = true) int eventId) {
		
		List<SeminarListForm> seminarList = null;
		
		try {
			seminarList = service.getSeminar(eventId)
					.stream()
					.map(s -> new SeminarListForm(s.getSeminarId(), s.getSeminarName(), s.getBlockId(), s.getBlockName(), s.getStartDatetime()))
					.collect(Collectors.toList());
		}
		catch(Exception e) {
			throw e;
		}
		
		return seminarList;
	}
}

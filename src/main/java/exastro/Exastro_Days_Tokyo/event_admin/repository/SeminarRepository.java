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

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import exastro.Exastro_Days_Tokyo.event_admin.repository.entity.Seminar;
import exastro.Exastro_Days_Tokyo.event_admin.repository.entity.SeminarDetail;

@Repository
public interface SeminarRepository extends JpaRepository<SeminarDetail, String> {


	//イベントに紐づくセミナー一覧を取得
	List<Seminar>  findByEventEventId(int eventId);


	//セミナー詳細を取得
	SeminarDetail  findBySeminarId(int seminarId);


	//イベントに紐づくセミナーの詳細付き一覧を取得
	List<SeminarDetail>  findDetailByEventEventId(int eventId);
}

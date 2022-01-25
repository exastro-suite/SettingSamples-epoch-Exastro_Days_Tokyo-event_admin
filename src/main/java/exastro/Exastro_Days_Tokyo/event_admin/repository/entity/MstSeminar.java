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

package exastro.Exastro_Days_Tokyo.event_admin.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
/**
 * The persistent class for the mst_seminars database table.
 * 
 */
@Entity
@Table(name="mst_seminars")
public class MstSeminar {
	
	@Id
	@Column(name="mst_seminar_id")
	private int mstSeminarId;
	
	@Column(name="seminar_name")
	private String seminarName;
	
	// セミナー概要
	@Column(name="seminar_overview")
	private String seminarOverview;
	
	// 定員
	@Column(name="capacity")
	private Integer capacity;
	
	@Column(name="delete_flag")
	private boolean deleteFlag;
	
	public MstSeminar() {
	}
	
	// コンストラクタ
	public MstSeminar(String seminarName) {
		this.seminarName = seminarName;
		this.deleteFlag = false;
	}
	
	public int getMstSeminarId() {
		return mstSeminarId;
	}
	public void setMstSeminarId(int mstSeminarId) {
		this.mstSeminarId = mstSeminarId;
	}
	
	public String getSeminarName() {
		return seminarName;
	}
	public void setSeminarName(String seminarName) {
		this.seminarName = seminarName;
	}

	public String getSeminarOverview() {
		return seminarOverview;
	}
	public void setSeminarOverview(String seminarOverview) {
		this.seminarOverview = seminarOverview;
	}

	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public boolean getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

}

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

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
/**
 * The persistent class for the seminars database table.
 * 
 */
@Entity
@Table(name="seminars")
public class SeminarDetail {
	
	@Id
	@Column(name="seminar_id")
	private int seminarId;
	
	@Column(name="start_datetime")
	private Timestamp startDatetime;
	
	@Column(name="delete_flag")
	private boolean deleteFlag;

	@ManyToOne
	@JoinColumn(name = "mst_seminar_id")
	private MstSeminar mstSeminar;

	@ManyToOne
	@JoinColumn(name = "block_id")
	private Block block;
	
	@Column(name="speaker_id")
	private Integer speakerId;
	
	@ManyToOne
	@JoinColumn(name = "event_id")
	private EventDetail event;
	
	public SeminarDetail() {
	}
	
	// コンストラクタ
	public SeminarDetail(Timestamp startDatetime, MstSeminar mstSeminar, Block block, EventDetail event) {
		this.startDatetime = startDatetime;
		this.mstSeminar = mstSeminar;
		this.block = block;
		this.event = event;
		this.deleteFlag = false;
	}
	
	public int getSeminarId() {
		return seminarId;
	}

	public void setSeminarId(int seminarId) {
		this.seminarId = seminarId;
	}

	public Timestamp getStartDatetime() {
		return startDatetime;
	}

	public void setStartDatetime(Timestamp startDatetime) {
		this.startDatetime = startDatetime;
	}

	public boolean getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public MstSeminar getMstSeminar() {
		return mstSeminar;
	}

	public void setMstSeminar(MstSeminar mstSeminar) {
		this.mstSeminar = mstSeminar;
	}

	public Block getBlock() {
		return block;
	}

	public void setBlock(Block block) {
		this.block = block;
	}

	public Integer getSpeakerId() {
		return speakerId;
	}

	public void setSpeakerId(Integer speakerId) {
		this.speakerId = speakerId;
	}

	public EventDetail getEvent() {
		return event;
	}

	public void setEvent(EventDetail event) {
		this.event = event;
	}
	
}

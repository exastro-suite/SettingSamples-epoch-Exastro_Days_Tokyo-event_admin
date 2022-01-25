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
 * The persistent class for the mst_blocks database table.
 * 
 */
@Entity
@Table(name="mst_blocks")
public class Block {
	
	@Id
	@Column(name="block_id")
	private int blockId;
	
	@Column(name="block_name")
	private String blockName;
	
	@Column(name="delete_flag")
	private boolean deleteFlag;
	
	public Block() {
	}	
	
	public Block(String blockName) {
		this.blockName = blockName;
		this.deleteFlag = false;
	}
	
	public int getBlockId() {
		return this.blockId;
	}
	public void setBlockId(int blockId) {
		this.blockId = blockId;
	}

	public String getBlockName() {
		return this.blockName;
	}
	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}

	public boolean getDeleteFlag() {
		return this.deleteFlag;
	}
	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
}

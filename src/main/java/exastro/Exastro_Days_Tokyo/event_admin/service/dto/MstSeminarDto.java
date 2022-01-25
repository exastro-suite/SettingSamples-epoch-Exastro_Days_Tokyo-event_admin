package exastro.Exastro_Days_Tokyo.event_admin.service.dto;

public class MstSeminarDto {
	private int mstSeminarId;
	private String seminarName;
	
	public MstSeminarDto() {
		
	}
	
	public MstSeminarDto(String seminarName) {
		this.seminarName = seminarName;
	}
	public MstSeminarDto(int mstSeminarId, String seminarName) {
		this.mstSeminarId = mstSeminarId;
		this.seminarName = seminarName;
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
}


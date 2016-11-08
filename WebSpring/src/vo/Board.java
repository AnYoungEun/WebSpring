package vo;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class Board {
	private String idx;
	private String title;
	private String delGb;
	private Date creaDtm;
	private String creaId;
	private String fileSrc;
	
	public String getIdx() {
		return idx;
	}
	public void setIdx(String idx) {
		this.idx = idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDelGb() {
		return delGb;
	}
	public void setDelGb(String delGb) {
		this.delGb = delGb;
	}
	public Date getCreaDtm() {
		return creaDtm;
	}
	public void setCreaDtm(Date creaDtm) {
		this.creaDtm = creaDtm;
	}
	public String getCreaId() {
		return creaId;
	}
	public void setCreaId(String creaId) {
		this.creaId = creaId;
	}
	public String getFileSrc() {
		return fileSrc;
	}
	public void setFileSrc(String fileSrc) {
		this.fileSrc = fileSrc;
	}
	public int getHitCnt() {
		return hitCnt;
	}
	public void setHitCnt(int hitCnt) {
		this.hitCnt = hitCnt;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	
	int hitCnt;
	String contents;
}

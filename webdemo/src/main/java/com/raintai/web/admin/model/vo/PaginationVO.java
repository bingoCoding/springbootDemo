/**
 * 
 */
package com.raintai.web.admin.model.vo;

/**
 * 分页VO
 * 
 * @author 	alanwei
 * @since	2016-12-27
 */
public class PaginationVO {

	/** 页数 */
	private Integer pageNum = 1;

	/** 记录数 */
	private Integer pageSize = 10;

	/**
	 * @return the pageNum
	 */
	public Integer getPageNum() {
		return pageNum;
	}

	/**
	 * @param pageNum the pageNum to set
	 */
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	/**
	 * @return the pageSize
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
}

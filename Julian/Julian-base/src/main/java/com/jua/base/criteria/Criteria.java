package com.jua.base.criteria;

import java.util.HashMap;
import java.util.Map;

/**
 * 公用条件查询类
 */
public class Criteria {
	/**
	 * 存放条件查询值
	 */
	private Map<String, Object> condition; //注意如果是数字类型，则以字符串的形式传入 eg condition.put(key,"0")

	/**
	 * 是否相异
	 */
	protected boolean distinct;


	private int currentPage = 1; // 当前页
	private int totalCount = 0; // 总条数
	private int pageSize = 10; // 每页条数
	private boolean islimit = true; //默认所有查询为分页查询

	/**
	 * 排序字段
	 */
	protected String orderByClause;
	

	/**
	 * 分页字段
	 */
	protected String limitClause;

	protected Criteria(Criteria example) {
		this.orderByClause = example.orderByClause;
		this.condition = example.condition;
		this.distinct = example.distinct;
		this.limitClause = example.limitClause;
		this.islimit = example.islimit;
	}

	public Criteria() {
		condition = new HashMap<String, Object>();
		//设置删除条件
		condition.put("deleteFlag", "0");
	}
	/**
	 * 单条件查询 
	 * 
	 */
	public Criteria(String key,String value){
		condition = new HashMap<String, Object>();
		condition.put(key, value);
		//设置删除条件
		condition.put("deleteFlag", "0");
	}

	public void clear() {
		condition.clear();
		orderByClause = null;
		distinct = false;
		limitClause = null;
	}

	/**
	 * @param condition
	 *            查询的条件名称
	 * @param value
	 *            查询的值
	 */
	public Criteria put(String condition, Object value) {
		this.condition.put(condition, value);
		return (Criteria) this;
	}

	/**
	 * @param orderByClause
	 *            排序字段
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * @param distinct
	 *            是否相异
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	public String getLimitClause() {
		if(this.islimit){
			int pageOffset = (this.currentPage - 1) * this.pageSize;
			limitClause = " limit " + pageOffset + "," + pageSize;
			return limitClause;
		}
		return "";
	}
	
	

	/**
	 * 设置是否分页
	 */
	public boolean isIslimit() {
		return islimit;
	}
	
	/**
	 * 设置是否分页
	 */
	public void setIslimit(boolean islimit) {
		this.islimit = islimit;
	}

	public String getOrderByClause() {
		return orderByClause;
	}

	public void setCondition(Map<String, Object> condition) {
		this.condition = condition;
	}

	public Map<String, Object> getCondition() {
		return condition;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * 得到总条数
	 */
	public int getTotalCount() {
		return totalCount;
	}

	/**
	 * 得到总页数
	 * 
	 * @return
	 */
	public int getTotalPage() {
		int pageCount = this.totalCount / this.pageSize + 1;
		// 如果模板==0，且总数大于1，则减一
		if ((this.totalCount % this.pageSize == 0) && pageCount > 1)
			pageCount--;
		return pageCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
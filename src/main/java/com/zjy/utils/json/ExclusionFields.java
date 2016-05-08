package com.zjy.utils.json;

/**
 * 
 * @author JH  2014
 */
public class ExclusionFields {
	public static final String[] USER_EXCLUSION = { "password", "birthday", "officeRoom", "email", "mobile",
			"officePhone", "status", "userType", "headImage", "nationality", "sortNum", "memo1", "memo2", "gradeId",
			"grade", "mainDept", "otherDepts", "relType" };
	public static final String[] REGION_EXCLUSION = { "parentId", "title", "descript", "globalSN", "memo" };
	public static final String[] NAVIGATOR_BAR_EXCLUSION = { "parentId", "title", "descript", "sortNum", "memo",
			"icon", "showIcon","isAllow"};
	
	public static final String[] NAVIGATOR_MENU_EXCLUSION = {"barId","title","sortNum","url","target","icon","showIcon","descript","memo"};
	public static final String[] DICT_EXCLUSION = { "parent", "children", "parentId", "dkey", "descript", "sortNum", "memo" };
	
	public static final String[] ROLE_EXCLUSION = { "parentId", "level", "descript", "sortNum", "status", "memo", "relType" };
	
	public static final String[] ATTCH_EXCLUSION = {"fileContent"};
}
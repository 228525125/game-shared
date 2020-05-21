package org.cx.game.host;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 用于记录整场比赛的摄像机
 * @author chenxian
 *
 */
public class Camera implements Serializable {
	
	private List<Record> recordList = new ArrayList<Record>();
	
	public void addRecord(Record record){
		recordList.add(record);
	}
	
	public Integer getNewSequence(){
		return recordList.size()+1;
	}
	
	/**
	 * 
	 * 因为sequence是从1开始，sequence=List.size()
	 * @return
	 */
	public Integer getLastSequence(){
		return recordList.size();
	}
	
	/**
	 * 根据sequence获取记录，默认sequence=List.index+1，
	 * @param sequence
	 * @return
	 */
	public Record getRecord(Integer sequence){
		if(recordList.size()>=sequence)
			return recordList.get(sequence-1);
		return null;
	}
	
	/**
	 * 查询sequence大于greaterThan的记录
	 * @param greaterThan 基零
	 * @return
	 */
	public List<Record> query(Integer greaterThan){
		List<Record> list = new ArrayList<Record>();
		for(int i=greaterThan;i<recordList.size();i++){
			list.add(recordList.get(i));
		}
		
		return list;
	}
	
	/**
	 * 查询sequence大于greaterThan的记录
	 * @param greaterThan 基零
	 * @return
	 */
	public List<Record> query(Integer greaterThan, String action){
		List<Record> retList = new ArrayList<Record>();
		List<Record> list = query(greaterThan);
		for(int i=0;i<list.size();i++){
			Record record = list.get(i);
			if(record.getAction().equals(action))
				retList.add(record);
		}
		return retList;
	}
}

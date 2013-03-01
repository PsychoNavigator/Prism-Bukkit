package me.botsko.prism.actions;

import me.botsko.prism.actionlibs.ActionType;

public interface Action {
	
	
	/**
	 * 
	 * @return
	 */
	public String getActionTime();
	
	
	/**
	 * 
	 * @return
	 */
	public ActionType getType();
	
	
	/**
	 * 
	 * @return
	 */
	public String getWorldName();
	
	
	/**
	 * 
	 * @return
	 */
	public String getPlayerName();
	
	
	/**
	 * 
	 * @return
	 */
	public double getX();
	
	
	/**
	 * 
	 * @return
	 */
	public double getY();
	
	
	/**
	 * 
	 * @return
	 */
	public double getZ();
	
	
	/**
	 * 
	 * @return
	 */
	public int getBlockId();
	
	
	/**
	 * 
	 * @return
	 */
	public byte getBlockSubId();
	
	
	/**
	 * 
	 * @return
	 */
	public String getData();

	
	/**
	 * 
	 * @return
	 */
	public String getDisplayDate();


	/**
	 * 
	 * @return
	 */
	public String getDisplayTime();
	
	
	/**
	 * 
	 * @return
	 */
	public String getTimeSince();


	/**
	 * 
	 * @return
	 */
	public int getId();
	
	
	/**
	 * 
	 * @return
	 */
	public int getAggregateCount();
	
	
	/**
	 * 
	 * @return
	 */
	public String getNiceName();
	
}
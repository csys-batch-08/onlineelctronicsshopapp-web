package com.onlineelectronicshopdao;

import java.util.List;

import com.onlineelectronicshop.model.Components;

public interface ComponentDAO {
	public void insertCmponent(Components component);
	public List<Components> showComponent();
	public List<Components> showComponent(String search);
	public int findComponentId(String ComponentName);
	public void updateComponent(Double price,String componentName);
	public Components findComponent(int componentId);
	public void updateAvailable(String ComponetName);
	public void deleteComponent(String deleteComponent);
	public Double findPrice(int comId);
	
}

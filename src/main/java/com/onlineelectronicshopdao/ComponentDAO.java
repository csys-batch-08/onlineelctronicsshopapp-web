package com.onlineelectronicshopdao;

import java.util.List;

import com.onlineelectronicshop.model.Components;

public interface ComponentDAO {
	public List<Components> showComponent();
	public int findComponentId(String ComponentName);
	
	public Components findComponent(int componentId);
	public void updateComponent(String updateComponent);
	public void deleteComponent(String deleteComponent);
	public Double findPrice(int comId);
	
}

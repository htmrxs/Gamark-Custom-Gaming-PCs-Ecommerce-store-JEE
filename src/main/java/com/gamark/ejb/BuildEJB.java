package com.gamark.ejb;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Remove;
import javax.ejb.Stateful;

@Stateful
public class BuildEJB{
    
	private List<Integer> buildItems = new ArrayList<>();
	
	public void addItem(Integer item){
		if(!buildItems.contains(item))
			buildItems.add(item);
	}

	public void removeItem(Integer item){
		if(buildItems.contains(item))
			buildItems.remove(item);
	}
	
	public float getTotalprice()
        {
		if(buildItems ==null || buildItems.isEmpty())
			return 0;
                float total = 0f;
                for(Integer buildItem : buildItems){
                        total+=buildItem;
                }
                return total;
	}
	
	public void empty(){
		buildItems.clear();
	}
	
	 @Remove
	public void checkout(){
		buildItems.clear();
	}
	
}
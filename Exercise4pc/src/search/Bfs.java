package search;

import java.util.ArrayList;
import java.util.Iterator;

import rp13.search.interfaces.Agenda;

public class Bfs<ItemT> implements Agenda<ItemT>
{
	private ArrayList<ItemT> agenda = new ArrayList<ItemT>();
	
	@Override
	public void push(ItemT _item)
	{
		agenda.add(_item);
	}

	@Override
	public ItemT pop() {
		ItemT node = agenda.get(0);
		agenda.remove(0);
		return node;
	}

	@Override
	public boolean isEmpty() {
		return agenda.isEmpty();
	}

	@Override
	public boolean contains(ItemT _item) {
		return agenda.contains(_item);
	}

	@Override
	public Iterator<ItemT> iterator() {
		
		return null;
	}

}


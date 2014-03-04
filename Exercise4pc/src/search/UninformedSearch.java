package search;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import rp13.search.interfaces.Agenda;
import rp13.search.interfaces.SuccessorFunction;
import rp13.search.util.*;

public class UninformedSearch<ActionT, StateT>
{
	private ActionStatePair<ActionT, StateT> node;
	private ActionStatePair<ActionT, StateT> theNode;
	public ArrayList<ActionT> doSearch(StateT start, StateT goal, SuccessorFunction<ActionT, StateT> successorFn, Agenda<ActionStatePair<ActionT, StateT>> agenda)
	{
		
		EqualityGoalTest<StateT> test = new EqualityGoalTest<StateT>(goal);
		List<ActionStatePair<ActionT, StateT>> firstSuccessors = new ArrayList<ActionStatePair<ActionT, StateT>>();
		ArrayList<StateT> visited = new ArrayList<StateT>();
		successorFn.getSuccessors(start, firstSuccessors);
		visited.add(start);
		assert(firstSuccessors != null);
		for (ActionStatePair<ActionT, StateT> node: firstSuccessors) 
		{
			if(visited.contains(node.getState()) == false)
					{
						agenda.push(node);
					}
		}
		
		while(!agenda.isEmpty())
		{
			ActionStatePair<ActionT, StateT> currNode = agenda.pop();
			visited.add(currNode.getState());
			if(test.isGoal(currNode.getState()))
			{
				ArrayList<ActionT> stack = new ArrayList<ActionT>();
				theNode = currNode;
				stack.add(0, theNode.getAction());
				while(theNode.getParent() != null)
				{
					theNode = theNode.getParent();
					stack.add(0, theNode.getAction());
				}
				System.out.println(goal.toString());
				return stack;
			}
			else
			{
				ArrayList<ActionStatePair<ActionT, StateT>> successors = new ArrayList<ActionStatePair<ActionT, StateT>>();
			
				successorFn.getSuccessors(currNode.getState(), successors);
				for (ActionStatePair<ActionT, StateT> node : successors) 
				{
					if(visited.contains(node.getState()) == false)
					{
						node.setParent(currNode);
						agenda.push(node);
					}
				}
			}
		}
		return null;
		
		
		
	}
	

}


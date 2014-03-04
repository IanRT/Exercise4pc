package search;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import rp13.search.interfaces.Agenda;
import rp13.search.problem.puzzle.EightPuzzle;
import rp13.search.problem.puzzle.EightPuzzle.PuzzleMove;
import rp13.search.problem.puzzle.EightPuzzleSuccessorFunction;
import rp13.search.util.ActionStatePair;

@Test
public class Tester<ItemT> {
 
	private EightPuzzle puzzle;
	private EightPuzzle goal;
	private EightPuzzleSuccessorFunction succs;
	private Agenda<ActionStatePair<PuzzleMove, EightPuzzle>> bfs;
	private Agenda<ActionStatePair<PuzzleMove, EightPuzzle>> dfs;
	

  @BeforeMethod
  public void beforeMethod() 
  {
	  goal = EightPuzzle.orderedEightPuzzle();
	  puzzle = EightPuzzle.randomEightPuzzle();
	  succs = new EightPuzzleSuccessorFunction();
	  bfs = new Bfs<ActionStatePair<PuzzleMove, EightPuzzle>>();
	  dfs = new Dfs<ActionStatePair<PuzzleMove, EightPuzzle>>();
	  
  }
  
  public void bfsTestEight()
  {
	  UninformedSearch<PuzzleMove, EightPuzzle> searcher = new UninformedSearch<PuzzleMove, EightPuzzle>();
	  System.out.println(puzzle.toString());
	  System.out.println(searcher.doSearch(puzzle, goal, succs, bfs));
  }
  
  public void dfsTestEight()
  {
	  UninformedSearch<PuzzleMove, EightPuzzle> searcher = new UninformedSearch<PuzzleMove, EightPuzzle>();
	  System.out.println(puzzle.toString());
	  System.out.println(searcher.doSearch(puzzle, goal, succs, dfs));
  }
 
}

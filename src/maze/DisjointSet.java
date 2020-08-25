
package maze;

public class DisjointSet {
    
    //TODO - write all the methods of this class
    
    /**
     * make a singleton set out of each cell in the maze
     * @param maze
     */
    public void makeSet(MazeCell[][] mazeCell) {
    	for(int i = 0; i < mazeCell.length; i++)
    	{
    		for(int j = 0; j < mazeCell[0].length; j++)
    		{
    			mazeCell[i][j].setParent(mazeCell[i][j]);
    		}
    	}
    }

    /**
     * Create the union of the sets that contain cell1 and cell2.
     * If the two cells are in the same set, nothing changes,
     * else create the new set as a union. 
     * Please see the union-find algorithm.
     * @param cell1
     * @param cell2
     */
    public void union(MazeCell cell1, MazeCell cell2){
    	MazeCell p1 = find(cell1);
    	MazeCell p2 = find(cell2);
        if(p1 != p2)
        {
        	if(p1.getRank() > p2.getRank())
        	{
        		p2.setParent(p1);
        	}
        	else if(p1.getRank() < p2.getRank())
        	{
        		p1.setParent(p2);
        	}
        	else
        	{
        		p2.setRank(p2.getRank() + 1);
        		p1.setParent(p2);
        	}
        }
    }

    /**
     * Find the set that the cell is a part of.
     * While finding the set, do the path compression as well.
     * @param cell
     * @return
     */
    public MazeCell find(MazeCell cell){
    	while(cell.getParent() != cell)
    	{
    		cell = cell.getParent();
    	}
        return cell;
    }

}

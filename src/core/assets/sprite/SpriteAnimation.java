package core.assets.sprite;

public class SpriteAnimation {
	public static final String DEFAULT = "default";
	
	protected String name;
	protected int startCol;
	protected int startRow;
	protected int endCol;
	protected int endRow;
	protected int frameCount;
	protected int colDirection;
	protected int rowDirection;
	protected int speed;
	protected boolean repeat;

	public SpriteAnimation(String name) {
		this(name, 0, 0, 0, 0, 0, false);
	}
	
	public SpriteAnimation(String name, int col, int row) {
		this(name, col, row, col, row, 0, false);
	}
	
	public SpriteAnimation(String name, int startCol, int startRow, int endCol, int endRow, int spd, boolean repeat){
		this.name = name;

		this.startCol = startCol;
		this.startRow = startRow;
		
		this.endCol = endCol;
		this.endRow = endRow;

		int colCount = endCol - startCol;
		int rowCount = endRow - startRow;
		this.frameCount = (colCount > rowCount) ? colCount : rowCount;
		this.frameCount++;
		
		this.colDirection = new Integer(endCol).compareTo(startCol);
		this.rowDirection = new Integer(endRow).compareTo(startRow);

		this.speed = spd;
		this.repeat = repeat;
	}

// Name

	public String getName() {		return this.name;			}

// Frame

	public int[] getFrameAtIndex(int i) {
		int x = this.getStartCol() + (i * this.getColDirection());
		int y = this.getStartRow() + (i * this.getRowDirection());

		return new int[] {x, y};
	}

	public int getStartCol() { 		return this.startCol; 		}

	public int getStartRow() { 		return this.startRow; 		}

	public int getEndCol() { 		return this.endCol; 		}

	public int getEndRow() { 		return this.endRow; 		}

	public int getFrameCount() { 	return this.frameCount;		}

	public int getColDirection() { 	return this.colDirection; 	}

	public int getRowDirection() { 	return this.rowDirection; 	}

// Behavior

	public int getSpeed() { 		return this.speed; 			}
	
	public boolean isRepeatable() { return this.repeat; 		}
}

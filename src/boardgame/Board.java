package boardgame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;

	public Board(int rows, int columns) {
		if (rows < 1 || columns < 1) {
			throw new BorardException("Error creating board: there mustbe at least 1 row and 1 column");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public Piece piece(int row, int column) {
		if (!positionExists(row, column)) {
          throw new  BorardException ("Position not on the board");
		}
		return pieces[row][column];
	}

	public Piece piece(Position position) {
		if (!positionExiststs(position)) {
	          throw new  BorardException ("Position not on the board");
			}
		return pieces[position.getRow()][position.getColumn()];
	}

	public void placePiece(Piece piece, Position position) {
		if(thereIsPiece(position)) {
			throw new BorardException("there is already a piece on position" + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}

	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}

	public boolean positionExiststs(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}

	public boolean thereIsPiece(Position position) {
		if (!positionExiststs(position)) {
	          throw new  BorardException ("Position not on the board");
			}
		return piece(position) != null;
	}
}

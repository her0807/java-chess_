package chess.domain.position;

import chess.domain.piece.Direction;
import chess.domain.piece.Piece;
import java.util.Objects;

public class Position {

    private static final int FIRST_BEGIN = 0;
    private static final int FIRST_END = 1;
    private static final int SECOND_BEGIN = 1;
    private static final int SECOND_END = 2;

    private final Column column;
    private final Row row;

    public Position(Column column, Row row) {
        this.column = column;
        this.row = row;
    }

    public Position(String value) {
        this(Column.of(value.substring(FIRST_BEGIN, FIRST_END)),
                Row.of(value.substring(SECOND_BEGIN, SECOND_END)));
    }

    public Direction findDirection(Position position, Piece piece) {
        int x = column.calculateGap(position.column);
        int y = row.calculateGap(position.row);

        if (piece.isStep()) {
            return Direction.of(x, y);
        }

        return summarizeDirection(x, y);
    }

    private Direction summarizeDirection(int x, int y) {
        int nx = summarizeStep(x, y);
        int ny = summarizeStep(y, x);

        return Direction.of(nx, ny);
    }

    private int summarizeStep(int targetStep, int contrastStep) {
        if (targetStep == 0) {
            return 0;
        }
        if (isSteps(targetStep, contrastStep)) {
            return summarize(targetStep);
        }
        return targetStep;
    }

    private boolean isSteps(int targetStep, int contrastStep) {
        float countingStep = (float) contrastStep / Math.abs(targetStep);
        return countingStep == 0 || countingStep == 1 || countingStep == -1;
    }

    private int summarize(int step) {
        return step / Math.abs(step);
    }

    public boolean isSameRow(Row row) {
        return this.row == row;
    }

    public boolean isSameColumn(Position position) {
        return this.column == position.column;
    }

    public boolean movable(Direction direction) {
        return column.movable(direction.getColumn()) && row.movable(direction.getRow());
    }

    public Position move(Direction direction) {
        return new Position(column.move(direction.getColumn()), row.move(direction.getRow()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position = (Position) o;
        return column == position.column && row == position.row;
    }

    @Override
    public int hashCode() {
        return Objects.hash(column, row);
    }

    @Override
    public String toString() {
        return "Position{" +
                "column=" + column +
                ", row=" + row +
                '}';
    }
}

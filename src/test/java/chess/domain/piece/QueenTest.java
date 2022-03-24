package chess.domain.piece;

import static org.assertj.core.api.Assertions.assertThat;

import chess.domain.position.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class QueenTest {

    @DisplayName("이동 가능 확인")
    @ParameterizedTest
    @CsvSource(value = {"a1,a5", "a5,a1", "d1,d5", "d5,d1", "a1,c3", "c3,a1", "a3,c1", "c1,a3"})
    void movable(String toValue, String fromValue) {
        // given
        Position to = new Position(toValue);
        Position from = new Position(fromValue);

        Queen queen = new Queen();

        // then
        assertThat(queen.movable(to, from)).isTrue();
    }

    @DisplayName("이동 불가 확인")
    @Test
    void notMovable() {
        // given
        Position to = new Position("a1");
        Position from = new Position("b3");

        Queen queen = new Queen();

        // then
        assertThat(queen.movable(to, from)).isFalse();
    }
}
package algorithm.explore.card;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Card {

    private String mark;

    private String color;

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Card(String mark, String color) {
        this.mark = mark;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Card{" +
                "mark='" + mark + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public static List<Card> generator() {
        List<Card> cards1 = Stream.iterate(2, x -> x + 1).limit(13).map(it -> {
            if (it < 10) {
                return it.toString();
            } else if (it == 11) {
                return "J";
            } else if (it == 12) {
                return "Q";
            } else if (it == 13) {
                return "K";
            } else {
                return "A";
            }
        }).map(it -> new Card(it, "红桃")).collect(Collectors.toList());
        List<Card> cards2 = Stream.iterate(2, x -> x + 1).limit(13).map(it -> {
            if (it < 10) {
                return it.toString();
            } else if (it == 11) {
                return "J";
            } else if (it == 12) {
                return "Q";
            } else if (it == 13) {
                return "K";
            } else {
                return "A";
            }
        }).map(it -> new Card(it, "黑桃")).collect(Collectors.toList());
        List<Card> cards3 = Stream.iterate(2, x -> x + 1).limit(13).map(it -> {
            if (it < 10) {
                return it.toString();
            } else if (it == 11) {
                return "J";
            } else if (it == 12) {
                return "Q";
            } else if (it == 13) {
                return "K";
            } else {
                return "A";
            }
        }).map(it -> new Card(it, "梅花")).collect(Collectors.toList());
        List<Card> cards4 = Stream.iterate(2, x -> x + 1).limit(13).map(it -> {
            if (it < 10) {
                return it.toString();
            } else if (it == 11) {
                return "J";
            } else if (it == 12) {
                return "Q";
            } else if (it == 13) {
                return "K";
            } else {
                return "A";
            }
        }).map(it -> new Card(it, "方块")).collect(Collectors.toList());
        return Stream.of(cards1, cards2, cards3, cards4).flatMap(Collection::stream).collect(Collectors.toList());
    }
}

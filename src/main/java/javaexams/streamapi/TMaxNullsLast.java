package javaexams.streamapi;

import java.util.Comparator;
import java.util.stream.Stream;

public class TMaxNullsLast {

    static class Tag {

        Long time;

        Tag(Long time) {
            this.time = time;
        }

        Long getTime() {
            return time;
        }

        void setTime(Long time) {
            this.time = time;
        }

        @Override
        public String toString() {
            return String.valueOf(time);
        }
    }

    public static void main(String[] args) {
        Tag tag2 = new Tag(4L);
        Tag tag1 = new Tag(null);

        System.out.println(Stream.of(tag1, tag2)
            .max(Comparator.comparing(Tag::getTime, Comparator.nullsLast(Comparator.naturalOrder())))
            .get()
        );

        Tag tag3 = new Tag(null);
        Tag tag4 = new Tag(null);

        System.out.println(Stream.of(tag1, tag2)
            .max(Comparator.comparing(Tag::getTime, Comparator.nullsLast(Comparator.naturalOrder())))
            .get()
        );
    }


}

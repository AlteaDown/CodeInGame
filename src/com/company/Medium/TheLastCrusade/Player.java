package com.company.Medium.TheLastCrusade;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int columnCount = in.nextInt(); // number of columns.
        int rowCount = in.nextInt(); // number of rows.
        in.nextLine();


        List<List<RoomType>> rows = new ArrayList<>();
        for (int i = 0; i < rowCount; i++) {
            rows.add(Pattern.compile(System.lineSeparator(), Pattern.LITERAL)
                    .splitAsStream(in.nextLine())
                    .flatMap(s -> Arrays.stream(s.split("\\s+")))
                    .map(Integer::parseInt)
                    .map(type -> RoomType.values()[type])
                    .collect(Collectors.toList()));
        }
        int EX = in.nextInt(); // the coordinate along the X axis of the exit (not useful for this first mission, but must be read).

        // game loop
        while (true) {
            Point playerCoordinates = new Point(in.nextInt(), in.nextInt());
            Direction enterDirection = Direction.valueOf(in.next());

            RoomType currentRoom = rows.get(playerCoordinates.y).get(playerCoordinates.x);
            Direction newDirection = currentRoom.tunnelList.get(enterDirection);
            switch (newDirection) {
                case TOP:
                    playerCoordinates.setLocation(playerCoordinates.x, playerCoordinates.y - 1);
                    break;
                case RIGHT:
                    playerCoordinates.setLocation(playerCoordinates.x + 1, playerCoordinates.y);
                    break;
                case BOTTOM:
                    playerCoordinates.setLocation(playerCoordinates.x, playerCoordinates.y + 1);
                    break;
                case LEFT:
                    playerCoordinates.setLocation(playerCoordinates.x - 1, playerCoordinates.y);
                    break;
            }

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");


            // One line containing the X Y coordinates of the room in which you believe Indy will be on the next turn.
            System.out.println(playerCoordinates.x + " " + playerCoordinates.y);
        }
    }

    enum RoomType {
        TYPE_0('█', new HashMap<>()),
        TYPE_1('╋', new HashMap<Direction, Direction>() {
            {
                put(Direction.TOP, Direction.BOTTOM);
                put(Direction.LEFT, Direction.BOTTOM);
                put(Direction.RIGHT, Direction.BOTTOM);
            }
        }),
        TYPE_2('━', new HashMap<Direction, Direction>() {
            {
                put(Direction.LEFT, Direction.RIGHT);
                put(Direction.RIGHT, Direction.LEFT);
            }
        }),
        TYPE_3('┃', new HashMap<Direction, Direction>() {
            {
                put(Direction.TOP, Direction.BOTTOM);
            }
        }),
        TYPE_4('╃', new HashMap<Direction, Direction>() {
            {
                put(Direction.TOP, Direction.LEFT);
                put(Direction.RIGHT, Direction.BOTTOM);
            }
        }),
        TYPE_5('╆', new HashMap<Direction, Direction>() {
            {
                put(Direction.TOP, Direction.RIGHT);
                put(Direction.LEFT, Direction.BOTTOM);
            }
        }),

        TYPE_6('┷', new HashMap<Direction, Direction>() {
            {
                put(Direction.LEFT, Direction.RIGHT);
                put(Direction.RIGHT, Direction.LEFT);
            }
        }),

        TYPE_7('┣', new HashMap<Direction, Direction>() {
            {
                put(Direction.TOP, Direction.BOTTOM);
                put(Direction.RIGHT, Direction.BOTTOM);
            }
        }),

        TYPE_8('┳', new HashMap<Direction, Direction>() {
            {
                put(Direction.LEFT, Direction.BOTTOM);
                put(Direction.RIGHT, Direction.BOTTOM);
            }
        }),

        TYPE_9('┫', new HashMap<Direction, Direction>() {
            {
                put(Direction.TOP, Direction.BOTTOM);

                put(Direction.LEFT, Direction.BOTTOM);
            }
        }),

        TYPE_10('╯', new HashMap<Direction, Direction>() {
            {
                put(Direction.TOP, Direction.LEFT);
            }
        }),

        TYPE_11('╰', new HashMap<Direction, Direction>() {
            {
                put(Direction.TOP, Direction.RIGHT);
            }
        }),

        TYPE_12('╭', new HashMap<Direction, Direction>() {
            {
                put(Direction.RIGHT, Direction.BOTTOM);
            }
        }),

        TYPE_13('╮', new HashMap<Direction, Direction>() {
            {
                put(Direction.LEFT, Direction.BOTTOM);
            }
        });

        private final Character representation;
        private final Map<Direction, Direction> tunnelList;

        RoomType(Character representation, Map<Direction, Direction> tunnelList) {
            this.representation = representation;
            this.tunnelList = tunnelList;
        }
    }

    enum Direction {
        TOP, RIGHT, BOTTOM, LEFT
    }
}
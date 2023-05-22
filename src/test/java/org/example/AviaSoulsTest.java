package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static java.util.Arrays.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AviaSoulsTest {

    @Test
    public void Test1() {
        Ticket ticket1 = new Ticket("A1", "B1", 300, 10, 12);
        Ticket ticket2 = new Ticket("A1", "B1", 200, 10, 12);
        Ticket ticket3 = new Ticket("A1", "B1", 100, 10, 12);

        AviaSouls tickets = new AviaSouls();
        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);

        Ticket[] expected = {ticket3, ticket2, ticket1};
        Arrays.sort(tickets.findAll());
        Ticket[] actual = tickets.findAll();
        assertArrayEquals(expected, actual);


    }

}

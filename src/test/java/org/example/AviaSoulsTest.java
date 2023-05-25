package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static java.util.Arrays.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AviaSoulsTest {

    Ticket ticket1 = new Ticket("A1", "B1", 300, 23, 6);
    Ticket ticket2 = new Ticket("A2", "B2", 500, 22, 4);
    Ticket ticket3 = new Ticket("A3", "B3", 100, 4, 12);
    Ticket ticket4 = new Ticket("A1", "B1", 300, 5, 14);
    Ticket ticket5 = new Ticket("A1", "C1", 200, 6, 16);
    Ticket ticket6 = new Ticket("A1", "B1", 100, 7, 15);
    AviaSouls tickets = new AviaSouls();
    TicketTimeComparator ticketTimeComparator = new TicketTimeComparator();

    @BeforeEach
    public void setup() {
        // AviaSouls tickets = new AviaSouls();
        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);
        tickets.add(ticket6);
    }

    @Test
    public void shouldSortPriceCompareTo() {

        Ticket[] expected = {ticket3, ticket6, ticket5, ticket1, ticket4, ticket2};
        Arrays.sort(tickets.findAll());
        Ticket[] actual = tickets.findAll();
        assertArrayEquals(expected, actual);


    }

    @Test
    public void shouldSearchSortPriceCompareTo() {

        Ticket[] expected = {ticket6, ticket1, ticket4};
        Ticket[] actual = tickets.search("A1", "B1");
        assertArrayEquals(expected, actual);


    }

    @Test
    public void shouldSearchOneTicketSortPriceCompareTo() {

        Ticket[] expected = {ticket5};
        Ticket[] actual = tickets.search("A1", "C1");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchNotTicketSortPriceCompareTo() {

        Ticket[] expected = {};
        Ticket[] actual = tickets.search("A1", "D1");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortFlyTimesComparator() {

        Arrays.sort(tickets.findAll(), ticketTimeComparator);
        Ticket[] expected = {ticket2, ticket1, ticket3, ticket6, ticket4, ticket5};
        Ticket[] actual = tickets.findAll();
        assertArrayEquals(expected, actual);


    }

    @Test
    public void shouldSearchSortFlyTimesComparator() {

        Ticket[] expected = {ticket1, ticket6, ticket4};
        Ticket[] actual = tickets.searchTime("A1", "B1");
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchOneTicketSortFlyTimesComparator() {

        Ticket[] expected = {ticket5};
        Ticket[] actual = tickets.searchTime("A1", "C1");
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchNotTicketSortFlyTimesComparator() {

        Ticket[] expected = {};
        Ticket[] actual = tickets.searchTime("A1", "D1");
        assertArrayEquals(expected, actual);

    }


}


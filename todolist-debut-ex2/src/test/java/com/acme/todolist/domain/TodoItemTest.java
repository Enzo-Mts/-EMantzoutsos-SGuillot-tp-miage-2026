package com.acme.todolist.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class TodoItemTest {

    @Test
    void itemAgeDe25h_doitAfficherLate() {
        TodoItem item = new TodoItem("1", Instant.now().minus(25, ChronoUnit.HOURS), "Faire les courses");
        assertThat(item.finalContent()).startsWith("[LATE!]");
    }

    @Test
    void itemAgeDe1h_nedoitPasAfficherLate() {
        TodoItem item = new TodoItem("2", Instant.now().minus(1, ChronoUnit.HOURS), "Faire les courses");
        assertThat(item.finalContent()).doesNotContain("[LATE!]");
    }
}
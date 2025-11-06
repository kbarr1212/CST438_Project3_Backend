package com.example.backend.repository_tests;

import com.example.backend.entity.Item;
import com.example.backend.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class ItemRepositoryTest {

    @Autowired
    private ItemRepository repo;

    @Test
    void save_and_findById() {
        Item i = new Item();
        i.setTitle("Vintage Jacket");
        i.setDescription("Denim, size M");
        Item saved = repo.save(i);

        Optional<Item> found = repo.findById(saved.getId());
        assertThat(found).isPresent();
        assertThat(found.get().getTitle()).isEqualTo("Vintage Jacket");
    }

    @Test
    void findAll_empty_then_one() {
        assertThat(repo.findAll()).isEmpty();

        Item i = new Item();
        i.setTitle("Lamp");
        i.setDescription("Retro");
        repo.save(i);

        assertThat(repo.findAll()).hasSize(1);
    }
}
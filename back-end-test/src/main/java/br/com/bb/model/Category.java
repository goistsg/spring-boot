package br.com.bb.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String name;

    //@OneToMany(mappedBy = "account")
    @OneToMany
    private List<Product> produtos;

    public Category() { super(); }

    public Category(Long id, String name) {
        super();
        this.id = id;
        this.name = name;
        this.produtos = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Product> produtos) {
        this.produtos = produtos;
    }

    @Override
    public String toString() {
        return String.format("Category [id=%s, name=%s]", id, name);
    }
}

package com.example.entitychildvalidation;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@CheckChildren
@Entity
public class Parent
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Child> children = new HashSet<>();

    public Parent()
    {
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Set<Child> getChildren()
    {
        return children;
    }

    public void setChildren(Set<Child> children)
    {
        this.children = children;
    }

    @Override
    public String toString()
    {
        return "Parent{" +
                "id=" + id +
                '}';
    }
}

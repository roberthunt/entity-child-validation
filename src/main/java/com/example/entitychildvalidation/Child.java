package com.example.entitychildvalidation;

import javax.persistence.*;

@Entity
public class Child
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Parent parent;

    public Child()
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

    public Parent getParent()
    {
        return parent;
    }

    public void setParent(Parent parent)
    {
        this.parent = parent;
    }

    @Override
    public String toString()
    {
        return "Child{" +
                "id=" + id +
                '}';
    }
}

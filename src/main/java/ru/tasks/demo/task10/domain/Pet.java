package ru.tasks.demo.task10.domain;

import java.util.Objects;

public class Pet {
    private final PetKind kind;
    private final String name;
    private int age;
    private boolean isAdopted;

    public Pet(PetKind kind, String name, int age) {
        this.kind = kind;
        this.name = name;
        this.age = age;
        this.isAdopted = false;
    }

    public PetKind getKind() {
        return kind;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isAdopted() {
        return isAdopted;
    }

    public void setAdopted(boolean adopted) {
        isAdopted = adopted;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Objects.equals(name, pet.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}

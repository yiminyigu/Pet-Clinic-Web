package guru.framework.sfgpetclinic.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;


@MappedSuperclass //do not create this entities
public class Person extends BaseEntity{
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    public Person(Long id, String firstName, String lastName) {
        super(id);
        this.firstName=firstName;
        this.lastName=lastName;
    }

    public Person() {
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

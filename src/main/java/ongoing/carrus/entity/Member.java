package ongoing.carrus.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity(name = "member_table")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberId;
    @Column(length = 20, nullable = false)
    private String firstName;
    @Column(length = 20, nullable = false)
    private String lasName;
    @Column(length = 50, nullable = false)
    private String street;
    @Column(length = 20, nullable = false)
    private String city;
    @Column(length = 20, nullable = false)
    private String zipcode;
    @Column(length = 12, nullable = false)
    private String phoneNumber;
    @Column(length = 30, nullable = false)
    private String email;
    @Column(nullable = false)
    private boolean approved;
    @Column(nullable = false)
    private int ranking;
    @CreationTimestamp
    private LocalDateTime dateCreated;
    @UpdateTimestamp
    private LocalDateTime dateUpdated;
    @Column(nullable = false)
    private  double balance;

    public Member() {
    }

    public Member(String firstName, String lasName, String street, String city, String zipcode, String phoneNumber, String email, boolean approved, int ranking, LocalDateTime dateCreated, LocalDateTime dateUpdated, double balance) {
        this.firstName = firstName;
        this.lasName = lasName;
        this.street = street;
        this.city = city;
        this.zipcode = zipcode;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.approved = approved;
        this.ranking = ranking;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.balance = balance;
    }

    public Member(String firstName, String lasName, String street, String city, String zipcode, String phoneNumber, String email, boolean approved, int ranking, double balance) {
        this.firstName = firstName;
        this.lasName = lasName;
        this.street = street;
        this.city = city;
        this.zipcode = zipcode;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.approved = approved;
        this.ranking = ranking;
        this.balance = balance;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLasName() {
        return lasName;
    }

    public void setLasName(String lasName) {
        this.lasName = lasName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(LocalDateTime dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Member)) return false;
        Member member = (Member) o;
        return getMemberId() == member.getMemberId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMemberId());
    }
}

package aws.training.clearing.model;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "card")
@Data
public class Card {

    @Id
    @Column
    String id;
    @Column
    String cardUserId;
    @Column
    String cardNumber;
    @Column
    Double balance;

}

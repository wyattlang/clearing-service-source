package aws.training.clearing.repo;

import aws.training.clearing.model.Card;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CardRepository extends CrudRepository<Card, UUID> {

    @Query("select u from Card u where u.cardNumber = ?1")
    Card findByCardNumber(String cardNumber);

    @Query("select u from Card u where u.cardUserId = ?1")
    List<Card> findAllByCardUserId(String cardUserId);

}

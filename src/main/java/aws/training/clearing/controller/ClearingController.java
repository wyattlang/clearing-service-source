package aws.training.clearing.controller;

import aws.training.clearing.model.Card;
import aws.training.clearing.repo.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ClearingController {

    @Autowired
    private CardRepository cardRepository;

    @PostMapping
    public Map<String, String> postForClearing(@RequestBody Map<String, String> request) {
        String cardNumber = request.get("cardNumber");

        Card cardFound = cardRepository.findByCardNumber(cardNumber);
        List<Card> cardsFoundByUserId = cardRepository.findAllByCardUserId(cardFound.getCardUserId());

        double sumOfAllBalances = cardsFoundByUserId.stream()
                .mapToDouble(Card::getBalance)
                .sum();

        if (sumOfAllBalances > 1000) {
            request.put("cleared", "false");
        } else {
            request.put("cleared", "true");
        }

        return request;
    }

}

import java.util.Arrays;
import java.util.List;

public enum AccountType {

    SAVINGS, CHECKING, BUSINESS;

    /**
     * Switch expressions are much easy to use and more readable
     */
    public List<CardType> getSuggestedCardTypes() {
        return switch (this) {
            case SAVINGS -> Arrays.asList(CardType.CREDIT, CardType.DEBIT);
            case CHECKING -> Arrays.asList(CardType.DEBIT, CardType.CREDIT, CardType.PREPAID);
            case BUSINESS -> List.of(CardType.CREDIT);
        };
    }
}
